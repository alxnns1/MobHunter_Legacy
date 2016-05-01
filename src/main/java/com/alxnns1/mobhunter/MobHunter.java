package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.entity.EntityJaggi;
import com.alxnns1.mobhunter.entity.EntityKelbi;
import com.alxnns1.mobhunter.entity.EntityPopo;
import com.alxnns1.mobhunter.entity.render.RenderJaggi;
import com.alxnns1.mobhunter.entity.render.RenderKelbi;
import com.alxnns1.mobhunter.entity.render.RenderPopo;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.init.MHRecipes;
import com.alxnns1.mobhunter.init.MHTileEntities;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.worldgen.WorldGenHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

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
            return new ItemStack(MHItems.itemBones, 1, 0).getItem();
            //return MHItems.itemMonsterBoneS;
        }

        @Override
        public String getTranslatedTabLabel() {
            return Reference.MOD_NAME;
        }

    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Initializing and registering items, blocks and configs

        MHItems.init();
        MHBlocks.init();
        MHTileEntities.init();

        EntityRegistry.registerModEntity(EntityPopo.class, "Popo", 100, MobHunter.instance, 64, 1, false);
        EntityRegistry.registerModEntity(EntityKelbi.class, "Kelbi", 101, MobHunter.instance, 64, 1, false);
        EntityRegistry.registerModEntity(EntityJaggi.class, "Jaggi", 102, MobHunter.instance, 64, 1, false);
        EntityRegistry.registerEgg(EntityPopo.class,0x402a00,0x403400);
        EntityRegistry.registerEgg(EntityKelbi.class,0x20402b,0xbfbf8f);
        EntityRegistry.registerEgg(EntityJaggi.class,0xd56a00,0xbf80ff);

        if(event.getSide() == Side.CLIENT)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityPopo.class, RenderPopo.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityKelbi.class, RenderKelbi.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityJaggi.class, RenderJaggi.FACTORY);
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //Initializing and registering textures, models, GUIs, tile entities, recipes and event handlers

        //Model registering needs to only happen client-side
        if(event.getSide() == Side.CLIENT)
        {
            MHItems.regModels();
            MHBlocks.regModels();
        }

        MHRecipes.init();
        GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);

        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());
        EntityEventHandler.addMobDrop(EntityEventHandler.ALL_VANILLA_WILDCARD,new ItemStack(MHItems.itemBones, 1, 1),1,1,0.5f);
        EntityEventHandler.addMobDrop(EntityEventHandler.AGGRESSIVE_WILDCARD,new ItemStack(MHItems.itemBones, 1, 0),1,2,0.5f);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        //I wonder if I'll use this
    }
}
