package com.alxnns1.mobhunter.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.world.World;

/**
 * Created by Mark on 05/04/2017.
 */
public class EntityBarrelBomb extends EntityTNTPrimed
{
    public EntityBarrelBomb(World worldIn)
    {
        super(worldIn);
    }

    public EntityBarrelBomb(World worldIn, double x, double y, double z, EntityLivingBase igniter)
    {
        super(worldIn, x, y, z, igniter);
        motionX = 0;
        motionY = 0;
        motionZ = 0;
    }

    /**
     * Set this entity to bounce for when spawning a bouncing bomb.
     */
    public EntityBarrelBomb setBounce()
    {
        motionY = 1;
        return this;
    }
}
