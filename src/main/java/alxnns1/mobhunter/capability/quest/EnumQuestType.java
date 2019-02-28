package alxnns1.mobhunter.capability.quest;

import net.minecraft.item.ItemStack;

/**
 * Created by Mark on 12/01/2017.
 */
public enum EnumQuestType
{
	CRAFTING(ItemStack.class, "Craft the following items:"),
	GATHERING(ItemStack.class, "Gather the following items:"),
	HUNTING(EntityStack.class, "Hunt the following monsters:");

	public final Class storageType;
	public final String questDesc;

	EnumQuestType(Class storageType, String questDesc)
	{
		this.storageType = storageType;
		this.questDesc = questDesc;
	}
}
