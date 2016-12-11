package com.alxnns1.mobhunter.util;

import com.alxnns1.mobhunter.item.ISubTypes;
import com.alxnns1.mobhunter.item.ItemMHArmour;
import com.alxnns1.mobhunter.item.ItemMHBow;
import com.alxnns1.mobhunter.item.ItemMHSword;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;

/**
 * Created by Mark on 14/10/2016.
 */
@SideOnly(Side.CLIENT)
public class ClientUtil
{
    /**
     * Registers item models using their unlocalised name.
     * ONLY run this client side!
     * @param item
     */
    public static void regModel(Item item)
    {
        regModel(item, 0);
    }
    public static void regModel(Block block)
    {
        regModel(Item.getItemFromBlock(block), 0);
    }

    public static void regModel(Item item, int meta)
    {
        String itemPath = item.getRegistryName().getResourcePath();
        if(item instanceof ItemBlock)
            itemPath = "block/" + itemPath;
        else if(item instanceof ItemMHArmour)
            itemPath = "armour/" + itemPath;
        else if(item instanceof ItemMHSword)
            itemPath = "weapon/sword/" + itemPath;
        else if(item instanceof ItemMHBow)
            itemPath = "weapon/bow/" + itemPath;
        if(item.getHasSubtypes() && item instanceof ISubTypes)
            itemPath += "/" + ((ISubTypes) item).getSubNames()[meta];
        ModelResourceLocation loc = new ModelResourceLocation(item.getRegistryName().getResourceDomain() + ":" + itemPath, "inventory");
        ModelLoader.setCustomModelResourceLocation(item, meta, loc);
    }
}
