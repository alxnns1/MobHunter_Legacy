package com.alxnns1.mobhunter.message;

import com.alxnns1.mobhunter.init.MHCapabilities;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Mark on 28/06/2016.
 */
public class MessageHunterRank implements IMessage
{
    private NBTTagCompound hunterRankTag;

    public MessageHunterRank() {}

    public MessageHunterRank(NBTTagCompound hunterRank)
    {
        hunterRankTag = hunterRank;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        hunterRankTag = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        ByteBufUtils.writeTag(buf, hunterRankTag);
    }

    public static class MessageHandler implements IMessageHandler<MessageHunterRank, IMessage>
    {
        @Override
        public IMessage onMessage(final MessageHunterRank message, MessageContext ctx)
        {
            IThreadListener mainThread = Minecraft.getMinecraft();
            mainThread.addScheduledTask(new Runnable()
            {
                @Override
                public void run()
                {
                    EntityPlayer player = Minecraft.getMinecraft().player;
                    player.getCapability(MHCapabilities.HUNTER_RANK, null).deserializeNBT(message.hunterRankTag);
                }
            });
            return null;
        }
    }
}
