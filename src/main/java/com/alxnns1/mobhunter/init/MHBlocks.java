package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.*;
import com.alxnns1.mobhunter.block.render.RenderBbq;
import com.alxnns1.mobhunter.block.upgrading.BlockWeaponUpgrade;
import com.alxnns1.mobhunter.item.ItemBlockBasic;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
    public static BlockOre blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MHItems.itemEarthCrystal);
    public static BlockResource blockEarthCrystal = new BlockResource(Names.Blocks.EARTH_CRYSTAL);
    public static BlockOre blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 1);
    public static BlockResource blockMachalite = new BlockResource(Names.Blocks.MACHALITE);
    public static BlockOre blockOreDragonite = new BlockOre(Names.Blocks.ORE_DRAGONITE, 2);
    public static BlockResource blockDragonite = new BlockResource(Names.Blocks.DRAGONITE, 2);

    public static BlockHerb blockHerb = new BlockHerb();
    public static BlockShroom blockShroom = new BlockShroom();
    public static BlockBerry blockBerry = new BlockBerry();
    public static BlockBug blockBug = new BlockBug();
    public static BlockBone blockBone = new BlockBone();

    public static BlockBbq blockBbq = new BlockBbq();
    public static BlockWeaponUpgrade blockWeaponUpgrade = new BlockWeaponUpgrade();

    private static void regBlock(Block block)
    {
        GameRegistry.register(block);
        ItemBlock itemBlock = new ItemBlockBasic(block);
        GameRegistry.register(itemBlock);
    }

    public static void init()
    {
        regBlock(blockOreEarthCrystal);
        regBlock(blockEarthCrystal);
        regBlock(blockOreMachalite);
        regBlock(blockMachalite);
        regBlock(blockOreDragonite);
        regBlock(blockDragonite);

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
        Common.regModel(blockOreEarthCrystal);
        Common.regModel(blockEarthCrystal);
        Common.regModel(blockOreMachalite);
        Common.regModel(blockMachalite);
        Common.regModel(blockOreDragonite);
        Common.regModel(blockDragonite);

        Common.regModel(blockHerb);
        Common.regModel(blockShroom);
        Common.regModel(blockBerry);
        Common.regModel(blockBug);
        Common.regModel(blockBone);

        Common.regModel(blockBbq);
        ClientRegistry.bindTileEntitySpecialRenderer(TileBbq.class, new RenderBbq());
        Common.regModel(blockWeaponUpgrade);
    }
}
