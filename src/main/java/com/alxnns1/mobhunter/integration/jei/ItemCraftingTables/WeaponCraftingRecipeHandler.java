package com.alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import com.alxnns1.mobhunter.crafting.WeaponCraftingRecipe;
import com.alxnns1.mobhunter.integration.jei.MobHunterPlugin;
import com.alxnns1.mobhunter.reference.Reference;

/**
 * Created by Mark on 09/12/2016.
 */
public class WeaponCraftingRecipeHandler extends AbstractItemCraftingRecipeHandler<WeaponCraftingRecipe>
{
    @Override
    public Class<WeaponCraftingRecipe> getRecipeClass()
    {
        return WeaponCraftingRecipe.class;
    }

    @Override
    public String getRecipeCategoryUid()
    {
        return Reference.MOD_ID + ":" + MobHunterPlugin.WEAPON_CRAFTING_ID;
    }
}
