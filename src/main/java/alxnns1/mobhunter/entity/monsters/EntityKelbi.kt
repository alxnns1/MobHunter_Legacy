package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MetaRef
import alxnns1.mobhunter.reference.Names
import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

/**
 * Created by Alex on 27/04/2016.
 */
class EntityKelbi(worldIn: World) : EntityMHHerbivore(worldIn) {
    init {
        setSize(0.9f, 1.3f)
        setBaseHealth(5)
        setBaseSpeed(0.2)
        setBaseKnockback(0.2)
    }

    override fun getEyeHeight() = 1.375f

    /**
     * Drop 0-2 items of this living's type
     */
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
                    randomDrop < 70 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE))
                    else -> dropSingleItem(MHItems.itemRawMeat)
                }
            }
        }
    }

    override fun createChild(ageable: EntityAgeable) = EntityKelbi(world)
}
