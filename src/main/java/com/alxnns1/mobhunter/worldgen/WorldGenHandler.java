package com.alxnns1.mobhunter.worldgen;

import com.alxnns1.mobhunter.init.MHBlocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * This class is used to handle all of the world generation code.
 * Created by Mark on 21/04/2016.
 */
public class WorldGenHandler implements IWorldGenerator
{
    //WorldGenMineable(block state, number of blocks to spawn)
    WorldGenMinable oreEarthCrystal = new WorldGenMinable(MHBlocks.blockOreEarthCrystal.getDefaultState(), 4);
    WorldGenMinable oreMachalite = new WorldGenMinable(MHBlocks.blockOreMachalite.getDefaultState(), 2);
    WorldGenMinable oreDragonite = new WorldGenMinable(MHBlocks.blockOreDragonite.getDefaultState(), 1);

    MHPlantGen bushHerb = new MHPlantGen(MHBlocks.blockHerb);
    MHPlantGen bushShroom = new MHPlantGen(MHBlocks.blockShroom);
    MHPlantGen bushBerry = new MHPlantGen(MHBlocks.blockBerry);
    MHPlantGen bushBug = new MHPlantGen(MHBlocks.blockBug);
    MHPlantGen bushBone = new MHPlantGen(MHBlocks.blockBone);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.getDimensionId())
        {
            case -1:
                //Nether
                genNether(world, random, chunkX,  chunkZ);
                break;
            case 1:
                //End
                genEnd(world, random, chunkX,  chunkZ);
                break;
            default:
                //Overworld and whatever else
                genOverworld(world, random, chunkX, chunkZ);
                break;
        }
    }

    private BlockPos getRandXZInChunk(Random random, int chunkX, int chunkZ)
    {
        return getRandXZInChunk(random, chunkX, 0, chunkZ);
    }

    private BlockPos getRandXZInChunk(Random random, int chunkX, int y, int chunkZ)
    {
        return new BlockPos(chunkX * 16 + random.nextInt(16), y, chunkZ * 16 + random.nextInt(16));
    }

    private void genOverworld(World world, Random random, int chunkX, int chunkZ)
    {
        genOre(world, random, chunkX, chunkZ, 15, oreEarthCrystal, 0, 128);
        genOre(world, random, chunkX, chunkZ, 15, oreMachalite, 0, 64);
        genOre(world, random, chunkX, chunkZ, 10, oreDragonite, 0, 64);

        bushHerb.generate(world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        bushShroom.generate(world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        bushBerry.generate(world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        bushBug.generate(world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        bushBone.generate(world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
    }

    private void genNether(World world, Random random, int chunkX, int chunkZ)
    {
        bushHerb.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        bushShroom.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        bushBerry.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        bushBug.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        bushBone.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
    }

    private void genEnd(World world, Random random, int chunkX, int chunkZ)
    {
        //bushBone.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
    }

    /**
     * Generates ores into the world
     * @param world World object
     * @param random Random object
     * @param chunkX Chunk X coord
     * @param chunkZ Chunk Z coord
     * @param genCount How many veins to generate per chunk
     * @param generator The WorldGenMinable object for the ore
     * @param minHeight The minimum height the veins will spawn at
     * @param maxHeight The maximum height the veins will spawn at
     */
    private void genOre(World world, Random random, int chunkX, int chunkZ, int genCount, WorldGenMinable generator, int minHeight, int maxHeight)
    {
        //Some vanilla checks for the height limits
        if (maxHeight < minHeight)
        {
            int i = minHeight;
            minHeight = maxHeight;
            maxHeight = i;
        }
        else if (maxHeight == minHeight)
        {
            if (minHeight < 255)
            {
                ++maxHeight;
            }
            else
            {
                --minHeight;
            }
        }

        for(int i = 0; i < genCount; i++)
        {
            //Creates random position in chunk for vein
            BlockPos pos = getRandXZInChunk(random, chunkX, chunkZ).add(0, random.nextInt(maxHeight - minHeight) + minHeight, 0);
            //Generates vein
            generator.generate(world, random, pos);
        }
    }
}
