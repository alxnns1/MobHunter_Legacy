package alxnns1.mobhunter.worldgen;

import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
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

    private boolean canPlace(World world, BlockPos pos)
    {
        return (world.isAirBlock(pos) || world.getBlockState(pos).getBlock().isReplaceable(world, pos)) && block.canBlockStay(world, pos, block.getDefaultState());
    }

    public boolean generate(World world, Random rand, BlockPos position)
    {
        boolean isNether = world.provider.getDimension() == -1;
        int maxHeight = isNether ? 127 : 255;

        int numToSpawn = Math.max(1, size + rand.nextInt(3) - 1);
        for (int i = 0; i < numToSpawn; ++i)
        {
            BlockPos pos = position.add(rand.nextInt(5) - 2, 0, rand.nextInt(5) - 2);
            if(world.getBlockState(pos.down()).getBlock() == Blocks.SNOW_LAYER)
                pos = pos.down();

            if(!isNether)
            {
                for(int y = 2; y >= - 2; y--)
                {
                    BlockPos newPos = pos.add(0, y, 0);
                    if(canPlace(world, newPos) && world.setBlockState(newPos, block.getDefaultState(), 2)) break;
                }
            }
            else
            {
                //Finds a suitable y position within 10 blocks up and down (NETHER ONLY)
                int minY = pos.getY() - 10 < 1 ? 1 : pos.getY() - 10;
                int maxY = pos.getY() + 10 > maxHeight ? maxHeight : pos.getY() + 10;
                for(int y = minY; y <= maxY; y++)
                {
                    BlockPos newPos = new BlockPos(pos.getX(), y, pos.getZ());
                    if(canPlace(world, newPos) && world.setBlockState(newPos, block.getDefaultState(), 2))
                        break;
                }
            }
        }

        return true;
    }
}
