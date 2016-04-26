package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.ItemArmourResource;
import com.alxnns1.mobhunter.item.ItemResource;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemFood;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains all of the mod's items and registering code
 * Created by Mark on 21/04/2016.
 */
public class MHItems
{
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 10, new int[]{2, 4, 3, 2}, 20);

    public static ItemArmor armourBoneHelmet = new ItemArmourResource(boneArmourMaterial,1,0,Names.Items.BONE_HELMET);
    public static ItemArmor armourBoneChestplate = new ItemArmourResource(boneArmourMaterial,1,1,Names.Items.BONE_CHESTPLATE);
    public static ItemArmor armourBoneLeggings = new ItemArmourResource(boneArmourMaterial,2,2,Names.Items.BONE_LEGGINGS);
    public static ItemArmor armourBoneBoots = new ItemArmourResource(boneArmourMaterial,1,3,Names.Items.BONE_BOOTS);

    public static final ItemResource itemEarthCrystal = new ItemResource(Names.Items.EARTH_CRYSTAL);
    public static final ItemResource itemMachaliteIngot = new ItemResource(Names.Items.MACHALITE_INGOT);
    public static final ItemResource itemMysteryBone = new ItemResource(Names.Items.MYSTERY_BONE);
    public static final ItemResource itemMonsterBoneS = new ItemResource(Names.Items.MONSTER_BONE_S);
    public static final Item itemRawMeat = new ItemFood(3, 0.3F, true).setUnlocalizedName(Names.Items.RAW_MEAT);

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

        GameRegistry.registerItem(armourBoneHelmet,Names.Items.BONE_HELMET);
        GameRegistry.registerItem(armourBoneChestplate,Names.Items.BONE_CHESTPLATE);
        GameRegistry.registerItem(armourBoneLeggings,Names.Items.BONE_LEGGINGS);
        GameRegistry.registerItem(armourBoneBoots,Names.Items.BONE_BOOTS);
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

        Common.regModel(armourBoneHelmet);
        Common.regModel(armourBoneChestplate);
        Common.regModel(armourBoneLeggings);
        Common.regModel(armourBoneBoots);
    }
}
