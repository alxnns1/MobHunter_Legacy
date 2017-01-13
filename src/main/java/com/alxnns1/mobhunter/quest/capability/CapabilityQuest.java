package com.alxnns1.mobhunter.quest.capability;

import com.alxnns1.mobhunter.init.MHQuests;
import com.alxnns1.mobhunter.message.MessageQuest;
import com.alxnns1.mobhunter.quest.EnumQuestStatus;
import com.alxnns1.mobhunter.quest.MHQuest;
import com.alxnns1.mobhunter.quest.MHQuestCooldown;
import com.alxnns1.mobhunter.quest.MHQuestObject;
import com.alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.capabilities.Capability;

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
    public boolean removeQuest()
    {
        boolean canRemove = currentQuest != null;
        if(canRemove)
            currentQuest = null;
        return canRemove;
    }

    @Override
    public void progressQuest(EntityPlayer player, Object object)
    {
        if(currentQuest == null)
            return;
        if(currentQuest.addProgress(object) && currentQuest.isCompleted())
        {
            //Send chat message to player
            MHQuest quest = currentQuest.getQuest();
            player.sendMessage(new TextComponentString("Congrats! You completed the quest '" + quest.getLocalName() + "'!\n" +
                    "You've received " + quest.getPointsReward() + " HR Points and the following items:\n" + quest.getRewardText()));

            //Give player reward items
            for(ItemStack stack : currentQuest.getQuest().getRewardItems())
                if(!player.inventory.addItemStackToInventory(stack.copy()))
                    player.entityDropItem(stack.copy(), 0);

            //TODO: Give player HR points

            //Add completed quest to either completed quests or quests on cooldown
            if(currentQuest.getQuest().getIsRepeatable())
                cooldownQuests.add(new MHQuestCooldown(currentQuest.getQuest(), player.world.getTotalWorldTime()));
            else
                completedQuests.add(currentQuest.getQuest().getUnlocName());

            //Clear current quest
            currentQuest = null;
        }
    }

    @Override
    public EnumQuestStatus getQuestStatus(MHQuest quest)
    {
        return currentQuest.getQuest().isEqual(quest) ? EnumQuestStatus.ACCEPTED : completedQuests.contains(quest.getUnlocName()) ? EnumQuestStatus.COMPLETED : EnumQuestStatus.UNCOMPLETED;
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
            questTag.setString("questId", currentQuest.getQuest().getUnlocName());
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
            {
                currentQuest = new MHQuestObject(quest);
                currentQuest.setStartTime(nbt.getLong("questStart"));
            }
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
