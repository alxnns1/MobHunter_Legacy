package alxnns1.mobhunter.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Mark on 23/10/2016.
 */
public class ArmourCraftingManager
{
    public static IForgeRegistry<ArmourCraftingRecipe> REGISTRY;

    public static Collection<ArmourCraftingRecipe> getRecipes()
    {
        return REGISTRY.getValuesCollection();
    }

    public static Collection<ArmourCraftingRecipe> findMatchingRecipes(InventoryCrafting inv)
    {
        Collection<ArmourCraftingRecipe> r = new ArrayList<>();
        for(ArmourCraftingRecipe recipe : getRecipes())
            if(recipe.matches(inv))
                r.add(recipe);
        return r;
    }
}
