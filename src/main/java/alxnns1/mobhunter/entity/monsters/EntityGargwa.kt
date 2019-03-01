package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MetaRef
import alxnns1.mobhunter.reference.Names
import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

class EntityGargwa(worldIn: World) : EntityMHHerbivore(worldIn, MHItems.itemBug) {
    init {
        setSize(1.0f, 1.25f)
        baseHealth = 7.0
        baseSpeed = 0.3
        baseKnockBack = 0.1
    }

    override fun getEyeHeight() = 1.5625f

    override fun dropFewItems(hitByPlayer: Boolean, lootingLevel: Int) {
        for (n in 0..lootingLevel) {
            val randomDrop = rand.nextInt(100)
            if (hitByPlayer) {
                when {
                    randomDrop < 70 -> dropSingleItem(MHItems.itemRawMeat)
                    randomDrop < 85 -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S))
                    else -> dropSingleItem(MHItems.itemHerbivoreDrop, MetaRef.getMeta(MetaRef.EnumItemType.HERBIVORE_DROP, Names.Items.GARGWA_FEATHER))
                }
            } else {
                when {
                    randomDrop < 82 -> dropSingleItem(MHItems.itemRawMeat)
                    else -> dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S))
                }
            }
        }
        if (hitByPlayer) {
            val randomDrop = rand.nextInt(100)
            when {
                randomDrop < 60 -> dropSingleItem(MHItems.itemMisc, MetaRef.getMeta(MetaRef.EnumItemType.MISC, Names.Items.STEEL_EGG))
                randomDrop < 90 -> dropSingleItem(MHItems.itemPlant, MetaRef.getMeta(MetaRef.EnumItemType.PLANT, Names.Items.HERB))
                else -> dropSingleItem(MHItems.itemBug, MetaRef.getMeta(MetaRef.EnumItemType.BUG, Names.Items.INSECT_HUSK))
            }
        }
    }

    override fun createChild(ageable: EntityAgeable) = EntityGargwa(this.world)
}
