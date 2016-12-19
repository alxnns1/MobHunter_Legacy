package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entity.spits.EntitySpitPoison;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Mark on 07/12/2016.
 */
public class ItemMHDebug extends Item
{
    public ItemMHDebug()
    {
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(Names.Items.DEBUG);
        setRegistryName(Names.Items.DEBUG);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(!worldIn.isRemote)
        {
            EntitySpitPoison entity = new EntitySpitPoison(worldIn, playerIn, "debugSpit", 2f, 1f, new PotionEffect(MobEffects.GLOWING, 40));
            entity.setPosition(playerIn.posX, playerIn.posY + 1.5d, playerIn.posZ);
            worldIn.spawnEntity(entity);
        }
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }
}
