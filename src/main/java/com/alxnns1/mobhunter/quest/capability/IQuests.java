package com.alxnns1.mobhunter.quest.capability;

import com.alxnns1.mobhunter.quest.MHQuest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public interface IQuests extends INBTSerializable<NBTTagCompound>
{
    /**
     * Returns the list of currently active quests for the player
     */
    List<MHQuest> getCurrentQuests();

    /**
     * Adds a new quest for the player
     * @return Success - Will return false if player has already accepted the quest
     */
    boolean addNewQuest(EntityPlayer player, MHQuest quest);

    /**
     * Removes the quest from the player with the given unlocalised name
     * @return Success - Will return false if the player has not accepted the quest already
     */
    boolean removeQuest(EntityPlayer player, String questUnlocName);

    void dataChanged(EntityPlayer player);
}
