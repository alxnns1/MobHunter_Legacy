package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by Alex on 30/05/2016.
 */
public class EntityJaggia extends EntityMHBirdWyvern {
    public EntityJaggia(World worldIn)
    {
        super(worldIn, 0.79f, 1.24f, MHItems.itemRawMeat);
        this.setSize(1.5F, 1.8125F);
        setBaseHealth(12);
        setBaseAttack(3);
        setBaseSpeed(0.3);
        setBaseKnockback(0.1);
        this.tasks.addTask(1, new EntityAILeapAtTarget(this,0.5f));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
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
                if(i<43){
                    this.dropItem(MHItems.itemJaggiHide, 1);
                }else if(i<73){
                    this.dropItem(MHItems.itemJaggiScale, 1);
                }else if(i<91){
                    this.dropItem(MHItems.itemBirdWyvernFang, 1);
                }else if(i<100){
                    this.dropItem(MHItems.itemMonsterBoneS, 1);
                }
            }

        }
    }
}
