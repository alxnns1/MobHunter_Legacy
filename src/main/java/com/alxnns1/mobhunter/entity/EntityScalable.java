package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Mark on 28/04/2016.
 */
public abstract class EntityScalable extends EntityAnimal
{
    private static final String KEY_SCALE = "scale";
    private static final int WATCHER_SCALE = 20;
    private static float scaleMax; //= 1.24f;
    private static float scaleMin; //= 0.79f;
    private double baseHealth = 5d;
    private double baseSpeed = 0.1d;
    private double baseKnockback = 0.2d;

    public EntityScalable(World world)
    {
        this(world, 1f, 1f);
    }

    public EntityScalable(World world, float minScale, float maxScale)
    {
        super(world);
        this.setSize(0.9F, 1.3F); //Same as cow
        scaleMin = minScale;
        scaleMax = maxScale;
        ((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
        this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(3, new EntityAITempt(this, 1.25D, Items.wheat, false));
        this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
        this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(7, new EntityAILookIdle(this));
    }

    protected void entityInit()
    {
        super.entityInit();
        //Creates the datawatcher object to save the entity scale in
        this.dataWatcher.addObject(WATCHER_SCALE, 1.0f);
    }

    //Same as pig
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        float scale = (this.rand.nextFloat() * (scaleMax - scaleMin)) + scaleMin;
        this.setEntityScale(scale);
        return super.onInitialSpawn(difficulty, livingdata);
    }

    private void setEntityScale(float scale)
    {
        //Gets the datawatcher value for the entity scale
        this.dataWatcher.updateObject(WATCHER_SCALE, scale);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) Math.round(baseHealth * scale));
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(baseSpeed * scale);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(baseKnockback * scale);
        this.setHealth(this.getMaxHealth());
        //this.setScale(scale);
        LogHelper.info("Scale: " + scale + "   Health: " + this.getMaxHealth());
    }

    public float getScale()
    {
        return this.dataWatcher.getWatchableObjectFloat(WATCHER_SCALE);
    }

    public void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        super.writeEntityToNBT(tagCompound);
        tagCompound.setFloat(KEY_SCALE, getScale());
    }

    public void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        super.readEntityFromNBT(tagCompund);
        setEntityScale(tagCompund.getFloat(KEY_SCALE));
    }

    protected void setBaseHealth(int health)
    {
        baseHealth = (double) health;
    }

    protected void setBaseSpeed(double speed)
    {
        baseSpeed = speed;
    }

    protected void setBaseKnockback(double knockback)
    {
        baseKnockback = knockback;
    }
}
