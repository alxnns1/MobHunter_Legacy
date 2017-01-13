package com.alxnns1.mobhunter.quest;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuestObject
{
    private MHQuest quest;
    /** The world time at which the quest was started */
    private long startTime = 0;
    private Map<Integer, Integer> progress;

    public MHQuestObject(MHQuest quest)
    {
        this.quest = quest;
        progress = new HashMap<Integer, Integer>();
    }

    public MHQuest getQuest()
    {
        return quest;
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
        return getStartTime() > 0 && getStartTime() + quest.getTimeLimitTicks() > worldTime;
    }

    /**
     * Calculates the time remaining for the quest in minutes
     */
    public int getMinsLeft(long worldTime)
    {
        return (int) ((worldTime - getStartTime()) / 1200L);
    }

    /**
     * Gets the index of the object in the quest's objectives array
     * Returns -1 if not found
     */
    private int getObjIndex(Object object)
    {
        Class storageClass = quest.getQuestType().storageType;
        Object[] objectives = quest.getObjectives();
        for(int i = 0; i < quest.getObjectives().length; i++)
        {
            if(storageClass == ItemStack.class)
            {
                if(((ItemStack) objectives[i]).isItemEqual((ItemStack) object)) return i;
            }
            else if(storageClass == EntityStack.class)
            {
                if(((EntityStack) objectives[i]).isEqualTo((EntityStack) object)) return i;
            }
            else
                throw new RuntimeException("Unhandled Quest Type! -> " + storageClass.toString());
        }
        return -1;
    }

    /**
     * Get the max amount for an objective at the given index
     */
    private int getObjMax(int index)
    {
        Class storageClass = quest.getQuestType().storageType;
        Object obj = quest.getObjectives()[index];
        if(storageClass == ItemStack.class)
            return ((ItemStack) obj).stackSize;
        else if(storageClass == EntityStack.class)
            return ((EntityStack) obj).getAmount();
        else
            throw new RuntimeException("Unhandled Quest Type! -> " + storageClass.toString());
    }

    /**
     * Tries to progress the quest using the given Object.
     * Returns is any progress was made.
     */
    public boolean addProgress(Object objectToProgress)
    {
        //Check the objectToProgress is of the correct instance
        Class storageClass = quest.getQuestType().storageType;
        if(!storageClass.isInstance(objectToProgress))
            LogHelper.error("Tried to add progress to quest with storage class '" + quest.getQuestType().storageType.toString() +
                    "'!\nObject trying to be progressed:\n" + objectToProgress.toString());

        //Increase the progress if not already at max
        int i = getObjIndex(objectToProgress);
        if(i < 0) return false;
        int currProg = progress.get(i);
        int maxProg = getObjMax(i);
        if(currProg < maxProg)
        {
            progress.put(i, ++ currProg);
            return true;
        }
        return false;
    }

    /**
     * Checks if the quest has been completed
     */
    public boolean isCompleted()
    {
        for(int i = 0; i < quest.getObjectives().length; i++)
            if(progress.get(i) < getObjMax(i))
                return false;
        return true;
    }
}
