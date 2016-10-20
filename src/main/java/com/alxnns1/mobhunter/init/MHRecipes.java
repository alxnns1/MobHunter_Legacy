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
        //1 Catalyst = 1 Honey + 1 Bitterbug
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemBug, 1, 10), new ItemStack(MHItems.itemConsumable, 1, 13));
        //1 Whetstone = 1 Monster Bone S + 1 Iron Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMisc, 1, 1), new ItemStack(MHItems.itemMonsterDrop, 1, 0), Items.IRON_INGOT);

        //1 Potion = 1 Glass Bottle + 1 Herb + 1 Blue Mushroom
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 0), Items.GLASS_BOTTLE, new ItemStack(MHItems.itemConsumable, 1, 0), new ItemStack(MHItems.itemMushroom, 1, 0));
        //1 Mega Potion = 1 Potion + 1 Honey
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 1), new ItemStack(MHItems.itemDrink, 1, 0), new ItemStack(MHItems.itemBug, 1, 10));
        //1 Nutrients = 1 Blue Mushroom + 1 Godbug
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 10), new ItemStack(MHItems.itemMushroom, 1, 0), new ItemStack(MHItems.itemBug, 1, 3));
        //1 Mega Nutrients = 1 Nutrients + 1 Honey
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 11), new ItemStack(MHItems.itemDrink, 1, 10), new ItemStack(MHItems.itemBug, 1, 10));
        //1 Antidote = 1 Blue Mushroom + 1 Antidote Herb
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 2), new ItemStack(MHItems.itemMushroom, 1, 0), new ItemStack(MHItems.itemConsumable, 1, 1));
        //1 Immunizer = 1 Catalyst + 1 Dragon Toadstool
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 3), new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemMushroom, 1, 1));
        //1 Dash Juice = 1 Catalyst + 1 Rare Steak
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 4), new ItemStack(MHItems.itemMisc, 1, 0), MHItems.itemRareSteak);
        //1 Demondrug = 1 Catalyst + 1 Might Seed
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 6), new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemConsumable, 1, 8));
        //1 Armourskin = 1 Catalyst + 1 Adamant Seed
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 8), new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemConsumable, 1, 9));

        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringHelmet), "yzy", "y y", "   ", 'y', Items.STRING, 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 0));
        //2 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringChestplate), "x x", "xyx", "zzz", 'x', new ItemStack(MHItems.itemMonsterDrop, 1, 0), 'y', Items.IRON_INGOT, 'z', Items.STRING);
        //1 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringLeggings), "yzy", "   ", "   ", 'y', new ItemStack(MHItems.itemMonsterDrop, 1, 0), 'z', Items.IRON_INGOT);
        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringBoots), "   ", "y y", "z z", 'y', Items.STRING, 'z', new ItemStack(MHItems.itemMonsterDrop, 0));

        //1 Machalite Ingot + 1 Iron Ore + 2 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterHelmet), "xyx", "z z", "   ", 'x', Items.IRON_INGOT, 'y', new ItemStack(MHItems.itemOre, 1, 1), 'z', new ItemStack(MHItems.itemBug, 6));
        //2 Iron Ingot + 3 Jaggi Scale + 2 Monster Bone S + 1 Earth Crystal + 1 Ivy
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterChestplate), "w w", "xyx", "zxz", 'w', Items.IRON_INGOT, 'x', new ItemStack(MHItems.itemMonsterDrop, 18), 'y', new ItemStack(MHItems.itemOre, 1, 0), 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 0));
        //2 Machalite Ingot + 1 Iron Ingot + 1 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterLeggings), "xyx", "z z", "   ", 'x', new ItemStack(MHItems.itemOre, 1, 1), 'y', new ItemStack(MHItems.itemBug, 6), 'z', Items.IRON_INGOT);
        //1 Iron Ingot + 1 Earth Crystal + 2 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterBoots), "   ", "y y", "z z", 'y', Items.IRON_INGOT, 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 0));

        //2 Mystery Bone + 1 Unknown Skull + 1 Altaroth Jaw
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), "xyx", "z z", "   ", 'x', new ItemStack(MHItems.itemMonsterDrop, 1, 2), 'y', new ItemStack(MHItems.itemMonsterDrop, 1, 3), 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 8));
        //4 Mystery Bone + 1 Jumbo Bone + 2 Altaroth Stomach + 2 Monster Bone S + 2 Monster Fluid
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), "w w", "xyx", "xzx", 'w', new ItemStack(MHItems.itemMonsterDrop, 1, 0), 'x', new ItemStack(MHItems.itemMonsterDrop, 1, 2), 'y', new ItemStack(MHItems.itemMonsterDrop, 1, 5), 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 9));
        //2 Mystery Bone + 2 Monster Bone S + 2 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), "wxw", "y y", "z z", 'w', new ItemStack(MHItems.itemMonsterDrop, 1, 15), 'x', Items.STRING, 'y', new ItemStack(MHItems.itemMonsterDrop, 1, 2), 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 0));
        //2 Mystery Bone + 1 Monster Bone M + 1 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), "   ", "y y", "z z", 'y', new ItemStack(MHItems.itemMonsterDrop, 1, 2), 'z', new ItemStack(MHItems.itemMonsterDrop, 1, 1));

        //3 Machalite Ingot + 2 Earth Crystal + 3 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyHelmet), "xyx", "z z", "   ", 'x', new ItemStack(MHItems.itemOre, 1, 1), 'y', new ItemStack(MHItems.itemOre, 1, 0), 'z', Items.IRON_INGOT);
        //5 Machalite Ingot + 2 Monster Bone S + 6 Iron Ingot + 2 Earth Crystal
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyChestplate), "x x", "yxy", "yzy", 'x', new ItemStack(MHItems.itemOre, 1, 1), 'y', Items.IRON_INGOT, 'z', new ItemStack(MHItems.itemOre, 1, 0));
        //2 Machalite Ingot + 2 Monster Bone S + 3 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyLeggings), "xyx", "z z", "y y", 'x', new ItemStack(MHItems.itemOre, 1, 1), 'y', Items.IRON_INGOT, 'z', new ItemStack(MHItems.itemMonsterDrop, 0));
        //4 Machalite Ingot + 2 Earth Crystal + 2 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyBoots), "   ", "y y", "z z", 'y', Items.IRON_INGOT, 'z', new ItemStack(MHItems.itemOre, 1, 1));

        GameRegistry.addRecipe(new ItemStack(MHItems.itemMachalitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemOre, 1, 1), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(MHItems.itemDragonitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemOre, 1, 2), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(MHItems.itemGossamitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemOre, 1, 3), 'y', new ItemStack(Items.STICK));

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockEarthCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 0), MHBlocks.blockEarthCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockMachalite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 1), MHBlocks.blockMachalite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockDragonite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 2), MHBlocks.blockDragonite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockLightCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 4), MHBlocks.blockLightCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockIceCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 5));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 5), MHBlocks.blockIceCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockGossamite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 3), MHBlocks.blockGossamite);

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockBbq), "w w", "wxw", "yzy", 'w', Items.IRON_INGOT, 'x', Items.FLINT_AND_STEEL, 'y', new ItemStack(Blocks.STONE), 'z', new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockWeaponCraft), "www", "xyx", "xzx", 'w', new ItemStack(Blocks.CARPET,1,14), 'x', new ItemStack(Blocks.STONE), 'y', new ItemStack(Blocks.CHEST), 'z', new ItemStack(Blocks.BOOKSHELF));

        GameRegistry.addSmelting(MHBlocks.blockOreMachalite, new ItemStack(MHItems.itemOre, 1, 1), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreDragonite, new ItemStack(MHItems.itemOre, 1, 2), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreGossamite, new ItemStack(MHItems.itemOre, 1, 3), 0.2f);

        WeaponUpgradeManager wum = WeaponUpgradeManager.getInstance();
        wum.addRecipeNullKey(MHItems.weaponHuntersKnife, new ItemStack(Items.IRON_INGOT, 3));
        wum.addRecipe(MHItems.weaponSoldiersDagger, MHItems.weaponHuntersKnifePlus, new ItemStack(MHItems.itemMonsterDrop, 1, 26), new ItemStack(MHItems.itemMonsterDrop, 3, 17), new ItemStack(MHItems.itemMonsterDrop, 3, 18), new ItemStack(MHItems.itemOre, 5, 0));
        wum.addRecipe(MHItems.weaponCommandersDagger, MHItems.weaponSoldiersDagger, new ItemStack(MHItems.itemMonsterDrop, 2, 27), new ItemStack(MHItems.itemMonsterDrop, 3, 26), new ItemStack(MHItems.itemOre, 5, 1));
        wum.addRecipe(MHItems.weaponViperBite, MHItems.weaponHuntersKnife, new ItemStack(MHItems.itemMonsterDrop, 5, 23), new ItemStack(MHItems.itemMonsterDrop, 4, 25), new ItemStack(MHItems.itemMonsterDrop, 3, 0));
        //wum.addRecipe(MHItems.weaponViperBitePlus, MHItems.weaponViperBite, new ItemStack(MHItems.itemMonsterDrop, 6, 25), new ItemStack(MHItems.itemMonsterDrop, 6, 0));
        //wum.addRecipe(MHItems.weaponDeathprize, MHItems.weaponViperBite, new ItemStack(MHItems.itemMonsterDrop, 9, 25), new ItemStack(MHItems.itemMonsterDrop, 9, 1));
        wum.addRecipe(MHItems.weaponSerpentBite, MHItems.weaponHuntersKnife, new ItemStack(MHItems.itemMonsterDrop, 5, 20), new ItemStack(MHItems.itemMonsterDrop, 4, 22), new ItemStack(MHItems.itemMonsterDrop, 3, 0));
        wum.addRecipe(MHItems.weaponSerpentBitePlus, MHItems.weaponSerpentBite, new ItemStack(MHItems.itemMonsterDrop, 6, 22), new ItemStack(MHItems.itemMonsterDrop, 6, 0));
        wum.addRecipe(MHItems.weaponDeadlock, MHItems.weaponSerpentBitePlus, new ItemStack(MHItems.itemMonsterDrop, 9, 22), new ItemStack(MHItems.itemMonsterDrop, 9, 1));
        wum.addRecipe(MHItems.weaponHuntersKnifePlus, MHItems.weaponHuntersKnife, new ItemStack(Items.IRON_INGOT, 5));
        wum.addRecipe(MHItems.weaponHuntersDagger, MHItems.weaponHuntersKnifePlus, new ItemStack(MHItems.itemOre, 4, 0), new ItemStack(MHItems.itemOre, 2, 1), new ItemStack(MHItems.itemBug, 6));
        wum.addRecipe(MHItems.weaponAssassinsDagger, MHItems.weaponHuntersDagger, new ItemStack(MHItems.itemOre, 4, 0), new ItemStack(MHItems.itemOre, 2, 2), new ItemStack(MHItems.itemBug, 6));


        wum.addRecipeNullKey(MHItems.weaponBoneKris, new ItemStack(MHItems.itemMonsterDrop, 1, 2), new ItemStack(MHItems.itemMonsterDrop, 2, 0));
        wum.addRecipe(MHItems.weaponBoneKrisPlus, MHItems.weaponBoneKris, new ItemStack(MHItems.itemMonsterDrop, 3, 0), new ItemStack(MHItems.itemMonsterDrop, 3, 15));
        wum.addRecipe(MHItems.weaponChiefKris, MHItems.weaponBoneKrisPlus, new ItemStack(MHItems.itemMonsterDrop, 1, 1), new ItemStack(MHItems.itemMonsterDrop, 2, 0), new ItemStack(MHItems.itemMonsterDrop, 5, 7), new ItemStack(Items.IRON_INGOT, 3));
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
