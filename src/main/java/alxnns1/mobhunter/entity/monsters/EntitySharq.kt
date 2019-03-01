package alxnns1.mobhunter.entity.monsters

import net.minecraft.entity.EntityAgeable
import net.minecraft.world.World

class EntitySharq(worldIn: World) : EntityMHMarine(worldIn) {
    init {
        setSize(3.0f, 3.5f)
        setBaseHealth(10)
        setBaseSpeed(0.15)
        setBaseKnockback(0.5)
    }

    override fun createChild(ageable: EntityAgeable) = EntitySharq(world)
}
