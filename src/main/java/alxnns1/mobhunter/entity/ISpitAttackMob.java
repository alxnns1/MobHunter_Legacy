package alxnns1.mobhunter.entity;

import net.minecraft.entity.EntityLivingBase;

/**
 * Created by Alex on 08/12/2016.
 */
public interface ISpitAttackMob
{
	/**
	 * Attack the specified entity using a ranged attack.
	 */
	void attackEntityWithSpitAttack(EntityLivingBase target);
}
