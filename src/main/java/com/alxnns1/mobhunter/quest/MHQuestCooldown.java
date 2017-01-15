package com.alxnns1.mobhunter.quest;

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

    /**
     * Gets whether enough time has passed for this quest to has finished it's cooldown
     */
    public boolean isCoolEnough(long worldTime)
    {
        return worldTime >= cooldownStart + quest.getRepeatCooldown();
    }

    /**
     * Calculates the cooldown time remaining in minutes
     */
    public int getMinsLeft(long worldTime)
    {
        return (int) ((worldTime - cooldownStart + (long) quest.getRepeatCooldown()) / 1200L);
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
