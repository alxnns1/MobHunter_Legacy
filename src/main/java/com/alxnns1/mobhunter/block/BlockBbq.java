package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHAchievements;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.Random;

/**
 * Created by Mark on 26/04/2016.
 */
public class BlockBbq extends BlockContainer
{
    public BlockBbq()
    {
        super(Material.ROCK);
        setUnlocalizedName(Names.Blocks.BBQ);
        setCreativeTab(MobHunter.MH_TAB);
        setHardness(2f);
        setResistance(10f);
        //setLightOpacity(0);
    }

    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBbq();
    }

    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    /*
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    */

    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileBbq te = (TileBbq) world.getTileEntity(pos);
        return te == null || !te.isCooking() ? 0 : 14;
    }

    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, @Nullable ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileBbq te = (TileBbq) world.getTileEntity(pos);

        if(heldItem != null && heldItem.getItem().equals(MHItems.itemRawMeat) && !te.isCooking())
        {
            //Try put the raw meat into the bbq spit
            if(te.putRawMeat())
            {
                heldItem.stackSize--;
                return true;
            }
            return false;
        }
        else if(te.isCooking())
        {
            //Try to get the item from the bbq spit
            Item product = te.retrieveItem();
            if(product != null && !world.isRemote)
            {
                //Drop item on the ground
                BlockPos pPos = player.getPosition();
                EntityItem itemDrop = new EntityItem(world, pPos.getX() + 0.5d, pPos.getY() + 0.5d, pPos.getZ() + 0.5d, new ItemStack(product));
                itemDrop.setNoPickupDelay();
                world.spawnEntityInWorld(itemDrop);
                if(product.equals(MHItems.itemDoneSteak))
                    player.addStat(MHAchievements.cookMeat);
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
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        worldIn.checkLightFor(EnumSkyBlock.BLOCK, pos);
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
