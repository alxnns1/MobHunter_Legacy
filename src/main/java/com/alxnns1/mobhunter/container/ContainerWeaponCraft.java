package com.alxnns1.mobhunter.container;

import com.alxnns1.mobhunter.crafting.MHCraftingRecipe;
import com.alxnns1.mobhunter.crafting.WeaponCraftingManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public class ContainerWeaponCraft extends AbstractContainerCraft
{
    public ContainerWeaponCraft(InventoryPlayer invPlayer, World worldIn)
    {
        super(invPlayer, worldIn);
    }

    @Override
    protected List<MHCraftingRecipe> getRecipes()
    {
        return WeaponCraftingManager.getInstance().findMatchingRecipes(inventory, inventoryPlayer, world);
    }
}
