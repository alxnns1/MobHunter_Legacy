package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * Created by Alex on 20/04/2016.
 */
public class ItemMHResource extends Item {
    public ItemMHResource(String itemName, boolean puInTab){
        if(puInTab){setCreativeTab(MobHunter.MH_TAB);}
        setUnlocalizedName(itemName);
    }
}
