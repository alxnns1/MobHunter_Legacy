package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.capability.quest.IQuest;
import com.alxnns1.mobhunter.capability.quest.MHQuest;
import com.alxnns1.mobhunter.handler.QuestHandler;
import com.alxnns1.mobhunter.init.MHQuests;
import com.alxnns1.mobhunter.message.MessageSetQuest;
import com.alxnns1.mobhunter.util.CommonUtil;
import com.google.common.collect.Lists;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 20/01/2017.
 */
public class GuiQuestList extends MHGuiScreen
{
    private static final List<String> hunterRankList;
    private static int numButtons = 7;

    private List<MHQuest> questList = new ArrayList<MHQuest>();
    private int listStart = 0;
    private MHQuest selectedQuest;
    private IQuest questCapability;

    static
    {
        //Creates the hunterRankList array
        hunterRankList = new ArrayList<String>();
        List<List<MHQuest>> questsByRank = MHQuests.getQuestsByRank();
        for(int i = 0; i < questsByRank.size(); i++)
            if(!questsByRank.get(i).isEmpty())
                hunterRankList.add("HR: " + i);
    }

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

        //Accept button
        addButton(new AcceptButton(233, 181));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button instanceof ListButton)
        {
            //Show quest
            selectedQuest = ((ListButton) button).quest;
        }
        else if(button instanceof ArrowButton)
        {
            //Scroll list
            if(((ArrowButton) button).isUpArrow())
                listStart++;
            else
                listStart--;

            //Set arrow buttons enabled
            ((ArrowButton) buttonList.get(numButtons + 1)).enabled = listStart > 0;
            ((ArrowButton) buttonList.get(numButtons + 2)).enabled = questList.size() > listStart + numButtons;

            //Set quests to buttons
            for(int i = 0; i < numButtons; i++)
            {
                int actualI = listStart + i;
                ListButton listButton = (ListButton) buttonList.get(i);
                if(questList.size() < actualI + 1)
                    listButton.quest = null;
                else
                    listButton.quest = questList.get(actualI);
            }
        }
        else if(button instanceof AcceptButton)
        {
            //Accept quest
            CommonUtil.NETWORK.sendToServer(new MessageSetQuest(selectedQuest, mc.player.getUniqueID()));
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

            //Draw text
            drawCenteredString(fontRendererObj, quest.getLocalName(), xPosition + (width / 2), yPosition + (height / 2));
        }
    }

    private class ArrowButton extends MHButton
    {
        private boolean isUp;

        public ArrowButton(int x, int y, boolean isUpArrow)
        {
            super(x, y, 11, 17, isUpArrow ? 234 : 245, 204, "");
            isUp = isUpArrow;
        }

        public boolean isUpArrow()
        {
            return isUp;
        }
    }

    private class AcceptButton extends MHButton
    {
        public AcceptButton(int x, int y)
        {
            super(x, y, 16, 16, 224, 240, "");
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if(!visible) return;
            mc.getTextureManager().bindTexture(guiImage);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
            //Draw button
            drawTexturedModalRect(xPosition, yPosition, enabled ? iconX : iconX + width, iconY, width, height);
        }

        public void drawButtonForegroundLayer(int mouseX, int mouseY)
        {
            //Draw tooltip
            drawHoveringText(Lists.newArrayList("Accept Quest"), mouseX, mouseY);
        }
    }
}
