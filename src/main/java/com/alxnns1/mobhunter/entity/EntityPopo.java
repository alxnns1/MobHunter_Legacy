package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Mark on 21/04/2016.
 */
public class EntityPopo extends EntityCow
{
    private static final String KEY_SCALE = "scale";
    private static final int WATCHER_SCALE = 20;
    private static final float scaleMax = 1.24f;
    private static final float scaleMin = 0.79f;

    public EntityPopo(World worldIn)
    {
        super(worldIn);
        this.setSize(1.9F, 2.5F);
    }

    protected void entityInit()
    {
        super.entityInit();
        //Creates the datawatcher object to save the entity scale in
        this.dataWatcher.addObject(WATCHER_SCALE, 1.0f);
    }

    protected Item getDropItem()
    {
        return MHItems.itemRawMeat;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        if(!hitByPlayer) {
            int i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                this.dropItem(MHItems.itemMysteryBone, 1);
            }
            i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                this.dropItem(MHItems.itemRawMeat, 1);
            }
        }else{
            for(int n=0;n<2+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<45){
                    this.dropItem(MHItems.itemMysteryBone, 1);
                }else if(i<75){
                    this.dropItem(MHItems.itemRawMeat, 1);
                }else if(i<95){
                    this.dropItem(MHItems.itemBruteBone, 1);
                }else if(i<100){
                    this.dropItem(MHItems.itemJumboBone, 1);
                }
            }

        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        float scale = ((this.rand.nextFloat() * (scaleMax - scaleMin)) + scaleMin)*2;
        this.setPopoScale(scale);
        return super.onInitialSpawn(difficulty, livingdata);
    }

    private void setPopoScale(float scale)
    {
        //Gets the datawatcher value for the entity scale
        this.dataWatcher.updateObject(WATCHER_SCALE, scale);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double) Math.round(5.0D * scale));
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D * scale);
        this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue(0.2D * scale);
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
