package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.reference.MetaRef;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Mark on 14/05/2016.
 */
public class ItemMHDrink extends ItemMHConsumable
{
    public ItemMHDrink(String itemName, String... subNames)
    {
        super(0, 0, false, itemName, subNames);
        setMaxStackSize(1);
    }

    /**
     * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
     * the Item before the action is complete.
     */
    public ItemStack onItemUseFinish(ItemStack stack, World world, EntityLivingBase entityLiving)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entityLiving;
            if (!world.isRemote)
            {
                switch(stack.getMetadata())
                {
                    case 0: //Potion
                        player.heal(5f);
                        break;
                    case 1: //Mega Potion
                        player.heal(10f);
                        break;
                    case 2: //Antidote
                        if(player.isPotionActive(MobEffects.POISON)) player.removePotionEffect(MobEffects.POISON);
                        break;
                    case 3: //Immunizer
                        player.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 200));
                        break;
                    case 4: //Dash Juice
                        player.getFoodStats().setFoodSaturationLevel(Math.min(player.getFoodStats().getSaturationLevel() + 10f, 40f));
                        break;
                    case 5: //Mega Dash Juice
                        player.getFoodStats().setFoodSaturationLevel(Math.min(player.getFoodStats().getSaturationLevel() + 20f, 40f));
                        break;
                    case 6: //Demondrug
                        player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 200, 1));
                        break;
                    case 7: //Mega Demondrug
                        player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 400, 1));
                        break;
                    case 8: //Armourskin
                        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 200, 1));
                        break;
                    case 9: //Mega Armourskin
                        player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 400, 1));
                        break;
                }
            }

            if (!player.capabilities.isCreativeMode) {
                --stack.stackSize;
                if (stack.stackSize <= 0)
                    return new ItemStack(Items.GLASS_BOTTLE);
                player.inventory.addItemStackToInventory(new ItemStack(Items.GLASS_BOTTLE));
            }
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
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        playerIn.setActiveHand(hand);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }

    @Override
    public ItemMHDrink addToMetaRef(MetaRef.EnumItemType itemType)
    {
        return (ItemMHDrink) super.addToMetaRef(itemType);
    }
}
