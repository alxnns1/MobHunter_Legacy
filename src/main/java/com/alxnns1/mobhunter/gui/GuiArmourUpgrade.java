package com.alxnns1.mobhunter.gui;

import com.alxnns1.mobhunter.container.ContainerWeaponTable;
import com.alxnns1.mobhunter.crafting.WeaponCraftingRecipe;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.item.ItemMHArmour;
import com.alxnns1.mobhunter.item.ItemMHSword;
import com.alxnns1.mobhunter.reference.Reference;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
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
public class GuiArmourUpgrade extends GuiContainer
{
    private static final ResourceLocation guiImage = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "guiCraft.png");
    private static final String TOOLTIP = "gui.blockArmourUpgrade.";

    private ContainerWeaponTable container;

    public GuiArmourUpgrade(InventoryPlayer invPlayer, World world)
    {
        super(new ContainerWeaponTable(invPlayer, world));
        container = (ContainerWeaponTable) inventorySlots;
        this.xSize = 256;
        this.ySize = 203;
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

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        for(int i = 0; i < 5; i++)
        {
            //Update buttons with recipes
            UpgradeButton button = (UpgradeButton) buttonList.get(i);
            if(i < container.recipes.size() && container.recipes.get(i) != null)
            {
                WeaponCraftingRecipe recipe = container.recipes.get(i);
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
        this.fontRendererObj.drawString(new TextComponentTranslation(MHBlocks.blockArmourCraft.getUnlocalizedName() + ".name").getUnformattedText(), 8, 4, 4210752);
        this.fontRendererObj.drawString(new TextComponentTranslation("container.inventory").getUnformattedText(), 8, this.ySize - 92, 4210752);

        //Draw button tooltip
        if(container.recipes == null || container.recipes.isEmpty()) return;
        for(int i = 0; i < 5; i++)
        {
            if(container.recipes.size() < i + 1)
                break;
            Button b = (Button) buttonList.get(i);
            if(b.isMouseOver())
            {
                //Get the recipe for the button
                WeaponCraftingRecipe r = container.recipes.get(i);
                if(r == null) continue;
                List<String> list = new ArrayList<String>();
                String line1;
                if(r.getKeyInput() != null && r.getKeyInput().getItem() instanceof ItemMHArmour)
                    line1 = I18n.format(TOOLTIP + "button.craft.1.1") + " ";
                else
                    line1 = I18n.format(TOOLTIP + "button.craft.1.2") + " ";
                list.add(line1 + TextFormatting.AQUA + r.getRecipeOutput().getDisplayName());
                list.add(I18n.format(TOOLTIP + "button.craft.2"));
                //Get the materials which are not present in player inventory
                ArrayList<Object> remainingItems = container.checkPlayerInv(container.inventoryPlayer, r.getInput());
                //Add the materials to the tooltip, coloured yellow if player has enough and red if not
                for(Object o : r.getInput())
                {
                    TextFormatting colour = TextFormatting.YELLOW;
                    if(o instanceof ItemStack)
                    {
                        ItemStack stackO = (ItemStack) o;
                        //Check if enough of the item exists in the inventory (If not, then item in tooltip is coloured red)
                        for(Object remainingO : remainingItems)
                        {
                            if(     (remainingO instanceof ItemStack && stackO.isItemEqual((ItemStack) remainingO)) ||
                                    (remainingO instanceof List && OreDictionary.containsMatch(false, (List<ItemStack>) remainingO, stackO)))
                            {
                                colour = TextFormatting.RED;
                                break;
                            }
                        }
                        list.add(((ItemStack) o).stackSize + " x " + colour + ((ItemStack) o).getDisplayName());
                    }
                    else if(o instanceof List)
                    {
                        //This basically gets the first ore dictionary string for the item.
                        list.add(I18n.format(TOOLTIP + "button.craft.ore") + colour + OreDictionary.getOreName(OreDictionary.getOreIDs(((List<ItemStack>) o).get(0))[0]));
                    }
                }
                b.setTooltip(list);
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
                GuiArmourUpgrade.this.drawHoveringText(tooltipLines, mouseX, mouseY);
        }
    }
}
