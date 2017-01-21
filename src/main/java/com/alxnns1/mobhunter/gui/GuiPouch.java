package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.container.ContainerPouch;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Mark on 02/12/2016.
 */
public class GuiPouch extends MHGuiContainer
{
    public GuiPouch(EntityPlayer player, World world)
    {
        super(new ContainerPouch(player, world), "pouch");
        textPlayerInvY = 74;
    }
}
