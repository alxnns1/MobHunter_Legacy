package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Config;
import net.minecraft.entity.ai.EntityAIAttackMelee;
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
 * Created by Alex on 01/06/2016.
 */
public class EntityGreatJaggi extends EntityMHBirdWyvern {
    public EntityGreatJaggi(World worldIn)
    {
        super(worldIn, Config.scaleMin*0.75f, Config.scaleMax*0.75f, MHItems.itemRawMeat);
        this.setSize(2.25F, 2.5F);
        setBaseHealth(390);
        setBaseAttack(3*1.5);
        setBaseSpeed(0.3*1.5);
        setBaseKnockback(0.5*1.5);
        this.tasks.addTask(1, new EntityAILeapAtTarget(this,0.5f));
        this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMHHerbivore.class, true));
    }

    @Override
    public float getEyeHeight()
    {
        return 3.75F;
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
                dropSingleItem(MHItems.itemMonsterDrop, 16); //Screamer Sac
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemMonsterDrop, 26); //Great Jaggi Hide
            }
        }else{
            for(int n=0;n<3+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<20){
                    dropSingleItem(MHItems.itemMonsterDrop, 26); //Great Jaggi Hide
                }else if(i<41){
                    dropSingleItem(MHItems.itemMonsterDrop, 27); //Great Jaggi Claw
                }else if(i<71){
                    dropSingleItem(MHItems.itemMonsterDrop, 16); //Screamer Sac
                }else if(i<74){
                    dropSingleItem(MHItems.itemMonsterDrop, 18); //Jaggi Scale
                }else if(i<79){
                    dropSingleItem(MHItems.itemMonsterDrop, 28); //Great Jaggi Head
                }else{
                    dropSingleItem(MHItems.itemMonsterDrop, 29); //Kings Frill
                }
            }
        }
    }
}
