package alxnns1.mobhunter.init;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.entity.EntitySpit;
import alxnns1.mobhunter.entity.RenderSpit;
import alxnns1.mobhunter.entity.monsters.*;
import alxnns1.mobhunter.entity.monsters.render.*;
import alxnns1.mobhunter.reference.MHConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Mark on 04/05/2016.
 */
public class MHEntities
{
	private static int modEntityID = 0;
	public static Set<EntityEntry> ENTITIES = new HashSet<>();
	public static List<String> ENTITY_NAMES = new ArrayList<String>();

	private static <T extends Entity> void addEntity(Class<T> entityClass, String name, int eggPrimary, int eggSecondary,
	                                                 int spawnWeight, int spawnMin, int spawnMax, BiomeDictionary.Type... biomeTypes)
	{
		ENTITIES.add(createBuilder(entityClass, name)
				.egg(eggPrimary, eggSecondary)
				.spawn(EnumCreatureType.CREATURE, spawnWeight, spawnMin, spawnMax, getBiomes(biomeTypes))
				.build());
	}

	private static <T extends Entity> void addEntity(Class<T> entityClass, String name, int eggPrimary, int eggSecondary)
	{
		ENTITIES.add(createBuilder(entityClass, name)
				.egg(eggPrimary, eggSecondary)
				.build());
	}

	private static <T extends Entity> void addEntity(Class<T> entityClass, String name)
	{
		ENTITIES.add(createBuilder(entityClass, name).build());
	}

	private static EntityEntryBuilder<Entity> createBuilder(Class<? extends Entity> entityClass, String name)
	{
		String entityName = String.format("%s.%s", MobHunter.MOD_ID, name);
		ENTITY_NAMES.add(entityName);
		return EntityEntryBuilder.create()
				.entity(entityClass)
				.name(entityName)
				.id(new ResourceLocation(MobHunter.MOD_ID, name), modEntityID++)
				.tracker(64, 20, false);
	}

	private static Set<Biome> getBiomes(BiomeDictionary.Type... biomeTypes)
	{
		Set<Biome> biomes = new HashSet<>();
		for(BiomeDictionary.Type type : biomeTypes)
			biomes.addAll(BiomeDictionary.getBiomes(type));
		return biomes;
	}

	private static <T extends Entity> void registerRender(Class<T> entityClass, IRenderFactory<? super T> renderFactory)
	{
		RenderingRegistry.registerEntityRenderingHandler(entityClass, renderFactory);
	}

	public static void init()
	{
		addEntity(EntityAptonoth.class, "aptonoth", 0x7f6d59, 0x382c1e,
				MHConfig.SPAWN_CHANCES.aptonothSpawnChance, 3, 5,
				BiomeDictionary.Type.PLAINS);
		addEntity(EntityApceros.class, "apceros", 0x664019, 0xccb399,
				MHConfig.SPAWN_CHANCES.apcerosSpawnChance, 3, 5,
				BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SANDY);
		addEntity(EntityAltaroth.class, "altaroth", 0x8fbf60, 0xbfbf60,
				MHConfig.SPAWN_CHANCES.altarothSpawnChance, 3, 5,
				BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.JUNGLE, BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS);
		addEntity(EntityPopo.class, "popo", 0x402a00, 0x403400,
				MHConfig.SPAWN_CHANCES.popoSpawnChance, 3, 5,
				BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SNOWY);
		addEntity(EntityKelbi.class, "kelbi", 0x20402b, 0xbfbf8f,
				MHConfig.SPAWN_CHANCES.kelbiSpawnChance, 3, 5,
				BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS);
		addEntity(EntityGargwa.class, "gargwa", 0x804000, 0x0000ff,
				MHConfig.SPAWN_CHANCES.gargwaSpawnChance, 3, 5,
				BiomeDictionary.Type.JUNGLE);

		addEntity(EntityGreatJaggi.class, "greatjaggi", 0xe2aa72, 0x9f40ff,
				MHConfig.SPAWN_CHANCES.greatJaggiSpawnChance, 1, 1,
				BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.BEACH);
		addEntity(EntityJaggi.class, "jaggi", 0xd56a00, 0xbf80ff);
		addEntity(EntityJaggia.class, "jaggia", 0xff8000, 0x9f40ff);
		addEntity(EntityVelocidrome.class, "velocidrome", 0x0080ff, 0x402000,
				MHConfig.SPAWN_CHANCES.velocidromeSpawnChance, 1, 1,
				BiomeDictionary.Type.FOREST, BiomeDictionary.Type.PLAINS);
		addEntity(EntityVelociprey.class, "velociprey", 0x0080ff, 0x402000);
        /*
        addEntity(EntityGiadrome.class, "giadrome", 0x9fbfdf, 0x476078,
                Config.giadromeSpawnChance, 1, 1,
                BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SNOWY);
        */
		addEntity(EntityGiaprey.class, "giaprey", 0x9fbfdf, 0x476078,
				MHConfig.SPAWN_CHANCES.giapreySpawnChance, 3, 5,
				BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.SNOWY);
		addEntity(EntityGendrome.class, "gendrome", 0x408040, 0x806040,
				MHConfig.SPAWN_CHANCES.gendromeSpawnChance, 1, 1,
				BiomeDictionary.Type.SAVANNA, BiomeDictionary.Type.SANDY);
		addEntity(EntityGenprey.class, "genprey", 0x408040, 0x806040);
        /*
        addEntity(EntityIondrome.class, "iodrome", 0xdf2020, 0x0a0a0a,
                Config.iodromeSpawnChance, 1, 1,
                BiomeDictionary.Type.SWAMP);
        */
		addEntity(EntityIoprey.class, "ioprey", 0xdf2020, 0x0a0a0a,
				MHConfig.SPAWN_CHANCES.iopreySpawnChance, 3, 5,
				BiomeDictionary.Type.SWAMP);

		addEntity(EntitySpit.class, "spit");
	}

	@SideOnly(Side.CLIENT)
	public static void regRenders()
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

	public static Set<EntityEntry> getEntities()
	{
		if(ENTITIES.isEmpty()) init();
		return ENTITIES;
	}
}
