package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.entity.AI.EntityAIAttackMeleeAndSpit;
import alxnns1.mobhunter.entity.EntitySpit;
import alxnns1.mobhunter.entity.ISpitAttackMob;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * Created by Alex on 10/06/2016.
 */
public class EntityIoprey extends EntityMHBirdWyvern implements ISpitAttackMob
{
	public EntityIoprey(World worldIn)
	{
		super(worldIn, 1, 1);
		this.setSize(1.5F, 1.8125F);
		setBaseHealth(15);
		setBaseAttack(2);
		setBaseSpeed(0.3);
		setBaseKnockback(0.1);
		this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.5f));
		this.tasks.addTask(4, new EntityAIAttackMeleeAndSpit(this, 1.0D, 200, 16.0f, 4.0f, true));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityAnimal.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityMHHerbivore.class, true));
	}

	@Override
	public float getEyeHeight()
	{
		return 2.5625F;
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean hitByPlayer, int lootingLevel)
	{
		if(!hitByPlayer)
		{
			int i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
			for(int j = 0; j < i; ++j)
			{
				dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
			}
			i = this.rand.nextInt(1) + this.rand.nextInt(1 + lootingLevel);
			for(int k = 0; k < i; ++k)
			{
				dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.BIRD_WYVERN_FANG));
			}
		}
		else
		{
			for(int n = 0; n < 1 + lootingLevel; n++)
			{
				int i = this.rand.nextInt(99);
				if(i < 40)
				{
					dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_FANG));
				}
				else if(i < 69)
				{
					dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_SCALE));
				}
				else if(i < 92)
				{
					dropSingleItem(MHItems.itemBirdWyvernDrop, MetaRef.getMeta(MetaRef.EnumItemType.BIRD_DROP, Names.Items.IOPREY_HIDE));
				}
				else
				{
					dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
				}
			}
		}
	}

	@Override
	public boolean isPotionApplicable(PotionEffect potioneffectIn)
	{
		Potion potion = potioneffectIn.getPotion();
		if(potion == MobEffects.POISON) return false;
		return true;
	}

	@Override
	public void attackEntityWithSpitAttack(EntityLivingBase target)
	{
		EntitySpit spit = new EntitySpit(this.world, this, "iopreySpit", 0f, 1f, new PotionEffect(MobEffects.POISON, 200));
		double d0 = target.posY + (double) target.getEyeHeight() - 1.100000023841858D;
		double d1 = target.posX - this.posX;
		double d2 = d0 - spit.posY;
		double d3 = target.posZ - this.posZ;
		float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
		spit.setPosition(this.posX, this.posY + 1.5d, this.posZ);
		spit.setItemToRender(new ItemStack(Items.CHORUS_FRUIT_POPPED));
		this.playSound(SoundEvents.ENTITY_SLIME_ATTACK, 1.0F, 1.0F / (this.getRNG().nextFloat() * 0.4F + 0.8F));
		this.world.spawnEntity(spit);
	}
}
