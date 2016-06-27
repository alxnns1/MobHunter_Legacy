package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.item.ItemPickaxe;
import net.minecraftforge.common.util.EnumHelper;

/**
 * Created by Alex on 26/06/2016.
 */
public class ItemMHPickaxe extends ItemPickaxe
{
    public ItemMHPickaxe(String name, int harvestLevel, int maxUses, float efficiency, float damage)
    {
        super(EnumHelper.addToolMaterial("Pickaxe" + name, harvestLevel, maxUses, efficiency, damage, 15));
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName("item" + name + "Pickaxe");
        setRegistryName("item" + name + "Pickaxe");
    }
}
