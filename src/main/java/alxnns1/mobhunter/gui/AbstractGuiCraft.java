package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.container.AbstractContainerCraft;
import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import alxnns1.mobhunter.item.EnumSharpness;
import alxnns1.mobhunter.item.ItemMHSword;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Mouse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 23/10/2016.
 */
public abstract class AbstractGuiCraft extends GuiContainer
{
    private static final ResourceLocation guiImage = new ResourceLocation(MobHunter.MOD_ID, MobHunter.GUI_TEXTURE_DIR + "guicraft.png");
    private final String tooltip;
    private AbstractContainerCraft container;
    private String invName;

    public static final byte BUTTON_ID_ARROW_UP = Byte.MAX_VALUE;
    public static final byte BUTTON_ID_ARROW_DOWN = Byte.MAX_VALUE - 1;

    public AbstractGuiCraft(AbstractContainerCraft container, String invName, String tooltipPrefix)
    {
        super(container);
        this.container = container;
        this.invName = invName;
        tooltip = tooltipPrefix;
        xSize = 256;
        ySize = 203;
    }

    @Override
    public void initGui()
    {
        super.initGui();
        //Add the buttons to the gui
        for(int i = 0; i < 5; i++)
            buttonList.add(new UpgradeButton(i, 60, 14 + (19 * i), "", null));
        buttonList.add(new ArrowButton(5, 44, 34, true));
        buttonList.add(new ArrowButton(6, 44, 72, false));
    }

    private static String itemStackText(ItemStack stack, TextFormatting colour)
    {
        return stack.getCount() + " x " + colour + stack.getDisplayName();
    }

    private List<String> getButtonTooltip(MHCraftingRecipe recipe)
    {
        List<String> tooltipList = new ArrayList<>();
        ItemStack outputStack = recipe.getOutput();
        String line1Key = tooltip + (recipe.getKeyInput().isEmpty() ? "button.craft.1.2" : "button.craft.1.1");
        tooltipList.add(I18n.format(line1Key, TextFormatting.AQUA + outputStack.getDisplayName()));
        if(this instanceof GuiWeaponCraft)
        {
            tooltipList.add(TextFormatting.GRAY + I18n.format(tooltip + "button.craft.2.1", Float.toString(ItemMHSword.getActualAttackDamage(outputStack) + 1f)));
            EnumSharpness sharpness = ItemMHSword.getSharpness(outputStack);
            String sharpnessText = sharpness == null ? "None" : sharpness.getChatColour() + sharpness.getLocalizedName();
            tooltipList.add(TextFormatting.GRAY + I18n.format(tooltip + "button.craft.2.2", sharpnessText));
            tooltipList.add(I18n.format(tooltip + "button.craft.3"));
        }
        else if(this instanceof GuiArmourCraft)
            tooltipList.add(I18n.format(tooltip + "button.craft.2"));

        NonNullList<Ingredient> inputs = recipe.getInputs();
        //Get the inputs which are present in player inventory
        List<ItemStack> foundStacks = container.getStacksFromInv(container.inventoryPlayer, inputs);
        //Add the materials to the tooltip, coloured yellow if player has enough and red if not
        for(Ingredient inputIng : inputs)
        {
            TextFormatting colour = TextFormatting.RED;
            ItemStack match = ItemStack.EMPTY;
            for(ItemStack stack : foundStacks)
            {
                if(inputIng.apply(stack))
                {
                    colour = TextFormatting.YELLOW;
                    match = stack;
                    break;
                }
            }
            String text = match.isEmpty() ?
                    itemStackText(inputIng.getMatchingStacks()[0], colour) :
                    itemStackText(match, colour);
            tooltipList.add(TextFormatting.GRAY + text);
        }

        return tooltipList;
    }

    private boolean canScrollUp()
    {
        return container.recipeStart > 0;
    }

    private boolean canScrollDown()
    {
        return container.recipes.size() > container.recipeStart + 5;
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @SuppressWarnings("unchecked")
    @Override
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
                button.displayString = recipe.getOutput().getDisplayName();
                button.setItem(recipe.getOutput());
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
        ((ArrowButton) buttonList.get(5)).enabled = canScrollUp();
        ((ArrowButton) buttonList.get(6)).enabled = canScrollDown();
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
        this.fontRenderer.drawString(invName, 8, 4, 4210752);
        this.fontRenderer.drawString(new TextComponentTranslation("container.inventory").getUnformattedText(), 8, this.ySize - 92, 4210752);

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
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button instanceof UpgradeButton)
        {
            //Add 1 to the id so that ids start from 1 rather than 0 (because there's no -0!)
            int id = button.id + 1;
            //If shift key is held, make the id negative
            id = isShiftKeyDown() ? id * -1 : id;
            container.enchantItem(this.mc.player, id);
            mc.playerController.sendEnchantPacket(container.windowId, id);
        }
        else if(button instanceof ArrowButton)
        {
            //Use the same enchant method for arrow buttons but ids Int Max for up and Int Max - 1 for down.
            int id = ((ArrowButton) button).isUpArrow() ? BUTTON_ID_ARROW_UP : BUTTON_ID_ARROW_DOWN;
            container.enchantItem(this.mc.player, id);
            mc.playerController.sendEnchantPacket(container.windowId, id);
        }
    }

    @Override
    public void handleMouseInput() throws IOException
    {
        super.handleMouseInput();

        int scrolled = Mouse.getEventDWheel();
        if(scrolled == 0) return;

        boolean scrolledUp = scrolled > 0;
        if((scrolledUp && canScrollUp()) || (!scrolledUp && canScrollDown()))
        {
            int id = scrolled > 0 ? BUTTON_ID_ARROW_UP : BUTTON_ID_ARROW_DOWN;
            container.enchantItem(mc.player, id);
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

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
        {
            super.drawButton(mc, mouseX, mouseY, partialTicks);
            //Draw item at left of button
            if(item != null)
                itemRender.renderItemAndEffectIntoGUI(item, x + 1, y + 1);
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

        @Override
        public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
        {
            if(!visible) return;
            FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(guiImage);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= x && mouseY >= y && mouseX < x + width && mouseY < y + height;
            //Select appropriate button icon for button state
            int iy = iconY;
            int textColour = 14737632;
            if(!enabled)
            {
                iy += height; //Changes to "off" icon
                textColour = 10526880; //Changes to darker text
            }
            //Draw icon
            drawTexturedModalRect(x, y, iconX, iy, width, height);
            //Draw text
            if(!displayString.equals(""))
                drawCenteredString(fontrenderer, displayString, (x + 16) + (width - 16) / 2, y + (height - 8) / 2, textColour);
        }

        @Override
        public void drawButtonForegroundLayer(int mouseX, int mouseY)
        {
            if(!tooltipLines.isEmpty())
                drawHoveringText(tooltipLines, mouseX, mouseY);
        }
    }
}
