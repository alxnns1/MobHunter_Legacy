package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.item.ItemMHArmour;
import alxnns1.mobhunter.container.ContainerArmourCraft;
import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 10/05/2016.
 */
public class GuiArmourCraft extends AbstractGuiCraft
{
    private static final String TOOLTIP = "gui.blockarmourupgrade.";

    public GuiArmourCraft(EntityPlayer player, World world, String blockDisplayName)
    {
        super(new ContainerArmourCraft(player, world), blockDisplayName);
    }

    @Override
    protected List<String> getButtonTooltip(MHCraftingRecipe recipe)
    {
        List<String> list = new ArrayList<String>();
        String line1;
        if(recipe.getKeyInput() != null && recipe.getKeyInput().getItem() instanceof ItemMHArmour)
            line1 = I18n.format(TOOLTIP + "button.craft.1.1") + " ";
        else
            line1 = I18n.format(TOOLTIP + "button.craft.1.2") + " ";
        list.add(line1 + TextFormatting.AQUA + recipe.getOutput().getDisplayName());
        list.add(I18n.format(TOOLTIP + "button.craft.2"));
        //Get the materials which are not present in player inventory
        ArrayList<Object> remainingItems = container.checkPlayerInv(container.inventoryPlayer, recipe.getInput());
        //Add the materials to the tooltip, coloured yellow if player has enough and red if not
        for(Object o : recipe.getInput())
        {
            TextFormatting colour = TextFormatting.YELLOW;
            if(o instanceof ItemStack)
            {
                ItemStack stackO = (ItemStack) o;
                //Check if enough of the item exists in the inventory (If not, then item in tooltip is coloured red)
                for(Object remainingO : remainingItems)
                {
                    if((remainingO instanceof ItemStack && stackO.isItemEqual((ItemStack) remainingO)) || (remainingO instanceof NonNullList && OreDictionary.containsMatch(false, (NonNullList<ItemStack>) remainingO, stackO)))
                    {
                        colour = TextFormatting.RED;
                        break;
                    }
                }
                list.add(((ItemStack) o).getCount() + " x " + colour + ((ItemStack) o).getDisplayName());
            }
            else if(o instanceof NonNullList)
            {
                //This basically gets the first ore dictionary string for the item.
                list.add(I18n.format(TOOLTIP + "button.craft.ore") + colour + OreDictionary.getOreName(OreDictionary.getOreIDs(((NonNullList<ItemStack>) o).get(0))[0]));
            }
        }
        return list;
    }
}
