package alxnns1.mobhunter.integration.jei;

import alxnns1.mobhunter.crafting.ArmourCraftingRecipe;
import alxnns1.mobhunter.crafting.WeaponCraftingManager;
import alxnns1.mobhunter.crafting.WeaponCraftingRecipe;
import alxnns1.mobhunter.crafting.ArmourCraftingManager;
import alxnns1.mobhunter.init.MHBlocks;
import alxnns1.mobhunter.integration.jei.ItemCraftingTables.ItemCraftingRecipeCategory;
import alxnns1.mobhunter.integration.jei.ItemCraftingTables.ItemCraftingRecipeWrapper;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Reference;
import mezz.jei.api.*;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

/**
 * Created by Mark on 08/12/2016.
 */
@JEIPlugin
public class MobHunterPlugin extends BlankModPlugin
{
    public static IJeiHelpers jeiHelper;

    public static final String WEAPON_CRAFTING_ID = "weaponCrafting";
    public static final String ARMOUR_CRAFTING_ID = "armourCrafting";

    @Override
    public void register(@Nonnull IModRegistry registry)
    {
        jeiHelper = registry.getJeiHelpers();

        registry.addRecipeCategories(
                new ItemCraftingRecipeCategory(jeiHelper.getGuiHelper(), WEAPON_CRAFTING_ID),
                new ItemCraftingRecipeCategory(jeiHelper.getGuiHelper(), ARMOUR_CRAFTING_ID));
        registry.handleRecipes(WeaponCraftingRecipe.class, ItemCraftingRecipeWrapper.FACTORY_WEAPON, MobHunter.MOD_ID + ":" + WEAPON_CRAFTING_ID);
        registry.handleRecipes(ArmourCraftingRecipe.class, ItemCraftingRecipeWrapper.FACTORY_ARMOUR, MobHunter.MOD_ID + ":" + WEAPON_CRAFTING_ID);

        registry.addRecipes(WeaponCraftingManager.getInstance().getRecipeList(), MobHunter.MOD_ID + ":" + WEAPON_CRAFTING_ID);
        registry.addRecipes(ArmourCraftingManager.getInstance().getRecipeList(), MobHunter.MOD_ID + ":" + WEAPON_CRAFTING_ID);

        registry.addRecipeCategoryCraftingItem(new ItemStack(MHBlocks.blockWeaponCraft), MobHunter.MOD_ID + ":" + WEAPON_CRAFTING_ID);
        registry.addRecipeCategoryCraftingItem(new ItemStack(MHBlocks.blockArmourCraft), MobHunter.MOD_ID + ":" + ARMOUR_CRAFTING_ID);

        //Hide items from JEI
        IIngredientBlacklist blacklist = jeiHelper.getIngredientBlacklist();
        for(String itemName : MetaRef.getList(MetaRef.EnumItemType.ICON))
            blacklist.addIngredientToBlacklist(MetaRef.getStack(MetaRef.EnumItemType.ICON, itemName));
    }
}
