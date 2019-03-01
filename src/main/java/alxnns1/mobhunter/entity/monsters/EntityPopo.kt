package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MetaRef
import alxnns1.mobhunter.reference.Names
import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

class EntityPopo(worldIn: World) : EntityMHHerbivore(worldIn) {
    init {
        setSize(1.9f, 2.5f)
        baseHealth = 5.0
        baseSpeed = 0.1
        baseKnockBack = 0.5
    }

    override fun getEyeHeight() = 2.0f

    override fun dropFewItems(hitByPlayer: Boolean, lootingLevel: Int) {
        for (n in 0..lootingLevel) {
            val randomDrop = rand.nextInt(100)
            if (hitByPlayer) {
                when {
                    randomDrop < 45 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE))
                    randomDrop < 75 -> dropSingleItem(MHItems.itemRawMeat)
                    randomDrop < 95 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.BRUTE_BONE))
                    else -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.JUMBO_BONE))
                }
            } else {
                when {
                    randomDrop < 60 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE))
                    else -> dropSingleItem(MHItems.itemRawMeat)
                }
            }
        }
    }

    override fun createChild(ageable: EntityAgeable) = EntityPopo(world)
}
