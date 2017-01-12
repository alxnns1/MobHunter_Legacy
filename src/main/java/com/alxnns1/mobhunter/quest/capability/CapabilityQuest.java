package com.alxnns1.mobhunter.quest.capability;

import com.alxnns1.mobhunter.init.MHQuests;
import com.alxnns1.mobhunter.quest.MHQuest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class CapabilityQuest implements IQuests
{
    private List<MHQuest> quests;

    public CapabilityQuest()
    {
        quests = new ArrayList<MHQuest>();
    }

    @Override
    public List<MHQuest> getCurrentQuests()
    {
        return quests;
    }

    @Override
    public boolean addNewQuest(EntityPlayer player, MHQuest quest)
    {
        for(MHQuest q : quests)
            if(q.isEqual(quest))
                return false;
        quests.add(quest);
        return true;
    }

    @Override
    public boolean removeQuest(EntityPlayer player, String questUnlocName)
    {
        for(int i = 0; i < quests.size(); i++)
            if(quests.get(i).getUnlocName().equals(questUnlocName))
            {
                quests.remove(i);
                return true;
            }
        return false;
    }

    @Override
    public void dataChanged(EntityPlayer player)
    {
        //TODO: Send packet to update client of data change
        //if(player != null && player instanceof EntityPlayerMP)
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound questTag = new NBTTagCompound();
        NBTTagList tagList = new NBTTagList();
        for(MHQuest quest : quests)
        {
            NBTTagCompound tag = new NBTTagCompound();
            tag.setString("questId", quest.getUnlocName());
            tag.setLong("questStart", quest.getStartTime());
            tagList.appendTag(tag);
        }
        questTag.setTag("questList", tagList);
        return questTag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        quests.clear();
        NBTTagList tagList = nbt.getTagList("questList", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i <= tagList.tagCount(); i++)
        {
            NBTTagCompound tag = tagList.getCompoundTagAt(i);
            MHQuest quest = MHQuests.getQuest(tag.getString("questId"));
            if(quest == null) continue;
            quest.setStartTime(tag.getLong("questStart"));
            quests.add(quest);
        }
    }

    public static class Storage implements Capability.IStorage<IQuests>
    {
        public static final Storage INSTANCE = new Storage();

        @Override
        public NBTBase writeNBT(Capability<IQuests> capability, IQuests instance, EnumFacing side)
        {
            return instance.serializeNBT();
        }

        @Override
        public void readNBT(Capability<IQuests> capability, IQuests instance, EnumFacing side, NBTBase nbt)
        {
            instance.deserializeNBT((NBTTagCompound) nbt);
        }
    }
}
