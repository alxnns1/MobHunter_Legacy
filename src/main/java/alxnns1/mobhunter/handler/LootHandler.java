package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.Reference;
import net.minecraft.item.Item;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;

/**
 * Created by Mark on 04/11/2016.
 */
@Mod.EventBusSubscriber
public class LootHandler
{
    private static void addLoot(LootPool pool, Item item, int weight)
    {
        pool.addEntry(new LootEntryItem(item, weight, 0, new LootFunction[0], new LootCondition[0], Reference.MOD_ID + item.getUnlocalizedName()));
    }

    @SubscribeEvent
    public static void addLoot(LootTableLoadEvent event)
    {
        if(event.getName().equals(LootTableList.GAMEPLAY_FISHING_FISH))
        {
            //Add fishable fish
            LootPool pool = event.getTable().getPool("main");
            for(Map.Entry<Item, Integer> entry : MHItems.FISHABLE.entrySet())
                addLoot(pool, entry.getKey(), entry.getValue());
        }
    }
}
