package com.alxnns1.mobhunter.entity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Created by Alex on 17/05/2016.
 */
public class EntityGargwa extends EntityMHHerbivore {
    public EntityGargwa(World worldIn){
        super(worldIn, 0.79f, 1.24f, MHItems.itemBug);
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
                dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemRawMeat);
            }
        }else{
            for(int n=0;n<1+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<70){
                    dropSingleItem(MHItems.itemRawMeat);
                }else if(i<85){
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.MONSTER_BONE_S));
                }else{
                    dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.GARGWA_FEATHER));
                }
            }
            int i = this.rand.nextInt(99);
            if(i<60){
                dropSingleItem(MHItems.itemMonsterDrop, MetaRef.getMeta(MetaRef.EnumItemType.MONSTER_DROP, Names.Items.STEEL_EGG));
            }else if(i<90){
                dropSingleItem(MHItems.itemConsumable, MetaRef.getMeta(MetaRef.EnumItemType.CONSUMABLE, Names.Items.HERB));
            }else{
                dropSingleItem(MHItems.itemBug, MetaRef.getMeta(MetaRef.EnumItemType.BUG, Names.Items.INSECT_HUSK));
            }
        }
    }

    public EntityGargwa createChild(EntityAgeable ageable)
    {
        return new EntityGargwa(this.worldObj);
    }
}
