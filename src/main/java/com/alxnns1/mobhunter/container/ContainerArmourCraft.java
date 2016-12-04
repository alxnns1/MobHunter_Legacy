package com.alxnns1.mobhunter.container;

import com.alxnns1.mobhunter.crafting.ArmourCraftingManager;
import com.alxnns1.mobhunter.crafting.MHCraftingRecipe;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public class ContainerArmourCraft extends AbstractContainerCraft
{
    public ContainerArmourCraft(EntityPlayer player, World worldIn)
    {
        super(player, worldIn);
    }

    @Override
    protected List<MHCraftingRecipe> getRecipes()
    {
        return ArmourCraftingManager.getInstance().findMatchingRecipes((InventoryCrafting) inventory, inventoryPlayer, world);
    }
}
