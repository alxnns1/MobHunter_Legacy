package alxnns1.mobhunter.entity.monsters;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

/**
 * Created by Alex on 24/02/2017.
 */
public class EntitySharq extends EntityMHMarine {
	public EntitySharq(World worldIn) {
		super(worldIn);
		this.setSize(3.0F, 3.5F);
		setBaseHealth(10);
		setBaseSpeed(0.15);
		setBaseKnockback(0.5);
	}

	public EntitySharq createChild(EntityAgeable ageable) {
		return new EntitySharq(this.world);
	}
}
