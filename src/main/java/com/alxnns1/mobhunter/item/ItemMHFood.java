package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHFood extends ItemFood{
    public ItemMHFood(int amount, float saturation, boolean isWolfFood, String itemName) {
        super(amount, saturation, isWolfFood);
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
    }
}
