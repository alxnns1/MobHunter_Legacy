package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.init.MHPotions;
import com.alxnns1.mobhunter.potion.PotionEffectParalyse;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Alex on 10/06/2016.
 */
public class EntityGenprey extends EntityMHBirdWyvern {
    public EntityGenprey(World worldIn)
    {
        super(worldIn, 0.79f, 1.24f, MHItems.itemRawMeat);
        this.setSize(1.5F, 1.8125F);
        this.tasks.addTask(1, new EntityAILeapAtTarget(this,0.5f));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityAnimal.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWitch.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityMHHerbivore.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMHHerbivore.class, true));
    }

    @Override
    public float getEyeHeight()
    {
        return 2.5625F;
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
            int i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                this.dropItem(MHItems.itemMonsterBoneS, 1);
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                this.dropItem(MHItems.itemBirdWyvernFang, 1);
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<42){
                    this.dropItem(MHItems.itemGenpreyFang, 1);
                }else if(i<75){
                    this.dropItem(MHItems.itemGenpreyScale, 1);
                }else if(i<100){
                    this.dropItem(MHItems.itemGenpreyHide, 1);
                }
            }

        }
    }

    public boolean attackEntityAsMob(Entity entityIn)
    {
        if (super.attackEntityAsMob(entityIn))
        {
            if (entityIn.getHorizontalFacing() == this.getHorizontalFacing()) {
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffectParalyse(320));
            }
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
    {
        setBaseHealth(12);
        setBaseAttack(3);
        setBaseSpeed(0.3);
        setBaseKnockback(0.1);
        /*
        double rand = Math.random();
        if(rand<0.1){
            EntityGendrome drome = new EntityGendrome(worldObj);
            worldObj.spawnEntityInWorld(drome);
            drome.setPosition(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ());
            this.setDead();
        }
        */
        return super.onInitialSpawn(difficulty, livingdata);
    }

}
