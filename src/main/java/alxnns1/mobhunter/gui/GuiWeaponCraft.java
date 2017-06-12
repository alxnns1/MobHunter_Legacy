package alxnns1.mobhunter.gui;

import alxnns1.mobhunter.container.ContainerWeaponCraft;
import alxnns1.mobhunter.crafting.MHCraftingRecipe;
import alxnns1.mobhunter.item.EnumSharpness;
import alxnns1.mobhunter.item.ItemMHSword;
import alxnns1.mobhunter.reference.Reference;
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
public class GuiWeaponCraft extends AbstractGuiCraft
{
    private static final String TOOLTIP = "gui.blockweaponupgrade.";

    public GuiWeaponCraft(EntityPlayer player, World world, String blockDisplayName)
    {
        super(new ContainerWeaponCraft(player, world), blockDisplayName);
    }

    @Override
    protected List<String> getButtonTooltip(MHCraftingRecipe recipe)
    {
        List<String> list = new ArrayList<String>();
        String line1;
        ItemStack resultStack = recipe.getRecipeOutput();
        if(resultStack == null)
        {
            list.add(TextFormatting.RED + "Error - recipe output is null!");
            return list;
        }
        if(!(resultStack.getItem() instanceof ItemMHSword))
        {
            list.add("Error - recipe output is not a " + Reference.MOD_NAME + " Sword!");
            return list;
        }
        if(recipe.getKeyInput() != null)
            line1 = I18n.format(TOOLTIP + "button.craft.1.1") + " ";
        else
            line1 = I18n.format(TOOLTIP + "button.craft.1.2") + " ";
        list.add(line1 + TextFormatting.AQUA + resultStack.getDisplayName());
        list.add(TextFormatting.GRAY + I18n.format(TOOLTIP + "button.craft.2.1") + " " + Float.toString(ItemMHSword.getActualAttackDamage(resultStack) + 1f));
        EnumSharpness sharpness = ItemMHSword.getSharpness(resultStack);
        if(sharpness == null)
            list.add(TextFormatting.LIGHT_PURPLE + "Sharpness is null!");
        else
            list.add(TextFormatting.GRAY + I18n.format(TOOLTIP + "button.craft.2.2") + " " + sharpness.getChatColour() + sharpness.getLocalizedName());

        //Materials:
        list.add(TextFormatting.GRAY + I18n.format(TOOLTIP + "button.craft.3"));
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
                list.add(TextFormatting.GRAY +  "" + ((ItemStack) o).getCount() + " x " + colour + ((ItemStack) o).getDisplayName());
            }
            else if(o instanceof NonNullList)
            {
                //This basically gets the first ore dictionary string for the item.
                list.add(TextFormatting.GRAY + I18n.format(TOOLTIP + "button.craft.ore") + colour + OreDictionary.getOreName(OreDictionary.getOreIDs(((NonNullList<ItemStack>) o).get(0))[0]));
            }
        }
        return list;
    }
}
