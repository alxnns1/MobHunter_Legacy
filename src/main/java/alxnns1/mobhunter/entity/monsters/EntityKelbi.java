package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.world.World;

/**
 * Created by Alex on 27/04/2016.
 */
public class EntityKelbi extends EntityMHHerbivore {
	public EntityKelbi(World worldIn) {
		super(worldIn);
		this.setSize(0.9F, 1.3F);
		setBaseHealth(5);
		setBaseSpeed(0.2);
		setBaseKnockback(0.2);
	}

	@Override
	public float getEyeHeight() {
		return 1.375F;
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean hitByPlayer, int lootingLevel) {
		if (!hitByPlayer) {
			int i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
			for (int j = 0; j < i; ++j) {
				dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE));
			}
			i = this.rand.nextInt(2) + this.rand.nextInt(1 + lootingLevel);
			for (int k = 0; k < i; ++k) {
				dropSingleItem(MHItems.itemRawMeat);
			}
		} else {
			for (int n = 0; n < 1 + lootingLevel; n++) {
				int i = this.rand.nextInt(99);
				if (i < 45) {
					dropSingleItem(MHItems.itemHerbivoreDrop, MetaRef.getMeta(MetaRef.EnumItemType.HERBIVORE_DROP, Names.Items.KELBI_HORN));
				} else if (i < 75) {
					dropSingleItem(MHItems.itemHerbivoreDrop, MetaRef.getMeta(MetaRef.EnumItemType.HERBIVORE_DROP, Names.Items.WARM_PELT));
				} else if (i < 90) {
					dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE));
				} else {
					dropSingleItem(MHItems.itemRawMeat);
				}
			}
		}
	}

	public EntityKelbi createChild(EntityAgeable ageable) {
		return new EntityKelbi(this.world);
	}
}
