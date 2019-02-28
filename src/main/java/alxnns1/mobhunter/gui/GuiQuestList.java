package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.capability.quest.EnumQuestStatus;
import alxnns1.mobhunter.capability.quest.IQuest;
import alxnns1.mobhunter.capability.quest.MHQuest;
import alxnns1.mobhunter.capability.quest.MHQuestCooldown;
import alxnns1.mobhunter.init.MHCapabilities;
import alxnns1.mobhunter.init.MHQuests;
import alxnns1.mobhunter.message.MessageSetQuest;
import alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GuiQuestList extends MHGuiScreen
{
	private static final List<Integer> hunterRankList;
	private static int numButtons = 7;
	private static final String LANG = "gui.questlist.";

	private List<MHQuest> questList = new ArrayList<>();
	private int listStart = 0;
	//This is to know which HR has been clicked on. -1 when displaying the HR list.
	private int currentHR = -1;
	private MHQuest selectedQuest;
	private IQuest questCapability;
	//I only have 2 pages of info, so true is page 1, and false is page 2
	private boolean questPage = true;

	private PageButton pageButton;

	static
	{
		//Creates the hunterRankList array
		hunterRankList = new ArrayList<>();
		List<List<MHQuest>> questsByRank = MHQuests.getQuestsByRank();
		for(int i = 0; i < questsByRank.size(); i++)
			if(!questsByRank.get(i).isEmpty())
				hunterRankList.add(i);
	}

	public GuiQuestList(EntityPlayer player)
	{
		super("questlist");
		questCapability = player.getCapability(MHCapabilities.QUESTS, null);
		xSize = 256;
		ySize = 204;
	}

	@Override
	public void initGui()
	{
		super.initGui();

		//List buttons
		for(int i = 0; i < numButtons; i++)
			addButton(new ListButton(23, 14 + (i * 14)));

		//Arrow buttons
		addButton(new ArrowButton(7, 39, true));
		addButton(new ArrowButton(7, 70, false));

		//Set arrow buttons enabled
		((ArrowButton) buttonList.get(numButtons)).enabled = listStart > 0;
		((ArrowButton) buttonList.get(numButtons + 1)).enabled = questList.size() > listStart + numButtons;

		addButton(new AcceptButton(233, 181));
		addButton(new BackButton(213, 181));
		pageButton = new PageButton(193, 181);
		addButton(pageButton);

		refreshQuests();
		refreshButtons();
	}

	/**
	 * Grabs the quests for the current HR
	 */
	private void refreshQuests()
	{
		if(currentHR >= 0)
		{
			questList.clear();
			questList = MHQuests.getQuestsForRank(currentHR);
			//MobHunter.LOGGER.info("Got " + questList.size() + " quests");
		}
	}

	/**
	 * Refreshes the buttons
	 */
	public void refreshButtons()
	{
		for(GuiButton button : buttonList)
		{
			if(button instanceof ListButton)
			{
				int actualI = listStart + button.id;
				ListButton listButton = (ListButton) button;
				if(currentHR < 0)
				{
					//Set button hunter rank
					boolean hasRank = actualI < hunterRankList.size();
					listButton.quest = null;
					listButton.hunterRank = hasRank ? hunterRankList.get(actualI) : -1;
					listButton.enabled = hasRank;
				}
				else
				{
					//Set button quest
					boolean hasQuest = actualI < questList.size();
					listButton.quest = hasQuest ? questList.get(actualI) : null;
					listButton.hunterRank = -1;
					listButton.enabled = hasQuest;
				}
			}
			else if(button instanceof ArrowButton)
			{
				ArrowButton arrowButton = (ArrowButton) button;
				if(arrowButton.isUpArrow())
					arrowButton.enabled = listStart > 0;
				else
					arrowButton.enabled = currentHR >= 0 ? questList.size() > listStart + numButtons : hunterRankList.size() > listStart + numButtons;
			}
			else if(button instanceof AcceptButton)
				((AcceptButton) button).enabled = selectedQuest != null && (questCapability.canAcceptQuest(selectedQuest) || questCapability.isQuestAccepted(selectedQuest));
			else if(button instanceof BackButton)
				((BackButton) button).enabled = currentHR >= 0;
			else if(button instanceof PageButton)
			{
				((PageButton) button).enabled = selectedQuest != null;
				((PageButton) button).visible = selectedQuest != null;
			}
		}
	}

	@Override
	protected void drawExtraBg()
	{
		//Render the extra button space
		if(selectedQuest == null)
			return;

		drawTexturedModalRect(188 + guiLeft, 176 + guiTop, 208, 176, 25, 21);
	}

	@Override
	protected void drawText()
	{
		//Show the selected quest in the quest viewing box
		if(selectedQuest == null)
			return;

		//Top left corner of box
		int x = 10 + guiLeft;
		int y = 124 + guiTop;
		int xMid = guiLeft + xSize / 2;
		int width = 236;
		int white = 0xFFFFFF;
		int grey = 0xD3D3D3;
		int textHeight = fontRenderer.FONT_HEIGHT;

		//Name
		drawCenteredStringWithShadow(selectedQuest.getLocalName(), xMid, y, questCapability.getQuestStatus(selectedQuest).getColour());

		if(questPage)
		{
			//Description
			int descLines = wrapText(selectedQuest.getLocalDesc(), x, y + textHeight, width, grey, true);

			//Objectives
			String objText;
			switch(selectedQuest.getQuestType())
			{
				case GATHERING:
					objText = I18n.format(LANG + "obj.gather");
					break;
				case CRAFTING:
					objText = I18n.format(LANG + "obj.craft");
					break;
				case HUNTING:
					objText = I18n.format(LANG + "obj.hunt");
					break;
				default:
					objText = I18n.format(LANG + "obj");
			}
			drawStringWithShadow(objText + ":", x, y + textHeight * (descLines + 2), grey);
			wrapText(CommonUtil.replaceCommasWithNewlines(selectedQuest.getObjectiveText(), true), x, y + textHeight * (descLines + 3), width, grey, true);

			//Time Limit
			drawStringWithShadow(I18n.format(LANG + "time", selectedQuest.getTimeLimit()), x, y + textHeight * 7, white);

			//Repeat Cooldown
			if(selectedQuest.isRepeatable())
			{
				MHQuestCooldown cooldownQuest = questCapability.getQuestCooldown(selectedQuest);
				String text = I18n.format(LANG + "cooldown", cooldownQuest == null ? selectedQuest.getRepeatCooldownInMins() : cooldownQuest.getMinsLeft(mc.world.getTotalWorldTime()));
				int textColour = cooldownQuest == null ? white : EnumQuestStatus.COOLDOWN.getColour();
				int textWidth = fontRenderer.getStringWidth(text);
				int cooldownX = 185 + guiLeft - textWidth;
				drawStringWithShadow(text, cooldownX, y + textHeight * 7, textColour);
			}
		}
		else
		{
			//Rewards
			drawStringWithShadow(I18n.format(LANG + "rewards") + ":", x, y + textHeight, grey);
			wrapText(selectedQuest.getPointsRewardText() + " \n " + CommonUtil.replaceCommasWithNewlines(selectedQuest.getRewardText(), true),
					x, y + textHeight * 2, width, grey, true);
			//Penalty
			drawStringWithShadow(I18n.format(LANG + "penalty") + ":", xMid + 20, y + textHeight * 2, grey);
			drawStringWithShadow(selectedQuest.getPointsPenaltyText(), xMid + 20, y + textHeight * 3, grey);
		}
	}

	@Override
	protected void drawTooltips(List<String> tooltip, int mouseX, int mouseY)
	{
		for(GuiButton button : buttonList)
			if(button instanceof MHButton && button.isMouseOver())
			{
				String text = ((MHButton) button).getTooltipText();
				if(text != null && !text.equals(""))
					tooltip.add(((MHButton) button).getTooltipText());
				break;
			}
	}

	@Override
	protected void actionPerformed(GuiButton button) throws IOException
	{
		if(button instanceof ListButton)
		{
			boolean isQuestList = currentHR >= 0;
			if(isQuestList)
				selectedQuest = ((ListButton) button).quest;
			else
			{
				listStart = 0;
				currentHR = ((ListButton) button).hunterRank;
				questPage = true;
				refreshQuests();
			}
			pageButton.enabled = selectedQuest != null;
			pageButton.visible = selectedQuest != null;
			refreshButtons();
		}
		else if(button instanceof ArrowButton)
		{
			//Scroll list
			if(((ArrowButton) button).isUpArrow())
				listStart--;
			else
				listStart++;

			refreshButtons();
		}
		else if(button instanceof AcceptButton)
		{
			//Accept or cancel quest
			CommonUtil.NETWORK.sendToServer(new MessageSetQuest(questCapability.isQuestAccepted(selectedQuest) ? null : selectedQuest, mc.player.getUniqueID()));
		}
		else if(button instanceof BackButton)
		{
			//Back button
			listStart = 0;
			selectedQuest = null;
			currentHR = -1;
			refreshButtons();
		}
		else if(button instanceof PageButton)
		{
			//Change page
			questPage = !questPage;
			pageButton.enabled = selectedQuest != null;
			pageButton.visible = selectedQuest != null;
		}
	}

	private class ListButton extends MHButton
	{
		public int hunterRank = -1;
		public MHQuest quest;

		public ListButton(int x, int y)
		{
			super(x, y, 225, 14, 0, 204, "");
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
		{
			super.drawButton(mc, mouseX, mouseY, partialTicks);

			String text = hunterRank >= 0 ? "HR: " + hunterRank : "";

			//Draw icon
			if(quest != null)
			{
				text = quest.getLocalName();
				EnumQuestStatus questStatus = questCapability.getQuestStatus(quest);
				if(questStatus != EnumQuestStatus.UNCOMPLETED)
				{
					int iconX = questCapability.getQuestStatus(quest).ordinal() * 12;
					drawTexturedModalRect(x + 2, y + 1, iconX, 244, 12, 12);
				}
			}

			//Draw text
			drawString(fontRenderer, text, x + 17, y + (height / 2) - 4, 0xFFFFFF); //xPosition + (width / 2)
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

		@Override
		public String getTooltipText()
		{
			return I18n.format(LANG + (isUp ? "up" : "down"));
		}
	}

	private class AcceptButton extends MHButton
	{
		public AcceptButton(int x, int y)
		{
			super(x, y, 16, 16, 208, 240, "");
			enabled = false;
			iconMoveHorizontal = true;
		}

		private int getIconIndex()
		{
			if(enabled && questCapability.canAcceptQuest(selectedQuest))
				return 0;
			else if(questCapability.isQuestAccepted(selectedQuest))
				return 2;
			else
				return 1;
		}

		@Override
		public String getTooltipText()
		{
			String text = null;
			if(selectedQuest == null)
				return null;
			else if(enabled && questCapability.canAcceptQuest(selectedQuest))
				text = "accept";
			else if(questCapability.isQuestAccepted(selectedQuest))
				text = "cancel";
			else if(questCapability.isQuestCompleted(selectedQuest))
				text = "completed";
			else if(questCapability.getCurrentQuest() != null)
				text = "alreadyhavequest";
			else if(questCapability.isQuestCoolingDown(selectedQuest))
				text = "oncooldown";
			if(text != null)
				return I18n.format(LANG + text);
			return null;
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
		{
			if(!visible) return;
			mc.getTextureManager().bindTexture(guiImage);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
			//Draw button
			int i = getIconIndex();
			int ix = iconX + i * 16;
			drawTexturedModalRect(x, y, ix, iconY, width, height);
		}
	}

	private class BackButton extends MHButton
	{
		public BackButton(int x, int y)
		{
			super(x, y, 16, 16, 176, 240, "");
			enabled = false;
			iconMoveHorizontal = true;
		}

		@Override
		public String getTooltipText()
		{
			return enabled ? I18n.format(LANG + "back") : null;
		}
	}

	private class PageButton extends MHButton
	{
		public PageButton(int x, int y)
		{
			super(x, y, 16, 16, 144, 240, "");
			enabled = false;
			visible = false;
			iconMoveHorizontal = true;
		}

		@Override
		public String getTooltipText()
		{
			return I18n.format(LANG + "infopage");
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
		{
			if(!visible) return;
			mc.getTextureManager().bindTexture(guiImage);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
			//Draw button
			int ix = iconMoveHorizontal ? questPage ? iconX : iconX + width : iconX;
			int iy = iconMoveHorizontal ? iconY : questPage ? iconY : iconY + height;
			drawTexturedModalRect(x, y, ix, iy, width, height);
		}
	}
}
