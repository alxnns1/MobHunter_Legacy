package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.capability.quest.MHQuestObject;
import com.alxnns1.mobhunter.handler.QuestHandler;
import com.alxnns1.mobhunter.message.MessageGuiQuest;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;

/**
 * Created by Mark on 12/01/2017.
 */
public class GuiQuest extends MHGuiScreen
{
    private MHQuestObject quest;

    public GuiQuest(EntityPlayer player)
    {
        super("quest");
        quest = QuestHandler.getQuestCapability(player).getCurrentQuest();
        xSize = 192;
        ySize = 244; //191;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        super.initGui();

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

    protected void drawExtraBg()
    {
        //Draw icon
        if(quest == null) return;
        int iconY = quest.getQuest().getQuestType().ordinal() * 32;
        drawTexturedModalRect(guiLeft + 18, guiTop + 18, 224, iconY, 32, 32);
    }

    protected void drawText()
    {
        //Draw text
        if(quest == null) return;
        wrapText(quest.getQuest().getLocalName(), 52, 10, 85);
        wrapText(quest.getQuest().getLocalDesc(), 17, 45, 160);
        wrapText("Objective Progress: \n " + quest.getQuestGuiObjProgress(), 22, 110, 155);
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

    private class QuestButton extends MHButton
    {
        public QuestButton(int x, int y, String buttonText)
        {
            super(x, y,51, 24, 0, 208, buttonText);
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
