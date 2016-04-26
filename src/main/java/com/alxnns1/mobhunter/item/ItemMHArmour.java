package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemArmor;

/**
 * Created by Alex on 20/04/2016.
 */
public class ItemMHArmour extends ItemArmor {
    public ItemMHArmour(ArmorMaterial material, int renderIndex, int armourType, String itemName){
        super(material, renderIndex, armourType);
        setUnlocalizedName(itemName);
        setCreativeTab(MobHunter.MH_TAB);
    }
}
