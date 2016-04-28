package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Mark on 28/04/2016.
 */
public class ItemMHResourceMeta extends Item
{
    private String[] metaNames;
    private int maxMeta;

    public ItemMHResourceMeta(String unlocName, String[] metaNames)
    {
        setUnlocalizedName(unlocName);
        this.metaNames = metaNames;
        maxMeta = metaNames.length > 16 ? 16 : metaNames.length;
        setCreativeTab(MobHunter.MH_TAB);
        setHasSubtypes(true);
        setMaxDamage(0);
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        int i = stack.getMetadata();
        return getUnlocalizedName() + "." + metaNames[i];
    }

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        for (int i = 0; i < maxMeta; ++i)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }

    public int getMaxMeta()
    {
        return maxMeta;
    }
}
