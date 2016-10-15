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

        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSerpentBite), "yyx", "yzx", "ywx", 'w', MHItems.weaponAssassinsDagger, 'x', MHItems.itemVelocipreyHide, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSerpentBitePlus), "yyx", "yzz", "yxz", 'x', MHItems.weaponSerpentBite, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponDeadlock), "yyx", "yzz", "yxz", 'x', MHItems.weaponSerpentBitePlus, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneM);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponViperBitePlus), "yyx", "yzz", "yxz", 'x', MHItems.weaponViperBite, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneS);
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponDeathprize), "yyx", "yzz", "yxz", 'x', MHItems.weaponViperBitePlus, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneM);

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

        wum.addRecipe(MHItems.weaponBoneKris, MHItems.itemMysteryBone, new ItemStack(MHItems.itemMonsterBoneS, 2));
        wum.addRecipe(MHItems.weaponBoneKrisPlus, MHItems.weaponBoneKris, new ItemStack(MHItems.itemMonsterBoneS, 3), new ItemStack(MHItems.itemBirdWyvernFang, 3));
        wum.addRecipe(MHItems.weaponChiefKris, MHItems.weaponBoneKrisPlus, new ItemStack(MHItems.itemMonsterBoneM), new ItemStack(MHItems.itemMonsterBoneS, 2), new ItemStack(MHItems.itemBoneHusk, 5), new ItemStack(Items.IRON_INGOT, 3));
        wum.addRecipe(MHItems.weaponRottonSword, MHItems.weaponBoneKris, new ItemStack(Items.ROTTEN_FLESH, 7), new ItemStack(Items.SKULL, 1, 2));
        wum.addRecipe(MHItems.weaponPlaguedSword, MHItems.weaponRottonSword, new ItemStack(Items.ROTTEN_FLESH, 6), new ItemStack(Items.SKULL, 2, 2));
        wum.addRecipe(MHItems.weaponInfestedSword, MHItems.weaponPlaguedSword, new ItemStack(Items.ROTTEN_FLESH, 5), new ItemStack(Items.SKULL, 3, 2));
        wum.addRecipe(MHItems.weaponSkeletalSword, MHItems.weaponBoneKris, new ItemStack(Items.BONE, 7), new ItemStack(Items.SKULL, 1, 0));
        wum.addRecipe(MHItems.weaponSkeletalSwordPlus, MHItems.weaponSkeletalSword, new ItemStack(Items.BONE, 6), new ItemStack(Items.SKULL, 2, 0));
        wum.addRecipe(MHItems.weaponWitheredSword, MHItems.weaponSkeletalSwordPlus, new ItemStack(Items.BONE, 6), new ItemStack(Items.SKULL, 1, 1), Items.COAL);
        wum.addRecipe(MHItems.weaponWitheredSwordPlus, MHItems.weaponWitheredSword, new ItemStack(Items.BONE, 3), new ItemStack(Items.SKULL, 2, 1), new ItemStack(Items.COAL, 3));
        wum.addRecipe(MHItems.weaponNecrosisBlade, MHItems.weaponWitheredSwordPlus, new ItemStack(Items.BONE, 3), new ItemStack(Items.SKULL, 1, 1), Items.NETHER_STAR, new ItemStack(Items.COAL, 3));
        wum.addRecipe(MHItems.weaponMandiblade, MHItems.weaponBoneKris, new ItemStack(Items.STRING, 7), Items.SPIDER_EYE);
        wum.addRecipe(MHItems.weaponMandibladePlus, MHItems.weaponMandiblade, new ItemStack(Items.STRING, 6), new ItemStack(Items.SPIDER_EYE, 2));
        wum.addRecipe(MHItems.weaponStingingMandiblade, MHItems.weaponMandibladePlus, new ItemStack(Items.STRING, 6), Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);
        wum.addRecipe(MHItems.weaponPoisonStingblade, MHItems.weaponStingingMandiblade, new ItemStack(Items.STRING, 3), new ItemStack(Items.SPIDER_EYE, 3), new ItemStack(Items.FERMENTED_SPIDER_EYE, 2));
        wum.addRecipe(MHItems.weaponFearSword, MHItems.weaponBoneKris, new ItemStack(Items.GUNPOWDER, 7), new ItemStack(Items.SKULL, 1, 4));
        wum.addRecipe(MHItems.weaponTerrorSword, MHItems.weaponFearSword, new ItemStack(Items.GUNPOWDER, 6), new ItemStack(Items.SKULL, 2, 4));
        wum.addRecipe(MHItems.weaponDreadSword, MHItems.weaponTerrorSword, new ItemStack(Items.GUNPOWDER, 3), new ItemStack(Items.SKULL, 3, 4), new ItemStack(Blocks.TNT, 2));
        wum.addRecipe(MHItems.weaponXenoblade, MHItems.weaponBoneKris, new ItemStack(Items.ENDER_PEARL, 5));
        wum.addRecipe(MHItems.weaponXenobladePlus, MHItems.weaponXenoblade, new ItemStack(Items.ENDER_PEARL, 7), Items.ENDER_EYE);
        wum.addRecipe(MHItems.weaponAstralSword, MHItems.weaponXenobladePlus, new ItemStack(Items.ENDER_PEARL, 3), new ItemStack(Items.ENDER_EYE, 2), new ItemStack(Blocks.END_STONE, 3));
        wum.addRecipe(MHItems.weaponAstralEndsword, MHItems.weaponAstralSword, new ItemStack(Items.ENDER_EYE, 3), Blocks.DRAGON_EGG, Items.DRAGON_BREATH, new ItemStack(Blocks.END_STONE, 3));
        wum.addRecipe(MHItems.weaponSlimySword, MHItems.weaponBoneKris, new ItemStack(Items.SLIME_BALL, 5));
        wum.addRecipe(MHItems.weaponSlimySwordPlus, MHItems.weaponSlimySword, new ItemStack(Items.SLIME_BALL, 5), new ItemStack(Blocks.SLIME_BLOCK, 3));
        wum.addRecipe(MHItems.weaponCrystalizedSlimeblade, MHItems.weaponSlimySwordPlus, new ItemStack(Items.SLIME_BALL, 3), new ItemStack(Items.MAGMA_CREAM, 2), new ItemStack(Blocks.SLIME_BLOCK, 3));
        wum.addRecipe(MHItems.weaponMagmaticSlimeblade, MHItems.weaponCrystalizedSlimeblade, new ItemStack(Items.MAGMA_CREAM, 3), new ItemStack(Blocks.SLIME_BLOCK, 3), new ItemStack(Items.BLAZE_POWDER, 2));
        wum.addRecipe(MHItems.weaponBlazingSword, MHItems.weaponBoneKris, new ItemStack(Items.BLAZE_ROD, 2), new ItemStack(Items.BLAZE_POWDER, 3));
        wum.addRecipe(MHItems.weaponBlazingTempest, MHItems.weaponBlazingSword, new ItemStack(Items.BLAZE_ROD, 6), new ItemStack(Items.BLAZE_POWDER, 3));
        wum.addRecipe(MHItems.weaponBlazingInferno, MHItems.weaponBlazingTempest, new ItemStack(Items.BLAZE_ROD, 3), new ItemStack(Items.BLAZE_POWDER, 3), new ItemStack(Items.FIRE_CHARGE, 2));


    }
}
