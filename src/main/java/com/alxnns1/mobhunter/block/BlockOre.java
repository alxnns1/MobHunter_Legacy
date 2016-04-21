package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * Created by Mark on 21/04/2016.
 */
public class BlockOre extends Block
{
    public BlockOre(String blockName)
    {
        super(Material.rock);
        setUnlocalizedName(blockName);
        setCreativeTab(MobHunter.MH_TAB);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundTypePiston);
    }


}
