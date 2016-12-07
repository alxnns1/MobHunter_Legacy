package com.alxnns1.mobhunter.entity.monsters;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.world.World;

/**
 * Created by Mark on 21/04/2016.
 */
public class EntityPopo extends EntityMHHerbivore
{
    public EntityPopo(World worldIn)
    {
        super(worldIn);
        this.setSize(1.9F, 2.5F);
        setBaseHealth(5);
        setBaseSpeed(0.1);
        setBaseKnockback(0.5);
    }

    @Override
    public float getEyeHeight()
    {
        return 2.0F;
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
                dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE));
            }
            i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemRawMeat);
            }
        }else{
            for(int n=0;n<2+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<45){
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MYSTERY_BONE));
                }else if(i<75){
                    dropSingleItem(MHItems.itemRawMeat);
                }else if(i<95){
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.BRUTE_BONE));
                }else{
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.JUMBO_BONE));
                }
            }
        }
    }

    public EntityPopo createChild(EntityAgeable ageable)
    {
        return new EntityPopo(this.worldObj);
    }
}
