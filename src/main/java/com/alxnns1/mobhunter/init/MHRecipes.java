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
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"xyx", " z ", "   ", 'x', MHItems.itemMysteryBone, 'y', MHItems.itemUnknownSkull, 'z', Items.string});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"w w", "xyx", "xzx", 'w', MHItems.itemMonsterBoneS, 'x', MHItems.itemMysteryBone, 'y', Items.leather, 'z', Items.string});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), new Object[] {"xxx", "y y", "z z", 'x', Items.leather, 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneS});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), new Object[] {"   ", "y y", "z z", 'y', MHItems.itemMonsterBoneS, 'z', MHItems.itemMysteryBone});

        GameRegistry.addRecipe(new ItemStack(MHItems.itemBoneBlade), new Object[] {" y "," y "," z ",'y',MHItems.itemMonsterBoneS,'z',MHItems.itemJaggiHide});

        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemIronSwordPlus),new Object[] {
                new ItemStack(Items.iron_sword),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemBusterSword),new Object[] {
                new ItemStack(MHItems.itemIronSwordPlus),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemBusterSwordPlus),new Object[] {
                new ItemStack(MHItems.itemBusterSword),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot)});
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemBoneBladePlus),new Object[] {
                new ItemStack(MHItems.itemBoneBlade),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemJaggiHide),
                new ItemStack(MHItems.itemJaggiHide)});

        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
    }
}
