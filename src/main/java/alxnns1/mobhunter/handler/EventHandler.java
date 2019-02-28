package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.entity.IScaledMob;
import alxnns1.mobhunter.entity.monsters.EntityGreatJaggi;
import alxnns1.mobhunter.entity.monsters.EntityMHBirdWyvern;
import alxnns1.mobhunter.init.MHAdvancementTriggers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mark on 21/04/2016.
 */
@Mod.EventBusSubscriber
public class EventHandler
{
	/** Any registered mob which extends EntityLiving */
	public static final String ALL_WILDCARD = "/*";
	/** Any vanilla mob */
	public static final String ALL_VANILLA_WILDCARD = "/*v";
	/** Any vanilla aggressive mob */
	public static final String AGGRESSIVE_WILDCARD = "/a";
	/** Any vanilla passive mob */
	public static final String PASSIVE_WILDCARD = "/p";

	private static final String[] PASSIVE_NAMES = {
			"MushroomCow", "Villager", "VillagerGolem", "SnowMan", "Pig", "Sheep",
			"Cow", "Chicken", "Squid", "Wolf", "Ocelot", "Cat", "Bat", "EntityHorse", "horse",
			"donkey", "mule", "skeletonhorse", "zombiehorse", "Rabbit"
	};
	private static final String[] AGGRESIVE_NAMES = {
			"Creeper", "Skeleton", "Spider", "Giant", "Zombie", "Slime", "Ghast",
			"PigZombie", "Enderman", "Endermite", "Silverfish", "CaveSpider", "Blaze",
			"LavaSlime", "EnderDragon", "WitherBoss", "Witch", "Guardian", "KillerBunny",
			"Shulker"
	};

	private static ArrayList<Object[]> mobDrops = new ArrayList<Object[]>();

	private static boolean checkMobName(boolean isAggressive, String name)
	{
		String[] N;
		if(isAggressive)
			N = AGGRESIVE_NAMES;
		else
			N = PASSIVE_NAMES;
		for(String n : N)
			if(name.equals(n))
				return true;
		return false;
	}

	/**
	 * Adds a drop to a mob
	 *
	 * @param mobName Name of the mob which will drop item
	 * @param item The item which will drop
	 * @param chance Chance that the item will be able to drop (between 0 and 1)
	 */
	public static void addMobDrop(String mobName, ItemStack item, float chance)
	{
		addMobDrop(mobName, item, 1, 1, chance);
	}

	/**
	 * Adds a drop to a mob
	 *
	 * @param mobName Name of the mob which will drop item
	 * @param item The item which will drop
	 * @param qtyMin Min amount of the item will drop
	 * @param qtyMax Max amount of the item will drop
	 * @param chance Chance that the item will be able to drop at all (between 0 and 1)
	 */
	public static void addMobDrop(String mobName, ItemStack item, int qtyMin, int qtyMax, float chance)
	{
		if(chance <= 0)
			chance = 0.01f;
		else if(chance > 1)
			chance = 1f;
		if(qtyMin > qtyMax)
		{
			int temp = qtyMin;
			qtyMin = qtyMax;
			qtyMax = temp;
		}
		else if(qtyMin == 0 && qtyMax == 0)
			qtyMax = 1;

		mobDrops.add(new Object[]{mobName, item, qtyMin, qtyMax, chance});
	}

	@SubscribeEvent
	public static void mobDeath(LivingDropsEvent event)
	{
		EntityLivingBase entity = event.getEntityLiving();
		Random rand = entity.getEntityWorld().rand;

		//Checks the dead entity against the ones in the list
		for(Object[] o : mobDrops)
		{
			//This all checks if the entity's localised name or unlocalised name matches the name in the list
			//EntityLivingBase entity = event.entityLiving;
			String s = EntityList.getEntityString(entity);
			if(s == null)
				s = "generic";
			String mobUnlocName = "entity." + s + ".name";
			String mobName = new TextComponentTranslation(mobUnlocName).getUnformattedText();

			if(rand.nextFloat() < (Float) o[4])
			{
				if((o[0].equals(PASSIVE_WILDCARD) && checkMobName(false, s)) ||        //Passive vanilla mob
						(o[0].equals(AGGRESSIVE_WILDCARD) && checkMobName(true, s)) ||      //Aggressive vanilla mob
						(o[0].equals(ALL_VANILLA_WILDCARD) && (checkMobName(false, s) || checkMobName(true, s))) || //Any vanilla mob
						(o[0].equals(ALL_WILDCARD) && entity instanceof EntityLiving) ||    //Any registered mob
						((mobName.equals(o[0]) || mobUnlocName.equals(o[0]))))              //Exact mob
				{
					//Can spawn mob drop!
					int min = (Integer) o[2];
					int max = (Integer) o[3];
					int randQty = rand.nextInt(max) + min;
					if(randQty > 0)
						event.getEntityLiving().entityDropItem((ItemStack) o[1], 0);
				}
			}
		}
	}

	//TODO: First sword advancement
    /*
    @SubscribeEvent
    public static void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
        Item item = event.crafting.getItem();
        EntityPlayer player = event.player;
        if(item instanceof ItemMHSword)
            player.addStat(MHAchievements.firstSword);
    }
    */

    /*
    @SubscribeEvent
    public void mobSpawn(LivingSpawnEvent event)
    {
        EntityLivingBase entity = event.entityLiving;
        if(entity instanceof EntityMHBirdWyvern || entity instanceof EntityMHHerbivore || entity instanceof EntityMHNeopteron)
        {
            float scale = -1;
            if(entity instanceof EntityMHBirdWyvern) scale = ((EntityMHBirdWyvern) entity).getScale();
            if(entity instanceof EntityMHHerbivore) scale = ((EntityMHHerbivore) entity).getScale();
            if(entity instanceof EntityMHNeopteron) scale = ((EntityMHNeopteron) entity).getScale();
            //MobHunter.LOGGER.info(entity.getDisplayName().getUnformattedText() + ", " + entity.getPosition().toString() + " (" + entity.getEntityId() + ")");
        }
    }
    */

	@SubscribeEvent
	public static void entityKilled(LivingDeathEvent event)
	{
		EntityLivingBase entity = event.getEntityLiving();
		Entity entitySource = event.getSource().getTrueSource();

		if(event.getSource() instanceof EntityDamageSource && entitySource instanceof EntityPlayerMP)
		{
			float scale = -1f;

			if(entity instanceof EntityGreatJaggi)
				scale = ((EntityGreatJaggi) entity).getScale() * 1.5f;
			else if(entity instanceof IScaledMob)
				scale = ((IScaledMob) entity).getScale();

			//Small and Large Crown Advancements
			EntityPlayer player = (EntityPlayer) entitySource;
			if(scale != -1f && entity instanceof EntityMHBirdWyvern)
			{
				MHAdvancementTriggers.smallCrown.trigger((EntityPlayerMP) player, scale);
				MHAdvancementTriggers.largeCrown.trigger((EntityPlayerMP) player, scale);
			}

			//TODO: Boss Monster Achievements
            /*
            if(entity instanceof EntityGreatJaggi) player.addStat(MHAchievements.greatJaggi);
            if(entity instanceof EntityVelocidrome) player.addStat(MHAchievements.velocidrome);
            if(entity instanceof EntityGendrome) player.addStat(MHAchievements.gendrome);
            */
            /*
            if(entity instanceof EntityIodrome) player.addStat(MHAchievements.iodrome);
            */
		}
	}
}
