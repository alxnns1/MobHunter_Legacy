package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.block.upgrading.ContainerWeaponUpgrade;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiWeaponUpgrade extends GuiContainer
{
    //TODO: Use GuiEnchantment as a gui to make something similar.

    //TODO: Make a texture for the gui.
    private static final ResourceLocation guiImage = new ResourceLocation(Reference.GUI_TEXTURE_DIR + "guiWeaponUpgrade.png");
    private static final ResourceLocation vanillaTempGuiImage = new ResourceLocation("textures/gui/container/enchanting_table.png");

    public GuiWeaponUpgrade(InventoryPlayer invPlayer, World world, int x, int y, int z)
    {
        super(new ContainerWeaponUpgrade(invPlayer, world, x, y, z));
        //TODO: Set the size of the texture.
        //this.xSize = ;
        //this.ySize = ;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        //Draw gui
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(vanillaTempGuiImage);
        int x = (this.width - this.xSize) / 2;
        int y = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(x, y, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_)
    {
        //TODO: Adjust text position according to texture.
        //Draw text
        this.fontRendererObj.drawString(StatCollector.translateToLocal(MHBlocks.blockWeaponUpgrade.getUnlocalizedName() + ".name"), 12, 5, 4210752);
        this.fontRendererObj.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 98, 4210752);
    }
}
