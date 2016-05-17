package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by Alex on 17/05/2016.
 */
public class EntityGargwa extends EntityMHHerbivore {
    public EntityGargwa(World worldIn){
        super(worldIn, 0.79f, 1.24f, MHItems.itemThunderbug);
        this.setSize(1.0F, 1.25F);
        setBaseHealth(7);
        setBaseSpeed(0.3);
        setBaseKnockback(0.1);
    }

    @Override
    public float getEyeHeight()
    {
        return 1.5625F;
    }

    protected Item getDropItem()
    {
        return MHItems.itemRawMeat;
    }

    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        if(!hitByPlayer) {
            int i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                this.dropItem(MHItems.itemMonsterBoneS, 1);
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                this.dropItem(MHItems.itemRawMeat, 1);
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<70){
                    this.dropItem(MHItems.itemRawMeat, 1);
                }else if(i<85){
                    this.dropItem(MHItems.itemMonsterBoneS, 1);
                }else if(i<100){
                    this.dropItem(MHItems.itemGargwaFeather, 1);
                }
            }
            int i = this.rand.nextInt(99);
            if(i<60){
                this.dropItem(MHItems.itemSteelEgg, 1);
            }else if(i<90){
                this.dropItem(MHItems.itemHerb, 1);
            }else if(i<100){
                this.dropItem(MHItems.itemInsectHusk, 1);
            }
        }
    }

    public EntityGargwa createChild(EntityAgeable ageable)
    {
        return new EntityGargwa(this.worldObj);
    }
}
