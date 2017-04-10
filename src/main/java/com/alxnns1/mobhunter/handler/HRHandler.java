package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.capability.hunterRank.CapabilityHunterRankProvider;
import com.alxnns1.mobhunter.capability.hunterRank.EnumHRDataChange;
import com.alxnns1.mobhunter.capability.hunterRank.IHunterRank;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

/**
 * Created by Mark on 17/01/2017.
 */
@Mod.EventBusSubscriber
public class HRHandler
{
    private static final ResourceLocation hunterRankRL = new ResourceLocation(Reference.MOD_ID, "_HunterRank");

    /**
     * Get the Hunter Rank Capability from the player
     */
    public static IHunterRank getHunterRankCapability(EntityPlayer player)
    {
        return player.getCapability(MHCapabilities.HUNTER_RANK, null);
    }

    /**
     * Checks if the player has the Hunter Rank Capability
     */
    public static boolean hasHunterRankCapability(EntityPlayer player)
    {
        return player.hasCapability(MHCapabilities.HUNTER_RANK, null);
    }

    @SubscribeEvent
    public void attachCapability(AttachCapabilitiesEvent<Entity> event)
    {
        //Attach our capability to all players
        Entity entity = event.getObject();
        if(entity instanceof EntityPlayer && !hasHunterRankCapability((EntityPlayer) entity))
            event.addCapability(hunterRankRL, new CapabilityHunterRankProvider());
    }

    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event)
    {
        //Send the client capability details
        if(event.player instanceof EntityPlayerMP && hasHunterRankCapability(event.player))
            getHunterRankCapability(event.player).dataChanged((EntityPlayerMP) event.player, EnumHRDataChange.ALL);
    }

    @SubscribeEvent
    public void onClonePlayer(net.minecraftforge.event.entity.player.PlayerEvent.Clone event)
    {
        //Copy capability on player death to new player
        if(event.isWasDeath() && (event.getEntityPlayer() instanceof EntityPlayerMP))
        {
            EntityPlayerMP player = (EntityPlayerMP) event.getEntityPlayer();
            getHunterRankCapability(player).deserializeNBT(getHunterRankCapability(event.getOriginal()).serializeNBT());
            getHunterRankCapability(player).dataChanged(player, EnumHRDataChange.ALL);
        }
    }
}
