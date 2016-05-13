package com.alxnns1.mobhunter.block.upgrading;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Mark on 10/05/2016.
 */
public class ContainerWeaponUpgrade extends Container
{
    //TODO: Finish container for gui

    public ContainerWeaponUpgrade(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        this(invPlayer, world, new BlockPos(x, y, z));
    }

    public ContainerWeaponUpgrade(InventoryPlayer invPlayer, World world, BlockPos position)
    {

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return false;
    }
}
