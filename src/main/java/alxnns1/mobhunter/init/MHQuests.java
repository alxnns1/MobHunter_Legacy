package alxnns1.mobhunter.init;

import alxnns1.mobhunter.capability.hunterRank.HunterRankProgression;
import alxnns1.mobhunter.capability.quest.EntityStack;
import alxnns1.mobhunter.capability.quest.MHQuest;
import alxnns1.mobhunter.capability.quest.EnumQuestType;
import alxnns1.mobhunter.reference.MetaRef;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class MHQuests
{
    public static IForgeRegistry<MHQuest> REGISTRY;

    private static List<List<MHQuest>> QUESTS_BY_RANK = new ArrayList<>();
    private static List<String> QUEST_IDS = new ArrayList<>();

    static
    {
        //Setup QUESTS_BY_RANK list
        for(int i = 0; i < HunterRankProgression.HR_MAX; i++)
            QUESTS_BY_RANK.add(new ArrayList<>());
    }

    /**
     * Gets a list of all the quest IDs
     */
    public static List<String> getQuestIds()
    {
        return new ArrayList<>(QUEST_IDS);
    }

    /**
     * Gets a quest by it's name (ID)
     */
    public static MHQuest getQuest(String name)
    {
        return REGISTRY.getValue(new ResourceLocation(name));
    }

    /**
     * Gets a copy of the quest list for the given rank
     */
    public static List<MHQuest> getQuestsForRank(int hunterRank)
    {
        return new ArrayList<>(QUESTS_BY_RANK.get(hunterRank));
    }

    /**
     * Gets all of the quests, grouped by rank
     */
    public static List<List<MHQuest>> getQuestsByRank()
    {
        return QUESTS_BY_RANK;
    }

    public static void initLists()
    {
        REGISTRY.forEach(quest -> {
            QUESTS_BY_RANK.get(quest.getRequiredHR()).add(quest);
            QUEST_IDS.add(quest.getQuestId());
        });
    }

    public static void regQuests(IForgeRegistry<MHQuest> registry)
    {
        //Register quests
        registry.registerAll(
                new MHQuest(EnumQuestType.GATHERING, "huntbasics1", 1, 0, 140)
                        .setObjectives(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "herb", 5))
                        .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "herb", 5),
                                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "bluemushroom", 5))
                        .setPenalty(0),
                new MHQuest(EnumQuestType.CRAFTING, "huntbasics2", 1, 0, 140)
                        .setObjectives(new ItemStack(MHItems.itemDoneSteak))
                        .setRewardItems(new ItemStack(MHItems.itemDoneSteak, 5, 0))
                        .setPenalty(0),
                new MHQuest(EnumQuestType.CRAFTING, "huntbasics3", 1, 0, 140)
                        .setObjectives(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion", 5))
                        .setRewardItems(MetaRef.getStack(MetaRef.EnumItemType.DRINK, "potion", 5),
                                MetaRef.getStack(MetaRef.EnumItemType.DRINK, "megapotion", 5))
                        .setPenalty(0),
                new MHQuest(EnumQuestType.CRAFTING, "huntbasics4", 1, 0, 140)
                        .setObjectives(new ItemStack(MHItems.weaponHuntersKnife))
                        .setRewardItems(new ItemStack(MHItems.weaponHuntersKnife),
                                new ItemStack(MHItems.weaponBoneKris))
                        .setPenalty(0),
                new MHQuest(EnumQuestType.HUNTING, "huntbasics5", 1, 0, 140)
                        .setObjectives(new EntityStack(true, "jaggi", 3))
                        .setRewardItems(new ItemStack(MHItems.armourHunterHelmet),
                                new ItemStack(MHItems.armourHunterChestplate),
                                new ItemStack(MHItems.armourHunterLeggings),
                                new ItemStack(MHItems.armourHunterBoots))
                        .setPenalty(0)
        );
    }
}
