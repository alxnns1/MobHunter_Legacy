package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.item.ItemResource;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.ItemModelMesherForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Created by Alex on 20/04/2016.
 */

@Mod(modid= Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION)
public class MobHunter {

    @Mod.Instance(Reference.MOD_ID)
    public static MobHunter instance;

    public static final CreativeTabs MH_TAB = new CreativeTabs(Reference.MOD_ID) {

        @Override
        public Item getTabIconItem() {
            return itemBoneMail;
        }

        @Override
        public String getTranslatedTabLabel() {
            return Reference.MOD_NAME;
        }

    };

    public static final ItemResource itemBoneMail = new ItemResource("itemBoneMail");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Initializing and registering items, blocks and configs

        GameRegistry.registerItem(itemBoneMail,"itemBoneMail");
        GameRegistry.addRecipe(new ItemStack(itemBoneMail), new Object[] {"xyx", "yxy", "xyx", 'x', Items.string, 'y', Items.bone});
        GameRegistry.addShapelessRecipe(new ItemStack(Items.skull,1,0), new ItemStack(Items.skull,1,OreDictionary.WILDCARD_VALUE));
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //Initializing and registering textures, models, GUIs, tile entities, recipes and event handlers

        ItemModelMesherForge m = (ItemModelMesherForge) Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
        m.register(itemBoneMail,0,new ModelResourceLocation(Reference.MOD_ID + ":" + itemBoneMail.getUnlocalizedName().substring(itemBoneMail.getUnlocalizedName().indexOf(".")+1),"inventory"));
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        //I wonder if I'll use this
    }
}
