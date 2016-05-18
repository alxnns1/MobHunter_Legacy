package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHSword extends ItemSword {
    public ItemMHSword(ToolMaterial material, String itemName) {
        super(material.setRepairItem(new ItemStack(MHItems.itemWhetstone)));
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        Common.addTooltip(stack, tooltip);
    }


}
