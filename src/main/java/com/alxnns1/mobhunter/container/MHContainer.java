package com.alxnns1.mobhunter.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Mark on 06/07/2016.
 */
public class MHContainer extends Container
{
    public IInventory inventory;
    public InventoryPlayer inventoryPlayer;
    protected World world;

    protected int slotI = 0;
    protected int invStartX = 8;
    protected int invStartY = 86;

    public MHContainer(InventoryPlayer invPlayer, IInventory inv, World worldIn)
    {
        world = worldIn;
        inventory = inv;
        inventoryPlayer = invPlayer;
        init();
        addSlots();
        bindPlayerInventory(invPlayer);
    }

    /**
     * Called first in the constructor for anything which cannot be done in the constructor.
     */
    protected void init() {}

    /**
     * Called after init() to add slots to the container.
     */
    protected void addSlots() {}

    /**
     * Adds the player's inventory slots to the container. Called after addSlots().
     */
    protected void bindPlayerInventory(InventoryPlayer inventoryPlayer)
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                addSlotToContainer(new Slot(inventoryPlayer, j + i * 9 + 9, invStartX + j * 18, invStartY + i * 18));

        for (int i = 0; i < 9; i++)
            addSlotToContainer(new Slot(inventoryPlayer, i, invStartX + i * 18, invStartY + 18 * 3 + 4));
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return inventory.isUseableByPlayer(playerIn);
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

            //If GUI slot
            if (slot < slotI)
            {
                if (!mergeItemStack(stackInSlot, slotI, slotI + 36, true))
                    return null;

                slotObject.onSlotChange(stackInSlot, stack);
            }
            //If slot Inventory
            else if (slot >= slotI && slot <= slotI + 36)
            {
                boolean success = false;
                for(int i = 0; i < slotI; i++)
                {
                    if(inventorySlots.get(i).isItemValid(stackInSlot))
                    {
                        if(mergeItemStack(stackInSlot, i, i + 1, false))
                        {
                            success = true;
                            break;
                        }
                    }
                }
                if(!success)
                    return null;
            }

            if (stackInSlot.stackSize == 0)
                slotObject.putStack(null);
            else
                slotObject.onSlotChanged();

            if (stackInSlot.stackSize == stack.stackSize)
                return null;

            slotObject.onPickupFromSlot(player, stackInSlot);
        }

        return stack;
    }

    @Override
    public void addListener(IContainerListener listener)
    {
        super.addListener(listener);
        listener.sendAllWindowProperties(this, inventory);
    }
}
