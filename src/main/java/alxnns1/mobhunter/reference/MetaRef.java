package alxnns1.mobhunter.reference;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.init.MHItems;
import com.google.common.collect.Lists;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 21/10/2016.
 */
public class MetaRef
{
    public enum EnumItemType
    {
        DRINK,
        TOOL,
        MISC,
        PLANT,
        MUSHROOM,
        BERRY,
        BUG,
        ORE,
        MISC_DROP,
        HERBIVORE_DROP,
        LYNIAN_DROP,
        NEOPTERAN_DROP,
        PISCINE_DROP,
        BIRD_DROP,
        CARAPACEON_DROP,
        BEAST_DROP,
        AMPHIBIAN_DROP,
        SNAKE_DROP,
        BRUTE_DROP,
        WYVERN_DROP,
        PSEUDO_DROP,
        FANGED_DROP,
        ZENITH_DROP,
        LEVIATHON_DROP,
        ELDER_DROP,
        ICON
    }

    private static List<String> DRINK = new ArrayList<>();
    private static List<String> TOOL = new ArrayList<>();
    private static List<String> MISC = new ArrayList<>();
    private static List<String> PLANT = new ArrayList<>();
    private static List<String> MUSHROOM = new ArrayList<>();
    private static List<String> BERRY = new ArrayList<>();
    private static List<String> BUG = new ArrayList<>();
    private static List<String> ORE = new ArrayList<>();
    private static List<String> MISC_DROP = new ArrayList<>();
    private static List<String> HERBIVORE_DROP = new ArrayList<>();
    private static List<String> LYNIAN_DROP = new ArrayList<>();
    private static List<String> NEOPTERAN_DROP = new ArrayList<>();
    private static List<String> PISCINE_DROP = new ArrayList<>();
    private static List<String> BIRD_DROP = new ArrayList<>();
    private static List<String> CARAPACEON_DROP = new ArrayList<>();
    private static List<String> BEAST_DROP = new ArrayList<>();
    private static List<String> AMPHIBIAN_DROP = new ArrayList<>();
    private static List<String> SNAKE_DROP = new ArrayList<>();
    private static List<String> BRUTE_DROP = new ArrayList<>();
    private static List<String> WYVERN_DROP = new ArrayList<>();
    private static List<String> PSEUDO_DROP = new ArrayList<>();
    private static List<String> FANGED_DROP = new ArrayList<>();
    private static List<String> ZENITH_DROP = new ArrayList<>();
    private static List<String> LEVIATHON_DROP = new ArrayList<>();
    private static List<String> ELDER_DROP = new ArrayList<>();
    private static List<String> ICON = new ArrayList<>();

    public static List<String> getList(EnumItemType itemType)
    {
        switch(itemType)
        {
            case DRINK:             return DRINK;
            case TOOL:              return TOOL;
            case MISC:              return MISC;
            case PLANT:             return PLANT;
            case MUSHROOM:          return MUSHROOM;
            case BERRY:             return BERRY;
            case BUG:               return BUG;
            case ORE:               return ORE;
            case MISC_DROP:         return MISC_DROP;
            case HERBIVORE_DROP:    return HERBIVORE_DROP;
            case LYNIAN_DROP:       return LYNIAN_DROP;
            case NEOPTERAN_DROP:    return NEOPTERAN_DROP;
            case PISCINE_DROP:      return PISCINE_DROP;
            case BIRD_DROP:         return BIRD_DROP;
            case CARAPACEON_DROP:   return CARAPACEON_DROP;
            case BEAST_DROP:        return BEAST_DROP;
            case AMPHIBIAN_DROP:    return AMPHIBIAN_DROP;
            case SNAKE_DROP:        return SNAKE_DROP;
            case BRUTE_DROP:        return BRUTE_DROP;
            case WYVERN_DROP:       return WYVERN_DROP;
            case PSEUDO_DROP:       return PSEUDO_DROP;
            case FANGED_DROP:       return FANGED_DROP;
            case ZENITH_DROP:       return ZENITH_DROP;
            case LEVIATHON_DROP:    return LEVIATHON_DROP;
            case ELDER_DROP:        return ELDER_DROP;
            case ICON:              return ICON;
            default:
                MobHunter.LOGGER.error("Who added an item that I didn't know about? Come on, own up! -> " + itemType);
                return Lists.newArrayList();
        }
    }

    private static Item getItem(EnumItemType itemType)
    {
        switch(itemType)
        {
            case DRINK:             return MHItems.itemDrink;
            case TOOL:              return MHItems.itemTool;
            case MISC:              return MHItems.itemMisc;
            case PLANT:             return MHItems.itemPlant;
            case MUSHROOM:          return MHItems.itemMushroom;
            case BERRY:             return MHItems.itemBerry;
            case BUG:               return MHItems.itemBug;
            case ORE:               return MHItems.itemOre;
            case MISC_DROP:         return MHItems.itemMiscDrop;
            case HERBIVORE_DROP:    return MHItems.itemHerbivoreDrop;
            case LYNIAN_DROP:       return MHItems.itemLynianDrop;
            case NEOPTERAN_DROP:    return MHItems.itemNeopteranDrop;
            case PISCINE_DROP:      return MHItems.itemPiscineWyvernDrop;
            case BIRD_DROP:         return MHItems.itemBirdWyvernDrop;
            case CARAPACEON_DROP:   return MHItems.itemCarapaceonDrop;
            case BEAST_DROP:        return MHItems.itemFangedBeastDrop;
            case AMPHIBIAN_DROP:    return MHItems.itemAmphibianDrop;
            case SNAKE_DROP:        return MHItems.itemSnakeWyvernDrop;
            case BRUTE_DROP:        return MHItems.itemBruteWyvernDrop;
            case WYVERN_DROP:       return MHItems.itemTrueWyvernDrop;
            case PSEUDO_DROP:       return MHItems.itemPseudoWyvernDrop;
            case FANGED_DROP:       return MHItems.itemFangedWyvernDrop;
            case ZENITH_DROP:       return MHItems.itemZenithWyvernDrop;
            case LEVIATHON_DROP:    return MHItems.itemLeviathonDrop;
            case ELDER_DROP:        return MHItems.itemElderDragonDrop;
            case ICON:              return MHItems.itemIcon;
            default:
                MobHunter.LOGGER.error("Who added an item that I didn't know about? Come on, own up! -> " + itemType);
                return null;
        }
    }

    public static void addMetaTo(EnumItemType itemType, String... subNames)
    {
        List<String> list = getList(itemType);
        if(list != null)
            list.addAll(Lists.newArrayList(subNames));
    }

    public static int getMeta(EnumItemType itemType, String subName)
    {
        List<String> list = getList(itemType);
        return list != null ? list.indexOf(subName.toLowerCase()) : -1;
    }

    public static ItemStack getStack(EnumItemType itemType, String subName)
    {
        return getStack(itemType, subName, 1);
    }

    public static ItemStack getStack(EnumItemType itemType, String subName, int amount)
    {
        Item item = getItem(itemType);
        int meta = getMeta(itemType, subName);
        return item == null || meta == -1 ? null : new ItemStack(item, amount, meta);
    }
}
