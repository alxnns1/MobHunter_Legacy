package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.capability.quest.EnumQuestType;
import com.alxnns1.mobhunter.capability.quest.IQuest;
import com.alxnns1.mobhunter.capability.quest.MHQuestObject;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.message.MessageGuiQuest;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;

public class GuiQuest extends MHGuiScreen
{
    private static final String LANG = "gui.quest.";
    private MHQuestObject quest;

    public GuiQuest(EntityPlayer player)
    {
        super("quest");
        updateQuest(player);
        xSize = 192;
        ySize = 191;
    }

    /**
     * Updates the currently shown quest
     */
    public void updateQuest(EntityPlayer player)
    {
        EntityPlayer p = player == null ? mc.player : player;
        IQuest questCap = p.getCapability(MHCapabilities.QUESTS, null);
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
            addButton(new QuestButton(17, 150, I18n.format(LANG + "button.close")));
            addButton(new QuestButton(58, 150, I18n.format(LANG + "button.share")));
            addButton(new QuestButton(99, 150, I18n.format(LANG + "button.submit")));
            addButton(new QuestButton(140, 150, I18n.format(LANG + "button.cancel")));
        }
        else
        {
            addButton(new QuestButton(18, 150, I18n.format(LANG + "button.close")));
            addButton(new QuestButton(72, 150, I18n.format(LANG + "button.share")));
            addButton(new QuestButton(126, 150, I18n.format(LANG + "button.cancel")));
        }
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
        wrapText(quest.getQuest().getLocalName(), 52 + guiLeft, 19 + guiTop, 85, 0, false);
        wrapText(quest.getQuest().getLocalDesc(), 17 + guiLeft, 54 + guiTop, 160, 0, false);
        wrapText(I18n.format(LANG + "objProgress") + ": \n " + quest.getQuestGuiObjProgress(), 22 + guiLeft, 119 + guiTop, 155, 0, false);
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
                //LogHelper.info("Button ID: " + button.id + "   Changed to: " + buttonId);
                CommonUtil.NETWORK.sendToServer(new MessageGuiQuest(buttonId, mc.player.getUniqueID()));
        }
    }

    private class QuestButton extends MHButton
    {
        public QuestButton(int x, int y, String buttonText)
        {
            super(x, y, GuiQuest.this.isItemSubmitQuest() ? 38 : 51, 24, GuiQuest.this.isItemSubmitQuest() ? 51 : 0, 208, buttonText);
        }

        @Override
        protected int getTextColour()
        {
            return 0;
        }
    }
}
