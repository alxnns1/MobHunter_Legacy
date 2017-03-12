package com.alxnns1.mobhunter.capability.quest;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MHQuest
{
    private final EnumQuestType questType;
    /** Unlocalised name for the quest */
    private final String name;
    private final int points, reqHR, time;
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
        repeatCooldown = -1;
    }

    /**
     * Checks if this quest is the same as the given one
     */
    public boolean isEqual(MHQuest quest)
    {
        return quest != null && isEqual(quest.name);
    }

    /**
     * Checks if this quest has the same quest ID as given
     */
    public boolean isEqual(String questId)
    {
        return name.equals(questId);
    }

    /**
     * Sets the objectives of this quest, which may be EntityStacks or ItemStacks
     */
    public MHQuest setObjectives(Object... objectives)
    {
        LogHelper.info(objectives[0].getClass().getName());
        if(!questType.storageType.getName().equals(objectives[0].getClass().getName()))
            throw new IllegalArgumentException("Objectives are not an array of the required class: " + questType.storageType.toString());
        this.objectives = objectives;
        return this;
    }

    /**
     * Gets the objectives for this quest
     */
    public Object[] getObjectives()
    {
        return objectives == null ? null : objectives.clone();
    }

    /**
     * Sets this quest to be repeatable, and how long of a cooldown it will have (in minutes)
     */
    public MHQuest setRepeatable(int cooldownMins)
    {
        repeatCooldown = cooldownMins * 1200;
        return this;
    }

    /**
     * Whether this quest can be repeated
     */
    public boolean isRepeatable()
    {
        return repeatCooldown >= 0;
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
        return rewards == null ? null : rewards.clone();
    }

    /**
     * Returns a String listing the items or entities in the given list (CLIENT SIDE ONLY)
     */
    @SideOnly(Side.CLIENT)
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
                text += stack.getAmount() + "x " + stack.getEntityLocName();
            }
        }
        return text;
    }

    /**
     * Returns an ITextComponent listing the items or entities in the given list
     */
    private ITextComponent getListTextComponent(Object[] objList)
    {
        if(objList == null || objList.length == 0)
            return new TextComponentString("Null List");
        TextComponentString text = new TextComponentString("");
        for(int i = 0; i < objList.length; i++)
        {
            Object object = objList[i];
            if(i > 0)
                text.appendText(", ");
            if(object instanceof ItemStack)
            {
                ItemStack stack = (ItemStack) object;
                text.appendText(stack.stackSize + "x ");
                text.appendSibling(new TextComponentTranslation(stack.getUnlocalizedName() + ".name"));
            }
            else if(object instanceof EntityStack)
            {
                EntityStack stack = (EntityStack) object;
                text.appendText(stack.getAmount() + "x ");
                text.appendSibling(new TextComponentTranslation(stack.getEntityUnlocName()));
            }
        }
        return text;
    }

    @SideOnly(Side.CLIENT)
    public String getObjectiveText()
    {
        return getListText(objectives);
    }

    public ITextComponent getObjectiveTextComponent()
    {
        return getListTextComponent(objectives);
    }

    @SideOnly(Side.CLIENT)
    public String getRewardText()
    {
        return getListText(rewards);
    }

    public ITextComponent getRewardTextComponent()
    {
        return getListTextComponent(rewards);
    }

    /**
     * Gets the cooldown after completing the quest
     * Will be -1 if this quest is not repeatable
     */
    public int getRepeatCooldown()
    {
        return repeatCooldown;
    }

    /**
     * Returns the repeat cooldown in minutes rather than ticks
     */
    public int getRepeatCooldownInMins()
    {
        return getRepeatCooldown() / 1200;
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
        return I18n.format(getUnlocDesc());
    }

    public String getUnlocDesc()
    {
        return getQuestLang() + ".desc";
    }

    /**
     * Gets the objective description of the quest
     */
    @SideOnly(Side.CLIENT)
    public String getLocalObj()
    {
        return questType.questDesc + " \n " + getObjectiveText();
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

    public String getPointsRewardText()
    {
        return points + " HR Point" + (points == 1 ? "" : "s");
    }

    /**
     * Gets the amount of Hunter Rank points deducted from the player for failing the quest
     * By default, this is a quarter of the reward points
     */
    public int getPointsPenalty()
    {
        return (int) Math.ceil((float) points / 4f);
    }

    public String getPointsPenaltyText()
    {
        int penalty = getPointsPenalty();
        return penalty + " HR Point" + (penalty == 1 ? "" : "s");
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
