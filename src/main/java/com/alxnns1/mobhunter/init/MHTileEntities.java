package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by Mark on 26/04/2016.
 */
public class MHTileEntities
{
    public static void init()
    {
        GameRegistry.registerTileEntity(TileBbq.class, Names.Blocks.BBQ);
    }
}
