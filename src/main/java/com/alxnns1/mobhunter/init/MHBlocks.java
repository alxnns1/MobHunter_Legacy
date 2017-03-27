package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.*;
import com.alxnns1.mobhunter.block.render.RenderBbq;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import com.alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
    public static List<Block> BLOCKS = new ArrayList<Block>();

    public static BlockOre blockOreEarthCrystal, blockOreMachalite, blockOreDragonite, blockOreLightCrystal, blockOreIceCrystal, blockOreGossamite;
    public static BlockResource blockEarthCrystal, blockMachalite, blockDragonite, blockLightCrystal, blockGossamite, blockIceCrystal;
    public static BlockNatural blockHerb, blockShroom, blockBerry, blockBug, blockBone;
    public static BlockCrop blockCropHerb, blockCropAntidoteHerb, blockCropFireHerb, blockCropIvy, blockCropSleepHerb, blockCropSapPlant, blockCropFelvine, blockCropGloamgrass, blockCropHotPepper,
                            blockCropBlueMushroom, blockCropNitroshroom, blockCropParashroom, blockCropToadstool, blockCropExciteshroom, blockCropMopeshroom, blockCropDragonToadstool,
                            blockCropPaintberry, blockCropMightSeed, blockCropAdamantSeed, blockCropNulberry, blockCropDragonfellBerry, blockCropScatternut, blockCropNeedleberry, blockCropLatchberry, blockCropBomberry;

    public static BlockBbq blockBbq, blockBbqGourmet;
    public static BlockCraft blockWeaponCraft, blockArmourCraft;

    private static void regBlock(Block block, String oreDicName)
    {
        regBlock(block);
        OreDictionary.registerOre(oreDicName, block);
    }

    private static void regBlock(Block block)
    {
        GameRegistry.register(block);
        ItemBlock itemBlock = (ItemBlock) new ItemBlock(block).setRegistryName(block.getRegistryName());
        GameRegistry.register(itemBlock);
        BLOCKS.add(block);
    }

    public static void regBlocks()
    {
        regBlock(blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL)), "oreEarthCrystal");
        regBlock(blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 1), "oreMachalite");
        regBlock(blockOreDragonite = new BlockOre(Names.Blocks.ORE_DRAGONITE, 2), "oreDragonite");
        regBlock(blockOreLightCrystal = (BlockOre) new BlockOre(Names.Blocks.ORE_LIGHT_CRYSTAL, 2, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.LIGHT_CRYSTAL)).setLightLevel(1.0f), "oreLightCrystal");
        regBlock(blockOreIceCrystal = new BlockOre(Names.Blocks.ORE_ICE_CRYSTAL, 1, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ICE_CRYSTAL)), "oreIceCrystal");
        regBlock(blockOreGossamite = new BlockOre(Names.Blocks.ORE_GOSSAMITE, 2), "oreGossamite");

        regBlock(blockEarthCrystal = new BlockResource(Names.Blocks.EARTH_CRYSTAL, 1), "blockEarthCrystal");
        regBlock(blockMachalite = new BlockResource(Names.Blocks.MACHALITE, 1), "blockMachalite");
        regBlock(blockDragonite = new BlockResource(Names.Blocks.DRAGONITE, 2), "blockDragonite");
        regBlock(blockLightCrystal = (BlockResource) new BlockResource(Names.Blocks.LIGHT_CRYSTAL, 2).setLightLevel(1.0f), "blockLightCrystal");
        regBlock(blockIceCrystal = new BlockResource(Names.Blocks.ICE_CRYSTAL, 1), "blockIceCrystal");
        regBlock(blockGossamite = new BlockResource(Names.Blocks.GOSSAMITE, 2), "blockGossamite");
        
        regBlock(blockHerb = new BlockHerb());
        regBlock(blockShroom = new BlockShroom());
        regBlock(blockBerry = new BlockBerry());
        regBlock(blockBug = new BlockBug());
        regBlock(blockBone = new BlockBone());

        regBlock(blockCropHerb = new BlockCrop(Names.Blocks.CROP_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HERB)));
        regBlock(blockCropAntidoteHerb = new BlockCrop(Names.Blocks.CROP_ANTIDOTE_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.ANTIDOTE_HERB)));
        regBlock(blockCropFireHerb = new BlockCrop(Names.Blocks.CROP_FIRE_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.FIRE_HERB)));
        regBlock(blockCropIvy = new BlockCrop(Names.Blocks.CROP_IVY, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.IVY)));
        regBlock(blockCropSleepHerb = new BlockCrop(Names.Blocks.CROP_SLEEP_HERB, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.SLEEP_HERB)));
        regBlock(blockCropSapPlant = new BlockCrop(Names.Blocks.CROP_SAP_PLANT, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.SAP_PLANT)));
        regBlock(blockCropFelvine = new BlockCrop(Names.Blocks.CROP_FELVINE, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.FELVINE)));
        regBlock(blockCropGloamgrass = new BlockCrop(Names.Blocks.CROP_GLOAMGRASS, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.GLOAMGRASS_BUD), MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.GLOAMGRASS_ROOT)));
        regBlock(blockCropHotPepper = new BlockCrop(Names.Blocks.CROP_HOT_PEPPER, MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HOT_PEPPER)));
        regBlock(blockCropBlueMushroom = new BlockCrop(Names.Blocks.CROP_BLUE_MUSHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.BLUE_MUSHROOM)));
        regBlock(blockCropNitroshroom = new BlockCrop(Names.Blocks.CROP_NITROSHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.NITROSHROOM)));
        regBlock(blockCropParashroom = new BlockCrop(Names.Blocks.CROP_PARASHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.PARASHROOM)));
        regBlock(blockCropToadstool = new BlockCrop(Names.Blocks.CROP_TOADSTOOL, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.TOADSTOOL)));
        regBlock(blockCropExciteshroom = new BlockCrop(Names.Blocks.CROP_EXCITESHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.EXCITESHROOM)));
        regBlock(blockCropMopeshroom = new BlockCrop(Names.Blocks.CROP_MOPESHROOM, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.MOPESHROOM)));
        regBlock(blockCropDragonToadstool = new BlockCrop(Names.Blocks.CROP_DRAGON_TOADSTOOL, MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.DRAGON_TOADSTOOL)));
        regBlock(blockCropPaintberry = new BlockCrop(Names.Blocks.CROP_PAINTBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.PAINTBERRY)));
        regBlock(blockCropMightSeed = new BlockCrop(Names.Blocks.CROP_MIGHT_SEED, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.MIGHT_SEED)));
        regBlock(blockCropAdamantSeed = new BlockCrop(Names.Blocks.CROP_ADAMANT_SEED, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.ADAMANT_SEED)));
        regBlock(blockCropNulberry = new BlockCrop(Names.Blocks.CROP_NULBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.NULBERRY)));
        regBlock(blockCropDragonfellBerry = new BlockCrop(Names.Blocks.CROP_DRAGONFELL_BERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.DRAGONFELL_BERRY)));
        regBlock(blockCropScatternut = new BlockCrop(Names.Blocks.CROP_SCATTERNUT, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.SCATTERNUT)));
        regBlock(blockCropNeedleberry = new BlockCrop(Names.Blocks.CROP_NEEDLEBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.NEEDLEBERRY)));
        regBlock(blockCropLatchberry = new BlockCrop(Names.Blocks.CROP_LATCHBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.LATCHBERRY)));
        regBlock(blockCropBomberry = new BlockCrop(Names.Blocks.CROP_BOMBERRY, MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.BOMBERRY)));

        regBlock(blockBbq = new BlockBbq());
        regBlock(blockBbqGourmet = new BlockBbqGourmet());
        regBlock(blockWeaponCraft = new BlockCraft(Names.Blocks.WEAPON_CRAFT));
        regBlock(blockArmourCraft = new BlockCraft(Names.Blocks.ARMOUR_CRAFT));
    }

    public static void regTileEntities()
    {
        GameRegistry.registerTileEntity(TileBbq.class, Names.Blocks.BBQ);
    }

    @SideOnly(Side.CLIENT)
    public static void regModels()
    {
        for(Block block : BLOCKS)
            ClientUtil.regModel(block);

        ClientRegistry.bindTileEntitySpecialRenderer(TileBbq.class, new RenderBbq());
    }

    @SideOnly(Side.CLIENT)
    public static void regColours()
    {
        FMLClientHandler.instance().getClient().getBlockColors().registerBlockColorHandler(new IBlockColor()
        {
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
            {
                return worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D);
            }
        }, blockHerb, blockBerry, blockBug, blockShroom);
        FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new IItemColor()
        {
            public int getColorFromItemstack(ItemStack stack, int tintIndex)
            {
                return ColorizerGrass.getGrassColor(0.5D, 1.0D);
            }
        }, blockHerb, blockBerry, blockBug, blockShroom);
    }
}
