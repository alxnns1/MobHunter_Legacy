package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.entity.*;
import com.alxnns1.mobhunter.init.MHAchievements;
import com.alxnns1.mobhunter.item.ItemMHSword;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mark on 21/04/2016.
 */
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

        mobDrops.add(new Object[] {mobName, item, qtyMin, qtyMax, chance});
    }

    @SubscribeEvent
    public void mobDeath(LivingDropsEvent event)
    {
        EntityLivingBase entity = event.getEntityLiving();

        //This is called every time a LivingEntityBase dies
        Random rand = new Random();
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

            if(rand.nextFloat() < (Float) o[4]) {
                if(     (o[0].equals(PASSIVE_WILDCARD) && checkMobName(false, s)) ||        //Passive vanilla mob
                        (o[0].equals(AGGRESSIVE_WILDCARD) && checkMobName(true, s)) ||      //Aggressive vanilla mob
                        (o[0].equals(ALL_VANILLA_WILDCARD) && (checkMobName(false, s) || checkMobName(true, s))) || //Any vanilla mob
                        (o[0].equals(ALL_WILDCARD) && entity instanceof EntityLiving) ||    //Any registered mob
                        ((mobName.equals(o[0]) || mobUnlocName.equals(o[0]))))              //Exact mob
                {
                    //Can spawn mob drop!
                    int min = (Integer) o[2];
                    int max = (Integer) o[3];
                    int randQty = rand.nextInt(max) + min;
                    if (randQty > 0)
                        event.getEntityLiving().entityDropItem((ItemStack) o[1], 0);
                }
            }
        }
    }

    @SubscribeEvent
    public void onCrafting(PlayerEvent.ItemCraftedEvent event)
    {
        Item item = event.crafting.getItem();
        EntityPlayer player = event.player;
        if(item instanceof ItemMHSword)
            player.addStat(MHAchievements.firstSword);
    }

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
            //LogHelper.info(entity.getDisplayName().getUnformattedText() + ", " + entity.getPosition().toString() + " (" + entity.getEntityId() + ")");
        }
    }
    */

    @SubscribeEvent
    public void entityKilled(LivingDeathEvent event)
    {
        EntityLivingBase entity = event.getEntityLiving();

        float scale = -1f;
        if(entity instanceof EntityGreatJaggi)
            scale = ((EntityGreatJaggi)entity).getScale()*1.5f;
        else if(entity instanceof EntityMHBirdWyvern)
            scale = ((EntityMHBirdWyvern)entity).getScale();
        else if(entity instanceof EntityMHHerbivore)
            scale = ((EntityMHHerbivore)entity).getScale();
        else if(entity instanceof EntityMHNeopteron)
            scale = ((EntityMHNeopteron)entity).getScale();

        if(event.getSource() instanceof EntityDamageSource && event.getSource().getSourceOfDamage() instanceof EntityPlayer)
        {
            //Small and Large Crown Achievements
            EntityPlayer player = (EntityPlayer) event.getSource().getEntity();
            if(scale != -1f)
            {
                if(scale < 0.84f)
                    player.addStat(MHAchievements.smallCrown);
                else if(scale > 1.19f)
                    player.addStat(MHAchievements.largeCrown);
            }

            //Boss Monster Achievements
            if(entity instanceof EntityGreatJaggi) player.addStat(MHAchievements.greatJaggi);
            if(entity instanceof EntityVelocidrome) player.addStat(MHAchievements.velocidrome);
            /*
            if(entity instanceof EntityGendrome) player.addStat(MHAchievements.gendrome);
            if(entity instanceof EntityIodrome) player.addStat(MHAchievements.iodrome);
            */

            //Hunter Rank Incrementation
            //TODO: Uncomment Hunter Rank Incrementation (And finish)
            //HunterRankProvider.get(player).changeHunterRankBy(player, AMOUNT);
        }
    }

    //TODO: Uncomment Hunter Rank Events Handlers
    /*
    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent.Entity event)
    {
        if(event.getEntity() instanceof EntityPlayer && !event.getEntity().hasCapability(HunterRankProvider.HUNTER_RANK, null))
            event.addCapability(new ResourceLocation(Reference.MOD_ID, " Player Hunter Rank"), new HunterRankProvider());
    }

    @SubscribeEvent
    public void onClonePlayer(Clone event)
    {
        if(event.isWasDeath())
        {
            EntityPlayer player = event.getEntityPlayer();
            HunterRankProvider.get(player).loadNBT(HunterRankProvider.get(event.getOriginal()).saveNBT());
            HunterRankProvider.get(player).dataChanged(player);
        }
    }
    */
}
