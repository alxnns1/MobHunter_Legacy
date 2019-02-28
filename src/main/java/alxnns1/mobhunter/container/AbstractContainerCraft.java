package alxnns1.mobhunter.container;

import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import alxnns1.mobhunter.gui.AbstractGuiCraft;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by Mark on 10/05/2016.
 */
public abstract class AbstractContainerCraft extends MHContainer
{
	/** Used to store the currently viewable recipes for the buttons */
	public List<MHCraftingRecipe> recipes;
	public List<Boolean> recipesValid;
	/** This will be used to scroll through recipes */
	public int recipeStart = 0;

	public AbstractContainerCraft(EntityPlayer player, World worldIn)
	{
		super(player, null, worldIn);
		recipes = new ArrayList<>(5);
		recipesValid = new ArrayList<>(5);
		reloadRecipes();
	}

	@Override
	protected void init()
	{
		invStartX = 48;
		invStartY = 122;
		inventory = new InventoryCrafting(this, 1, 1);
	}

	@Override
	protected void addSlots()
	{
		addSlotToContainer(new Slot(inventory, 0, 14, 53)
		{
			@Override
			public int getSlotStackLimit()
			{
				return 1;
			}
		});
	}

	public boolean checkHasAllItems(IInventory inv, NonNullList<Ingredient> input)
	{
		return getStacksFromInv(inv, input).size() == input.size();
	}

	private static int getStackCountIfExists(ItemStack stack, Collection<ItemStack> list)
	{
		for(ItemStack listStack : list)
			if(OreDictionary.itemMatches(stack, listStack, false))
				return listStack.getCount();
		return 0;
	}

	/**
	 * Checks the player's inventory for all of the input items.
	 * Returns missing items.
	 */
	public ArrayList<ItemStack> getStacksFromInv(IInventory inv, NonNullList<Ingredient> input)
	{
		ArrayList<ItemStack> foundComplete = new ArrayList<>();
		ArrayList<ItemStack> found = new ArrayList<>();
		//Go through all of the ingredients
		for(Ingredient ing : input)
		{
			NonNullList<ItemStack> ingStacks = NonNullList.from(ItemStack.EMPTY, ing.getMatchingStacks());
			//Check if each ingredient is in the player inventory
			for(int i = 0; i < inv.getSizeInventory(); i++)
			{
				ItemStack stack = inv.getStackInSlot(i);
				if(stack.isEmpty()) continue;

				int matchedSize = getStackCountIfExists(stack, ingStacks);

				if(matchedSize > 0)
				{
					boolean existingStackUpdated = false;
					//If we already have the same stack, then update its count
					for(ItemStack foundStack : found)
					{
						if(foundStack.isItemEqual(stack))
						{
							int stackSize = Math.max(foundStack.getCount() + stack.getCount(), matchedSize);
							foundStack.setCount(stackSize);
							existingStackUpdated = true;
							if(stackSize == matchedSize) foundComplete.add(foundStack);
							break;
						}
					}

					//Add a new stack to the found stacks
					if(!existingStackUpdated)
					{
						ItemStack foundNew = stack.copy();
						int stackSize = Math.max(foundNew.getCount(), matchedSize);
						foundNew.setCount(stackSize);
						found.add(foundNew);
						if(stackSize == matchedSize) foundComplete.add(foundNew);
					}
					break;
				}
			}
		}
		return foundComplete;
	}

	protected abstract List<MHCraftingRecipe> getRecipes();

	/**
	 * Gets the recipes for the given key item in the slot
	 */
	protected void reloadRecipes()
	{
		recipes = getRecipes();
		recipes.sort(((o1, o2) -> o1.getOutput().getDisplayName().compareToIgnoreCase(o2.getOutput().getDisplayName())));
		recipesValid = new ArrayList<>(Arrays.asList(false, false, false, false, false));
		recipeStart = 0;

		//Crafting buttons
		for(int i = recipeStart; i < recipeStart + 5; i++)
		{
			if(recipes.size() < i + 1)
				recipesValid.set(i, false);
			else
			{
				MHCraftingRecipe r = recipes.get(i);
				recipesValid.set(i, r == null ? null : checkHasAllItems(inventoryPlayer, r.getInputs()));
			}
		}
	}

