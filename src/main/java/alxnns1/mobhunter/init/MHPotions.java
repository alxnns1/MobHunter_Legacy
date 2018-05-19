package alxnns1.mobhunter.init;

import alxnns1.mobhunter.potion.PotionMH;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.util.text.TextComponentTranslation;

/**
 * Created by Mark on 01/06/2016.
 */
public class MHPotions
{
    //TODO: If we're keeping potions, then register using the Forge registry event
    public static PotionMH potionParalyse;

    private static PotionMH createPotion(String name, boolean isBad, int iconX, int iconY)
    {
        PotionMH potion = new PotionMH(name, isBad, 0x000000);
        potion.setPotionName(new TextComponentTranslation("effect." + name + ".name").getUnformattedText());
        potion.setIconIndex(iconX, iconY);
        return potion;
    }

    public static void init()
    {
        potionParalyse = createPotion(Names.Potions.PARALYSE, true, 0, 0);
    }
}
