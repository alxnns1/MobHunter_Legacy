package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.MobHunter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 20/01/2017.
 */
public class MHGuiScreen extends GuiScreen
{
	protected static ResourceLocation guiImage;
	protected int xSize = 176;
	protected int ySize = 168;
	protected int guiLeft, guiTop;

	public MHGuiScreen(String guiImageName)
	{
		guiImage = new ResourceLocation(MobHunter.MOD_ID, MobHunter.GUI_TEXTURE_DIR + guiImageName + ".png");
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question. Called when the GUI is displayed and when the
	 * window resizes, the buttonList is cleared beforehand.
	 */
	@Override
	public void initGui()
	{
		guiLeft = (width - xSize) / 2;
		guiTop = (height - ySize) / 2;
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
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		drawExtraBg();

		super.drawScreen(mouseX, mouseY, partialTicks);

		drawText();

		List<String> tooltip = new ArrayList<String>();
		drawTooltips(tooltip, mouseX, mouseY);
		if(!tooltip.isEmpty())
			drawHoveringText(tooltip, mouseX, mouseY);
	}

	protected void drawExtraBg(){}

	protected void drawText(){}

	protected void drawTooltips(List<String> tooltip, int mouseX, int mouseY){}

	/**
	 * Draws text which wraps by word to the next lines below if there's not enough space between xLeft and xRight
	 * Returns how many lines the text took up
	 */
	protected int wrapText(String text, int x, int y, int width, int colour, boolean drawShadow)
	{
		String[] textArray = text.split(" ");
		String line = null;
		int lineNum = 0;
		int lineHeight = fontRenderer.FONT_HEIGHT;
		for(String s : textArray)
		{
			//Add text to line
			if(s.equals("\n"))
			{
				drawString(line == null ? "" : line, x, y + (lineNum++ * lineHeight), colour, drawShadow);
				line = null;
				continue;
			}
			if(line == null)
				line = s;
			else
			{
				if(fontRenderer.getStringWidth(line + s) <= width)
					line += " " + s;
				else
				{
					//Draw string then go to next line
					drawString(line, x, y + (lineNum++ * lineHeight), colour, drawShadow);
					line = s;
				}
			}
		}
		if(line != null)
			drawString(line, x, y + (lineNum * lineHeight), colour, drawShadow);
		return lineNum + 1;
	}

	public void drawString(String text, int x, int y, int color, boolean drawShadow)
	{
		fontRenderer.drawString(text, (float) x, (float) y, color, drawShadow);
	}

	public void drawString(String text, int x, int y, int color)
	{
		drawString(text, x, y, color, false);
	}

	public void drawStringWithShadow(String text, int x, int y, int color)
	{
		drawString(text, x, y, color, true);
	}

	public void drawCenteredString(String text, int x, int y, int color, boolean drawShadow)
	{
		fontRenderer.drawString(text, (float) (x - fontRenderer.getStringWidth(text) / 2), (float) y, color, drawShadow);
	}

	public void drawCenteredString(String text, int x, int y, int color)
	{
		drawCenteredString(text, x, y, color, false);
	}

	public void drawCenteredStringWithShadow(String text, int x, int y, int color)
	{
		drawCenteredString(text, x, y, color, true);
	}

	protected class MHButton extends GuiButton
	{
		protected final int iconX, iconY;
		protected boolean iconMoveHorizontal = false;

		public MHButton(int x, int y, int width, int height, int iconXIn, int iconYIn, String buttonText)
		{
			super(buttonList.size(), guiLeft + x, guiTop + y, width, height, buttonText);
			iconX = iconXIn;
			iconY = iconYIn;
		}

		protected int getTextColour()
		{
			return enabled ? 14737632 : 10526880;
		}

		public String getTooltipText()
		{
			return null;
		}

		//Overriding this to remove the shadow
		public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y)
		{
			drawCenteredString(fontRendererIn, text, x, y, getTextColour());
		}

		@Override
		public void drawCenteredString(FontRenderer fontRendererIn, String text, int x, int y, int colour)
		{
			fontRendererIn.drawString(text, (float) (x - fontRendererIn.getStringWidth(text) / 2), (float) y, colour, false);
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
		{
			if(!visible) return;
			FontRenderer fontrenderer = mc.fontRenderer;
			mc.getTextureManager().bindTexture(guiImage);
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			this.hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
			//Draw button
			int ix = iconMoveHorizontal ? enabled ? iconX : iconX + width : iconX;
			int iy = iconMoveHorizontal ? iconY : enabled ? iconY : iconY + height;
			drawTexturedModalRect(x, y, ix, iy, width, height);
			if(!displayString.equals(""))
				drawCenteredString(fontrenderer, displayString, x + width / 2, y + (height - 8) / 2);
			//drawCenteredString(fontrenderer, displayString, (x + 16) + (width - 16) / 2, y + (height - 8) / 2);
		}
	}
}
