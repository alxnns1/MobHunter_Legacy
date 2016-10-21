package com.alxnns1.mobhunter.crafting;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.ShapelessOreRecipe;

import java.util.List;

/**
 * Created by Mark on 07/07/2016.
 */
public class WeaponCraftingRecipe extends ShapelessOreRecipe
{
    private ItemStack inputKey = null;

    public WeaponCraftingRecipe(ItemStack result, ItemStack key, Object ... recipe)
    {
        super(result, recipe);
        inputKey = key == null ? null : key.copy();
    }

    public ItemStack getKeyInput()
    {
        return inputKey;
    }

    @Override
    public ItemStack getRecipeOutput(){ return output.copy(); }

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn)
    {
        ItemStack item = inv.getStackInSlot(0);
        if(item == null)
            return inputKey == null;
        return item.isItemEqual(inputKey);
    }

    @Override
    public String toString()
    {
        String str = "Output: " + output.getUnlocalizedName() + ", Inputs: ";
        str += (inputKey == null ? "null" : inputKey.getUnlocalizedName()) + ", ";
        for(Object o : input)
        {
            if(o instanceof ItemStack)
                str += ((ItemStack)o).getUnlocalizedName();
            else if(o instanceof Item)
                str += ((Item)o).getUnlocalizedName();
            else if(o instanceof Block)
                str += ((Block)o).getUnlocalizedName();
            else if(o instanceof String)
                str += (String)o;
            else if(o instanceof List)
                str += "List of " + ((List)o).size();
            else if(o == null)
                str += "null";
            else
                str += o.toString();
            str += ", ";
        }
        str = str.substring(0, str.length()-2);
        return str;
    }
}
