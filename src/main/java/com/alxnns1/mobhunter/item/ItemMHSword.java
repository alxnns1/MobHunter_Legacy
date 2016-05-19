package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.util.Common;
import com.alxnns1.mobhunter.util.LogHelper;
import com.alxnns1.mobhunter.util.NBTHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
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
    private float baseAttackDamage = 4f;

    public ItemMHSword(ToolMaterial material, String itemName, EnumSharpness maxSharpness, int[] sharpnessDamageLevels)
    {
        this(material, itemName);
        this.maxSharpness = maxSharpness;
        this.damageLevels = sharpnessDamageLevels;
        //this.sharpnessDamage = sharpnessDamageLevels[sharpnessDamageLevels.length - 1];
        this.baseAttackDamage = 4.0f + material.getDamageVsEntity(); //Same as in ItemSword
        if(sharpnessDamageLevels.length - 1 != maxSharpness.getId())
            LogHelper.warn("Sword " + getUnlocalizedName() + " has " + sharpnessDamageLevels.length + " sharpness damages and a max sharpness id of " + maxSharpness.getId() + "!");
    }

    //This constructor will be removed once weapons are converted to using sharpness
    public ItemMHSword(ToolMaterial material, String itemName)
    {
        super(material.setRepairItem(new ItemStack(MHItems.itemWhetstone)));
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
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
     * Calculates the actual damage of this weapon using the sharpness
     */
    public float getActualAttackDamage(ItemStack stack)
    {
        EnumSharpness currentSharpness = getSharpness(stack);
        LogHelper.info("Damage: " + baseAttackDamage * currentSharpness.getDamageMult());
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
        EnumSharpness currentSharpness = getSharpness(stack);
        int sharpnessDamage = getSharpnessDamage(stack, currentSharpness);

        //Reduces sharpness damage on every hit depending on target's armour
        sharpnessDamage -= Math.max((int) Math.ceil((float) target.getTotalArmorValue() / 4f), 1);
        //If damage reaches 0, then reduce sharpness level
        if(sharpnessDamage <= 0)
        {
            EnumSharpness prev = currentSharpness.getPrevSharpness();
            if(EnumSharpness.isSame(currentSharpness, prev))
                sharpnessDamage = 0;
            else
            {
                NBTHelper.setInteger(stack, KEY_SHARPNESS_LEVEL, prev.getId());
                sharpnessDamage = damageLevels[currentSharpness.getId()];
            }
        }

        NBTHelper.setInteger(stack, KEY_SHARPNESS_DAMAGE, sharpnessDamage);

        LogHelper.info("Sharpness Damage: " + sharpnessDamage);

        return super.hitEntity(stack, target, attacker);
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


}
