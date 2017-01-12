package com.alxnns1.mobhunter.quest.capability;

import com.alxnns1.mobhunter.MobHunter;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by Mark on 12/01/2017.
 */
public class CapabilityQuestProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private IQuests quests;

    public CapabilityQuestProvider()
    {
        quests = new CapabilityQuest();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == MobHunter.CAPABILITY_QUESTS;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        return hasCapability(capability, facing) ? (T) quests : null;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        return quests.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        quests.deserializeNBT(nbt);
    }
}
