package com.alxnns1.mobhunter.crafting;

import com.google.common.collect.Lists;
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
 * Created by Mark on 06/07/2016.
 */
public class WeaponUpgradeManager
{
    private static final WeaponUpgradeManager instance = new WeaponUpgradeManager();
    private List<WeaponUpgradeRecipe> recipes = Lists.newArrayList();

    public static WeaponUpgradeManager getInstance()
    {
        return instance;
    }

    private WeaponUpgradeManager() {}

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
        recipes.add(new WeaponUpgradeRecipe(result, keyItem, r));
    }

    public List<WeaponUpgradeRecipe> findMatchingRecipes(InventoryCrafting inv, InventoryPlayer invPlayer, World world)
    {
        List<WeaponUpgradeRecipe> r = new ArrayList<WeaponUpgradeRecipe>();
        for(int j = 0; j < recipes.size(); ++j)
        {
            WeaponUpgradeRecipe WURecipe = recipes.get(j);
            if(WURecipe.matches(inv, world))
                r.add(WURecipe);
        }
        return r;
    }

    /**
     * Returns the List<> of all recipes
     */
    public List<WeaponUpgradeRecipe> getRecipeList()
    {
        return this.recipes;
    }
}
