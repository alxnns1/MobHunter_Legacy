package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.util.Common;
import com.alxnns1.mobhunter.util.LogHelper;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
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
    private EnumSharpness maxSharpness = EnumSharpness.RED;
    private int[] damageLevels;
    private float baseAttackDamage = 4f;

    public ItemMHSword(ToolMaterial material, String itemName, EnumSharpness maxSharp, int[] sharpnessDamageLevels)
    {
        this(material, itemName);
        maxSharpness = maxSharp;
        damageLevels = sharpnessDamageLevels;
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
     * Gets the current sharpness level from the ItemStack's metadata
     */
    public EnumSharpness getSharpness(ItemStack stack)
    {
        if(damageLevels != null) {
            for (int i = 0; i < damageLevels.length; i++) {
                if ((stack.getMaxDamage() - stack.getItemDamage()) < damageLevels[i]) {
                    LogHelper.info(stack.getDisplayName() + "'s sharpness is less than it's max.");
                    return EnumSharpness.getById(i);
                }
            }
            LogHelper.info(stack.getDisplayName() + "'s sharpness is it's max.");
            return maxSharpness;
        }
        LogHelper.info(stack.getDisplayName() + "'s sharpness is undefined.");
        return EnumSharpness.RED;
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
            stack.damageItem(damageAmount, attacker);
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
