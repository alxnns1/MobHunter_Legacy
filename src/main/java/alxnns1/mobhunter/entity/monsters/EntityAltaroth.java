package alxnns1.mobhunter.entity.monsters;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Alex on 17/05/2016.
 */
public class EntityAltaroth extends EntityMHNeopteron
{
	private boolean full = false;

	public EntityAltaroth(World worldIn)
	{
		super(worldIn);
		this.setSize(0.9f, 0.5f);
		setBaseHealth(5);
		setBaseAttack(1);
		setBaseSpeed(0.2);
		setBaseKnockback(0.3);
		this.tasks.addTask(1, new EntityAILeapAtTarget(this, 0.5f));
		this.tasks.addTask(4, new EntityAIAttackMelee(this, 1.0D, false));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityVillager.class, true));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
	}

	@Override
	public float getEyeHeight()
	{
		return 0.25F;
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
				dropSingleItem(MHItems.itemNeopteranDrop, MetaRef.getMeta(MetaRef.EnumItemType.NEOPTERAN_DROP, Names.Items.ALTAROTH_STOMACH));
			}
		}
		else
		{
			for(int n = 0; n < 1 + lootingLevel; n++)
			{
				int i = this.rand.nextInt(99);
				if(i < 50)
				{
					dropSingleItem(MHItems.itemNeopteranDrop, MetaRef.getMeta(MetaRef.EnumItemType.NEOPTERAN_DROP, Names.Items.ALTAROTH_STOMACH));
				}
				else if(i < 75)
				{
					dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_FLUID));
				}
				else if(i < 100)
				{
					dropSingleItem(MHItems.itemNeopteranDrop, MetaRef.getMeta(MetaRef.EnumItemType.NEOPTERAN_DROP, Names.Items.ALTAROTH_JAW));
				}
			}
			int i = this.rand.nextInt(99);
			if(i < 20)
			{
				dropSingleItem(MHItems.itemMiscDrop, MetaRef.getMeta(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_FLUID));
			}
			else if(i < 40)
			{
				dropSingleItem(MHItems.itemPlant, MetaRef.getMeta(MetaRef.EnumItemType.PLANT, Names.Items.HONEY));
			}
			else if(i < 60)
			{
				dropSingleItem(MHItems.itemBerry, MetaRef.getMeta(MetaRef.EnumItemType.BERRY, Names.Items.NULBERRY));
			}
			else if(i < 80)
			{
				dropSingleItem(MHItems.itemBug, MetaRef.getMeta(MetaRef.EnumItemType.BUG, Names.Items.INSECT_HUSK));
			}
			else
			{
				dropSingleItem(MHItems.itemNeopteranDrop, MetaRef.getMeta(MetaRef.EnumItemType.NEOPTERAN_DROP, Names.Items.ALTAROTH_STOMACH));
			}
		}
	}

	public boolean isFull()
	{
		return full;
	}
}
