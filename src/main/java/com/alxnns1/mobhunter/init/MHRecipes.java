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
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"xyx", " z ", "   ", 'x', new ItemStack(MHItems.itemBones, 1, 1), 'y', new ItemStack(Items.skull,1,0), 'z', Items.string});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"w w", "xyx", "xzx", 'w', new ItemStack(MHItems.itemBones, 1, 0), 'x', new ItemStack(MHItems.itemBones, 1, 1), 'y', Items.leather, 'z', Items.string});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), new Object[] {"xxx", "y y", "z z", 'x', Items.leather, 'y', new ItemStack(MHItems.itemBones, 1, 1), 'z', new ItemStack(MHItems.itemBones, 1, 0)});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), new Object[] {"   ", "y y", "z z", 'y', new ItemStack(MHItems.itemBones, 1, 0), 'z', new ItemStack(MHItems.itemBones, 1, 1)});

        GameRegistry.addRecipe(new ItemStack(MHItems.itemBoneBlade), new Object[] {" y "," y "," z ",'y',new ItemStack(MHItems.itemBones, 1, 0),'z',Items.leather});

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
                new ItemStack(MHItems.itemBones, 1, 0),
                new ItemStack(MHItems.itemBones, 1, 0),
                new ItemStack(MHItems.itemBones, 1, 0),
                new ItemStack(MHItems.itemBones, 1, 0),
                new ItemStack(Items.leather),
                new ItemStack(Items.leather)});

        GameRegistry.addShapelessRecipe(new ItemStack(Items.skull,1,0), new ItemStack(Items.skull,1, OreDictionary.WILDCARD_VALUE));

        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addSmelting(MHItems.itemRareSteak, new ItemStack(MHItems.itemDoneSteak), 0.2f);
        GameRegistry.addSmelting(MHItems.itemDoneSteak, new ItemStack(MHItems.itemBurntMeat), 0.2f);
    }
}
