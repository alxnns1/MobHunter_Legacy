package com.alxnns1.mobhunter;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.StatCollector;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mark on 21/04/2016.
 */
public class EntityEventHandler
{
    private static ArrayList<Object[]> mobDrops = new ArrayList<Object[]>();

    /**
     * Adds a drop to a mob
     * @param mobName Name of the mob which will drop item
     * @param item The item which will drop
     * @param chance Chance that the item will be able to drop (between 0 and 1)
     */
    public static void addMobDrop(String mobName, Item item, float chance)
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
    public static void addMobDrop(String mobName, Item item, int qtyMin, int qtyMax, float chance)
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
        LogHelper.info("Mob " + event.entityLiving.getName() + " died!");
        //This is called every time a LivingEntityBase dies
        Random rand = new Random();
        //Checks the dead entity against the ones in the list
        for(Object[] o : mobDrops)
        {
            //This all checks if the entity's localised name or unlocalised name matches the name in the list
            EntityLivingBase entity = event.entityLiving;
            String s = EntityList.getEntityString(entity);
            if (s == null)
                s = "generic";
            String mobUnlocName = "entity." + s + ".name";
            String mobName = StatCollector.translateToLocal(mobUnlocName);

            if((mobName.equals(o[0]) || mobUnlocName.equals(o[0])) && rand.nextFloat() < (Float) o[4])
            {
                LogHelper.info("Mob can drop " + ((Item)o[1]).getUnlocalizedName());
                //Can spawn mob drop!
                int min = (Integer) o[2];
                int max = (Integer) o[3];
                int randQty = rand.nextInt(max) + min;
                if(randQty > 0)
                {
                    event.entityLiving.dropItem((Item) o[1], randQty);
                    LogHelper.info("Mob dropped " + randQty);
                }
            }
        }
    }
}
