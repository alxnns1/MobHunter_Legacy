package com.alxnns1.mobhunter.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by Mark on 28/06/2016.
 */
public class HunterRankProvider implements ICapabilitySerializable<NBTTagFloat>
{
    @CapabilityInject(IHunterRank.class)
    public static Capability<IHunterRank> HUNTER_RANK = null;

    private IHunterRank hunterRank = null;

    public HunterRankProvider()
    {
        hunterRank = new HunterRankDefault();
    }

    public static IHunterRank get(EntityPlayer player)
    {
        return player != null && player.hasCapability(HUNTER_RANK, null) ? player.getCapability(HUNTER_RANK, null) : null;
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return HUNTER_RANK != null && capability == HUNTER_RANK;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        return hasCapability(capability, facing) ? (T)hunterRank : null;
    }

    @Override
    public NBTTagFloat serializeNBT()
    {
        return hunterRank.saveNBT();
    }

    @Override
    public void deserializeNBT(NBTTagFloat nbt)
    {
        hunterRank.loadNBT(nbt);
    }
}
