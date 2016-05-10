package com.alxnns1.mobhunter.block.upgrading;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

/**
 * Created by Mark on 10/05/2016.
 */
public class BlockWeaponUpgrade extends Block
{
    public BlockWeaponUpgrade()
    {
        super(Material.rock);
        setUnlocalizedName(Names.Blocks.WEAPON_UPGRADE);
        setCreativeTab(MobHunter.MH_TAB);
        setHardness(2f);
        setResistance(10f);
    }

    //Used to open the block's GUI
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if(world.isRemote)
            return true;
        //Open crafting gui
        if(!player.isSneaking())
            player.openGui(MobHunter.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
