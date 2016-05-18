package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.StatBase;
import net.minecraft.stats.StatBasic;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by Mark on 16/05/2016.
 */
public class MHAchievements
{
    //public static StatBase testStat = new StatBasic("stat.MHTest", new ChatComponentTranslation("stat.MHTest", new Object[0]));

    public static Achievement cookMeat = new Achievement("achievment.cookMeat", "cookMeat", -1, -1, MHItems.itemDoneSteak, null);

    public static void init()
    {
        //testStat.initIndependentStat().registerStat();

        cookMeat.registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage(Reference.MOD_ID,
                cookMeat));
    }
}
