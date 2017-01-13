package com.alxnns1.mobhunter.quest;

import net.minecraft.item.ItemStack;

/**
 * Created by Mark on 12/01/2017.
 */
public enum EnumQuestType
{
    CRAFTING(ItemStack.class),
    GATHERING(ItemStack.class),
    HUNTING(EntityStack.class);

    public final Class storageType;

    EnumQuestType(Class storageType)
    {
        this.storageType = storageType;
    }
}
