package com.alxnns1.mobhunter.quest;

import com.alxnns1.mobhunter.message.MessageGuiQuest;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.CommonUtil;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

/**
 * Created by Mark on 12/01/2017.
 */
public class GuiQuest extends GuiScreen
{
    private static final ResourceLocation guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "quest.png");
    protected final int xSize = 192;
    protected final int ySize = 244; //191;
    protected int guiLeft, guiTop;
    private MHQuestObject quest;

    public GuiQuest(EntityPlayer player)
    {
        this.quest = QuestHandler.getQuestCapability(player).getCurrentQuest();
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        guiLeft = (width - xSize) / 2;
        guiTop = (height - ySize) / 2;

        addButton(new QuestButton(18, 150, "Close"));
        addButton(new QuestButton(72, 150, "Share"));
        addButton(new QuestButton(126, 150, "Cancel"));

        //TODO: Remove debug buttons
        //Debug Buttons
        addButton(new QuestButton(18, 194, "Craft"));
        addButton(new QuestButton(72, 194, "Gather"));
        addButton(new QuestButton(126, 194, "Hunt"));
        addButton(new QuestButton(72, 220, "Clear Q"));
    }

    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        //Draw GUI background
        mc.getTextureManager().bindTexture(guiImage);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, 192);

        super.drawScreen(mouseX, mouseY, partialTicks);

        if(quest == null) return;

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(guiImage);
        //Draw icon
        int iconY = quest.getQuest().getQuestType().ordinal() * 32;
        drawTexturedModalRect(guiLeft + 18, guiTop + 18, 224, iconY, 32, 32);

        //Draw text
        wrapText(quest.getQuest().getLocalName(), 52, 10, 85);
        wrapText(quest.getQuest().getLocalDesc(), 17, 45, 160);
        wrapText("Objective Progress: \n " + quest.getQuestGuiObjProgress(), 22, 110, 155);
    }

    /**
     * Draws text which wraps by word to the next lines below if there's not enough space between xLeft and xRight
     */
    private void wrapText(String text, int x, int y, int width)
    {
        x += guiLeft;
        y += guiTop;
        String[] textArray = text.split(" ");
        String line = null;
        int lineNum = 1;
        int lineHeight = fontRendererObj.FONT_HEIGHT;
        for(String s : textArray)
        {
            //Add text to line
            if(s.equals("\n"))
            {
                fontRendererObj.drawString(line == null ? "" : line, x, y + (lineNum++ * lineHeight), 0);
                line = null;
                continue;
            }
            if(line == null)
                line = s;
            else
            {
                if(fontRendererObj.getStringWidth(line + s) <= width)
                    line += " " + s;
                else
                {
                    //Draw string then go to next line
                    fontRendererObj.drawString(line, x, y + (lineNum++ * lineHeight), 0);
                    line = s;
                }
            }
        }
        if(line != null)
            fontRendererObj.drawString(line, x, y + (lineNum * lineHeight), 0);
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch(button.id)
        {
            case 1:
            case 2:
                CommonUtil.NETWORK.sendToServer(new MessageGuiQuest(button.id, mc.player.getUniqueID()));
            case 0: //Close button
                mc.player.closeScreen();
                break;
            //Debug buttons
            default:
                //Process button click on server
                CommonUtil.NETWORK.sendToServer(new MessageGuiQuest(button.id, mc.player.getUniqueID()));
        }
    }

    private class QuestButton extends GuiButton
    {
        public QuestButton(int x, int y, String buttonText)
        {
            super(buttonList.size(), guiLeft + x, guiTop + y, 51, 24, buttonText);
        }

        //Overriding this to remove the shadow
        @Override
        public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int color)
        {
            fontRendererIn.drawString(text, (float)(x - fontRendererIn.getStringWidth(text) / 2), (float)y, color, false);
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if(!visible) return;
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(guiImage);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
            //Draw button
            drawTexturedModalRect(xPosition, yPosition, enabled ? 0 : 51, 232, width, height);
            //Draw text
            if(!displayString.equals(""))
                drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0);
        }
    }
}
