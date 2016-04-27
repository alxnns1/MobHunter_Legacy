package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by Mark on 26/04/2016.
 */
public class BlockBbq extends BlockContainer
{
    public BlockBbq()
    {
        super(Material.rock);
        setUnlocalizedName(Names.Blocks.BBQ);
        setCreativeTab(MobHunter.MH_TAB);
        setLightOpacity(0);
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBbq();
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    /*
    public boolean isFullCube()
    {
        return false;
    }
    */

    //Return 3 for standard block models
    public int getRenderType()
    {
        return 3;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileBbq te = (TileBbq) worldIn.getTileEntity(pos);

        if(playerIn.getCurrentEquippedItem() != null && playerIn.getCurrentEquippedItem().getItem().equals(MHItems.itemRawMeat) && !te.isCooking())
        {
            //Try put the raw meat into the bbq spit
            if(te.putRawMeat())
            {
                playerIn.getCurrentEquippedItem().stackSize--;
                LogHelper.info("Inserting Raw Meat");
                return true;
            }
            return false;
        }
        else if(te.isCooking())
        {
            //Try to get the item from the bbq spit
            Item product = te.retrieveItem();
            if(product != null && !worldIn.isRemote)
            {
                //Drop item on the ground
                BlockPos dropPos = pos.offset(side);
                EntityItem itemDrop = new EntityItem(worldIn, dropPos.getX() + 0.5d, dropPos.getY() + 0.5d, dropPos.getZ() + 0.5d, new ItemStack(product));
                worldIn.spawnEntityInWorld(itemDrop);
                return true;
            }
        }
        return false;
    }

    private void spawnParticle(World world, BlockPos pos, Random rand, boolean isFire)
    {
        double x = pos.getX() + 0.375d + (rand.nextDouble() * 0.25d);
        double y = pos.getY() + 0.25d + (rand.nextDouble() * 0.125d);
        double z = pos.getZ() + 0.375d + (rand.nextDouble() * 0.25d);
        EnumParticleTypes type;
        if(isFire)
            type = EnumParticleTypes.FLAME;
        else
            type = EnumParticleTypes.SMOKE_NORMAL;
        world.spawnParticle(type, x, y, z, 0, 0, 0, new int[0]);
    }

    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        //This is where the particles are spawned when cooking
        boolean cooking = ((TileBbq) worldIn.getTileEntity(pos)).isCooking();
        if(cooking)
        {
            //Spawns between 1 and 5 fire particles
            for(int i = 0; i < rand.nextInt(4); i++)
            {
                spawnParticle(worldIn, pos, rand, true);
            }
            //Spawns between 0 and 3 smoke particles
            for(int i = 1; i < rand.nextInt(4); i++)
            {
                spawnParticle(worldIn, pos, rand, false);
            }
        }
    }
}
