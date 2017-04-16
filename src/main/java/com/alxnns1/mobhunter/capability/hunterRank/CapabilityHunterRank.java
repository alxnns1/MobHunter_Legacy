package com.alxnns1.mobhunter.capability.hunterRank;

import com.alxnns1.mobhunter.message.MessageCapability;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;

/**
 * Created by Mark on 28/06/2016.
 */
public class CapabilityHunterRank implements IHunterRank
{
    private static final ResourceLocation hunterRankRL = new ResourceLocation(Reference.MOD_ID, "_HunterRank");
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
                //Decrease rank, but don't go lower than HR 1
                if(hunterRank > 1)
                {
                    setRankInternal(hunterRank - 1);
                    progressPoints = HunterRankProgression.getProgressForRank(hunterRank) + progressPoints;
                }
                else
                {
                    progressPoints = 0;
                    break;
                }
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
    public ResourceLocation getKey()
    {
        return hunterRankRL;
    }

    @Override
    public ICapabilityProvider getProvider()
    {
        return new CapabilityHunterRankProvider();
    }

    @Override
    public void dataChanged(EntityPlayerMP player)
    {
        dataChanged(player, EnumHRDataChange.ALL);
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
}
