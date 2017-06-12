package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.Config;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.potion.PotionEffectParalyse;
import alxnns1.mobhunter.reference.MetaRef;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Alex on 11/12/2016.
 */
public class EntityGendrome extends EntityMHBirdWyvern {
    public EntityGendrome(World worldIn) {
        super(worldIn, Config.scaleMin*0.75f, Config.scaleMax*0.75f);
        this.setSize(2.25F, 2.5F);
        setBaseHealth(300);
        setBaseAttack(2*1.5);
        setBaseSpeed(0.3*1.5);
        setBaseKnockback(0.5*1.5);
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
    public float getEyeHeight() {
        return 3.75F;
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
        if(!hitByPlayer) {
            int i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int j = 0; j < i; ++j) {
                dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC));
            }
            i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
            for (int k = 0; k < i; ++k) {
                dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HIDE));
            }
        }else{
            for(int n=0;n<3+lootingLevel;n++) {
                int i = this.rand.nextInt(99);
                if(i<18){
                    dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_CLAW));
                }else if(i<60){
                    dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HIDE));
                }else if(i<65){
                    dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENPREY_SCALE));
                }else if(i<71){
                    dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.GENDROME_HEAD));
                }else{
                    dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.PARALYSIS_SAC));
                }
            }
        }
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        if (super.attackEntityAsMob(entityIn)) {
            if (entityIn.getHorizontalFacing() == this.getHorizontalFacing()) {
                ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffectParalyse(320));
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
     * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
     */
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        setBaseHealth(375);
        setBaseAttack(3*1.5);
        setBaseSpeed(0.3*1.5);
        setBaseKnockback(0.5*1.5);
        double rand = this.rand.nextInt(8) + 6;
        for(int i=0;i<rand;i++) {
            EntityGenprey genprey = new EntityGenprey(world);
            genprey.setLocationAndAngles(this.getPosition().getX(),this.getPosition().getY(),this.getPosition().getZ(),0,0);
            genprey.onInitialSpawn(difficulty,livingdata);
            world.spawnEntity(genprey);
        }
        return super.onInitialSpawn(difficulty, livingdata);
    }
}
