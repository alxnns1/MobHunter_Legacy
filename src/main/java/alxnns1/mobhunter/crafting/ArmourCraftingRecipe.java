package alxnns1.mobhunter.crafting;

import net.minecraft.item.Item;

/**
 * Created by Mark on 09/12/2016.
 */
public class ArmourCraftingRecipe extends MHCraftingRecipe<ArmourCraftingRecipe>
{
    public ArmourCraftingRecipe(Item result, Object... inputs)
    {
        super(result, inputs);
    }

    public ArmourCraftingRecipe(Item result, Item key, Object... inputs)
    {
        super(result, key, inputs);
    }
}
