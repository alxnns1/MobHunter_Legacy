package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.entity.EntityAgeable;
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
                this.dropItem(MHItems.itemBirdWyvernFang, 1);
            }
            i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
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
