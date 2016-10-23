package com.alxnns1.mobhunter.container;

import com.alxnns1.mobhunter.crafting.ArmourCraftingManager;
import com.alxnns1.mobhunter.crafting.MHCraftingRecipe;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public class ContainerArmourCraft extends AbstractContainerCraft
{
    public ContainerArmourCraft(InventoryPlayer invPlayer, World worldIn)
    {
        super(invPlayer, worldIn);
    }

    @Override
    protected List<MHCraftingRecipe> getRecipes()
    {
        return ArmourCraftingManager.getInstance().findMatchingRecipes(inventory, inventoryPlayer, world);
    }
}
