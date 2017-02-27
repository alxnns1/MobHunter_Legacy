package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * Created by Alex on 20/04/2016.
 */
public class ItemMHArmour extends ItemArmor
{
    public ItemMHArmour(ArmorMaterial material, int renderIndex, EntityEquipmentSlot equipSlot, String itemName)
    {
        super(material, renderIndex, equipSlot);
        setUnlocalizedName(itemName);
        setCreativeTab(MobHunter.MHARMOUR_TAB);
        setRegistryName(itemName);
    }

    public ItemMHArmour(ArmorMaterial material, EntityEquipmentSlot equipSlot, String itemName)
    {
        this(material, equipSlot.equals(EntityEquipmentSlot.LEGS) ? 2 : 1, equipSlot, itemName);
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        ClientUtil.addTooltip(stack, tooltip);
    }
}
