package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.capability.quest.EntityStack;
import com.alxnns1.mobhunter.capability.quest.EnumQuestType;
import com.alxnns1.mobhunter.capability.quest.MHQuest;
import com.alxnns1.mobhunter.reference.MetaRef;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuests
{
    private static List<MHQuest> QUESTS = new ArrayList<MHQuest>();

    public static MHQuest
            testCraft, testGather, testHunt,
            huntBasics1, huntBasics2, huntBasics3, huntBasics4, huntBasics5;

    public static MHQuest getQuest(String name)
    {
        for(MHQuest q : QUESTS)
            if(q.isEqual(name))
                return q;
        return null;
    }

    public static void regQuest(MHQuest quest)
    {
        for(MHQuest q : QUESTS)
            if(q.isEqual(quest))
                throw new RuntimeException("A Quest with the name " + quest.getUnlocName() + " already exists!");
        QUESTS.add(quest);
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
                .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.MISC, "steelEgg")));

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
