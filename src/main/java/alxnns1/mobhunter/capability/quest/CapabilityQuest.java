package alxnns1.mobhunter.capability.quest;

import alxnns1.mobhunter.init.MHCapabilities;
import alxnns1.mobhunter.init.MHQuests;
import alxnns1.mobhunter.message.MessageCapability;
import alxnns1.mobhunter.util.CommonUtil;
import alxnns1.mobhunter.util.LogHelper;
import alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public class CapabilityQuest implements IQuest
{
    private static final ResourceLocation questRL = new ResourceLocation(Reference.MOD_ID, "_Quests");

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
    public boolean isQuestAccepted(MHQuest quest)
    {
        return currentQuest != null && currentQuest.getQuest().isEqual(quest);
    }

    @Override
    public List<MHQuestCooldown> getCooldownQuests()
    {
        return cooldownQuests;
    }

    @Override
    public MHQuestCooldown getQuestCooldown(MHQuest quest)
    {
        for(MHQuestCooldown cdQuest : cooldownQuests)
            if(cdQuest.isQuestEqual(quest))
                return cdQuest;
        return null;
    }

    @Override
    public boolean isQuestCoolingDown(MHQuest quest)
    {
        return getQuestCooldown(quest) != null;
    }

    @Override
    public List<String> getCompletedQuests()
    {
        return completedQuests;
    }

    @Override
    public boolean isQuestCompleted(MHQuest quest)
    {
        return completedQuests.contains(quest.getQuestId());
    }

    @Override
    public boolean canAcceptQuest(MHQuest quest)
    {
        return currentQuest == null && !isQuestCompleted(quest) && !isQuestCoolingDown(quest);
    }

    @Override
    public boolean addQuest(MHQuest quest, long startTime)
    {
        boolean canAdd = currentQuest == null;
        if(canAdd)
            currentQuest = new MHQuestObject(quest).setStartTime(startTime);
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
            player.getCapability(MHCapabilities.HUNTER_RANK, null).changeProgressPointsBy(player, -penalty);
            player.sendMessage(new TextComponentTranslation("message.quest.cancel")
                    .appendText(" '")
                    .appendSibling(new TextComponentTranslation(quest.getUnlocName()))
                    .appendText("'\n")
                    .appendSibling(new TextComponentTranslation("message.quest.penalty", penalty)));
            currentQuest = null;
        }
        return canRemove;
    }

    @Override
    public boolean progressQuest(EntityPlayerMP player, Object object)
    {
        if(currentQuest == null)
            return false;
        int progress = currentQuest.addProgress(object);
        if(progress > 0)
        {
            if(object instanceof ItemStack)
            {
                ItemStack stack = (ItemStack) object;
                player.inventory.clearMatchingItems(stack.getItem(), stack.getMetadata(), progress, stack.getTagCompound());
                player.inventory.markDirty();
            }
            if(currentQuest.isCompleted())
            {
                //Send chat message to player
                MHQuest quest = currentQuest.getQuest();
                player.sendMessage(new TextComponentTranslation("message.quest.complete")
                        .appendText(" '")
                        .appendSibling(new TextComponentTranslation(quest.getUnlocName()))
                        .appendText("'!\n")
                        .appendSibling(new TextComponentTranslation("message.quest.reward", quest.getPointsRewardText()))
                        .appendText(":\n")
                        .appendSibling(quest.getRewardTextComponent()));

                //Give player reward items
                for(ItemStack stack : currentQuest.getQuest().getRewardItems())
                    if(!player.inventory.addItemStackToInventory(stack.copy()))
                        player.entityDropItem(stack.copy(), 0);

                //Give player HR points
                player.getCapability(MHCapabilities.HUNTER_RANK, null).changeProgressPointsBy(player, quest.getPointsReward());

                //Add completed quest to either completed quests or quests on cooldown
                if(currentQuest.getQuest().isRepeatable())
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
            return true;
        }
        return false;
    }

    @Override
    public EnumQuestStatus getQuestStatus(MHQuest quest)
    {
        if(isQuestAccepted(quest))
            return EnumQuestStatus.ACCEPTED;
        else if(isQuestCompleted(quest))
            return EnumQuestStatus.COMPLETED;
        else if(isQuestCoolingDown(quest))
            return EnumQuestStatus.COOLDOWN;
        else
            return EnumQuestStatus.UNCOMPLETED;
    }

    @Override
    public ResourceLocation getKey()
    {
        return questRL;
    }

    @Override
    public ICapabilityProvider getProvider()
    {
        return new CapabilityQuestProvider();
    }

    @Override
    public void dataChanged(EntityPlayerMP player)
    {
        dataChanged(player, EnumQuestDataChange.ALL);
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
                tag.setTag("cooldownQuests", serializeCooldownQuestsNBT());
                break;
        }
        CommonUtil.NETWORK.sendTo(new MessageCapability(MessageCapability.EnumCapability.QUEST, tag), player);
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
            completedQuests.clear();
            for(int i = 0; i < tagList.tagCount(); i++)
                completedQuests.add(tagList.getStringTagAt(i));
        }
        if(nbt.hasKey("cooldownQuests"))
        {
            NBTTagList tagList = nbt.getTagList("cooldownQuests", Constants.NBT.TAG_COMPOUND);
            cooldownQuests.clear();
            for(int i = 0; i < tagList.tagCount(); i++)
                cooldownQuests.add(MHQuestCooldown.readFromNBT(tagList.getCompoundTagAt(i)));
        }
    }
}
