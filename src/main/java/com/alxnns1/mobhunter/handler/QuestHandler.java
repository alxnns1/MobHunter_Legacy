package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.capability.quest.*;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Iterator;

/**
 * Created by Mark on 12/01/2017.
 */
@Mod.EventBusSubscriber
public class QuestHandler
{
    private static final ResourceLocation questRL = new ResourceLocation(Reference.MOD_ID, "_Quests");

    /**
     * Get the Quest Capability from the player
     */
    public static IQuest getQuestCapability(EntityPlayer player)
    {
        return player.getCapability(MHCapabilities.QUESTS, null);
    }

    /**
     * Checks if the player has the Quest Capability
     */
    public static boolean hasQuestCapability(EntityPlayer player)
    {
        return player.hasCapability(MHCapabilities.QUESTS, null);
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        //Attach our capability to all players
        Entity entity = event.getObject();
        if(entity instanceof EntityPlayer && !hasQuestCapability((EntityPlayer) entity))
            event.addCapability(questRL, new CapabilityQuestProvider());
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event)
    {
        //Send the client capability details
        if(event.player instanceof EntityPlayerMP && hasQuestCapability(event.player))
            getQuestCapability(event.player).dataChanged((EntityPlayerMP) event.player, EnumQuestDataChange.ALL);
    }

    @SubscribeEvent
    public void onClonePlayer(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
    {
        //Copy capability on player death to new player
        if(event.isWasDeath() && (event.getEntityPlayer() instanceof EntityPlayerMP))
        {
            EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();
            getQuestCapability(player).deserializeNBT(getQuestCapability(event.getOriginal()).serializeNBT());
            getQuestCapability(player).dataChanged(player, EnumQuestDataChange.ALL);
        }
    }

    //Removed these since I'm now using a submit button for quests that require items
    /*
    @SubscribeEvent
    public void onCrafted(PlayerEvent.ItemCraftedEvent event)
    {
        //Add quest progress for Crafting quests
        if(!(event.player instanceof EntityPlayerMP))
            return;
        IQuest quest = getQuestCapability(event.player);
        if(quest.getCurrentQuest() != null && quest.getCurrentQuest().getQuest().getQuestType() == EnumQuestType.CRAFTING)
            quest.progressQuest((EntityPlayerMP) event.player, event.crafting);
    }

    @SubscribeEvent
    public void onPickup(EntityItemPickupEvent event)
    {
        //Add quest progress for Gathering quests
        if(!(event.getEntityPlayer() instanceof EntityPlayerMP))
            return;
        IQuest quest = getQuestCapability(event.getEntityPlayer());
        if(quest.getCurrentQuest() != null && quest.getCurrentQuest().getQuest().getQuestType() == EnumQuestType.GATHERING)
            quest.progressQuest((EntityPlayerMP) event.getEntityPlayer(), event.getItem().getEntityItem());
    }
    */

    @SubscribeEvent
    public void entityKilled(LivingDeathEvent event)
    {
        //Add quest progress for Hunting quests
        if(!(event.getSource().getSourceOfDamage() instanceof EntityPlayerMP)) return;
        EntityPlayerMP player = (EntityPlayerMP) event.getSource().getSourceOfDamage();
        IQuest quest = getQuestCapability(player);
        if(quest.getCurrentQuest() != null && quest.getCurrentQuest().getQuest().getQuestType() == EnumQuestType.HUNTING)
            quest.progressQuest(player, new EntityStack(EntityList.getEntityString(event.getEntityLiving()), 1));
    }

    private long nextQuestCheck = 0;

    @SubscribeEvent
    public void questTick(TickEvent.PlayerTickEvent event)
    {
        long worldTime = event.player.world.getTotalWorldTime();
        if(event.player instanceof EntityPlayerMP && event.phase == TickEvent.Phase.END && worldTime >= nextQuestCheck)
        {
            nextQuestCheck = worldTime + 200; //10s
            EntityPlayerMP player = (EntityPlayerMP) event.player;

            //Check player quests and remove them if they've gone over the time limit
            IQuest playerQuest = getQuestCapability(player);
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
