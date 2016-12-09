package com.alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import com.alxnns1.mobhunter.crafting.ArmourCraftingRecipe;
import com.alxnns1.mobhunter.integration.jei.MobHunterPlugin;
import com.alxnns1.mobhunter.reference.Reference;

/**
 * Created by Mark on 09/12/2016.
 */
public class ArmourCraftingRecipeHandler extends AbstractItemCraftingRecipeHandler<ArmourCraftingRecipe>
{
    @Override
    public Class<ArmourCraftingRecipe> getRecipeClass()
    {
        return ArmourCraftingRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid()
    {
        return Reference.MOD_ID + ":" + MobHunterPlugin.ARMOUR_CRAFTING_ID;
    }
}
