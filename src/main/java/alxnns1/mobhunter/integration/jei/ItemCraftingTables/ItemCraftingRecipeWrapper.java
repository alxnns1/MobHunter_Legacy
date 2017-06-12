package alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import alxnns1.mobhunter.crafting.ArmourCraftingRecipe;
import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import alxnns1.mobhunter.crafting.WeaponCraftingRecipe;
import alxnns1.mobhunter.integration.jei.MobHunterPlugin;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapper;
import mezz.jei.api.recipe.IRecipeWrapperFactory;
import net.minecraft.item.ItemStack;

import java.util.Collections;
import java.util.List;

/**
 * Created by Mark on 08/12/2016.
 */
public class ItemCraftingRecipeWrapper extends BlankRecipeWrapper
{
    public static final Factory<WeaponCraftingRecipe> FACTORY_WEAPON = new Factory<WeaponCraftingRecipe>();
    public static final Factory<ArmourCraftingRecipe> FACTORY_ARMOUR = new Factory<ArmourCraftingRecipe>();

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

    private static class Factory<T extends MHCraftingRecipe> implements IRecipeWrapperFactory<T>
    {
        @Override
        public IRecipeWrapper getRecipeWrapper(T recipe)
        {
            return new ItemCraftingRecipeWrapper(recipe);
        }
    }
}
