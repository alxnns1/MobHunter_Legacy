package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import javax.annotation.Nullable;

/**
 * Created by Mark on 10/05/2016.
 */
public class BlockArmourCraft extends BlockCraft
{
    public BlockArmourCraft()
    {
        super();
        setUnlocalizedName(Names.Blocks.ARMOUR_CRAFT);
        setRegistryName(Names.Blocks.ARMOUR_CRAFT);
    }
}
