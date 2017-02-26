package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.capability.quest.EnumQuestType;
import com.alxnns1.mobhunter.capability.quest.IQuest;
import com.alxnns1.mobhunter.capability.quest.MHQuestObject;
import com.alxnns1.mobhunter.handler.QuestHandler;
import com.alxnns1.mobhunter.message.MessageGuiQuest;
import com.alxnns1.mobhunter.util.CommonUtil;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.client.gui.GuiButton;
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
        updateQuest(player);
        xSize = 192;
        ySize = 244; //191;
    }

    /**
     * Updates the currently shown quest
     */
    public void updateQuest(EntityPlayer player)
    {
        IQuest questCap = QuestHandler.getQuestCapability(player == null ? mc.player : player);
        quest = questCap == null ? null : questCap.getCurrentQuest();
    }

    private boolean isItemSubmitQuest()
    {
        return quest != null && quest.getQuest().getQuestType() != EnumQuestType.HUNTING;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
     * window resizes, the buttonList is cleared beforehand.
     */
    public void initGui()
    {
        super.initGui();

        if(isItemSubmitQuest())
        {
            addButton(new QuestButton(17, 150, "Close"));
            addButton(new QuestButton(58, 150, "Share"));
            addButton(new QuestButton(99, 150, "Submit"));
            addButton(new QuestButton(140, 150, "Cancel"));
        }
        else
        {
            addButton(new QuestButton(18, 150, "Close"));
            addButton(new QuestButton(72, 150, "Share"));
            addButton(new QuestButton(126, 150, "Cancel"));
        }

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
            case 0: //Close button
                mc.player.closeScreen();
                break;
            default:
                //Process button click on server
                int buttonId = !isItemSubmitQuest() && button.id > 1 ? button.id + 1 : button.id;
                LogHelper.info("Button ID: " + button.id + "   Changed to: " + buttonId);
                CommonUtil.NETWORK.sendToServer(new MessageGuiQuest(buttonId, mc.player.getUniqueID()));
        }
    }

    private class QuestButton extends MHButton
    {
        public QuestButton(int x, int y, String buttonText)
        {
            super(x, y, GuiQuest.this.isItemSubmitQuest() ? 38 : 51, 24, GuiQuest.this.isItemSubmitQuest() ? 51 : 0, 208, buttonText);
        }
        /*
        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if(!visible) return;
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(guiImage);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
            //Draw button
            drawTexturedModalRect(xPosition, yPosition, iconX, enabled ? iconY : iconY + height, width, height);
            //Draw text
            if(!displayString.equals(""))
                drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, 0);
        }
        */
    }
}
