package com.alxnns1.mobhunter.capability.hunterRank;

import com.alxnns1.mobhunter.message.MessageHunterRank;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by Mark on 28/06/2016.
 */
public class CapabilityHunterRank implements IHunterRank
{
    private int hunterRank, progressPoints;

    public CapabilityHunterRank()
    {
        hunterRank = 0;
        progressPoints = 0;
    }

    @Override
    public int getRank()
    {
        return hunterRank;
    }

    @Override
    public int getProgressPoints()
    {
        return progressPoints;
    }

    @Override
    public void setRank(EntityPlayerMP player, int hunterRank)
    {
        this.hunterRank = Math.min(hunterRank, 0);
        progressPoints = 0;
        dataChanged(player, EnumHRDataChange.RANK);
    }

    @Override
    public void setProgressPoints(EntityPlayerMP player, int progressPoints)
    {
        this.progressPoints = Math.min(progressPoints, 0);
        dataChanged(player, EnumHRDataChange.PROGRESS);
    }

    @Override
    public void changeHunterRankBy(EntityPlayerMP player, int amount)
    {
        setRank(player, hunterRank + amount);
    }

    @Override
    public void changeProgressPointsBy(EntityPlayerMP player, int amount)
    {
        setProgressPoints(player, progressPoints + amount);
        if(progressPoints < 0)
            changeHunterRankBy(player, -1);
        //TODO: Increase rank when have enough points
        //else if(progressPoints > )
    }

    @Override
    public void dataChanged(EntityPlayerMP player, EnumHRDataChange changeType)
    {
        NBTTagCompound tag = new NBTTagCompound();
        switch(changeType)
        {
            case ALL:
                tag = serializeNBT();
                break;
            case RANK:
                tag.setInteger("rank", hunterRank);
                break;
            case PROGRESS:
                tag.setInteger("progress", progressPoints);
                break;
        }
        CommonUtil.NETWORK.sendTo(new MessageHunterRank(tag), player);
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("rank", hunterRank);
        tag.setInteger("progress", progressPoints);
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        if(nbt.hasKey("rank"))
            hunterRank = nbt.getInteger("rank");
        if(nbt.hasKey("progress"))
            progressPoints = nbt.getInteger("progress");
    }

    public static class Storage implements Capability.IStorage<IHunterRank>
    {
        public static final Storage INSTANCE = new Storage();

        @Override
        public NBTBase writeNBT(Capability<IHunterRank> capability, IHunterRank instance, EnumFacing side)
        {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IHunterRank> capability, IHunterRank instance, EnumFacing side, NBTBase nbt)
        {
            instance.deserializeNBT((NBTTagCompound) nbt);
        }
    }
}
