package alxnns1.mobhunter.init;

import alxnns1.mobhunter.block.*;
import alxnns1.mobhunter.item.ItemBlockBarrelBomb;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.tileentity.TileBbq;
import alxnns1.mobhunter.tileentity.TileGourmetBBQ;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Contains all of the mod's blocks
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
	public static Set<Block> BLOCKS = new HashSet<>();
	public static Set<Item> ITEM_BLOCKS = new HashSet<>();
	public static Map<Block, String> ORES = new HashMap<>();

	public static BlockOre blockOreEarthCrystal, blockOreMachalite, blockOreDragonite, blockOreLightCrystal, blockOreIceCrystal, blockOreGossamite;
	public static BlockResource blockEarthCrystal, blockMachalite, blockDragonite, blockLightCrystal, blockGossamite, blockIceCrystal;
	public static BlockNatural blockHerb, blockShroom, blockBerry, blockBug, blockBone;
	public static BlockCrop blockCropHerb, blockCropAntidoteHerb, blockCropFireHerb, blockCropIvy, blockCropSleepHerb, blockCropSapPlant, blockCropFelvine, blockCropGloamgrass, blockCropHotPepper,
			blockCropBlueMushroom, blockCropNitroshroom, blockCropParashroom, blockCropToadstool, blockCropExciteshroom, blockCropMopeshroom, blockCropDragonToadstool,
			blockCropPaintberry, blockCropMightSeed, blockCropAdamantSeed, blockCropNulberry, blockCropDragonfellBerry, blockCropScatternut, blockCropNeedleberry, blockCropLatchberry, blockCropBomberry;

	public static BlockBbq blockBbq, blockBbqGourmet;
	public static BlockCraft blockWeaponCraft, blockArmourCraft;
	public static BlockBarrelBomb blockBarrelBomb;

	private static void addBlock(Block block, String oreDicName)
	{
		addBlock(block);
		ORES.put(block, oreDicName);
	}

	private static void addBlock(Block block)
	{
		addBlock(block, new ItemBlock(block));
	}

	private static void addBlock(Block block, ItemBlock itemBlock)
	{
		BLOCKS.add(block);
		ITEM_BLOCKS.add(itemBlock.setRegistryName(block.getRegistryName()));
	}

	private static void init()
	{
		addBlock(blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL)), "oreEarthCrystal");
		addBlock(blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 1), "oreMachalite");
		addBlock(blockOreDragonite = new BlockOre(Names.Blocks.ORE_DRAGONITE, 2), "oreDragonite");
		addBlock(blockOreLightCrystal = (BlockOre) new BlockOre(Names.Blocks.ORE_LIGHT_CRYSTAL, 2, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.LIGHT_CRYSTAL)).setLightLevel(1.0f), "oreLightCrystal");
		addBlock(blockOreIceCrystal = new BlockOre(Names.Blocks.ORE_ICE_CRYSTAL, 1, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ICE_CRYSTAL)), "oreIceCrystal");
		addBlock(blockOreGossamite = new BlockOre(Names.Blocks.ORE_GOSSAMITE, 2), "oreGossamite");

		addBlock(blockEarthCrystal = new BlockResource(Names.Blocks.EARTH_CRYSTAL, 1), "blockEarthCrystal");
		addBlock(blockMachalite = new BlockResource(Names.Blocks.MACHALITE, 1), "blockMachalite");
		addBlock(blockDragonite = new BlockResource(Names.Blocks.DRAGONITE, 2), "blockDragonite");
		addBlock(blockLightCrystal = (BlockResource) new BlockResource(Names.Blocks.LIGHT_CRYSTAL, 2).setLightLevel(1.0f), "blockLightCrystal");
		addBlock(blockIceCrystal = new BlockResource(Names.Blocks.ICE_CRYSTAL, 1), "blockIceCrystal");
		addBlock(blockGossamite = new BlockResource(Names.Blocks.GOSSAMITE, 2), "blockGossamite");

		addBlock(blockHerb = new BlockHerb());
		addBlock(blockShroom = new BlockShroom());
		addBlock(blockBerry = new BlockBerry());
		addBlock(blockBug = new BlockBug());
		addBlock(blockBone = new BlockBone());

		addBlock(blockCropHerb = new BlockCrop(Names.Blocks.CROP_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HERB)));
		addBlock(blockCropAntidoteHerb = new BlockCrop(Names.Blocks.CROP_ANTIDOTE_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.ANTIDOTE_HERB)));
		addBlock(blockCropFireHerb = new BlockCrop(Names.Blocks.CROP_FIRE_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.FIRE_HERB)));
		addBlock(blockCropIvy = new BlockCrop(Names.Blocks.CROP_IVY, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.IVY)));
		addBlock(blockCropSleepHerb = new BlockCrop(Names.Blocks.CROP_SLEEP_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.SLEEP_HERB)));
		addBlock(blockCropSapPlant = new BlockCrop(Names.Blocks.CROP_SAP_PLANT, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.SAP_PLANT)));
		addBlock(blockCropFelvine = new BlockCrop(Names.Blocks.CROP_FELVINE, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.FELVINE)));
		addBlock(blockCropGloamgrass = new BlockCrop(Names.Blocks.CROP_GLOAMGRASS, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.GLOAMGRASS_BUD), MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.GLOAMGRASS_ROOT)));
		addBlock(blockCropHotPepper = new BlockCrop(Names.Blocks.CROP_HOT_PEPPER, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HOT_PEPPER)));
		addBlock(blockCropBlueMushroom = new BlockCrop(Names.Blocks.CROP_BLUE_MUSHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.BLUE_MUSHROOM)));
		addBlock(blockCropNitroshroom = new BlockCrop(Names.Blocks.CROP_NITROSHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.NITROSHROOM)));
		addBlock(blockCropParashroom = new BlockCrop(Names.Blocks.CROP_PARASHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.PARASHROOM)));
		addBlock(blockCropToadstool = new BlockCrop(Names.Blocks.CROP_TOADSTOOL, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.TOADSTOOL)));
		addBlock(blockCropExciteshroom = new BlockCrop(Names.Blocks.CROP_EXCITESHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.EXCITESHROOM)));
		addBlock(blockCropMopeshroom = new BlockCrop(Names.Blocks.CROP_MOPESHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.MOPESHROOM)));
		addBlock(blockCropDragonToadstool = new BlockCrop(Names.Blocks.CROP_DRAGON_TOADSTOOL, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.DRAGON_TOADSTOOL)));
		addBlock(blockCropPaintberry = new BlockCrop(Names.Blocks.CROP_PAINTBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.PAINTBERRY)));
		addBlock(blockCropMightSeed = new BlockCrop(Names.Blocks.CROP_MIGHT_SEED, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.MIGHT_SEED)));
		addBlock(blockCropAdamantSeed = new BlockCrop(Names.Blocks.CROP_ADAMANT_SEED, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.ADAMANT_SEED)));
		addBlock(blockCropNulberry = new BlockCrop(Names.Blocks.CROP_NULBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.NULBERRY)));
		addBlock(blockCropDragonfellBerry = new BlockCrop(Names.Blocks.CROP_DRAGONFELL_BERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.DRAGONFELL_BERRY)));
		addBlock(blockCropScatternut = new BlockCrop(Names.Blocks.CROP_SCATTERNUT, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.SCATTERNUT)));
		addBlock(blockCropNeedleberry = new BlockCrop(Names.Blocks.CROP_NEEDLEBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.NEEDLEBERRY)));
		addBlock(blockCropLatchberry = new BlockCrop(Names.Blocks.CROP_LATCHBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.LATCHBERRY)));
		addBlock(blockCropBomberry = new BlockCrop(Names.Blocks.CROP_BOMBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.BOMBERRY)));

		addBlock(blockBbq = new BlockBbq());
		addBlock(blockBbqGourmet = new BlockBbqGourmet());
		addBlock(blockWeaponCraft = new BlockCraft(Names.Blocks.WEAPON_CRAFT));
		addBlock(blockArmourCraft = new BlockCraft(Names.Blocks.ARMOUR_CRAFT));

		addBlock(blockBarrelBomb = new BlockBarrelBomb(), new ItemBlockBarrelBomb(blockBarrelBomb));

		GameRegistry.registerTileEntity(TileBbq.class, Names.Blocks.BBQ);
		GameRegistry.registerTileEntity(TileGourmetBBQ.class, Names.Blocks.BBQ_GOURMET);
	}

	public static void regOres()
	{
		if(BLOCKS.isEmpty()) init();
		ORES.forEach((block, ore) -> OreDictionary.registerOre(ore, block));
	}

	public static Set<Block> getBlocks()
	{
		if(BLOCKS.isEmpty()) init();
		return BLOCKS;
	}

	public static Set<Item> getItemBlocks()
	{
		if(ITEM_BLOCKS.isEmpty()) init();
		return ITEM_BLOCKS;
	}
}
