package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Mark on 26/04/2016.
 */
public class BlockBbq extends BlockContainer
{
    public BlockBbq(Material materialIn)
    {
        super(materialIn);
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBbq();
    }

    //Return 3 for standard block models
    public int getRenderType()
    {
        return 3;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(worldIn.isRemote)
            return true;
        Item item = playerIn.getCurrentEquippedItem().getItem();
        if(item.equals(MHItems.itemRawMeat))
        {
            TileBbq te = (TileBbq) worldIn.getTileEntity(pos);
            te.putRawMeat();
            playerIn.getCurrentEquippedItem().stackSize--;
        }
        return true;
    }
}
