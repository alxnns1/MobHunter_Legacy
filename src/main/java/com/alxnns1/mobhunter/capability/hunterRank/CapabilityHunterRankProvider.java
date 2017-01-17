package com.alxnns1.mobhunter.capability.hunterRank;

import com.alxnns1.mobhunter.init.MHCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by Mark on 28/06/2016.
 */
public class CapabilityHunterRankProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private IHunterRank hunterRank;

    public CapabilityHunterRankProvider()
    {
        hunterRank = new CapabilityHunterRank();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == MHCapabilities.HUNTER_RANK;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        return hasCapability(capability, facing) ? (T)hunterRank : null;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        return hunterRank.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        hunterRank.deserializeNBT(nbt);
    }
}
