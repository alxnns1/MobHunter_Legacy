package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.BlockOre;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.Common;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
    public static BlockOre blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 2);
    public static BlockOre blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MHItems.itemEarthCrystal);

    public static void init()
    {
        GameRegistry.registerBlock(blockOreMachalite, Names.Blocks.ORE_MACHALITE);
        GameRegistry.registerBlock(blockOreEarthCrystal, Names.Blocks.ORE_EARTH_CRYSTAL);
    }

    public static void regModels()
    {
        Common.regModel(blockOreMachalite);
        Common.regModel(blockOreEarthCrystal);
    }
}
