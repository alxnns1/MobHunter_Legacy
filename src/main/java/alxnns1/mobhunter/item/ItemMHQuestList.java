package alxnns1.mobhunter.item;

import alxnns1.mobhunter.handler.EnumGuiID;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemMHQuestList extends ItemMHBasic
{
	public ItemMHQuestList()
	{
		super(Names.Items.QUEST_LIST);
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		if(worldIn.isRemote)
			CommonUtil.openGui(playerIn, worldIn, EnumGuiID.QUEST_LIST);
		return new ActionResult<>(EnumActionResult.PASS, playerIn.getHeldItem(hand));
	}
}
