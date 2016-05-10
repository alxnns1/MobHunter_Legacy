package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.*;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHItems
{
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 10, new int[]{2, 4, 3, 2}, 20);

    public static ItemArmor armourBoneHelmet = new ItemMHArmour(boneArmourMaterial,1,0,Names.Items.BONE_HELMET);
    public static ItemArmor armourBoneChestplate = new ItemMHArmour(boneArmourMaterial,1,1,Names.Items.BONE_CHESTPLATE);
    public static ItemArmor armourBoneLeggings = new ItemMHArmour(boneArmourMaterial,2,2,Names.Items.BONE_LEGGINGS);
    public static ItemArmor armourBoneBoots = new ItemMHArmour(boneArmourMaterial,1,3,Names.Items.BONE_BOOTS);

    public static final ItemMHResource itemEarthCrystal = new ItemMHResource(Names.Items.EARTH_CRYSTAL);
    public static final ItemMHResource itemMachaliteIngot = new ItemMHResource(Names.Items.MACHALITE_INGOT);

    public static final ItemMHResource itemHerb = new ItemMHResource(Names.Items.HERB);
    public static final ItemMHResource itemAntidoteHerb = new ItemMHResource(Names.Items.ANTIDOTE_HERB);
    public static final ItemMHResource itemFireHerb = new ItemMHResource(Names.Items.FIRE_HERB);
    public static final ItemMHResource itemIvy = new ItemMHResource(Names.Items.IVY);
    public static final ItemMHResource itemSleepHerb = new ItemMHResource(Names.Items.SLEEP_HERB);
    public static final ItemMHResource itemSapPlant = new ItemMHResource(Names.Items.SAP_PLANT);
    public static final ItemMHResource itemFelvine = new ItemMHResource(Names.Items.FELVINE);
    public static final ItemMHResource itemGloamgrassRoot = new ItemMHResource(Names.Items.GLOAMGRASS_ROOT);
    public static final ItemMHResource itemHotPepper = new ItemMHResource(Names.Items.HOT_PEPPER);

    public static final ItemMHResource itemBlueMushroom = new ItemMHResource(Names.Items.BLUE_MUSHROOM);
    public static final ItemMHResource itemNitroshroom = new ItemMHResource(Names.Items.NITROSHROOM);
    public static final ItemMHResource itemParashroom = new ItemMHResource(Names.Items.PARASHROOM);
    public static final ItemMHResource itemToadstool = new ItemMHResource(Names.Items.TOADSTOOL);
    public static final ItemMHResource itemExciteshroom = new ItemMHResource(Names.Items.EXCITESHROOM);
    public static final ItemMHResource itemMopeshroom = new ItemMHResource(Names.Items.MOPESHROOM);
    public static final ItemMHResource itemDragonToadstool = new ItemMHResource(Names.Items.DRAGON_TOADSTOOL);

    public static final ItemMHResource itemHuskberry = new ItemMHResource(Names.Items.HUSKBERRY);
    public static final ItemMHResource itemPaintberry = new ItemMHResource(Names.Items.PAINTBERRY);
    public static final ItemMHResource itemMightSeed = new ItemMHResource(Names.Items.MIGHT_SEED);
    public static final ItemMHResource itemAdamantSeed = new ItemMHResource(Names.Items.ADAMANT_SEED);
    public static final ItemMHResource itemNulberry = new ItemMHResource(Names.Items.NULBERRY);
    public static final ItemMHResource itemDragonfellBerry = new ItemMHResource(Names.Items.DRAGONFELL_BERRY);
    public static final ItemMHResource itemScatternut = new ItemMHResource(Names.Items.SCATTERNUT);
    public static final ItemMHResource itemNeedleberry = new ItemMHResource(Names.Items.NEEDLEBERRY);
    public static final ItemMHResource itemLatchberry = new ItemMHResource(Names.Items.LATCHBERRY);
    public static final ItemMHResource itemBomberry = new ItemMHResource(Names.Items.BOMBERRY);

    public static final ItemMHResource itemInsectHusk = new ItemMHResource(Names.Items.INSECT_HUSK);
    public static final ItemMHResource itemStinkhopper = new ItemMHResource(Names.Items.STINKHOPPER);
    public static final ItemMHResource itemSnakebeeLarva = new ItemMHResource(Names.Items.SNAKEBEE_LARVA);
    public static final ItemMHResource itemGodbug = new ItemMHResource(Names.Items.GODBUG);
    public static final ItemMHResource itemBitterbug = new ItemMHResource(Names.Items.BITTERBUG);
    public static final ItemMHResource itemFlashbug = new ItemMHResource(Names.Items.FLASHBUG);
    public static final ItemMHResource itemThunderbug = new ItemMHResource(Names.Items.THUNDERBUG);
    public static final ItemMHResource itemGlueglopper = new ItemMHResource(Names.Items.GLUEGLOPPER);
    public static final ItemMHResource itemKillerBeetle = new ItemMHResource(Names.Items.KILLER_BEETLE);
    public static final ItemMHResource itemHercudrome = new ItemMHResource(Names.Items.HERCUDROME);
    public static final ItemMHResource itemRareScarab = new ItemMHResource(Names.Items.RARE_SCARAB);

    //public static final ItemMHResourceMeta itemBones = new ItemMHResourceMeta(Names.Items.BONE, new String[] {Names.Items.MONSTER_BONE_S, Names.Items.MYSTERY_BONE, Names.Items.BRUTE_BONE, Names.Items.JUMBO_BONE});

    public static final ItemMHResource itemMonsterBoneS = new ItemMHResource(Names.Items.MONSTER_BONE_S);
    public static final ItemMHResource itemMysteryBone = new ItemMHResource(Names.Items.MYSTERY_BONE);
    public static final ItemMHResource itemBruteBone = new ItemMHResource(Names.Items.BRUTE_BONE);
    public static final ItemMHResource itemJumboBone = new ItemMHResource(Names.Items.JUMBO_BONE);

    public static final ItemMHResource itemRawMeat = new ItemMHResource(Names.Items.RAW_MEAT);
    public static final ItemMHFood itemRareSteak = new ItemMHFood(5, 0.4F, true, Names.Items.RARE_STEAK);
    public static final ItemMHFood itemDoneSteak = new ItemMHFood(10, 1.0F, true, Names.Items.DONE_STEAK);
    public static final ItemMHFood itemBurntMeat = new ItemMHFood(5, 0.3F, true, Names.Items.BURNT_MEAT);

    public static final ItemMHResource itemKelbiHorn = new ItemMHResource(Names.Items.KELBI_HORN);
    public static final ItemMHResource itemWarmPelt = new ItemMHResource(Names.Items.WARM_PELT);

    public static final ItemMHResource itemBirdWyvernFang = new ItemMHResource(Names.Items.BIRD_WYVERN_FANG);

    public static final ItemMHResource itemJaggiHide = new ItemMHResource(Names.Items.JAGGI_HIDE);
    public static final ItemMHResource itemJaggiScale = new ItemMHResource(Names.Items.JAGGI_SCALE);

    public static final ItemMHSword itemIronSwordPlus = new ItemMHSword(EnumHelper.addToolMaterial("IronPlus",0,500,0.0f,2.0f,0), Names.Items.IRON_SWORD_PLUS);
    public static final ItemMHSword itemBusterSword = new ItemMHSword(EnumHelper.addToolMaterial("Buster",0,750,0.0f,3.0f,0), Names.Items.BUSTER_SWORD);
    public static final ItemMHSword itemBusterSwordPlus = new ItemMHSword(EnumHelper.addToolMaterial("BusterPlus",0,1000,0.0f,5.0f,0), Names.Items.BUSTER_SWORD_PLUS);
    public static final ItemMHSword itemBoneBlade = new ItemMHSword(EnumHelper.addToolMaterial("Bone",0,59,0.0f,3.0f,0), Names.Items.BONE_BLADE);
    public static final ItemMHSword itemBoneBladePlus = new ItemMHSword(EnumHelper.addToolMaterial("BonePlus",0,118,0.0f,4.0f,0), Names.Items.BONE_BLADE_PLUS);

    /**
     * Registers the items
     */
    public static void init()
    {
        GameRegistry.registerItem(itemEarthCrystal, Names.Items.EARTH_CRYSTAL);
        GameRegistry.registerItem(itemMachaliteIngot, Names.Items.MACHALITE_INGOT);

        GameRegistry.registerItem(itemHerb, Names.Items.HERB);
        GameRegistry.registerItem(itemAntidoteHerb, Names.Items.ANTIDOTE_HERB);
        GameRegistry.registerItem(itemFireHerb, Names.Items.FIRE_HERB);
        GameRegistry.registerItem(itemIvy, Names.Items.IVY);
        GameRegistry.registerItem(itemSleepHerb, Names.Items.SLEEP_HERB);
        GameRegistry.registerItem(itemSapPlant, Names.Items.SAP_PLANT);
        GameRegistry.registerItem(itemFelvine, Names.Items.FELVINE);
        GameRegistry.registerItem(itemGloamgrassRoot, Names.Items.GLOAMGRASS_ROOT);
        GameRegistry.registerItem(itemHotPepper, Names.Items.HOT_PEPPER);

        GameRegistry.registerItem(itemBlueMushroom, Names.Items.BLUE_MUSHROOM);
        GameRegistry.registerItem(itemNitroshroom, Names.Items.NITROSHROOM);
        GameRegistry.registerItem(itemParashroom, Names.Items.PARASHROOM);
        GameRegistry.registerItem(itemToadstool, Names.Items.TOADSTOOL);
        GameRegistry.registerItem(itemExciteshroom, Names.Items.EXCITESHROOM);
        GameRegistry.registerItem(itemMopeshroom, Names.Items.MOPESHROOM);
        GameRegistry.registerItem(itemDragonToadstool, Names.Items.DRAGON_TOADSTOOL);

        GameRegistry.registerItem(itemHuskberry, Names.Items.HUSKBERRY);
        GameRegistry.registerItem(itemPaintberry, Names.Items.PAINTBERRY);
        GameRegistry.registerItem(itemMightSeed, Names.Items.MIGHT_SEED);
        GameRegistry.registerItem(itemAdamantSeed, Names.Items.ADAMANT_SEED);
        GameRegistry.registerItem(itemNulberry, Names.Items.NULBERRY);
        GameRegistry.registerItem(itemDragonfellBerry, Names.Items.DRAGONFELL_BERRY);
        GameRegistry.registerItem(itemScatternut, Names.Items.SCATTERNUT);
        GameRegistry.registerItem(itemNeedleberry, Names.Items.NEEDLEBERRY);
        GameRegistry.registerItem(itemLatchberry, Names.Items.LATCHBERRY);
        GameRegistry.registerItem(itemBomberry, Names.Items.BOMBERRY);

        GameRegistry.registerItem(itemInsectHusk, Names.Items.INSECT_HUSK);
        GameRegistry.registerItem(itemStinkhopper, Names.Items.STINKHOPPER);
        GameRegistry.registerItem(itemSnakebeeLarva, Names.Items.SNAKEBEE_LARVA);
        GameRegistry.registerItem(itemGodbug, Names.Items.GODBUG);
        GameRegistry.registerItem(itemBitterbug, Names.Items.BITTERBUG);
        GameRegistry.registerItem(itemFlashbug, Names.Items.FLASHBUG);
        GameRegistry.registerItem(itemThunderbug, Names.Items.THUNDERBUG);
        GameRegistry.registerItem(itemGlueglopper, Names.Items.GLUEGLOPPER);
        GameRegistry.registerItem(itemKillerBeetle, Names.Items.KILLER_BEETLE);
        GameRegistry.registerItem(itemHercudrome, Names.Items.HERCUDROME);
        GameRegistry.registerItem(itemRareScarab, Names.Items.RARE_SCARAB);

        //GameRegistry.registerItem(itemBones, "bones");

        GameRegistry.registerItem(itemMysteryBone, Names.Items.MYSTERY_BONE);
        GameRegistry.registerItem(itemMonsterBoneS, Names.Items.MONSTER_BONE_S);
        GameRegistry.registerItem(itemBruteBone, Names.Items.BRUTE_BONE);
        GameRegistry.registerItem(itemJumboBone, Names.Items.JUMBO_BONE);

        GameRegistry.registerItem(itemRawMeat, Names.Items.RAW_MEAT);
        GameRegistry.registerItem(itemRareSteak, Names.Items.RARE_STEAK);
        GameRegistry.registerItem(itemDoneSteak, Names.Items.DONE_STEAK);
        GameRegistry.registerItem(itemBurntMeat, Names.Items.BURNT_MEAT);

        GameRegistry.registerItem(itemKelbiHorn, Names.Items.KELBI_HORN);
        GameRegistry.registerItem(itemWarmPelt, Names.Items.WARM_PELT);

        GameRegistry.registerItem(itemBirdWyvernFang, Names.Items.BIRD_WYVERN_FANG);

        GameRegistry.registerItem(itemJaggiHide, Names.Items.JAGGI_HIDE);
        GameRegistry.registerItem(itemJaggiScale, Names.Items.JAGGI_SCALE);

        GameRegistry.registerItem(armourBoneHelmet,Names.Items.BONE_HELMET);
        GameRegistry.registerItem(armourBoneChestplate,Names.Items.BONE_CHESTPLATE);
        GameRegistry.registerItem(armourBoneLeggings,Names.Items.BONE_LEGGINGS);
        GameRegistry.registerItem(armourBoneBoots,Names.Items.BONE_BOOTS);

        GameRegistry.registerItem(itemIronSwordPlus,Names.Items.IRON_SWORD_PLUS);
        GameRegistry.registerItem(itemBusterSword,Names.Items.BUSTER_SWORD);
        GameRegistry.registerItem(itemBusterSwordPlus,Names.Items.BUSTER_SWORD_PLUS);
        GameRegistry.registerItem(itemBoneBlade,Names.Items.BONE_BLADE);
        GameRegistry.registerItem(itemBoneBladePlus,Names.Items.BONE_BLADE_PLUS);
    }

    /**
     * Registers the item models for the items
     * Only run this client-side!
     */
    public static void regModels()
    {
        Common.regModel(itemMachaliteIngot);
        Common.regModel(itemEarthCrystal);

        Common.regModel(itemHerb);
        Common.regModel(itemAntidoteHerb);
        Common.regModel(itemFireHerb);
        Common.regModel(itemIvy);
        Common.regModel(itemSleepHerb);
        Common.regModel(itemSapPlant);
        Common.regModel(itemFelvine);
        Common.regModel(itemGloamgrassRoot);
        Common.regModel(itemHotPepper);

        Common.regModel(itemBlueMushroom);
        Common.regModel(itemNitroshroom);
        Common.regModel(itemParashroom);
        Common.regModel(itemToadstool);
        Common.regModel(itemExciteshroom);
        Common.regModel(itemMopeshroom);
        Common.regModel(itemDragonToadstool);

        Common.regModel(itemHuskberry);
        Common.regModel(itemPaintberry);
        Common.regModel(itemMightSeed);
        Common.regModel(itemAdamantSeed);
        Common.regModel(itemNulberry);
        Common.regModel(itemDragonfellBerry);
        Common.regModel(itemScatternut);
        Common.regModel(itemNeedleberry);
        Common.regModel(itemLatchberry);
        Common.regModel(itemBomberry);

        Common.regModel(itemInsectHusk);
        Common.regModel(itemStinkhopper);
        Common.regModel(itemSnakebeeLarva);
        Common.regModel(itemGodbug);
        Common.regModel(itemBitterbug);
        Common.regModel(itemFlashbug);
        Common.regModel(itemThunderbug);
        Common.regModel(itemGlueglopper);
        Common.regModel(itemKillerBeetle);
        Common.regModel(itemHercudrome);
        Common.regModel(itemRareScarab);

        /*
        for(int i = 0; i < itemBones.getMaxMeta(); i++)
        {
            Common.regModel(itemBones, i);
        }
        */

        Common.regModel(itemMysteryBone);
        Common.regModel(itemMonsterBoneS);
        Common.regModel(itemBruteBone);
        Common.regModel(itemJumboBone);

        Common.regModel(itemRawMeat);
        Common.regModel(itemRareSteak);
        Common.regModel(itemDoneSteak);
        Common.regModel(itemBurntMeat);

        Common.regModel(itemKelbiHorn);
        Common.regModel(itemWarmPelt);

        Common.regModel(itemBirdWyvernFang);

        Common.regModel(itemJaggiHide);
        Common.regModel(itemJaggiScale);

        Common.regModel(armourBoneHelmet);
        Common.regModel(armourBoneChestplate);
        Common.regModel(armourBoneLeggings);
        Common.regModel(armourBoneBoots);

        Common.regModel(itemIronSwordPlus);
        Common.regModel(itemBusterSword);
        Common.regModel(itemBusterSwordPlus);
        Common.regModel(itemBoneBlade);
        Common.regModel(itemBoneBladePlus);
    }
}
