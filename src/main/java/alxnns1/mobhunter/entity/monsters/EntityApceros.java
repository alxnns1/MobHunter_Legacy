package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MHConfig;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

/**
 * Created by Alex on 23/02/2017.
 */
public class EntityApceros extends EntityMHHerbivore{
    public EntityApceros(World worldIn)
    {
        super(worldIn, MHConfig.scaleMin*1.5f, MHConfig.scaleMax*1.5f);
        this.setSize(3.0F, 3.5F);
        setBaseHealth((int)(20/1.5));
        setBaseSpeed(0.15);
        setBaseKnockback(0.5);
    }

    @Override
    public float getEyeHeight()
    {
        return 1.75F;
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
                if(i<45){
                    dropSingleItem(MHItems.itemRawMeat);
                }else if(i<90){
                    dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
                }else{
                    dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M));
                }
            }
        }
    }

    public EntityApceros createChild(EntityAgeable ageable)
    {
        return new EntityApceros(this.world);
    }
}
