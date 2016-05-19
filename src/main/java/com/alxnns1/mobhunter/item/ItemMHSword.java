package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.util.Common;
import com.alxnns1.mobhunter.util.LogHelper;
import com.alxnns1.mobhunter.util.NBTHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHSword extends ItemSword
{
    protected final String KEY_SHARPNESS_LEVEL = "sharpnessLevel";
    protected final String KEY_SHARPNESS_DAMAGE = "sharpnessDamage";

    private EnumSharpness maxSharpness = EnumSharpness.RED;
    private int[] damageLevels;
    private int maxTotalDamage = 0;
    private float baseAttackDamage = 4f;

    public ItemMHSword(ToolMaterial material, String itemName, EnumSharpness maxSharpness, int[] sharpnessDamageLevels)
    {
        this(material, itemName);
        this.maxSharpness = maxSharpness;
        damageLevels = sharpnessDamageLevels;
        for(int d : damageLevels)
            maxTotalDamage += d;
        if(sharpnessDamageLevels.length - 1 != maxSharpness.getId())
            LogHelper.warn("Sword " + getUnlocalizedName() + " has " + sharpnessDamageLevels.length + " sharpness damages and a max sharpness id of " + maxSharpness.getId() + "!");
    }

    //This constructor will be removed once weapons are converted to using sharpness
    public ItemMHSword(ToolMaterial material, String itemName)
    {
        super(material.setRepairItem(new ItemStack(MHItems.itemWhetstone)));
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
        baseAttackDamage = 4.0f + material.getDamageVsEntity(); //Same as in ItemSword
    }

    /**
     * Gets the current sharpness level from the ItemStack's NBT data
     */
    public EnumSharpness getSharpness(ItemStack stack)
    {
        EnumSharpness sharpness = this.maxSharpness;
        if(NBTHelper.hasTag(stack, KEY_SHARPNESS_LEVEL))
            sharpness = EnumSharpness.getById(NBTHelper.getInt(stack, KEY_SHARPNESS_LEVEL));
        return sharpness;
    }

    /**
     * Gets the current sharpness damage from the ItemStack's NBT data
     */
    public int getSharpnessDamage(ItemStack stack, EnumSharpness currentSharpness)
    {
        int damage = damageLevels[currentSharpness.getId()];
        if(NBTHelper.hasTag(stack, KEY_SHARPNESS_DAMAGE))
            damage = NBTHelper.getInt(stack, KEY_SHARPNESS_DAMAGE);
        return damage;
    }

    /**
     * Decreases the sharpness on the sword.
     * @param stack The sword ItemStack
     * @param amount The amount to reduce sharpness by
     * @param entity The entity holding the sword
     */
    public void decreaseSharpness(ItemStack stack, int amount, EntityLivingBase entity)
    {
        EnumSharpness currentSharpness = getSharpness(stack);
        int sharpnessDamage = getSharpnessDamage(stack, currentSharpness);
        boolean sharpnessChanged = false;

        sharpnessDamage -= amount;
        if(sharpnessDamage <= 0)
            sharpnessChanged = true;

        while(sharpnessDamage <= 0)
        {
            if(currentSharpness.getId() == 0)
            {
                //Destroy sword
                //This uses code from ItemStack.damageItem()
                entity.renderBrokenItemStack(stack);
                --stack.stackSize;
                if (entity instanceof EntityPlayer)
                {
                    EntityPlayer entityplayer = (EntityPlayer)entity;
                    entityplayer.triggerAchievement(StatList.objectBreakStats[Item.getIdFromItem(stack.getItem())]);
                }
                if (stack.stackSize < 0)
                {
                    stack.stackSize = 0;
                }
                break;
            }
            currentSharpness = currentSharpness.getPrevSharpness();
            sharpnessDamage += damageLevels[currentSharpness.getId()];
        }

        //Save new values
        if(sharpnessChanged)
            NBTHelper.setInteger(stack, KEY_SHARPNESS_LEVEL, currentSharpness.getId());
        NBTHelper.setInteger(stack, KEY_SHARPNESS_DAMAGE, sharpnessDamage);
        LogHelper.info("Sharpness Damage: " + sharpnessDamage);
    }

    /**
     * Tries to increase the sharpness of the weapon by 1. If no change, then returns false.
     * @return Whether the increase was successful
     */
    public boolean increaseSharpness(ItemStack stack)
    {
        return increaseSharpness(stack, 1);
    }

    /**
     * Tries to increase the sharpness of the weapon. If no change, then returns false.
     * @param amount Amount to try increase sharpness by
     * @return Whether the increase was successful
     */
    public boolean increaseSharpness(ItemStack stack, int amount)
    {
        EnumSharpness currentSharpness = getSharpness(stack);
        int sharpnessDamage = getSharpnessDamage(stack, currentSharpness);
        int currentDamageMax = damageLevels[currentSharpness.getId()];

        if(EnumSharpness.isSame(currentSharpness, maxSharpness))
        {
            if(sharpnessDamage == currentDamageMax)
                //If sharpness and damage is at max, then no change
                return false;
            else
            {
                //If damage isn't at max, then set it back to max
                NBTHelper.setInteger(stack, KEY_SHARPNESS_DAMAGE, currentDamageMax);
                return true;
            }
        }

        EnumSharpness next = currentSharpness.getNextSharpness(amount);

        if(next.getId() > maxSharpness.getId())
            //If new sharpness is greater than max for weapon, then just set to max
            currentSharpness = maxSharpness;
        else
            //If not greater than max, then just set to new sharpness
            currentSharpness = next;
        //Set current sharpness damage to max for current sharpness level
        NBTHelper.setInteger(stack, KEY_SHARPNESS_LEVEL, currentSharpness.getId());
        NBTHelper.setInteger(stack, KEY_SHARPNESS_DAMAGE, damageLevels[currentSharpness.getId()]);

        return true;
    }

    /**
     * Calculates the actual damage of this weapon using the sharpness
     */
    public float getActualAttackDamage(ItemStack stack)
    {
        EnumSharpness currentSharpness = getSharpness(stack);
        return baseAttackDamage * currentSharpness.getDamageMult();
    }

    public Multimap<String, AttributeModifier> getAttributeModifiers(ItemStack stack)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", (double)getActualAttackDamage(stack), 0));
        return multimap;
    }

    /**
     * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
     * the damage on the stack.
     */
    public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
    {
        if (!(attacker instanceof EntityPlayer) || !((EntityPlayer)attacker).capabilities.isCreativeMode)
        {
            //Reduces sharpness damage on every hit depending on target's armour
            int damageAmount = Math.max((int) Math.ceil((float) target.getTotalArmorValue() / 4f), 1);
            decreaseSharpness(stack, damageAmount, attacker);
        }
        return true;
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        EnumSharpness currentSharpness = getSharpness(stack);
        if(currentSharpness != null)
        {
            tooltip.add("Sharpness: " + currentSharpness.getChatColour() + StatCollector.translateToLocal(currentSharpness.getUnlocalizedName()));
            tooltip.add("Max Sharpness: " + maxSharpness.getChatColour() + StatCollector.translateToLocal(maxSharpness.getUnlocalizedName()));
        }

        Common.addTooltip(stack, tooltip);
    }

    /**
     * Determines if the durability bar should be rendered for this item.
     * Defaults to vanilla stack.isDamaged behavior.
     * But modders can use this for any data they wish.
     *
     * @param stack The current Item Stack
     * @return True if it should render the 'durability' bar.
     */
    public boolean showDurabilityBar(ItemStack stack)
    {
        return maxSharpness.getId() > 0;
    }

    /**
     * Queries the percentage of the 'Durability' bar that should be drawn.
     *
     * @param stack The current ItemStack
     * @return 1.0 for 100% 0 for 0%
     */
    public double getDurabilityForDisplay(ItemStack stack)
    {
        EnumSharpness sharpness = getSharpness(stack);
        int damage = getSharpnessDamage(stack, sharpness);
        for(int i = 0; i < sharpness.getId(); i++)
            damage += damageLevels[i];

        return (double) (maxTotalDamage - damage) / (double) maxTotalDamage;
    }

    public boolean onBlockDestroyed(ItemStack stack, World worldIn, Block blockIn, BlockPos pos, EntityLivingBase playerIn)
    {
        decreaseSharpness(stack, 2, playerIn);
        return true;
    }

    /**
     * Returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
}
