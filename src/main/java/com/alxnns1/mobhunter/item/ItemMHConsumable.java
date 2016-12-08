package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.potion.PotionEffectParalyse;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
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
public class ItemMHConsumable extends ItemFood implements ISubTypes<ItemMHConsumable>
{
    protected final int effectDuration = 200;
    private int eatDuration = this.itemUseDuration;
    public static int EAT_DURATION_SHORT = 8;
    protected String[] subNames;

    public ItemMHConsumable(String itemName, String... subNames)
    {
        this(true, EAT_DURATION_SHORT, itemName, subNames);
    }

    public ItemMHConsumable(boolean alwaysEdible, int eatingDuration, String itemName, String... subNames)
    {
        this(0, 0, false, itemName, subNames);
        if(alwaysEdible) setAlwaysEdible();
        eatDuration = eatingDuration;
    }

    public ItemMHConsumable(int amount, float saturation, boolean isWolfFood, String itemName, String... subNames)
    {
        super(amount, saturation, isWolfFood);
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        setHasSubtypes(subNames != null && subNames.length > 0);
        this.subNames = hasSubtypes ? subNames : null;
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
        if(itemStackIn.isItemEqual(new ItemStack(MHItems.itemConsumable, 1, 0)))
        {
            if(playerIn.shouldHeal())
                super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
        }
        else
            super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        //Only want to run on the server
        if(worldIn.isRemote) return;

        String[] itemNameSplit = stack.getItem().getRegistryName().getResourcePath().split(".");
        String itemName = itemNameSplit[itemNameSplit.length-1];

        if(itemName.equals(Names.Items.HERB))
            player.heal(2f);
        else if(itemName.equals(Names.Items.NULBERRY) && player.getActivePotionEffects().size() > 0)
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
            if(itemName.equals(Names.Items.ANTIDOTE_HERB))
            {
                if(player.isPotionActive(MobEffects.POISON))
                    player.removePotionEffect(MobEffects.POISON);
            }
            else if(itemName.equals(Names.Items.FIRE_HERB))
                player.setFire(effectDuration / 20);
            else if(itemName.equals(Names.Items.NITROSHROOM))
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, effectDuration));
            else if(itemName.equals(Names.Items.PARASHROOM))
                player.addPotionEffect(new PotionEffectParalyse(effectDuration));
            else if(itemName.equals(Names.Items.TOADSTOOL))
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, effectDuration));
            else if(itemName.equals(Names.Items.EXCITESHROOM))
                player.getFoodStats().addStats(2,0);
            else if(itemName.equals(Names.Items.MOPESHROOM))
                player.getFoodStats().addStats(-2,0);
            else if(itemName.equals(Names.Items.MIGHT_SEED))
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, effectDuration));
            else if(itemName.equals(Names.Items.ADAMANT_SEED))
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, effectDuration));
            else if(itemName.equals(Names.Items.NEEDLEBERRY))
                player.attackEntityFrom(DamageSource.generic, 2);
            else if(itemName.equals(Names.Items.BOMBERRY))
            {
                double rotation = Math.toRadians(player.getRotationYawHead());
                double xLook = -Math.sin(rotation);
                double zLook = Math.cos(rotation);
                worldIn.createExplosion(null, player.posX + xLook, player.posY, player.posZ + zLook, 0.5f, true);
            }
            else if(itemName.equals(Names.Items.BITTERBUG))
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, (int) Math.round(effectDuration * 1.5)));
        }
    }

    @Override
    public String[] getSubNames()
    {
        return subNames;
    }

    @Override
    public ItemMHConsumable addToMetaRef(MetaRef.EnumItemType itemType)
    {
        MetaRef.addMetaTo(itemType, subNames);
        return this;
    }

    /**
     * Returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        if(hasSubtypes)
            for(int i = 0; i < getSubNames().length; i++)
                subItems.add(new ItemStack(itemIn, 1, i));
        else
            subItems.add(new ItemStack(itemIn));
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        if(hasSubtypes)
            return super.getUnlocalizedName(stack) + "." + getSubNames()[stack.getMetadata()];
        return super.getUnlocalizedName(stack);
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        CommonUtil.addTooltip(stack, tooltip);
    }
}
