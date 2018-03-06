package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.container.ContainerArmourCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiArmourCraft extends AbstractGuiCraft
{
    public GuiArmourCraft(EntityPlayer player, World world, String blockDisplayName)
    {
        super(new ContainerArmourCraft(player, world), blockDisplayName, "gui.blockarmourupgrade.");
    }
}
