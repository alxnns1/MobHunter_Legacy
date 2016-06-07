package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.potion.PotionMH;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.util.StatCollector;

/**
 * Created by Mark on 01/06/2016.
 */
public class MHPotions
{
    public static PotionMH potionParalyse;

    private static PotionMH createPotion(String name, boolean isBad, int iconX, int iconY)
    {
        PotionMH potion = new PotionMH(name, isBad, 0x000000);
        potion.setPotionName(StatCollector.translateToLocal("effect." + name + ".name"));
        potion.setIconIndex(iconX, iconY);
        return potion;
    }

    public static void init()
    {
        potionParalyse = createPotion(Names.Potions.PARALYSE, true, 0, 0);
    }
}
