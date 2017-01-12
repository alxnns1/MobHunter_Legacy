package com.alxnns1.mobhunter.quest;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.quest.capability.CapabilityQuestProvider;
import com.alxnns1.mobhunter.quest.capability.IQuest;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
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

    public static IQuest getQuestCapability(EntityPlayer player)
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
        IQuest quest = getQuestCapability(event.player);
        if(quest.getCurrentQuest().getQuestType() == EnumQuestType.CRAFTING)
            ;//TODO: Progress crafting quest
    }

    @SubscribeEvent
    public void onPickup(PlayerEvent.ItemPickupEvent event)
    {
        IQuest quest = getQuestCapability(event.player);
        if(quest.getCurrentQuest().getQuestType() == EnumQuestType.GATHERING)
            ;//TODO: Progress gathering quest
    }

    @SubscribeEvent
    public void entityKilled(LivingDeathEvent event)
    {
        if(!(event.getSource().getSourceOfDamage() instanceof EntityPlayer)) return;
        EntityPlayer player = (EntityPlayer) event.getSource().getSourceOfDamage();
        IQuest quest = getQuestCapability(player);
        if(quest.getCurrentQuest().getQuestType() == EnumQuestType.HUNTING)
            ;//TODO: Progress hunting quest
    }

    @SubscribeEvent
    public void questTick(TickEvent.PlayerTickEvent event)
    {
        long worldTime = event.player.world.getWorldTime();
        EntityPlayer player = event.player;
        //Only check once every minute
        if(event.phase == TickEvent.Phase.END && worldTime%1200 == 0)
        {
            //Check player quests and remove them if they've gone over the time limit
            IQuest playerQuest = getQuestCapability(player);
            MHQuest quest = playerQuest.getCurrentQuest();
            if(quest != null && quest.hasQuestExpired(worldTime))
            {
                //Remove quest and notify player
                player.sendMessage(new TextComponentString(TextFormatting.RED + "You have run out of time to complete the quest '" + quest.getLocalName() + "'!"));
                if(quest.getPointsPenalty() > 0)
                    player.sendMessage(new TextComponentString(TextFormatting.RED + "" + quest.getPointsPenalty() + " HR points have been deducted as a penalty."));
                playerQuest.removeQuest(player);
            }
        }
    }
}
