package com.alxnns1.mobhunter.container;

import com.alxnns1.mobhunter.crafting.WeaponUpgradeManager;
import com.alxnns1.mobhunter.crafting.WeaponUpgradeRecipe;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Mark on 10/05/2016.
 */
public class ContainerWeaponUpgrade extends MHContainer
{
    public ContainerWeaponUpgrade(InventoryPlayer invPlayer, World worldIn)
    {
        super(invPlayer, null, worldIn);
        inventory = new InventoryCrafting(this, 1, 1);
    }

    @Override
    protected void addSlots()
    {
        invStartY = 122;
        addSlotToContainer(new Slot(inventory, 0, 13, 53));
    }

    /**
     * Callback for when the crafting matrix is changed.
     */
    @Override
    public void onCraftMatrixChanged(IInventory inventoryIn)
    {
        ArrayList<WeaponUpgradeRecipe> result = WeaponUpgradeManager.getInstance().findMatchingRecipes(inventory, inventoryPlayer, world);
        //TODO: Do something with the recipes to display them!
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
}
