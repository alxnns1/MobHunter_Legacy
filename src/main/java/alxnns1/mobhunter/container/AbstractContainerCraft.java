package alxnns1.mobhunter.container;

import alxnns1.mobhunter.gui.AbstractGuiCraft;
import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Arrays;
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
        recipes = new ArrayList<MHCraftingRecipe>(5);
        recipesValid = new ArrayList<Boolean>(5);
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
            public int getSlotStackLimit()
            {
                return 1;
            }
        });
    }

    public boolean checkHasAllItems(IInventory inv, NonNullList<Object> input)
    {
        return checkPlayerInv(inv, input).isEmpty();
    }

    /**
     * Checks the player's inventory for all of the input items.
     * Returns missing items.
     */
    @SuppressWarnings("unchecked")
    public ArrayList<Object> checkPlayerInv(IInventory inv, NonNullList<Object> input)
    {
        ArrayList<Object> required = new ArrayList<Object>(input.size());
        //Go through all of the ingredients
        for(int r = 0; r < input.size(); r++)
        {
            Object o = input.get(r);
            if(o instanceof ItemStack)
            {
                required.add(((ItemStack) o).copy()); //Want a copy, not a reference
                o = required.get(r);
            }
            else
                required.add(o);
            //Check if each ingredient is in the player inventory
            for(int i = 0; i < inv.getSizeInventory(); i++)
            {
                ItemStack stack = inv.getStackInSlot(i);
                if(stack == null) continue;

                if(o instanceof ItemStack)
                {
                    ItemStack oStack = (ItemStack) o;
                    if(OreDictionary.itemMatches(oStack, stack, false))
                    {
                        oStack.shrink(stack.getCount());
                        if(oStack.getCount() > 0)
                            required.set(r, oStack);
                        else
                            required.set(r, null);
                    }
                }
                else if(o instanceof NonNullList)
                {
                    if(OreDictionary.containsMatch(false, (NonNullList<ItemStack>) o, stack))
                    {
                        required.set(r, null);
                        break;
                    }
                }
                //If all of this ingredient is in inventory, then skip to the next one
                if(required.get(r) == null)
                    break;
            }
        }
        //Remove all null items
        for(int i = 0; i < required.size(); i++)
        {
            if(required.get(i) == null)
            {
                required.remove(i);
                i -= 1;
            }
        }
        return required;
    }

    protected abstract List<MHCraftingRecipe> getRecipes();

    /**
     * Gets the recipes for the given key item in the slot
     */
    protected void reloadRecipes()
    {
        recipes = getRecipes();
        recipesValid = new ArrayList<Boolean>(Arrays.asList(false, false, false, false, false));
        recipeStart = 0;

        //Crafting buttons
        for(int i = recipeStart; i < recipeStart + 5; i++)
        {
            if(recipes.size() < i + 1)
                recipesValid.set(i, false);
            else
            {
                MHCraftingRecipe r = recipes.get(i);
                recipesValid.set(i, r == null ? null : checkHasAllItems(inventoryPlayer, r.getInput()));
            }
        }
    }

    /**
     * Refreshes the view of recipes in the GUI (normally done after an arrow has been clicked)
     */
    protected void refreshRecipes()
    {
        //LogHelper.info("Refreshing recipes - start: " + recipeStart);
        for(int i = 0; i < 5; i++)
        {
            int recipeActualI = recipeStart + i;
            if(recipes.size() < recipeActualI + 1)
                recipesValid.set(i, false);
            else
            {
                MHCraftingRecipe r = recipes.get(recipeActualI);
                recipesValid.set(i, r == null ? null : checkHasAllItems(inventoryPlayer, r.getInput()));
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
                if(checkHasAllItems(inventoryPlayer, recipes.get(actualRecipeI).getInput()))
                {
                    if(!world.isRemote)
                    {
                        MHCraftingRecipe recipe = recipes.get(actualRecipeI);

                        //Collect the recipe inputs in an inventory for the player crafting event
                        InventoryBasic inv = new InventoryBasic("MHCraftingRecipe", false, recipe.getRecipeSize() + 1);
                        ItemStack keyItem = recipe.getKeyInput();
                        if(keyItem != null)
                            inv.addItem(recipe.getKeyInput());
                        for(Object object : recipe.getInput())
                        {
                            if(object instanceof ItemStack)
                                inv.addItem((ItemStack) object);
                            else if(object instanceof List)
                                inv.addItem(((List<ItemStack>) object).get(0));
                        }
                        net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(playerIn, recipe.getRecipeOutput(), inv);

                        if(!playerIn.capabilities.isCreativeMode)
                        {
                            //Remove ingredients from player inventory
                            for(Object item : recipe.getInput())
                            {
                                if(item instanceof ItemStack)
                                {
                                    ItemStack toRemove = (ItemStack) item;
                                    playerIn.inventory.clearMatchingItems(toRemove.getItem(), toRemove.getMetadata(), toRemove.getCount(), null);
                                }
                                else if(item instanceof List)
                                {
                                    List<ItemStack> toRemove = (List<ItemStack>) item;
                                    for(ItemStack s : toRemove)
                                        if(playerIn.inventory.clearMatchingItems(s.getItem(), s.getMetadata(), 1, null) > 0)
                                            break;
                                }
                            }
                        }

                        //Change key item to recipe output
                        ItemStack newItem = recipe.getRecipeOutput();
                        if(stack != null)
                        {
                            //Set new item to have taken the same amount of damage
                            newItem.setItemDamage(stack.getItemDamage());
                            if(stack.isItemEnchanted())
                                //Copy over enchantments
                                EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(stack), newItem);
                        }
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

        for (int i = 0; i < this.listeners.size(); ++i)
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
                recipesValid = new ArrayList<Boolean>(5);
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

        if (slotObject != null && slotObject.getHasStack())
        {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();

            //If slot 0 (input)
            if (slot == 0)
            {
                if (!this.mergeItemStack(stackInSlot, slotI, slotI+36, true))
                    return null;

                slotObject.onSlotChange(stackInSlot, stack);
            }
            //If slot Inventory
            else if (slot >= slotI && slot <= slotI+36)
            {
                //Only move 1 item
                Slot guiSlot = inventorySlots.get(0);
                if(guiSlot.getHasStack())
                    return null;
                //Only make the move on the server to fix leaving behind a stack of 0 when there was only 1 in the stack before
                if(!player.world.isRemote)
                    guiSlot.putStack(stackInSlot.splitStack(1));
            }

            if (stackInSlot.getCount() == 0)
                slotObject.putStack(null);
            else
                slotObject.onSlotChanged();

            if (stackInSlot.getCount() == stack.getCount())
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
