package com.alxnns1.mobhunter.reference;

import com.alxnns1.mobhunter.util.LogHelper;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 21/10/2016.
 */
public class MetaRef
{
    public enum EnumItemType
    {
        PLANT,
        MUSHROOM,
        BERRY,
        BUG,
        MONSTER_DROP,
        ORE,
        ICON,
        MISC,
        CONSUMABLE,
        DRINK
    }

    private static List<String> PLANT = new ArrayList<String>();
    private static List<String> MUSHROOM = new ArrayList<String>();
    private static List<String> BERRY = new ArrayList<String>();
    private static List<String> BUG = new ArrayList<String>();
    private static List<String> MONSTER_DROP = new ArrayList<String>();
    private static List<String> ORE = new ArrayList<String>();
    private static List<String> ICON = new ArrayList<String>();
    private static List<String> MISC = new ArrayList<String>();
    private static List<String> CONSUMABLE = new ArrayList<String>();
    private static List<String> DRINK = new ArrayList<String>();

    private static List<String> getList(EnumItemType itemType)
    {
        switch(itemType)
        {
            case PLANT:
                return PLANT;
            case MUSHROOM:
                return MUSHROOM;
            case BERRY:
                return BERRY;
            case BUG:
                return BUG;
            case MONSTER_DROP:
                return MONSTER_DROP;
            case ORE:
                return ORE;
            case ICON:
                return ICON;
            case MISC:
                return MISC;
            case CONSUMABLE:
                return CONSUMABLE;
            case DRINK:
                return DRINK;
            default:
                LogHelper.error("Who added an item that I didn't know about? Come on, own up!");
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
        return list != null ? list.indexOf(subName) : -1;
    }
}
