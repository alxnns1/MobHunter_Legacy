package com.alxnns1.mobhunter.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import java.util.Random;

/**
 * Created by Mark on 21/04/2016.
 */
public class BlockOreGem extends BlockOre
{
    private Item drop;

    public BlockOreGem(String blockName, Item itemDrop)
    {
        super(blockName);
        drop = itemDrop;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return drop;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random random)
    {
        return 1;
    }
}
