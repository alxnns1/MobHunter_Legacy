package alxnns1.mobhunter.worldgen;

import alxnns1.mobhunter.init.MHBlocks;
import alxnns1.mobhunter.reference.MHConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

/**
 * This class is used to handle all of the world generation code.
 * Created by Mark on 21/04/2016.
 */
public class WorldGenHandler implements IWorldGenerator
{
    //WorldGenMineable(block state, number of blocks to spawn)
    private WorldGenMinable oreEarthCrystal = new WorldGenMinable(MHBlocks.blockOreEarthCrystal.getDefaultState(), 10);
    private WorldGenMinable oreMachalite = new WorldGenMinable(MHBlocks.blockOreMachalite.getDefaultState(), 8);
    private WorldGenMinable oreDragonite = new WorldGenMinable(MHBlocks.blockOreDragonite.getDefaultState(), 6);
    private WorldGenMinable oreLightCrystal = new WorldGenMinable(MHBlocks.blockOreLightCrystal.getDefaultState(), 5);
    private WorldGenMinable oreIceCrystal = new WorldGenMinable(MHBlocks.blockOreIceCrystal.getDefaultState(), 10);
    private WorldGenMinable oreGossamite = new WorldGenMinable(MHBlocks.blockOreGossamite.getDefaultState(), 4);

    private MHPlantGen bushHerb = new MHPlantGen(MHBlocks.blockHerb);
    private MHPlantGen bushShroom = new MHPlantGen(MHBlocks.blockShroom);
    private MHPlantGen bushBerry = new MHPlantGen(MHBlocks.blockBerry);
    private MHPlantGen bushBug = new MHPlantGen(MHBlocks.blockBug);
    private MHPlantGen bushBone = new MHPlantGen(MHBlocks.blockBone);

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        int dimId = world.provider.getDimension();
        for(int id : MHConfig.plantGenDimIDs)
        {
            if(dimId == id)
            {
                switch(dimId)
                {
                    case -1: //Nether
                        genNether(world, random, chunkX,  chunkZ);
                        break;
                    case 1: //End
                        genEnd(world, random, chunkX,  chunkZ);
                        break;
                    default: //Overworld and other dimensions in the config
                        genOverworld(world, random, chunkX, chunkZ);
                }
                break;
            }
        }
    }

    private BlockPos getRandXZInChunk(Random random, int chunkX, int chunkZ)
    {
        return getRandXZInChunk(random, chunkX, 0, chunkZ);
    }

    private BlockPos getRandXZInChunk(Random random, int chunkX, int y, int chunkZ)
    {
        return new BlockPos(chunkX * 16 + random.nextInt(12) + 2, y, chunkZ * 16 + random.nextInt(12) + 2);
    }

    private void genOverworld(World world, Random random, int chunkX, int chunkZ)
    {
        genOre(world, random, chunkX, chunkZ, 16, oreEarthCrystal, 0, 128);
        genOre(world, random, chunkX, chunkZ, 12, oreMachalite, 0, 64);
        genOre(world, random, chunkX, chunkZ, 8, oreDragonite, 0, 64);
        genOre(world, random, chunkX, chunkZ, 8, oreLightCrystal, 96, 160);
        genOre(world, random, chunkX, chunkZ, 16, oreIceCrystal, 0, 64, BiomeDictionary.Type.COLD);
        genOre(world, random, chunkX, chunkZ, 8, oreGossamite, 96, 160);

        genBush(bushHerb, world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        genBush(bushShroom, world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        genBush(bushBerry, world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        genBush(bushBug, world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
        genBush(bushBone, world, random, world.getHeight(getRandXZInChunk(random, chunkX, chunkZ)));
    }

    private void genNether(World world, Random random, int chunkX, int chunkZ)
    {
        genBush(bushHerb, world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        genBush(bushShroom, world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        genBush(bushBerry, world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        genBush(bushBug, world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
        genBush(bushBone, world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
    }

    private void genEnd(World world, Random random, int chunkX, int chunkZ)
    {
        //bushBone.generate(world, random, getRandXZInChunk(random, chunkX, random.nextInt(128), chunkZ));
    }

    private void genBush(WorldGenerator generator, World world, Random random, BlockPos pos)
    {
        if(random.nextInt(5) == 0)
            generator.generate(world, random, pos);
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
        if(maxHeight < minHeight)
        {
            int i = minHeight;
            minHeight = maxHeight;
            maxHeight = i;
        }
        else if(maxHeight == minHeight)
        {
            if(minHeight < 255)
                ++maxHeight;
            else
                --minHeight;
        }

        for(int i = 0; i < genCount; i++)
        {
            //Creates random position in chunk for vein
            BlockPos pos = getRandXZInChunk(random, chunkX, random.nextInt(maxHeight - minHeight) + minHeight, chunkZ);
            //Generates vein
            generator.generate(world, random, pos);
        }
    }

    /**
     * Generates ores into the world dependant on biomes
     * @param world World object
     * @param random Random object
     * @param chunkX Chunk X coord
     * @param chunkZ Chunk Z coord
     * @param genCount How many veins to generate per chunk
     * @param generator The WorldGenMinable object for the ore
     * @param minHeight The minimum height the veins will spawn at
     * @param maxHeight The maximum height the veins will spawn at
     * @param biomes The biomes the veins will spawn in
     */
    private void genOre(World world, Random random, int chunkX, int chunkZ, int genCount, WorldGenMinable generator, int minHeight, int maxHeight, BiomeDictionary.Type... biomes)
    {
        //Some vanilla checks for the height limits
        if(maxHeight < minHeight)
        {
            int i = minHeight;
            minHeight = maxHeight;
            maxHeight = i;
        }
        else if(maxHeight == minHeight)
        {
            if(minHeight < 255)
                ++maxHeight;
            else
                --minHeight;
        }

        for(int i = 0; i < genCount; i++)
        {
            //Creates random position in chunk for vein
            BlockPos pos = getRandXZInChunk(random, chunkX, random.nextInt(maxHeight - minHeight) + minHeight, chunkZ);
            //Generates vein
            for(BiomeDictionary.Type biome : biomes)
                if(BiomeDictionary.hasType(world.getBiome(pos),biome))
                    generator.generate(world, random, pos);
        }
    }
}
