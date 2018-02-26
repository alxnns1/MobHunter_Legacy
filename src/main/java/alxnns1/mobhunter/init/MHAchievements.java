package alxnns1.mobhunter.init;

import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.init.Items;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

/**
 * Created by Mark on 16/05/2016.
 */
public class MHAchievements
{
    //public static StatBase testStat = new StatBasic("stat.MHTest", new ChatComponentTranslation("stat.MHTest", new Object[0]));

    public static Achievement cookMeat = new Achievement("achievment.cookMeat", "cookMeat", -2, -2, MHItems.itemDoneSteak, null);
    public static Achievement firstSword = new Achievement("achievment.firstSword", "firstSword", -2, -1, MHItems.weaponHuntersKnife, null);
    public static Achievement smallCrown = new Achievement("achievment.smallCrown", "smallCrown", 2, -2, Items.IRON_HELMET, null);
    public static Achievement largeCrown = new Achievement("achievment.largeCrown", "largeCrown", 2, -1, Items.GOLDEN_HELMET, null);
    public static Achievement greatJaggi = new Achievement("achievment.greatJaggi", "greatJaggi", -3, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_JAGGI), null);
    public static Achievement greatBaggi = new Achievement("achievment.greatBaggi", "greatBaggi", -2, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_BAGGI), null);
    public static Achievement greatWroggi = new Achievement("achievment.greatWroggi", "greatWroggi", -1, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_WROGGI), null);
    public static Achievement greatMaccao = new Achievement("achievment.greatMaccao", "greatMaccao", 0, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GREAT_MACCAO), null);
    public static Achievement velocidrome = new Achievement("achievment.velocidrome", "velocidrome", 1, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_VELOCIDROME), null);
    public static Achievement gendrome = new Achievement("achievment.gendrome", "gendrome", 2, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_GENDROME), null);
    public static Achievement iodrome = new Achievement("achievment.iodrome", "iodrome", 3, 1, MetaRef.getStack(MetaRef.EnumItemType.ICON, Names.Items.ICON_IODROME), null);

    public static void init()
    {
        //testStat.initIndependentStat().registerStat();

        cookMeat.registerStat();
        firstSword.registerStat();
        smallCrown.registerStat();
        largeCrown.registerStat();
        greatJaggi.registerStat();
        //greatBaggi.registerStat();
        //greatWroggi.registerStat();
        //greatMaccao.registerStat();
        velocidrome.registerStat();
        gendrome.registerStat();
        //iodrome.registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage(MobHunter.MOD_ID,
                cookMeat,
                firstSword,
                smallCrown,
                largeCrown,
                greatJaggi/*,
                greatBaggi*//*,
                greatWroggi*//*,
                greatMaccao*/,
                velocidrome,
                gendrome/*,
                iodrome*/));
    }
}
