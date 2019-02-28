package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.container.ContainerArmourCraft;
import alxnns1.mobhunter.container.ContainerPouch;
import alxnns1.mobhunter.container.ContainerWeaponCraft;
import alxnns1.mobhunter.gui.*;
import alxnns1.mobhunter.init.MHBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID >= 0 && ID < EnumGuiID.values().length)
		{
			//Item GUI
			switch(EnumGuiID.values()[ID])
			{
				case POUCH:
					return new ContainerPouch(player, world);
			}
		}
		else
		{
			//Block GUI
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

			//Server side - returns instance of the container
			if(block == MHBlocks.blockWeaponCraft)
				return new ContainerWeaponCraft(player, world);
			else if(block == MHBlocks.blockArmourCraft)
				return new ContainerArmourCraft(player, world);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		if(ID >= 0 && ID < EnumGuiID.values().length)
		{
			//Item GUI
			switch(EnumGuiID.values()[ID])
			{
				case POUCH:
					return new GuiPouch(player, world);
				case QUEST:
					return new GuiQuest(player);
				case QUEST_LIST:
					return new GuiQuestList(player);
			}
		}
		else
		{
			//Block GUI
			Block block = world.getBlockState(new BlockPos(x, y, z)).getBlock();

			//Client side - returns instance of the gui
			if(block == MHBlocks.blockWeaponCraft)
				return new GuiWeaponCraft(player, world, block.getLocalizedName());
			else if(block == MHBlocks.blockArmourCraft)
				return new GuiArmourCraft(player, world, block.getLocalizedName());
		}
		return null;
	}
}
