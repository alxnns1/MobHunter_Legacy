package alxnns1.mobhunter.capability.monsters;

import alxnns1.mobhunter.init.MHCapabilities;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nullable;

/**
 * Created by Mark on 10/04/2017.
 */
public class CapabilityMonstersProvider implements ICapabilitySerializable<NBTTagCompound>
{
    private IMonsters monsters;

    public CapabilityMonstersProvider()
    {
        monsters = new CapabilityMonsters();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing)
    {
        return capability == MHCapabilities.MONSTERS;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing)
    {
        return hasCapability(capability, facing) ? (T) monsters : null;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        return monsters.serializeNBT();
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        monsters.deserializeNBT(nbt);
    }
}
