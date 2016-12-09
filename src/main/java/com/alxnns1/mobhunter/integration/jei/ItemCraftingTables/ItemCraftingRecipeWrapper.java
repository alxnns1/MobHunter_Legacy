package com.alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import com.alxnns1.mobhunter.crafting.MHCraftingRecipe;
import com.alxnns1.mobhunter.integration.jei.MobHunterPlugin;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mark on 08/12/2016.
 */
public class ItemCraftingRecipeWrapper extends BlankRecipeWrapper
{
    private final List<List<ItemStack>> inputs;
    private final ItemStack output;

    public ItemCraftingRecipeWrapper(MHCraftingRecipe recipe)
    {
        inputs = MobHunterPlugin.jeiHelper.getStackHelper().expandRecipeItemStackInputs(recipe.getInput());
        inputs.add(0, Collections.singletonList(recipe.getKeyInput()));
        output = recipe.getRecipeOutput();
    }

    @Override
    public void getIngredients(IIngredients ingredients)
    {
        ingredients.setInputLists(ItemStack.class, inputs);
        ingredients.setOutput(ItemStack.class, output);
    }
}
