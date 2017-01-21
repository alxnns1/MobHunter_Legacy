package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.container.MHContainer;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 02/12/2016.
 */
public class MHGuiContainer extends GuiContainer
{
    private static ResourceLocation guiImage;
    private IInventory inventory;
    protected int textColour = 4210752;
    protected int textPlayerInvY = 82;

    public MHGuiContainer(MHContainer container, String guiImageName)
    {
        super(container);
        guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + guiImageName + ".png");
        inventory = container.inventory;
        xSize = 176;
        ySize = 168;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        //Draw gui
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(guiImage);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        drawText();

        mouseX -= guiLeft;
        mouseY -= guiTop;
        List<String> tooltip = new ArrayList<String>();
        drawTooltips(tooltip, mouseX, mouseY);
        if(!tooltip.isEmpty())
            drawHoveringText(tooltip, mouseX, mouseY);
    }

    protected void drawText()
    {
        fontRendererObj.drawString(inventory.getDisplayName().getFormattedText(), 8, 6, textColour);
        fontRendererObj.drawString(I18n.format("container.inventory"), 8, textPlayerInvY, textColour);
    }

    protected void drawTooltips(List<String> tooltip, int mouseX, int mouseY) {}
}
