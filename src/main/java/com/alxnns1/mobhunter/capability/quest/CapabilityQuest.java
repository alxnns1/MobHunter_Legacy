package com.alxnns1.mobhunter.capability.quest;

import com.alxnns1.mobhunter.handler.HunterRankHandler;
import com.alxnns1.mobhunter.init.MHQuests;
import com.alxnns1.mobhunter.message.MessageQuest;
import com.alxnns1.mobhunter.util.CommonUtil;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class CapabilityQuest implements IQuest
{
    private List<String> completedQuests = new ArrayList<String>();
    private List<MHQuestCooldown> cooldownQuests = new ArrayList<MHQuestCooldown>();
    private MHQuestObject currentQuest = null;

    public CapabilityQuest() {}

    @Override
    public MHQuestObject getCurrentQuest()
    {
        return currentQuest;
    }

    @Override
    public List<MHQuestCooldown> getCooldownQuests()
    {
        return cooldownQuests;
    }

    @Override
    public List<String> getCompletedQuests()
    {
        return completedQuests;
    }

    @Override
    public boolean addQuest(MHQuestObject quest)
    {
        boolean canAdd = currentQuest == null;
        if(canAdd)
            currentQuest = quest;
        return canAdd;
    }

    @Override
    public boolean clearQuest()
    {
        boolean canRemove = currentQuest != null;
        if(canRemove)
            currentQuest = null;
        return canRemove;
    }

    @Override
    public boolean cancelQuest(EntityPlayerMP player)
    {
        boolean canRemove = currentQuest != null;
        if(canRemove)
        {
            MHQuest quest = currentQuest.getQuest();
            int penalty = quest.getPointsPenalty();
            //Remove HR points from player
            HunterRankHandler.getHunterRankCapability(player).changeProgressPointsBy(player, penalty);
            player.sendMessage(new TextComponentString("You've cancelled the quest '" + quest.getLocalName() + "'\n" +
                    penalty + " HR points have been deducted from you as a penalty."));
            currentQuest = null;
        }
        return canRemove;
    }

    @Override
    public void progressQuest(EntityPlayerMP player, Object object)
    {
        if(currentQuest == null)
            return;
        if(currentQuest.addProgress(object))
        {
            if(currentQuest.isCompleted())
            {
                //Send chat message to player
                MHQuest quest = currentQuest.getQuest();
                player.sendMessage(new TextComponentString("Congrats! You completed the quest '" + quest.getLocalName() + "'!\n" +
                        "You've received " + quest.getPointsRewardText() + " and the following items:\n" + quest.getRewardText()));

                //Give player reward items
                for(ItemStack stack : currentQuest.getQuest().getRewardItems())
                    if(!player.inventory.addItemStackToInventory(stack.copy()))
                        player.entityDropItem(stack.copy(), 0);

                //Give player HR points
                HunterRankHandler.getHunterRankCapability(player).changeProgressPointsBy(player, quest.getPointsReward());

                //Add completed quest to either completed quests or quests on cooldown
                if(currentQuest.getQuest().getIsRepeatable())
                {
                    cooldownQuests.add(new MHQuestCooldown(currentQuest.getQuest(), player.world.getTotalWorldTime()));
                    dataChanged(player, EnumQuestDataChange.COOLDOWN);
                }
                else
                {
                    completedQuests.add(currentQuest.getQuest().getQuestId());
                    dataChanged(player, EnumQuestDataChange.COMPLETED);
                }

                //Clear current quest
                currentQuest = null;
            }
            dataChanged(player, EnumQuestDataChange.CURRENT);
        }
    }

    @Override
    public EnumQuestStatus getQuestStatus(MHQuest quest)
    {
        return currentQuest.getQuest().isEqual(quest) ? EnumQuestStatus.ACCEPTED : completedQuests.contains(quest.getQuestId()) ? EnumQuestStatus.COMPLETED : EnumQuestStatus.UNCOMPLETED;
    }

    @Override
    public void dataChanged(EntityPlayerMP player, EnumQuestDataChange changeType)
    {
        NBTTagCompound tag = new NBTTagCompound();
        switch(changeType)
        {
            case ALL:
                tag = serializeNBT();
                break;
            case CURRENT:
                tag.setTag("current", serializeCurrentQuestNBT());
                break;
            case COMPLETED:
                tag.setTag("completedQuests", serializeCompletedQuestsNBT());
                break;
            case COOLDOWN:
                tag.setTag("completedQuests", serializeCooldownQuestsNBT());
                break;
        }
        CommonUtil.NETWORK.sendTo(new MessageQuest(tag), player);
    }

    private NBTTagCompound serializeCurrentQuestNBT()
    {
        NBTTagCompound questTag = new NBTTagCompound();
        if(currentQuest != null)
        {
            questTag.setString("questId", currentQuest.getQuest().getQuestId());
            questTag.setTag("questData", currentQuest.serializeNBT());
        }
        else
            questTag.setString("questId", "");
        return questTag;
    }

    private NBTTagList serializeCompletedQuestsNBT()
    {
        NBTTagList questList = new NBTTagList();
        for(String s : completedQuests)
            questList.appendTag(new NBTTagString(s));
        return questList;
    }

    private NBTTagList serializeCooldownQuestsNBT()
    {
        NBTTagList questList = new NBTTagList();
        for(MHQuestCooldown cooldownQuest : cooldownQuests)
            questList.appendTag(cooldownQuest.writeToNBT());
        return questList;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("current", serializeCurrentQuestNBT());
        tag.setTag("completedQuests", serializeCompletedQuestsNBT());
        tag.setTag("cooldownQuests", serializeCooldownQuestsNBT());
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        if(nbt.hasKey("current"))
        {
            NBTTagCompound tag = nbt.getCompoundTag("current");
            String questId = tag.getString("questId");
            if(questId.equals(""))
                currentQuest = null;
            else
            {
                MHQuest quest = MHQuests.getQuest(questId);
                if(quest != null)
                {
                    currentQuest = new MHQuestObject(quest);
                    currentQuest.deserializeNBT(tag.getCompoundTag("questData"));
                }
                else
                    LogHelper.error("Quest ID '" + questId + "' couldn't be found!");
            }
        }
        if(nbt.hasKey("completedQuests"))
        {
            NBTTagList tagList = nbt.getTagList("completedQuests", Constants.NBT.TAG_STRING);
            for(int i = 0; i < tagList.tagCount(); i++)
                completedQuests.add(tagList.getStringTagAt(i));
        }
        if(nbt.hasKey("cooldownQuests"))
        {
            NBTTagList tagList = nbt.getTagList("cooldownQuests", Constants.NBT.TAG_COMPOUND);
            for(int i = 0; i < tagList.tagCount(); i++)
                cooldownQuests.add(MHQuestCooldown.readFromNBT(tagList.getCompoundTagAt(i)));
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
