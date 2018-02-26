package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.reference.Config;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by Mark on 15/07/2016.
 */
@Mod.EventBusSubscriber
public class ConfigHandler
{
    public static Configuration config;
    private static final String GENERAL = Configuration.CATEGORY_GENERAL;
    private static final String MOBS_GENERAL = "mobs_general";
    private static final String MOBS = "mobs";

    public static void init(File configFile)
    {
        //Create configuration object from the given configuration file
        if(config == null)
        {
            config = new Configuration(configFile);
            loadConfiguration();
        }
    }

    private static int[] getIntArray(String name, String category, int[] defaultValue, String comment)
    {
        Property prop = config.get(category, name, defaultValue, comment);
        prop.setLanguageKey(name);
        return prop.getIntList();
    }

    private static void loadConfiguration()
    {
        Config.scaleMax = config.getFloat("scaleMax", MOBS_GENERAL, Config.scaleMax, 0.1f, 10f, "The maximum mob scale multiplier for all mobs.");
        Config.scaleMin = config.getFloat("scaleMin", MOBS_GENERAL, Config.scaleMin, 0.1f, 10f, "The minimum mob scale multiplier for all mobs.");

        Config.plantGenDimIDs = getIntArray("plantGenDimIDs", GENERAL, Config.plantGenDimIDs, "The dimensions which the Overworld based plants will generate in. 0 is the Overworld.");

        Config.aptonothSpawnChance = config.getInt("aptonothSpawnChance", MOBS, Config.aptonothSpawnChance, 0, 1000, "Natural spawn chance for Aptanoths");
        Config.altarothSpawnChance = config.getInt("altarothSpawnChance", MOBS, Config.altarothSpawnChance, 0, 1000, "Natural spawn chance for Altaroths");
        Config.popoSpawnChance = config.getInt("popoSpawnChance", MOBS, Config.popoSpawnChance, 0, 1000, "Natural spawn chance for Popo");
        Config.kelbiSpawnChance = config.getInt("kelbiSpawnChance", MOBS, Config.kelbiSpawnChance, 0, 1000, "Natural spawn chance for Kelbi");
        Config.gargwaSpawnChance = config.getInt("gargwaSpawnChance", MOBS, Config.gargwaSpawnChance, 0, 1000, "Natural spawn chance for Gargwa");
        Config.jaggiSpawnChance = config.getInt("jaggiSpawnChance", MOBS, Config.jaggiSpawnChance, 0, 1000, "Natural spawn chance for Jaggi");
        Config.velocipreySpawnChance = config.getInt("velocipreySpawnChance", MOBS, Config.velocipreySpawnChance, 0, 1000, "Natural spawn chance for Velociprey");
        Config.genpreySpawnChance = config.getInt("genpreySpawnChance", MOBS, Config.genpreySpawnChance, 0, 1000, "Natural spawn chance for Genprey");
        Config.iopreySpawnChance = config.getInt("iopreySpawnChance", MOBS, Config.iopreySpawnChance, 0, 1000, "Natural spawn chance for Ioprey");

        Config.jaggiaChance = config.getFloat("jaggiaChance", MOBS, (float) Config.jaggiaChance, 0f, 1f, "The chance for a Jaggi to turn into a Jaggia on spawn (if it doesn't turn into a Great Jaggi)");
        Config.greatJaggiSpawnChance = config.getInt("greatJaggiSpawnChance", MOBS, Config.greatJaggiSpawnChance, 0, 100, "Natural spawn chance for Great Jaggi");
        Config.velocidromeSpawnChance = config.getInt("velocidromeSpawnChance", MOBS, Config.velocidromeSpawnChance, 0, 100, "Natural spawn chance for Velocidrome");

        if(config.hasChanged())
            config.save();
    }

    @SubscribeEvent
    public static void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.getModID().equalsIgnoreCase(MobHunter.MOD_ID))
            //Resync configs
            loadConfiguration();
    }
}
