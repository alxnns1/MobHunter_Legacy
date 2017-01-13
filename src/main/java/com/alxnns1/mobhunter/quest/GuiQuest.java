package com.alxnns1.mobhunter.quest;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 12/01/2017.
 */
public class GuiQuest extends GuiScreen
{
    private static final ResourceLocation guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "quest.png");
    protected final int xSize = 128;
    protected final int ySize = 128;
    private EntityPlayer player;
    private MHQuestObject quest;

    public GuiQuest(EntityPlayer player)
    {
        this.player = player;
        this.quest = QuestHandler.getQuestCapability(player).getCurrentQuest();
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        addButton(new QuestButton(12, 100, "Close"));
        addButton(new QuestButton(48, 100, "Share"));
        addButton(new QuestButton(84, 100, "Cancel"));
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
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);

        //Draw icon
        int iconX = 128 + quest.getQuest().getQuestType().ordinal() * 32;
        drawTexturedModalRect(12, 12, iconX, 16, 32, 32);

        //Draw text
        wrapText(quest.getQuest().getLocalName(), 45, 12, 48);
        fontRendererObj.drawString("HR: " + quest.getQuest().getRequiredHR(), 101, 33, 0);
        wrapText(quest.getQuest().getLocalDesc(), 15, 45, 104);
        wrapText("Rewards: " + quest.getQuest().getPointsReward() + " HR Points, " + quest.getQuest().getRewardText(),
                13, 85, 106);
    }

    /**
     * Draws text which wraps by word to the next lines below if there's not enough space between xLeft and xRight
     */
    private void wrapText(String text, int x, int y, int width)
    {
        String[] textArray = text.split(" ");
        String line = null;
        int lineNum = 0;
        for(String s : textArray)
        {
            //Add text to line
            if(line == null)
                line = s;
            else
            {
                if(fontRendererObj.getStringWidth(line + s) <= width)
                    line += " " + s;
                else
                {
                    //Draw string then go to next line
                    fontRendererObj.drawString(line, x, y * lineNum++, 0);
                    line = s;
                }
            }
        }
        if(line != null)
            fontRendererObj.drawString(line, x, y * lineNum, 0);
    }

    private class QuestButton extends GuiButton
    {
        public QuestButton(int x, int y, String buttonText)
        {
            super(buttonList.size(), x, y, 34, 16, buttonText);
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if(!visible) return;
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(guiImage);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
            //Draw button
            int iconX = !enabled ? 162 : hovered ? 128 : 0;
            if(iconX > 0)
                drawTexturedModalRect(xPosition, yPosition, iconX, 0, width, height);
            //Draw text
            if(!displayString.equals(""))
                drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0);
        }
    }
}
