package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.*;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHItems
{
    public static List<Item> ITEMS = new ArrayList<Item>();
    
    public static void regItem(Item item)
    {
        GameRegistry.register(item);
        ITEMS.add(item);
    }
    
    public static ItemArmor.ArmorMaterial derringArmourMaterial = EnumHelper.addArmorMaterial("Derring", Reference.MOD_ID + ":derring", 5, new int[]{1, 3, 2, 1}, 6, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial hunterArmourMaterial = EnumHelper.addArmorMaterial("Hunter's", Reference.MOD_ID + ":hunter", 15, new int[]{2, 3, 3, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 17, new int[]{2, 5, 4, 2}, 8, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0f);
    public static ItemArmor.ArmorMaterial alloyArmourMaterial = EnumHelper.addArmorMaterial("Alloy", Reference.MOD_ID + ":alloy", 19, new int[]{2, 6, 5, 2}, 6, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0f);

    public static ItemArmor armourDerringHelmet, armourDerringChestplate, armourDerringLeggings, armourDerringBoots,
            armourHunterHelmet, armourHunterChestplate, armourHunterLeggings, armourHunterBoots,
            armourBoneHelmet, armourBoneChestplate, armourBoneLeggings, armourBoneBoots,
            armourAlloyHelmet, armourAlloyChestplate, armourAlloyLeggings, armourAlloyBoots;

    public static ItemMHDrink itemPotion, itemMegaPotion, itemNutrients, itemMegaNutrients, itemAntidote, itemImmunizer,
            itemDashJuice, itemMegaDashJuice, itemDemondrug, itemMegaDemondrug, itemArmourskin, itemMegaArmourskin;

    public static ItemMHResource itemCatalyst, itemWhetstone, itemMiniWhetstone, itemRawMeat;

    public static ItemMHPickaxe itemMachalitePickaxe, itemDragonitePickaxe, itemGossamitePickaxe;

    public static ItemMHConsumable itemRareSteak, itemDoneSteak, itemBurntMeat;/*,
            itemHerb, itemAntidoteHerb, itemFireHerb,
            itemNitroshroom, itemParashroom, itemToadstool, itemExciteshroom, itemMopeshroom,
            itemMightSeed, itemAdamantSeed, itemNulberry, itemNeedleberry, itemBomberry,
            itemBitterbug;
            */

    /*
    public static ItemMHResource itemIvy, itemSleepHerb, itemSapPlant, itemFelvine, itemGloamgrassRoot, itemHotPepper,
            itemBlueMushroom, itemDragonToadstool,
            itemHuskberry, itemPaintberry, itemDragonfellBerry, itemScatternut, itemLatchberry,
            itemEarthCrystal, itemMachaliteIngot, itemDragoniteIngot, itemLightCrystal, itemIceCrystal, itemGossamiteIngot,
            itemInsectHusk, itemStinkhopper, itemSnakebeeLarva, itemGodbug, itemFlashbug, itemThunderbug, itemGlueglopper,
            itemKillerBeetle, itemHercudrome, itemRareScarab, itemHoney,
            itemMonsterBoneS, itemMonsterBoneM, itemMysteryBone, itemUnknownSkull, itemBruteBone, itemJumboBone, itemDung, itemBoneHusk,
            itemAltarothJaw, itemAltarothStomach,
            itemKelbiHorn, itemWarmPelt,
            itemGargwaFeather, itemSteelEgg,
            itemMonsterFluid,
            itemBirdWyvernFang,
            itemScreamerSac,
            itemJaggiHide, itemJaggiScale, itemJaggiFang,
            itemVelocipreyHide, itemVelocipreyScale, itemVelocipreyFang,
            itemGenpreyHide, itemGenpreyScale, itemGenpreyFang,
            itemGreatJaggiHide, itemGreatJaggiClaw, itemGreatJaggiHead, itemKingsFrill,
            iconGreatJaggi, iconGendrome, iconIodrome, iconVelocidrome, iconKirin;
    */

    public static ItemMHSword weaponTest,
            weaponHuntersKnife, weaponSoldiersDagger, weaponCommandersDagger, weaponSerpentBite, weaponSerpentBitePlus,
            weaponDeadlock, weaponViperBite, weaponViperBitePlus, weaponDeathprize, weaponHuntersKnifePlus,
            weaponHuntersDagger, weaponAssassinsDagger,
            weaponBoneKris, weaponBoneKrisPlus, weaponChiefKris,
            weaponRottonSword, weaponPlaguedSword, weaponInfestedSword,
            weaponSkeletalSword, weaponSkeletalSwordPlus, weaponWitheredSword, weaponWitheredSwordPlus, weaponNecrosisBlade,
            weaponMandiblade, weaponMandibladePlus, weaponStingingMandiblade, weaponPoisonStingblade,
            weaponFearSword, weaponTerrorSword, weaponDreadSword,
            weaponXenoblade, weaponXenobladePlus, weaponAstralSword, weaponAstralEndsword,
            weaponSlimySword, weaponSlimySwordPlus, weaponCrystalizedSlimeblade, weaponMagmaticSlimeblade,
            weaponBlazingSword, weaponBlazingTempest, weaponBlazingInferno;

    public static ItemMHShield shieldTest;

    /*
        These are the new meta items, and are just down here while testing.
     */

    public static ItemMHResource itemPlant, itemMushroom, itemBerry, itemBug, itemMonsterDrop, itemOre, itemIcon;
    public static ItemMHConsumable itemConsumable;

    /**
     * Registers the items
     */
    public static void regItems()
    {
        regItem(armourDerringHelmet = new ItemMHArmour(derringArmourMaterial, EntityEquipmentSlot.HEAD,Names.Items.DERRING_HELMET));
        regItem(armourDerringChestplate = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.DERRING_CHESTPLATE));
        regItem(armourDerringLeggings = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.DERRING_LEGGINGS));
        regItem(armourDerringBoots = new ItemMHArmour(derringArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.DERRING_BOOTS));

        regItem(armourHunterHelmet = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.HUNTER_HELMET));
        regItem(armourHunterChestplate = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.HUNTER_CHESTPLATE));
        regItem(armourHunterLeggings = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.HUNTER_LEGGINGS));
        regItem(armourHunterBoots = new ItemMHArmour(hunterArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.HUNTER_BOOTS));

        regItem(armourBoneHelmet = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.BONE_HELMET));
        regItem(armourBoneChestplate = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.BONE_CHESTPLATE));
        regItem(armourBoneLeggings = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.BONE_LEGGINGS));
        regItem(armourBoneBoots = new ItemMHArmour(boneArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.BONE_BOOTS));

        regItem(armourAlloyHelmet = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.HEAD,Names.Items.ALLOY_HELMET));
        regItem(armourAlloyChestplate = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.CHEST,Names.Items.ALLOY_CHESTPLATE));
        regItem(armourAlloyLeggings = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.LEGS,Names.Items.ALLOY_LEGGINGS));
        regItem(armourAlloyBoots = new ItemMHArmour(alloyArmourMaterial,EntityEquipmentSlot.FEET,Names.Items.ALLOY_BOOTS));
        
        regItem(itemPotion = new ItemMHDrink(Names.Items.POTION));
        regItem(itemMegaPotion = new ItemMHDrink(Names.Items.MEGA_POTION));
        //regItem(itemNutrients = new ItemMHDrink(Names.Items.NUTRIENTS));
        //regItem(itemMegaNutrients = new ItemMHDrink(Names.Items.MEGA_NUTRIENTS));
        regItem(itemAntidote = new ItemMHDrink(Names.Items.ANTIDOTE));
        regItem(itemImmunizer = new ItemMHDrink(Names.Items.IMMUNIZER));
        regItem(itemDashJuice = new ItemMHDrink(Names.Items.DASH_JUICE));
        regItem(itemMegaDashJuice = new ItemMHDrink(Names.Items.MEGA_DASH_JUICE));
        regItem(itemDemondrug = new ItemMHDrink(Names.Items.DEMONDRUG));
        regItem(itemMegaDemondrug = new ItemMHDrink(Names.Items.MEGA_DEMONDRUG));
        regItem(itemArmourskin = new ItemMHDrink(Names.Items.ARMOURSKIN));
        regItem(itemMegaArmourskin = new ItemMHDrink(Names.Items.MEGA_ARMOURSKIN));

        regItem(itemCatalyst = new ItemMHResource(Names.Items.CATALYST));

        regItem(itemWhetstone = new ItemMHResource(Names.Items.WHETSTONE));
        regItem(itemMiniWhetstone = new ItemMHResource(Names.Items.MINI_WHETSTONE));

        regItem(itemMachalitePickaxe = new ItemMHPickaxe(Names.Items.MACHALITE_PICKAXE, 2, 500, 7.0f, 3f));
        regItem(itemDragonitePickaxe = new ItemMHPickaxe(Names.Items.DRAGONITE_PICKAXE, 3, 750, 7.0f, 4f));
        regItem(itemGossamitePickaxe = new ItemMHPickaxe(Names.Items.GOSSAMITE_PICKAXE, 3, 1000, 8.0f, 5f));

        regItem(itemRawMeat = new ItemMHResource(Names.Items.RAW_MEAT));
        regItem(itemRareSteak = new ItemMHConsumable(5, 0.4F, true, Names.Items.RARE_STEAK));
        regItem(itemDoneSteak = new ItemMHConsumable(10, 1.0F, true, Names.Items.DONE_STEAK));
        regItem(itemBurntMeat = new ItemMHConsumable(5, 0.3F, true, Names.Items.BURNT_MEAT));

        /*
        regItem(itemHerb = new ItemMHConsumable(Names.Items.HERB, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemAntidoteHerb = new ItemMHConsumable(Names.Items.ANTIDOTE_HERB, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemFireHerb = new ItemMHConsumable(Names.Items.FIRE_HERB, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemIvy = new ItemMHResource(Names.Items.IVY));
        regItem(itemSleepHerb = new ItemMHResource(Names.Items.SLEEP_HERB));
        regItem(itemSapPlant = new ItemMHResource(Names.Items.SAP_PLANT));
        regItem(itemFelvine = new ItemMHResource(Names.Items.FELVINE));
        regItem(itemGloamgrassRoot = new ItemMHResource(Names.Items.GLOAMGRASS_ROOT));
        regItem(itemHotPepper = new ItemMHResource(Names.Items.HOT_PEPPER));

        regItem(itemBlueMushroom = new ItemMHResource(Names.Items.BLUE_MUSHROOM));
        regItem(itemNitroshroom = new ItemMHConsumable(Names.Items.NITROSHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemParashroom = new ItemMHConsumable(Names.Items.PARASHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemToadstool = new ItemMHConsumable(Names.Items.TOADSTOOL, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemExciteshroom = new ItemMHConsumable(Names.Items.EXCITESHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemMopeshroom = new ItemMHConsumable(Names.Items.MOPESHROOM, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemDragonToadstool = new ItemMHResource(Names.Items.DRAGON_TOADSTOOL));

        regItem(itemHuskberry = new ItemMHResource(Names.Items.HUSKBERRY));
        regItem(itemPaintberry = new ItemMHResource(Names.Items.PAINTBERRY));
        regItem(itemMightSeed = new ItemMHConsumable(Names.Items.MIGHT_SEED, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemAdamantSeed = new ItemMHConsumable(Names.Items.ADAMANT_SEED, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemNulberry = new ItemMHConsumable(Names.Items.NULBERRY, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemDragonfellBerry = new ItemMHResource(Names.Items.DRAGONFELL_BERRY));
        regItem(itemScatternut = new ItemMHResource(Names.Items.SCATTERNUT));
        regItem(itemNeedleberry = new ItemMHConsumable(Names.Items.NEEDLEBERRY, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemLatchberry = new ItemMHResource(Names.Items.LATCHBERRY));
        regItem(itemBomberry = new ItemMHConsumable(Names.Items.BOMBERRY, true, ItemMHConsumable.EAT_DURATION_SHORT));

        regItem(itemEarthCrystal = new ItemMHResource(Names.Items.EARTH_CRYSTAL));
        regItem(itemMachaliteIngot = new ItemMHResource(Names.Items.MACHALITE_INGOT));
        regItem(itemDragoniteIngot = new ItemMHResource(Names.Items.DRAGONITE_INGOT));
        regItem(itemLightCrystal = new ItemMHResource(Names.Items.LIGHT_CRYSTAL));
        regItem(itemIceCrystal = new ItemMHResource(Names.Items.ICE_CRYSTAL));
        regItem(itemGossamiteIngot = new ItemMHResource(Names.Items.GOSSAMITE_INGOT));

        regItem(itemInsectHusk = new ItemMHResource(Names.Items.INSECT_HUSK));
        regItem(itemStinkhopper = new ItemMHResource(Names.Items.STINKHOPPER));
        regItem(itemSnakebeeLarva = new ItemMHResource(Names.Items.SNAKEBEE_LARVA));
        regItem(itemGodbug = new ItemMHResource(Names.Items.GODBUG));
        regItem(itemBitterbug = new ItemMHConsumable(Names.Items.BITTERBUG, true, ItemMHConsumable.EAT_DURATION_SHORT));
        regItem(itemFlashbug = new ItemMHResource(Names.Items.FLASHBUG));
        regItem(itemThunderbug = new ItemMHResource(Names.Items.THUNDERBUG));
        regItem(itemGlueglopper = new ItemMHResource(Names.Items.GLUEGLOPPER));
        regItem(itemKillerBeetle = new ItemMHResource(Names.Items.KILLER_BEETLE));
        regItem(itemHercudrome = new ItemMHResource(Names.Items.HERCUDROME));
        regItem(itemRareScarab = new ItemMHResource(Names.Items.RARE_SCARAB));
        regItem(itemHoney = new ItemMHResource(Names.Items.HONEY));

        regItem(itemMonsterBoneS = new ItemMHResource(Names.Items.MONSTER_BONE_S));
        regItem(itemMonsterBoneM = new ItemMHResource(Names.Items.MONSTER_BONE_M));
        regItem(itemMysteryBone = new ItemMHResource(Names.Items.MYSTERY_BONE));
        regItem(itemUnknownSkull = new ItemMHResource(Names.Items.UNKNOWN_SKULL));
        regItem(itemBruteBone = new ItemMHResource(Names.Items.BRUTE_BONE));
        regItem(itemJumboBone = new ItemMHResource(Names.Items.JUMBO_BONE));
        regItem(itemDung = new ItemMHResource(Names.Items.DUNG));
        regItem(itemBoneHusk = new ItemMHResource(Names.Items.BONE_HUSK));

        regItem(itemAltarothJaw = new ItemMHResource(Names.Items.ALTAROTH_JAW));
        regItem(itemAltarothStomach = new ItemMHResource(Names.Items.ALTAROTH_STOMACH));

        regItem(itemKelbiHorn = new ItemMHResource(Names.Items.KELBI_HORN));
        regItem(itemWarmPelt = new ItemMHResource(Names.Items.WARM_PELT));

        regItem(itemGargwaFeather = new ItemMHResource(Names.Items.GARGWA_FEATHER));
        regItem(itemSteelEgg = new ItemMHResource(Names.Items.STEEL_EGG));

        regItem(itemMonsterFluid = new ItemMHResource(Names.Items.MONSTER_FLUID));

        regItem(itemBirdWyvernFang = new ItemMHResource(Names.Items.BIRD_WYVERN_FANG));

        regItem(itemScreamerSac = new ItemMHResource(Names.Items.SCREAMER_SAC));

        regItem(itemJaggiHide = new ItemMHResource(Names.Items.JAGGI_HIDE));
        regItem(itemJaggiScale = new ItemMHResource(Names.Items.JAGGI_SCALE));
        regItem(itemJaggiFang = new ItemMHResource(Names.Items.JAGGI_FANG));

        regItem(itemVelocipreyHide = new ItemMHResource(Names.Items.VELOCIPREY_HIDE));
        regItem(itemVelocipreyScale = new ItemMHResource(Names.Items.VELOCIPREY_SCALE));
        regItem(itemVelocipreyFang = new ItemMHResource(Names.Items.VELOCIPREY_FANG));

        regItem(itemGenpreyHide = new ItemMHResource(Names.Items.GENPREY_HIDE));
        regItem(itemGenpreyScale = new ItemMHResource(Names.Items.GENPREY_SCALE));
        regItem(itemGenpreyFang = new ItemMHResource(Names.Items.GENPREY_FANG));

        regItem(itemGreatJaggiHide = new ItemMHResource(Names.Items.GREAT_JAGGI_HIDE));
        regItem(itemGreatJaggiClaw = new ItemMHResource(Names.Items.GREAT_JAGGI_CLAW));
        regItem(itemGreatJaggiHead = new ItemMHResource(Names.Items.GREAT_JAGGI_HEAD));
        regItem(itemKingsFrill = new ItemMHResource(Names.Items.KINGS_FRILL));
        */

        regItem(weaponTest = new ItemMHSword("weaponTest", 1f, 5, 10, 15, 20, 25, 30, 35));
        regItem(shieldTest = new ItemMHShield("shieldTest", 100, Items.IRON_INGOT));

        regItem(weaponHuntersKnife = new ItemMHSword(Names.Items.HUNTERS_KNIFE, 6f, 140, 280, 400));
        regItem(weaponSoldiersDagger = new ItemMHSword(Names.Items.SOLDIERS_DAGGER, 8f, 100, 160, 420, 500));
        regItem(weaponCommandersDagger = new ItemMHSword(Names.Items.COMMANDERS_DAGGER, 10f, 100, 240, 400, 500));
        regItem(weaponSerpentBite = new ItemMHSword(Names.Items.SERPENT_BITE, 10f, 120, 200, 440, 500));
        regItem(weaponSerpentBitePlus = new ItemMHSword(Names.Items.SERPENT_BITE_PLUS, 15f, 120, 180, 380, 500));
        regItem(weaponDeadlock = new ItemMHSword(Names.Items.DEADLOCK, 20f, 140, 200, 400, 580, 600));
        regItem(weaponViperBite = new ItemMHSword(Names.Items.VIPER_BITE, 10f, 120, 200, 440, 500));
        regItem(weaponViperBitePlus = new ItemMHSword(Names.Items.VIPER_BITE_PLUS, 15f, 120, 180, 380, 500));
        regItem(weaponDeathprize = new ItemMHSword(Names.Items.DEATHPRIZE, 20f, 140, 200, 400, 580, 600));
        regItem(weaponHuntersKnifePlus = new ItemMHSword(Names.Items.HUNTERS_KNIFE_PLUS, 7f, 60, 200, 400));
        regItem(weaponHuntersDagger = new ItemMHSword(Names.Items.HUNTERS_DAGGER, 8f, 140, 280, 400));
        regItem(weaponAssassinsDagger = new ItemMHSword(Names.Items.ASSASSINS_DAGGER, 9f, 120, 200, 400));

        //TODO: Need to finish adding these sword with sharpness levels

        regItem(weaponBoneKris = new ItemMHSword(Names.Items.BONE_KRIS, 4f));
        regItem(weaponBoneKrisPlus = new ItemMHSword(Names.Items.BONE_KRIS_PLUS, 7f));
        regItem(weaponChiefKris = new ItemMHSword(Names.Items.CHIEF_KRIS, 10f));
        regItem(weaponRottonSword = new ItemMHSword(Names.Items.ROTTEN_SWORD, 6f));
        regItem(weaponPlaguedSword = new ItemMHSword(Names.Items.PLAGUED_SWORD, 8f));
        regItem(weaponInfestedSword = new ItemMHSword(Names.Items.INFESTED_SWORD, 10f));
        regItem(weaponSkeletalSword = new ItemMHSword(Names.Items.SKELETAL_SWORD, 6f));
        regItem(weaponSkeletalSwordPlus = new ItemMHSword(Names.Items.SKELETAL_SWORD_PLUS, 8f));
        regItem(weaponWitheredSword = new ItemMHSword(Names.Items.WITHERED_SWORD, 11f));
        regItem(weaponWitheredSwordPlus = new ItemMHSword(Names.Items.WITHERED_SWORD_PLUS, 14f));
        regItem(weaponNecrosisBlade = new ItemMHSword(Names.Items.NECROSIS_BLADE, 18f));
        regItem(weaponMandiblade = new ItemMHSword(Names.Items.MANDIBLADE, 6f));
        regItem(weaponMandibladePlus = new ItemMHSword(Names.Items.MANDIBLADE_PLUS, 8f));
        regItem(weaponStingingMandiblade = new ItemMHSword(Names.Items.STINGING_MANDIBLADE, 11f));
        regItem(weaponPoisonStingblade = new ItemMHSword(Names.Items.POISON_STINGBLADE, 14f));
        regItem(weaponFearSword = new ItemMHSword(Names.Items.FEAR_SWORD, 6f));
        regItem(weaponTerrorSword = new ItemMHSword(Names.Items.TERROR_SWORD, 8f));
        regItem(weaponDreadSword = new ItemMHSword(Names.Items.DREAD_SWORD, 10f));
        regItem(weaponXenoblade = new ItemMHSword(Names.Items.XENOBLADE, 6f));
        regItem(weaponXenobladePlus = new ItemMHSword(Names.Items.XENOBLADE_PLUS, 8f));
        regItem(weaponAstralSword = new ItemMHSword(Names.Items.ASTRAL_SWORD, 11f));
        regItem(weaponAstralEndsword = new ItemMHSword(Names.Items.ASTRAL_ENDSWORD, 15f));
        regItem(weaponSlimySword = new ItemMHSword(Names.Items.SLIMY_SWORD, 6f));
        regItem(weaponSlimySwordPlus = new ItemMHSword(Names.Items.SLIMY_SWORD_PLUS, 8f));
        regItem(weaponCrystalizedSlimeblade = new ItemMHSword(Names.Items.CRYSTALIZED_SLIMEBLADE, 11f));
        regItem(weaponMagmaticSlimeblade = new ItemMHSword(Names.Items.MAGMATIC_SLIMEBLADE, 14f));
        regItem(weaponBlazingSword = new ItemMHSword(Names.Items.BLAZING_SWORD, 6f));
        regItem(weaponBlazingTempest = new ItemMHSword(Names.Items.BLAZING_TEMPEST, 8f));
        regItem(weaponBlazingInferno = new ItemMHSword(Names.Items.BLAZING_INFERNO, 10f));

        /*
        regItem(iconGreatJaggi = new ItemMHResource(Names.Items.ICON_GREAT_JAGGI,false));
        regItem(iconGendrome = new ItemMHResource(Names.Items.ICON_GENDROME,false));
        regItem(iconIodrome = new ItemMHResource(Names.Items.ICON_IODROME,false));
        regItem(iconVelocidrome = new ItemMHResource(Names.Items.ICON_VELOCIDROME,false));
        regItem(iconKirin = new ItemMHResource(Names.Items.ICON_KIRIN,false));

        OreDictionary.registerOre("gemEarthCrystal", itemEarthCrystal);
        OreDictionary.registerOre("ingotMachalite", itemMachaliteIngot);
        OreDictionary.registerOre("ingotDragonite", itemDragoniteIngot);
        OreDictionary.registerOre("gemLightCrystal", itemLightCrystal);
        OreDictionary.registerOre("gemIceCrystal", itemIceCrystal);
        OreDictionary.registerOre("ingotGossamite", itemGossamiteIngot);
        */

        /*
            These new registrations are down here atm for testing
         */
        //itemPlant, itemMushroom, itemBerry, itemBug, itemMonsterDrop, itemOre, itemIcon, itemConsumable

        regItem(itemPlant = new ItemMHResource("plant",
                "ivy", "sleepHerb", "sapPlant", "felvine", "gloamgrassRoot", "hotPepper"));
        regItem(itemMushroom = new ItemMHResource("mushroom",
                "blueMushroom", "dragonToadstool"));
        regItem(itemBerry = new ItemMHResource("berry",
                "huskberry", "paintberry", "dragonfellBerry", "scatternut", "latchberry"));
        regItem(itemBug = new ItemMHResource("bug",
                "insectHusk", "stinkHopper", "snakebeeLarva", "godbug", "flashbug", "thunderbug", "glueglopper",
                "killerBeetle", "hercudrome", "rareScarab", "honey"));
        regItem(itemMonsterDrop = new ItemMHResource("monsterDrop",
                "monsterBoneS", "monsterBoneM", "mysteryBone", "unknownSkull", "bruteBone", "jumboBone", "dung",
                "boneHusk",
                "altarothJaw", "altarothStomach",
                "kelbiHorn", "warmPelt",
                "gargwaFeather", "steelEgg",
                "monsterFluid",
                "birdWyvernFang",
                "screamerSac",
                "jaggiHide", "jaggiScale", "jaggiFang",
                "velocipreyHide", "velocipreyScale", "velocipreyFang",
                "genpreyHide", "genpreyScale", "genpreyFang",
                "greatJaggiHide", "greatJaggiClaw", "greatJaggiHead", "kingsFrill"));
        regItem(itemOre = new ItemMHResource("ore",
                "earthCrystal", "machaliteIngot", "dragoniteIngot", "gossamiteIngot", "lightCrystal", "iceCrystal"));
        regItem(itemIcon = new ItemMHResource("icon", false,
                "greatJaggi", "gendrome", "iodrome", "velocidrome", "kirin"));

        regItem(itemConsumable = new ItemMHConsumable("consumable",
                "herb", "antidoteHerb", "fireHerb",
                "nitroshroom", "parashroom", "toadstool", "exciteshroom", "mopeshroom",
                "mightSeed", "adamantSeed", "nullberry", "needleberry", "bomberry",
                "bitterbug"));

        OreDictionary.registerOre("gemEarthCrystal", new ItemStack(itemOre, 1, 0));
        OreDictionary.registerOre("ingotMachalite", new ItemStack(itemOre, 1, 1));
        OreDictionary.registerOre("ingotDragonite", new ItemStack(itemOre, 1, 2));
        OreDictionary.registerOre("ingotGossamite", new ItemStack(itemOre, 1, 3));
        OreDictionary.registerOre("gemLightCrystal", new ItemStack(itemOre, 1, 4));
        OreDictionary.registerOre("gemIceCrystal", new ItemStack(itemOre, 1, 5));
    }

    /**
     * Registers the item models for the items
     * Only run this client-side!
     */
    public static void regModels()
    {
        for(Item item : ITEMS)
        {
            if(item instanceof ISubTypes && item.getHasSubtypes())
                for(int meta = 0; meta < ((ISubTypes) item).getSubNames().length; meta++)
                    ClientUtil.regModel(item, meta);
            else
                ClientUtil.regModel(item);
        }
    }
}
