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

    public static BlockBbq blockBbq;
    public static BlockWeaponUpgrade blockWeaponUpgrade;

    private static void regBlock(Block block, String oreDicName)
    {
        regBlock(block);
        OreDictionary.registerOre(oreDicName, block);
    }

    private static void regBlock(Block block)
    {
        GameRegistry.register(block);
        ItemBlock itemBlock = new ItemBlockBasic(block);
        GameRegistry.register(itemBlock);
        BLOCKS.add(block);
    }

    public static void regBlocks()
    {
        regBlock(blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MHItems.itemEarthCrystal), "oreEarthCrystal");
        regBlock(blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 1), "oreMachalite");
        regBlock(blockOreDragonite = new BlockOre(Names.Blocks.ORE_DRAGONITE, 2), "oreDragonite");
        regBlock(blockOreLightCrystal = (BlockOre) new BlockOre(Names.Blocks.ORE_LIGHT_CRYSTAL, 2, MHItems.itemLightCrystal).setLightLevel(1.0f), "oreLightCrystal");
        regBlock(blockOreIceCrystal = new BlockOre(Names.Blocks.ORE_ICE_CRYSTAL, 1, MHItems.itemIceCrystal), "oreIceCrystal");
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

        regBlock(blockBbq = new BlockBbq());
        regBlock(blockWeaponUpgrade = new BlockWeaponUpgrade());
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
