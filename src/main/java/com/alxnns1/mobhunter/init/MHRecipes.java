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
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.HONEY),
                MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, Names.Items.BITTERBUG));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.WHETSTONE),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S),
                Items.IRON_INGOT);

        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.POTION),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, Names.Items.HERB),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.BLUE_MUSHROOM));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_POTION),
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.POTION),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.HONEY));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.ANTIDOTE),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, Names.Items.ANTIDOTE_HERB),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.BLUE_MUSHROOM));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.IMMUNIZER),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.DRAGON_TOADSTOOL));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.DASH_JUICE),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MHItems.itemRareSteak);
        //TODO Add Dash Extract
        //GameRegistry.addShapelessRecipe(
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_DASH_JUICE),
        //      Items.GLASS_BOTTLE,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.DASH_EXTRACT),
        //      MHItems.itemDoneSteak);
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.DEMONDRUG),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, Names.Items.MIGHT_SEED));
        //TODO Add Pale Extract
        //GameRegistry.addShapelessRecipe(
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_DEMONDRUG),
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.DEMONDRUG),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.PALE_EXTRACT);
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.ARMOURSKIN),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, Names.Items.ADAMANT_SEED));
        //TODO Add Pale Extract
        //GameRegistry.addShapelessRecipe(
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_ARMOURSKIN),
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.ARMOURSKIN),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.PALE_EXTRACT);

        GameRegistry.addRecipe(
                new ItemStack(MHItems.itemFieldPouch),
                "yzy", "y y", "yyy",
                'y', new ItemStack(Blocks.CARPET,1,0),
                'z', Items.STRING);

        GameRegistry.addRecipe(
                new ItemStack(MHItems.itemMachalitePickaxe),
                "xxx", " y ", " y ",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT),
                'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(
                new ItemStack(MHItems.itemDragonitePickaxe),
                "xxx", " y ", " y ",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT),
                'y', new ItemStack(Items.STICK));
        GameRegistry.addRecipe(
                new ItemStack(MHItems.itemGossamitePickaxe),
                "xxx", " y ", " y ",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT),
                'y', new ItemStack(Items.STICK));

        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockEarthCrystal),
                "xxx", "xxx", "xxx",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 9),
                MHBlocks.blockEarthCrystal);
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockMachalite),
                "xxx", "xxx", "xxx",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 9),
                MHBlocks.blockMachalite);
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockDragonite),
                "xxx", "xxx", "xxx",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT, 9),
                MHBlocks.blockDragonite);
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockLightCrystal),
                "xxx", "xxx", "xxx",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.LIGHT_CRYSTAL));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.LIGHT_CRYSTAL, 9),
                MHBlocks.blockLightCrystal);
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockIceCrystal),
                "xxx", "xxx", "xxx",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ICE_CRYSTAL));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ICE_CRYSTAL, 9),
                MHBlocks.blockIceCrystal);
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockGossamite),
                "xxx", "xxx", "xxx",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT, 9),
                MHBlocks.blockGossamite);

        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockBbq),
                "w w", "wxw", "yzy",
                'w', Items.IRON_INGOT,
                'x', Items.FLINT_AND_STEEL,
                'y', new ItemStack(Blocks.STONE),
                'z', new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addSmelting(MHItems.itemRawMeat,
                new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockWeaponCraft),
                "www", "xyx", "xzx",
                'w', new ItemStack(Blocks.CARPET,1,14),
                'x', new ItemStack(Blocks.STONE),
                'y', new ItemStack(Blocks.CHEST),
                'z', new ItemStack(Blocks.BOOKSHELF));
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockArmourCraft),
                "www", "xyx", "xzx",
                'w', new ItemStack(Blocks.CARPET,1,11),
                'x', new ItemStack(Blocks.STONE),
                'y', new ItemStack(Blocks.CHEST),
                'z', new ItemStack(Blocks.BOOKSHELF));

        GameRegistry.addSmelting(MHBlocks.blockOreMachalite,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreDragonite,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreGossamite,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT), 0.2f);

        WeaponCraftingManager wcm = WeaponCraftingManager.getInstance();
        wcm.addRecipeNullKey(MHItems.weaponHuntersKnife,
                new ItemStack(Items.IRON_INGOT, 3));
        wcm.addRecipe(MHItems.weaponSoldiersDagger, MHItems.weaponHuntersKnifePlus,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_HIDE),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 5));
        wcm.addRecipe(MHItems.weaponCommandersDagger, MHItems.weaponSoldiersDagger,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_CLAW, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5));
        wcm.addRecipe(MHItems.weaponSerpentBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_FANG, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 3));
        wcm.addRecipe(MHItems.weaponSerpentBitePlus, MHItems.weaponSerpentBite,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_FANG, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 6));
        wcm.addRecipe(MHItems.weaponDeadlock, MHItems.weaponSerpentBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_FANG, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M, 9));
        wcm.addRecipe(MHItems.weaponVelocidromeBite, MHItems.weaponSerpentBite,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HEAD),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M, 4));
        wcm.addRecipe(MHItems.weaponVelocidromeBitePlus, MHItems.weaponVelocidromeBite,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M, 6));
        //TODO Add Monster Bone L and Monster Bone+
        //wcm.addRecipe(MHItems.weaponVelocidromeFang, MHItems.weaponVelocidromeBitePlus,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 6),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 4),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HEAD, 1),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_L, 4));
        //wcm.addRecipe(MHItems.weaponVelocidromeFangPlus, MHItems.weaponVelocidromeFang,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 9),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 6),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_L, 6));
        //wcm.addRecipe(MHItems.weaponDromeRushDagger, MHItems.weaponVelocidromeFangPlus,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 9),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 6),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HEAD, 1),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SCREAMER_SAC, 2),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_PLUS, 6));
        //wcm.addRecipe(MHItems.weaponGreatStabberdag, MHItems.weaponDromeRushDagger,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 12),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 8),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HEAD, 1),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SCREAMER_SAC, 4),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_PLUS, 8));
        wcm.addRecipe(MHItems.weaponSnakeBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GIAPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GIAPREY_FANG, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 3));
        wcm.addRecipe(MHItems.weaponSnakeBitePlus, MHItems.weaponSnakeBite,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GIAPREY_FANG, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.FROST_SAC, 2));
        wcm.addRecipe(MHItems.weaponDeathlyCold, MHItems.weaponSnakeBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GIAPREY_FANG, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.FROST_SAC, 4));
        wcm.addRecipe(MHItems.weaponViperBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GENPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GENPREY_FANG, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 3));
        wcm.addRecipe(MHItems.weaponViperBitePlus, MHItems.weaponViperBite,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GENPREY_FANG, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.PARALYSIS_SAC, 2));
        wcm.addRecipe(MHItems.weaponDeathprize, MHItems.weaponViperBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GENPREY_FANG, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.PARALYSIS_SAC, 4));
        wcm.addRecipe(MHItems.weaponHydraBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_FANG, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 3));
        wcm.addRecipe(MHItems.weaponHydraBitePlus, MHItems.weaponHydraBite,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_FANG, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.POISON_SAC, 2));
        wcm.addRecipe(MHItems.weaponDeadlyPoison, MHItems.weaponHydraBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.IOPREY_FANG, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.POISON_SAC, 4));
        wcm.addRecipe(MHItems.weaponHuntersKnifePlus, MHItems.weaponHuntersKnife,
                new ItemStack(Items.IRON_INGOT, 5));
        wcm.addRecipe(MHItems.weaponHuntersDagger, MHItems.weaponHuntersKnifePlus,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 4),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER));
        wcm.addRecipe(MHItems.weaponAssassinsDagger, MHItems.weaponHuntersDagger,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 4),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER));

        wcm.addRecipeNullKey(MHItems.weaponBoneKris,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2));
        wcm.addRecipe(MHItems.weaponBoneKrisPlus, MHItems.weaponBoneKris,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.BIRD_WYVERN_FANG, 3));
        wcm.addRecipe(MHItems.weaponChiefKris, MHItems.weaponBoneKrisPlus,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.BONE_HUSK, 5),
                new ItemStack(Items.IRON_INGOT, 3));
        wcm.addRecipe(MHItems.weaponRottonSword, MHItems.weaponBoneKris,
                new ItemStack(Items.ROTTEN_FLESH, 7),
                new ItemStack(Items.SKULL, 1, 2));
        wcm.addRecipe(MHItems.weaponPlaguedSword, MHItems.weaponRottonSword,
                new ItemStack(Items.ROTTEN_FLESH, 6),
                new ItemStack(Items.SKULL, 2, 2));
        wcm.addRecipe(MHItems.weaponInfestedSword, MHItems.weaponPlaguedSword,
                new ItemStack(Items.ROTTEN_FLESH, 5),
                new ItemStack(Items.SKULL, 3, 2));
        wcm.addRecipe(MHItems.weaponSkeletalSword, MHItems.weaponBoneKris,
                new ItemStack(Items.BONE, 7),
                new ItemStack(Items.SKULL, 1, 0));
        wcm.addRecipe(MHItems.weaponSkeletalSwordPlus, MHItems.weaponSkeletalSword,
                new ItemStack(Items.BONE, 6),
                new ItemStack(Items.SKULL, 2, 0));
        wcm.addRecipe(MHItems.weaponWitheredSword, MHItems.weaponSkeletalSwordPlus,
                new ItemStack(Items.BONE, 6),
                new ItemStack(Items.SKULL, 1, 1),
                Items.COAL);
        wcm.addRecipe(MHItems.weaponWitheredSwordPlus, MHItems.weaponWitheredSword,
                new ItemStack(Items.BONE, 3),
                new ItemStack(Items.SKULL, 2, 1),
                new ItemStack(Items.COAL, 3));
        wcm.addRecipe(MHItems.weaponNecrosisBlade, MHItems.weaponWitheredSwordPlus,
                new ItemStack(Items.BONE, 3),
                new ItemStack(Items.SKULL, 1, 1),
                Items.NETHER_STAR,
                new ItemStack(Items.COAL, 3));
        wcm.addRecipe(MHItems.weaponMandiblade, MHItems.weaponBoneKris,
                new ItemStack(Items.STRING, 7),
                Items.SPIDER_EYE);
        wcm.addRecipe(MHItems.weaponMandibladePlus, MHItems.weaponMandiblade,
                new ItemStack(Items.STRING, 6),
                new ItemStack(Items.SPIDER_EYE, 2));
        wcm.addRecipe(MHItems.weaponStingingMandiblade, MHItems.weaponMandibladePlus,
                new ItemStack(Items.STRING, 6),
                Items.SPIDER_EYE,
                Items.FERMENTED_SPIDER_EYE);
        wcm.addRecipe(MHItems.weaponPoisonStingblade, MHItems.weaponStingingMandiblade,
                new ItemStack(Items.STRING, 3),
                new ItemStack(Items.SPIDER_EYE, 3),
                new ItemStack(Items.FERMENTED_SPIDER_EYE, 2));
        wcm.addRecipe(MHItems.weaponFearSword, MHItems.weaponBoneKris,
                new ItemStack(Items.GUNPOWDER, 7),
                new ItemStack(Items.SKULL, 1, 4));
        wcm.addRecipe(MHItems.weaponTerrorSword, MHItems.weaponFearSword,
                new ItemStack(Items.GUNPOWDER, 6),
                new ItemStack(Items.SKULL, 2, 4));
        wcm.addRecipe(MHItems.weaponDreadSword, MHItems.weaponTerrorSword,
                new ItemStack(Items.GUNPOWDER, 3),
                new ItemStack(Items.SKULL, 3, 4),
                new ItemStack(Blocks.TNT, 2));
        wcm.addRecipe(MHItems.weaponXenoblade, MHItems.weaponBoneKris,
                new ItemStack(Items.ENDER_PEARL, 5));
        wcm.addRecipe(MHItems.weaponXenobladePlus, MHItems.weaponXenoblade,
                new ItemStack(Items.ENDER_PEARL, 7),
                Items.ENDER_EYE);
        wcm.addRecipe(MHItems.weaponAstralSword, MHItems.weaponXenobladePlus,
                new ItemStack(Items.ENDER_PEARL, 3),
                new ItemStack(Items.ENDER_EYE, 2),
                new ItemStack(Blocks.END_STONE, 3));
        wcm.addRecipe(MHItems.weaponAstralEndsword, MHItems.weaponAstralSword,
                new ItemStack(Items.ENDER_EYE, 3),
                Blocks.DRAGON_EGG,
                Items.DRAGON_BREATH,
                new ItemStack(Blocks.END_STONE, 3));
        wcm.addRecipe(MHItems.weaponSlimySword, MHItems.weaponBoneKris,
                new ItemStack(Items.SLIME_BALL, 5));
        wcm.addRecipe(MHItems.weaponSlimySwordPlus, MHItems.weaponSlimySword,
                new ItemStack(Items.SLIME_BALL, 5),
                new ItemStack(Blocks.SLIME_BLOCK, 3));
        wcm.addRecipe(MHItems.weaponCrystalizedSlimeblade, MHItems.weaponSlimySwordPlus,
                new ItemStack(Items.SLIME_BALL, 3),
                new ItemStack(Items.MAGMA_CREAM, 2),
                new ItemStack(Blocks.SLIME_BLOCK, 3));
        wcm.addRecipe(MHItems.weaponMagmaticSlimeblade, MHItems.weaponCrystalizedSlimeblade,
                new ItemStack(Items.MAGMA_CREAM, 3),
                new ItemStack(Blocks.SLIME_BLOCK, 3),
                new ItemStack(Items.BLAZE_POWDER, 2));
        wcm.addRecipe(MHItems.weaponBlazingSword, MHItems.weaponBoneKris,
                new ItemStack(Items.BLAZE_ROD, 2),
                new ItemStack(Items.BLAZE_POWDER, 3));
        wcm.addRecipe(MHItems.weaponBlazingTempest, MHItems.weaponBlazingSword,
                new ItemStack(Items.BLAZE_ROD, 6),
                new ItemStack(Items.BLAZE_POWDER, 3));
        wcm.addRecipe(MHItems.weaponBlazingInferno, MHItems.weaponBlazingTempest,
                new ItemStack(Items.BLAZE_ROD, 3),
                new ItemStack(Items.BLAZE_POWDER, 3),
                new ItemStack(Items.FIRE_CHARGE, 2));

        ArmourCraftingManager acm = ArmourCraftingManager.getInstance();
        acm.addRecipeNullKey(MHItems.armourDerringHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));
        acm.addRecipeNullKey(MHItems.armourDerringChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
                Items.IRON_INGOT);
        acm.addRecipeNullKey(MHItems.armourDerringLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S),
                Items.IRON_INGOT);
        acm.addRecipeNullKey(MHItems.armourDerringBoots,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));

        acm.addRecipeNullKey(MHItems.armourHunterHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT),
                Items.IRON_INGOT,
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2));
        acm.addRecipeNullKey(MHItems.armourHunterChestplate,
                new ItemStack(Items.IRON_INGOT, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL),
                MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.IVY));
        acm.addRecipeNullKey(MHItems.armourHunterLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2),
                Items.IRON_INGOT,
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER));
        acm.addRecipeNullKey(MHItems.armourHunterBoots,
                Items.IRON_INGOT,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2));

        acm.addRecipeNullKey(MHItems.armourBoneHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.UNKNOWN_SKULL),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.ALTAROTH_JAW));
        acm.addRecipeNullKey(MHItems.armourBoneChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JUMBO_BONE),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.ALTAROTH_STOMACH, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_FLUID));
        //TODO Add Sharp Bone Item for the rest of the bone armour
        //acm.addRecipeNullKey(MHItems.armourBoneLeggings,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 2),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SHARP_FANG, 2));
        //acm.addRecipeNullKey(MHItems.armourBoneBoots,
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE, 2),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_M),
        //      MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SHARP_FANG));

        acm.addRecipeNullKey(MHItems.armourAlloyHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourAlloyChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
                new ItemStack(Items.IRON_INGOT, 6),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2));
        acm.addRecipeNullKey(MHItems.armourAlloyLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourAlloyBoots,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 4),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2),
                new ItemStack(Items.IRON_INGOT, 2));

        acm.addRecipeNullKey(MHItems.armourJaggiHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_CLAW),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_SCALE, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourJaggiChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.KINGS_FRILL),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_CLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourJaggiLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GREAT_JAGGI_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.KINGS_FRILL),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));
        acm.addRecipeNullKey(MHItems.armourJaggiBoots,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_HIDE, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JAGGI_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 4),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2));

        acm.addRecipeNullKey(MHItems.armourVelocipreyHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2));
        acm.addRecipeNullKey(MHItems.armourVelocipreyChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_CLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SCREAMER_SAC, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 3));
        acm.addRecipeNullKey(MHItems.armourVelocipreyLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIDROME_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.SCREAMER_SAC, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2));
        acm.addRecipeNullKey(MHItems.armourVelocipreyBoots,
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.VELOCIPREY_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S, 4),
                new ItemStack(Items.IRON_INGOT, 4));

    }
}
