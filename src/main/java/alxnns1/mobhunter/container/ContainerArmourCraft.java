package alxnns1.mobhunter.container;

import alxnns1.mobhunter.crafting.ArmourCraftingManager;
import alxnns1.mobhunter.crafting.MHCraftingRecipe;
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
		return ArmourCraftingManager.findMatchingRecipes((InventoryCrafting) inventory);
	}
}
