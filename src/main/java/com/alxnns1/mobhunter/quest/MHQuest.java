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
    /** Unlocalised name for the quest */
    private final String name;
    private final int points, reqHR, time;
    /** Whether the quest is repeatable */
    private boolean repeatable;
    /** Cooldown to being able to accept the quest again once it's been completed */
    private int repeatCooldown;
    private Object[] objectives;
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
     * Check if this quest is the same as the given one
     */
    public boolean isEqual(MHQuest quest)
    {
        return quest != null && name.equals(quest.name);
    }

    public MHQuest setObjectives(Object... objectives)
    {
        if(!questType.storageType.isInstance(objectives.getClass()))
            throw new IllegalArgumentException("Objectives are not an array of the required class: " + questType.storageType.toString());
        this.objectives = objectives;
        return this;
    }

    public Object[] getObjectives()
    {
        return objectives != null ? objectives.clone() : null;
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
    public MHQuest setRewardItems(ItemStack... rewards)
    {
        this.rewards = rewards;
        return this;
    }

    /**
     * Gets the item rewards for this quest
     */
    public ItemStack[] getRewardItems()
    {
        return rewards.clone();
    }

    private String getListText(Object[] objList)
    {
        if(objList == null || objList.length == 0)
            return "Null List";
        String text = "";
        for(int i = 0; i < objList.length; i++)
        {
            Object object = objList[i];
            if(i > 0)
                text += ", ";
            if(object instanceof ItemStack)
            {
                ItemStack stack = (ItemStack) object;
                text += stack.stackSize + "x " + stack.getDisplayName();
            }
            else if(object instanceof EntityStack)
            {
                EntityStack stack = (EntityStack) object;
                text += stack.getAmount() + "x " + stack.getEntityName();
            }
        }
        return text;
    }

    public String getObjectiveText()
    {
        return getListText(objectives);
    }

    public String getRewardText()
    {
        return getListText(rewards);
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

    public String getQuestId()
    {
        return name;
    }

    private String getQuestLang()
    {
        return "quest." + name;
    }

    public String getUnlocName()
    {
        return getQuestLang() + ".name";
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
        return I18n.format(getQuestLang() + ".desc");
    }

    /**
     * Gets the objective description of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalObj()
    {
        return questType.questDesc + "\n" + getObjectiveText();
    }

    /**
     * Gets the reward description of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalRew()
    {
        //TODO: Generate description from rewards?
        return I18n.format(getQuestLang() + ".rew");
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
     * Gets the time limit to complete this quest in minutes
     */
    public int getTimeLimit()
    {
        return time;
    }

    /**
     * Gets the time limit to complete this quest in ticks
     */
    public long getTimeLimitTicks()
    {
        return (long) getTimeLimit() * 1200;
    }
}
