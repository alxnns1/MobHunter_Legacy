package com.alxnns1.mobhunter.entity;

import com.google.common.collect.Lists;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.Constants;

import java.awt.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Mark on 07/12/2016.
 */
public class EntitySpit extends Entity implements IProjectile
{
    private EntityLivingBase sourceEntity;
    private UUID sourceUUID;
    private float attackDamage;
    private PotionEffect[] potionEffects;
    public Color particleColour;
    private ItemStack itemToRender;
    private String damageType;

    private Entity ignoreEntity;
    private int ignoreTime;

    public EntitySpit(World world)
    {
        this(world, null, "Spit", 0f, 1f);
    }

    public EntitySpit(World world, EntityLivingBase sourceEntity, String damageTypeIn, float attackDamage, float velocity, PotionEffect... potionEffects)
    {
        super(world);
        sourceUUID = sourceEntity == null ? null : sourceEntity.getUniqueID();
        this.damageType = damageTypeIn;
        this.attackDamage = attackDamage;
        this.potionEffects = potionEffects;
        particleColour = new Color(PotionUtils.getPotionColorFromEffectList(Lists.newArrayList(potionEffects)));
        if(sourceEntity != null)
        {
            setHeadingFromThrower(sourceEntity, velocity);
            setPosition(sourceEntity.posX, sourceEntity.posY + sourceEntity.getEyeHeight(), sourceEntity.posZ);
        }
        setItemToRender(new ItemStack(Items.DYE, 1, 15));
    }

    public void setItemToRender(ItemStack item)
    {
        itemToRender = item.copy();
    }

    public ItemStack getItemToRender()
    {
        return itemToRender;
    }

    public void setParticleColour(int colour)
    {
        particleColour = new Color(colour);
    }

    public void setParticleColour(int r, int g, int b)
    {
        particleColour = new Color(r, g, b);
    }

    public EntityLivingBase getSourceEntity()
    {
        if(sourceEntity == null && sourceUUID != null && world instanceof WorldServer)
        {
            Entity entity = ((WorldServer) world).getEntityFromUuid(sourceUUID);
            if(entity instanceof EntityLivingBase)
                sourceEntity = (EntityLivingBase) entity;
        }
        return sourceEntity;
    }

    @Override
    protected void entityInit() {}

