package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.capability.hunterRank.HunterRankProgression;
import com.alxnns1.mobhunter.capability.quest.EntityStack;
import com.alxnns1.mobhunter.capability.quest.EnumQuestType;
import com.alxnns1.mobhunter.capability.quest.MHQuest;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuests
{
    private static List<MHQuest> ALL_QUESTS = new ArrayList<MHQuest>();
    private static List<List<MHQuest>> QUESTS_BY_RANK = new ArrayList<List<MHQuest>>();
    private static List<String> QUEST_IDS = new ArrayList<String>();

    static
    {
        //Setup QUESTS_BY_RANK list
        for(int i = 0; i < HunterRankProgression.HR_MAX; i++)
            QUESTS_BY_RANK.add(new ArrayList<MHQuest>());
    }

    public static MHQuest
            testCraft, testGather, testHunt,
            huntBasics1, huntBasics2, huntBasics3, huntBasics4, huntBasics5;

    /**
     * Gets a list of all the quest IDs
     */
    public static List<String> getQuestIds()
    {
        List<String> idsCopy = new ArrayList<String>(QUEST_IDS.size());
        for(String s : QUEST_IDS)
            idsCopy.add(s);
        return idsCopy;
    }

    /**
     * Gets a quest by it's name (ID)
     */
    public static MHQuest getQuest(String name)
    {
        for(MHQuest q : ALL_QUESTS)
            if(q.isEqual(name))
                return q;
        return null;
    }

    /**
     * Gets a copy of the quest list for the given rank
     */
    public static List<MHQuest> getQuestsForRank(int hunterRank)
    {
        List<MHQuest> quests = QUESTS_BY_RANK.get(hunterRank);
        List<MHQuest> questsCopy = new ArrayList<MHQuest>(quests.size());
        for(MHQuest q : quests)
            questsCopy.add(q);
        return questsCopy;
    }

    /**
     * Gets all of the quests, grouped by rank
     */
    public static List<List<MHQuest>> getQuestsByRank()
    {
        return QUESTS_BY_RANK;
    }

    public static void regQuest(MHQuest quest)
    {
        for(MHQuest q : ALL_QUESTS)
            if(q.isEqual(quest))
                throw new RuntimeException("A Quest with the name " + quest.getUnlocName() + " already exists!");
        if(quest.getObjectives() == null) LogHelper.warn("The quest '" + quest.getQuestId() + "' has no objectives!");
        if(quest.getRewardItems() == null) LogHelper.warn("The quest '" + quest.getQuestId() + "' has no rewards!");
        ALL_QUESTS.add(quest);
        QUESTS_BY_RANK.get(quest.getRequiredHR()).add(quest);
        QUEST_IDS.add(quest.getQuestId());
    }

    public static void init()
    {
        //Register quests
        regQuest(testCraft = new MHQuest(EnumQuestType.CRAFTING, "testCraft", 1, 0, 140)
                .setObjectives(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion"))
                .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "megaPotion")));
        regQuest(testGather =  new MHQuest(EnumQuestType.GATHERING, "testGather", 10, 0, 140)
                .setObjectives(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "herb", 5))
                .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion", 5)));
        regQuest(testHunt = new MHQuest(EnumQuestType.HUNTING, "testHunt", 100, 0, 140)
                .setObjectives(new EntityStack("MobHunter.Gargwa", 1))
                .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.MISC, "steelEgg"))
                .setRepeatable(10));

        regQuest(huntBasics1 = new MHQuest(EnumQuestType.GATHERING, "huntBasics1", 1, 0, 140)
                .setObjectives(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "herb", 5))
                .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "herb", 5),
                        MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "blueMushroom", 5)));
        regQuest(huntBasics2 = new MHQuest(EnumQuestType.CRAFTING, "huntBasics2", 1, 0, 140)
                .setObjectives(new ItemStack(MHItems.itemDoneSteak))
                .setRewardItems(new ItemStack(MHItems.itemDoneSteak, 0, 5)));
        regQuest(huntBasics3 = new MHQuest(EnumQuestType.CRAFTING, "huntBasics3", 1, 0, 140)
                .setObjectives(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion", 5))
                .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion", 5),
                        MetaRef.getStack(MetaRef.EnumItemType.DRINK, "megaPotion", 5)));
        regQuest(huntBasics4 = new MHQuest(EnumQuestType.CRAFTING, "huntBasics4", 1, 0, 140)
                .setObjectives(new ItemStack(MHItems.weaponHuntersKnife))
                .setRewardItems(new ItemStack(MHItems.weaponHuntersKnife),
                        new ItemStack(MHItems.weaponBoneKris)));
        regQuest(huntBasics5 = new MHQuest(EnumQuestType.HUNTING, "huntBasics5", 1, 0, 140)
                .setObjectives(new EntityStack("MobHunter.Jaggi", 3))
                .setRewardItems(new ItemStack(MHItems.armourHunterHelmet),
                        new ItemStack(MHItems.armourHunterChestplate),
                        new ItemStack(MHItems.armourHunterLeggings),
                        new ItemStack(MHItems.armourHunterBoots)));
    }
}
