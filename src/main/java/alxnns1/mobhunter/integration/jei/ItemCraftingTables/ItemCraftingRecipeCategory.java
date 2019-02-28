package alxnns1.mobhunter.integration.jei.ItemCraftingTables;

import alxnns1.mobhunter.MobHunter;
import mezz.jei.api.IGuiHelper;
import mezz.jei.api.gui.IDrawable;
import mezz.jei.api.gui.IGuiItemStackGroup;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeCategory;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 08/12/2016.
 */
public class ItemCraftingRecipeCategory implements IRecipeCategory<ItemCraftingRecipeWrapper>
{
	private final String uid;
	private final String title;
	private final IDrawable background;

	public ItemCraftingRecipeCategory(IGuiHelper guiHelper, String unlocName)
	{
		uid = MobHunter.MOD_ID + ":" + unlocName;
		title = I18n.format("jei.recipe." + unlocName);
		background = guiHelper.createDrawable(new ResourceLocation(MobHunter.MOD_ID, MobHunter.GUI_TEXTURE_DIR + "guicraftupgrade_jei.png"), 0, 0, 166, 56);
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
	public String getModName()
	{
		return MobHunter.MOD_NAME;
	}

	@Override
	public IDrawable getBackground()
	{
		return background;
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, ItemCraftingRecipeWrapper recipeWrapper, IIngredients ingredients)
	{
		IGuiItemStackGroup guiStacks = recipeLayout.getItemStacks();
		int slotId = 0;

		//Key Input Slot
		guiStacks.init(slotId++, true, 5, 19);

		//Ingredients
		for(int i = 0; i < ingredients.getInputs(ItemStack.class).size() - 1; i++)
			guiStacks.init(slotId++, true, 57 + (i * 17 - (i / 3 * 51)), 2 + i / 3 * 17);

		//Output Slot
		guiStacks.init(slotId, false, 143, 19);

		//Set Ingredients
		guiStacks.set(ingredients);
	}
}
