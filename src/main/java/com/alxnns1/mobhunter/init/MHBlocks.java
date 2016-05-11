package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.block.*;
import com.alxnns1.mobhunter.block.render.RenderBbq;
import com.alxnns1.mobhunter.block.upgrading.BlockWeaponUpgrade;
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
    public static BlockBerry blockBerry = new BlockBerry();
    public static BlockBug blockBug = new BlockBug();
    public static BlockBone blockBone = new BlockBone();

    public static BlockBbq blockBbq = new BlockBbq();
    public static BlockWeaponUpgrade blockWeaponUpgrade = new BlockWeaponUpgrade();

    public static void init()
    {
        GameRegistry.registerBlock(blockOreMachalite, Names.Blocks.ORE_MACHALITE);
        GameRegistry.registerBlock(blockOreEarthCrystal, Names.Blocks.ORE_EARTH_CRYSTAL);

        GameRegistry.registerBlock(blockHerb, Names.Blocks.HERB);
        GameRegistry.registerBlock(blockShroom, Names.Blocks.SHROOM);
        GameRegistry.registerBlock(blockBerry, Names.Blocks.BERRY);
        GameRegistry.registerBlock(blockBug, Names.Blocks.BUG);
        GameRegistry.registerBlock(blockBone, Names.Blocks.BONE);

        GameRegistry.registerBlock(blockBbq, Names.Blocks.BBQ);
        GameRegistry.registerBlock(blockWeaponUpgrade, Names.Blocks.WEAPON_UPGRADE);
    }

    public static void regModels()
    {
        Common.regModel(blockOreMachalite);
        Common.regModel(blockOreEarthCrystal);

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
