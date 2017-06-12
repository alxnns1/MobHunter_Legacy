package alxnns1.mobhunter.container;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.item.ItemMHPouch;
import alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import javax.annotation.Nullable;

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
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                addSlotToContainer(new Slot(inventory, slotI++, 8 + j * 18, 18 + i * 18)
                {
                    @Override
                    public boolean isItemValid(@Nullable ItemStack stack)
                    {
                        //TODO: In 1.11, remove the toLowerCase()
                        return stack == null || (stack.getItem().getRegistryName().getResourceDomain().equals(Reference.MOD_ID.toLowerCase()) && !stack.getItem().equals(MHItems.itemFieldPouch));
                    }
                });
    }
}
