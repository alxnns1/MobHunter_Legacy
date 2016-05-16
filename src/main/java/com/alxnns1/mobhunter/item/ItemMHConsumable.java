package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.Collection;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHConsumable extends ItemFood
{
    protected final int effectDuration = 100;
    private int eatDuration = this.itemUseDuration;
    public static int EAT_DURATION_SHORT = 8;

    public ItemMHConsumable(String itemName)
    {
        this(0, 0, false, itemName);
    }

    public ItemMHConsumable(String itemName, boolean alwaysEdible, int eatingDuration)
    {
        this(0, 0, false, itemName);
        if(alwaysEdible) setAlwaysEdible();
        eatDuration = eatingDuration;
    }

    public ItemMHConsumable(int amount, float saturation, boolean isWolfFood, String itemName)
    {
        super(amount, saturation, isWolfFood);
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return eatDuration;
    }

    public void setMaxItemUseDuration(int duration)
    {
        eatDuration = duration;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        if(itemStackIn.getItem().equals(MHItems.itemHerb))
        {
            if(playerIn.shouldHeal())
                super.onItemRightClick(itemStackIn, worldIn, playerIn);
        }
        else
            super.onItemRightClick(itemStackIn, worldIn, playerIn);

        return itemStackIn;
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        //Only want to run on the server
        if(worldIn.isRemote) return;

        Item item = stack.getItem();
        if(item.equals(MHItems.itemHerb))
            player.heal(2f);
        else if(item.equals(MHItems.itemNulberry) && player.getActivePotionEffects().size() > 0)
        {
            Collection<PotionEffect> effects = player.getActivePotionEffects();
            int rand = itemRand.nextInt(effects.size());
            int i = 0;
            for(PotionEffect effect : effects)
            {
                if(i == rand)
                {
                    player.removePotionEffect(effect.getPotionID());
                    break;
                }
                i++;
            }
        }
        else if(itemRand.nextFloat() < 0.5f)
        {
            if(item.equals(MHItems.itemAntidoteHerb) && player.isPotionActive(Potion.poison))
                player.removePotionEffect(Potion.poison.getId());
            else if(item.equals(MHItems.itemToadstool))
                player.addPotionEffect(new PotionEffect(Potion.poison.getId(), effectDuration));
            else if(item.equals(MHItems.itemExciteshroom))
                player.getFoodStats().addStats(2,0);
            else if(item.equals(MHItems.itemMopeshroom))
                player.getFoodStats().addStats(-2,0);
            else if(item.equals(MHItems.itemMightSeed))
                player.addPotionEffect(new PotionEffect(Potion.damageBoost.getId(), effectDuration));
            else if(item.equals(MHItems.itemAdamantSeed))
                player.addPotionEffect(new PotionEffect(Potion.resistance.getId(), effectDuration));
            else if(item.equals(MHItems.itemFireHerb))
                player.setFire(effectDuration / 20);
            else if(item.equals(MHItems.itemBomberry))
            {
                double rotation = Math.toRadians(player.getRotationYawHead());
                double xLook = -Math.sin(rotation);
                double zLook = Math.cos(rotation);
                worldIn.createExplosion(null, player.posX + xLook, player.posY, player.posZ + zLook, 0.5f, true);
            }
            else if(item.equals(MHItems.itemNeedleberry))
                player.attackEntityFrom(DamageSource.generic, 2);
            else if(item.equals(MHItems.itemBitterbug))
                player.addPotionEffect(new PotionEffect(Potion.confusion.getId(), (int) Math.round(effectDuration * 1.5)));
            else if(item.equals(MHItems.itemNitroshroom))
                player.addPotionEffect(new PotionEffect(Potion.moveSpeed.getId(), effectDuration));
        }
    }
}
