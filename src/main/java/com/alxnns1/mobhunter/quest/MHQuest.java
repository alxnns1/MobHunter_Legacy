package com.alxnns1.mobhunter.quest;

import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuest
{
    private final EnumQuestType questType;
    private final String name;
    private final int points, reqHR, time;
    private boolean repeatable;
    private int repeatCooldown;
    private long startTime = 0;
    private ItemStack[] rewards;

    public MHQuest(EnumQuestType questType, String name, int pointsRewarded, int requiredHR, int timeLimit)
    {
        this.questType = questType;
        this.name = name;
        points = pointsRewarded;
        reqHR = requiredHR;
        time = timeLimit;
        repeatable = false;
    }

    /**
     * Check of this quest is the same as the given one
     */
    public boolean isEqual(MHQuest quest)
    {
        return quest != null && name.equals(quest.name);
    }

    public MHQuest setRepeatable(int cooldown)
    {
        repeatable = true;
        repeatCooldown = cooldown;
        return this;
    }

    /**
     * Whether this quest can be repeated
     */
    public boolean getIsRepeatable()
    {
        return repeatable;
    }

    /**
     * Sets the item rewards for this quest
     */
    public MHQuest setRewardItems(ItemStack... stacks)
    {
        if(stacks != null)
            rewards = stacks.clone();
        return this;
    }

    /**
     * Gets the item rewards for this quest
     */
    public ItemStack[] getRewardItems()
    {
        return rewards.clone();
    }

    /**
     * Gets the cooldown after completing the quest
     * Will be -1 if this quest is not repeatable
     */
    public int getRepeatCooldown()
    {
        return repeatable ? repeatCooldown : -1;
    }

    public EnumQuestType getQuestType()
    {
        return questType;
    }

    public String getUnlocName()
    {
        return name;
    }

    /**
     * Gets the name of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalName()
    {
        return I18n.format(getUnlocName());
    }

    /**
     * Gets the description of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalDesc()
    {
        return I18n.format(getUnlocName() + ".desc");
    }

    /**
     * Gets the objective description of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalObj()
    {
        return I18n.format(getUnlocName() + ".obj");
    }

    /**
     * Gets the reward description of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalRew()
    {
        return I18n.format(getUnlocName() + ".rew");
    }

    /**
     * Gets the amount of Hunter Rank points awarded for completion of the quest
     */
    public int getPointsReward()
    {
        return points;
    }

    /**
     * Gets the amount of Hunter Rank points deducted from the player for failing the quest
     * By default, this is a quarter of the reward points
     */
    public int getPointsPenalty()
    {
        return (int) Math.ceil((float) points / 4f);
    }

    /**
     * Gets the required Hunter Rank to be able to accept this quest
     */
    public int getRequiredHR()
    {
        return reqHR;
    }

    /**
     * Gets the time limit to complete this quest
     */
    public int getTimeLimit()
    {
        return time;
    }

    /**
     * Sets the world time at which the quest was started
     * Used for calculating when a quest expires
     * Can only be set once!
     */
    public void setStartTime(long time)
    {
        if(startTime <= 0)
            startTime = time;
    }

    /**
     * Gets the world time at which the quest was started
     */
    public long getStartTime()
    {
        return startTime;
    }

    /**
     * Calculates if the quest has expired
     * Will return false if a start time has not been set
     */
    public boolean hasQuestExpired(long worldTime)
    {
        return getStartTime() > 0 && getStartTime() + (long) getTimeLimit() > worldTime;
    }
}
