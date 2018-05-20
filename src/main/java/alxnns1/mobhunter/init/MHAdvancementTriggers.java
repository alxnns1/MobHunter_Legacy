package alxnns1.mobhunter.init;

import alxnns1.mobhunter.advancement.MHTrigger;
import alxnns1.mobhunter.advancement.trigger.LargeCrownTrigger;
import alxnns1.mobhunter.advancement.trigger.SmallCrownTrigger;
import net.minecraft.advancements.CriteriaTriggers;

/**
 * Created by Mark on 07/03/2018.
 */
public class MHAdvancementTriggers
{
    public static SmallCrownTrigger smallCrown;
    public static LargeCrownTrigger largeCrown;

    private static void register(MHTrigger trigger)
    {
        CriteriaTriggers.register(trigger);
    }

    public static void init()
    {
        register(smallCrown = new SmallCrownTrigger());
        register(largeCrown = new LargeCrownTrigger());
    }

    /*
    public static Achievement firstSword = new Achievement("achievment.firstSword", "firstSword", -2, -1, MHItems.weaponHuntersKnife, null);
    public static Achievement greatJaggi = new Achievement("achievment.greatJaggi", "greatJaggi", -3, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_JAGGI), null);
    public static Achievement greatBaggi = new Achievement("achievment.greatBaggi", "greatBaggi", -2, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_BAGGI), null);
    public static Achievement greatWroggi = new Achievement("achievment.greatWroggi", "greatWroggi", -1, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_WROGGI), null);
    public static Achievement greatMaccao = new Achievement("achievment.greatMaccao", "greatMaccao", 0, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_MACCAO), null);
    public static Achievement velocidrome = new Achievement("achievment.velocidrome", "velocidrome", 1, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_VELOCIDROME), null);
    public static Achievement gendrome = new Achievement("achievment.gendrome", "gendrome", 2, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GENDROME), null);
    public static Achievement iodrome = new Achievement("achievment.iodrome", "iodrome", 3, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_IODROME), null);
    */
}
