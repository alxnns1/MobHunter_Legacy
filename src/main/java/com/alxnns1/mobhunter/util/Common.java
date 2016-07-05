package com.alxnns1.mobhunter.util;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.client.ItemModelMesherForge;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

import java.util.List;

/**
 * This class will contain methods which will get used in multiple places
 * Created by Mark on 21/04/2016.
 */
public class Common
{
    public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);

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

    private static int maxLength = 30;

    public static List<String> addTooltip(ItemStack stack, List<String> tooltip)
    {
        String unlocName = stack.getUnlocalizedName();
        String tooltipText = new TextComponentTranslation(unlocName + ".tooltip").getUnformattedText();
        //Convert string to array to we can wrap by word
        String[] tooltipArray = tooltipText.split(" ");
        int l = 0;
        String line = "";
        for(String s : tooltipArray)
        {
            l += s.length(); //Get word length
            line += s + " "; //Add word to the line
            if(l > maxLength)
            {
                //If current line is long enough, go to next line
                tooltip.add(line);
                line = "";
                l = 0;
            }
        }
        if(l > 0)
            tooltip.add(line);

        return tooltip;
    }

    /**
     * Copied from EntityLivingBase due to it being private.
     * Determines whether the entity can block the damage source based on the damage source's location, whether the
     * damage source is blockable, and whether the entity is blocking.
     */
    public static boolean canBlockDamageSource(EntityLivingBase entity, DamageSource damageSourceIn)
    {
        if (!damageSourceIn.isUnblockable() && entity.isActiveItemStackBlocking())
        {
            Vec3d vec3d = damageSourceIn.getDamageLocation();

            if (vec3d != null)
            {
                Vec3d vec3d1 = entity.getLook(1.0F);
                Vec3d vec3d2 = vec3d.subtractReverse(new Vec3d(entity.posX, entity.posY, entity.posZ)).normalize();
                vec3d2 = new Vec3d(vec3d2.xCoord, 0.0D, vec3d2.zCoord);

                if (vec3d2.dotProduct(vec3d1) < 0.0D)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
