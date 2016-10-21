package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.util.CommonUtil;
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
public class ItemMHResource extends Item implements ISubTypes<ItemMHResource>
{
    protected String[] subNames;
    private boolean addInfo;

    public ItemMHResource(String itemName, String... subNames)
    {
        this(itemName, true, subNames);
    }

    public ItemMHResource(String itemName, boolean putInTab, String... subNames)
    {
        if(putInTab)
            setCreativeTab(MobHunter.MH_TAB);
        addInfo = putInTab;
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        setHasSubtypes(subNames != null && subNames.length > 0);
        this.subNames = hasSubtypes ? subNames : null;
    }

    @Override
    public String[] getSubNames()
    {
        return subNames;
    }

    @Override
    public ItemMHResource addToMetaRef(MetaRef.EnumItemType itemType)
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
        if(addInfo)
            CommonUtil.addTooltip(stack, tooltip);
    }
}
