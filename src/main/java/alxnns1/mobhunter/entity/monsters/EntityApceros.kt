package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MHConfig
import alxnns1.mobhunter.reference.MetaRef
import alxnns1.mobhunter.reference.Names
import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

class EntityApceros(worldIn: World) : EntityMHHerbivore(worldIn, MHConfig.scaleMin * 1.5f, MHConfig.scaleMax * 1.5f) {
    init {
        setSize(3.0f, 3.5f)
        baseHealth = 20 / 1.5
        baseSpeed = 0.15
        baseKnockBack = 0.5
    }

    override fun getEyeHeight() = 1.75f

    override fun dropFewItems(hitByPlayer: Boolean, lootingLevel: Int) {
        for (n in 0..lootingLevel) {
            val randomDrop = this.rand.nextInt(100)
            if (hitByPlayer) {
                when {
                    randomDrop < 45 -> dropSingleItem(MHItems.itemRawMeat)
                    randomDrop < 90 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S))
                    else -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M))
                }
            } else {
                when {
                    randomDrop < 50 -> dropSingleItem(MHItems.itemRawMeat)
                    else -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S))
                }
            }
        }
    }

    override fun createChild(ageable: EntityAgeable) = EntityApceros(this.world)
}
