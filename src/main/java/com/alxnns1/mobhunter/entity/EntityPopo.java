package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
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
    private static final String KEY_SCALE = "scale";
    private static final int WATCHER_SCALE = 20;

    public EntityPopo(World worldIn)
    {
        super(worldIn);
    }

    protected void entityInit()
    {
        super.entityInit();
        //Creates the datawatcher object to save the entity scale in
        this.dataWatcher.addObject(WATCHER_SCALE, 1.0f);
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        float scale = (this.rand.nextFloat() * 0.45f) + 0.79f;
        this.setPopoScale(scale);
        return super.onInitialSpawn(difficulty, livingdata);
    }

    private void setPopoScale(float scale)
    {
        //Gets the datawatcher value for the entity scale
        this.dataWatcher.updateObject(WATCHER_SCALE, scale);
        this.setSize(0.9F * scale, 1.3F * scale);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) Math.round(10.0D * scale));
        this.setHealth(this.getMaxHealth());
        LogHelper.info("Scale: " + scale + "   Health: " + this.getMaxHealth());
    }

    public EntityPopo createChild(EntityAgeable ageable)
    {
        return new EntityPopo(this.worldObj);
    }

    public float getPopoScale(){
        return this.dataWatcher.getWatchableObjectFloat(WATCHER_SCALE);
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setFloat(KEY_SCALE, getPopoScale());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        setPopoScale(tagCompund.getFloat(KEY_SCALE));
    }
}
