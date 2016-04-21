package com.alxnns1.mobhunter.util;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.ItemModelMesherForge;

/**
 * This class will contain methods which will get used in multiple places
 * Created by Mark on 21/04/2016.
 */
public class Common
{
    private static ItemModelMesherForge m = (ItemModelMesherForge) Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

    /**
     * Registers item models using their unlocalised name.
     * ONLY run this client side!
     * @param item
     */
    public static void regModel(Item item)
    {
        m.register(item,0,new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(item.getUnlocalizedName().indexOf(".")+1),"inventory"));
    }
}
