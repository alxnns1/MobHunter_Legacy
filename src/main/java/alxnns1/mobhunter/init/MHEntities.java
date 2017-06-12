package alxnns1.mobhunter.init;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.entity.EntitySpit;
import alxnns1.mobhunter.entity.RenderSpit;
import alxnns1.mobhunter.entity.monsters.*;
import alxnns1.mobhunter.entity.monsters.render.*;
import alxnns1.mobhunter.reference.Config;
import alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 04/05/2016.
 */
public class MHEntities
{
    private static int modEntityID = 0;
    public static List<String> ENTITY_NAMES = new ArrayList<String>();

    private static void registerEntity(Class<? extends Entity> entityClass, String name)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entityClass, Reference.MOD_ID + "." + name, ++modEntityID, MobHunter.instance, 64, 1, false);
        ENTITY_NAMES.add(String.format("%s.%s", Reference.MOD_ID, name));
    }

    private static void registerMobWithEgg(Class<? extends Entity> entityClass, String name, int eggColour, int eggSpotColour)
    {
        EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entityClass, Reference.MOD_ID + "." + name, ++modEntityID, MobHunter.instance, 64, 1, false, eggColour, eggSpotColour);
        ENTITY_NAMES.add(String.format("%s.%s", Reference.MOD_ID, name));
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, BiomeDictionary.Type[] biomeTypes)
    {
        addSpawn(entityClass, rarity, 3, 5, biomeTypes);
    }

    private static void addSpawn(Class<? extends EntityLiving> entityClass, int rarity, int min, int max, BiomeDictionary.Type[] biomeTypes)
    {
        for(BiomeDictionary.Type biome : biomeTypes)
            EntityRegistry.addSpawn(entityClass, rarity, min, max, EnumCreatureType.CREATURE, BiomeDictionary.getBiomes(biome).toArray(new Biome[] {}));
    }

    private static <T extends Entity> void registerRender(Class<T> entityClass, IRenderFactory<? super T> renderFactory)
    {
        RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
    }

    public static void init(boolean isClientSide)
    {
        registerMobWithEgg(EntityAptonoth.class, "aptonoth", 0x7f6d59, 0x382c1e);
        addSpawn(EntityAptonoth.class, Config.aptonothSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.PLAINS});
        registerMobWithEgg(EntityApceros.class, "apceros", 0x664019, 0xccb399);
        addSpawn(EntityApceros.class, Config.apcerosSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SAVANNA,
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.SANDY});
        registerMobWithEgg(EntityAltaroth.class, "altaroth", 0x8fbf60, 0xbfbf60);
        addSpawn(EntityAltaroth.class, Config.altarothSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SAVANNA,
                BiomeDictionary.Type.JUNGLE,
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS});
        registerMobWithEgg(EntityPopo.class, "popo", 0x402a00, 0x403400);
        addSpawn(EntityPopo.class, Config.popoSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.SNOWY});
        registerMobWithEgg(EntityKelbi.class, "kelbi", 0x20402b, 0xbfbf8f);
        addSpawn(EntityKelbi.class, Config.kelbiSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS});
        registerMobWithEgg(EntityGargwa.class, "gargwa", 0x804000, 0x0000ff);
        addSpawn(EntityGargwa.class, Config.gargwaSpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.JUNGLE});
        registerMobWithEgg(EntityGiaprey.class, "giaprey", 0x9fbfdf, 0x476078);
        addSpawn(EntityGiaprey.class, Config.giapreySpawnChance, new BiomeDictionary.Type[]{
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.SNOWY});
        registerMobWithEgg(EntityIoprey.class, "ioprey", 0xdf2020, 0x0a0a0a);
        addSpawn(EntityIoprey.class, Config.iopreySpawnChance, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SWAMP});

        registerMobWithEgg(EntityGreatJaggi.class, "greatjaggi", 0xe2aa72, 0x9f40ff);
        registerMobWithEgg(EntityJaggi.class, "jaggi", 0xd56a00, 0xbf80ff);
        registerMobWithEgg(EntityJaggia.class, "jaggia", 0xff8000, 0x9f40ff);
        addSpawn(EntityGreatJaggi.class, Config.greatJaggiSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.PLAINS,
                BiomeDictionary.Type.BEACH});
        registerMobWithEgg(EntityVelocidrome.class, "velocidrome", 0x0080ff, 0x402000);
        registerMobWithEgg(EntityVelociprey.class, "velociprey", 0x0080ff, 0x402000);
        addSpawn(EntityVelocidrome.class, Config.velocidromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.FOREST,
                BiomeDictionary.Type.PLAINS});
        /*
        registerMobWithEgg(EntityGiadrome.class, "giadrome", 0x9fbfdf, 0x476078);
        addSpawn(EntityGiadrome.class, Config.giadromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.MOUNTAIN,
                BiomeDictionary.Type.SNOWY});
        */
        registerMobWithEgg(EntityGendrome.class, "gendrome", 0x408040, 0x806040);
        registerMobWithEgg(EntityGenprey.class, "genprey", 0x408040, 0x806040);
        addSpawn(EntityGendrome.class, Config.gendromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SAVANNA,
                BiomeDictionary.Type.SANDY});
        /*
        registerMobWithEgg(EntityIondrome.class, "iodrome", 0xdf2020, 0x0a0a0a);
        addSpawn(EntityIodrome.class, Config.iodromeSpawnChance, 1, 1, new BiomeDictionary.Type[] {
                BiomeDictionary.Type.SWAMP});
        */

        registerEntity(EntitySpit.class, "spit");

        if(isClientSide)
            regClientStuff();
    }

    @SideOnly(Side.CLIENT)
    private static void regClientStuff()
    {
        registerRender(EntityAptonoth.class, RenderAptonoth.FACTORY);
        registerRender(EntityApceros.class, RenderApceros.FACTORY);
        registerRender(EntityAltaroth.class, RenderAltaroth.FACTORY);
        registerRender(EntityPopo.class, RenderPopo.FACTORY);
        registerRender(EntityKelbi.class, RenderKelbi.FACTORY);
        registerRender(EntityGargwa.class, RenderGargwa.FACTORY);
        registerRender(EntityJaggi.class, RenderJaggi.FACTORY);
        registerRender(EntityJaggia.class, RenderJaggia.FACTORY);
        registerRender(EntityVelociprey.class, RenderVelociprey.FACTORY);
        registerRender(EntityGiaprey.class, RenderGiaprey.FACTORY);
        registerRender(EntityGenprey.class, RenderGenprey.FACTORY);
        registerRender(EntityIoprey.class, RenderIoprey.FACTORY);

        registerRender(EntityGreatJaggi.class, RenderGreatJaggi.FACTORY);
        registerRender(EntityVelocidrome.class, RenderVelocidrome.FACTORY);
        //registerRender(EntityGiadrome.class, RenderGiadrome.FACTORY);
        registerRender(EntityGendrome.class, RenderGendrome.FACTORY);
        //registerRender(EntityIodrome.class, RenderIodrome.FACTORY);

        registerRender(EntitySpit.class, RenderSpit.FACTORY);
    }
}
