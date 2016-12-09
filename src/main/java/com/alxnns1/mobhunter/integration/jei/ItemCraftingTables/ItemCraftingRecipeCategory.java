package com.alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import com.alxnns1.mobhunter.reference.Reference;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.BlankRecipeCategory;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;

import java.util.List;

/**
 * Created by Mark on 08/12/2016.
 */
public class ItemCraftingRecipeCategory extends BlankRecipeCategory<ItemCraftingRecipeWrapper>
{
    private final String uid;
    private final String title;
    private final IDrawable background;

    public ItemCraftingRecipeCategory(IGuiHelper guiHelper, String unlocName)
    {
        uid = Reference.MOD_ID + ":" + unlocName;
        title = I18n.format("jei.recipe." + unlocName);
        background = guiHelper.createBlankDrawable(150, 110);
    }

    @Override
    public String getUid()
    {
        return uid;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public IDrawable getBackground()
    {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayout recipeLayout, ItemCraftingRecipeWrapper recipeWrapper, IIngredients ingredients)
    {
        //TODO: Finish recipe layout in GUI!

        IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();
        int slotId = 0;

        //List<List<ItemStack>> inputs = ingredients.getInputs(ItemStack.class);
        //ItemStack keyInput = inputs.remove(0).get(0);

        //Key Input Slot
        guiStacks.init(slotId++, true, 0, 0);

        //Ingredients
        for(int i = 0; i < ingredients.getInputs(ItemStack.class).size() - 1; i++)
            guiStacks.init(slotId++, true, 20, i * 18);

        //Output Slot
        guiStacks.init(slotId, false, 40, 0);

        //Set Ingredients
        guiStacks.set(ingredients);
    }
}
