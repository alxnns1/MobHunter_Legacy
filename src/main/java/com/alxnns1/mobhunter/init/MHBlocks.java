package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.BlockBbq;
import com.alxnns1.mobhunter.block.BlockHerb;
import com.alxnns1.mobhunter.block.BlockOre;
import com.alxnns1.mobhunter.block.BlockShroom;
import com.alxnns1.mobhunter.block.render.RenderBbq;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import com.alxnns1.mobhunter.util.Common;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHBlocks
{
    public static BlockOre blockOreMachalite = new BlockOre(Names.Blocks.ORE_MACHALITE, 2);
    public static BlockOre blockOreEarthCrystal = new BlockOre(Names.Blocks.ORE_EARTH_CRYSTAL, 1, MHItems.itemEarthCrystal);

    public static BlockHerb blockHerb = new BlockHerb();
    public static BlockShroom blockShroom = new BlockShroom();

    public static BlockBbq blockBbq = new BlockBbq();

    public static void init()
    {
        GameRegistry.registerBlock(blockOreMachalite, Names.Blocks.ORE_MACHALITE);
        GameRegistry.registerBlock(blockOreEarthCrystal, Names.Blocks.ORE_EARTH_CRYSTAL);

        GameRegistry.registerBlock(blockHerb, Names.Blocks.HERB);
        GameRegistry.registerBlock(blockShroom, Names.Blocks.SHROOM);

        GameRegistry.registerBlock(blockBbq, Names.Blocks.BBQ);
    }

    public static void regModels()
    {
        Common.regModel(blockOreMachalite);
        Common.regModel(blockOreEarthCrystal);

        Common.regModel(blockHerb);
        Common.regModel(blockShroom);

        Common.regModel(blockBbq);
        ClientRegistry.bindTileEntitySpecialRenderer(TileBbq.class, new RenderBbq());
    }
}
