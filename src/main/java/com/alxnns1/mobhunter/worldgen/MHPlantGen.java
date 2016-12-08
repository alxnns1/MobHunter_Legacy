package com.alxnns1.mobhunter.worldgen;

import net.minecraft.block.BlockBush;
import net.minecraft.util.math.BlockPos;
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

    private BlockPos getNearestValidPlantPos(World world, BlockPos pos)
    {
        int maxHeight = world.provider.getDimension() == -1 ? 127 : 255;
        int minY = pos.getY() - 10 < 1 ? 1 : pos.getY() - 10;
        int maxY = pos.getY() + 10 > maxHeight ? maxHeight : pos.getY() + 10;
        for(int y = minY; y <= maxY; y++)
        {
            BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
            if(world.isAirBlock(newPos) && world.getBlockState(newPos.down()).isOpaqueCube())
                return newPos;
        }
        return pos;
    }

    public boolean generate(World world, Random rand, BlockPos position)
    {
        boolean isNether = world.provider.getDimension() == -1;
        int maxHeight = isNether ? 127 : 255;

        for (int i = 0; i < size; ++i)
        {
            BlockPos pos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if(world.isAirBlock(pos) && (!world.provider.hasNoSky() || pos.getY() < 255) && block.canBlockStay(world, pos, block.getDefaultState()))
                world.setBlockState(pos, block.getDefaultState(), 2);
            else if(isNether)
            {
                //Finds a suitable y position within 10 blocks up and down (NETHER ONLY)
                int minY = pos.getY() - 10 < 1 ? 1 : pos.getY() - 10;
                int maxY = pos.getY() + 10 > maxHeight ? maxHeight : pos.getY() + 10;
                for(int y = minY; y <= maxY; y++)
                {
                    BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                    if(world.isAirBlock(newPos) && block.canBlockStay(world, newPos, block.getDefaultState()))
                    {
                        world.setBlockState(newPos, block.getDefaultState(), 2);
                        break;
                    }
                }
            }
        }

        return true;
    }
}
