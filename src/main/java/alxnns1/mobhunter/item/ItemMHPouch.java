package alxnns1.mobhunter.item;

import alxnns1.mobhunter.handler.EnumGuiID;
import alxnns1.mobhunter.inventory.InventoryPouch;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.util.ClientUtil;
import alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Alex on 16/11/2016.
 */
public class ItemMHPouch extends ItemMHBasic
{
	public ItemMHPouch()
	{
		super(Names.Items.FIELD_POUCH);
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
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if(!worldIn.isRemote && !playerIn.isSneaking() && hand == EnumHand.MAIN_HAND)
			CommonUtil.openGui(playerIn, worldIn, EnumGuiID.POUCH);
		return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(hand));
	}

	/**
	 * Allows items to add custom lines of information to the mouseover description
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		ClientUtil.addTooltip(stack, tooltip);
	}
}
