package com.alxnns1.mobhunter.quest;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.quest.capability.CapabilityQuestProvider;
import com.alxnns1.mobhunter.quest.capability.IQuests;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

/**
 * Created by Mark on 12/01/2017.
 */
public class QuestHandler
{
    private static final ResourceLocation questRL = new ResourceLocation(Reference.MOD_ID, "_Quests");

    private static IQuests getQuestCapability(EntityPlayer player)
    {
        return player.getCapability(MobHunter.CAPABILITY_QUESTS, null);
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        Entity entity = event.getObject();
        if(entity instanceof EntityPlayer && !entity.hasCapability(MobHunter.CAPABILITY_QUESTS, null))
            event.addCapability(questRL, new CapabilityQuestProvider());
    }

    @SubscribeEvent
    public void onClonePlayer(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
    {
        //Copy capability on player death to new player
        if(event.isWasDeath())
        {
            EntityPlayer player = event.getEntityPlayer();
            getQuestCapability(player).deserializeNBT(getQuestCapability(event.getOriginal()).serializeNBT());
            getQuestCapability(player).dataChanged(player);
        }
    }

    @SubscribeEvent
    public void onCrafted(PlayerEvent.ItemCraftedEvent event)
    {

    }

    @SubscribeEvent
    public void onPickup(PlayerEvent.ItemPickupEvent event)
    {

    }

    @SubscribeEvent
    public void entityKilled(LivingDeathEvent event)
    {

    }

    @SubscribeEvent
    public void questTick(TickEvent.PlayerTickEvent event)
    {
        //Check player quests and remove them if they've gone over the time limit
        long worldTime = event.player.world.getWorldTime();
    }
}
