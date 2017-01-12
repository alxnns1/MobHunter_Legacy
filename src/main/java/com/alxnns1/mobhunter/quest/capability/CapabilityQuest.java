package com.alxnns1.mobhunter.quest.capability;

import com.alxnns1.mobhunter.init.MHQuests;
import com.alxnns1.mobhunter.message.MessageQuest;
import com.alxnns1.mobhunter.quest.MHQuest;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

/**
 * Created by Mark on 12/01/2017.
 */
public class CapabilityQuest implements IQuest
{
    private MHQuest currentQuest = null;

    public CapabilityQuest() {}

    @Override
    public MHQuest getCurrentQuest()
    {
        return currentQuest;
    }

    @Override
    public boolean addQuest(EntityPlayer player, MHQuest quest)
    {
        boolean canAdd = currentQuest == null;
        if(canAdd)
            currentQuest = quest;
        return canAdd;
    }

    @Override
    public boolean removeQuest(EntityPlayer player)
    {
        boolean canRemove = currentQuest != null;
        if(canRemove)
            currentQuest = null;
        return canRemove;
    }

    @Override
    public void dataChanged(EntityPlayer player)
    {
        if(player != null && player instanceof EntityPlayerMP)
            CommonUtil.network.sendTo(new MessageQuest(serializeNBT()), (EntityPlayerMP) player);
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound questTag = new NBTTagCompound();
        if(currentQuest != null)
        {
            questTag.setString("questId", currentQuest.getUnlocName());
            questTag.setLong("questStart", currentQuest.getStartTime());
        }
        return questTag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        if(nbt.hasKey("questId"))
        {
            MHQuest quest = MHQuests.getQuest(nbt.getString("questId"));
            if(quest != null)
                quest.setStartTime(nbt.getLong("questStart"));
            currentQuest = quest;
        }
    }

    public static class Storage implements Capability.IStorage<IQuest>
    {
        public static final Storage INSTANCE = new Storage();

        @Override
        public NBTBase writeNBT(Capability<IQuest> capability, IQuest instance, EnumFacing side)
        {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IQuest> capability, IQuest instance, EnumFacing side, NBTBase nbt)
        {
            instance.deserializeNBT((NBTTagCompound) nbt);
        }
    }
}
