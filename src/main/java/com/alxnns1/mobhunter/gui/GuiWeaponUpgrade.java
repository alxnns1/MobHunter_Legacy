package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.container.ContainerWeaponUpgrade;
import com.alxnns1.mobhunter.crafting.WeaponUpgradeRecipe;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.util.LogHelper;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiWeaponUpgrade extends GuiContainer
{
    private static final ResourceLocation guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "guiWeaponUpgrade.png");

    private ContainerWeaponUpgrade container;

    public GuiWeaponUpgrade(InventoryPlayer invPlayer, World world)
    {
        super(new ContainerWeaponUpgrade(invPlayer, world));
        container = (ContainerWeaponUpgrade) inventorySlots;
        this.xSize = 175;
        this.ySize = 203;
    }

    public void initGui()
    {
        super.initGui();
        //Add the buttons to the gui
        for(int i = 0; i < 5; i++)
            buttonList.add(new UpgradeButton(i, 60, 14 + (19 * i), "Button " + (i + 1), null));
        buttonList.add(new ArrowButton(5, 44, 34, true));
        buttonList.add(new ArrowButton(6, 44, 72, false));
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            UpgradeButton button = (UpgradeButton) buttonList.get(i);
            if(container.inventory.getStackInSlot(0) != null)
            {
                //Set button display string
                if(i < container.recipes.size() && container.recipes.get(i) != null)
                {
                    WeaponUpgradeRecipe recipe = container.recipes.get(i);
                    button.displayString = recipe.getRecipeOutput().getDisplayName();
                    button.setItem(recipe.getRecipeOutput());
                }
                else
                {
                    button.displayString = "";
                    button.setItem(null);
                }
                //Set if button enabled
                if(i < container.recipesValid.size() && container.recipesValid.get(i) != null)
                    button.enabled = container.recipesValid.get(i);
                else
                    button.enabled = false;
            }
            else
            {
                button.enabled = false;
                button.displayString = "";
                button.setItem(null);
            }
            //buttonList.set(i, button);
        }
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
        this.fontRendererObj.drawString(new TextComponentTranslation(MHBlocks.blockWeaponUpgrade.getUnlocalizedName() + ".name").getUnformattedText(), 8, 4, 4210752);
        this.fontRendererObj.drawString(new TextComponentTranslation("container.inventory").getUnformattedText(), 8, this.ySize - 92, 4210752);

        //Draw button tooltip
        if(container.recipes == null || container.recipes.isEmpty()) return;
        for(int i = 0; i < container.recipes.size(); i++)
        {
            Button b = (Button) buttonList.get(i);
            if(b.isMouseOver())
            {
                WeaponUpgradeRecipe r = container.recipes.get(i);
                if(r == null) continue;
                List<String> list = new ArrayList<String>();
                list.add("Upgrade Weapon To: " + TextFormatting.AQUA + r.getRecipeOutput().getDisplayName());
                list.add("Required Materials:");
                for(Object o : r.getInput())
                {
                    if(o instanceof ItemStack)
                        list.add(((ItemStack)o).stackSize + " x " + TextFormatting.YELLOW + ((ItemStack)o).getDisplayName());
                    else if(o instanceof List)
                        //This basically gets the first ore dictionary string for the item.
                        list.add("1 x Ore:" + TextFormatting.YELLOW + OreDictionary.getOreName(OreDictionary.getOreIDs(((List<ItemStack>)o).get(0))[0]));
                }
                b.setTooltip(list);
                b.drawButtonForegroundLayer(mouseX - guiLeft, mouseY - guiTop);
            }
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
        //TODO: Draw the resultant items ontop of the buttons
    }

    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button instanceof UpgradeButton)
        {
            container.enchantItem(this.mc.thePlayer, button.id);
            //if(container.enchantItem(this.mc.thePlayer, button.id))
                //button.enabled = false;
            mc.playerController.sendEnchantPacket(container.windowId, button.id);
        }
        else if(button instanceof ArrowButton) //Arrow button
        {
            PacketBuffer buf = new PacketBuffer(Unpooled.buffer());
            buf.writeBoolean(((ArrowButton)button).isUpArrow());
            mc.getConnection().sendPacket(new CPacketCustomPayload("MH|WUPage", buf));
        }
    }

    @SideOnly(Side.CLIENT)
    private class UpgradeButton extends Button
    {
        private ItemStack item;

        public UpgradeButton(int buttonId, int x, int y, String buttonText, ItemStack renderItem)
        {
            super(buttonId, x, y, 108, 19, 0, 204, buttonText);
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
            super(buttonId, x, y, 11, 17, isUpArrow ? 108 : 119, 204, "");
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
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            //Select appropriate button icon for button state
            int y = iconY;
            int textColour = 14737632;
            if(!this.enabled)
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
                GuiWeaponUpgrade.this.drawHoveringText(tooltipLines, mouseX, mouseY);
        }
    }
}
