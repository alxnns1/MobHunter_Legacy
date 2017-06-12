package alxnns1.mobhunter.crafting;

import com.google.common.collect.Lists;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Mark on 06/07/2016.
 */
public class WeaponCraftingManager extends AbstractCraftngManager<WeaponCraftingRecipe>
{
    private static final WeaponCraftingManager instance = new WeaponCraftingManager();
    private List<WeaponCraftingRecipe> recipes = Lists.newArrayList();

    public static WeaponCraftingManager getInstance()
    {
        return instance;
    }

    private WeaponCraftingManager() {}

    @Override
    public List<WeaponCraftingRecipe> getRecipeList()
    {
        return recipes;
    }

    @Override
    public WeaponCraftingRecipe newRecipe(ItemStack result, ItemStack key, Object... recipe)
    {
        return new WeaponCraftingRecipe(result, key, recipe);
    }
}
