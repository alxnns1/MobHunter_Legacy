package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.*;
import com.alxnns1.mobhunter.block.render.RenderBbq;
import com.alxnns1.mobhunter.block.BlockWeaponUpgrade;
import com.alxnns1.mobhunter.item.ItemBlockBasic;
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

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
    public static BlockOre blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MHItems.itemEarthCrystal);
    public static BlockResource blockEarthCrystal = new BlockResource(Names.Blocks.EARTH_CRYSTAL, 1);
    public static BlockOre blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 1);
    public static BlockResource blockMachalite = new BlockResource(Names.Blocks.MACHALITE, 1);
    public static BlockOre blockOreDragonite = new BlockOre(Names.Blocks.ORE_DRAGONITE, 2);
    public static BlockResource blockDragonite = new BlockResource(Names.Blocks.DRAGONITE, 2);
    public static BlockOre blockOreLightCrystal = (BlockOre) new BlockOre(Names.Blocks.ORE_LIGHT_CRYSTAL, 2, MHItems.itemLightCrystal).setLightLevel(1.0f);
    public static BlockResource blockLightCrystal = (BlockResource) new BlockResource(Names.Blocks.LIGHT_CRYSTAL, 2).setLightLevel(1.0f);
    public static BlockOre blockOreIceCrystal = new BlockOre(Names.Blocks.ORE_ICE_CRYSTAL, 1, MHItems.itemIceCrystal);
    public static BlockResource blockIceCrystal = new BlockResource(Names.Blocks.ICE_CRYSTAL, 1);
    public static BlockOre blockOreGossamite = new BlockOre(Names.Blocks.ORE_GOSSAMITE, 2);
    public static BlockResource blockGossamite = new BlockResource(Names.Blocks.GOSSAMITE, 2);

    public static BlockHerb blockHerb = new BlockHerb();
    public static BlockShroom blockShroom = new BlockShroom();
    public static BlockBerry blockBerry = new BlockBerry();
    public static BlockBug blockBug = new BlockBug();
    public static BlockBone blockBone = new BlockBone();

    public static BlockBbq blockBbq = new BlockBbq();
    public static BlockWeaponUpgrade blockWeaponUpgrade = new BlockWeaponUpgrade();

    private static void regBlock(Block block, String oreDicName)
    {
        GameRegistry.register(block);
        ItemBlock itemBlock = new ItemBlockBasic(block);
        GameRegistry.register(itemBlock);
        OreDictionary.registerOre(oreDicName, block);
    }

    private static void regBlock(Block block)
    {
        GameRegistry.register(block);
        ItemBlock itemBlock = new ItemBlockBasic(block);
        GameRegistry.register(itemBlock);
    }

    public static void init()
    {
        regBlock(blockOreEarthCrystal, "oreEarthCrystal");
        regBlock(blockEarthCrystal, "blockEarthCrystal");
        regBlock(blockOreMachalite, "oreMachalite");
        regBlock(blockMachalite, "blockMachalite");
        regBlock(blockOreDragonite, "oreDragonite");
        regBlock(blockDragonite, "blockDragonite");
        regBlock(blockOreLightCrystal, "oreLightCrystal");
        regBlock(blockLightCrystal, "blockLightCrystal");
        regBlock(blockOreIceCrystal, "oreIceCrystal");
        regBlock(blockIceCrystal, "blockIceCrystal");
        regBlock(blockOreGossamite, "oreGossamite");
        regBlock(blockGossamite, "blockGossamite");

        regBlock(blockHerb);
        regBlock(blockShroom);
        regBlock(blockBerry);
        regBlock(blockBug);
        regBlock(blockBone);

        regBlock(blockBbq);
        regBlock(blockWeaponUpgrade);
    }

    @SideOnly(Side.CLIENT)
    public static void regModels()
    {
        ClientUtil.regModel(blockOreEarthCrystal);
        ClientUtil.regModel(blockEarthCrystal);
        ClientUtil.regModel(blockOreMachalite);
        ClientUtil.regModel(blockMachalite);
        ClientUtil.regModel(blockOreDragonite);
        ClientUtil.regModel(blockDragonite);
        ClientUtil.regModel(blockOreLightCrystal);
        ClientUtil.regModel(blockLightCrystal);
        ClientUtil.regModel(blockOreIceCrystal);
        ClientUtil.regModel(blockIceCrystal);
        ClientUtil.regModel(blockOreGossamite);
        ClientUtil.regModel(blockGossamite);

        ClientUtil.regModel(blockHerb);
        ClientUtil.regModel(blockShroom);
        ClientUtil.regModel(blockBerry);
        ClientUtil.regModel(blockBug);
        ClientUtil.regModel(blockBone);

        ClientUtil.regModel(blockBbq);
        ClientRegistry.bindTileEntitySpecialRenderer(TileBbq.class, new RenderBbq());
        ClientUtil.regModel(blockWeaponUpgrade);
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
        }, blockHerb,blockBerry,blockBug,blockShroom);
        FMLClientHandler.instance().getClient().getItemColors().registerItemColorHandler(new IItemColor()
        {
            public int getColorFromItemstack(ItemStack stack, int tintIndex)
            {
                return ColorizerGrass.getGrassColor(0.5D, 1.0D);
            }
        }, blockHerb,blockBerry,blockBug,blockShroom);
    }
}
