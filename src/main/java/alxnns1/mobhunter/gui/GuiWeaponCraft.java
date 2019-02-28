package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.container.ContainerWeaponCraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiWeaponCraft extends AbstractGuiCraft
{
	public GuiWeaponCraft(EntityPlayer player, World world, String blockDisplayName)
	{
		super(new ContainerWeaponCraft(player, world), blockDisplayName, "gui.blockweaponupgrade.");
	}
}
