package com.alxnns1.mobhunter.quest.capability;

import com.alxnns1.mobhunter.quest.MHQuest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public interface IQuest extends INBTSerializable<NBTTagCompound>
{
    /**
     * Returns the currently active quest for the player
     */
    MHQuest getCurrentQuest();

    /**
     * Adds a new quest for the player
     * @return Success - Will return false if player has already accepted a quest
     */
    boolean addQuest(EntityPlayer player, MHQuest quest);

    /**
     * Removes the quest from the player
     * @return Success - Will return false if the player has not accepted a quest
     */
    boolean removeQuest(EntityPlayer player);

    void dataChanged(EntityPlayer player);
}
