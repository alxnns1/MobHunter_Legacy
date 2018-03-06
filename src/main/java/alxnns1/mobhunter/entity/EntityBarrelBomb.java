package alxnns1.mobhunter.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

/**
 * Created by Mark on 05/04/2017.
 */
public class EntityBarrelBomb extends EntityTNTPrimed
{
    private boolean hasBeenThrown = false;
    private int fuseStart;

    public EntityBarrelBomb(World worldIn)
    {
        super(worldIn);
        fuseStart = getFuse();
    }

    public EntityBarrelBomb(World world, EntityLivingBase thrower, float velocity)
    {
        this(world, thrower.posX, thrower.posY + (double) thrower.getEyeHeight() - 0.1d, thrower.posZ, thrower);
        setThrow(thrower, velocity);
    }

    public EntityBarrelBomb(World worldIn, double x, double y, double z, EntityLivingBase igniter)
    {
        super(worldIn, x, y, z, igniter);
        motionX = 0;
        motionY = 0;
        motionZ = 0;
    }

    @Override
    public void setFuse(int fuseIn)
    {
        super.setFuse(fuseIn);
        fuseStart = fuseIn;
    }

    /**
     * Partly copied from EntityTNTPrimed due to it being private.
     * Will kill this entity and create an explosion.
     */
    protected void explode()
    {
        setDead();
        if(!world.isRemote)
            world.createExplosion(this, posX, posY + (double)(height / 16.0F), posZ, 4.0F, true);
    }

    /**
     * Set this entity to bounce for when spawning a bouncing bomb.
     */
    public EntityBarrelBomb setBounce()
    {
        motionY = 1;
        return this;
    }

    /**
     * Set this entity to throw in the direction the thrower is looking at the velocity given.
     */
    public EntityBarrelBomb setThrow(EntityLivingBase thrower, float velocity)
    {
        hasBeenThrown = true;

        float rotYaw = thrower.rotationYaw;
        float rotPitch = thrower.rotationPitch;
        float x = - MathHelper.sin(rotYaw * 0.017453292f) * MathHelper.cos(rotPitch * 0.017453292f);
        float y = -MathHelper.sin(rotPitch * 0.017453292f);
        float z = MathHelper.cos(rotYaw * 0.017453292f) * MathHelper.cos(rotPitch * 0.017453292f);

        //This bit is normally in IProjectile#shoot
        float magnitude = MathHelper.sqrt(x * x + y * y + z * z);
        x = (x / magnitude) * velocity;
        y = (y / magnitude) * velocity;
        z = (z / magnitude) * velocity;
        motionX = x;
        motionY = y;
        motionZ = z;
        float hMagnitude = MathHelper.sqrt(x * x + z * z);
        rotationYaw = (float) (MathHelper.atan2(x, z) * (180d / Math.PI));
        rotationPitch = (float)(MathHelper.atan2(y, hMagnitude) * (180D / Math.PI));
        prevRotationYaw = rotationYaw;
        prevRotationPitch = rotationPitch;

        motionX += thrower.motionX;
        motionZ += thrower.motionZ;
        if(!thrower.onGround)
            motionY += thrower.motionY;
        
        return this;
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        super.onUpdate();

        //Collide with blocks
        if(hasBeenThrown && collided)
            explode();

        //Collide with living or item entities
        if(hasBeenThrown && getFuse() < fuseStart - 5)
        {
            List<Entity> entityList = world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
            for(Entity entity : entityList)
                if((entity instanceof EntityLivingBase || entity instanceof EntityItem)) //&& CommonUtil.getEntityVelocity(entity) >= 6d)
                {
                    explode();
                    break;
                }
        }
    }
}
