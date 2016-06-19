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
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHSword extends ItemSword
{
    private final EnumSharpness maxSharpness;
    private final int[] damageLevels;
    private final String damageLevelsString;
    private float baseAttackDamage = 4f;
    private int nextSharpen = 200;

    public ItemMHSword(String itemName, float damage, int[] sharpnessDamageLevels)
    {
        super(EnumHelper.addToolMaterial(itemName + "Mat", 0, sharpnessDamageLevels[sharpnessDamageLevels.length - 1], 0, damage, 0).setRepairItem(new ItemStack(MHItems.itemWhetstone)));
        maxSharpness = EnumSharpness.getById(sharpnessDamageLevels.length - 1);
        if(maxSharpness == null) LogHelper.warn("Sword " + getUnlocalizedName() + " has a null sharpness! Something must be wrong!");
        damageLevels = sharpnessDamageLevels;
        String levels = "";
        for(int i = 0; i < damageLevels.length; i++)
        {
            levels += damageLevels[i];
            if(i < damageLevels.length - 1)
                levels += " <- ";
        }
        damageLevelsString = levels;
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        baseAttackDamage = 4f + getDamageVsEntity();
    }

    /**
     * Gets the current sharpness level from the ItemStack's metadata
     */
    public EnumSharpness getSharpness(ItemStack stack)
    {
        if(damageLevels != null) {
            for (int i = 0; i < damageLevels.length; i++) {
                if ((stack.getMaxDamage() - stack.getItemDamage()) < damageLevels[i]) {
                    return EnumSharpness.getById(i);
                }
            }
            return maxSharpness;
        }
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

    public void repairSharpness(ItemStack stack, int amount){
        if(stack.getItemDamage()<amount){
            stack.setItemDamage(0);
        }else{
            stack.setItemDamage(stack.getItemDamage()-amount);
        }
    }

    public Multimap<String, AttributeModifier> getAttributeModifiers(ItemStack stack)
    {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getAttributeUnlocalizedName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double)getActualAttackDamage(stack), 0));
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
            tooltip.add("Sharpness: " + currentSharpness.getChatColour() + new TextComponentTranslation(currentSharpness.getUnlocalizedName()).getUnformattedText());
            tooltip.add("Max Sharpness: " + maxSharpness.getChatColour() + new TextComponentTranslation(maxSharpness.getUnlocalizedName()).getUnformattedText());
            if(playerIn.isCreative())
                tooltip.add(damageLevelsString);
        }

        Common.addTooltip(stack, tooltip);
    }

    /**
     * Returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.EAT;
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 200;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(playerIn.isSneaking() && itemStackIn.getItemDamage()>0) {
            if(playerIn.inventory.hasItemStack(new ItemStack(MHItems.itemWhetstone))) {
                nextSharpen = 200;
                playerIn.setActiveHand(hand);
                return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
            }
        }
        return new ActionResult(EnumActionResult.FAIL, itemStackIn);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer) {
            repairSharpness(stack, nextSharpen);
            if (nextSharpen == 200) {
                ((EntityPlayer) entityLiving).inventory.decrStackSize(((EntityPlayer) entityLiving).inventory.getSlotFor(new ItemStack(MHItems.itemWhetstone)),1);
            } else if (nextSharpen == 100) {
                //playerIn.inventory.consumeInventoryItem(MHItems.itemMiniWhetstone);
            }
        }
        return stack;
    }
}
