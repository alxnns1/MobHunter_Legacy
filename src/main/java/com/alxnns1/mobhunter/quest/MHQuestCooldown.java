package com.alxnns1.mobhunter.quest;

/**
 * Created by Mark on 13/01/2017.
 */
public class MHQuestCooldown
{
    private MHQuest quest;
    private long cooldownStart;

    public MHQuestCooldown(MHQuest quest, long worldTime)
    {
        this.quest = quest;
        cooldownStart = worldTime;
    }

    /**
     * Gets whether enough time has passed for this quest to has finished it's cooldown
     */
    public boolean isCoolEnough(long worldTime)
    {
        return cooldownStart + quest.getTimeLimitTicks() >= worldTime;
    }

    /**
     * Calculates the cooldown time remaining in minutes
     */
    public int getMinsLeft(long worldTime)
    {
        return (int) ((worldTime - cooldownStart) / 1200L);
    }
}
