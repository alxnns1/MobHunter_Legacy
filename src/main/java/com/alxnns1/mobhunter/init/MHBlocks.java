package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.BlockOre;
import com.alxnns1.mobhunter.block.BlockOreGem;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.Common;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
    public static BlockOre blockOreMalachite = new BlockOre(Names.Blocks.ORE_MALACHITE);
    public static BlockOre blockOreEarthCrystal = new BlockOreGem(Names.Blocks.ORE_EARTH_CRYSTAL, MHItems.itemEarthCrystal);

    public static void init()
    {
        GameRegistry.registerBlock(blockOreMalachite, Names.Blocks.ORE_MALACHITE);
        GameRegistry.registerBlock(blockOreEarthCrystal, Names.Blocks.ORE_EARTH_CRYSTAL);
    }

    public static void regModels()
    {
        Common.regModel(blockOreMalachite);
        Common.regModel(blockOreEarthCrystal);
    }
}
