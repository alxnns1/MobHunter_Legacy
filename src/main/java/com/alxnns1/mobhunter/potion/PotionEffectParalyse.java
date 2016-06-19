package com.alxnns1.mobhunter.potion;

import com.alxnns1.mobhunter.init.MHPotions;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;

/**
 * Created by Mark on 01/06/2016.
 */
public class PotionEffectParalyse extends PotionEffectMH
{
    private double x, y, z;
    private float pitch, yaw;

    public PotionEffectParalyse(int effectDuration)
    {
        super(MHPotions.potionParalyse, effectDuration, 0);
    }

    /**
     * Happens on the first tick
     */
    public void onApplyEffect(EntityLivingBase entityIn)
    {
        //LogHelper.info("Applying Paralyse!");
        this.pitch = entityIn.rotationPitch;
        this.yaw = entityIn.rotationYawHead;
        this.x = entityIn.posX;
        this.y = entityIn.posY;
        this.z = entityIn.posZ;
    }

    /**
     * Happen on every tick between the first and last
     */
    public void performEffect(EntityLivingBase entityIn)
    {
        //TODO: Try to allow falling - Use Slowness and Jumping without showing teh potion effect?
        //LogHelper.info("Paralysing!");
        if(entityIn instanceof EntityPlayerMP)
            ((EntityPlayerMP)entityIn).connection.setPlayerLocation(this.x, this.y, this.z, this.yaw, this.pitch);
        else
        {
            entityIn.motionX = 0f;
            entityIn.motionY = 0f;
            entityIn.motionZ = 0f;
            entityIn.rotationPitch = this.pitch;
            entityIn.rotationYawHead = this.yaw;
        }
    }
}
