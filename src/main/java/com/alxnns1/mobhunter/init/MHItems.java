package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.*;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
@SuppressWarnings("all")
public class MHItems
{
    public static ItemArmor.ArmorMaterial derringArmourMaterial = EnumHelper.addArmorMaterial("Derring", Reference.MOD_ID + ":derring", 5, new int[]{1, 3, 2, 1}, 6, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial hunterArmourMaterial = EnumHelper.addArmorMaterial("Hunter's", Reference.MOD_ID + ":hunter", 15, new int[]{2, 3, 3, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 17, new int[]{2, 5, 4, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial alloyArmourMaterial = EnumHelper.addArmorMaterial("Alloy", Reference.MOD_ID + ":alloy", 19, new int[]{2, 6, 5, 2}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);

    public static ItemArmor armourDerringHelmet = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.DERRING_HELMET);
    public static ItemArmor armourDerringChestplate = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.DERRING_CHESTPLATE);
    public static ItemArmor armourDerringLeggings = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.DERRING_LEGGINGS);
    public static ItemArmor armourDerringBoots = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.DERRING_BOOTS);

    public static ItemArmor armourHunterHelmet = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.HUNTER_HELMET);
    public static ItemArmor armourHunterChestplate = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.HUNTER_CHESTPLATE);
    public static ItemArmor armourHunterLeggings = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.HUNTER_LEGGINGS);
    public static ItemArmor armourHunterBoots = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.HUNTER_BOOTS);

    public static ItemArmor armourBoneHelmet = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.BONE_HELMET);
    public static ItemArmor armourBoneChestplate = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.BONE_CHESTPLATE);
    public static ItemArmor armourBoneLeggings = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.BONE_LEGGINGS);
    public static ItemArmor armourBoneBoots = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.BONE_BOOTS);

    public static ItemArmor armourAlloyHelmet = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.ALLOY_HELMET);
    public static ItemArmor armourAlloyChestplate = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.ALLOY_CHESTPLATE);
    public static ItemArmor armourAlloyLeggings = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.ALLOY_LEGGINGS);
    public static ItemArmor armourAlloyBoots = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.ALLOY_BOOTS);

    public static final ItemMHDrink itemPotion = new ItemMHDrink(Names.Items.POTION);
    public static final ItemMHDrink itemMegaPotion = new ItemMHDrink(Names.Items.MEGA_POTION);
    public static final ItemMHDrink itemNutrients = new ItemMHDrink(Names.Items.NUTRIENTS);
    public static final ItemMHDrink itemMegaNutrients = new ItemMHDrink(Names.Items.MEGA_NUTRIENTS);
    public static final ItemMHDrink itemAntidote = new ItemMHDrink(Names.Items.ANTIDOTE);
    public static final ItemMHDrink itemImmunizer = new ItemMHDrink(Names.Items.IMMUNIZER);
    public static final ItemMHDrink itemDashJuice = new ItemMHDrink(Names.Items.DASH_JUICE);
    public static final ItemMHDrink itemMegaDashJuice = new ItemMHDrink(Names.Items.MEGA_DASH_JUICE);
    public static final ItemMHDrink itemDemondrug = new ItemMHDrink(Names.Items.DEMONDRUG);
    public static final ItemMHDrink itemMegaDemondrug = new ItemMHDrink(Names.Items.MEGA_DEMONDRUG);
    public static final ItemMHDrink itemArmourskin = new ItemMHDrink(Names.Items.ARMOURSKIN);
    public static final ItemMHDrink itemMegaArmourskin = new ItemMHDrink(Names.Items.MEGA_ARMOURSKIN);

    public static final ItemMHResource itemCatalyst = new ItemMHResource(Names.Items.CATALYST);

    public static final ItemMHResource itemWhetstone = new ItemMHResource(Names.Items.WHETSTONE);

    public static final ItemMHResource itemRawMeat = new ItemMHResource(Names.Items.RAW_MEAT);
    public static final ItemMHConsumable itemRareSteak = new ItemMHConsumable(5, 0.4F, true, Names.Items.RARE_STEAK);
    public static final ItemMHConsumable itemDoneSteak = new ItemMHConsumable(10, 1.0F, true, Names.Items.DONE_STEAK);
    public static final ItemMHConsumable itemBurntMeat = new ItemMHConsumable(5, 0.3F, true, Names.Items.BURNT_MEAT);

    public static final ItemMHConsumable itemHerb = new ItemMHConsumable(Names.Items.HERB, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemAntidoteHerb = new ItemMHConsumable(Names.Items.ANTIDOTE_HERB, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemFireHerb = new ItemMHConsumable(Names.Items.FIRE_HERB, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHResource itemIvy = new ItemMHResource(Names.Items.IVY);
    public static final ItemMHResource itemSleepHerb = new ItemMHResource(Names.Items.SLEEP_HERB);
    public static final ItemMHResource itemSapPlant = new ItemMHResource(Names.Items.SAP_PLANT);
    public static final ItemMHResource itemFelvine = new ItemMHResource(Names.Items.FELVINE);
    public static final ItemMHResource itemGloamgrassRoot = new ItemMHResource(Names.Items.GLOAMGRASS_ROOT);
    public static final ItemMHResource itemHotPepper = new ItemMHResource(Names.Items.HOT_PEPPER);

    public static final ItemMHResource itemBlueMushroom = new ItemMHResource(Names.Items.BLUE_MUSHROOM);
    public static final ItemMHConsumable itemNitroshroom = new ItemMHConsumable(Names.Items.NITROSHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemParashroom = new ItemMHConsumable(Names.Items.PARASHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemToadstool = new ItemMHConsumable(Names.Items.TOADSTOOL, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemExciteshroom = new ItemMHConsumable(Names.Items.EXCITESHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemMopeshroom = new ItemMHConsumable(Names.Items.MOPESHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHResource itemDragonToadstool = new ItemMHResource(Names.Items.DRAGON_TOADSTOOL);

    public static final ItemMHResource itemHuskberry = new ItemMHResource(Names.Items.HUSKBERRY);
    public static final ItemMHResource itemPaintberry = new ItemMHResource(Names.Items.PAINTBERRY);
    public static final ItemMHConsumable itemMightSeed = new ItemMHConsumable(Names.Items.MIGHT_SEED, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemAdamantSeed = new ItemMHConsumable(Names.Items.ADAMANT_SEED, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHConsumable itemNulberry = new ItemMHConsumable(Names.Items.NULBERRY, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHResource itemDragonfellBerry = new ItemMHResource(Names.Items.DRAGONFELL_BERRY);
    public static final ItemMHResource itemScatternut = new ItemMHResource(Names.Items.SCATTERNUT);
    public static final ItemMHConsumable itemNeedleberry = new ItemMHConsumable(Names.Items.NEEDLEBERRY, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHResource itemLatchberry = new ItemMHResource(Names.Items.LATCHBERRY);
    public static final ItemMHConsumable itemBomberry = new ItemMHConsumable(Names.Items.BOMBERRY, true, ItemMHConsumable.EAT_DURATION_SHORT);

    public static final ItemMHResource itemEarthCrystal = new ItemMHResource(Names.Items.EARTH_CRYSTAL);
    public static final ItemMHResource itemMachaliteIngot = new ItemMHResource(Names.Items.MACHALITE_INGOT);
    public static final ItemMHResource itemDragoniteIngot = new ItemMHResource(Names.Items.DRAGONITE_INGOT);

    public static final ItemMHResource itemInsectHusk = new ItemMHResource(Names.Items.INSECT_HUSK);
    public static final ItemMHResource itemStinkhopper = new ItemMHResource(Names.Items.STINKHOPPER);
    public static final ItemMHResource itemSnakebeeLarva = new ItemMHResource(Names.Items.SNAKEBEE_LARVA);
    public static final ItemMHResource itemGodbug = new ItemMHResource(Names.Items.GODBUG);
    public static final ItemMHConsumable itemBitterbug = new ItemMHConsumable(Names.Items.BITTERBUG, true, ItemMHConsumable.EAT_DURATION_SHORT);
    public static final ItemMHResource itemFlashbug = new ItemMHResource(Names.Items.FLASHBUG);
    public static final ItemMHResource itemThunderbug = new ItemMHResource(Names.Items.THUNDERBUG);
    public static final ItemMHResource itemGlueglopper = new ItemMHResource(Names.Items.GLUEGLOPPER);
    public static final ItemMHResource itemKillerBeetle = new ItemMHResource(Names.Items.KILLER_BEETLE);
    public static final ItemMHResource itemHercudrome = new ItemMHResource(Names.Items.HERCUDROME);
    public static final ItemMHResource itemRareScarab = new ItemMHResource(Names.Items.RARE_SCARAB);
    public static final ItemMHResource itemHoney = new ItemMHResource(Names.Items.HONEY);

    //public static final ItemMHResourceMeta itemBones = new ItemMHResourceMeta(Names.Items.BONE, new String[] {Names.Items.MONSTER_BONE_S, Names.Items.MYSTERY_BONE, Names.Items.BRUTE_BONE, Names.Items.JUMBO_BONE});

    public static final ItemMHResource itemMonsterBoneS = new ItemMHResource(Names.Items.MONSTER_BONE_S);
    public static final ItemMHResource itemMonsterBoneM = new ItemMHResource(Names.Items.MONSTER_BONE_M);
    public static final ItemMHResource itemMysteryBone = new ItemMHResource(Names.Items.MYSTERY_BONE);
    public static final ItemMHResource itemUnknownSkull = new ItemMHResource(Names.Items.UNKNOWN_SKULL);
    public static final ItemMHResource itemBruteBone = new ItemMHResource(Names.Items.BRUTE_BONE);
    public static final ItemMHResource itemJumboBone = new ItemMHResource(Names.Items.JUMBO_BONE);
    public static final ItemMHResource itemDung = new ItemMHResource(Names.Items.DUNG);

    public static final ItemMHResource itemAltarothJaw = new ItemMHResource(Names.Items.ALTAROTH_JAW);
    public static final ItemMHResource itemAltarothStomach = new ItemMHResource(Names.Items.ALTAROTH_STOMACH);

    public static final ItemMHResource itemKelbiHorn = new ItemMHResource(Names.Items.KELBI_HORN);
    public static final ItemMHResource itemWarmPelt = new ItemMHResource(Names.Items.WARM_PELT);

    public static final ItemMHResource itemGargwaFeather = new ItemMHResource(Names.Items.GARGWA_FEATHER);
    public static final ItemMHResource itemSteelEgg = new ItemMHResource(Names.Items.STEEL_EGG);

    public static final ItemMHResource itemMonsterFluid = new ItemMHResource(Names.Items.MONSTER_FLUID);

    public static final ItemMHResource itemBirdWyvernFang = new ItemMHResource(Names.Items.BIRD_WYVERN_FANG);

    public static final ItemMHResource itemScreamerSac = new ItemMHResource(Names.Items.SCREAMER_SAC);

    public static final ItemMHResource itemJaggiHide = new ItemMHResource(Names.Items.JAGGI_HIDE);
    public static final ItemMHResource itemJaggiScale = new ItemMHResource(Names.Items.JAGGI_SCALE);

    public static final ItemMHResource itemVelocipreyHide = new ItemMHResource(Names.Items.VELOCIPREY_HIDE);
    public static final ItemMHResource itemVelocipreyScale = new ItemMHResource(Names.Items.VELOCIPREY_SCALE);

    public static final ItemMHResource itemGenpreyHide = new ItemMHResource(Names.Items.GENPREY_HIDE);
    public static final ItemMHResource itemGenpreyScale = new ItemMHResource(Names.Items.GENPREY_SCALE);
    public static final ItemMHResource itemGenpreyFang = new ItemMHResource(Names.Items.GENPREY_FANG);

    public static final ItemMHResource itemGreatJaggiHide = new ItemMHResource(Names.Items.GREAT_JAGGI_HIDE);
    public static final ItemMHResource itemGreatJaggiClaw = new ItemMHResource(Names.Items.GREAT_JAGGI_CLAW);
    public static final ItemMHResource itemGreatJaggiHead = new ItemMHResource(Names.Items.GREAT_JAGGI_HEAD);
    public static final ItemMHResource itemKingsFrill = new ItemMHResource(Names.Items.KINGS_FRILL);

    public static final ItemMHSword weaponIronSwordPlus = new ItemMHSword(EnumHelper.addToolMaterial("IronPlus",0,399,0.0f,3.0f,0), Names.Items.IRON_SWORD_PLUS, EnumSharpness.YELLOW, new int[] {180, 320});
    public static final ItemMHSword weaponBusterSword = new ItemMHSword(EnumHelper.addToolMaterial("Buster",0,399,0.0f,4.0f,0), Names.Items.BUSTER_SWORD, EnumSharpness.GREEN, new int[] {160, 300, 380});
    public static final ItemMHSword weaponRuggedGreatSword = new ItemMHSword(EnumHelper.addToolMaterial("Rugged",0,399,0.0f,6.0f,0), Names.Items.RUGGED_GREAT_SWORD, EnumSharpness.GREEN, new int[] {80, 200, 360});
    public static final ItemMHSword weaponBusterSwordPlus = new ItemMHSword(EnumHelper.addToolMaterial("BusterPlus",0,399,0.0f,6.0f,0), Names.Items.BUSTER_SWORD_PLUS, EnumSharpness.GREEN, new int[] {80, 160, 340});
    public static final ItemMHSword weaponRavagerBlade = new ItemMHSword(EnumHelper.addToolMaterial("RavagerPlus",0,399,0.0f,7.0f,0), Names.Items.RAVAGER_BLADE, EnumSharpness.GREEN, new int[] {140, 220, 320});

    public static final ItemMHSword weaponBoneBlade = new ItemMHSword(EnumHelper.addToolMaterial("Bone",0,399,0.0f,4.0f,0), Names.Items.BONE_BLADE, EnumSharpness.ORANGE, new int[] {160});
    public static final ItemMHSword weaponBoneBladePlus = new ItemMHSword(EnumHelper.addToolMaterial("BonePlus",0,399,0.0f,5.0f,0), Names.Items.BONE_BLADE_PLUS, EnumSharpness.YELLOW, new int[] {200, 380});
    public static final ItemMHSword weaponJawblade = new ItemMHSword(EnumHelper.addToolMaterial("Jawblade",0,399,0.0f,6.0f,0), Names.Items.JAWBLADE, EnumSharpness.YELLOW, new int[] {300, 340});
    public static final ItemMHSword weaponGiantJawblade = new ItemMHSword(EnumHelper.addToolMaterial("GiantJawblade",0,399,0.0f,7.0f,0), Names.Items.GIANT_JAWBLADE, EnumSharpness.YELLOW, new int[] {60, 100});

    public static final ItemMHResource iconGreatJaggi = new ItemMHResource(Names.Items.ICON_GREAT_JAGGI,false);
    public static final ItemMHResource iconGendrome = new ItemMHResource(Names.Items.ICON_GENDROME,false);
    public static final ItemMHResource iconIodrome = new ItemMHResource(Names.Items.ICON_IODROME,false);
    public static final ItemMHResource iconVelocidrome = new ItemMHResource(Names.Items.ICON_VELOCIDROME,false);
    public static final ItemMHResource iconKirin = new ItemMHResource(Names.Items.ICON_KIRIN,false);

    /**
     * Registers the items
     */
    public static void init()
    {
        GameRegistry.register(itemPotion);
        GameRegistry.register(itemMegaPotion);
        //GameRegistry.register(itemNutrients);
        //GameRegistry.register(itemMegaNutrients);
        GameRegistry.register(itemAntidote);
        GameRegistry.register(itemImmunizer);
        GameRegistry.register(itemDashJuice);
        GameRegistry.register(itemMegaDashJuice);
        GameRegistry.register(itemDemondrug);
        GameRegistry.register(itemMegaDemondrug);
        GameRegistry.register(itemArmourskin);
        GameRegistry.register(itemMegaArmourskin);

        GameRegistry.register(itemCatalyst);

        GameRegistry.register(itemWhetstone);

        GameRegistry.register(itemRawMeat);
        GameRegistry.register(itemRareSteak);
        GameRegistry.register(itemDoneSteak);
        GameRegistry.register(itemBurntMeat);

        GameRegistry.register(itemHerb);
        GameRegistry.register(itemAntidoteHerb);
        GameRegistry.register(itemFireHerb);
        GameRegistry.register(itemIvy);
        GameRegistry.register(itemSleepHerb);
        GameRegistry.register(itemSapPlant);
        GameRegistry.register(itemFelvine);
        GameRegistry.register(itemGloamgrassRoot);
        GameRegistry.register(itemHotPepper);

        GameRegistry.register(itemBlueMushroom);
        GameRegistry.register(itemNitroshroom);
        GameRegistry.register(itemParashroom);
        GameRegistry.register(itemToadstool);
        GameRegistry.register(itemExciteshroom);
        GameRegistry.register(itemMopeshroom);
        GameRegistry.register(itemDragonToadstool);

        GameRegistry.register(itemHuskberry);
        GameRegistry.register(itemPaintberry);
        GameRegistry.register(itemMightSeed);
        GameRegistry.register(itemAdamantSeed);
        GameRegistry.register(itemNulberry);
        GameRegistry.register(itemDragonfellBerry);
        GameRegistry.register(itemScatternut);
        GameRegistry.register(itemNeedleberry);
        GameRegistry.register(itemLatchberry);
        GameRegistry.register(itemBomberry);

        GameRegistry.register(itemEarthCrystal);
        GameRegistry.register(itemMachaliteIngot);
        GameRegistry.register(itemDragoniteIngot);

        GameRegistry.register(itemInsectHusk);
        GameRegistry.register(itemStinkhopper);
        GameRegistry.register(itemSnakebeeLarva);
        GameRegistry.register(itemGodbug);
        GameRegistry.register(itemBitterbug);
        GameRegistry.register(itemFlashbug);
        GameRegistry.register(itemThunderbug);
        GameRegistry.register(itemGlueglopper);
        GameRegistry.register(itemKillerBeetle);
        GameRegistry.register(itemHercudrome);
        GameRegistry.register(itemRareScarab);
        GameRegistry.register(itemHoney);

        //GameRegistry.register(itemBones, "bones");

        GameRegistry.register(itemMonsterBoneS);
        GameRegistry.register(itemMonsterBoneM);
        GameRegistry.register(itemMysteryBone);
        GameRegistry.register(itemUnknownSkull);
        GameRegistry.register(itemBruteBone);
        GameRegistry.register(itemJumboBone);
        GameRegistry.register(itemDung);

        GameRegistry.register(itemAltarothJaw);
        GameRegistry.register(itemAltarothStomach);

        GameRegistry.register(itemKelbiHorn);
        GameRegistry.register(itemWarmPelt);

        GameRegistry.register(itemGargwaFeather);
        GameRegistry.register(itemSteelEgg);

        GameRegistry.register(itemMonsterFluid);

        GameRegistry.register(itemBirdWyvernFang);

        GameRegistry.register(itemScreamerSac);

        GameRegistry.register(itemJaggiHide);
        GameRegistry.register(itemJaggiScale);

        GameRegistry.register(itemVelocipreyHide);
        GameRegistry.register(itemVelocipreyScale);

        GameRegistry.register(itemGenpreyHide);
        GameRegistry.register(itemGenpreyScale);
        GameRegistry.register(itemGenpreyFang);

        GameRegistry.register(itemGreatJaggiHide);
        GameRegistry.register(itemGreatJaggiClaw);
        GameRegistry.register(itemGreatJaggiHead);
        GameRegistry.register(itemKingsFrill);

        GameRegistry.register(armourDerringHelmet);
        GameRegistry.register(armourDerringChestplate);
        GameRegistry.register(armourDerringLeggings);
        GameRegistry.register(armourDerringBoots);

        GameRegistry.register(armourHunterHelmet);
        GameRegistry.register(armourHunterChestplate);
        GameRegistry.register(armourHunterLeggings);
        GameRegistry.register(armourHunterBoots);

        GameRegistry.register(armourBoneHelmet);
        GameRegistry.register(armourBoneChestplate);
        GameRegistry.register(armourBoneLeggings);
        GameRegistry.register(armourBoneBoots);

        GameRegistry.register(armourAlloyHelmet);
        GameRegistry.register(armourAlloyChestplate);
        GameRegistry.register(armourAlloyLeggings);
        GameRegistry.register(armourAlloyBoots);

        GameRegistry.register(weaponIronSwordPlus);
        GameRegistry.register(weaponBusterSword);
        GameRegistry.register(weaponRuggedGreatSword);
        GameRegistry.register(weaponBusterSwordPlus);
        GameRegistry.register(weaponRavagerBlade);

        GameRegistry.register(weaponBoneBlade);
        GameRegistry.register(weaponBoneBladePlus);
        GameRegistry.register(weaponJawblade);
        GameRegistry.register(weaponGiantJawblade);

        GameRegistry.register(iconGreatJaggi);
        GameRegistry.register(iconGendrome);
        GameRegistry.register(iconIodrome);
        GameRegistry.register(iconVelocidrome);
        GameRegistry.register(iconKirin);
    }

    /**
     * Registers the item models for the items
     * Only run this client-side!
     */
    public static void regModels()
    {
        Common.regModel(itemPotion);
        Common.regModel(itemMegaPotion);
        //Common.regModel(itemNutrients);
        //Common.regModel(itemMegaNutrients);
        Common.regModel(itemAntidote);
        Common.regModel(itemImmunizer);
        Common.regModel(itemDashJuice);
        Common.regModel(itemMegaDashJuice);
        Common.regModel(itemDemondrug);
        Common.regModel(itemMegaDemondrug);
        Common.regModel(itemArmourskin);
        Common.regModel(itemMegaArmourskin);

        Common.regModel(itemCatalyst);

        Common.regModel(itemWhetstone);

        Common.regModel(itemRawMeat);
        Common.regModel(itemRareSteak);
        Common.regModel(itemDoneSteak);
        Common.regModel(itemBurntMeat);

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

        Common.regModel(itemEarthCrystal);
        Common.regModel(itemMachaliteIngot);
        Common.regModel(itemDragoniteIngot);

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
        Common.regModel(itemHoney);

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
        Common.regModel(itemDung);

        Common.regModel(itemAltarothJaw);
        Common.regModel(itemAltarothStomach);

        Common.regModel(itemKelbiHorn);
        Common.regModel(itemWarmPelt);

        Common.regModel(itemGargwaFeather);
        Common.regModel(itemSteelEgg);

        Common.regModel(itemMonsterFluid);

        Common.regModel(itemBirdWyvernFang);

        Common.regModel(itemScreamerSac);

        Common.regModel(itemJaggiHide);
        Common.regModel(itemJaggiScale);

        Common.regModel(itemVelocipreyHide);
        Common.regModel(itemVelocipreyScale);

        Common.regModel(itemGenpreyHide);
        Common.regModel(itemGenpreyScale);
        Common.regModel(itemGenpreyFang);

        Common.regModel(itemGreatJaggiHide);
        Common.regModel(itemGreatJaggiClaw);
        Common.regModel(itemGreatJaggiHead);
        Common.regModel(itemKingsFrill);

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
        Common.regModel(weaponRuggedGreatSword);
        Common.regModel(weaponBusterSwordPlus);
        Common.regModel(weaponRavagerBlade);

        Common.regModel(weaponBoneBlade);
        Common.regModel(weaponBoneBladePlus);
        Common.regModel(weaponJawblade);
        Common.regModel(weaponGiantJawblade);

        Common.regModel(iconGreatJaggi);
        Common.regModel(iconGendrome);
        Common.regModel(iconIodrome);
        Common.regModel(iconVelocidrome);
        Common.regModel(iconKirin);
    }
}
