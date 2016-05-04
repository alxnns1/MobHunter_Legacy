package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Alex on 04/05/2016.
 */
public class BlockShroom extends BlockBush {
    public BlockShroom(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.SHROOM);
        this.setBlockBounds(0.2f, 0.0f, 0.2f, 0.8f, 0.7f, 0.8f);
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
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        for(int n=0;n<RANDOM.nextInt(2)+1+fortune;n++){
            int i = RANDOM.nextInt(5);
            if(i==0) {
                drops.add(new ItemStack(MHItems.itemBlueMushroom));
            }else if(i==1){
                drops.add(new ItemStack(MHItems.itemNitroshroom));
            }else if(i==2){
                drops.add(new ItemStack(MHItems.itemParashroom));
            }else if(i==3){
                drops.add(new ItemStack(MHItems.itemToadstool));
            }else if(i==4){
                drops.add(new ItemStack(MHItems.itemExciteshroom));
            }else {
                drops.add(new ItemStack(MHItems.itemDragonToadstool));
            }
        }
        return drops;
    }
}
