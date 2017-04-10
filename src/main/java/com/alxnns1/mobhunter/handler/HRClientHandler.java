package com.alxnns1.mobhunter.handler;

import com.alxnns1.mobhunter.capability.hunterRank.HunterRankProgression;
import com.alxnns1.mobhunter.capability.hunterRank.IHunterRank;
import com.alxnns1.mobhunter.reference.Reference;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.GameType;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by Mark on 10/04/2017.
 */
@Mod.EventBusSubscriber(Side.CLIENT)
public class HRClientHandler
{
    private static final ResourceLocation hunterRankBar = new ResourceLocation(Reference.MOD_ID, Reference.GUI_TEXTURE_DIR + "hr_bar.png");
    private static Minecraft mc = Minecraft.getMinecraft();

    private static Map<UUID, IHunterRank> playerRankCache = new HashMap<UUID, IHunterRank>();
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
    private static void drawCenteredOnPos(FontRenderer fr, String text, int xPos, int yPos, int colour)
    {
        fr.drawString(text, xPos - (fr.getStringWidth(text) / 2), yPos, colour);
    }

    private static void drawBorderedString(FontRenderer fr, String text, int xPos, int yPos, int colour)
    {
        fr.drawString(text, xPos + 1, yPos, 0);
        fr.drawString(text, xPos - 1, yPos, 0);
        fr.drawString(text, xPos, yPos + 1, 0);
        fr.drawString(text, xPos, yPos - 1, 0);
        fr.drawString(text, xPos, yPos, colour);
    }

    /**
     * Draws a textured rectangle using the texture currently bound to the TextureManager
     */
    public static void drawTexturedModalRect(float xCoord, float yCoord, int minU, int minV, int maxU, int maxV)
    {
        float f = 0.00390625F;
        float f1 = 0.00390625F;
        Tessellator tessellator = Tessellator.getInstance();
        VertexBuffer vertexbuffer = tessellator.getBuffer();
        vertexbuffer.begin(7, DefaultVertexFormats.POSITION_TEX);
        vertexbuffer.pos((double)(xCoord + 0.0F), (double)(yCoord + (float)maxV), 0d).tex((double)((float)(minU + 0) * 0.00390625F), (double)((float)(minV + maxV) * 0.00390625F)).endVertex();
        vertexbuffer.pos((double)(xCoord + (float)maxU), (double)(yCoord + (float)maxV), 0d).tex((double)((float)(minU + maxU) * 0.00390625F), (double)((float)(minV + maxV) * 0.00390625F)).endVertex();
        vertexbuffer.pos((double)(xCoord + (float)maxU), (double)(yCoord + 0.0F), 0d).tex((double)((float)(minU + maxU) * 0.00390625F), (double)((float)(minV + 0) * 0.00390625F)).endVertex();
        vertexbuffer.pos((double)(xCoord + 0.0F), (double)(yCoord + 0.0F), 0d).tex((double)((float)(minU + 0) * 0.00390625F), (double)((float)(minV + 0) * 0.00390625F)).endVertex();
        tessellator.draw();
    }

    @SubscribeEvent
    public static void renderInventoryHR(GuiScreenEvent.DrawScreenEvent.Post event)
    {
        if(event.getGui() instanceof GuiInventory)
        {
            EntityPlayer player = mc.player;
            IHunterRank hunterRank = HRHandler.getHunterRankCapability(player);
            if(hunterRank == null)
                return;

            FontRenderer fontRenderer = mc.fontRendererObj;
            int xMid = event.getGui().width / 2;
            int x = (event.getGui().width - 176) / 2;
            int y = (event.getGui().height - 166) / 2 - 5;
            int hr = hunterRank.getRank();
            int p = hunterRank.getProgressPoints();
            int pMax = HunterRankProgression.getProgressForRank(hr);

            int barWidth = 176;
            int barHeight = 6;
            int barX = xMid - barWidth / 2;
            int barPointsWidth = Math.round(((float) p / (float) pMax) * (float) barWidth);

            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            RenderHelper.disableStandardItemLighting();
            mc.getTextureManager().bindTexture(hunterRankBar);

            //Render progression bar
            drawTexturedModalRect(barX, y, 0, 0, barWidth, barHeight);
            GlStateManager.color(0.8F, 0.8F, 0F, 1F);
            drawTexturedModalRect(barX, y, 0, barHeight, barPointsWidth, barHeight * 2);
            GlStateManager.color(1f, 1f, 1f);
            //Render hunter rank
            drawBorderedString(fontRenderer, "HR: " + hr, x + 3, y - 4, 0xCECE02); //Bar colour: 0xA9A901

            RenderHelper.enableStandardItemLighting();
        }
    }

    /*
    @SubscribeEvent
    public static void renderHR(RenderGameOverlayEvent.Post event)
    {
        if(event.getType() == RenderGameOverlayEvent.ElementType.PLAYER_LIST)
        {
            //TODO: Sort out something for rendering on the player list
            //Draw HR on the player list next to the player's names
            NetHandlerPlayClient nethandlerplayclient = mc.player.connection;
            List<NetworkPlayerInfo> list = ENTRY_ORDERING.sortedCopy(nethandlerplayclient.getPlayerInfoMap());
        }
    }
    */
}
