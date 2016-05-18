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
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemWhetstone), new Object[] {MHItems.itemMonsterBoneS, Items.iron_ingot});

        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemPotion), new Object[] {Items.glass_bottle, MHItems.itemHerb, MHItems.itemBlueMushroom});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMegaPotion), new Object[] {Items.glass_bottle, MHItems.itemPotion, MHItems.itemHoney});
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemNutrients), new Object[] {Items.glass_bottle, MHItems.itemBlueMushroom, MHItems.itemGodbug});
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMegaNutrients), new Object[] {Items.glass_bottle, MHItems.itemNutrients, MHItems.itemHoney});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemAntidote), new Object[] {Items.glass_bottle, MHItems.itemBlueMushroom, MHItems.itemAntidoteHerb});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemImmunizer), new Object[] {Items.glass_bottle, MHItems.itemCatalyst, MHItems.itemDragonToadstool});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDashJuice), new Object[] {Items.glass_bottle, MHItems.itemCatalyst, MHItems.itemRareSteak});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDemondrug), new Object[] {Items.glass_bottle, MHItems.itemCatalyst, MHItems.itemMightSeed});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemArmourskin), new Object[] {Items.glass_bottle, MHItems.itemCatalyst, MHItems.itemAdamantSeed});

        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringHelmet), new Object[] {"yzy", "y y", "   ", 'y', Items.string, 'z', MHItems.itemMonsterBoneS});
        //2 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringChestplate), new Object[] {"x x", "xyx", "zzz", 'x', MHItems.itemMonsterBoneS, 'y', Items.iron_ingot, 'z', Items.string});
        //1 Monster Bone S + 1 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringLeggings), new Object[] {"yzy", "   ", "   ", 'y', MHItems.itemMonsterBoneS, 'z', Items.iron_ingot});
        //1 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourDerringBoots), new Object[] {"   ", "y y", "z z", 'y', Items.string, 'z', MHItems.itemMonsterBoneS});

        //1 Machalite Ingot + 1 Iron Ore + 2 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterHelmet), new Object[] {"xyx", "z z", "   ", 'x', Items.iron_ingot, 'y', MHItems.itemMachaliteIngot, 'z', MHItems.itemGlueglopper});
        //2 Iron Ingot + 3 Jaggi Scale + 2 Monster Bone S + 1 Earth Crystal + 1 Ivy
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterChestplate), new Object[] {"w w", "xyx", "zxz", 'w', Items.iron_ingot, 'x', MHItems.itemJaggiScale, 'y', MHItems.itemEarthCrystal, 'z', MHItems.itemMonsterBoneS});
        //2 Machalite Ingot + 1 Iron Ingot + 1 Glueglopper
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterLeggings), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMachaliteIngot, 'y', MHItems.itemGlueglopper, 'z', Items.iron_ingot});
        //1 Iron Ingot + 1 Earth Crystal + 2 Monster Bone S
        GameRegistry.addRecipe(new ItemStack(MHItems.armourHunterBoots), new Object[] {"   ", "y y", "z z", 'y', Items.iron_ingot, 'z', MHItems.itemMonsterBoneS});

        //2 Mystery Bone + 1 Unknown Skull + 1 Altaroth Jaw
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMysteryBone, 'y', MHItems.itemUnknownSkull, 'z', MHItems.itemAltarothJaw});
        //4 Mystery Bone + 1 Jumbo Bone + 2 Altaroth Stomach + 2 Monster Bone S + 2 Moster Fluid
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"w w", "xyx", "xzx", 'w', MHItems.itemMonsterBoneS, 'x', MHItems.itemMysteryBone, 'y', MHItems.itemJumboBone, 'z', MHItems.itemAltarothStomach});
        //2 Mystery Bone + 2 Monster Bone S + 2 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), new Object[] {"wxw", "y y", "z z", 'w', MHItems.itemBirdWyvernFang, 'x', Items.string, 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneS});
        //2 Mystery Bone + 1 Monster Bone M + 1 Sharp Fang(use Bird Wyvern Fang for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), new Object[] {"   ", "y y", "z z", 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneM});

        //3 Machalite Ingot + 2 Earth Crystal + 3 Iron Ingot
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyHelmet), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMachaliteIngot, 'y', MHItems.itemEarthCrystal, 'z', Items.iron_ingot});
        //5 Machalite Ingot + 2 Monster Bone S + 6 Iron Ingot + 2 Earth Crystal
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyChestplate), new Object[] {"x x", "yxy", "yzy", 'x', MHItems.itemMachaliteIngot, 'y', Items.iron_ingot, 'z', MHItems.itemEarthCrystal});
        //2 Machalite Ingot + 2 Monster Bone S + 3 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyLeggings), new Object[] {"xyx", "z z", "y y", 'x', MHItems.itemMachaliteIngot, 'y', Items.iron_ingot, 'z', MHItems.itemMonsterBoneS});
        //4 Machalite Ingot + 2 Earth Crystal + 2 Iron Ore
        GameRegistry.addRecipe(new ItemStack(MHItems.armourAlloyBoots), new Object[] {"   ", "y y", "z z", 'y', Items.iron_ingot, 'z', MHItems.itemMachaliteIngot});

        //1 Iron Sword + 5 Iron Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponIronSwordPlus),new Object[] {
                Items.iron_sword,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot});
        //1 Iron Sword+ + 2 Machalite Ingot + 8 Iron Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSword),new Object[] {
               MHItems.weaponIronSwordPlus,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                MHItems.itemMachaliteIngot,
                MHItems.itemMachaliteIngot});
        //1 Buster Sword + 5 Machalite Ingot + 2 Earth Crystal + 5 Iron Ore
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSwordPlus),new Object[] {
                MHItems.weaponBusterSword,
                Items.iron_ingot,
                Items.iron_ingot,
                Items.iron_ingot,
                MHItems.itemEarthCrystal,
                MHItems.itemMachaliteIngot,
                MHItems.itemMachaliteIngot,
                MHItems.itemMachaliteIngot,
                MHItems.itemMachaliteIngot});
        //1 Buster Sword+ + 3 Dragonite Ingot + 5 Machalite Ingot + 10 Earth Crystal + 3 Killer Beetle
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponRavagerBlade),new Object[] {
                MHItems.weaponBusterSwordPlus,
                MHItems.itemDragoniteIngot,
                MHItems.itemMachaliteIngot,
                MHItems.itemMachaliteIngot,
                MHItems.itemEarthCrystal,
                MHItems.itemEarthCrystal,
                MHItems.itemEarthCrystal,
                MHItems.itemEarthCrystal,
                MHItems.itemKillerBeetle});

        //2 Monster Bone S + 1 Jaggi Hide
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponBoneBlade), new Object[] {" y "," y "," z ",'y',MHItems.itemMonsterBoneS,'z',MHItems.itemJaggiHide});
        //1 Bone Blade + 4 Monster Bone S + 2 Jaggi Hide
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBoneBladePlus),new Object[] {
                MHItems.weaponBoneBlade,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemJaggiHide,
                MHItems.itemJaggiHide});
        //1 Bone Blade+ + 7 Monster Bone S + 5 Monster Bone M
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponJawblade),new Object[] {
                MHItems.weaponBoneBladePlus,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneS,
                MHItems.itemMonsterBoneM,
                MHItems.itemMonsterBoneM,
                MHItems.itemMonsterBoneM});
        //1 Jawblade + 5 Monster Bone M + 3 Jumbo Bone + 5 Earth Crystal
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponGiantJawblade),new Object[] {
                MHItems.weaponJawblade,
                MHItems.itemMonsterBoneM,
                MHItems.itemMonsterBoneM,
                MHItems.itemMonsterBoneM,
                MHItems.itemJumboBone,
                MHItems.itemJumboBone,
                MHItems.itemEarthCrystal,
                MHItems.itemEarthCrystal,
                MHItems.itemEarthCrystal});

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockEarthCrystal), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemEarthCrystal)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemEarthCrystal, 9), MHBlocks.blockEarthCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockMachalite), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemMachaliteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMachaliteIngot, 9), MHBlocks.blockMachalite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockDragonite), new Object[] {"xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemDragoniteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDragoniteIngot, 9), MHBlocks.blockDragonite);

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockBbq), new Object[] {"w w", "wxw", "yzy", 'w', Items.iron_ingot, 'x', Items.flint_and_steel, 'y', new ItemStack(Blocks.stone), 'z', new ItemStack(Blocks.netherrack)});
        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
    }
}
