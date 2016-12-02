package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.handler.GuiHandler;
import com.alxnns1.mobhunter.handler.ConfigHandler;
import com.alxnns1.mobhunter.handler.EventHandler;
import com.alxnns1.mobhunter.handler.LootHandler;
import com.alxnns1.mobhunter.init.*;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.worldgen.WorldGenHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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
public class MobHunter
{
    @Mod.Instance(Reference.MOD_ID)
    public static MobHunter instance;

    public static final CreativeTabs MH_TAB = new CreativeTabs(Reference.MOD_ID + "Items")
    {
        @Override
        public Item getTabIconItem()
        {
            return MHItems.itemMonsterDrop;
        }

        @SideOnly(Side.CLIENT)
        public int getIconItemDamage()
        {
            return MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S);
        }

        @Override
        public String getTranslatedTabLabel()
        {
            return Reference.MOD_NAME + " Items";
        }

    };

    public static final CreativeTabs MHARMOUR_TAB = new CreativeTabs(Reference.MOD_ID + "Armours")
    {
        @Override
        public Item getTabIconItem()
        {
            return MHItems.armourBoneHelmet;
        }

        @Override
        public String getTranslatedTabLabel()
        {
            return Reference.MOD_NAME + " Armours";
        }

    };

    public static final CreativeTabs MHWEAPON_TAB = new CreativeTabs(Reference.MOD_ID + "Weapons")
    {
        @Override
        public Item getTabIconItem()
        {
            return MHItems.weaponHuntersKnife;
        }

        @Override
        public String getTranslatedTabLabel()
        {
            return Reference.MOD_NAME + " Weapons";
        }

    };

    public static final CreativeTabs MHBLOCK_TAB = new CreativeTabs(Reference.MOD_ID + "Blocks")
    {
        @Override
        public Item getTabIconItem()
        {
            return Item.getItemFromBlock(MHBlocks.blockWeaponCraft);
        }

        @Override
        public String getTranslatedTabLabel()
        {
            return Reference.MOD_NAME + " Blocks";
        }

    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
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
    public void init(FMLInitializationEvent event)
    {
        //Initializing and registering GUIs, tile entities, recipes and event handlers

        if(event.getSide() == Side.CLIENT)
            MHBlocks.regColours();

        MHRecipes.init();
        MHAchievements.init();
        GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new LootHandler());

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        //I wonder if I'll use this
    }
}
