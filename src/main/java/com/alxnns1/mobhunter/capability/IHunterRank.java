package com.alxnns1.mobhunter.capability;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagFloat;

/**
 * Created by Mark on 28/06/2016.
 */
public interface IHunterRank
{
    /**
     * Gets the player's current Hunter Rank.
     * @return Player's Hunter Rank
     */
    float getHunterRank();

    /**
     * Sets the player's Hunter Rank to the value given.
     * @param hunterRank
     */
    void setHunterRank(EntityPlayer player, float hunterRank);

    /**
     * Increases or decreases the player's Hunter Rank by the given amount.
     * @param amount
     */
    void changeHunterRankBy(EntityPlayer player, float amount);

    NBTTagFloat saveNBT();

    void loadNBT(NBTTagFloat tag);

    void dataChanged(EntityPlayer player);
}
