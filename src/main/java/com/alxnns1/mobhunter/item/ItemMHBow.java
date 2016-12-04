package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.item.Item;

/**
 * Created by Mark on 04/12/2016.
 */
public class ItemMHBow extends Item
{
    protected final EnumBowCharge chargeType;
    protected final byte chargeLevel;

    public ItemMHBow(String itemName, EnumBowCharge chargeType, int chargeLevel)
    {
        setMaxStackSize(1);
        setCreativeTab(MobHunter.MHWEAPON_TAB);
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        this.chargeType = chargeType;
        this.chargeLevel = (byte) chargeLevel;

    }
}
