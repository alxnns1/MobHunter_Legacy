package com.alxnns1.mobhunter.container;

import com.alxnns1.mobhunter.crafting.WeaponUpgradeManager;
import com.alxnns1.mobhunter.crafting.WeaponUpgradeRecipe;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 10/05/2016.
 */
public class ContainerWeaponUpgrade extends MHContainer
{
    /** Used to store the currently viewable recipes for the buttons */
    private WeaponUpgradeRecipe[] recipes;

    public ContainerWeaponUpgrade(InventoryPlayer invPlayer, World worldIn)
    {
        super(invPlayer, null, worldIn);
        recipes = new WeaponUpgradeRecipe[5];
    }

    @Override
    protected void init()
    {
        invStartY = 122;
        inventory = new InventoryCrafting(this, 1, 1);
    }

    @Override
    protected void addSlots()
    {
        addSlotToContainer(new Slot(inventory, 0, 13, 53)
        {
            /**
             * Returns the maximum stack size for a given slot (usually the same as getInventoryStackLimit(), but 1 in the case
             * of armor slots)
             */
            public int getSlotStackLimit()
            {
                return 1;
            }
        });
    }

    /**
     * Checks the player's inventory for all of the input items, and returns true if they're all present.
     * False if at least 1 item is not there.
     * TODO: Change it so that it returns how many of each item there is for use on the tooltip.
     */
    @SuppressWarnings("unchecked")
    public boolean checkPlayerInv(IInventory inv, ArrayList<Object> input)
    {
        ArrayList<Object> required = new ArrayList<Object>(input);
        //Go through all of the ingredients
        for(int r = 0; r < required.size(); r++)
        {
            boolean inRecipe = false;
            Object o = required.get(r);
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
                        oStack.stackSize -= stack.stackSize;
                        if(oStack.stackSize > 0)
                            required.set(r, oStack);
                        else
                            required.set(r, null);
                    }
                }
                else if(o instanceof List)
                {
                    for(ItemStack oStack : (List<ItemStack>) o)
                    {
                        if(OreDictionary.itemMatches(oStack, stack, false))
                        {
                            required.set(r, null);
                            break;
                        }
                    }
                }
                //If all of this ingredient is in inventory, then skip to the next one
                if(required.get(r) == null) break;
            }
            //If any ingredient isn't in the inventory, then return false
            if(required.get(r) != null) return false;
        }

        //See if we found all of the ingredients
        for(Object o : required)
            if(o != null)
                return false;

        return true;
    }

    /**
     * Creates an array of the indexes of the recipes which the player has all the ingredients for.
     */
    private ArrayList<Integer> getValidRecipes(ArrayList<WeaponUpgradeRecipe> recipes, InventoryPlayer inv)
    {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        for(int i = 0; i < recipes.size(); i++)
            if(checkPlayerInv(inv, recipes.get(i).getInput()))
                indexes.add(i);
        return indexes;
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        ArrayList<WeaponUpgradeRecipe> upgrades = WeaponUpgradeManager.getInstance().findMatchingRecipes(inventory, inventoryPlayer, world);
        ArrayList<Integer> valid = getValidRecipes(upgrades, inventoryPlayer);
        String log = "Recipes:\n";
        for(int i = 0; i < upgrades.size(); i++)
        {
            if(valid.contains(i))
                log += "Y - ";
            else
                log += "N - ";
            log += upgrades.get(i).toString();
        }
        LogHelper.info(log);
        //TODO: Do something with the recipes to display them!
    }

    /**
     * Handles the given Button-click on the server, currently only used by enchanting. Name is for legacy.
     * I am using this to upgrade the item (i.e. remove old item and create new one)
     */
    @Override
    @SuppressWarnings("all")
    public boolean enchantItem(EntityPlayer playerIn, int id)
    {
        ItemStack stack = inventory.getStackInSlot(0);

        if(stack == null || recipes[id] == null) return false;
        if(playerIn.capabilities.isCreativeMode || checkPlayerInv(inventoryPlayer, recipes[id].getInput()))
        {
            if(!world.isRemote)
            {
                WeaponUpgradeRecipe recipe = recipes[id];

                if(!playerIn.capabilities.isCreativeMode)
                {
                    //Remove ingredients from player inventory
                    for(Object item : recipe.getInput())
                    {
                        if(item instanceof ItemStack)
                        {
                            ItemStack toRemove = (ItemStack) item;
                            playerIn.inventory.clearMatchingItems(toRemove.getItem(), toRemove.getMetadata(), toRemove.stackSize, null);
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
                if(stack.isItemEnchanted())
                    //Copy over enchantments
                    EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(stack), newItem);
                inventory.setInventorySlotContents(0, newItem);
            }
            return true;
        }
        else
            return false;
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
            //listener.sendProgressBarUpdate();
        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void updateProgressBar(int id, int data)
    {

    }

    /**
     * Called when the container is closed.
     */
    public void onContainerClosed(EntityPlayer playerIn)
    {
        super.onContainerClosed(playerIn);

        if(world.isRemote) return;
        ItemStack stack = inventory.removeStackFromSlot(0);
        if(stack != null) playerIn.dropItem(stack, false);
    }
}
