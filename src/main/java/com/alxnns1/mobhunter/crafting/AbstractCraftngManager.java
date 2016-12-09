package com.alxnns1.mobhunter.crafting;

import net.minecraft.block.Block;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public abstract class AbstractCraftngManager<T extends MHCraftingRecipe>
{
    /**
     * Returns the List<> of all recipes
     */
    public abstract List<T> getRecipeList();

    public abstract T newRecipe(ItemStack result, ItemStack key, Object ... recipe);

    private void addStack(ArrayList<ItemStack> stacks, ItemStack stack)
    {
        for(int i = 0; i < stacks.size(); i++)
        {
            ItemStack s = stacks.get(i);
            if(OreDictionary.itemMatches(s, stack, false))
            {
                s.stackSize += stack.stackSize;
                return;
            }
        }
        stacks.add(stack);
    }

    public void addRecipeNullKey(Item result, Object ... recipeObj)
    {
        addRecipeNullKey(new ItemStack(result), recipeObj);
    }

    public void addRecipeNullKey(ItemStack result, Object ... recipeObj)
    {
        addRecipe(result, (ItemStack) null, recipeObj);
    }

    public void addRecipe(Item result, Item keyItem, Object ... recipeObj)
    {
        addRecipe(new ItemStack(result), new ItemStack(keyItem), recipeObj);
    }

    public void addRecipe(Item result, ItemStack keyItem, Object ... recipeObj)
    {
        addRecipe(new ItemStack(result), keyItem, recipeObj);
    }

    public void addRecipe(ItemStack result, Item keyItem, Object ... recipeObj)
    {
        addRecipe(result, new ItemStack(keyItem), recipeObj);
    }

    public void addRecipe(ItemStack result, ItemStack keyItem, Object ... recipeObj)
    {
        //Turn Items and Blocks into ItemStacks
        Object[] r = new Object[0];
        ArrayList<ItemStack> stacks = new ArrayList<ItemStack>();
        for(int i = 0; i < recipeObj.length; i++)
        {
            Object o = recipeObj[i];
            if(o instanceof Item)
                addStack(stacks, new ItemStack((Item)o));
            else if(o instanceof Block)
                addStack(stacks, new ItemStack((Block)o));
            else if(o instanceof ItemStack)
                addStack(stacks, (ItemStack) o);
            else
                r = ArrayUtils.add(r, o);
        }
        r = ArrayUtils.addAll(r, stacks.toArray());
        getRecipeList().add(newRecipe(result, keyItem, r));
    }

    public List<MHCraftingRecipe> findMatchingRecipes(InventoryCrafting inv, InventoryPlayer invPlayer, World world)
    {
        List<MHCraftingRecipe> r = new ArrayList<MHCraftingRecipe>();
        for(int j = 0; j < getRecipeList().size(); ++j)
        {
            MHCraftingRecipe WURecipe = getRecipeList().get(j);
            if(WURecipe.matches(inv, world))
                r.add(WURecipe);
        }
        return r;
    }
}
