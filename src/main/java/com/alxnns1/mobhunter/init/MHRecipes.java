package com.alxnns1.mobhunter.init;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

/**
 * Contains the recipes to be added
 * Created by Mark on 21/04/2016.
 */
public class MHRecipes
{
    //Using this suppression to remove the "Redundant array creation" warnings
    @SuppressWarnings("all")
    public static void init()
    {
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneHelmet), new Object[] {"xyx", " z ", "   ", 'x', MHItems.itemMysteryBone, 'y', MHItems.itemUnknownSkull, 'z', Items.string});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneChestplate), new Object[] {"w w", "xyx", "xzx", 'w', MHItems.itemMonsterBoneS, 'x', MHItems.itemMysteryBone, 'y', Items.leather, 'z', Items.string});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneLeggings), new Object[] {"xxx", "y y", "z z", 'x', Items.leather, 'y', MHItems.itemMysteryBone, 'z', MHItems.itemMonsterBoneS});
        GameRegistry.addRecipe(new ItemStack(MHItems.armourBoneBoots), new Object[] {"   ", "y y", "z z", 'y', MHItems.itemMonsterBoneS, 'z', MHItems.itemMysteryBone});

        //1 Iron Sword + 5 Iron Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponIronSwordPlus),new Object[] {
                new ItemStack(Items.iron_sword),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot)});
        //1 Iron Sword+ + 2 Machalite Ingot + 8 Iron Ingot
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSword),new Object[] {
                new ItemStack(MHItems.weaponIronSwordPlus),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot)});
        //1 Buster Sword + 5 Machalite Ingot + 2 Earth Crystal + 5 Iron Ore
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSwordPlus),new Object[] {
                new ItemStack(MHItems.weaponBusterSword),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(Items.iron_ingot),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot)});
        //1 Buster Sword+ + 3 Dragonite Ingot + 5 Machalite Ingot + 10 Earth Crystal + 3 Killer Beetle
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBusterSwordPlus),new Object[] {
                new ItemStack(MHItems.weaponBusterSword),
                new ItemStack(MHItems.itemDragoniteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemMachaliteIngot),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemKillerBeetle)});

        //2 Monster Bone S + 1 Jaggi Hide
        GameRegistry.addRecipe(new ItemStack(MHItems.weaponBoneBlade), new Object[] {" y "," y "," z ",'y',MHItems.itemMonsterBoneS,'z',MHItems.itemJaggiHide});
        //1 Bone Blade + 4 Monster Bone S + 2 Jaggi Hide
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponBoneBladePlus),new Object[] {
                new ItemStack(MHItems.weaponBoneBlade),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemJaggiHide),
                new ItemStack(MHItems.itemJaggiHide)});
        //1 Bone Blade+ + 7 Monster Bone S + 5 Monster Bone M
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponJawblade),new Object[] {
                new ItemStack(MHItems.weaponBoneBladePlus),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneS),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM)});
        //1 Jawblade + 5 Monster Bone M + 3 Jumbo Bone + 5 Earth Crystal
        GameRegistry.addShapelessRecipe(new ItemStack(MHItems.weaponGiantJawblade),new Object[] {
                new ItemStack(MHItems.weaponJawblade),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemMonsterBoneM),
                new ItemStack(MHItems.itemJumboBone),
                new ItemStack(MHItems.itemJumboBone),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal),
                new ItemStack(MHItems.itemEarthCrystal)});

        GameRegistry.addSmelting(MHItems.itemRawMeat, new ItemStack(MHItems.itemRareSteak), 0.2f);
    }
}
