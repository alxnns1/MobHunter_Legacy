package com.alxnns1.mobhunter.crafting;

import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapelessOreRecipe;
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

    private WeaponUpgradeManager()
    {
        //Add recipes here
        addRecipe(Items.DIAMOND_SWORD, Items.GOLDEN_SWORD, new Object[] {Items.GOLD_INGOT, Items.GOLD_INGOT, Items.GOLD_INGOT, Items.NETHER_STAR});
    }

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
        Object[] r = new Object[recipeObj.length];
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

    @SuppressWarnings("unchecked")
    public boolean checkPlayerInv(IInventory inv, ArrayList<Object> input)
    {
        ArrayList<Object> required = new ArrayList<Object>(input);
        //Go through inventory
        for(int i = 0; i < inv.getSizeInventory(); i++)
        {
            ItemStack stack = inv.getStackInSlot(i);
            if(stack == null) continue;

            boolean inRecipe = false;
            //Check stack against recipe inputs
            for(int r = 0; r < required.size(); r++)
            {
                Object o = required.get(r);
                if(o instanceof ItemStack)
                {
                    ItemStack oStack = (ItemStack) o;
                    if(OreDictionary.itemMatches(oStack, stack, false))
                    {
                        inRecipe = true;
                        oStack.stackSize -= stack.stackSize;
                        if(oStack.stackSize > 0)
                            required.set(i, oStack);
                        else
                            required.remove(i);
                    }
                }
                else if(o instanceof List)
                {
                    for(ItemStack oStack : (List<ItemStack>) o)
                    {
                        if(OreDictionary.itemMatches(oStack, stack, false))
                        {
                            inRecipe = true;
                            required.remove(i);
                            break;
                        }
                    }
                }
                if(inRecipe) break;
            }
            if(!inRecipe) return false;
        }
        return required.isEmpty();
    }

    public ArrayList<WeaponUpgradeRecipe> findMatchingRecipes(InventoryCrafting inv, InventoryPlayer invPlayer, World world)
    {
        ArrayList<WeaponUpgradeRecipe> r = new ArrayList<WeaponUpgradeRecipe>();
        for(int j = 0; j < recipes.size(); ++j)
        {
            WeaponUpgradeRecipe WURecipe = recipes.get(j);
            if(WURecipe.matches(inv, world) && checkPlayerInv(invPlayer, WURecipe.getInput()))
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
