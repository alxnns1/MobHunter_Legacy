package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Alex on 27/04/2016.
 */
public class EntityKelbi extends EntityMHHerbivore
{
    public EntityKelbi(World worldIn)
    {
        super(worldIn);
        this.setSize(0.9F, 1.3F);
        setBaseHealth(5);
        setBaseSpeed(0.2);
        setBaseKnockback(0.2);
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
            int i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                dropSingleItem(MHItems.itemMonsterDrop, 2); //Mystery Bone
            }
            i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                this.dropSingleItem(MHItems.itemRawMeat, 1);
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<45){
                    dropSingleItem(MHItems.itemMonsterDrop, 10); //Kelbi Horn
                }else if(i<75){
                    dropSingleItem(MHItems.itemMonsterDrop, 11); //Warm Pelt
                }else if(i<90){
                    dropSingleItem(MHItems.itemMonsterDrop, 2); //Mystery Bone
                }else if(i<100){
                    dropSingleItem(MHItems.itemRawMeat);
                }
            }
        }
    }

    public EntityKelbi createChild(EntityAgeable ageable)
    {
        return new EntityKelbi(this.worldObj);
    }
}
