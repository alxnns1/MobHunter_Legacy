package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 20/04/2016.
 */
public class ItemMHResource extends Item
{
    private boolean addInfo;

    public ItemMHResource(String itemName)
    {
        this(itemName, true);
    }

    public ItemMHResource(String itemName, boolean putInTab)
    {
        if(putInTab)setCreativeTab(MobHunter.MH_TAB);
        addInfo = putInTab;
        setUnlocalizedName(itemName);
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        if(addInfo)
            Common.addTooltip(stack, tooltip);
    }
}
