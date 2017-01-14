package com.alxnns1.mobhunter.message;

import com.alxnns1.mobhunter.init.MHQuests;
import com.alxnns1.mobhunter.quest.MHQuestObject;
import com.alxnns1.mobhunter.quest.QuestHandler;
import com.alxnns1.mobhunter.quest.capability.IQuest;
import com.alxnns1.mobhunter.util.LogHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.IThreadListener;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.UUID;

/**
 * Created by Mark on 14/01/2017.
 */
public class MessageGuiQuest implements IMessage
{
    public int buttonId;
    public UUID playerUuid;

    public MessageGuiQuest() {}

    public MessageGuiQuest(int buttonId, UUID playerUuid)
    {
        this.buttonId = buttonId;
        this.playerUuid = playerUuid;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        buttonId = buf.readInt();
        long mostSig = buf.readLong();
        long leastSig = buf.readLong();
        playerUuid = new UUID(mostSig, leastSig);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(buttonId);
        buf.writeLong(playerUuid.getMostSignificantBits());
        buf.writeLong(playerUuid.getLeastSignificantBits());
    }

    public static class Handler implements IMessageHandler<MessageGuiQuest, IMessage>
    {
        @Override
        public IMessage onMessage(final MessageGuiQuest message, final MessageContext ctx)
        {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.world;
            mainThread.addScheduledTask(new Runnable()
            {
                @Override
                public void run()
                {
                    WorldServer world = (WorldServer) ctx.getServerHandler().playerEntity.world;
                    EntityPlayer player = world.getPlayerEntityByUUID(message.playerUuid);
                    IQuest questCapability = QuestHandler.getQuestCapability(player);
                    LogHelper.info("Handling Gui Quest Packet");
                    switch(message.buttonId)
                    {

                        case 1:
                            //Share
                            //TODO: Maybe find a way to handle the chat message on the client side of players? That way I can easily get quest data.
                            //For info on what's going on here, have a look at:
                            // StatBase#getStatName

                            MinecraftServer server = world.getMinecraftServer();
                            if(server != null)
                            {
                                TextComponentString msg1;
                                if(player != null)
                                    msg1 = new TextComponentString(player.getDisplayNameString() + " has shared their quest [");
                                else
                                    msg1 = new TextComponentString("[");
                                TextComponentTranslation questName = new TextComponentTranslation(questCapability.getCurrentQuest().getQuest().getUnlocName());
                                questName.getStyle().setColor(TextFormatting.GREEN);
                                //questName.getStyle().setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                                //        new TextComponentTranslation()));
                                server.getPlayerList().sendChatMsg(msg1.appendSibling(questName).appendText("]"));
                            }
                            break;
                        case 2:
                            //Cancel
                            questCapability.cancelQuest(player);
                            questCapability.dataChanged(player);
                            break;

                        //Debug Buttons
                        case 3:
                            //Add Test Crafting Quest
                            questCapability.addQuest(new MHQuestObject(MHQuests.testCraft));
                            questCapability.dataChanged(player);
                            break;
                        case 4:
                            //Add Test Gathering Quest
                            questCapability.addQuest(new MHQuestObject(MHQuests.testGather));
                            questCapability.dataChanged(player);
                            break;
                        case 5:
                            //Add Test Hunting Quest
                            questCapability.addQuest(new MHQuestObject(MHQuests.testHunt));
                            questCapability.dataChanged(player);
                            break;
                        case 6:
                            //Clear Current Quest
                            questCapability.clearQuest();
                            questCapability.dataChanged(player);
                            break;
                    }
                }
            });
            return null;
        }
    }
}
