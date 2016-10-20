package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Config;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Alex on 27/04/2016.
 */
public class EntityJaggi extends EntityMHBirdWyvern
{
    public EntityJaggi(World worldIn)
    {
        super(worldIn);
        this.setSize(1.0F, 1.0F);
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
        return 1.375F;
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
                dropSingleItem(MHItems.itemMonsterDrop, 0); //Monster Bone S
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemMonsterDrop, 15); //Bird Wyvern Fang
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<40){
                    dropSingleItem(MHItems.itemMonsterDrop, 15); //Bird Wyvern Fang
                }else if(i<69){
                    dropSingleItem(MHItems.itemMonsterDrop, 17); //Jaggi Hide
                }else if(i<92){
                    dropSingleItem(MHItems.itemMonsterDrop, 18); //Jaggi Scale
                }else if(i<100){
                    dropSingleItem(MHItems.itemMonsterDrop, 0); //Monster Bone S
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
        setBaseHealth(9);
        setBaseAttack(3);
        setBaseSpeed(0.3);
        setBaseKnockback(0.1);
        double rand = this.rand.nextDouble();
        if(rand< Config.greatJaggiChance){
            EntityGreatJaggi great = new EntityGreatJaggi(worldObj);
            great.setLocationAndAngles(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ(),0,0);
            great.onInitialSpawn(difficulty,livingdata);
            worldObj.spawnEntityInWorld(great);
            this.setDead();
        }else if(rand<Config.jaggiaChance){
            EntityJaggia jaggia = new EntityJaggia(worldObj);
            jaggia.setLocationAndAngles(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ(),0,0);
            jaggia.onInitialSpawn(difficulty,livingdata);
            worldObj.spawnEntityInWorld(jaggia);
            this.setDead();
        }
        return super.onInitialSpawn(difficulty, livingdata);
    }
}
