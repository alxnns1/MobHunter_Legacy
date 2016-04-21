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
        GameRegistry.addRecipe(new ItemStack(MHItems.itemBoneMail), new Object[]{"xyx", "yxy", "xyx", 'x', Items.string, 'y', Items.bone});

        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"wxw", "yzy", "   ", 'w', Items.bone, 'x', new ItemStack(Items.skull,1,0), 'y', MHItems.itemBoneMail, 'z', Items.leather});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"y y", "yxy", "zzz", 'x', Items.string, 'y', MHItems.itemBoneMail, 'z', Items.leather});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), new Object[] {"zzz", "x x", "y y", 'x', Items.string, 'y', MHItems.itemBoneMail, 'z', Items.leather});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), new Object[] {"   ", "y y", "z z", 'y', MHItems.itemBoneMail, 'z', Items.leather});

        GameRegistry.addShapelessRecipe(new ItemStack(Items.skull,1,0), new ItemStack(Items.skull,1, OreDictionary.WILDCARD_VALUE));
    }
}
