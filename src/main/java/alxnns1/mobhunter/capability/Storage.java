package alxnns1.mobhunter.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by Mark on 10/04/2017.
 */
public class Storage<T extends ICapability> implements Capability.IStorage<T>
{
    @Override
    public NBTBase writeNBT(Capability<T> capability, T instance, EnumFacing side)
    {
        return instance.serializeNBT();
    }

    @Override
    public void readNBT(Capability<T> capability, T instance, EnumFacing side, NBTBase nbt)
    {
        instance.deserializeNBT((NBTTagCompound) nbt);
    }
}
