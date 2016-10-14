package com.alxnns1.mobhunter.util;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.ItemModelMesherForge;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mark on 14/10/2016.
 */
@SideOnly(Side.CLIENT)
public class ClientUtil
{
    private static ItemModelMesherForge m = (ItemModelMesherForge) Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

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
        m.register(item,meta,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(item.getUnlocalizedName().indexOf(".")+1),"inventory"));
    }
}
