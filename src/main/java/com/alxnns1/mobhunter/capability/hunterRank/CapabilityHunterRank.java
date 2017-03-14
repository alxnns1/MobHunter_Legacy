package com.alxnns1.mobhunter.capability.hunterRank;

import com.alxnns1.mobhunter.message.MessageCapability;
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

    /**
     * Sets the Hunter Rank without calling dataChanged
     */
    private void setRankInternal(int hunterRank)
    {
        this.hunterRank = Math.max(hunterRank, 0);
    }

    @Override
    public void setRank(EntityPlayerMP player, int hunterRank)
    {
        setRankInternal(hunterRank);
        boolean pointsChanged = false;
        if(progressPoints != 0)
        {
            setProgressPointsInternal(0);
            pointsChanged = true;
        }

        dataChanged(player, pointsChanged ? EnumHRDataChange.ALL : EnumHRDataChange.RANK);
    }

    @Override
    public void changeRankBy(EntityPlayerMP player, int amount)
    {
        setRank(player, hunterRank + amount);
    }

    /**
     * Sets the progress points without calling dataChanged
     */
    private void setProgressPointsInternal(int progressPoints)
    {
        this.progressPoints = Math.min(Math.max(progressPoints, 0), HunterRankProgression.getProgressForRank(hunterRank) - 1);
    }

    @Override
    public void setProgressPoints(EntityPlayerMP player, int progressPoints)
    {
        setProgressPointsInternal(progressPoints);
        dataChanged(player, EnumHRDataChange.PROGRESS);
    }

    @Override
    public void changeProgressPointsBy(EntityPlayerMP player, int amount)
    {
        progressPoints += amount;
        int oldRank = hunterRank;

        if(progressPoints < 0)
        {
            while(progressPoints < 0)
            {
                //Decrease rank
                setRankInternal(hunterRank - 1);
                progressPoints = HunterRankProgression.getProgressForRank(hunterRank) + progressPoints;
            }
        }
        else
        {
            int maxProgress = HunterRankProgression.getProgressForRank(hunterRank);
            while(progressPoints >= maxProgress)
            {
                //Increase Rank
                progressPoints -= maxProgress;
                setRankInternal(hunterRank + 1);
                maxProgress = HunterRankProgression.getProgressForRank(hunterRank);
            }
        }

        dataChanged(player, hunterRank != oldRank ? EnumHRDataChange.ALL : EnumHRDataChange.PROGRESS);
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
        CommonUtil.NETWORK.sendTo(new MessageCapability(MessageCapability.EnumCapability.HUNTER_RANK, tag), player);
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
