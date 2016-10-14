package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.crafting.WeaponUpgradeManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains the recipes to be added
 * Created by Mark on 21/04/2016.
 */
public class MHRecipes
{
    public static void init()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemCatalyst), MHItems.itemHoney, MHItems.itemBitterbug);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemWhetstone), MHItems.itemMonsterBoneS, Items.IRON_INGOT);

        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemPotion), Items.GLASS_BOTTLE, MHItems.itemHerb, MHItems.itemBlueMushroom);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMegaPotion), Items.GLASS_BOTTLE, MHItems.itemPotion, MHItems.itemHoney);
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemNutrients), Items.GLASS_BOTTLE, MHItems.itemBlueMushroom, MHItems.itemGodbug);
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMegaNutrients), Items.GLASS_BOTTLE, MHItems.itemNutrients, MHItems.itemHoney);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemAntidote), Items.GLASS_BOTTLE, MHItems.itemBlueMushroom, MHItems.itemAntidoteHerb);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemImmunizer), Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemDragonToadstool);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDashJuice), Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemRareSteak);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDemondrug), Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemMightSeed);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemArmourskin), Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemAdamantSeed);

        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringHelmet), "yzy", "y y", "   ", 'y', Items.STRING, 'z', MHItems.itemMonsterBoneS);
        //2 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringChestplate), "x x", "xyx", "zzz", 'x', MHItems.itemMonsterBoneS, 'y', Items.IRON_INGOT, 'z', Items.STRING);
        //1 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringLeggings), "yzy", "   ", "   ", 'y', MHItems.itemMonsterBoneS, 'z', Items.IRON_INGOT);
        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringBoots), "   ", "y y", "z z", 'y', Items.STRING, 'z', MHItems.itemMonsterBoneS);

        //1 Machalite Ingot + 1 Iron Ore + 2 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterHelmet), "xyx", "z z", "   ", 'x', Items.IRON_INGOT, 'y', MHItems.itemMachaliteIngot, 'z', MHItems.itemGlueglopper);
        //2 Iron Ingot + 3 Jaggi Scale + 2 Monster Bone S + 1 Earth Crystal + 1 Ivy
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterChestplate), "w w", "xyx", "zxz", 'w', Items.IRON_INGOT, 'x', MHItems.itemJaggiScale, 'y', MHItems.itemEarthCrystal, 'z', MHItems.itemMonsterBoneS);
        //2 Machalite Ingot + 1 Iron Ingot + 1 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterLeggings), "xyx", "z z", "   ", 'x', MHItems.itemMachaliteIngot, 'y', MHItems.itemGlueglopper, 'z', Items.IRON_INGOT);
        //1 Iron Ingot + 1 Earth Crystal + 2 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterBoots), "   ", "y y", "z z", 'y', Items.IRON_INGOT, 'z', MHItems.itemMonsterBoneS);

        //2 Mystery Bone + 1 Unknown Skull + 1 Altaroth Jaw
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), "xyx", "z z", "   ", 'x', MHItems.itemMysteryBone, 'y', MHItems.itemUnknownSkull, 'z', MHItems.itemAltarothJaw);
        //4 Mystery Bone + 1 Jumbo Bone + 2 Altaroth Stomach + 2 Monster Bone S + 2 Monster Fluid
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), "w w", "xyx", "xzx", 'w', MHItems.itemMonsterBoneS, 'x', MHItems.itemMysteryBone, 'y', MHItems.itemJumboBone, 'z', MHItems.itemAltarothStomach);
        //2 Mystery Bone + 2 Monster Bone S + 2 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), "wxw", "y y", "z z", 'w', MHItems.itemBirdWyvernFang, 'x', Items.STRING, 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneS);
        //2 Mystery Bone + 1 Monster Bone M + 1 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), "   ", "y y", "z z", 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneM);

        //3 Machalite Ingot + 2 Earth Crystal + 3 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyHelmet), "xyx", "z z", "   ", 'x', MHItems.itemMachaliteIngot, 'y', MHItems.itemEarthCrystal, 'z', Items.IRON_INGOT);
        //5 Machalite Ingot + 2 Monster Bone S + 6 Iron Ingot + 2 Earth Crystal
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyChestplate), "x x", "yxy", "yzy", 'x', MHItems.itemMachaliteIngot, 'y', Items.IRON_INGOT, 'z', MHItems.itemEarthCrystal);
        //2 Machalite Ingot + 2 Monster Bone S + 3 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyLeggings), "xyx", "z z", "y y", 'x', MHItems.itemMachaliteIngot, 'y', Items.IRON_INGOT, 'z', MHItems.itemMonsterBoneS);
        //4 Machalite Ingot + 2 Earth Crystal + 2 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyBoots), "   ", "y y", "z z", 'y', Items.IRON_INGOT, 'z', MHItems.itemMachaliteIngot);

        GameRegistry.addRecipe(new ItemStack(MHItems.weaponHuntersKnife), " z ", " z ", " z ", 'z', Items.IRON_INGOT);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSoldiersDagger), "zyx", "zyx", "zvw", 'v', MHItems.weaponHuntersKnifePlus, 'w', MHItems.itemGreatJaggiHide, 'x', MHItems.itemJaggiHide, 'y', MHItems.itemJaggiScale, 'z', MHItems.itemEarthCrystal);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponCommandersDagger), "xzy", "xzy", "ywz", 'w', MHItems.weaponSoldiersDagger, 'x', MHItems.itemGreatJaggiClaw, 'y', MHItems.itemGreatJaggiHide, 'z', MHItems.itemMachaliteIngot);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSerpentBite), "yyx", "yzx", "ywx", 'w', MHItems.weaponAssassinsDagger, 'x', MHItems.itemVelocipreyHide, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSerpentBitePlus), "yyx", "yzz", "yxz", 'x', MHItems.weaponSerpentBite, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponDeadlock), "yyx", "yzz", "yxz", 'x', MHItems.weaponSerpentBitePlus, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneM);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponViperBite), "yyx", "yzx", "ywx", 'w', MHItems.weaponAssassinsDagger, 'x', MHItems.itemGenpreyHide, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponViperBitePlus), "yyx", "yzz", "yxz", 'x', MHItems.weaponViperBite, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponDeathprize), "yyx", "yzz", "yxz", 'x', MHItems.weaponViperBitePlus, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneM);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponHuntersKnifePlus), " yy", " yy", " yz", 'y', Items.IRON_INGOT, 'z', MHItems.weaponHuntersKnife);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponHuntersDagger), "yxx", "yzx", " wx", 'w', MHItems.weaponHuntersKnife, 'x', MHItems.itemEarthCrystal, 'y', MHItems.itemMachaliteIngot, 'z', MHItems.itemGlueglopper);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponAssassinsDagger), "yxx", "yzx", " wx", 'w', MHItems.weaponHuntersDagger, 'x', MHItems.itemMysteryBone, 'y', MHItems.itemMonsterBoneM, 'z', MHItems.itemGlueglopper);

        GameRegistry.addRecipe(new ItemStack(MHItems.itemMachalitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemMachaliteIngot), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(MHItems.itemDragonitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemDragoniteIngot), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(MHItems.itemGossamitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemGossamiteIngot), 'y', new ItemStack(Items.STICK));

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockEarthCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemEarthCrystal));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemEarthCrystal, 9), MHBlocks.blockEarthCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockMachalite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemMachaliteIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMachaliteIngot, 9), MHBlocks.blockMachalite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockDragonite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemDragoniteIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDragoniteIngot, 9), MHBlocks.blockDragonite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockLightCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemLightCrystal));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemLightCrystal, 9), MHBlocks.blockLightCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockIceCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemIceCrystal));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemIceCrystal, 9), MHBlocks.blockIceCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockGossamite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemGossamiteIngot));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemGossamiteIngot, 9), MHBlocks.blockGossamite);

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockBbq), "w w", "wxw", "yzy", 'w', Items.IRON_INGOT, 'x', Items.FLINT_AND_STEEL, 'y', new ItemStack(Blocks.STONE), 'z', new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockWeaponCraft), "www", "xyx", "xzx", 'w', new ItemStack(Blocks.CARPET,1,14), 'x', new ItemStack(Blocks.STONE), 'y', new ItemStack(Blocks.CHEST), 'z', new ItemStack(Blocks.BOOKSHELF));

        GameRegistry.addSmelting(MHBlocks.blockOreMachalite, new ItemStack(MHItems.itemMachaliteIngot), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreDragonite, new ItemStack(MHItems.itemDragoniteIngot), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreGossamite, new ItemStack(MHItems.itemGossamiteIngot), 0.2f);

        WeaponUpgradeManager wum = WeaponUpgradeManager.getInstance();
        wum.addRecipe(MHItems.weaponHuntersKnife, Items.IRON_INGOT, new ItemStack(Items.IRON_INGOT, 2));
        wum.addRecipe(MHItems.weaponHuntersKnifePlus, MHItems.weaponHuntersKnife, new ItemStack(Items.IRON_INGOT, 5));
        wum.addRecipe(MHItems.weaponSoldiersDagger, MHItems.weaponHuntersKnifePlus, MHItems.itemGreatJaggiHide, new ItemStack(MHItems.itemJaggiHide, 3), new ItemStack(MHItems.itemJaggiScale, 3), new ItemStack(MHItems.itemEarthCrystal, 5));
        wum.addRecipe(MHItems.weaponCommandersDagger, MHItems.weaponSoldiersDagger, new ItemStack(MHItems.itemGreatJaggiClaw, 2), new ItemStack(MHItems.itemGreatJaggiHide, 3), new ItemStack(MHItems.itemMachaliteIngot, 5));
        wum.addRecipe(MHItems.weaponHuntersDagger, MHItems.weaponHuntersKnifePlus, new ItemStack(MHItems.itemEarthCrystal, 4), new ItemStack(MHItems.itemMachaliteIngot, 2), MHItems.itemGlueglopper);
        wum.addRecipe(MHItems.weaponAssassinsDagger, MHItems.weaponHuntersDagger, new ItemStack(MHItems.itemEarthCrystal, 4), new ItemStack(MHItems.itemDragoniteIngot, 2), MHItems.itemGlueglopper);
        wum.addRecipe(MHItems.weaponViperBite, MHItems.weaponHuntersKnife, new ItemStack(MHItems.itemGenpreyHide, 5), new ItemStack(MHItems.itemGenpreyFang, 4), new ItemStack(MHItems.itemMonsterBoneS, 3));
    }
}
