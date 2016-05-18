package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by Mark on 16/05/2016.
 */
public class MHAchievements
{
    public static Achievement cookMeat = new Achievement("achievment.cookMeat", "cookMeat", -1, -1, MHItems.itemDoneSteak, null);

    public static void init()
    {
        cookMeat.registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage(Reference.MOD_ID,
                cookMeat));
    }
}
