package alxnns1.mobhunter.reference;

import alxnns1.mobhunter.MobHunter;
import net.minecraftforge.common.config.Config;

/**
 * Created by Mark on 15/07/2016.
 */
@Config(modid = MobHunter.MOD_ID)
@Config.LangKey(MobHunter.MOD_ID + ".config.title")
public class MHConfig
{
    @Config.Comment("The maximum scale of a mob")
    @Config.RangeDouble(min = 0d)
    public static double scaleMax = 1.24d;

    @Config.Comment("The minimum scale of a mob")
    @Config.RangeDouble(min = 0d)
    public static double scaleMin = 0.79d;

    @Config.Comment("The dimension IDs that will generate plants")
    public static int[] plantGenDimIDs = new int[] {-1, 0, 1};

    @Config.Comment("Mob spawn chance configs")
    public static final SpawnChances SPAWN_CHANCES = new SpawnChances();

    public static class SpawnChances
    {
        @Config.RangeInt(min = 0)
        public int aptonothSpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int apcerosSpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int altarothSpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int popoSpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int kelbiSpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int gargwaSpawnChance = 8;
        //@Config.RangeInt(min = 0)
        //public int jaggiSpawnChance = 8;
        //@Config.RangeInt(min = 0)
        //public int velocipreySpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int giapreySpawnChance = 8;
        //@Config.RangeInt(min = 0)
        //public int genpreySpawnChance = 8;
        @Config.RangeInt(min = 0)
        public int iopreySpawnChance = 8;

        @Config.Comment("Minimum Jaggi pack size that spawns with a Great Jaggi")
        @Config.RangeInt(min = 0)
        public int jaggiPackSizeMin = 6;
        @Config.Comment("Maximum Jaggi pack size that spawns with a Great Jaggi")
        @Config.RangeInt(min = 0)
        public int jaggiPackSizeMax = 14;
        @Config.Comment("The chance for a Jaggia to spawn instead of a Jaggi")
        @Config.RangeDouble(min = 0d)
        public double jaggiaChance = 0.4d;

        @Config.RangeInt(min = 0)
        public int greatJaggiSpawnChance = 1;
        @Config.RangeInt(min = 0)
        public int velocidromeSpawnChance = 1;
        @Config.RangeInt(min = 0)
        public int gendromeSpawnChance = 1;
    }
}
