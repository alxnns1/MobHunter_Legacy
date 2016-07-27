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

    public static Achievement cookMeat = new Achievement("achievment.cookMeat", "cookMeat", -2, 0, MHItems.itemDoneSteak, null);
    public static Achievement firstSword = new Achievement("achievment.firstSword", "firstSword", -2, 1, MHItems.weaponHuntersKnife, null);
    public static Achievement smallCrown = new Achievement("achievment.smallCrown", "smallCrown", 0, 0, Items.IRON_HELMET, null);
    public static Achievement largeCrown = new Achievement("achievment.largeCrown", "largeCrown", 0, 1, Items.GOLDEN_HELMET, null);
    public static Achievement greatJaggi = new Achievement("achievment.greatJaggi", "greatJaggi", 2, 0, MHItems.iconGreatJaggi, null);
    public static Achievement velocidrome = new Achievement("achievment.velocidrome", "velocidrome", 2, 1, MHItems.iconVelocidrome, null);
    public static Achievement gendrome = new Achievement("achievment.gendrome", "gendrome", 2, 2, MHItems.iconGendrome, null);
    public static Achievement iodrome = new Achievement("achievment.iodrome", "iodrome", 2, 3, MHItems.iconIodrome, null);

    public static void init()
    {
        //testStat.initIndependentStat().registerStat();

        cookMeat.registerStat();
        firstSword.registerStat();
        smallCrown.registerStat();
        largeCrown.registerStat();
        greatJaggi.registerStat();
        /*
        velocidrome.registerStat();
        gendrome.registerStat();
        iodrome.registerStat();
        */

        AchievementPage.registerAchievementPage(new AchievementPage(Reference.MOD_ID,
                cookMeat, firstSword, smallCrown, largeCrown, greatJaggi/*, velocidrome, gendrome, iodrome*/));
    }
}