	/**
	 * Refreshes the view of recipes in the GUI (normally done after an arrow has been clicked)
	 */
	protected void refreshRecipes()
	{
		//MobHunter.LOGGER.info("Refreshing recipes - start: " + recipeStart);
		for(int i = 0; i < 5; i++)
		{
			int recipeActualI = recipeStart + i;
			if(recipes.size() < recipeActualI + 1)
				recipesValid.set(i, false);
			else
			{
				MHCraftingRecipe r = recipes.get(recipeActualI);
				recipesValid.set(i, r == null ? null : checkHasAllItems(inventoryPlayer, r.getInputs()));
			}
		}
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	@Override
	public void onCraftMatrixChanged(IInventory inventoryIn)
	{
		reloadRecipes();
		detectAndSendChanges();
	}

	/**
	 * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
	 * I am using this to craft the item (i.e. remove old item and create new one)
	 */
	@Override
	@SuppressWarnings("all")
	public boolean enchantItem(EntityPlayer playerIn, int id)
	{
		switch(id)
		{
			case AbstractGuiCraft.BUTTON_ID_ARROW_UP: //Up Arrow
				decRecipeStart();
				refreshRecipes();
				return true;
			case AbstractGuiCraft.BUTTON_ID_ARROW_DOWN: //Down Arrow
				incRecipeStart();
				refreshRecipes();
				return true;
			default: //Craft Button
				boolean putInGuiSlot = id > 0;
				id = Math.abs(id) - 1;
				ItemStack stack = inventory.getStackInSlot(0);
				int actualRecipeI = id + recipeStart;

				if(recipes.isEmpty() || recipes.get(actualRecipeI) == null) return false;
				MHCraftingRecipe recipe = recipes.get(actualRecipeI);
				ArrayList<ItemStack> foundStacks = getStacksFromInv(inventoryPlayer, recipe.getInputs());
				if(foundStacks.size() == recipe.getInputs().size())
				{
					if(!world.isRemote)
					{
						//Collect the recipe inputs in an inventory for the player crafting event
						InventoryBasic inv = new InventoryBasic("MHCraftingRecipe", false, recipe.getSize());
						ItemStack keyItem = recipe.getKeyInput();
						if(keyItem != null)
							inv.addItem(recipe.getKeyInput());
						foundStacks.forEach(foundStack -> inv.addItem(foundStack));

						net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(playerIn, recipe.getOutput(), inv);

						if(!playerIn.capabilities.isCreativeMode)
						{
							//Remove ingredients from player inventory
							foundStacks.forEach(foundStack ->
									playerIn.inventory.clearMatchingItems(foundStack.getItem(), foundStack.getMetadata(), foundStack.getCount(), null));
						}

						//Change key item to recipe output
						ItemStack newItem = recipe.getOutput();
						//Set new item to have taken the same amount of damage
						newItem.setItemDamage(stack.getItemDamage());
						if(stack.isItemEnchanted())
							//Copy over enchantments
							EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(stack), newItem);
						if(putInGuiSlot)
							inventory.setInventorySlotContents(0, newItem);
						else
							mergeItemStack(newItem, slotI, slotI + 36, true);
						inventory.markDirty();
						reloadRecipes();
					}
					return true;
				}
				else return false;
		}
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for(int i = 0; i < this.listeners.size(); ++i)
		{
			IContainerListener listener = this.listeners.get(i);
			for(int j = 0; j < recipesValid.size(); j++)
				listener.sendWindowProperty(this, j, recipesValid.get(j) ? 1 : 0);
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void updateProgressBar(int id, int data)
	{
		if(id >= 0 && id <= 4)
		{
			if(recipesValid == null || recipesValid.size() == 0)
				recipesValid = new ArrayList<>(5);
			recipesValid.set(id, data == 1);
		}
	}

	/**
	 * Called when the container is closed.
	 */
	@Override
	public void onContainerClosed(EntityPlayer playerIn)
	{
		super.onContainerClosed(playerIn);

		if(world.isRemote) return;
		ItemStack stack = inventory.removeStackFromSlot(0);
		if(stack != null) playerIn.dropItem(stack, false);
	}

	/**
	 * What happens when you shift-click a slot.
	 */
	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot)
	{
		ItemStack stack = null;
		Slot slotObject = this.inventorySlots.get(slot);

		if(slotObject != null && slotObject.getHasStack())
		{
			ItemStack stackInSlot = slotObject.getStack();
			stack = stackInSlot.copy();

			//If slot 0 (input)
			if(slot == 0)
			{
				if(!this.mergeItemStack(stackInSlot, slotI, slotI + 36, true))
					return null;

				slotObject.onSlotChange(stackInSlot, stack);
			}
			//If slot Inventory
			else if(slot >= slotI && slot <= slotI + 36)
			{
				//Only move 1 item
				Slot guiSlot = inventorySlots.get(0);
				if(guiSlot.getHasStack())
					return null;
				//Only make the move on the server to fix leaving behind a stack of 0 when there was only 1 in the stack before
				if(!player.world.isRemote)
					guiSlot.putStack(stackInSlot.splitStack(1));
			}

			if(stackInSlot.getCount() == 0)
				slotObject.putStack(null);
			else
				slotObject.onSlotChanged();

			if(stackInSlot.getCount() == stack.getCount())
				return null;

			slotObject.onTake(player, stackInSlot);
		}
		return stack;
	}

	public void incRecipeStart()
	{
		recipeStart++;
		//int maxStart = recipes.size() - 6;
		//if(recipeStart > maxStart)
		//    recipeStart = maxStart;
	}

	public void decRecipeStart()
	{
		recipeStart--;
		//if(recipeStart < 0)
		//    recipeStart = 0;
	}
}
