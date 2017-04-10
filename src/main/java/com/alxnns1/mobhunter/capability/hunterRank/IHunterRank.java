package com.alxnns1.mobhunter.capability.hunterRank;

import com.alxnns1.mobhunter.capability.ICapability;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * Created by Mark on 28/06/2016.
 */
public interface IHunterRank extends ICapability
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
     * Change the hunter rank by the given amount
     */
    void changeRankBy(EntityPlayerMP player, int amount);

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
