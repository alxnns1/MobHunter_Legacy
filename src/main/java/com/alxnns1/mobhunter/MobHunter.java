package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.gui.GuiHandler;
import com.alxnns1.mobhunter.handler.ConfigHandler;
import com.alxnns1.mobhunter.handler.EntityEventHandler;
import com.alxnns1.mobhunter.init.*;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.worldgen.WorldGenHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 20/04/2016.
 */

@Mod(modid= Reference.MOD_ID, name= Reference.MOD_NAME, version= Reference.VERSION)
public class MobHunter {

    @Mod.Instance(Reference.MOD_ID)
    public static MobHunter instance;

    public static final CreativeTabs MH_TAB = new CreativeTabs(Reference.MOD_ID)
    {
        @Override
        public Item getTabIconItem()
        {
            return MHItems.itemMonsterDrop;
            //return MHItems.itemMonsterBoneS;
        }

        @SideOnly(Side.CLIENT)
        public int getIconItemDamage()
        {
            return 0;
        }

        @Override
        public String getTranslatedTabLabel()
        {
            return Reference.MOD_NAME;
        }

    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event){
        //Initializing and registering items, blocks and configs

        //Passes suggested configuration file into the regBlocks method
        ConfigHandler.init(event.getSuggestedConfigurationFile());
        MinecraftForge.EVENT_BUS.register(new ConfigHandler());

        MHItems.regItems();
        MHBlocks.regBlocks();
        MHBlocks.regTileEntities();
        MHEntities.init(event.getSide() == Side.CLIENT);
        MHPotions.init();

        //Model registering needs to only happen client-side
        if(event.getSide() == Side.CLIENT)
        {
            MHItems.regModels();
            MHBlocks.regModels();
        }

        //TODO: Uncomment Hunter Rank
        //CapabilityManager.INSTANCE.register(IHunterRank.class, HunterRankDefault.HunterRankStorage.hunterRankStorage, HunterRankDefault.class);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
        //Initializing and registering GUIs, tile entities, recipes and event handlers

        if(event.getSide() == Side.CLIENT)
            MHBlocks.regColours();

        MHRecipes.init();
        MHAchievements.init();
        //GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
        MinecraftForge.EVENT_BUS.register(new EntityEventHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        //I wonder if I'll use this
    }
}
