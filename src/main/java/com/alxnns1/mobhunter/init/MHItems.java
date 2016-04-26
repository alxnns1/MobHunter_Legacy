package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.ItemMHArmour;
import com.alxnns1.mobhunter.item.ItemMHFood;
import com.alxnns1.mobhunter.item.ItemMHResource;
import com.alxnns1.mobhunter.item.ItemMHSword;
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
    public static final ItemMHResource itemMysteryBone = new ItemMHResource(Names.Items.MYSTERY_BONE);
    public static final ItemMHResource itemMonsterBoneS = new ItemMHResource(Names.Items.MONSTER_BONE_S);

    public static final ItemMHFood itemRawMeat = new ItemMHFood(3, 0.3F, true, Names.Items.RAW_MEAT);
    public static final ItemMHFood itemRareSteak = new ItemMHFood(5, 0.4F, true, Names.Items.RARE_STEAK);
    public static final ItemMHFood itemDoneSteak = new ItemMHFood(10, 1.0F, true, Names.Items.DONE_STEAK);
    public static final ItemMHFood itemBurntMeat = new ItemMHFood(5, 0.3F, true, Names.Items.BURNT_MEAT);

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
        GameRegistry.registerItem(itemMysteryBone, Names.Items.MYSTERY_BONE);
        GameRegistry.registerItem(itemMonsterBoneS, Names.Items.MONSTER_BONE_S);

        GameRegistry.registerItem(itemRawMeat, Names.Items.RAW_MEAT);
        GameRegistry.registerItem(itemRareSteak, Names.Items.RARE_STEAK);
        GameRegistry.registerItem(itemDoneSteak, Names.Items.DONE_STEAK);
        GameRegistry.registerItem(itemBurntMeat, Names.Items.BURNT_MEAT);

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
        Common.regModel(itemMysteryBone);
        Common.regModel(itemMonsterBoneS);

        Common.regModel(itemRawMeat);
        Common.regModel(itemRareSteak);
        Common.regModel(itemDoneSteak);
        Common.regModel(itemBurntMeat);

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
