package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MetaRef
import alxnns1.mobhunter.reference.Names
import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

class EntityAptonoth(worldIn: World) : EntityMHHerbivore(worldIn) {
    init {
        setSize(3.0f, 3.5f)
        baseHealth = 8.0
        baseSpeed = 0.15
        baseKnockBack = 0.5
    }

    override fun getEyeHeight() = 3.75f

    override fun dropFewItems(hitByPlayer: Boolean, lootingLevel: Int) {
        for (n in 0..lootingLevel) {
            val randomDrop = rand.nextInt(100)
            if (randomDrop < 75) {
                dropSingleItem(MHItems.itemRawMeat)
            } else {
                dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S))
            }
        }
    }

    override fun createChild(ageable: EntityAgeable) = EntityAptonoth(this.world)
}
