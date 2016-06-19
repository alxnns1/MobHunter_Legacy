package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by Alex on 17/05/2016.
 */
public class EntityAltaroth extends EntityMHNeopteron {
    private boolean full = false;

    public EntityAltaroth(World worldIn){
        super(worldIn, 0.79f, 1.24f);
        this.setSize(0.9f,0.5f);
        setBaseHealth(5);
        setBaseAttack(2);
        setBaseSpeed(0.2);
        setBaseKnockback(0.3);
        this.tasks.addTask(1, new EntityAILeapAtTarget(this,0.5f));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
    }

    @Override
    public float getEyeHeight()
    {
        return 0.25F;
    }

    protected Item getDropItem()
    {
        return MHItems.itemMonsterFluid;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        if(!hitByPlayer) {
            int i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                this.dropItem(MHItems.itemAltarothStomach, 1);
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<50){
                    this.dropItem(MHItems.itemAltarothStomach, 1);
                }else if(i<75){
                    this.dropItem(MHItems.itemMonsterFluid, 1);
                }else if(i<100){
                    this.dropItem(MHItems.itemAltarothJaw, 1);
                }
            }
            int i = this.rand.nextInt(99);
            if(i<20){
                this.dropItem(MHItems.itemMonsterFluid, 1);
            }else if(i<40){
                this.dropItem(MHItems.itemHoney, 1);
            }else if(i<60){
                this.dropItem(MHItems.itemNulberry, 1);
            }else if(i<80){
                this.dropItem(MHItems.itemInsectHusk, 1);
            }else if(i<100){
                this.dropItem(MHItems.itemAltarothStomach, 1);
            }
        }
    }

    public boolean isFull(){
        return full;
    }
}
