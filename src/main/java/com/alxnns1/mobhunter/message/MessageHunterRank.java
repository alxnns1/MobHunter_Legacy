package com.alxnns1.mobhunter.message;

import com.alxnns1.mobhunter.capability.HunterRankProvider;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagFloat;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Mark on 28/06/2016.
 */
public class MessageHunterRank implements IMessage
{
    private NBTTagFloat hunterRankTag;

    public MessageHunterRank() {}

    public MessageHunterRank(NBTTagFloat hunterRank)
    {
        hunterRankTag = hunterRank;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        hunterRankTag = (NBTTagFloat) ByteBufUtils.readTag(buf).getTag("hr");
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setTag("hr", hunterRankTag);
        ByteBufUtils.writeTag(buf, compound);
    }

    public static class MessageHandler implements IMessageHandler<MessageHunterRank, IMessage>
    {
        @Override
        public IMessage onMessage(final MessageHunterRank message, MessageContext ctx)
        {
            IThreadListener mainThread = ctx.side.isClient() ? Minecraft.getMinecraft() : (WorldServer) ctx.getServerHandler().playerEntity.world;
            mainThread.addScheduledTask(new Runnable()
            {
                @Override
                public void run()
                {
                    HunterRankProvider.get(Minecraft.getMinecraft().player).loadNBT(message.hunterRankTag);
                }
            });

            return null; //No response
        }
    }
}
