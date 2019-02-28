package alxnns1.mobhunter.crafting;

import net.minecraft.item.Item;

/**
 * Created by Mark on 09/12/2016.
 */
public class WeaponCraftingRecipe extends MHCraftingRecipe<WeaponCraftingRecipe>
{
	public WeaponCraftingRecipe(Item result, Object... inputs)
	{
		super(result, inputs);
	}

	public WeaponCraftingRecipe(Item result, Item key, Object... inputs)
	{
		super(result, key, inputs);
	}
}
