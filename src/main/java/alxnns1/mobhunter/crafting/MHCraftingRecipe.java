package alxnns1.mobhunter.crafting;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.registries.IForgeRegistryEntry;

import java.util.List;

/**
 * Created by Mark on 07/07/2016.
 */
public class MHCraftingRecipe<T extends IForgeRegistryEntry<T>> extends IForgeRegistryEntry.Impl<T>
{
    private ItemStack output = ItemStack.EMPTY;
    private ItemStack inputKey = ItemStack.EMPTY;
    private NonNullList<Ingredient> inputs = NonNullList.create();

    public MHCraftingRecipe(Item result, Object... input)
    {
        this(new ItemStack(result), ItemStack.EMPTY, input);
    }

    public MHCraftingRecipe(Item result, Item key, Object... input)
    {
        this(new ItemStack(result), new ItemStack(key), input);
    }

    public MHCraftingRecipe(ItemStack result, ItemStack key, Object... input)
    {
        output = result.copy();
        inputKey = key.copy();
        for(Object in : input)
        {
            Ingredient ingredient = CraftingHelper.getIngredient(in);
            if(ingredient == null)
            {
                StringBuilder sb = new StringBuilder("Invalid MobHunter crafting recipe: Key Input: ")
                        .append(inputKey).append(", Inputs: ");
                for(Object obj : input)
                    sb.append(obj).append(", ");
                sb.append("Output: ").append(output);
                throw new RuntimeException(sb.toString());
            }
            inputs.add(ingredient);
        }
    }

    public ItemStack getOutput(){ return output.copy(); }

    public ItemStack getKeyInput()
    {
        return inputKey.copy();
    }

    public NonNullList<Ingredient> getInputs()
    {
        return inputs;
    }

    public int getSize()
    {
        return (inputKey.isEmpty() ? 0 : 1) + inputs.size();
    }

    public boolean matches(InventoryCrafting inv)
    {
        return ItemStack.areItemStacksEqual(inv.getStackInSlot(0), inputKey);
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("Output: ")
                .append(output.getUnlocalizedName())
                .append(", Key Input: ")
                .append(inputKey == null ? "null" : inputKey.getUnlocalizedName())
                .append(", Inputs: ");
        for(Object o : inputs)
        {
            if(o instanceof ItemStack)
                sb.append(((ItemStack)o).getUnlocalizedName());
            else if(o instanceof Item)
                sb.append(((Item)o).getUnlocalizedName());
            else if(o instanceof Block)
                sb.append(((Block)o).getUnlocalizedName());
            else if(o instanceof String)
                sb.append((String)o);
            else if(o instanceof List)
                sb.append("List of ").append(((List)o).size());
            else if(o == null)
                sb.append("null");
            else
                sb.append(o.toString());
            sb.append(", ");
        }
        String str = sb.toString();
        str = str.substring(0, str.length() - 2);
        return str;
    }
}
