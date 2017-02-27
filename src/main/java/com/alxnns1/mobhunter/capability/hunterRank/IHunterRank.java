package com.alxnns1.mobhunter.capability.hunterRank;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * Created by Mark on 28/06/2016.
 */
public interface IHunterRank extends INBTSerializable<NBTTagCompound>
{
    /**
     * Gets the Hunter Rank
     */
    int getRank();

    /**
     * Gets the current progress points towards the next rank
     */
    int getProgressPoints();

    /**
     * Sets the Hunter Rank to the value given
     * Will also set the progress points to 0
     */
    void setRank(EntityPlayerMP player, int hunterRank);

    /**
     * Sets the progress points to the value given
     */
    void setProgressPoints(EntityPlayerMP player, int progressPoints);

    /**
     * Changes the progress points by the given amount
     */
    void changeProgressPointsBy(EntityPlayerMP player, int amount);

    void dataChanged(EntityPlayerMP player, EnumHRDataChange changeType);
}
