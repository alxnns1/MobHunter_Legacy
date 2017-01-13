package com.alxnns1.mobhunter.quest;

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

    public String getEntityName()
    {
        return entityName;
    }

    public int getAmount()
    {
        return amount;
    }

    public boolean isEqualTo(EntityStack other)
    {
        return other != null && entityName.equals(other.entityName);
    }
}
