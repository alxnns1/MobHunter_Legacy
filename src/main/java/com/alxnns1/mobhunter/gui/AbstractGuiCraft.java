package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.container.AbstractContainerCraft;
import com.alxnns1.mobhunter.crafting.MHCraftingRecipe;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public abstract class AbstractGuiCraft extends GuiContainer
{
    private static final ResourceLocation guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "guiCraft.png");
    protected AbstractContainerCraft container;
    protected String invName;

    public static final byte BUTTON_ID_ARROW_UP = Byte.MAX_VALUE;
    public static final byte BUTTON_ID_ARROW_DOWN = Byte.MAX_VALUE - 1;

    public AbstractGuiCraft(AbstractContainerCraft container, String invName)
    {
        super(container);
        this.container = container;
        this.invName = invName;
        xSize = 256;
        ySize = 203;
    }

    public void initGui()
    {
        super.initGui();
        //Add the buttons to the gui
        for(int i = 0; i < 5; i++)
            buttonList.add(new UpgradeButton(i, 60, 14 + (19 * i), "", null));
        buttonList.add(new ArrowButton(5, 44, 34, true));
        buttonList.add(new ArrowButton(6, 44, 72, false));
    }

    protected abstract List<String> getButtonTooltip(MHCraftingRecipe recipe);

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            //Update buttons with recipes
            int recipeActualI = container.recipeStart + i;
            UpgradeButton button = (UpgradeButton) buttonList.get(i);
            if(recipeActualI < container.recipes.size() && container.recipes.get(recipeActualI) != null)
            {
                MHCraftingRecipe recipe = container.recipes.get(recipeActualI);
                button.displayString = recipe.getRecipeOutput().getDisplayName();
                button.setItem(recipe.getRecipeOutput());
                button.enabled = container.recipesValid.get(i);
            }
            else
            {
                button.displayString = "";
                button.setItem(null);
                button.enabled = false;
            }
        }

        //Update arrow buttons
        ((ArrowButton) buttonList.get(5)).enabled = container.recipeStart > 0;
        ((ArrowButton) buttonList.get(6)).enabled = container.recipes.size() > container.recipeStart + 5;
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        //Draw gui
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(guiImage);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, this.xSize, this.ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        //Draw text
        this.fontRendererObj.drawString(invName, 8, 4, 4210752);
        this.fontRendererObj.drawString(new TextComponentTranslation("container.inventory").getUnformattedText(), 8, this.ySize - 92, 4210752);

        //Draw button tooltip
        if(container.recipes == null || container.recipes.isEmpty()) return;
        for(int i = 0; i < 5; i++)
        {
            int recipeActualI = container.recipeStart + i;
            if(container.recipes.size() < recipeActualI + 1)
                break;
            Button b = (Button) buttonList.get(i);
            if(b.isMouseOver())
            {
                //Get the recipe for the button
                MHCraftingRecipe r = container.recipes.get(recipeActualI);
                if(r == null) continue;
                b.setTooltip(getButtonTooltip(r));
                b.drawButtonForegroundLayer(mouseX - guiLeft, mouseY - guiTop);
            }
        }
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button instanceof UpgradeButton)
        {
            //Add 1 to the id so that ids start from 1 rather than 0 (because there's no -0!)
            int id = button.id + 1;
            //If shift key is held, make the id negative
            id = ClientUtil.isShiftKeyDown() ? id * -1 : id;
            container.enchantItem(this.mc.thePlayer, id);
            mc.playerController.sendEnchantPacket(container.windowId, id);
        }
        else if(button instanceof ArrowButton)
        {
            //Use the same enchant method for arrow buttons but ids Int Max for up and Int Max - 1 for down.
            int id = ((ArrowButton) button).isUpArrow() ? BUTTON_ID_ARROW_UP : BUTTON_ID_ARROW_DOWN;
            container.enchantItem(this.mc.thePlayer, id);
            mc.playerController.sendEnchantPacket(container.windowId, id);
        }
    }

    @SideOnly(Side.CLIENT)
    private class UpgradeButton extends Button
    {
        private ItemStack item;

        public UpgradeButton(int buttonId, int x, int y, String buttonText, ItemStack renderItem)
        {
            super(buttonId, x, y, 188, 19, 0, 204, buttonText);
            item = renderItem;
        }

        public void setItem(ItemStack renderItem)
        {
            item = renderItem;
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            super.drawButton(mc, mouseX, mouseY);
            //Draw item at left of button
            if(item != null)
                itemRender.renderItemAndEffectIntoGUI(item, xPosition + 1, yPosition + 1);
        }
    }

    @SideOnly(Side.CLIENT)
    private class ArrowButton extends Button
    {
        private boolean isUp;

        public ArrowButton(int buttonId, int x, int y, boolean isUpArrow)
        {
            super(buttonId, x, y, 11, 17, isUpArrow ? 188 : 199, 204, "");
            isUp = isUpArrow;
        }

        public boolean isUpArrow()
        {
            return isUp;
        }
    }

    @SideOnly(Side.CLIENT)
    private class Button extends GuiButton
    {
        private final int iconX;
        private final int iconY;
        private List<String> tooltipLines = new ArrayList<String>();

        public Button(int buttonId, int x, int y, int width, int height, int iconXIn, int iconYIn, String buttonText)
        {
            super(buttonId, guiLeft + x, guiTop + y, width, height, buttonText);
            iconX = iconXIn;
            iconY = iconYIn;
            enabled = false;
        }

        public void setTooltip(List<String> tooltip)
        {
            tooltipLines = tooltip;
        }

        public void addTooltip(String tooltip)
        {
            if(tooltip != null)
                tooltipLines.add(tooltip);
        }

        public void drawButton(Minecraft mc, int mouseX, int mouseY)
        {
            if(!visible) return;
            FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(guiImage);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
            //Select appropriate button icon for button state
            int y = iconY;
            int textColour = 14737632;
            if(!enabled)
            {
                y += height; //Changes to "off" icon
                textColour = 10526880; //Changes to darker text
            }
            //Draw icon
            drawTexturedModalRect(xPosition, yPosition, iconX, y, width, height);
            //Draw text
            if(!displayString.equals(""))
                drawCenteredString(fontrenderer, displayString, (xPosition + 16) + (width - 16) / 2, yPosition + (height - 8) / 2, textColour);
        }

        public void drawButtonForegroundLayer(int mouseX, int mouseY)
        {
            if(!tooltipLines.isEmpty())
                drawHoveringText(tooltipLines, mouseX, mouseY);
        }
    }
}
