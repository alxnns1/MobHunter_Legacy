package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.item.ItemArmourResource;
import com.alxnns1.mobhunter.item.ItemResource;
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
    public static ItemArmor.ArmorMaterial boneArmourMaterial = EnumHelper.addArmorMaterial("Bone", Reference.MOD_ID + ":bone", 10, new int[]{2, 4, 3, 2}, 20);

    public static ItemArmor armourBoneHelmet = new ItemArmourResource(boneArmourMaterial,1,0,Names.Items.BONE_HELMET);
    public static ItemArmor armourBoneChestplate = new ItemArmourResource(boneArmourMaterial,1,1,Names.Items.BONE_CHESTPLATE);
    public static ItemArmor armourBoneLeggings = new ItemArmourResource(boneArmourMaterial,2,2,Names.Items.BONE_LEGGINGS);
    public static ItemArmor armourBoneBoots = new ItemArmourResource(boneArmourMaterial,1,3,Names.Items.BONE_BOOTS);

    public static final ItemResource itemBoneMail = new ItemResource(Names.Items.BONE_MAIL);
    public static final ItemResource itemMachaliteIngot = new ItemResource(Names.Items.MACHALITE_INGOT);
    public static final ItemResource itemEarthCrystal = new ItemResource(Names.Items.EARTH_CRYSTAL);

    /**
     * Registers the items
     */
    public static void init()
    {
        GameRegistry.registerItem(itemBoneMail, Names.Items.BONE_MAIL);
        GameRegistry.registerItem(itemMachaliteIngot, Names.Items.MACHALITE_INGOT);
        GameRegistry.registerItem(itemEarthCrystal, Names.Items.EARTH_CRYSTAL);

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
        Common.regModel(itemBoneMail);
        Common.regModel(itemMachaliteIngot);
        Common.regModel(itemEarthCrystal);

        Common.regModel(armourBoneHelmet);
        Common.regModel(armourBoneChestplate);
        Common.regModel(armourBoneLeggings);
        Common.regModel(armourBoneBoots);
    }
}
