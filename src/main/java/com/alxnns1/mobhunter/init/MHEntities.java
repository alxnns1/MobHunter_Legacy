package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entity.EntityJaggi;
import com.alxnns1.mobhunter.entity.EntityKelbi;
import com.alxnns1.mobhunter.entity.EntityPopo;
import com.alxnns1.mobhunter.entity.render.RenderJaggi;
import com.alxnns1.mobhunter.entity.render.RenderKelbi;
import com.alxnns1.mobhunter.entity.render.RenderPopo;
import com.alxnns1.mobhunter.util.Common;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;

/**
 * Created by Mark on 04/05/2016.
 */
public class MHEntities
{
    private static int modEntityID = 0;
    private static int spawnRarity = 10;

    private static void registerMobWithEgg(Class<? extends Entity> entityClass, String name, int eggColour, int eggSpotColour)
    {
        EntityRegistry.registerModEntity(entityClass, name, ++modEntityID, MobHunter.instance, 64, 1, false);
        EntityRegistry.registerEgg(entityClass, eggColour, eggSpotColour);
    }

    public static void init(boolean isClientSide)
    {
        registerMobWithEgg(EntityPopo.class, "Popo", 0x402a00, 0x403400);
        EntityRegistry.addSpawn(EntityPopo.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
        EntityRegistry.addSpawn(EntityPopo.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        registerMobWithEgg(EntityKelbi.class, "Kelbi", 0x20402b, 0xbfbf8f);
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MESA));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.HILLS));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn(EntityKelbi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.BEACH));
        registerMobWithEgg(EntityJaggi.class, "Jaggi", 0xd56a00, 0xbf80ff);
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MESA));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.FOREST));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.PLAINS));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.MOUNTAIN));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.HILLS));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SWAMP));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SANDY));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.SNOWY));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.WASTELAND));
        EntityRegistry.addSpawn(EntityJaggi.class,spawnRarity,5,5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(BiomeDictionary.Type.BEACH));

        if(isClientSide)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityPopo.class, RenderPopo.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityKelbi.class, RenderKelbi.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityJaggi.class, RenderJaggi.FACTORY);
        }
    }
}
