package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Mark on 14/05/2016.
 */
public class ItemMHDrink extends ItemMHConsumable
{
    public ItemMHDrink(String itemName)
    {
        super(itemName);
        setMaxStackSize(1);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityPlayer player)
    {
        if (!player.capabilities.isCreativeMode)
            --stack.stackSize;
        if (!world.isRemote)
        {
            Item item = stack.getItem();
            if(item.equals(MHItems.itemPotion))
                player.heal(5f);
            else if(item.equals(MHItems.itemMegaPotion))
                player.heal(10f);
            //else if(item.equals(MHItems.itemNutrients))
            //else if(item.equals(MHItems.itemMegaNutrients))
            else if(item.equals(MHItems.itemAntidote) && player.isPotionActive(Potion.poison))
                player.removePotionEffect(Potion.poison.getId());
            else if(item.equals(MHItems.itemImmunizer))
                player.addPotionEffect(new PotionEffect(Potion.regeneration.getId(), effectDuration));
            else if(item.equals(MHItems.itemDashJuice))
                player.getFoodStats().addStats(10,0);
            else if(item.equals(MHItems.itemMegaDashJuice))
                player.getFoodStats().addStats(20,0);
            else if(item.equals(MHItems.itemDemondrug))
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), effectDuration, 1));
            else if(item.equals(MHItems.itemMegaDemondrug))
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), effectDuration * 2, 1));
            else if(item.equals(MHItems.itemArmorskin))
                player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), effectDuration, 1));
            else if(item.equals(MHItems.itemMegaArmorskin))
                player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), effectDuration * 2, 1));
        }
        return stack;
    }

    /**
     * Returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        playerIn.setItemInUse(itemStackIn, getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }
}
