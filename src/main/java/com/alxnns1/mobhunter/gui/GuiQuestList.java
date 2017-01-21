package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.capability.quest.IQuest;
import com.alxnns1.mobhunter.capability.quest.MHQuest;
import com.alxnns1.mobhunter.handler.QuestHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;

/**
 * Created by Mark on 20/01/2017.
 */
public class GuiQuestList extends MHGuiScreen
{
    private static int numButtons = 7;
    private IQuest questCapability;

    public GuiQuestList(EntityPlayer player)
    {
        super("questList");
        questCapability = QuestHandler.getQuestCapability(player);
        xSize = 256;
        ySize = 204;
    }

    public void initGui()
    {
        super.initGui();

        //List buttons
        for(int i = 0; i < numButtons; i++)
            addButton(new ListButton(23, 14 + (i * 14)));

        //Arrow buttons
        addButton(new ArrowButton(7, 39, true));
        addButton(new ArrowButton(7, 70, false));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        //TODO: Do stuff when buttons clicked
        if(button instanceof ListButton)
        {

        }
        else if(button instanceof ArrowButton)
        {

        }
    }

    private class ListButton extends MHButton
    {
        public MHQuest quest;

        public ListButton(int x, int y)
        {
            super(x, y, 225, 14, 0, 204, "");
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            super.drawButton(mc, mouseX, mouseY);

            //Draw icon
            if(quest == null) return;
            int iconX = questCapability.getQuestStatus(quest).ordinal() * 12;
            if(!questCapability.isQuestCoolingDown(quest)) return;
            drawTexturedModalRect(xPosition + 1, yPosition + 1, iconX, 244, 12, 12);
        }
    }

    private class ArrowButton extends MHButton
    {
        public ArrowButton(int x, int y, boolean isUpArrow)
        {
            super(x, y, 11, 17, isUpArrow ? 234 : 245, 204, "");
        }
    }
}
