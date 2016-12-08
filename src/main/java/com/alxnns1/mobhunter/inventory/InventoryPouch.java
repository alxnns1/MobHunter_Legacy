package com.alxnns1.mobhunter.inventory;

import com.alxnns1.mobhunter.block.BlockBbq;
import com.alxnns1.mobhunter.block.BlockCraft;
import com.alxnns1.mobhunter.block.BlockNatural;
import com.alxnns1.mobhunter.block.BlockResource;
import com.alxnns1.mobhunter.item.ItemMHConsumable;
import com.alxnns1.mobhunter.item.ItemMHResource;
import com.alxnns1.mobhunter.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;

/**
 * Created by Mark on 02/12/2016.
 */
public class InventoryPouch implements IInventory
{
    private String inventoryTitle;
    private final int slotsCount;
    private final ItemStack[] inventoryContents;
    private boolean hasCustomName;
    private ItemStack pouch;

    public InventoryPouch(ItemStack pouch, String title, boolean customName, int slotCount)
    {
        this.inventoryTitle = title;
        this.hasCustomName = customName;
        this.slotsCount = slotCount;
        this.inventoryContents = new ItemStack[slotCount];
        this.pouch = pouch;
    }

    /**
     * Returns the stack in the given slot.
     */
    @Override
    public ItemStack getStackInSlot(int index)
    {
        return index >= 0 && index < this.inventoryContents.length ? this.inventoryContents[index] : null;
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    @Override
    public ItemStack decrStackSize(int index, int count)
    {
        ItemStack itemstack = ItemStackHelper.getAndSplit(inventoryContents, index, count);

        if(itemstack != null)
            markDirty();

        return itemstack;
    }

    public ItemStack addItem(ItemStack stack)
    {
        ItemStack itemstack = stack.copy();

        for(int i = 0; i < slotsCount; ++i)
        {
            ItemStack itemstack1 = getStackInSlot(i);

            if(itemstack1 == null && isItemValidForSlot(i, itemstack))
            {
                setInventorySlotContents(i, itemstack);
                markDirty();
                return null;
            }

            if(ItemStack.areItemsEqual(itemstack1, itemstack))
            {
                int j = Math.min(getInventoryStackLimit(), itemstack1.getMaxStackSize());
                int k = Math.min(itemstack.stackSize, j - itemstack1.stackSize);

                if(k > 0)
                {
                    itemstack1.stackSize += k;
                    itemstack.stackSize -= k;

                    if(itemstack.stackSize <= 0)
                    {
                        markDirty();
                        return null;
                    }
                }
            }
        }

        if(itemstack.stackSize != stack.stackSize)
            markDirty();

        return itemstack;
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    @Override
    public ItemStack removeStackFromSlot(int index)
    {
        if (inventoryContents[index] != null)
        {
            ItemStack itemstack = inventoryContents[index];
            inventoryContents[index] = null;
            return itemstack;
        }
        else
            return null;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    @Override
    public void setInventorySlotContents(int index, @Nullable ItemStack stack)
    {
        inventoryContents[index] = stack;

        if (stack != null && stack.stackSize > getInventoryStackLimit())
            stack.stackSize = getInventoryStackLimit();

        markDirty();
    }

    /**
     * Returns the number of slots in the inventory.
     */
    @Override
    public int getSizeInventory()
    {
        return slotsCount;
    }

    /**
     * Get the name of this object. For players this returns their username
     */
    @Override
    public String getName()
    {
        return inventoryTitle;
    }

    /**
     * Returns true if this thing is named
     */
    @Override
    public boolean hasCustomName()
    {
        return hasCustomName;
    }

    /**
     * Sets the name of this inventory. This is displayed to the client on opening.
     */
    public void setCustomName(String inventoryTitleIn)
    {
        hasCustomName = true;
        inventoryTitle = inventoryTitleIn;
    }

    /**
     * Get the formatted ChatComponent that will be used for the sender's username in chat
     */
    @Override
    public ITextComponent getDisplayName()
    {
        return hasCustomName() ? new TextComponentString(getName()) : new TextComponentTranslation(getName());
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    @Override
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * For tile entities, ensures the chunk containing the tile entity is saved to disk later - the game won't think it
     * hasn't changed and skip it.
     */
    @Override
    public void markDirty() {}

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    @Override
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        return true;
    }

    @Override
    public void openInventory(EntityPlayer player)
    {
        //Read stacks from pouch

        NBTTagList stackList = NBTHelper.getList(pouch, "inventory");
        for(int i = 0; i < stackList.tagCount(); i++)
        {
            NBTTagCompound tag = stackList.getCompoundTagAt(i);
            inventoryContents[tag.getByte("slot")] = ItemStack.loadItemStackFromNBT(tag);
        }
    }

    @Override
    public void closeInventory(EntityPlayer player)
    {
        //Write stacks to pouch

        NBTTagList stackList = new NBTTagList();
        for(int i = 0; i < slotsCount; i++)
        {
            if(inventoryContents[i] == null) continue;
            NBTTagCompound tag = new NBTTagCompound();
            tag.setByte("slot", (byte) i);
            inventoryContents[i].writeToNBT(tag);
            stackList.appendTag(tag);
        }
        NBTHelper.setList(pouch, "inventory", stackList);
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    @Override
    public boolean isItemValidForSlot(int index, @Nullable ItemStack stack)
    {
        if(stack == null)
            return true;
        Item item = stack.getItem();
        if(item instanceof ItemMHConsumable || item instanceof ItemMHResource)
            return true;
        else if(item instanceof ItemBlock)
        {
            Block block = ((ItemBlock) item).getBlock();
            if(block instanceof BlockBbq || block instanceof BlockNatural || block instanceof BlockResource || block instanceof BlockCraft)
                return true;
        }
        return false;
    }

    @Override
    public int getField(int id)
    {
        return 0;
    }

    @Override
    public void setField(int id, int value) {}

    @Override
    public int getFieldCount()
    {
        return 0;
    }

    @Override
    public void clear()
    {
        for(int i = 0; i < inventoryContents.length; ++i)
            inventoryContents[i] = null;
    }
}
