package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.capability.HunterRankDefault;
import com.alxnns1.mobhunter.capability.IHunterRank;
import com.alxnns1.mobhunter.gui.GuiHandler;
import com.alxnns1.mobhunter.init.*;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.worldgen.WorldGenHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
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
            //return new ItemStack(MHItems.itemBones, 1, 0).getItem();
            return MHItems.itemMonsterBoneS;
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
        MHEntities.init(event.getSide() == Side.CLIENT);
        MHPotions.init();

        //TODO: Uncomment Hunter Rank
        //CapabilityManager.INSTANCE.register(IHunterRank.class, HunterRankDefault.HunterRankStorage.hunterRankStorage, HunterRankDefault.class);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //Initializing and registering textures, models, GUIs, tile entities, recipes and event handlers

        //Model registering needs to only happen client-side
        if(event.getSide() == Side.CLIENT)
        {
            MHItems.regModels();
            MHBlocks.regModels();
            MHBlocks.regColours();
        }

        MHRecipes.init();
        MHAchievements.init();
        GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        //I wonder if I'll use this
    }
}
