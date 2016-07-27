package com.alxnns1.mobhunter.init;

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
    //Using this suppression to remove the "Redundant array creation" warnings
    @SuppressWarnings("all")
    public static void init()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemCatalyst), new Object[] {MHItems.itemHoney, MHItems.itemBitterbug});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemWhetstone), new Object[] {MHItems.itemMonsterBoneS, Items.IRON_INGOT});

        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemPotion), new Object[] {Items.GLASS_BOTTLE, MHItems.itemHerb, MHItems.itemBlueMushroom});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMegaPotion), new Object[] {Items.GLASS_BOTTLE, MHItems.itemPotion, MHItems.itemHoney});
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemNutrients), new Object[] {Items.GLASS_BOTTLE, MHItems.itemBlueMushroom, MHItems.itemGodbug});
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMegaNutrients), new Object[] {Items.GLASS_BOTTLE, MHItems.itemNutrients, MHItems.itemHoney});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemAntidote), new Object[] {Items.GLASS_BOTTLE, MHItems.itemBlueMushroom, MHItems.itemAntidoteHerb});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemImmunizer), new Object[] {Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemDragonToadstool});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDashJuice), new Object[] {Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemRareSteak});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDemondrug), new Object[] {Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemMightSeed});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemArmourskin), new Object[] {Items.GLASS_BOTTLE, MHItems.itemCatalyst, MHItems.itemAdamantSeed});

        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringHelmet), new Object[] {"yzy", "y y", "   ", 'y', Items.STRING, 'z', MHItems.itemMonsterBoneS});
        //2 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringChestplate), new Object[] {"x x", "xyx", "zzz", 'x', MHItems.itemMonsterBoneS, 'y', Items.IRON_INGOT, 'z', Items.STRING});
        //1 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringLeggings), new Object[] {"yzy", "   ", "   ", 'y', MHItems.itemMonsterBoneS, 'z', Items.IRON_INGOT});
        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringBoots), new Object[] {"   ", "y y", "z z", 'y', Items.STRING, 'z', MHItems.itemMonsterBoneS});

        //1 Machalite Ingot + 1 Iron Ore + 2 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterHelmet), new Object[] {"xyx", "z z", "   ", 'x', Items.IRON_INGOT, 'y', MHItems.itemMachaliteIngot, 'z', MHItems.itemGlueglopper});
        //2 Iron Ingot + 3 Jaggi Scale + 2 Monster Bone S + 1 Earth Crystal + 1 Ivy
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterChestplate), new Object[] {"w w", "xyx", "zxz", 'w', Items.IRON_INGOT, 'x', MHItems.itemJaggiScale, 'y', MHItems.itemEarthCrystal, 'z', MHItems.itemMonsterBoneS});
        //2 Machalite Ingot + 1 Iron Ingot + 1 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterLeggings), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMachaliteIngot, 'y', MHItems.itemGlueglopper, 'z', Items.IRON_INGOT});
        //1 Iron Ingot + 1 Earth Crystal + 2 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterBoots), new Object[] {"   ", "y y", "z z", 'y', Items.IRON_INGOT, 'z', MHItems.itemMonsterBoneS});

        //2 Mystery Bone + 1 Unknown Skull + 1 Altaroth Jaw
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMysteryBone, 'y', MHItems.itemUnknownSkull, 'z', MHItems.itemAltarothJaw});
        //4 Mystery Bone + 1 Jumbo Bone + 2 Altaroth Stomach + 2 Monster Bone S + 2 Moster Fluid
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"w w", "xyx", "xzx", 'w', MHItems.itemMonsterBoneS, 'x', MHItems.itemMysteryBone, 'y', MHItems.itemJumboBone, 'z', MHItems.itemAltarothStomach});
        //2 Mystery Bone + 2 Monster Bone S + 2 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), new Object[] {"wxw", "y y", "z z", 'w', MHItems.itemBirdWyvernFang, 'x', Items.STRING, 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneS});
        //2 Mystery Bone + 1 Monster Bone M + 1 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), new Object[] {"   ", "y y", "z z", 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneM});

        //3 Machalite Ingot + 2 Earth Crystal + 3 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyHelmet), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMachaliteIngot, 'y', MHItems.itemEarthCrystal, 'z', Items.IRON_INGOT});
        //5 Machalite Ingot + 2 Monster Bone S + 6 Iron Ingot + 2 Earth Crystal
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyChestplate), new Object[] {"x x", "yxy", "yzy", 'x', MHItems.itemMachaliteIngot, 'y', Items.IRON_INGOT, 'z', MHItems.itemEarthCrystal});
        //2 Machalite Ingot + 2 Monster Bone S + 3 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyLeggings), new Object[] {"xyx", "z z", "y y", 'x', MHItems.itemMachaliteIngot, 'y', Items.IRON_INGOT, 'z', MHItems.itemMonsterBoneS});
        //4 Machalite Ingot + 2 Earth Crystal + 2 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyBoots), new Object[] {"   ", "y y", "z z", 'y', Items.IRON_INGOT, 'z', MHItems.itemMachaliteIngot});

        GameRegistry.addRecipe(new ItemStack(MHItems.weaponHuntersKnife), new Object[] {" z ", " z ", " z ", 'z', Items.IRON_INGOT});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSoldiersDagger), new Object[] {"zyx", "zyx", "zvw", 'v', MHItems.weaponHuntersKnifePlus, 'w', MHItems.itemGreatJaggiHide, 'x', MHItems.itemJaggiHide, 'y', MHItems.itemJaggiScale, 'z', MHItems.itemEarthCrystal});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponCommandersDagger), new Object[] {"xzy", "xzy", "ywz", 'w', MHItems.weaponSoldiersDagger, 'x', MHItems.itemGreatJaggiClaw, 'y', MHItems.itemGreatJaggiHide, 'z', MHItems.itemMachaliteIngot});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSerpentBite), new Object[] {"yyx", "yzx", "ywx", 'w', MHItems.weaponAssassinsDagger, 'x', MHItems.itemVelocipreyHide, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneS});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponSerpentBitePlus), new Object[] {"yyx", "yzz", "yxz", 'x', MHItems.weaponSerpentBite, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneS});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponDeadlock), new Object[] {"yyx", "yzz", "yxz", 'x', MHItems.weaponSerpentBitePlus, 'y', MHItems.itemVelocipreyFang, 'z', MHItems.itemMonsterBoneM});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponViperBite), new Object[] {"yyx", "yzx", "ywx", 'w', MHItems.weaponAssassinsDagger, 'x', MHItems.itemGenpreyHide, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneS});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponViperBitePlus), new Object[] {"yyx", "yzz", "yxz", 'x', MHItems.weaponViperBite, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneS});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponDeathprize), new Object[] {"yyx", "yzz", "yxz", 'x', MHItems.weaponViperBitePlus, 'y', MHItems.itemGenpreyFang, 'z', MHItems.itemMonsterBoneM});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponHuntersKnifePlus), new Object[] {" yy", " yy", " yz", 'y', Items.IRON_INGOT, 'z', MHItems.weaponHuntersKnife});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponHuntersDagger), new Object[] {"yxx", "yzx", " wx", 'w', MHItems.weaponHuntersKnife, 'x', MHItems.itemEarthCrystal, 'y', MHItems.itemMachaliteIngot, 'z', MHItems.itemGlueglopper});
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponAssassinsDagger), new Object[] {"yxx", "yzx", " wx", 'w', MHItems.weaponHuntersDagger, 'x', MHItems.itemMysteryBone, 'y', MHItems.itemMonsterBoneM, 'z', MHItems.itemGlueglopper});

        GameRegistry.addRecipe(new ItemStack(MHItems.itemMachalitePickaxe), new Object[] {"xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemMachaliteIngot), 'y', new ItemStack(Items.STICK)});
        GameRegistry.addRecipe(new ItemStack(MHItems.itemDragonitePickaxe), new Object[] {"xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemDragoniteIngot), 'y', new ItemStack(Items.STICK)});
        GameRegistry.addRecipe(new ItemStack(MHItems.itemGossamitePickaxe), new Object[] {"xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemGossamiteIngot), 'y', new ItemStack(Items.STICK)});

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockEarthCrystal), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemEarthCrystal)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemEarthCrystal, 9), MHBlocks.blockEarthCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockMachalite), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemMachaliteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMachaliteIngot, 9), MHBlocks.blockMachalite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockDragonite), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemDragoniteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDragoniteIngot, 9), MHBlocks.blockDragonite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockLightCrystal), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemLightCrystal)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemLightCrystal, 9), MHBlocks.blockLightCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockIceCrystal), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemIceCrystal)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemIceCrystal, 9), MHBlocks.blockIceCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockGossamite), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemGossamiteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemGossamiteIngot, 9), MHBlocks.blockGossamite);

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockBbq), new Object[] {"w w", "wxw", "yzy", 'w', Items.IRON_INGOT, 'x', Items.FLINT_AND_STEEL, 'y', new ItemStack(Blocks.STONE), 'z', new ItemStack(Blocks.NETHERRACK)});
        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockWeaponUpgrade), new Object[] {"www", "xyx", "xzx", 'w', new ItemStack(Blocks.CARPET,1,14), 'x', new ItemStack(Blocks.STONE), 'y', new ItemStack(Blocks.CHEST), 'z', new ItemStack(Blocks.BOOKSHELF)});

        GameRegistry.addSmelting(MHBlocks.blockOreMachalite, new ItemStack(MHItems.itemMachaliteIngot), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreDragonite, new ItemStack(MHItems.itemDragoniteIngot), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreGossamite, new ItemStack(MHItems.itemGossamiteIngot), 0.2f);
    }
}
