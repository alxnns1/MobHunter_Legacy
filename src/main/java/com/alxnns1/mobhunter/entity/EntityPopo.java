package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.world.World;

/**
 * Created by Mark on 21/04/2016.
 */
public class EntityPopo extends EntityCow
{
    /**
     * This value will affect the mob's health and size
     * Between 0.79 and 1.24
     */
    private float sizeMult;

    public EntityPopo(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F * sizeMult, 1.3F * sizeMult);
        LogHelper.info("Popo spawned with scale: " + sizeMult);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        sizeMult = (this.rand.nextFloat() * 0.45f) + 0.79f;
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) Math.round(10.0D * sizeMult));
        LogHelper.info("Popo spawned with health: " + (10*sizeMult));
    }

    public EntityPopo createChild(EntityAgeable ageable)
    {
        return new EntityPopo(this.worldObj);
    }

    public float getSizeMult(){
        return sizeMult;
    }
}
