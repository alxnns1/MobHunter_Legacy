package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Alex on 10/05/2016.
 */
public class BlockBug extends BlockBush {
    public BlockBug(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.BUG);
        this.setBlockBounds(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f);
        this.setCreativeTab(MobHunter.MH_TAB);
    }

    public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state) {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return worldIn.getBiomeGenForCoords(pos).getGrassColorAtPos(pos);
    }
/*
    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        Block blockUnderneath = world.getBlockState(pos.down()).getBlock();
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        for(int n=0;n<RANDOM.nextInt(2)+1+fortune;n++){
            double i = RANDOM.nextDouble();
            if(blockUnderneath.getMaterial()==Material.sand) {
                //On top of sand and gravel
                if (i<) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemHercudrome));
                } else {
                    drops.add(new ItemStack(MHItems.itemRareScarab));
                }
            }else if(blockUnderneath== Blocks.netherrack || blockUnderneath==Blocks.nether_brick || blockUnderneath==Blocks.soul_sand) {
                //On top of nether blocks
                if (i<) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                }
            }else if(blockUnderneath.getMaterial()==Material.snow || blockUnderneath.getMaterial()==Material.craftedSnow || blockUnderneath.getMaterial()==Material.ice || blockUnderneath.getMaterial()==Material.packedIce){
                //On top of snow and ice
                if (i<) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                }
            }else if(blockUnderneath.getMaterial()==Material.rock) {
                //On top of stone and rock material outliers
                if (i<) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                }
            }else{
                //On top of grass and other outliers
                if (i<) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                }
            }
        }
        return drops;
    }
*/
    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Cave;
    }
}
