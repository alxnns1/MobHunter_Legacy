package com.alxnns1.mobhunter.entity.monsters;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

/**
 * Created by Alex on 26/05/2016.
 */
public class EntityAptonoth extends EntityMHHerbivore{
    public EntityAptonoth(World worldIn)
    {
        super(worldIn);
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

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
    {
        if(!hitByPlayer) {
            int i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                dropSingleItem(MHItems.itemRawMeat);
            }
            i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
            }
        }else{
            for(int n=0;n<2+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<75){
                    dropSingleItem(MHItems.itemRawMeat);
                }else{
                    dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
                }
            }
        }
    }

    public EntityAptonoth createChild(EntityAgeable ageable)
    {
        return new EntityAptonoth(this.world);
    }
}
