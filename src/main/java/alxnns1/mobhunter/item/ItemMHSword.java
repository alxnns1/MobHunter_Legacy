package alxnns1.mobhunter.item;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.util.ClientUtil;
import com.google.common.collect.Multimap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHSword extends ItemSword
{
	private final EnumSharpness maxSharpness;
	private final int[] damageLevels;
	private final String damageLevelsString;

	public ItemMHSword(String itemName, float damage, int... sharpnessDamageLevels)
	{
		super(EnumHelper.addToolMaterial(itemName + "Mat", 0, sharpnessDamageLevels[sharpnessDamageLevels.length - 1], 0, damage - 1, 0).setRepairItem(new ItemStack(MHItems.itemMisc, 1, 1)));
		setCreativeTab(MobHunter.MHWEAPON_TAB);
		setUnlocalizedName(itemName);
		setRegistryName(itemName);
		maxSharpness = EnumSharpness.getById(sharpnessDamageLevels.length - 1);
		if(maxSharpness == null)
			MobHunter.LOGGER.warn("Sword " + getUnlocalizedName() + " has a null sharpness! Something must be wrong!");
		damageLevels = sharpnessDamageLevels;
		String levels = "";
		for(int i = 0; i < damageLevels.length; i++)
		{
			levels += damageLevels[i];
			if(i < damageLevels.length - 1)
				levels += " <- ";
		}
		damageLevelsString = levels;
	}

	/**
	 * Gets the current sharpness level from the ItemStack's metadata
	 */
	public static EnumSharpness getSharpness(ItemStack stack)
	{
		if(!(stack.getItem() instanceof ItemMHSword))
			return null;
		ItemMHSword sword = (ItemMHSword) stack.getItem();
		if(sword.damageLevels != null)
		{
			for(int i = 0; i < sword.damageLevels.length; i++)
				if((stack.getMaxDamage() - stack.getItemDamage()) < sword.damageLevels[i])
					return EnumSharpness.getById(i);
			return sword.maxSharpness;
		}
		return EnumSharpness.RED;
	}

	/**
	 * Calculates the actual damage of this weapon using the sharpness
	 */
	public static float getActualAttackDamage(ItemStack stack)
	{
		if(!(stack.getItem() instanceof ItemMHSword))
			return 0f;
		ItemMHSword sword = (ItemMHSword) stack.getItem();
		EnumSharpness currentSharpness = getSharpness(stack);
		return currentSharpness == null ? sword.getAttackDamage() : sword.getAttackDamage() * currentSharpness.getDamageMult();
	}

	public void repairSharpness(ItemStack stack, int amount)
	{
		if(stack.getItemDamage() < amount)
			stack.setItemDamage(0);
		else
			stack.setItemDamage(stack.getItemDamage() - amount);
	}

	@Override
	public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack)
	{
		Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
		if(slot == EntityEquipmentSlot.MAINHAND)
		{
			multimap.removeAll(SharedMonsterAttributes.ATTACK_DAMAGE.getName());
			multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) getActualAttackDamage(stack), 0));
		}
		return multimap;
	}

	/**
	 * Current implementations of this method in child classes do not use the entry argument beside ev. They just raise
	 * the damage on the stack.
	 */
	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		if(!(attacker instanceof EntityPlayer) || !((EntityPlayer) attacker).capabilities.isCreativeMode)
			stack.damageItem(1, attacker);
		return true;
	}

	/**
	 * Allows items to add custom lines of information to the mouseover description
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		EnumSharpness currentSharpness = getSharpness(stack);
		if(currentSharpness != null)
		{
			tooltip.add(I18n.format("item.sharpness") + " " + currentSharpness.getChatColour() + new TextComponentTranslation(currentSharpness.getUnlocalizedName()).getUnformattedText());
			tooltip.add(I18n.format("item.maxSharpness") + " " + maxSharpness.getChatColour() + new TextComponentTranslation(maxSharpness.getUnlocalizedName()).getUnformattedText());
			if(Minecraft.getMinecraft().player != null && Minecraft.getMinecraft().player.isCreative())
				tooltip.add(damageLevelsString);
		}

		ClientUtil.addTooltip(stack, tooltip);
	}

	/**
	 * Returns the action that specifies what animation to play when the items is being used
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack stack)
	{
		return EnumAction.EAT;
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
	{
		return 200;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
	{
		ItemStack stack = playerIn.getHeldItem(hand);
		if(playerIn.isSneaking() && stack.getItemDamage() > 0)
		{
			if(playerIn.inventory.hasItemStack(new ItemStack(MHItems.itemMisc, 1, 1)) || playerIn.inventory.hasItemStack(new ItemStack(MHItems.itemMisc, 1, 2)) || playerIn.inventory.hasItemStack(new ItemStack(MHItems.itemWhetfish, 1, 0)))
			{
				playerIn.setActiveHand(hand);
				return new ActionResult<>(EnumActionResult.SUCCESS, stack);
			}
		}
		return new ActionResult<>(EnumActionResult.FAIL, stack);
	}

	/**
	 * Called when the player finishes using this Item (E.g. finishes eating.). Not called when the player stops using
	 * the Item before the action is complete.
	 */
	@Override
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving)
	{
		if(entityLiving instanceof EntityPlayer)
		{
			int sharpen = 0;
			if(((EntityPlayer) entityLiving).inventory.clearMatchingItems(MHItems.itemMisc, 1, 1, null) > 0)
				//Whetstone
				sharpen = 200;
			else if(((EntityPlayer) entityLiving).inventory.clearMatchingItems(MHItems.itemMisc, 2, 1, null) > 0)
				//Mini Whetstone
				sharpen = 100;
			else if(((EntityPlayer) entityLiving).inventory.clearMatchingItems(MHItems.itemWhetfish, 0, 1, null) > 0)
				sharpen = 200;

			if(sharpen > 0)
				repairSharpness(stack, sharpen);
		}
		return stack;
	}
}
