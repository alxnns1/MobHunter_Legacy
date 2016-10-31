package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.crafting.ArmourCraftingManager;
import com.alxnns1.mobhunter.crafting.WeaponCraftingManager;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Contains the recipes to be added
 * Created by Mark on 21/04/2016.
 */
public class MHRecipes
{
    public static void init()
    {
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemBug, 1, 10), new ItemStack(MHItems.itemConsumable, 1, 13));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemMisc, 1, 1), new ItemStack(MHItems.itemMonsterDrop, 1, 0), Items.IRON_INGOT);

        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 0), Items.GLASS_BOTTLE, new ItemStack(MHItems.itemConsumable, 1, 0), new ItemStack(MHItems.itemMushroom, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 1), new ItemStack(MHItems.itemDrink, 1, 0), new ItemStack(MHItems.itemBug, 1, 10));
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 10), new ItemStack(MHItems.itemMushroom, 1, 0), new ItemStack(MHItems.itemBug, 1, 3));
        //GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 11), new ItemStack(MHItems.itemDrink, 1, 10), new ItemStack(MHItems.itemBug, 1, 10));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 2), new ItemStack(MHItems.itemMushroom, 1, 0), new ItemStack(MHItems.itemConsumable, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 3), new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemMushroom, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 4), new ItemStack(MHItems.itemMisc, 1, 0), MHItems.itemRareSteak);
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 6), new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemConsumable, 1, 8));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemDrink, 1, 8), new ItemStack(MHItems.itemMisc, 1, 0), new ItemStack(MHItems.itemConsumable, 1, 9));

        GameRegistry.addRecipe(new ItemStack(MHItems.itemMachalitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemOre, 1, 1), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(MHItems.itemDragonitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemOre, 1, 2), 'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(new ItemStack(MHItems.itemGossamitePickaxe), "xxx", " y ", " y ", 'x', new ItemStack(MHItems.itemOre, 1, 3), 'y', new ItemStack(Items.STICK));

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockEarthCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 0));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 0), MHBlocks.blockEarthCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockMachalite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 1));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 1), MHBlocks.blockMachalite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockDragonite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 2));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 2), MHBlocks.blockDragonite);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockLightCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 4));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 4), MHBlocks.blockLightCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockIceCrystal), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 5));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 5), MHBlocks.blockIceCrystal);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockGossamite), "xxx", "xxx", "xxx", 'x', new ItemStack(MHItems.itemOre, 1, 3));
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.itemOre, 9, 3), MHBlocks.blockGossamite);

        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockBbq), "w w", "wxw", "yzy", 'w', Items.IRON_INGOT, 'x', Items.FLINT_AND_STEEL, 'y', new ItemStack(Blocks.STONE), 'z', new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockWeaponCraft), "www", "xyx", "xzx", 'w', new ItemStack(Blocks.CARPET,1,14), 'x', new ItemStack(Blocks.STONE), 'y', new ItemStack(Blocks.CHEST), 'z', new ItemStack(Blocks.BOOKSHELF));
        GameRegistry.addRecipe(new ItemStack(MHBlocks.blockArmourCraft), "www", "xyx", "xzx", 'w', new ItemStack(Blocks.CARPET,1,11), 'x', new ItemStack(Blocks.STONE), 'y', new ItemStack(Blocks.CHEST), 'z', new ItemStack(Blocks.BOOKSHELF));

        GameRegistry.addSmelting(MHBlocks.blockOreMachalite, new ItemStack(MHItems.itemOre, 1, 1), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreDragonite, new ItemStack(MHItems.itemOre, 1, 2), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreGossamite, new ItemStack(MHItems.itemOre, 1, 3), 0.2f);

        WeaponCraftingManager wcm = WeaponCraftingManager.getInstance();
        wcm.addRecipeNullKey(MHItems.weaponHuntersKnife, new ItemStack(Items.IRON_INGOT, 3));
        wcm.addRecipe(MHItems.weaponSoldiersDagger, MHItems.weaponHuntersKnifePlus, new ItemStack(MHItems.itemMonsterDrop, 1, 26), new ItemStack(MHItems.itemMonsterDrop, 3, 17), new ItemStack(MHItems.itemMonsterDrop, 3, 18), new ItemStack(MHItems.itemOre, 5, 0));
        wcm.addRecipe(MHItems.weaponCommandersDagger, MHItems.weaponSoldiersDagger, new ItemStack(MHItems.itemMonsterDrop, 2, 27), new ItemStack(MHItems.itemMonsterDrop, 3, 26), new ItemStack(MHItems.itemOre, 5, 1));
        wcm.addRecipe(MHItems.weaponViperBite, MHItems.weaponHuntersKnife, new ItemStack(MHItems.itemMonsterDrop, 5, 23), new ItemStack(MHItems.itemMonsterDrop, 4, 25), new ItemStack(MHItems.itemMonsterDrop, 3, 0));
        //wcm.addRecipe(MHItems.weaponViperBitePlus, MHItems.weaponViperBite, new ItemStack(MHItems.itemMonsterDrop, 6, 25), new ItemStack(MHItems.itemMonsterDrop, 6, 0));
        //wcm.addRecipe(MHItems.weaponDeathprize, MHItems.weaponViperBite, new ItemStack(MHItems.itemMonsterDrop, 9, 25), new ItemStack(MHItems.itemMonsterDrop, 9, 1));
        wcm.addRecipe(MHItems.weaponSerpentBite, MHItems.weaponHuntersKnife, new ItemStack(MHItems.itemMonsterDrop, 5, 20), new ItemStack(MHItems.itemMonsterDrop, 4, 22), new ItemStack(MHItems.itemMonsterDrop, 3, 0));
        wcm.addRecipe(MHItems.weaponSerpentBitePlus, MHItems.weaponSerpentBite, new ItemStack(MHItems.itemMonsterDrop, 6, 22), new ItemStack(MHItems.itemMonsterDrop, 6, 0));
        wcm.addRecipe(MHItems.weaponDeadlock, MHItems.weaponSerpentBitePlus, new ItemStack(MHItems.itemMonsterDrop, 9, 22), new ItemStack(MHItems.itemMonsterDrop, 9, 1));
        wcm.addRecipe(MHItems.weaponHuntersKnifePlus, MHItems.weaponHuntersKnife, new ItemStack(Items.IRON_INGOT, 5));
        wcm.addRecipe(MHItems.weaponHuntersDagger, MHItems.weaponHuntersKnifePlus, new ItemStack(MHItems.itemOre, 4, 0), new ItemStack(MHItems.itemOre, 2, 1), new ItemStack(MHItems.itemBug, 6));
        wcm.addRecipe(MHItems.weaponAssassinsDagger, MHItems.weaponHuntersDagger, new ItemStack(MHItems.itemOre, 4, 0), new ItemStack(MHItems.itemOre, 2, 2), new ItemStack(MHItems.itemBug, 6));

        wcm.addRecipeNullKey(MHItems.weaponBoneKris, new ItemStack(MHItems.itemMonsterDrop, 1, 2), new ItemStack(MHItems.itemMonsterDrop, 2, 0));
        wcm.addRecipe(MHItems.weaponBoneKrisPlus, MHItems.weaponBoneKris, new ItemStack(MHItems.itemMonsterDrop, 3, 0), new ItemStack(MHItems.itemMonsterDrop, 3, 15));
        wcm.addRecipe(MHItems.weaponChiefKris, MHItems.weaponBoneKrisPlus, new ItemStack(MHItems.itemMonsterDrop, 1, 1), new ItemStack(MHItems.itemMonsterDrop, 2, 0), new ItemStack(MHItems.itemMonsterDrop, 5, 7), new ItemStack(Items.IRON_INGOT, 3));
        wcm.addRecipe(MHItems.weaponRottonSword, MHItems.weaponBoneKris, new ItemStack(Items.ROTTEN_FLESH, 7), new ItemStack(Items.SKULL, 1, 2));
        wcm.addRecipe(MHItems.weaponPlaguedSword, MHItems.weaponRottonSword, new ItemStack(Items.ROTTEN_FLESH, 6), new ItemStack(Items.SKULL, 2, 2));
        wcm.addRecipe(MHItems.weaponInfestedSword, MHItems.weaponPlaguedSword, new ItemStack(Items.ROTTEN_FLESH, 5), new ItemStack(Items.SKULL, 3, 2));
        wcm.addRecipe(MHItems.weaponSkeletalSword, MHItems.weaponBoneKris, new ItemStack(Items.BONE, 7), new ItemStack(Items.SKULL, 1, 0));
        wcm.addRecipe(MHItems.weaponSkeletalSwordPlus, MHItems.weaponSkeletalSword, new ItemStack(Items.BONE, 6), new ItemStack(Items.SKULL, 2, 0));
        wcm.addRecipe(MHItems.weaponWitheredSword, MHItems.weaponSkeletalSwordPlus, new ItemStack(Items.BONE, 6), new ItemStack(Items.SKULL, 1, 1), Items.COAL);
        wcm.addRecipe(MHItems.weaponWitheredSwordPlus, MHItems.weaponWitheredSword, new ItemStack(Items.BONE, 3), new ItemStack(Items.SKULL, 2, 1), new ItemStack(Items.COAL, 3));
        wcm.addRecipe(MHItems.weaponNecrosisBlade, MHItems.weaponWitheredSwordPlus, new ItemStack(Items.BONE, 3), new ItemStack(Items.SKULL, 1, 1), Items.NETHER_STAR, new ItemStack(Items.COAL, 3));
        wcm.addRecipe(MHItems.weaponMandiblade, MHItems.weaponBoneKris, new ItemStack(Items.STRING, 7), Items.SPIDER_EYE);
        wcm.addRecipe(MHItems.weaponMandibladePlus, MHItems.weaponMandiblade, new ItemStack(Items.STRING, 6), new ItemStack(Items.SPIDER_EYE, 2));
        wcm.addRecipe(MHItems.weaponStingingMandiblade, MHItems.weaponMandibladePlus, new ItemStack(Items.STRING, 6), Items.SPIDER_EYE, Items.FERMENTED_SPIDER_EYE);
        wcm.addRecipe(MHItems.weaponPoisonStingblade, MHItems.weaponStingingMandiblade, new ItemStack(Items.STRING, 3), new ItemStack(Items.SPIDER_EYE, 3), new ItemStack(Items.FERMENTED_SPIDER_EYE, 2));
        wcm.addRecipe(MHItems.weaponFearSword, MHItems.weaponBoneKris, new ItemStack(Items.GUNPOWDER, 7), new ItemStack(Items.SKULL, 1, 4));
        wcm.addRecipe(MHItems.weaponTerrorSword, MHItems.weaponFearSword, new ItemStack(Items.GUNPOWDER, 6), new ItemStack(Items.SKULL, 2, 4));
        wcm.addRecipe(MHItems.weaponDreadSword, MHItems.weaponTerrorSword, new ItemStack(Items.GUNPOWDER, 3), new ItemStack(Items.SKULL, 3, 4), new ItemStack(Blocks.TNT, 2));
        wcm.addRecipe(MHItems.weaponXenoblade, MHItems.weaponBoneKris, new ItemStack(Items.ENDER_PEARL, 5));
        wcm.addRecipe(MHItems.weaponXenobladePlus, MHItems.weaponXenoblade, new ItemStack(Items.ENDER_PEARL, 7), Items.ENDER_EYE);
        wcm.addRecipe(MHItems.weaponAstralSword, MHItems.weaponXenobladePlus, new ItemStack(Items.ENDER_PEARL, 3), new ItemStack(Items.ENDER_EYE, 2), new ItemStack(Blocks.END_STONE, 3));
        wcm.addRecipe(MHItems.weaponAstralEndsword, MHItems.weaponAstralSword, new ItemStack(Items.ENDER_EYE, 3), Blocks.DRAGON_EGG, Items.DRAGON_BREATH, new ItemStack(Blocks.END_STONE, 3));
        wcm.addRecipe(MHItems.weaponSlimySword, MHItems.weaponBoneKris, new ItemStack(Items.SLIME_BALL, 5));
        wcm.addRecipe(MHItems.weaponSlimySwordPlus, MHItems.weaponSlimySword, new ItemStack(Items.SLIME_BALL, 5), new ItemStack(Blocks.SLIME_BLOCK, 3));
        wcm.addRecipe(MHItems.weaponCrystalizedSlimeblade, MHItems.weaponSlimySwordPlus, new ItemStack(Items.SLIME_BALL, 3), new ItemStack(Items.MAGMA_CREAM, 2), new ItemStack(Blocks.SLIME_BLOCK, 3));
        wcm.addRecipe(MHItems.weaponMagmaticSlimeblade, MHItems.weaponCrystalizedSlimeblade, new ItemStack(Items.MAGMA_CREAM, 3), new ItemStack(Blocks.SLIME_BLOCK, 3), new ItemStack(Items.BLAZE_POWDER, 2));
        wcm.addRecipe(MHItems.weaponBlazingSword, MHItems.weaponBoneKris, new ItemStack(Items.BLAZE_ROD, 2), new ItemStack(Items.BLAZE_POWDER, 3));
        wcm.addRecipe(MHItems.weaponBlazingTempest, MHItems.weaponBlazingSword, new ItemStack(Items.BLAZE_ROD, 6), new ItemStack(Items.BLAZE_POWDER, 3));
        wcm.addRecipe(MHItems.weaponBlazingInferno, MHItems.weaponBlazingTempest, new ItemStack(Items.BLAZE_ROD, 3), new ItemStack(Items.BLAZE_POWDER, 3), new ItemStack(Items.FIRE_CHARGE, 2));

        ArmourCraftingManager acm = ArmourCraftingManager.getInstance();
        acm.addRecipeNullKey(MHItems.armourDerringHelmet, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));
        acm.addRecipeNullKey(MHItems.armourDerringChestplate, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2), Items.IRON_INGOT);
        acm.addRecipeNullKey(MHItems.armourDerringLeggings, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S), Items.IRON_INGOT);
        acm.addRecipeNullKey(MHItems.armourDerringBoots, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));

        acm.addRecipeNullKey(MHItems.armourHunterHelmet, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT), Items.IRON_INGOT, MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2));
        acm.addRecipeNullKey(MHItems.armourHunterChestplate, new ItemStack(Items.IRON_INGOT, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_SCALE, 3), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2), MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL), MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.IVY));
        acm.addRecipeNullKey(MHItems.armourHunterLeggings, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2), Items.IRON_INGOT, MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER));
        acm.addRecipeNullKey(MHItems.armourHunterBoots, Items.IRON_INGOT, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2));

        acm.addRecipeNullKey(MHItems.armourBoneHelmet, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.UNKNOWN_SKULL), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.ALTAROTH_JAW));
        acm.addRecipeNullKey(MHItems.armourBoneChestplate, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 4), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JUMBO_BONE), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.ALTAROTH_STOMACH, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_FLUID));
        //TODO Add Sharp Bone Item for the rest of the bone armour
        //acm.addRecipeNullKey(MHItems.armourBoneLeggings, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SHARP_FANG, 2));
        //acm.addRecipeNullKey(MHItems.armourBoneBoots, MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SHARP_FANG));

        acm.addRecipeNullKey(MHItems.armourAlloyHelmet, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 3), MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2), new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourAlloyChestplate, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2), new ItemStack(Items.IRON_INGOT, 6), MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2));
        acm.addRecipeNullKey(MHItems.armourAlloyLeggings, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2), MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2), new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourAlloyBoots, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 4), MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2), new ItemStack(Items.IRON_INGOT, 2));

    }
}
