package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.handler.EnumGuiID;
import com.alxnns1.mobhunter.inventory.InventoryPouch;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 16/11/2016.
 */
public class ItemMHPouch extends Item
{
    public ItemMHPouch(String itemName)
    {
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        setMaxStackSize(1);
    }

    /**
     * Gets the pouch's inventory from the ItemStack.
     */
    public static InventoryPouch getInventory(ItemStack stack)
    {
        return new InventoryPouch(stack, stack.getDisplayName(), true, 27);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(!worldIn.isRemote && !playerIn.isSneaking() && hand == EnumHand.MAIN_HAND)
            CommonUtil.openGui(playerIn, worldIn, EnumGuiID.POUCH);
            //playerIn.displayGUIChest(new PouchInventory(itemStackIn, "Field Pouch", true, 27));
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn);
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
