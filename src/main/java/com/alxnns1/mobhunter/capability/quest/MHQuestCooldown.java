package com.alxnns1.mobhunter.capability.quest;

import com.alxnns1.mobhunter.init.MHQuests;
import net.minecraft.nbt.NBTTagCompound;

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

    public boolean isQuestEqual(MHQuest questIn)
    {
        return quest.isEqual(questIn);
    }

    /**
     * Gets whether enough time has passed for this quest to has finished it's cooldown
     */
    public boolean isCoolEnough(long worldTime)
    {
        return getMinsLeft(worldTime) <= 0;
    }

    /**
     * Calculates the cooldown time remaining in minutes
     */
    public int getMinsLeft(long worldTime)
    {
        return (int) ((cooldownStart + (long) quest.getRepeatCooldown() - worldTime) / 1200L);
    }

    public NBTTagCompound writeToNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("questId", quest.getQuestId());
        tag.setLong("cooldownStart", cooldownStart);
        return tag;
    }

    public static MHQuestCooldown readFromNBT(NBTTagCompound nbt)
    {
        return new MHQuestCooldown(MHQuests.getQuest(nbt.getString("questId")), nbt.getLong("cooldownStart"));
    }
}
