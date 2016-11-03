package com.alxnns1.mobhunter.init;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.entity.*;
import com.alxnns1.mobhunter.entity.render.*;
import com.alxnns1.mobhunter.reference.Config;
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

    private static void registerMobWithEgg(Class<? extends Entity> entityClass, String name, int eggColour, int eggSpotColour)
    {
        EntityRegistry.registerModEntity(entityClass, name, ++modEntityID, MobHunter.instance, 64, 1, false, eggColour, eggSpotColour);
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, BiomeDictionary.Type[] biomeTypes)
    {
        addSpawn(entityClass, rarity, 3, 5, biomeTypes);
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, int min, int max, BiomeDictionary.Type[] biomeTypes)
    {
        for(BiomeDictionary.Type biome : biomeTypes)
            EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.CREATURE, BiomeDictionary.getBiomesForType(biome));
    }

    public static void init(boolean isClientSide)
    {
        registerMobWithEgg(EntityAptonoth.class, "Aptonoth", 0x7f6d59, 0x382c1e);
        addSpawn(EntityAptonoth.class, Config.aptonothSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityAltaroth.class, "Altaroth", 0x8fbf60, 0xbfbf60);
        addSpawn(EntityAltaroth.class, Config.altarothSpawnChance, new BiomeDictionary.Type[] {
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
        addSpawn(EntityPopo.class, Config.popoSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SNOWY,
                BiomeDictionary.Type.MOUNTAIN});
        registerMobWithEgg(EntityKelbi.class, "Kelbi", 0x20402b, 0xbfbf8f);
        addSpawn(EntityKelbi.class, Config.kelbiSpawnChance, new BiomeDictionary.Type[] {
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
        addSpawn(EntityGargwa.class, Config.gargwaSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS});
        registerMobWithEgg(EntityJaggi.class, "Jaggi", 0xd56a00, 0xbf80ff);
        registerMobWithEgg(EntityJaggia.class, "Jaggia", 0xff8000, 0x9f40ff);
        addSpawn(EntityJaggi.class, Config.jaggiSpawnChance, 3, 7, new BiomeDictionary.Type[] {
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
        registerMobWithEgg(EntityVelociprey.class, "Velociprey", 0x0080ff, 0x402000);
        addSpawn(EntityVelociprey.class, Config.velocipreySpawnChance, 3, 7, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.HILLS,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityGenprey.class, "Genprey", 0x408040, 0x806040);
        addSpawn(EntityGenprey.class, Config.genpreySpawnChance, 3, 7, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND});
        registerMobWithEgg(EntityIoprey.class, "Ioprey", 0xdf2020, 0x0a0a0a);
        addSpawn(EntityIoprey.class, Config.iopreySpawnChance, 3, 7, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MESA,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.SWAMP,
                BiomeDictionary.Type.SANDY,
                BiomeDictionary.Type.WASTELAND,
                BiomeDictionary.Type.MOUNTAIN,});

        registerMobWithEgg(EntityGreatJaggi.class, "GreatJaggi", 0xe2aa72, 0x9f40ff);
        registerMobWithEgg(EntityVelocidrome.class, "Velocidrome", 0x0080ff, 0x402000);
        /*
        registerMobWithEgg(EntityGendrome.class, "Gendrome", 0x408040, 0x806040);
        */


        if(isClientSide)
        {
            RenderingRegistry.registerEntityRenderingHandler(EntityAptonoth.class, RenderAptonoth.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityAltaroth.class, RenderAltaroth.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityPopo.class, RenderPopo.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityKelbi.class, RenderKelbi.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityGargwa.class, RenderGargwa.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityJaggi.class, RenderJaggi.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityJaggia.class, RenderJaggia.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityVelociprey.class, RenderVelociprey.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityGenprey.class, RenderGenprey.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityIoprey.class, RenderIoprey.FACTORY);

            RenderingRegistry.registerEntityRenderingHandler(EntityGreatJaggi.class, RenderGreatJaggi.FACTORY);
            RenderingRegistry.registerEntityRenderingHandler(EntityVelocidrome.class, RenderVelocidrome.FACTORY);
            /*
            RenderingRegistry.registerEntityRenderingHandler(EntityGendrome.class, RenderGendrome.FACTORY);
            */
        }
    }
}
