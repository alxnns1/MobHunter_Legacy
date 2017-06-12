package alxnns1.mobhunter.capability.quest;

import alxnns1.mobhunter.util.LogHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuestObject implements INBTSerializable<NBTTagCompound>
{
    private MHQuest quest;
    /** The world time at which the quest was started */
    private long startTime = 0;
    private Map<Integer, Integer> progress;

    public MHQuestObject(MHQuest quest)
    {
        this.quest = quest;
        //Init progress map
        int objSize = quest.getObjectives().length;
        progress = new HashMap<Integer, Integer>(objSize);
        for(int i = 0; i < objSize; i++)
            progress.put(i, 0);
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
    public MHQuestObject setStartTime(long time)
    {
        if(startTime <= 0)
            startTime = time;
        return this;
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
        return getStartTime() > 0 && worldTime > getStartTime() + quest.getTimeLimitTicks();
    }

    /**
     * Calculates the time remaining for the quest in minutes
     */
    public int getMinsLeft(long worldTime)
    {
        return (int) ((worldTime - getStartTime()) / 1200L);
    }

    @SideOnly(Side.CLIENT)
    public String getQuestGuiObjProgress()
    {
        Object[] objectives = quest.getObjectives();
        String text = "";

        for(int i = 0; i < objectives.length; i++)
        {
            if(i > 0)
                text += "\n";
            text += progress.get(i) + "/";
            Object object = objectives[i];
            if(object instanceof ItemStack)
            {
                ItemStack stack = (ItemStack) object;
                text += stack.stackSize + " " + I18n.format(stack.getUnlocalizedName() + ".name");
            }
            else if(object instanceof EntityStack)
            {
                EntityStack stack = (EntityStack) object;
                text += stack.getAmount() + " " + stack.getEntityLocName();
            }
        }

        return text;
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
     * Returns amount of progress made.
     */
    public int addProgress(Object objectToProgress)
    {
        //Check the objectToProgress is of the correct instance
        Class storageClass = quest.getQuestType().storageType;
        if(!storageClass.isInstance(objectToProgress))
        {
            LogHelper.error("Tried to add progress to quest with storage class '" + quest.getQuestType().storageType.toString() +
                    "'!\nObject trying to be progressed:\n" + objectToProgress.toString());
            return 0;
        }

        //Increase the progress
        int i = getObjIndex(objectToProgress);
        if(i < 0)
            return 0;
        int currProg = progress.get(i);
        int maxProg = getObjMax(i);
        if(currProg >= maxProg)
            return 0;
        int toProgress = 0;
        if(objectToProgress instanceof ItemStack)
            toProgress = ((ItemStack) objectToProgress).stackSize;
        else if(objectToProgress instanceof EntityStack)
            toProgress = ((EntityStack) objectToProgress).getAmount();
        if(currProg < maxProg)
        {
            toProgress = Math.min(currProg + toProgress, maxProg);
            progress.put(i, toProgress);
            //Return the progress made
            return toProgress - currProg;
        }
        return 0;
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

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setLong("startTime", startTime);
        NBTTagList progressList = new NBTTagList();
        for(Map.Entry<Integer, Integer> entry : progress.entrySet())
        {
            NBTTagCompound e = new NBTTagCompound();
            e.setInteger("key", entry.getKey());
            e.setInteger("value", entry.getValue());
            progressList.appendTag(e);
        }
        tag.setTag("progress", progressList);
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        startTime = nbt.getLong("startTime");
        NBTTagList progressList = nbt.getTagList("progress", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < progressList.tagCount(); i++)
        {
            NBTTagCompound tag = progressList.getCompoundTagAt(i);
            progress.put(tag.getInteger("key"), tag.getInteger("value"));
        }
    }
}
