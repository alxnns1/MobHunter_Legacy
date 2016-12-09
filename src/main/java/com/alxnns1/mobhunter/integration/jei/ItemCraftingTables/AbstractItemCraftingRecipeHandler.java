package com.alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import com.alxnns1.mobhunter.crafting.MHCraftingRecipe;
import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

/**
 * Created by Mark on 08/12/2016.
 */
public abstract class AbstractItemCraftingRecipeHandler<T extends MHCraftingRecipe> implements IRecipeHandler<T>
{
    @Override
    public String getRecipeCategoryUid(T recipe)
    {
        return getRecipeCategoryUid();
    }

    @Override
    public IRecipeWrapper getRecipeWrapper(T recipe)
    {
        return new ItemCraftingRecipeWrapper(recipe);
    }

    @Override
    public boolean isRecipeValid(T recipe)
    {
        return recipe.getRecipeOutput() != null && recipe.getInput() != null && recipe.getInput().size() > 0;
    }
}
