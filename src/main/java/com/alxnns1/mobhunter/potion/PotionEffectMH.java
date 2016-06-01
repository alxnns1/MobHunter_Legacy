package com.alxnns1.mobhunter.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Mark on 01/06/2016.
 */
public class PotionEffectMH extends PotionEffect
{
    private boolean applyEffect = true;

    public PotionEffectMH(int id, int effectDuration, int effectAmplifier, boolean ambient, boolean showParticles)
    {
        super(id, effectDuration, effectAmplifier, ambient, showParticles);
    }

    /**
     * Happens on the first tick
     */
    public void onApplyEffect(EntityLivingBase entityIn) {}

    /**
     * Happen on every tick between the first and last
     */
    public void performEffect(EntityLivingBase entityIn) {}

    /**
     * Happens on the last tick
     */
    public void onEndEffect(EntityLivingBase entityIn) {}

    /**
     * Happens on every tick
     */
    public boolean onUpdate(EntityLivingBase entityIn)
    {
        if(applyEffect)
        {
            onApplyEffect(entityIn);
            applyEffect = false;
        }
        else if(getDuration() <= 1)
            onEndEffect(entityIn);
        else
            performEffect(entityIn);

        return super.onUpdate(entityIn);
    }
}
