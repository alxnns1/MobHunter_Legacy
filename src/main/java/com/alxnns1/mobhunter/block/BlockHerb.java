package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
 * Created by Alex on 03/05/2016.
 */
public class BlockHerb extends BlockBush {
    public BlockHerb(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.HERB);
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

    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        Block blockUnderneath = world.getBlockState(pos.down()).getBlock();

        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        for(int n=0;n<RANDOM.nextInt(4)+1+fortune;n++){
            int i = RANDOM.nextInt(5);
            if(i==0) {
                drops.add(new ItemStack(MHItems.itemHerb));
            }else if(i==1){
                drops.add(new ItemStack(MHItems.itemAntidoteHerb));
            }else if(i==2){
                drops.add(new ItemStack(MHItems.itemSleepHerb));
            }else if(i==3){
                drops.add(new ItemStack(MHItems.itemSapPlant));
            }else if(i==4){
                drops.add(new ItemStack(MHItems.itemFireHerb));
            }else {
                drops.add(new ItemStack(MHItems.itemHotPepper));
            }
        }
        return drops;
    }

    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Cave;
    }
}
