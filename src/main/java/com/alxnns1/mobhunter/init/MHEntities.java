package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entity.*;
import com.alxnns1.mobhunter.entity.render.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

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

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, BiomeDictionary.Type[] biomeTypes)
    {
        for(BiomeDictionary.Type biome : biomeTypes)
        {
            addSpawn(entityClass, rarity, biome);
        }
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, BiomeDictionary.Type biomeType)
    {
        EntityRegistry.addSpawn(entityClass, rarity, 3, 5, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(biomeType));
    }

    public static void init(boolean isClientSide)
    {
        registerMobWithEgg(EntityAltaroth.class, "Altaroth", 0x8fbf60, 0xbfbf60);
        addSpawn(EntityAltaroth.class, spawnRarity, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityPopo.class, "Popo", 0x402a00, 0x403400);
        addSpawn(EntityPopo.class, spawnRarity, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.MOUNTAIN});
        registerMobWithEgg(EntityKelbi.class, "Kelbi", 0x20402b, 0xbfbf8f);
        addSpawn(EntityKelbi.class, spawnRarity, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityGargwa.class, "Gargwa", 0x804000, 0x0000ff);
        addSpawn(EntityGargwa.class, spawnRarity, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS});
        registerMobWithEgg(EntityJaggi.class, "Jaggi", 0xd56a00, 0xbf80ff);
        addSpawn(EntityJaggi.class, spawnRarity, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});

        if(isClientSide)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityAltaroth.class, RenderAltaroth.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityPopo.class, RenderPopo.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityKelbi.class, RenderKelbi.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityGargwa.class, RenderGargwa.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityJaggi.class, RenderJaggi.FACTORY);
        }
    }
}
