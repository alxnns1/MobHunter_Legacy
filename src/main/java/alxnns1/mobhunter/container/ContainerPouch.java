package alxnns1.mobhunter.container;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.item.ItemMHPouch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Mark on 02/12/2016.
 */
public class ContainerPouch extends MHContainer
{
	public ContainerPouch(EntityPlayer player, World world)
	{
		super(player, ItemMHPouch.getInventory(player.getHeldItemMainhand()), world);
	}

	@Override
	protected void addSlots()
	{
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 9; j++)
				addSlotToContainer(new Slot(inventory, slotI++, 8 + j * 18, 18 + i * 18)
				{
					@Override
					public boolean isItemValid(ItemStack stack)
					{
						return stack.isEmpty() ||
								(stack.getItem().getRegistryName().getResourceDomain().equals(MobHunter.MOD_ID) &&
										!stack.getItem().equals(MHItems.itemFieldPouch));
					}
				});
	}
}
