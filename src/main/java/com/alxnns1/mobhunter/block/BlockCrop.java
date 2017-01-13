package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Alex on 13/01/2017.
 */
public class BlockCrop extends BlockCrops {
    public static final PropertyEnum<EnumMHCrop> TYPE = PropertyEnum.<EnumMHCrop>create("type", EnumMHCrop.class);

    public BlockCrop() {
        super();
    }

    protected Item getSeed(IBlockState state) {
        return Items.WHEAT_SEEDS;
    }

    protected Item getCrop(IBlockState state) {
        return Items.WHEAT;
    }

    @Override
    public java.util.List<ItemStack> getDrops(net.minecraft.world.IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        java.util.List<ItemStack> ret = super.getDrops(world, pos, state, fortune);
        int age = getAge(state);
        Random rand = world instanceof World ? ((World)world).rand : new Random();

        if (age >= getMaxAge()) {
            int k = 3 + fortune;

            for (int i = 0; i < 3 + fortune; ++i) {
                if (rand.nextInt(2 * getMaxAge()) <= age) {
                    ret.add(new ItemStack(this.getSeed(state), 1, 0));
                }
            }
        }
        return ret;
    }

    /**
     * Get the Item that this Block should drop when harvested.
     */
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return this.isMaxAge(state) ? this.getCrop(state) : this.getSeed(state);
    }

    @Override
    public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
        return new ItemStack(this.getSeed(state));
    }

    protected PropertyEnum getTypeProperty() {
        return TYPE;
    }

    protected int getType(IBlockState state) {
        return ((EnumMHCrop)state.getValue(this.getTypeProperty())).ordinal();
    }

    public IBlockState withProperties(int age, EnumMHCrop type)
    {
        return this.getDefaultState().withProperty(this.getAgeProperty(), Integer.valueOf(age)).withProperty(this.getTypeProperty(), type);
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        int typeOrdinal = (int) Math.floor((double) meta/8);
        int age = meta - (typeOrdinal*8);
        EnumMHCrop type = EnumMHCrop.values()[typeOrdinal];
        return this.withProperties(age, type);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        int age = this.getAge(state);
        int type = this.getType(state)*8;
        return type+age;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] {AGE, TYPE});
    }

    public enum EnumMHCrop implements IStringSerializable{
        HERB,
        ANTIDOTE_HERB,
        FIRE_HERB,
        IVY,
        SLEEP_HERB,
        SAP_PLANT,
        FELVINE,
        GLOAMGRASS_ROOT,
        GLOAMGRASS_BUD,
        HOT_PEPPER,
        BLUE_MUSHROOM,
        NITROSHROOM,
        PARASHROOM,
        TOADSTOOL,
        EXCITESHROOM,
        MOPESHROOM,
        DRAGON_TOADSTOOL,
        HUSKBERRY,
        PAINTBERRY,
        MIGHT_SEED,
        ADAMANT_SEED,
        NULBERRY,
        DRAGONFELL_BERRY,
        SCATTERNUT,
        NEEDLEBERRY,
        LATCHBERRY,
        BOMBERRY;

        public String getName(){
            return toString();
        }
    }
}
