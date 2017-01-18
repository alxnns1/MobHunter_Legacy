package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.capability.hunterRank.CapabilityHunterRankProvider;
import com.alxnns1.mobhunter.capability.hunterRank.EnumHRDataChange;
import com.alxnns1.mobhunter.capability.hunterRank.IHunterRank;
import com.alxnns1.mobhunter.init.MHCapabilities;
import com.alxnns1.mobhunter.reference.Reference;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import java.util.*;

/**
 * Created by Mark on 17/01/2017.
 */
public class HunterRankHandler
{
    private static final ResourceLocation hunterRankRL = new ResourceLocation(Reference.MOD_ID, "_HunterRank");
    private static Minecraft mc = Minecraft.getMinecraft();

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

    private Map<UUID, IHunterRank> playerRankCache = new HashMap<UUID, IHunterRank>();
    //This is copied from GuiPlayerTabOverlay so we can get the same ordered player list
    private static final Ordering<NetworkPlayerInfo> ENTRY_ORDERING = Ordering.from(new Comparator<NetworkPlayerInfo>()
    {
        @Override
        public int compare(NetworkPlayerInfo o1, NetworkPlayerInfo o2)
        {
            ScorePlayerTeam scoreplayerteam = o1.getPlayerTeam();
            ScorePlayerTeam scoreplayerteam1 = o2.getPlayerTeam();
            return ComparisonChain.start().compareTrueFirst(o1.getGameType() != GameType.SPECTATOR, o2.getGameType() != GameType.SPECTATOR).compare(scoreplayerteam != null ? scoreplayerteam.getRegisteredName() : "", scoreplayerteam1 != null ? scoreplayerteam1.getRegisteredName() : "").compare(o1.getGameProfile().getName(), o2.getGameProfile().getName()).result();
        }
    });

    /**
     * Draws the text centered on the given position
     */
    private static void drawCenteredOnPos(FontRenderer fr, String text, int xPos, int yPos)
    {
        fr.drawStringWithShadow(text, xPos - (fr.getStringWidth(text) / 2), yPos, 0xFFFFFF);
    }

    @SubscribeEvent
    public void renderHR(RenderGameOverlayEvent.Post event)
    {
        switch(event.getType())
        {
            case TEXT:
                //Just for testing at least atm
                EntityPlayer player = mc.player;
                IHunterRank hunterRank = player.getCapability(MHCapabilities.HUNTER_RANK, null);
                if(hunterRank == null) return;

                //Render hunter rank
                FontRenderer fontRenderer = mc.fontRendererObj;
                ScaledResolution res = event.getResolution();
                int xMid = res.getScaledWidth() / 2;
                int y = res.getScaledHeight() - 80;

                drawCenteredOnPos(fontRenderer, "HR: " + hunterRank.getRank(), xMid, y);
                drawCenteredOnPos(fontRenderer, "Progress Points: " + hunterRank.getProgressPoints(), xMid, y + 10);
                break;
            //TODO: Sort out something for rendering on the player list
            /*
            case PLAYER_LIST:
                //Draw HR on the player list next to the player's names
                NetHandlerPlayClient nethandlerplayclient = mc.player.connection;
                List<NetworkPlayerInfo> list = ENTRY_ORDERING.sortedCopy(nethandlerplayclient.getPlayerInfoMap());

                break;
            */
        }
    }
}
