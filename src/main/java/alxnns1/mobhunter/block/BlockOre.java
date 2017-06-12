package alxnns1.mobhunter.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Mark on 21/04/2016.
 */
public class BlockOre extends BlockResource
{
    //The item that this block will drop with mined
    private ItemStack drop;

    public BlockOre(String blockName, int harvestLevel, ItemStack itemDrop)
    {
        this(blockName, harvestLevel);
        drop = itemDrop;
    }

    public BlockOre(String blockName, int harvestLevel)
    {
        super(blockName, harvestLevel);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        //Will return the given item to drop, if set. Otherwise, will just drop the ore block.
        return drop != null ? drop.getItem() : Item.getItemFromBlock(this);
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return drop != null ? drop.getMetadata() : 0;
    }

    /**
     * Get the quantity dropped based on the given fortune level
     */
    public int quantityDroppedWithBonus(int fortune, Random random)
    {
        //This is basically the same as vanilla code
        if (fortune > 0 && drop != null)
        {
            int i = random.nextInt(fortune + 2) - 1;

            if (i < 0)
                i = 0;

            return this.quantityDropped(random) * (i + 1);
        }
        return this.quantityDropped(random);
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (drop != null)
            return MathHelper.getInt(rand, 2, 5); //Same as xp drop from lapis and quartz ores
        return 0;
    }
/*
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        if(state.getBlock().getUnlocalizedName().contains("Light") || state.getBlock().getUnlocalizedName().contains("Ice") || state.getBlock().getUnlocalizedName().contains("Gossamite"))
        LogHelper.info(state.getBlock().getUnlocalizedName() + " > " + pos.toString());
    }*/
}
