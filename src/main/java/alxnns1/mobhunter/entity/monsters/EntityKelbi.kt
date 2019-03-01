package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MetaRef
import alxnns1.mobhunter.reference.Names
import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

class EntityKelbi(worldIn: World) : EntityMHHerbivore(worldIn) {
    init {
        setSize(0.9f, 1.3f)
        baseHealth = 5.0
        baseSpeed = 0.2
        baseKnockBack = 0.2
    }

    override fun getEyeHeight() = 1.375f

    override fun dropFewItems(hitByPlayer: Boolean, lootingLevel: Int) {
        for (n in 0..lootingLevel) {
            val randomDrop = rand.nextInt(100)
            if (hitByPlayer) {
                when {
                    randomDrop < 45 -> dropSingleItem(MHItems.itemHerbivoreDrop, MetaRef.getMeta(MetaRef.EnumItemType.HERBIVORE_DROP, Names.Items.KELBI_HORN))
                    randomDrop < 75 -> dropSingleItem(MHItems.itemHerbivoreDrop, MetaRef.getMeta(MetaRef.EnumItemType.HERBIVORE_DROP, Names.Items.WARM_PELT))
                    randomDrop < 90 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE))
                    else -> dropSingleItem(MHItems.itemRawMeat)
                }
            } else {
                when {
                    randomDrop < 73 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE))
                    else -> dropSingleItem(MHItems.itemRawMeat)
                }
            }
        }
    }

    override fun createChild(ageable: EntityAgeable) = EntityKelbi(world)
}
