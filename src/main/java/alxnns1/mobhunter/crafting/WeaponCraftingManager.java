package alxnns1.mobhunter.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mark on 06/07/2016.
 */
public class WeaponCraftingManager
{
    public static IForgeRegistry<WeaponCraftingRecipe> REGISTRY;

    public static Collection<WeaponCraftingRecipe> getRecipes()
    {
        return REGISTRY.getValuesCollection();
    }

    public static List<MHCraftingRecipe> findMatchingRecipes(InventoryCrafting inv)
    {
        List<MHCraftingRecipe> r = new ArrayList<>();
        for(WeaponCraftingRecipe recipe : getRecipes())
            if(recipe.matches(inv))
                r.add(recipe);
        return r;
    }
}
