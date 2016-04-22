package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyInstance;
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
    private static final String KEY_MULT = "sizemult";

    public EntityPopo(World worldIn)
    {
        super(worldIn);
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        sizeMult = (this.rand.nextFloat() * 0.45f) + 0.79f;
        this.setSize(0.9F * sizeMult, 1.3F * sizeMult);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) Math.round(10.0D * sizeMult));
        this.setHealth(this.getMaxHealth());
        LogHelper.info("SizeMult: " + sizeMult + "   Health: " + this.getMaxHealth());
        return super.onInitialSpawn(difficulty, livingdata);
    }

    public EntityPopo createChild(EntityAgeable ageable)
    {
        return new EntityPopo(this.worldObj);
    }

    public float getSizeMult(){
        return sizeMult;
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setFloat(KEY_MULT, sizeMult);
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        sizeMult = tagCompund.getFloat(KEY_MULT);
    }
}
