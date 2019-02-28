package alxnns1.mobhunter.capability.quest;

import alxnns1.mobhunter.capability.ICapability;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

/**
 * Created by Mark on 12/01/2017.
 */
public interface IQuest extends ICapability
{
	/**
	 * Returns the currently active quest for the player
	 */
	MHQuestObject getCurrentQuest();

	/**
	 * Returns whether the quest is the currently accepted quest
	 */
	boolean isQuestAccepted(MHQuest quest);

	/**
	 * Returns the quests currently on cooldown for the player
	 */
	List<MHQuestCooldown> getCooldownQuests();

	/**
	 * Returns this quest's cooldown object if it's on cooldown
	 * Returns null if not on cooldown
	 */
	MHQuestCooldown getQuestCooldown(MHQuest quest);

	/**
	 * Returns whether the given quest is on cooldown for the player
	 */
	boolean isQuestCoolingDown(MHQuest quest);

	/**
	 * Returns the quests completed by the player
	 */
	List<String> getCompletedQuests();

	/**
	 * Returns whether the quest has been completed by the player
	 */
	boolean isQuestCompleted(MHQuest quest);

	/**
	 * Returns whether the wuest can be accepted
	 */
	boolean canAcceptQuest(MHQuest quest);

	/**
	 * Adds the quest as the current accepted quest for the player
	 * Will ONLY remove the quest from the player
	 *
	 * @return Success - Will return false if player has already accepted a quest
	 */
	boolean addQuest(MHQuest quest, long startTime);

	/**
	 * Removes the current accepted quest from the player
	 *
	 * @return Success - Will return false if the player has not accepted a quest
	 */
	boolean clearQuest();

	/**
	 * Cancels the current accepted quest from the player
	 * Will deduct the penalty HR points from the player
	 *
	 * @return Success - Will return false if the player has not accepted a quest
	 */
	boolean cancelQuest(EntityPlayerMP player);

	/**
	 * Tries to add progress to the current quest
	 *
	 * @param object The object trying to progress. Crafting and Gathering quests will need this to be an ItemStack,
	 * and Hunting quests will need this to be an EntityStack.
	 */
	boolean progressQuest(EntityPlayerMP player, Object object);

	/**
	 * Gets the status of the quest for the player - i.e. whether the quest has been completed or not
	 */
	EnumQuestStatus getQuestStatus(MHQuest quest);

	void dataChanged(EntityPlayerMP player, EnumQuestDataChange changeType);
}
