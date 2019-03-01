package alxnns1.mobhunter.entity.monsters

import alxnns1.mobhunter.entity.IScaledMob
import alxnns1.mobhunter.init.MHItems
import alxnns1.mobhunter.reference.MHConfig
import net.minecraft.entity.IEntityLivingData
import net.minecraft.entity.SharedMonsterAttributes
import net.minecraft.entity.ai.*
import net.minecraft.entity.passive.EntityAnimal
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Items
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.network.datasync.DataSerializers
import net.minecraft.network.datasync.EntityDataManager
import net.minecraft.world.DifficultyInstance
import net.minecraft.world.World

abstract class EntityMHHerbivore @JvmOverloads constructor(
        world: World,
        minScale: Double = MHConfig.scaleMin,
        maxScale: Double = MHConfig.scaleMax,
        private val breedItem: Item = Items.WHEAT
) : EntityAnimal(world), IScaledMob {

    companion object {
        private val KEY_SCALE = "scale"
        private val ENTITY_SCALE = EntityDataManager.createKey(EntityMHHerbivore::class.java, DataSerializers.FLOAT)
        private var scaleMax = 0.0
        private var scaleMin = 0.0
    }

    var baseHealth = 5.0
    var baseSpeed = 0.1
    var baseKnockBack = 0.2

    constructor(world: World, temptFood: Item) : this(world, MHConfig.scaleMin, MHConfig.scaleMax, temptFood)

    init {
        setSize(0.9f, 1.3f)
        scaleMin = minScale
        scaleMax = maxScale
        tasks.addTask(0, EntityAISwimming(this))
        tasks.addTask(1, EntityAIPanic(this, 2.0))
        tasks.addTask(2, EntityAIMate(this, 1.0))
        tasks.addTask(3, EntityAITempt(this, 1.25, breedItem, false))
        tasks.addTask(4, EntityAIFollowParent(this, 1.25))
        tasks.addTask(5, EntityAIWander(this, 1.0))
        tasks.addTask(6, EntityAIWatchClosest(this, EntityPlayer::class.java, 6.0f))
        tasks.addTask(7, EntityAILookIdle(this))
    }

    override fun entityInit() {
        super.entityInit()
        dataManager.register(ENTITY_SCALE, 1.0f)
    }

    override fun applyEntityAttributes() {
        super.applyEntityAttributes()
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).baseValue = 10.0
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).baseValue = 0.25
    }

    override fun getDropItem() = MHItems.itemHerbivoreDrop!!

    override fun isBreedingItem(stack: ItemStack) = !stack.isEmpty && stack.item == breedItem

    override fun onInitialSpawn(difficulty: DifficultyInstance?, livingData: IEntityLivingData?): IEntityLivingData? {
        setEntityScale(rand.nextFloat() * (scaleMax - scaleMin) + scaleMin)
        return super.onInitialSpawn(difficulty, livingData)
    }

    private fun setEntityScale(scale: Double) {
        dataManager.set(ENTITY_SCALE, scale.toFloat())
        getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).baseValue = Math.round(baseHealth * scale).toDouble()
        getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).baseValue = baseSpeed * scale
        getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).baseValue = baseKnockBack * scale
        health = maxHealth
    }

    override fun getScale() = dataManager.get(ENTITY_SCALE)!!

    override fun writeEntityToNBT(tagCompound: NBTTagCompound) {
        super.writeEntityToNBT(tagCompound)
        tagCompound.setFloat(KEY_SCALE, scale)
    }

    override fun readEntityFromNBT(tagCompound: NBTTagCompound) {
        super.readEntityFromNBT(tagCompound)
        setEntityScale(tagCompound.getFloat(KEY_SCALE).toDouble())
    }

    @JvmOverloads
    fun dropSingleItem(item: Item, meta: Int = 0) = entityDropItem(ItemStack(item, 1, meta), 0f)
}
