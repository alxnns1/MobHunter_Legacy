package com.alxnns1.mobhunter.entity.AI;

import com.alxnns1.mobhunter.entity.ISpitAttackMob;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Alex on 08/12/2016.
 */
public class EntityAIAttackMeleeAndSpit extends EntityAIBase
{
    World worldObj;
    protected EntityCreature attacker;
    private final ISpitAttackMob spitAttacker;
    /**
     * A decrementing tick that spawns a spit attack once this value reaches 0. It is then set back to the
     * maxSpitAttackTime.
     */
    private int spitAttackTime;
    private final int spitIntervalMin;
    /** The maximum time the AI has to wait before peforming another spit attack. */
    private final int maxSpitAttackTime;
    private final float maxSpitDistance;
    private final float minSpitDistance;
    /** An amount of decrementing ticks that allows the entity to attack once the tick reaches 0. */
    protected int attackTick;
    /** The speed with which the mob will approach the target */
    double speedTowardsTarget;
    /** When true, the mob will continue chasing its target, even if it can't find a path to them right now. */
    boolean longMemory;
    /** The PathEntity of our entity. */
    Path entityPathEntity;
    private int delayCounter;
    private double targetX;
    private double targetY;
    private double targetZ;
    protected final int attackInterval = 20;
    private int failedPathFindingPenalty = 0;
    private boolean canPenalize = false;

    public EntityAIAttackMeleeAndSpit(ISpitAttackMob creature, double speedIn, int maxSpitAttackTimeIn, float maxSpitistanceIn, float minSpitDistanceIn, boolean useLongMemory) {
        this.spitAttackTime = -1;
        this.spitAttacker = creature;
        this.attacker = (EntityCreature) creature;
        this.worldObj = attacker.world;
        this.speedTowardsTarget = speedIn;
        this.longMemory = useLongMemory;
        this.spitIntervalMin = maxSpitAttackTimeIn;
        this.maxSpitAttackTime = maxSpitAttackTimeIn;
        this.maxSpitDistance = maxSpitistanceIn;
        this.minSpitDistance = minSpitDistanceIn;
        this.setMutexBits(3);

    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute() {
        EntityLivingBase target = this.attacker.getAttackTarget();

        if (target == null) {
            return false;
        }else if (!target.isEntityAlive()) {
            return false;
        }else{
            if (canPenalize) {
                if (--this.delayCounter <= 0) {
                    this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(target);
                    this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);
                    return this.entityPathEntity != null;
                } else {
                    return true;
                }
            }
            this.entityPathEntity = this.attacker.getNavigator().getPathToEntityLiving(target);
            return this.entityPathEntity != null;
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting() {
        EntityLivingBase entitylivingbase = this.attacker.getAttackTarget();
        return entitylivingbase == null ? false : (!entitylivingbase.isEntityAlive() ? false : (!this.longMemory ? !this.attacker.getNavigator().noPath() : (!this.attacker.isWithinHomeDistanceFromPosition(new BlockPos(entitylivingbase)) ? false : !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer)entitylivingbase).isSpectator() && !((EntityPlayer)entitylivingbase).isCreative())));
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting() {
        this.attacker.getNavigator().setPath(this.entityPathEntity, this.speedTowardsTarget);
        this.delayCounter = 0;
    }

    /**
     * Resets the task
     */
    public void resetTask() {
        this.spitAttackTime = -1;

        EntityLivingBase target = this.attacker.getAttackTarget();

        if (target instanceof EntityPlayer && (((EntityPlayer)target).isSpectator() || ((EntityPlayer)target).isCreative()))
        {
            this.attacker.setAttackTarget((EntityLivingBase)null);
        }

        this.attacker.getNavigator().clearPathEntity();
    }

    /**
     * Updates the task
     */
    public void updateTask() {
        EntityLivingBase target = this.attacker.getAttackTarget();
        this.attacker.getLookHelper().setLookPositionWithEntity(target, 30.0F, 30.0F);
        double distSqr = this.attacker.getDistanceSq(target.posX, target.getEntityBoundingBox().minY, target.posZ);
        --this.delayCounter;

        if ((this.longMemory || this.attacker.getEntitySenses().canSee(target)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || target.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.attacker.getRNG().nextFloat() < 0.05F)) {
            this.targetX = target.posX;
            this.targetY = target.getEntityBoundingBox().minY;
            this.targetZ = target.posZ;
            this.delayCounter = 4 + this.attacker.getRNG().nextInt(7);

            if (this.canPenalize) {
                this.delayCounter += failedPathFindingPenalty;
                if (this.attacker.getNavigator().getPath() != null) {
                    net.minecraft.pathfinding.PathPoint finalPathPoint = this.attacker.getNavigator().getPath().getFinalPathPoint();
                    if (finalPathPoint != null && target.getDistanceSq(finalPathPoint.xCoord, finalPathPoint.yCoord, finalPathPoint.zCoord) < 1)
                        failedPathFindingPenalty = 0;
                    else
                        failedPathFindingPenalty += 10;
                }else{
                    failedPathFindingPenalty += 10;
                }
            }

            if (distSqr > 1024.0D) {
                this.delayCounter += 10;
            }else if (distSqr > 256.0D) {
                this.delayCounter += 5;
            }

            if (!this.attacker.getNavigator().tryMoveToEntityLiving(target, this.speedTowardsTarget)) {
                this.delayCounter += 15;
            }
        }

        if (MathHelper.sqrt(distSqr) <= this.maxSpitDistance) {
            if (--this.spitAttackTime <= 0) {
                float f = MathHelper.sqrt(distSqr) / this.maxSpitDistance;
                this.spitAttacker.attackEntityWithSpitAttack(target);
                this.spitAttackTime = MathHelper.floor(f * (float) (this.maxSpitAttackTime - this.spitIntervalMin) + (float) this.spitIntervalMin);
            }
        }

        this.attackTick = Math.max(this.attackTick - 1, 0);
        this.attackEntityWithMelee(target, distSqr);
    }

    protected void attackEntityWithMelee(EntityLivingBase target, double dist) {
        double attackReachSqr = this.getAttackReachSqr(target);

        if (dist <= attackReachSqr && this.attackTick <= 0) {
            this.attackTick = 20;
            this.attacker.swingArm(EnumHand.MAIN_HAND);
            this.attacker.attackEntityAsMob(target);
        }
    }

    protected double getAttackReachSqr(EntityLivingBase attackTarget) {
        return (double)(this.attacker.width * 2.0F * this.attacker.width * 2.0F + attackTarget.width);
    }
}