    @Override
    protected void writeEntityToNBT(NBTTagCompound tag)
    {
        tag.setFloat("damage", attackDamage);
        tag.setInteger("colour", particleColour.getRGB());
        tag.setUniqueId("source", sourceUUID);
        if(potionEffects != null && potionEffects.length > 0)
        {
            NBTTagList effectList = new NBTTagList();
            for(PotionEffect p : potionEffects)
                effectList.appendTag(p.writeCustomPotionEffectToNBT(new NBTTagCompound()));
            tag.setTag("effects", effectList);
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tag)
    {
        attackDamage = tag.getFloat("damage");
        particleColour = new Color(tag.getInteger("colour"));
        sourceUUID = tag.getUniqueId("source");
        if(tag.hasKey("effects"))
        {
            NBTTagList effectList = tag.getTagList("effects", Constants.NBT.TAG_COMPOUND);
            potionEffects = new PotionEffect[effectList.tagCount()];
            for(int i = 0; i < effectList.tagCount(); i++)
                potionEffects[i] = PotionEffect.readCustomPotionEffectFromNBT(effectList.getCompoundTagAt(i));
        }
    }

    /**
     * Copied from EntityArrow and EntityThrowable (both are the same, and only implementations of this method)
     */
    @Override
    public void setThrowableHeading(double x, double y, double z, float velocity, float inaccuracy)
    {
        float f = MathHelper.sqrt(x * x + y * y + z * z);
        x = x / (double)f;
        y = y / (double)f;
        z = z / (double)f;
        x = x + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        y = y + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        z = z + this.rand.nextGaussian() * 0.007499999832361937D * (double)inaccuracy;
        x = x * (double)velocity;
        y = y * (double)velocity;
        z = z * (double)velocity;
        motionX = x;
        motionY = y;
        motionZ = z;
        float f1 = MathHelper.sqrt(x * x + z * z);
        rotationYaw = (float)(MathHelper.atan2(x, z) * (180D / Math.PI));
        rotationPitch = (float)(MathHelper.atan2(y, (double)f1) * (180D / Math.PI));
        prevRotationYaw = rotationYaw;
        prevRotationPitch = rotationPitch;
    }

    /**
     * Sets throwable heading based on an entity that's throwing it
     * Mostly copied from EntityThrowable
     */
    public void setHeadingFromThrower(Entity entityThrower, float velocity)
    {
        setThrowableHeading(entityThrower.getLookVec().xCoord, entityThrower.getLookVec().yCoord, entityThrower.getLookVec().zCoord, velocity, 1f);
        motionX += entityThrower.motionX;
        motionZ += entityThrower.motionZ;

        if (!entityThrower.onGround)
            motionY += entityThrower.motionY;
    }

    /**
     * Called when the entity hits a block or entity
     */
    protected void onHit(RayTraceResult rayTraceResult)
    {
        Entity entityHit = rayTraceResult.entityHit;
        if(entityHit != null)
        {
            //Hit entity
            if(attackDamage > 0)
                entityHit.attackEntityFrom(new EntityDamageSourceIndirect(damageType, this, sourceEntity), attackDamage);
            //Apply potion effects
            if(entityHit instanceof EntityLivingBase && potionEffects != null && potionEffects.length > 0)
            {
                EntityLivingBase livingHit = (EntityLivingBase) entityHit;
                for(PotionEffect p : potionEffects)
                    livingHit.addPotionEffect(p);
            }
        }else{
            AxisAlignedBB radius = new AxisAlignedBB(this.posX - 1, this.posY - 1, this.posZ - 1, this.posX + 1, this.posY + 1, this.posZ + 1);
            for(Entity e : world.getEntitiesWithinAABBExcludingEntity(this, radius)) {
                for(PotionEffect p : potionEffects) {
                    if(e instanceof EntityLivingBase) {
                        ((EntityLivingBase) e).addPotionEffect(p);
                    }
                }
            }
        }
        playSound(SoundEvents.ENTITY_GENERIC_SPLASH, 1f, 1.2f / (rand.nextFloat() * 0.2f + 0.9f));

        for(int i = 0; i < 8; ++i)
            //The Spell Mob particle uses the speed parameters for colour
            world.spawnParticle(EnumParticleTypes.SPELL_MOB, posX, posY, posZ, particleColour.getRed(), particleColour.getGreen(), particleColour.getBlue());

        if(!world.isRemote)
            setDead();
    }

    @Override
    public void onUpdate()
    {
        lastTickPosX = posX;
        lastTickPosY = posY;
        lastTickPosZ = posZ;
        super.onUpdate();

        Vec3d pos = getPositionVector();
        Vec3d nextPos = pos.addVector(motionX, motionY, motionZ);
        RayTraceResult ray = world.rayTraceBlocks(pos, nextPos);
        pos = getPositionVector();
        nextPos = pos.addVector(motionX, motionY, motionZ);
        if(ray != null)
            nextPos = ray.hitVec;

        List<Entity> entities = world.getEntitiesWithinAABBExcludingEntity(this, getEntityBoundingBox().addCoord(motionX, motionY, motionZ).expandXyz(1d));
        Entity closestEntity = null;
        double closestDistance = 0d;
        boolean flag = false;
        for(Entity e : entities)
        {
            if(!e.canBeCollidedWith()) continue;
            if(e == ignoreEntity)
                flag = true;
            else if(ticksExisted < 2 && ignoreEntity == null)
            {
                ignoreEntity = e;
                flag = true;
            }
            else
            {
                flag = false;
                AxisAlignedBB aabb = e.getEntityBoundingBox().expandXyz(0.30000001192092896D);
                RayTraceResult rayTrace = aabb.calculateIntercept(pos, nextPos);
                if(rayTrace != null)
                {
                    double distance = pos.squareDistanceTo(rayTrace.hitVec);
                    if(distance < closestDistance || closestDistance == 0d)
                    {
                        closestEntity = e;
                        closestDistance = distance;
                    }
                }
            }
        }

        if(ignoreEntity != null)
        {
            if(flag)
                ignoreTime = 2;
            else if(ignoreTime-- <= 0)
                ignoreEntity = null;
        }

        if(closestEntity != null)
            ray = new RayTraceResult(closestEntity);

        if(ray != null)
            onHit(ray);

        posX += motionX;
        posY += motionY;
        posZ += motionZ;
        double magnitude = (double) MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
        rotationYaw = (float) (MathHelper.atan2(motionX, motionZ) * (180d / Math.PI));

        /*
        while(rotationPitch - prevRotationPitch < -180f)
        {
            rotationPitch = (float)(MathHelper.atan2(motionY, magnitude) * (180D / Math.PI));
            prevRotationPitch -= 360f;
        }
        */

        for (rotationPitch = (float)(MathHelper.atan2(motionY, magnitude) * (180D / Math.PI)); rotationPitch - prevRotationPitch < -180.0F; prevRotationPitch -= 360.0F)
        {}

        while (rotationPitch - prevRotationPitch >= 180.0F)
            prevRotationPitch += 360.0F;

        while (rotationYaw - prevRotationYaw < -180.0F)
            prevRotationYaw -= 360.0F;

        while (rotationYaw - prevRotationYaw >= 180.0F)
            prevRotationYaw += 360.0F;

        rotationPitch = prevRotationPitch + (rotationPitch - prevRotationPitch) * 0.2f;
        rotationYaw = prevRotationYaw + (rotationYaw - prevRotationYaw) * 0.2f;

        double deceleration = 0.99d;
        if(isInWater())
        {
            for(int j = 0; j < 4; ++ j)
                world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, posX - motionX * 0.25d, posY - motionY * 0.25d, posZ - motionZ * 0.25d, motionX, motionY, motionZ);
            deceleration = 0.8d;
        }

        motionX *= deceleration;
        motionY *= deceleration;
        motionZ *= deceleration;

        //Method gets if entity is not affected by gravity
        if(!hasNoGravity())
            motionY -= 0.03d;

        setPosition(posX, posY, posZ);
    }
}
