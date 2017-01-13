package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.item.Item;

/**
 * Created by Mark on 12/01/2017.
 */
public class ItemMHBasic extends Item
{
    public ItemMHBasic(String name)
    {
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(name);
        setRegistryName(name);
    }
}
