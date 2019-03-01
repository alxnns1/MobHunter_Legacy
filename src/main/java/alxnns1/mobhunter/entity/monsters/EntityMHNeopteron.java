package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.entity.IScaledMob;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MHConfig;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

/**
 * Created by Alex on 17/05/2016.
 */
public class EntityMHNeopteron extends EntityMob implements IScaledMob {
	private static final String KEY_SCALE = "scale";
	private static final DataParameter<Float> ENTITY_SCALE = EntityDataManager.createKey(EntityMHHerbivore.class, DataSerializers.FLOAT);
	private static double scaleMax; //= 1.24d;
	private static double scaleMin; //= 0.79d;
	private double baseHealth = 5d;
	private double baseSpeed = 0.1d;
	private double baseKnockback = 0.2d;
	private double baseAttack = 0;

	public EntityMHNeopteron(World world) {
		this(world, MHConfig.scaleMin, MHConfig.scaleMax, MHItems.itemMushroom);
	}

	public EntityMHNeopteron(World world, double minScale, double maxScale) {
		this(world, minScale, maxScale, MHItems.itemMushroom);
	}

	public EntityMHNeopteron(World world, double minScale, double maxScale, Item temptFood) {
		super(world);
		this.setSize(0.9F, 1.3F); //Same as cow
		scaleMin = minScale;
		scaleMax = maxScale;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAITempt(this, 1.25D, temptFood, true));
		this.tasks.addTask(5, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	protected void entityInit() {
		super.entityInit();
		//Creates the datawatcher object to save the entity scale in
		this.dataManager.register(ENTITY_SCALE, 1.0f);
	}

	//Same as pig
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
	}

	protected Item getDropItem() {
		return MHItems.itemNeopteranDrop;
	}

	/**
	 * Called only once on an entity when first time spawned, via egg, mob spawner, natural spawning etc, but not called
	 * when entity is reloaded from nbt. Mainly used for initializing attributes and inventory
	 */
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
		double scale = (this.rand.nextFloat() * (scaleMax - scaleMin)) + scaleMin;
		this.setEntityScale(scale);
		return super.onInitialSpawn(difficulty, livingdata);
	}

	@Override
	public boolean getCanSpawnHere() {
		return this.world.getDifficulty() != EnumDifficulty.PEACEFUL;
	}

	private void setEntityScale(double scale) {
		//Gets the datawatcher value for the entity scale
		this.dataManager.set(ENTITY_SCALE, (float) scale);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) Math.round(baseHealth * scale));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed * scale);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(baseKnockback * scale);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(baseAttack * scale);
		this.setHealth(this.getMaxHealth());
	}

	public float getScale() {
		return this.dataManager.get(ENTITY_SCALE);
	}

	public void writeEntityToNBT(NBTTagCompound tagCompound) {
		super.writeEntityToNBT(tagCompound);
		tagCompound.setFloat(KEY_SCALE, getScale());
	}

	public void readEntityFromNBT(NBTTagCompound tagCompund) {
		super.readEntityFromNBT(tagCompund);
		setEntityScale(tagCompund.getFloat(KEY_SCALE));
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	protected void setBaseHealth(int health) {
		baseHealth = (double) health;
	}

	protected void setBaseSpeed(double speed) {
		baseSpeed = speed;
	}

	protected void setBaseKnockback(double knockback) {
		baseKnockback = knockback;
	}

	protected void setBaseAttack(double attack) {
		baseAttack = attack;
	}

	/**
	 * Drops a single item
	 */
	public EntityItem dropSingleItem(Item item) {
		return dropSingleItem(item, 0);
	}

	/**
	 * Drops a single item
	 */
	public EntityItem dropSingleItem(Item item, int meta) {
		return entityDropItem(new ItemStack(item, 1, meta), 0);
	}
}
