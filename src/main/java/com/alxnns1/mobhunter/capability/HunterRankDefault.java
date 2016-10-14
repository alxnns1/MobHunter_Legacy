package com.alxnns1.mobhunter.capability;

import com.alxnns1.mobhunter.message.MessageHunterRank;
import com.alxnns1.mobhunter.util.CommonUtil;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by Mark on 28/06/2016.
 */
public class HunterRankDefault implements IHunterRank
{
    private float storedHR;

    public HunterRankDefault()
    {
        storedHR = 1;
    }

    @Override
    public float getHunterRank()
    {
        return storedHR;
    }

    @Override
    public void setHunterRank(EntityPlayer player, float hunterRank)
    {
        if(hunterRank < 1)
        {
            LogHelper.warn("Tried to set the Hunter Rank to a value lower than 1!");
            return;
        }
        storedHR = hunterRank;
        dataChanged(player);
    }

    @Override
    public void changeHunterRankBy(EntityPlayer player, float amount)
    {
        storedHR += amount;
        if(storedHR < 1f) storedHR = 1f;
        dataChanged(player);
    }

    @Override
    public NBTTagFloat saveNBT()
    {
        return (NBTTagFloat) HunterRankStorage.hunterRankStorage.writeNBT(HunterRankProvider.HUNTER_RANK, this, null);
    }

    @Override
    public void loadNBT(NBTTagFloat tag)
    {
        HunterRankStorage.hunterRankStorage.readNBT(HunterRankProvider.HUNTER_RANK, this, null, tag);
    }

    @Override
    public void dataChanged(EntityPlayer player)
    {
        if(player != null && player instanceof EntityPlayerMP)
            CommonUtil.network.sendTo(new MessageHunterRank(saveNBT()), (EntityPlayerMP) player);
    }

    public static class HunterRankStorage implements Capability.IStorage<IHunterRank>
    {
        public static final HunterRankStorage hunterRankStorage = new HunterRankStorage();

        @Override
        public NBTBase writeNBT(Capability<IHunterRank> capability, IHunterRank instance, EnumFacing side)
        {
            return new NBTTagFloat(((HunterRankDefault)instance).storedHR);
        }

        @Override
        public void readNBT(Capability<IHunterRank> capability, IHunterRank instance, EnumFacing side, NBTBase nbt)
        {
            ((HunterRankDefault)instance).storedHR = ((NBTTagFloat)nbt).getFloat();
        }
    }
}
