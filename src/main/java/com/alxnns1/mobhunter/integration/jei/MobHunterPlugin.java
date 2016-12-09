package com.alxnns1.mobhunter.integration.jei;

import com.alxnns1.mobhunter.crafting.ArmourCraftingManager;
import com.alxnns1.mobhunter.crafting.WeaponCraftingManager;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.integration.jei.ItemCraftingTables.ArmourCraftingRecipeHandler;
import com.alxnns1.mobhunter.integration.jei.ItemCraftingTables.ItemCraftingRecipeCategory;
import com.alxnns1.mobhunter.integration.jei.ItemCraftingTables.WeaponCraftingRecipeHandler;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Reference;
import mezz.jei.api.*;
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
        registry.addRecipeHandlers(
                new WeaponCraftingRecipeHandler(),
                new ArmourCraftingRecipeHandler());

        registry.addRecipes(WeaponCraftingManager.getInstance().getRecipeList());
        registry.addRecipes(ArmourCraftingManager.getInstance().getRecipeList());

        registry.addRecipeCategoryCraftingItem(new ItemStack(MHBlocks.blockWeaponCraft), Reference.MOD_ID + ":" + WEAPON_CRAFTING_ID);
        registry.addRecipeCategoryCraftingItem(new ItemStack(MHBlocks.blockArmourCraft), Reference.MOD_ID + ":" + ARMOUR_CRAFTING_ID);
        //registry.addRecipeClickArea(AbstractGuiCraft.class, );

        //Hide items from JEI
        IItemBlacklist blacklist = jeiHelper.getItemBlacklist();
        for(String itemName : MetaRef.getList(MetaRef.EnumItemType.ICON))
            blacklist.addItemToBlacklist(MetaRef.getStack(MetaRef.EnumItemType.ICON, itemName));
    }
}
