package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by Alex on 26/05/2016.
 */
public class EntityAptonoth extends EntityMHHerbivore{
    public EntityAptonoth(World worldIn)
    {
        super(worldIn, 0.79f, 1.24f);
        this.setSize(3.0F, 3.5F);
        setBaseHealth(8);
        setBaseSpeed(0.15);
        setBaseKnockback(0.5);
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
            int i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                this.dropItem(MHItems.itemRawMeat, 1);
            }
            i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                this.dropItem(MHItems.itemMonsterBoneS, 1);
            }
        }else{
            for(int n=0;n<2+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<75){
                    this.dropItem(MHItems.itemRawMeat, 1);
                }else if(i<100){
                    this.dropItem(MHItems.itemMonsterBoneS, 1);
                }
            }

        }
    }

    public EntityAptonoth createChild(EntityAgeable ageable)
    {
        return new EntityAptonoth(this.worldObj);
    }
}
