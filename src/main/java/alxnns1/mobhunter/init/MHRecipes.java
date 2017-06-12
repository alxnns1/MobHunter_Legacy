package alxnns1.mobhunter.init;

import alxnns1.mobhunter.crafting.WeaponCraftingManager;
import alxnns1.mobhunter.crafting.ArmourCraftingManager;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

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
                MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HONEY),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.BITTERBUG));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.TOOL, Names.Items.WHETSTONE),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S),
                Items.IRON_INGOT);

        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.POTION),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HERB),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, Names.Items.BLUE_MUSHROOM));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_POTION),
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.POTION),
                MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HONEY));
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.ANTIDOTE),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.ANTIDOTE_HERB),
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
        //      MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.DASH_EXTRACT),
        //      MHItems.itemDoneSteak);
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.DEMONDRUG),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.MIGHT_SEED));
        //TODO Add Pale Extract
        //GameRegistry.addShapelessRecipe(
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_DEMONDRUG),
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.DEMONDRUG),
        //      MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PALE_EXTRACT);
        GameRegistry.addShapelessRecipe(
                MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.ARMOURSKIN),
                Items.GLASS_BOTTLE,
                MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST),
                MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.ADAMANT_SEED));
        //TODO Add Pale Extract
        //GameRegistry.addShapelessRecipe(
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.MEGA_ARMOURSKIN),
        //      MetaRef.getStack(MetaRef.EnumItemType.DRINK, Names.Items.ARMOURSKIN),
        //      MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PALE_EXTRACT);

        GameRegistry.addRecipe(
                new ItemStack(MHItems.itemFieldPouch),
                "yzy", "y y", "yyy",
                'y', new ItemStack(Blocks.CARPET,1,0),
                'z', Items.STRING);

        GameRegistry.addShapelessRecipe(
                new ItemStack(MHItems.itemQuest),
                Items.PAPER, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));

        GameRegistry.addShapelessRecipe(
                new ItemStack(MHItems.itemQuestList),
                Items.BOOK, MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));


        GameRegistry.addRecipe(new ShapedOreRecipe(
                new ItemStack(MHItems.itemMachalitePickaxe),
                "xxx", " y ", " y ",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT),
                'y', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(
                new ItemStack(MHItems.itemDragonitePickaxe),
                "xxx", " y ", " y ",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT),
                'y', "stickWood"));
        GameRegistry.addRecipe(new ShapedOreRecipe(
                new ItemStack(MHItems.itemGossamitePickaxe),
                "xxx", " y ", " y ",
                'x', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT),
                'y', "stickWood"));

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
                'z', new ItemStack(Blocks.LOG));
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockBbqGourmet),
                "w w", "wxw", "yzy",
                'w', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT),
                'x', Items.BLAZE_POWDER,
                'y', new ItemStack(Blocks.STONE),
                'z', new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addRecipe(
                new ItemStack(MHBlocks.blockBbqGourmet),
                " p ", "mbm", " n ",
                'p', Items.BLAZE_POWDER,
                'm', MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT),
                'b', MHBlocks.blockBbq,
                'n', new ItemStack(Blocks.NETHERRACK));
        GameRegistry.addSmelting(MHItems.itemRawMeat,
                new ItemStack(MHItems.itemRareSteak), 0.2f);
        GameRegistry.addRecipe(new ShapedOreRecipe(
                new ItemStack(MHBlocks.blockWeaponCraft),
                "www", "xyx", "xzx",
                'w', new ItemStack(Blocks.CARPET,1,14),
                'x', "stone",
                'y', "chestWood",
                'z', "bookshelf"));
        GameRegistry.addRecipe(new ShapedOreRecipe(
                new ItemStack(MHBlocks.blockArmourCraft),
                "www", "xyx", "xzx",
                'w', new ItemStack(Blocks.CARPET,1,11),
                'x', "stone",
                'y', "chestWood",
                'z', "bookshelf"));

        GameRegistry.addSmelting(MHBlocks.blockOreMachalite,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreDragonite,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT), 0.2f);
        GameRegistry.addSmelting(MHBlocks.blockOreGossamite,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT), 0.2f);

        WeaponCraftingManager wcm = WeaponCraftingManager.getInstance();
        wcm.addRecipeNullKey(MHItems.weaponHuntersKnife,
                new ItemStack(Items.IRON_INGOT, 6));
        wcm.addRecipe(MHItems.weaponSoldiersDagger, MHItems.weaponHuntersKnifePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 5));
        wcm.addRecipe(MHItems.weaponCommandersDagger, MHItems.weaponSoldiersDagger,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5));
        wcm.addRecipe(MHItems.weaponDeadlyKnife, MHItems.weaponCommandersDagger,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW, 6),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT, 3));
        wcm.addRecipe(MHItems.weaponDeadlyKnifePlus, MHItems.weaponDeadlyKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.KINGS_FRILL, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_PLUS, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT, 7));
        /*
        //TODO Great Jaggi High Rank and G Rank weapons
        wcm.addRecipe(MHItems.weaponNatchKnife, MHItems.weaponDeadlyKnifePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW_PLUS, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE_PLUS, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.KINGS_FRILL, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.CARBALITE_INGOT, 5));
        wcm.addRecipe(MHItems.weaponAcclimatedKnife, MHItems.weaponNatchKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.AVIAN_FINEBONE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_SCALE_PLUS, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_GEM, 1));
        wcm.addRecipe(MHItems.weaponRebelliousKnife, MHItems.weaponAcclimatedKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW_PLUS, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.TOUGH_BIRD_WYVERN_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.FUCIUM_INGOT, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_GEM, 2));
        wcm.addRecipe(MHItems.weaponRebelliousKnifePlus, MHItems.weaponRebelliousKnife,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ELTALITE_INGOT, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.AVIAN_STOUTBONE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW_PLUS, 5));
        wcm.addRecipe(MHItems.weaponVengefulKnife, MHItems.weaponRebelliousKnifePlus,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MELDSPAR_INGOT, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ELTALITE_INGOT, 10),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_GEM, 3));
        */
        wcm.addRecipe(MHItems.weaponSerpentBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_FANG, 10),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 3));
        wcm.addRecipe(MHItems.weaponSerpentBitePlus, MHItems.weaponSerpentBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE_PLUS, 7),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_FANG, 15),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M, 5));
        wcm.addRecipe(MHItems.weaponDeadlock, MHItems.weaponSerpentBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE_PLUS, 9),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_FANG, 20),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_L, 7),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.AVIAN_STOUTBONE, 5));
        wcm.addRecipe(MHItems.weaponVelocidromeBite, MHItems.weaponSerpentBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_HEAD),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M, 4));
        wcm.addRecipe(MHItems.weaponVelocidromeBitePlus, MHItems.weaponVelocidromeBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW, 6),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_HEAD, 1),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.JUMBO_BONE, 3));
        wcm.addRecipe(MHItems.weaponVelocidromeFang, MHItems.weaponVelocidromeBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_PLUS, 1),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5));
        wcm.addRecipe(MHItems.weaponVelocidromeFangPlus, MHItems.weaponVelocidromeFang,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE_PLUS, 7),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.TOUGH_BIRD_WYVERN_HIDE, 4));
        wcm.addRecipe(MHItems.weaponDromeRushDagger, MHItems.weaponVelocidromeFangPlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_SCALE_PLUS, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_GEM, 1));
        wcm.addRecipe(MHItems.weaponGreatStabberdag, MHItems.weaponDromeRushDagger,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_HARDCLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.TOUGH_BIRD_WYVERN_HIDE, 8),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.FEY_WYVERN_GEM, 2));
        wcm.addRecipe(MHItems.weaponSnakeBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GIAPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GIAPREY_FANG, 10),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.FROST_SAC, 1));
        wcm.addRecipe(MHItems.weaponSnakeBitePlus, MHItems.weaponSnakeBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GIAPREY_HIDE_PLUS, 7),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GIAPREY_FANG, 15),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.FROST_SAC, 2));
        wcm.addRecipe(MHItems.weaponDeathlyCold, MHItems.weaponSnakeBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GIAPREY_HIDE_PLUS, 9),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GIAPREY_FANG, 20),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.AVIAN_STOUTBONE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.FROST_SAC, 3));
        wcm.addRecipe(MHItems.weaponViperBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_FANG, 10),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 1));
        wcm.addRecipe(MHItems.weaponViperBitePlus, MHItems.weaponViperBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE_PLUS, 7),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_FANG, 15),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 2));
        wcm.addRecipe(MHItems.weaponDeathprize, MHItems.weaponViperBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE_PLUS, 9),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_FANG, 20),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_L, 7),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 3));
        wcm.addRecipe(MHItems.weaponGendromeBite, MHItems.weaponViperBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HEAD),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 1));
        wcm.addRecipe(MHItems.weaponGendromeBitePlus, MHItems.weaponGendromeBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HIDE, 6),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HEAD, 1),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.JUMBO_BONE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 2));
        wcm.addRecipe(MHItems.weaponGendromeFang, MHItems.weaponGendromeBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_PLUS, 1),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 3));
        wcm.addRecipe(MHItems.weaponGendromeFangPlus, MHItems.weaponGendromeFang,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE_PLUS, 7),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.TOUGH_BIRD_WYVERN_HIDE, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 4));
        wcm.addRecipe(MHItems.weaponDromeToxinDagger, MHItems.weaponGendromeFangPlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_SCALE_PLUS, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW_PLUS, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_GEM, 1),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 5));
        wcm.addRecipe(MHItems.weaponGreatParadag, MHItems.weaponDromeToxinDagger,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HARDCLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.TOUGH_BIRD_WYVERN_HIDE, 8),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.FEY_WYVERN_GEM, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 6));
        wcm.addRecipe(MHItems.weaponHydraBite, MHItems.weaponHuntersKnife,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_HIDE, 5),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_FANG, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 3));
        wcm.addRecipe(MHItems.weaponHydraBitePlus, MHItems.weaponHydraBite,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_FANG, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 6),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.POISON_SAC, 2));
        wcm.addRecipe(MHItems.weaponDeadlyPoison, MHItems.weaponHydraBitePlus,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_FANG, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M, 9),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.POISON_SAC, 4));
        //TODO Iodrome weapons
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
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2));
        wcm.addRecipe(MHItems.weaponBoneKrisPlus, MHItems.weaponBoneKris,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_FANG, 3));
        wcm.addRecipe(MHItems.weaponChiefKris, MHItems.weaponBoneKrisPlus,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.BONE_HUSK, 5),
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
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
        acm.addRecipeNullKey(MHItems.armourDerringChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                Items.IRON_INGOT);
        acm.addRecipeNullKey(MHItems.armourDerringLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S),
                Items.IRON_INGOT);
        acm.addRecipeNullKey(MHItems.armourDerringBoots,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));

        acm.addRecipeNullKey(MHItems.armourHunterHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT),
                Items.IRON_INGOT,
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2));
        acm.addRecipeNullKey(MHItems.armourHunterChestplate,
                new ItemStack(Items.IRON_INGOT, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL),
                MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.IVY));
        acm.addRecipeNullKey(MHItems.armourHunterLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2),
                Items.IRON_INGOT,
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER));
        acm.addRecipeNullKey(MHItems.armourHunterBoots,
                Items.IRON_INGOT,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2));

        acm.addRecipeNullKey(MHItems.armourBoneHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.UNKNOWN_SKULL),
                MetaRef.getStack(MetaRef.EnumItemType.NEOPTERAN_DROP, Names.Items.ALTAROTH_JAW));
        acm.addRecipeNullKey(MHItems.armourBoneChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE, 4),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.JUMBO_BONE),
                MetaRef.getStack(MetaRef.EnumItemType.NEOPTERAN_DROP, Names.Items.ALTAROTH_STOMACH, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_FLUID));
        acm.addRecipeNullKey(MHItems.armourBoneLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BEAST_DROP, Names.Items.SHARP_FANG, 2));
        acm.addRecipeNullKey(MHItems.armourBoneBoots,
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M),
                MetaRef.getStack(MetaRef.EnumItemType.BEAST_DROP, Names.Items.SHARP_FANG));

        acm.addRecipeNullKey(MHItems.armourAlloyHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourAlloyChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 5),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                new ItemStack(Items.IRON_INGOT, 6),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2));
        acm.addRecipeNullKey(MHItems.armourAlloyLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourAlloyBoots,
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 4),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2),
                new ItemStack(Items.IRON_INGOT, 2));

        acm.addRecipeNullKey(MHItems.armourJaggiHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_SCALE, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourJaggiChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.KINGS_FRILL),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_CLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2),
                new ItemStack(Items.IRON_INGOT, 3));
        acm.addRecipeNullKey(MHItems.armourJaggiLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GREAT_JAGGI_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.KINGS_FRILL),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));
        acm.addRecipeNullKey(MHItems.armourJaggiBoots,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_HIDE, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.JAGGI_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 4),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT, 2));

        acm.addRecipeNullKey(MHItems.armourVelocipreyHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2));
        acm.addRecipeNullKey(MHItems.armourVelocipreyChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_CLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.SCREAMER_SAC, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 3));
        acm.addRecipeNullKey(MHItems.armourVelocipreyLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIDROME_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.SCREAMER_SAC, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2));
        acm.addRecipeNullKey(MHItems.armourVelocipreyBoots,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.VELOCIPREY_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 4),
                new ItemStack(Items.IRON_INGOT, 4));

        acm.addRecipeNullKey(MHItems.armourGenpreyHelmet,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2));
        acm.addRecipeNullKey(MHItems.armourGenpreyChestplate,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW, 4),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_SCALE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.GLUEGLOPPER, 2),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 3));
        acm.addRecipeNullKey(MHItems.armourGenpreyLeggings,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL, 2));
        acm.addRecipeNullKey(MHItems.armourGenpreyBoots,
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_HIDE, 2),
                MetaRef.getStack(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_SCALE, 3),
                MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S, 4),
                new ItemStack(Items.IRON_INGOT, 4));
    }
}
