package com.alxnns1.mobhunter.worldgen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

/**
 * Created by Mark on 04/05/2016.
 */
public class MHPlantGen extends WorldGenerator
{
    private BlockBush block;
    private int size;

    public MHPlantGen(BlockBush blockToSpawn)
    {
        this(blockToSpawn, 4);
    }

    public MHPlantGen(BlockBush blockToSpawn, int groupSize)
    {
        block = blockToSpawn;
        size = groupSize;
    }

    public boolean generate(World world, Random rand, BlockPos position)
    {
        for (int i = 0; i < size; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (world.isAirBlock(blockpos) && (!world.provider.getHasNoSky() || blockpos.getY() < 255) && this.block.canBlockStay(world, blockpos, this.block.getDefaultState()))
            {
                world.setBlockState(blockpos, this.block.getDefaultState(), 2);
            }
        }

        return true;
    }
}
