package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.entity.IScaledMob;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MHConfig;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;

/**
 * Created by Alex on 24/02/2017.
 */
public abstract class EntityMHMarine extends EntityAnimal implements IScaledMob {
	private static final String KEY_SCALE = "scale";
	private static final DataParameter<Float> ENTITY_SCALE = EntityDataManager.createKey(EntityMHMarine.class, DataSerializers.FLOAT);
	private static double scaleMax; //= 1.24d;
	private static double scaleMin; //= 0.79d;
	private double baseHealth = 5d;
	private double baseSpeed = 0.1d;
	private double baseKnockback = 0.2d;
	private Item breedItem;

	public EntityMHMarine(World world) {
		this(world, MHConfig.scaleMin, MHConfig.scaleMax, Items.FISH);
	}

	public EntityMHMarine(World world, double minScale, double maxScale) {
		this(world, minScale, maxScale, Items.FISH);
	}

	public EntityMHMarine(World world, Item temptFood) {
		this(world, MHConfig.scaleMin, MHConfig.scaleMax, temptFood);
	}

	public EntityMHMarine(World world, double minScale, double maxScale, Item temptFood) {
		super(world);
		this.setSize(0.9F, 1.3F); //Same as cow
		scaleMin = minScale;
		scaleMax = maxScale;
		breedItem = temptFood;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIPanic(this, 2.0D));
		this.tasks.addTask(2, new EntityAIMate(this, 1.0D));
		this.tasks.addTask(3, new EntityAITempt(this, 1.25D, temptFood, false));
		this.tasks.addTask(4, new EntityAIFollowParent(this, 1.25D));
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
		return MHItems.itemHerbivoreDrop;
	}

	/**
	 * Checks if the parameter is an item which this animal can be fed to breed it
	 */
	public boolean isBreedingItem(ItemStack stack) {
		return !stack.isEmpty() && stack.getItem() == breedItem;
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

	private void setEntityScale(double scale) {
		//Gets the datawatcher value for the entity scale
		this.dataManager.set(ENTITY_SCALE, (float) scale);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double) Math.round(baseHealth * scale));
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(baseSpeed * scale);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(baseKnockback * scale);
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

	protected void setBaseHealth(int health) {
		baseHealth = (double) health;
	}

	protected void setBaseSpeed(double speed) {
		baseSpeed = speed;
	}

	protected void setBaseKnockback(double knockback) {
		baseKnockback = knockback;
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

	public boolean canBreatheUnderwater() {
		return true;
	}

	/**
	 * Checks if the entity's current position is a valid location to spawn this entity.
	 */
	public boolean getCanSpawnHere() {
		return true;
	}

	/**
	 * Gets called every tick from main Entity class
	 */
	public void onEntityUpdate() {
		int i = this.getAir();
		super.onEntityUpdate();

		if (this.isEntityAlive() && !this.isInWater()) {
			--i;
			this.setAir(i);

			if (this.getAir() == -20) {
				this.setAir(0);
				this.attackEntityFrom(DamageSource.DROWN, 2.0F);
			}
		} else {
			this.setAir(300);
		}
	}

	public boolean isPushedByWater() {
		return false;
	}
}
