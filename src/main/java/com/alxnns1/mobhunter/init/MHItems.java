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

    public static ItemMHResource itemRawMeat;

    public static ItemMHPickaxe itemMachalitePickaxe, itemDragonitePickaxe, itemGossamitePickaxe;

    public static ItemMHConsumable itemRareSteak, itemDoneSteak, itemBurntMeat;

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

    public static ItemMHResource itemPlant, itemMushroom, itemBerry, itemBug, itemMonsterDrop, itemOre, itemIcon, itemMisc;
    public static ItemMHConsumable itemConsumable;
    public static ItemMHDrink itemDrink;

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

        regItem(itemMachalitePickaxe = new ItemMHPickaxe(Names.Items.MACHALITE_PICKAXE, 2, 500, 7.0f, 3f));
        regItem(itemDragonitePickaxe = new ItemMHPickaxe(Names.Items.DRAGONITE_PICKAXE, 3, 750, 7.0f, 4f));
        regItem(itemGossamitePickaxe = new ItemMHPickaxe(Names.Items.GOSSAMITE_PICKAXE, 3, 1000, 8.0f, 5f));

        regItem(itemRawMeat = new ItemMHResource(Names.Items.RAW_MEAT));
        regItem(itemRareSteak = new ItemMHConsumable(5, 0.4F, true, Names.Items.RARE_STEAK));
        regItem(itemDoneSteak = new ItemMHConsumable(10, 1.0F, true, Names.Items.DONE_STEAK));
        regItem(itemBurntMeat = new ItemMHConsumable(5, 0.3F, true, Names.Items.BURNT_MEAT));

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
            These new registrations are down here atm for testing
         */

        //TODO: Need to go update ALL references to the items throughout the mod!

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
        regItem(itemMisc = new ItemMHResource("misc",
                "catalyst", "whetstone", "miniWhetstone"));
        regItem(itemConsumable = new ItemMHConsumable("consumable",
                "herb", "antidoteHerb", "fireHerb",
                "nitroshroom", "parashroom", "toadstool", "exciteshroom", "mopeshroom",
                "mightSeed", "adamantSeed", "nullberry", "needleberry", "bomberry",
                "bitterbug"));
        regItem(itemDrink = new ItemMHDrink("drink",
                "potion", "megaPotion", "antidote", "immunizer", "dashJuice", "megaDashJuice", "demondrug",
                "megaDemondrug", "armourskin", "megaArmourskin"));

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
