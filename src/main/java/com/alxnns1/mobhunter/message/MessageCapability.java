package com.alxnns1.mobhunter.message;

import com.alxnns1.mobhunter.gui.GuiQuest;
import com.alxnns1.mobhunter.init.MHCapabilities;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IThreadListener;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * Created by Mark on 12/01/2017.
 */
public class MessageCapability implements IMessage
{
    private EnumCapability capabilityType;
    private NBTTagCompound capabilityNBT;

    public MessageCapability() {}

    public MessageCapability(EnumCapability capabilityType, NBTTagCompound capabilityNBT)
    {
        this.capabilityType = capabilityType;
        this.capabilityNBT = capabilityNBT;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        capabilityType = EnumCapability.values()[buf.readInt()];
        capabilityNBT = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(capabilityType.ordinal());
        ByteBufUtils.writeTag(buf, capabilityNBT);
    }

    public static class Handler implements IMessageHandler<MessageCapability, IMessage>
    {
        @Override
        public IMessage onMessage(final MessageCapability message, MessageContext ctx)
        {
            IThreadListener mainThread = Minecraft.getMinecraft();
            mainThread.addScheduledTask(new Runnable()
            {
                @Override
                public void run()
                {
                    Minecraft mc = Minecraft.getMinecraft();
                    EntityPlayerSP player = mc.player;
                    Object capability = player.getCapability(message.capabilityType.getCapability(), null);
                    if(capability != null && capability instanceof INBTSerializable)
                        ((INBTSerializable) capability).deserializeNBT(message.capabilityNBT);
                    if(message.capabilityType == EnumCapability.QUEST && mc.currentScreen != null && mc.currentScreen instanceof GuiQuest)
                        ((GuiQuest) mc.currentScreen).updateQuest(null);
                }
            });
            return null;
        }
    }

    public enum EnumCapability
    {
        HUNTER_RANK(MHCapabilities.HUNTER_RANK),
        QUEST(MHCapabilities.QUESTS);

        private Capability capability;

        public <T> Capability<T> getCapability()
        {
            return capability;
        }

        <T> EnumCapability(Capability<T> capability)
        {
            this.capability = capability;
        }
    }
}
