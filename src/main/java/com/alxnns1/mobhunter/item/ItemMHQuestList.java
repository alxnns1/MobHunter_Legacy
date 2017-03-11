package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.handler.EnumGuiID;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.CommonUtil;
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
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(worldIn.isRemote)
            CommonUtil.openGui(playerIn, worldIn, EnumGuiID.QUEST_LIST);
        return new ActionResult<ItemStack>(EnumActionResult.PASS, itemStackIn);
    }
}
