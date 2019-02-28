package alxnns1.mobhunter.capability.monsters;

import alxnns1.mobhunter.capability.ICapability;
import net.minecraft.entity.player.EntityPlayerMP;

import java.util.List;

/**
 * Created by Mark on 10/04/2017.
 */
public interface IMonsters extends ICapability
{
	/**
	 * Returns the entry set of all the monster sizes.
	 */
	List<MonsterSize> getAllMonsterSizes();

	/**
	 * Returns a MonsterSize instance which holds the smallest and largest sizes of the monster.
	 * Will be null if monster is not found.
	 */
	MonsterSize getMonsterSizes(String monsterID);

	/**
	 * Returns a result which describes if the new size is smaller, larger or none than the existing values.
	 */
	EnumSizeResult checkMonsterSize(String monsterID, float size);

	/**
	 * Will update the smallest and largest sizes of the monster using the given size.
	 */
	void updateMonsterSize(String monsterID, float size);

	/**
	 * Sends the data for the given monster to the client side player.
	 */
	void dataChanged(EntityPlayerMP player, String monsterID);
}
