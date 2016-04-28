package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by Mark on 21/04/2016.
 */
public class EntityPopo extends EntityScalable
{
    public EntityPopo(World worldIn)
    {
        super(worldIn, 0.79f, 1.24f);
        this.setSize(1.9F, 2.5F);
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

    public EntityPopo createChild(EntityAgeable ageable)
    {
        return new EntityPopo(this.worldObj);
    }
}
