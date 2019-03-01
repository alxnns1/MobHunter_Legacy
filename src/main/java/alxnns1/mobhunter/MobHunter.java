package alxnns1.mobhunter;

import alxnns1.mobhunter.capability.hunterRank.HunterRankProgression;
import alxnns1.mobhunter.command.CommandHunterRank;
import alxnns1.mobhunter.command.CommandMonsters;
import alxnns1.mobhunter.command.CommandQuest;
import alxnns1.mobhunter.handler.GuiHandler;
import alxnns1.mobhunter.init.*;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.util.CommonUtil;
import alxnns1.mobhunter.worldgen.WorldGenHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.Logger;

/**
 * Created by Alex on 20/04/2016.
 */

@Mod(modid = MobHunter.MOD_ID, name = MobHunter.MOD_NAME, version = MobHunter.VERSION)
public class MobHunter
{
	public static final String MOD_ID = "mobhunter";
	public static final String MOD_NAME = "Mob Hunter";
	public static final String VERSION = "@VERSION@";
	public static final String GUI_TEXTURE_DIR = "textures/gui/";

	@Mod.Instance(MOD_ID)
	public static MobHunter instance;

	public static Logger LOGGER;

	public static final CreativeTabs MH_TAB = new CreativeTabs(MOD_ID + "_items")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S);
		}
	};

	public static final CreativeTabs MHARMOUR_TAB = new CreativeTabs(MOD_ID + "_armours")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(MHItems.armourBoneHelmet);
		}
	};

	public static final CreativeTabs MHWEAPON_TAB = new CreativeTabs(MOD_ID + "_weapons")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(MHItems.weaponHuntersKnife);
		}
	};

	public static final CreativeTabs MHBLOCK_TAB = new CreativeTabs(MOD_ID + "_blocks")
	{
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(MHBlocks.blockWeaponCraft);
		}
	};

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//Initializing and registering items, blocks and configs

		LOGGER = event.getModLog();
		CommonUtil.initNetwork();
		MHCapabilities.init();
		MHAdvancementTriggers.init();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		//Initializing and registering GUIs, tile entities, recipes and event handlers

		MHBlocks.regOres();
		MHRecipes.regSmelting();
		GameRegistry.registerWorldGenerator(new WorldGenHandler(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		HunterRankProgression.init();
		MHQuests.initLists();

		MHItems.ITEMS = null;
		MHBlocks.BLOCKS = null;
		MHBlocks.ITEM_BLOCKS = null;
		MHBlocks.ORES = null;
		MHEntities.ENTITIES = null;
	}

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event)
	{
		//Register commands
		event.registerServerCommand(new CommandQuest());
		event.registerServerCommand(new CommandHunterRank());
		event.registerServerCommand(new CommandMonsters());
	}
}
