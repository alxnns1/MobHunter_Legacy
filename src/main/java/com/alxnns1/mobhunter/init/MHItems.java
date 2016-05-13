package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.*;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHItems
{
    public static ItemArmor.ArmorMaterial derringArmourMaterial = EnumHelper.addArmorMaterial("Derring", Reference.MOD_ID + ":derring", 5, new int[]{1, 3, 2, 1}, 6);
    public static ItemArmor.ArmorMaterial hunterArmourMaterial = EnumHelper.addArmorMaterial("Hunter's", Reference.MOD_ID + ":hunter", 15, new int[]{2, 3, 3, 2}, 8);
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 17, new int[]{2, 5, 4, 2}, 8);
    public static ItemArmor.ArmorMaterial alloyArmourMaterial = EnumHelper.addArmorMaterial("Alloy", Reference.MOD_ID + ":alloy", 19, new int[]{2, 6, 5, 2}, 6);

    public static ItemArmor armourDerringHelmet = new ItemMHArmour(derringArmourMaterial,1,0,Names.Items.DERRING_HELMET);
    public static ItemArmor armourDerringChestplate = new ItemMHArmour(derringArmourMaterial,1,1,Names.Items.DERRING_CHESTPLATE);
    public static ItemArmor armourDerringLeggings = new ItemMHArmour(derringArmourMaterial,2,2,Names.Items.DERRING_LEGGINGS);
    public static ItemArmor armourDerringBoots = new ItemMHArmour(derringArmourMaterial,1,3,Names.Items.DERRING_BOOTS);

    public static ItemArmor armourHunterHelmet = new ItemMHArmour(hunterArmourMaterial,1,0,Names.Items.HUNTER_HELMET);
    public static ItemArmor armourHunterChestplate = new ItemMHArmour(hunterArmourMaterial,1,1,Names.Items.HUNTER_CHESTPLATE);
    public static ItemArmor armourHunterLeggings = new ItemMHArmour(hunterArmourMaterial,2,2,Names.Items.HUNTER_LEGGINGS);
    public static ItemArmor armourHunterBoots = new ItemMHArmour(hunterArmourMaterial,1,3,Names.Items.HUNTER_BOOTS);

    public static ItemArmor armourBoneHelmet = new ItemMHArmour(boneArmourMaterial,1,0,Names.Items.BONE_HELMET);
    public static ItemArmor armourBoneChestplate = new ItemMHArmour(boneArmourMaterial,1,1,Names.Items.BONE_CHESTPLATE);
    public static ItemArmor armourBoneLeggings = new ItemMHArmour(boneArmourMaterial,2,2,Names.Items.BONE_LEGGINGS);
    public static ItemArmor armourBoneBoots = new ItemMHArmour(boneArmourMaterial,1,3,Names.Items.BONE_BOOTS);

    public static ItemArmor armourAlloyHelmet = new ItemMHArmour(alloyArmourMaterial,1,0,Names.Items.ALLOY_HELMET);
    public static ItemArmor armourAlloyChestplate = new ItemMHArmour(alloyArmourMaterial,1,1,Names.Items.ALLOY_CHESTPLATE);
    public static ItemArmor armourAlloyLeggings = new ItemMHArmour(alloyArmourMaterial,2,2,Names.Items.ALLOY_LEGGINGS);
    public static ItemArmor armourAlloyBoots = new ItemMHArmour(alloyArmourMaterial,1,3,Names.Items.ALLOY_BOOTS);

    public static final ItemMHResource itemEarthCrystal = new ItemMHResource(Names.Items.EARTH_CRYSTAL,true);
    public static final ItemMHResource itemMachaliteIngot = new ItemMHResource(Names.Items.MACHALITE_INGOT,true);
    public static final ItemMHResource itemDragoniteIngot = new ItemMHResource(Names.Items.DRAGONITE_INGOT,true);

    public static final ItemMHResource itemHerb = new ItemMHResource(Names.Items.HERB,true);
    public static final ItemMHResource itemAntidoteHerb = new ItemMHResource(Names.Items.ANTIDOTE_HERB,true);
    public static final ItemMHResource itemFireHerb = new ItemMHResource(Names.Items.FIRE_HERB,true);
    public static final ItemMHResource itemIvy = new ItemMHResource(Names.Items.IVY,true);
    public static final ItemMHResource itemSleepHerb = new ItemMHResource(Names.Items.SLEEP_HERB,true);
    public static final ItemMHResource itemSapPlant = new ItemMHResource(Names.Items.SAP_PLANT,true);
    public static final ItemMHResource itemFelvine = new ItemMHResource(Names.Items.FELVINE,true);
    public static final ItemMHResource itemGloamgrassRoot = new ItemMHResource(Names.Items.GLOAMGRASS_ROOT,true);
    public static final ItemMHResource itemHotPepper = new ItemMHResource(Names.Items.HOT_PEPPER,true);

    public static final ItemMHResource itemBlueMushroom = new ItemMHResource(Names.Items.BLUE_MUSHROOM,true);
    public static final ItemMHResource itemNitroshroom = new ItemMHResource(Names.Items.NITROSHROOM,true);
    public static final ItemMHResource itemParashroom = new ItemMHResource(Names.Items.PARASHROOM,true);
    public static final ItemMHResource itemToadstool = new ItemMHResource(Names.Items.TOADSTOOL,true);
    public static final ItemMHResource itemExciteshroom = new ItemMHResource(Names.Items.EXCITESHROOM,true);
    public static final ItemMHResource itemMopeshroom = new ItemMHResource(Names.Items.MOPESHROOM,true);
    public static final ItemMHResource itemDragonToadstool = new ItemMHResource(Names.Items.DRAGON_TOADSTOOL,true);

    public static final ItemMHResource itemHuskberry = new ItemMHResource(Names.Items.HUSKBERRY,true);
    public static final ItemMHResource itemPaintberry = new ItemMHResource(Names.Items.PAINTBERRY,true);
    public static final ItemMHResource itemMightSeed = new ItemMHResource(Names.Items.MIGHT_SEED,true);
    public static final ItemMHResource itemAdamantSeed = new ItemMHResource(Names.Items.ADAMANT_SEED,true);
    public static final ItemMHResource itemNulberry = new ItemMHResource(Names.Items.NULBERRY,true);
    public static final ItemMHResource itemDragonfellBerry = new ItemMHResource(Names.Items.DRAGONFELL_BERRY,true);
    public static final ItemMHResource itemScatternut = new ItemMHResource(Names.Items.SCATTERNUT,true);
    public static final ItemMHResource itemNeedleberry = new ItemMHResource(Names.Items.NEEDLEBERRY,true);
    public static final ItemMHResource itemLatchberry = new ItemMHResource(Names.Items.LATCHBERRY,true);
    public static final ItemMHResource itemBomberry = new ItemMHResource(Names.Items.BOMBERRY,true);

    public static final ItemMHResource itemInsectHusk = new ItemMHResource(Names.Items.INSECT_HUSK,true);
    public static final ItemMHResource itemStinkhopper = new ItemMHResource(Names.Items.STINKHOPPER,true);
    public static final ItemMHResource itemSnakebeeLarva = new ItemMHResource(Names.Items.SNAKEBEE_LARVA,true);
    public static final ItemMHResource itemGodbug = new ItemMHResource(Names.Items.GODBUG,true);
    public static final ItemMHResource itemBitterbug = new ItemMHResource(Names.Items.BITTERBUG,true);
    public static final ItemMHResource itemFlashbug = new ItemMHResource(Names.Items.FLASHBUG,true);
    public static final ItemMHResource itemThunderbug = new ItemMHResource(Names.Items.THUNDERBUG,true);
    public static final ItemMHResource itemGlueglopper = new ItemMHResource(Names.Items.GLUEGLOPPER,true);
    public static final ItemMHResource itemKillerBeetle = new ItemMHResource(Names.Items.KILLER_BEETLE,true);
    public static final ItemMHResource itemHercudrome = new ItemMHResource(Names.Items.HERCUDROME,true);
    public static final ItemMHResource itemRareScarab = new ItemMHResource(Names.Items.RARE_SCARAB,true);

    //public static final ItemMHResourceMeta itemBones = new ItemMHResourceMeta(Names.Items.BONE, new String[] {Names.Items.MONSTER_BONE_S, Names.Items.MYSTERY_BONE, Names.Items.BRUTE_BONE, Names.Items.JUMBO_BONE});

    public static final ItemMHResource itemMonsterBoneS = new ItemMHResource(Names.Items.MONSTER_BONE_S,true);
    public static final ItemMHResource itemMonsterBoneM = new ItemMHResource(Names.Items.MONSTER_BONE_M,true);
    public static final ItemMHResource itemMysteryBone = new ItemMHResource(Names.Items.MYSTERY_BONE,true);
    public static final ItemMHResource itemUnknownSkull = new ItemMHResource(Names.Items.UNKNOWN_SKULL,true);
    public static final ItemMHResource itemBruteBone = new ItemMHResource(Names.Items.BRUTE_BONE,true);
    public static final ItemMHResource itemJumboBone = new ItemMHResource(Names.Items.JUMBO_BONE,true);

    public static final ItemMHResource itemRawMeat = new ItemMHResource(Names.Items.RAW_MEAT,true);
    public static final ItemMHFood itemRareSteak = new ItemMHFood(5, 0.4F, true, Names.Items.RARE_STEAK);
    public static final ItemMHFood itemDoneSteak = new ItemMHFood(10, 1.0F, true, Names.Items.DONE_STEAK);
    public static final ItemMHFood itemBurntMeat = new ItemMHFood(5, 0.3F, true, Names.Items.BURNT_MEAT);

    public static final ItemMHResource itemKelbiHorn = new ItemMHResource(Names.Items.KELBI_HORN,true);
    public static final ItemMHResource itemWarmPelt = new ItemMHResource(Names.Items.WARM_PELT,true);

    public static final ItemMHResource itemBirdWyvernFang = new ItemMHResource(Names.Items.BIRD_WYVERN_FANG,true);

    public static final ItemMHResource itemJaggiHide = new ItemMHResource(Names.Items.JAGGI_HIDE,true);
    public static final ItemMHResource itemJaggiScale = new ItemMHResource(Names.Items.JAGGI_SCALE,true);

    public static final ItemMHSword weaponIronSwordPlus = new ItemMHSword(EnumHelper.addToolMaterial("IronPlus",0,500,0.0f,2.0f,0), Names.Items.IRON_SWORD_PLUS);
    public static final ItemMHSword weaponBusterSword = new ItemMHSword(EnumHelper.addToolMaterial("Buster",0,750,0.0f,3.0f,0), Names.Items.BUSTER_SWORD);
    public static final ItemMHSword weaponBusterSwordPlus = new ItemMHSword(EnumHelper.addToolMaterial("BusterPlus",0,1000,0.0f,5.0f,0), Names.Items.BUSTER_SWORD_PLUS);
    public static final ItemMHSword weaponRavagerBlade = new ItemMHSword(EnumHelper.addToolMaterial("RavagerPlus",0,1500,0.0f,6.0f,0), Names.Items.RAVAGER_BLADE);

    public static final ItemMHSword weaponBoneBlade = new ItemMHSword(EnumHelper.addToolMaterial("Bone",0,59,0.0f,3.0f,0), Names.Items.BONE_BLADE);
    public static final ItemMHSword weaponBoneBladePlus = new ItemMHSword(EnumHelper.addToolMaterial("BonePlus",0,118,0.0f,4.0f,0), Names.Items.BONE_BLADE_PLUS);
    public static final ItemMHSword weaponJawblade = new ItemMHSword(EnumHelper.addToolMaterial("Jawblade",0,177,0.0f,5.0f,0), Names.Items.JAWBLADE);
    public static final ItemMHSword weaponGiantJawblade = new ItemMHSword(EnumHelper.addToolMaterial("GiantJawblade",0,236,0.0f,6.0f,0), Names.Items.GIANT_JAWBLADE);

    /**
     * Registers the items
     */
    public static void init()
    {
        GameRegistry.registerItem(itemEarthCrystal, Names.Items.EARTH_CRYSTAL);
        GameRegistry.registerItem(itemMachaliteIngot, Names.Items.MACHALITE_INGOT);
        GameRegistry.registerItem(itemDragoniteIngot, Names.Items.DRAGONITE_INGOT);

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

        GameRegistry.registerItem(itemMonsterBoneS, Names.Items.MONSTER_BONE_S);
        GameRegistry.registerItem(itemMonsterBoneM, Names.Items.MONSTER_BONE_M);
        GameRegistry.registerItem(itemMysteryBone, Names.Items.MYSTERY_BONE);
        GameRegistry.registerItem(itemUnknownSkull, Names.Items.UNKNOWN_SKULL);
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

        GameRegistry.registerItem(armourDerringHelmet,Names.Items.DERRING_HELMET);
        GameRegistry.registerItem(armourDerringChestplate,Names.Items.DERRING_CHESTPLATE);
        GameRegistry.registerItem(armourDerringLeggings,Names.Items.DERRING_LEGGINGS);
        GameRegistry.registerItem(armourDerringBoots,Names.Items.DERRING_BOOTS);

        GameRegistry.registerItem(armourHunterHelmet,Names.Items.HUNTER_HELMET);
        GameRegistry.registerItem(armourHunterChestplate,Names.Items.HUNTER_CHESTPLATE);
        GameRegistry.registerItem(armourHunterLeggings,Names.Items.HUNTER_LEGGINGS);
        GameRegistry.registerItem(armourHunterBoots,Names.Items.HUNTER_BOOTS);

        GameRegistry.registerItem(armourBoneHelmet,Names.Items.BONE_HELMET);
        GameRegistry.registerItem(armourBoneChestplate,Names.Items.BONE_CHESTPLATE);
        GameRegistry.registerItem(armourBoneLeggings,Names.Items.BONE_LEGGINGS);
        GameRegistry.registerItem(armourBoneBoots,Names.Items.BONE_BOOTS);

        GameRegistry.registerItem(armourAlloyHelmet,Names.Items.ALLOY_HELMET);
        GameRegistry.registerItem(armourAlloyChestplate,Names.Items.ALLOY_CHESTPLATE);
        GameRegistry.registerItem(armourAlloyLeggings,Names.Items.ALLOY_LEGGINGS);
        GameRegistry.registerItem(armourAlloyBoots,Names.Items.ALLOY_BOOTS);

        GameRegistry.registerItem(weaponIronSwordPlus,Names.Items.IRON_SWORD_PLUS);
        GameRegistry.registerItem(weaponBusterSword,Names.Items.BUSTER_SWORD);
        GameRegistry.registerItem(weaponBusterSwordPlus,Names.Items.BUSTER_SWORD_PLUS);
        GameRegistry.registerItem(weaponRavagerBlade,Names.Items.RAVAGER_BLADE);

        GameRegistry.registerItem(weaponBoneBlade,Names.Items.BONE_BLADE);
        GameRegistry.registerItem(weaponBoneBladePlus,Names.Items.BONE_BLADE_PLUS);
        GameRegistry.registerItem(weaponJawblade,Names.Items.JAWBLADE);
        GameRegistry.registerItem(weaponGiantJawblade,Names.Items.GIANT_JAWBLADE);
    }

    /**
     * Registers the item models for the items
     * Only run this client-side!
     */
    public static void regModels()
    {
        Common.regModel(itemEarthCrystal);
        Common.regModel(itemMachaliteIngot);
        Common.regModel(itemDragoniteIngot);

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

        Common.regModel(itemMonsterBoneS);
        Common.regModel(itemMonsterBoneM);
        Common.regModel(itemMysteryBone);
        Common.regModel(itemUnknownSkull);
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

        Common.regModel(armourDerringHelmet);
        Common.regModel(armourDerringChestplate);
        Common.regModel(armourDerringLeggings);
        Common.regModel(armourDerringBoots);

        Common.regModel(armourHunterHelmet);
        Common.regModel(armourHunterChestplate);
        Common.regModel(armourHunterLeggings);
        Common.regModel(armourHunterBoots);

        Common.regModel(armourBoneHelmet);
        Common.regModel(armourBoneChestplate);
        Common.regModel(armourBoneLeggings);
        Common.regModel(armourBoneBoots);

        Common.regModel(armourAlloyHelmet);
        Common.regModel(armourAlloyChestplate);
        Common.regModel(armourAlloyLeggings);
        Common.regModel(armourAlloyBoots);

        Common.regModel(weaponIronSwordPlus);
        Common.regModel(weaponBusterSword);
        Common.regModel(weaponBusterSwordPlus);
        Common.regModel(weaponRavagerBlade);

        Common.regModel(weaponBoneBlade);
        Common.regModel(weaponBoneBladePlus);
        Common.regModel(weaponJawblade);
        Common.regModel(weaponGiantJawblade);
    }
}
