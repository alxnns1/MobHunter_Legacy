package com.alxnns1.mobhunter.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

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

        //2 Mystery Bone + 1 Unknown Skull + 1 Altaroth Jaw(use Insect Husk for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"xyx", "z z", "   ", 'x', MHItems.itemMysteryBone, 'y', MHItems.itemUnknownSkull, 'z', MHItems.itemInsectHusk});
        //4 Mystery Bone + 1 Jumbo Bone + 2 Altaroth Stomach(use Insect Husk for now) + 2 Monster Bone S + 2 Moster Fluid(use Insect Husk for now)
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"w w", "xyx", "xzx", 'w', MHItems.itemMonsterBoneS, 'x', MHItems.itemMysteryBone, 'y', MHItems.itemJumboBone, 'z', MHItems.itemInsectHusk});
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
                new ItemStack(Items.iron_sword),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot)});
        //1 Iron Sword+ + 2 Machalite Ingot + 8 Iron Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSword),new Object[] {
                new ItemStack(MHItems.weaponIronSwordPlus),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot)});
        //1 Buster Sword + 5 Machalite Ingot + 2 Earth Crystal + 5 Iron Ore
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSwordPlus),new Object[] {
                new ItemStack(MHItems.weaponBusterSword),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot)});
        //1 Buster Sword+ + 3 Dragonite Ingot + 5 Machalite Ingot + 10 Earth Crystal + 3 Killer Beetle
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSwordPlus),new Object[] {
                new ItemStack(MHItems.weaponBusterSword),
                new ItemStack(MHItems.itemDragoniteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemKillerBeetle)});

        //2 Monster Bone S + 1 Jaggi Hide
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponBoneBlade), new Object[] {" y "," y "," z ",'y',MHItems.itemMonsterBoneS,'z',MHItems.itemJaggiHide});
        //1 Bone Blade + 4 Monster Bone S + 2 Jaggi Hide
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBoneBladePlus),new Object[] {
                new ItemStack(MHItems.weaponBoneBlade),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemJaggiHide),
                new ItemStack(MHItems.itemJaggiHide)});
        //1 Bone Blade+ + 7 Monster Bone S + 5 Monster Bone M
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponJawblade),new Object[] {
                new ItemStack(MHItems.weaponBoneBladePlus),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM)});
        //1 Jawblade + 5 Monster Bone M + 3 Jumbo Bone + 5 Earth Crystal
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponGiantJawblade),new Object[] {
                new ItemStack(MHItems.weaponJawblade),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemJumboBone),
                new ItemStack(MHItems.itemJumboBone),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal)});

        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
    }
}
