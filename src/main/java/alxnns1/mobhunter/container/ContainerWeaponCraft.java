package alxnns1.mobhunter.container;

import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import alxnns1.mobhunter.crafting.WeaponCraftingManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public class ContainerWeaponCraft extends AbstractContainerCraft
{
    public ContainerWeaponCraft(EntityPlayer player, World worldIn)
    {
        super(player, worldIn);
    }

    @Override
    protected List<MHCraftingRecipe> getRecipes()
    {
        return WeaponCraftingManager.findMatchingRecipes((InventoryCrafting) inventory);
    }
}
