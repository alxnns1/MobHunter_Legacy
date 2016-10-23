package com.alxnns1.mobhunter.crafting;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by Mark on 06/07/2016.
 */
public class WeaponCraftingManager extends AbstractCraftngManager
{
    private static final WeaponCraftingManager instance = new WeaponCraftingManager();
    private List<MHCraftingRecipe> recipes = Lists.newArrayList();

    public static WeaponCraftingManager getInstance()
    {
        return instance;
    }

    private WeaponCraftingManager() {}

    @Override
    public List<MHCraftingRecipe> getRecipeList()
    {
        return recipes;
    }
}
