package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Alex on 27/04/2016.
 */
public class EntityJaggi extends EntityMHWyvern
{
    public EntityJaggi(World worldIn)
    {
        super(worldIn, 0.79f, 1.24f);
        this.setSize(1.0F, 1.0F);
        setBaseHealth(9);
        setBaseAttack(3);
        setBaseSpeed(0.3);
        setBaseKnockback(0.1);
        this.tasks.addTask(1, new EntityAILeapAtTarget(this,0.5f));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityVillager.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPig.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPig.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityCow.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityCow.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntitySheep.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntitySheep.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityHorse.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityHorse.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityChicken.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityChicken.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWitch.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityWolf.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWolf.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityOcelot.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityOcelot.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityRabbit.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityRabbit.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPopo.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPopo.class, true));
        this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityKelbi.class,1.0D,false));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityKelbi.class, true));
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
                this.dropItem(MHItems.itemBirdWyvernFang, 1);
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                this.dropItem(MHItems.itemJaggiHide, 1);
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<40){
                    this.dropItem(MHItems.itemBirdWyvernFang, 1);
                }else if(i<69){
                    this.dropItem(MHItems.itemJaggiHide, 1);
                }else if(i<92){
                    this.dropItem(MHItems.itemJaggiScale, 1);
                }else if(i<100){
                    this.entityDropItem(new ItemStack(MHItems.itemBones, 1, 0), 0);
                    //this.dropItem(MHItems.itemMonsterBoneS, 1);
                }
            }

        }
    }

    public EntityJaggi createChild(EntityAgeable ageable)
    {
        return new EntityJaggi(this.worldObj);
    }
}
