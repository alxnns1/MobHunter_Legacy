package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.potion.PotionEffectParalyse;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.List;

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
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(itemStackIn.getItem().equals(MHItems.itemHerb))
        {
            if(playerIn.shouldHeal())
                super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
        }
        else
            super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);

        return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
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
                    player.removePotionEffect(effect.getPotion());
                    break;
                }
                i++;
            }
        }
        else if(itemRand.nextFloat() < 0.5f)
        {
            if(item.equals(MHItems.itemAntidoteHerb) && player.isPotionActive(MobEffects.POISON))
                player.removePotionEffect(MobEffects.POISON);
            else if(item.equals(MHItems.itemToadstool))
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, effectDuration));
            else if(item.equals(MHItems.itemParashroom))
                player.addPotionEffect(new PotionEffectParalyse(effectDuration));
            else if(item.equals(MHItems.itemExciteshroom))
                player.getFoodStats().addStats(2,0);
            else if(item.equals(MHItems.itemMopeshroom))
                player.getFoodStats().addStats(-2,0);
            else if(item.equals(MHItems.itemMightSeed))
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, effectDuration));
            else if(item.equals(MHItems.itemAdamantSeed))
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, effectDuration));
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
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) Math.round(effectDuration * 1.5)));
            else if(item.equals(MHItems.itemNitroshroom))
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, effectDuration));
        }
    }

    /*
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        if(entity instanceof EntityLivingBase)
            ((EntityLivingBase)entity).addPotionEffect(new PotionEffectParalyse(200));
        return super.onLeftClickEntity(stack, player, entity);
    }*/

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        Common.addTooltip(stack, tooltip);
    }
}
