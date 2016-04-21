package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Mark on 21/04/2016.
 */
public class BlockOre extends Block
{
    //The item that this block will drop with mined
    private Item drop;

    public BlockOre(String blockName, Item itemDrop)
    {
        this(blockName);
        drop = itemDrop;
    }

    public BlockOre(String blockName)
    {
        super(Material.rock);
        setUnlocalizedName(blockName);
        setCreativeTab(MobHunter.MH_TAB);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(soundTypePiston);
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        //Will return the given item to drop, if set. Otherwise, will just drop the ore block.
        return drop != null ? drop : Item.getItemFromBlock(this);
    }

    /**
     * Gets the metadata of the item this Block can drop. This method is called when the block gets destroyed. It
     * returns the metadata of the dropped item based on the old metadata of the block.
     */
    public int damageDropped(IBlockState state)
    {
        return 0;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        //Always drops 1 item without fortune
        return 1;
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
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }

    @Override
    public int getExpDrop(net.minecraft.world.IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (drop != null)
            return MathHelper.getRandomIntegerInRange(rand, 2, 5); //Same as xp drop from lapis and quartz ores
        return 0;
    }
}
