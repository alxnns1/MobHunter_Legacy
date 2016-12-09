package com.alxnns1.mobhunter.crafting;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public class ArmourCraftingManager extends AbstractCraftngManager<ArmourCraftingRecipe>
{
    private static final ArmourCraftingManager instance = new ArmourCraftingManager();
    private List<ArmourCraftingRecipe> recipes = Lists.newArrayList();

    public static ArmourCraftingManager getInstance()
    {
        return instance;
    }

    private ArmourCraftingManager() {}

    @Override
    public List<ArmourCraftingRecipe> getRecipeList()
    {
        return recipes;
    }

    @Override
    public ArmourCraftingRecipe newRecipe(ItemStack result, ItemStack key, Object... recipe)
    {
        return new ArmourCraftingRecipe(result, key, recipe);
    }
}
