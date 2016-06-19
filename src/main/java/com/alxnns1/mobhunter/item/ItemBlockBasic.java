package com.alxnns1.mobhunter.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

/**
 * Created by Mark on 19/06/2016.
 */
public class ItemBlockBasic extends ItemBlock
{
    public ItemBlockBasic(Block block)
    {
        super(block);
        setRegistryName(block.getRegistryName());
    }
}
