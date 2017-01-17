package com.alxnns1.mobhunter.capability.quest;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mark on 12/01/2017.
 */
public class EntityStack
{
    private final String entityName;
    private final int amount;

    public EntityStack(String entityName, int amount)
    {
        this.entityName = entityName;
        this.amount = amount;
    }

    public String getEntityUnlocName()
    {
        return "entity." + entityName + ".name";
    }

    @SideOnly(Side.CLIENT)
    public String getEntityLocName()
    {
        return I18n.format(getEntityUnlocName());
    }

    public int getAmount()
    {
        return amount;
    }

    public boolean isEqualTo(EntityStack other)
    {
        return other != null && entityName.equals(other.entityName);
    }

    @Override
    public String toString()
    {
        return amount + "x" + entityName;
    }
}
