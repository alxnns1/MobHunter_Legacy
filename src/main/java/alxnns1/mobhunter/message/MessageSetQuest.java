package alxnns1.mobhunter.message;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.capability.quest.EnumQuestDataChange;
import alxnns1.mobhunter.capability.quest.IQuest;
import alxnns1.mobhunter.capability.quest.MHQuest;
import alxnns1.mobhunter.init.MHCapabilities;
import alxnns1.mobhunter.init.MHQuests;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

import java.util.UUID;

/**
 * Created by Mark on 23/01/2017.
 */
public class MessageSetQuest implements IMessage
{
    public String questName;
    public UUID playerUuid;

    public MessageSetQuest() {}

    public MessageSetQuest(MHQuest quest, UUID playerUuid)
    {
        questName = quest == null ? questName = "" : quest.getQuestId();
        this.playerUuid = playerUuid;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        questName = ByteBufUtils.readUTF8String(buf);
        long mostSig = buf.readLong();
        long leastSig = buf.readLong();
        playerUuid = new UUID(mostSig, leastSig);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeUTF8String(buf, questName);
        buf.writeLong(playerUuid.getMostSignificantBits());
        buf.writeLong(playerUuid.getLeastSignificantBits());
    }

    public static class Handler implements IMessageHandler<MessageSetQuest, IMessage>
    {
        @Override
        public IMessage onMessage(final MessageSetQuest message, final MessageContext ctx)
        {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().player.world;
            mainThread.addScheduledTask(new Runnable()
            {
                @Override
                public void run()
                {
                    WorldServer world = (WorldServer) ctx.getServerHandler().player.world;
                    EntityPlayerMP player = (EntityPlayerMP) world.getPlayerEntityByUUID(message.playerUuid);
                    IQuest questCapability = player.getCapability(MHCapabilities.QUESTS, null);

                    if(message.questName == null || message.questName.equals(""))
                        //If no quest given, try to cancel the current quest
                        questCapability.cancelQuest(player);
                    else
                    {
                        //Try to add the quest
                        MHQuest quest = MHQuests.getQuest(message.questName);
                        if(quest == null) MobHunter.LOGGER.error("Couldn't find quest '" + message.questName + "'!");
                        questCapability.addQuest(quest, world.getTotalWorldTime());
                    }
                    questCapability.dataChanged(player, EnumQuestDataChange.CURRENT);
                }
            });
            return null;
        }
    }
}
