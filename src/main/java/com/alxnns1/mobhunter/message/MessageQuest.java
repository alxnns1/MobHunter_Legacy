package com.alxnns1.mobhunter.message;

import com.alxnns1.mobhunter.quest.QuestHandler;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Mark on 12/01/2017.
 */
public class MessageQuest implements IMessage
{
    private NBTTagCompound questNBT;

    public MessageQuest() {}

    public MessageQuest(NBTTagCompound questCapabilityNBT)
    {
        questNBT = questCapabilityNBT;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        questNBT = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeTag(buf, questNBT);
    }

    public static class Handler implements IMessageHandler<MessageQuest, IMessage>
    {
        @Override
        public IMessage onMessage(final MessageQuest message, MessageContext ctx)
        {
            IThreadListener mainThread = Minecraft.getMinecraft();
            mainThread.addScheduledTask(new Runnable()
            {
                @Override
                public void run()
                {
                    QuestHandler.getQuestCapability(Minecraft.getMinecraft().player).deserializeNBT(message.questNBT);
                }
            });
            return null;
        }
    }
}
