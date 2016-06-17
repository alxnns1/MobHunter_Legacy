package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by Mark on 16/05/2016.
 */
public class MHAchievements
{
    //public static StatBase testStat = new StatBasic("stat.MHTest", new ChatComponentTranslation("stat.MHTest", new Object[0]));

    public static Achievement cookMeat = new Achievement("achievment.cookMeat", "cookMeat", -1, -1, MHItems.itemDoneSteak, null);
    public static Achievement firstSword = new Achievement("achievment.firstSword", "firstSword", 1, -1, MHItems.weaponIronSwordPlus, null);
    public static Achievement smallCrown = new Achievement("achievment.smallCrown", "smallCrown", -1, 1, Items.IRON_HELMET, null);
    public static Achievement largeCrown = new Achievement("achievment.largeCrown", "largeCrown", 1, 1, Items.GOLDEN_HELMET, null);

    public static void init()
    {
        //testStat.initIndependentStat().registerStat();

        cookMeat.registerStat();
        firstSword.registerStat();
        smallCrown.registerStat();
        largeCrown.registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage(Reference.MOD_ID,
                cookMeat, firstSword, smallCrown, largeCrown));
    }
}
