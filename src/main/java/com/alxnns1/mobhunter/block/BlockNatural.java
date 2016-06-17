package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.EnumPlantType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mark on 17/06/2016.
 */
public class BlockNatural extends BlockBush
{
    private AxisAlignedBB BLOCK_BOUNDS;

    public BlockNatural(String name, AxisAlignedBB blockBounds)
    {
        super(Material.VINE);
        setCreativeTab(MobHunter.MH_TAB);
        setUnlocalizedName(name);
        setRegistryName(name);
        BLOCK_BOUNDS = blockBounds;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return BLOCK_BOUNDS;
    }

    @Override
    public boolean isReplaceable(IBlockAccess world, BlockPos pos)
    {
        return false;
    }

    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Cave;
    }

    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        return drops;
    }

    public ArrayList<ItemStack> getDropsCold(ArrayList<ItemStack> drops, double chance)
    {
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        return drops;
    }

    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune)
    {
        Biome biome = world.getBiomeGenForCoords(pos);
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        Random rand = world instanceof World ? ((World)world).rand : RANDOM;
        for(int n = 0; n < rand.nextInt(2) + 1 + fortune; n++)
        {
            double i = rand.nextDouble();
            if(blockstate.getMaterial() == Material.SAND)       this.getDropsSand(drops, i);
            else if(biome.getBiomeName().equals("Hell"))        this.getDropsNether(drops, i);
            else if(biome.getTemperature() < 0.2f)              this.getDropsCold(drops, i);
            else if(blockstate.getMaterial() == Material.ROCK)  this.getDropsRock(drops, i);
            else                                                this.getDropsOther(drops, i);
        }
        return drops;
    }
}
