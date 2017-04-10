package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.capability.ICapability;
import com.alxnns1.mobhunter.capability.quest.*;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Iterator;

/**
 * Created by Mark on 10/04/2017.
 */
@Mod.EventBusSubscriber
public class CapabilityHandler
{
    private static ICapability getDefaultICapability(Capability capability)
    {
        Object c = capability.getDefaultInstance();
        if(!(c instanceof ICapability))
        {
            LogHelper.error("A capability isn't an instance of ICapability! -> " + capability.getName());
            return null;
        }
        return (ICapability) c;
    }

    private static ICapability getICapability(Entity entity, Capability capability)
    {
        Object object = entity.getCapability(capability, null);
        return object == null || !(object instanceof ICapability) ? null : (ICapability) object;
    }

    @SubscribeEvent
    public static void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        //Attach our capabilities to all players
        Entity entity = event.getObject();
        if(entity instanceof EntityPlayer)
        {
            for(Capability cap : MHCapabilities.getCapabilities())
            {
                ICapability icap = getDefaultICapability(cap);
                if(icap == null) continue;
                if(!entity.hasCapability(cap, null))
                    event.addCapability(icap.getKey(), icap.getProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event)
    {
        //Send the client capability details
        if(event.player instanceof EntityPlayerMP)
        {
            EntityPlayerMP player = (EntityPlayerMP) event.player;
            for(Capability cap : MHCapabilities.getCapabilities())
            {
                ICapability icap = getICapability(player, cap);
                if(icap != null) icap.dataChanged(player);
            }
        }
    }

    @SubscribeEvent
    public static void onClonePlayer(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
    {
        //Copy capability on player death to new player
        if(event.isWasDeath() && (event.getEntityPlayer() instanceof EntityPlayerMP))
        {
            EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();
            for(Capability cap : MHCapabilities.getCapabilities())
            {
                ICapability oldicap = getICapability(event.getOriginal(), cap);
                ICapability icap = getICapability(player, cap);
                if(oldicap == null || icap == null) continue;
                icap.deserializeNBT(oldicap.serializeNBT());
                icap.dataChanged(player);
            }
        }
    }


    /*
        <<<<<<<<<<< QUESTS >>>>>>>>>>
     */


    private static long nextQuestCheck = 0;

    @SubscribeEvent
    public static void entityKilled(LivingDeathEvent event)
    {
        //Add quest progress for Hunting quests
        if(!(event.getSource().getSourceOfDamage() instanceof EntityPlayerMP)) return;
        EntityPlayerMP player = (EntityPlayerMP) event.getSource().getSourceOfDamage();
        IQuest quest = player.getCapability(MHCapabilities.QUESTS, null);
        if(quest.getCurrentQuest() != null && quest.getCurrentQuest().getQuest().getQuestType() == EnumQuestType.HUNTING)
            quest.progressQuest(player, new EntityStack(EntityList.getEntityString(event.getEntityLiving()), 1));
    }

    @SubscribeEvent
    public static void questTick(TickEvent.PlayerTickEvent event)
    {
        long worldTime = event.player.world.getTotalWorldTime();
        if(event.player instanceof EntityPlayerMP && event.phase == TickEvent.Phase.END && worldTime >= nextQuestCheck)
        {
            nextQuestCheck = worldTime + 200; //10s
            EntityPlayerMP player = (EntityPlayerMP) event.player;

            //Check player quests and remove them if they've gone over the time limit
            IQuest playerQuest = player.getCapability(MHCapabilities.QUESTS, null);
            MHQuestObject quest = playerQuest.getCurrentQuest();
            if(quest != null && quest.hasQuestExpired(worldTime))
            {
                //Remove quest and notify player
                player.sendMessage(new TextComponentString(TextFormatting.RED + "You have run out of time to complete the quest '" + quest.getQuest().getLocalName() + "'!"));
                if(quest.getQuest().getPointsPenalty() > 0)
                    player.sendMessage(new TextComponentString(TextFormatting.RED + "" + quest.getQuest().getPointsPenaltyText() + " have been deducted as a penalty."));
                playerQuest.clearQuest();
                playerQuest.dataChanged(player, EnumQuestDataChange.CURRENT);
            }

            //Check player's quests on cooldown and remove them from the array if passed their cooldown
            boolean flag = false;
            Iterator<MHQuestCooldown> questIterator = playerQuest.getCooldownQuests().iterator();
            while(questIterator.hasNext())
            {
                if(questIterator.next().isCoolEnough(worldTime))
                {
                    flag = true;
                    questIterator.remove();
                }
            }
            if(flag)
                playerQuest.dataChanged(player, EnumQuestDataChange.COOLDOWN);
        }
    }
}
