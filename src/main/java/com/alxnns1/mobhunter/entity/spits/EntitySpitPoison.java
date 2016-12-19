package com.alxnns1.mobhunter.entity.spits;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

/**
 * Created by Mark on 19/12/2016.
 */
public class EntitySpitPoison extends EntitySpit
{
    public EntitySpitPoison(World world)
    {
        super(world);
    }
    public EntitySpitPoison(World world, EntityLivingBase sourceEntity, String damageTypeIn, float attackDamage, float velocity, PotionEffect... potionEffects)
    {
        super(world, sourceEntity, damageTypeIn, attackDamage, velocity, potionEffects);
    }
}
