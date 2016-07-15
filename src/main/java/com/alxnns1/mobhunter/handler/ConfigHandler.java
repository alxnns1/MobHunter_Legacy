package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.reference.Config;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

/**
 * Created by Mark on 15/07/2016.
 */
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

    private static void loadConfiguration()
    {
        Config.scaleMax = config.getFloat("scaleMax", MOBS_GENERAL, Config.scaleMax, 0.1f, 10f, "The maximum mob scale multiplier for all mobs.");
        Config.scaleMin = config.getFloat("scaleMin", MOBS_GENERAL, Config.scaleMin, 0.1f, 10f, "The minimum mob scale multiplier for all mobs.");

        Config.aptonothSpawnChance = config.getInt("aptonothSpawnChance", MOBS, Config.aptonothSpawnChance, 0, 1000, "Natural spawn chance for Aptanoths");
        Config.altarothSpawnChance = config.getInt("altarothSpawnChance", MOBS, Config.altarothSpawnChance, 0, 1000, "Natural spawn chance for Altaroths");
        Config.popoSpawnChance = config.getInt("popoSpawnChance", MOBS, Config.popoSpawnChance, 0, 1000, "Natural spawn chance for Popo");
        Config.kelbiSpawnChance = config.getInt("kelbiSpawnChance", MOBS, Config.kelbiSpawnChance, 0, 1000, "Natural spawn chance for Kelbi");
        Config.gargwaSpawnChance = config.getInt("gargwaSpawnChance", MOBS, Config.gargwaSpawnChance, 0, 1000, "Natural spawn chance for Gargwa");
        Config.jaggiSpawnChance = config.getInt("jaggiSpawnChance", MOBS, Config.jaggiSpawnChance, 0, 1000, "Natural spawn chance for Jaggi");
        Config.velocipreySpawnChance = config.getInt("velocipreySpawnChance", MOBS, Config.velocipreySpawnChance, 0, 1000, "Natural spawn chance for Velociprey");
        Config.genpreySpawnChance = config.getInt("genpreySpawnChance", MOBS, Config.genpreySpawnChance, 0, 1000, "Natural spawn chance for Genprey");

        Config.jaggiaChance = config.getFloat("jaggiaChance", MOBS, (float) Config.jaggiaChance, 0f, 1f, "The chance for a Jaggi to turn into a Jaggia on spawn (if it doesn't turn into a Great Jaggi)");
        Config.greatJaggiChance = config.getFloat("greatJaggiChance", MOBS, (float) Config.greatJaggiChance, 0f, 1f, "The chance for a Jaggi to turn into a Great Jaggi on spawn");

        if(config.hasChanged())
            config.save();
    }

    @SubscribeEvent
    public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(event.getModID().equalsIgnoreCase(Reference.MOD_ID))
            //Resync configs
            loadConfiguration();
    }
}
