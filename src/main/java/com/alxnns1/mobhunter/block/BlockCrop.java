package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Alex on 13/01/2017.
 */
public class BlockCrop extends BlockCrops {
    public ItemStack crop;
    public ItemStack seed;

    public BlockCrop(String name, ItemStack cropIn) {
        this(name, cropIn, cropIn);
    }

    public BlockCrop(String name, ItemStack cropIn, ItemStack seedIn) {
        super();
        crop = cropIn;
        seed = seedIn;
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MobHunter.MHBLOCK_TAB);
    }

    protected ItemStack getSeed(IBlockState state) {
        return seed.copy();
    }

    protected ItemStack getCrop(IBlockState state) {
        return crop.copy();
    }

    @Override
    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        java.util.List<ItemStack> ret = new java.util.ArrayList<ItemStack>();
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        for (int i = 0; i < Math.floor(((float) age/(float) getMaxAge())*4) + 1 + fortune; ++i) {
            if(rand.nextDouble() < 0.5){
                ret.add(this.getCrop(state));
            }else{
                ret.add(this.getSeed(state));
            }
        }

        return ret;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return null;//this.isMaxAge(state) ? this.getCrop(state).getItem() : this.getSeed(state).getItem();
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return this.getSeed(state);
    }

    public IBlockState withProperties(int age)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age));
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        int age = meta;
        return this.withProperties(age);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        int age = this.getAge(state);
        return age;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AGE});
    }
}
