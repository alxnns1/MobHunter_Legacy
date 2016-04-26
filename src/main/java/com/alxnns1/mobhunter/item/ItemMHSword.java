package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.item.ItemSword;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHSword extends ItemSword {
    public ItemMHSword(ToolMaterial material, String itemName) {
        super(material);
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(itemName);
    }
}
