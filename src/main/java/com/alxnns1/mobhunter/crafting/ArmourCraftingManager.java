package com.alxnns1.mobhunter.crafting;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public class ArmourCraftingManager extends AbstractCraftngManager
{
    private static final ArmourCraftingManager instance = new ArmourCraftingManager();
    private List<MHCraftingRecipe> recipes = Lists.newArrayList();

    public static ArmourCraftingManager getInstance()
    {
        return instance;
    }

    private ArmourCraftingManager() {}

    @Override
    public List<MHCraftingRecipe> getRecipeList()
    {
        return recipes;
    }
}
