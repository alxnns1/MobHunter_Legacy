package alxnns1.mobhunter.block;

import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 11/05/2016.
 */
public class BlockBone extends BlockNatural
{
	public BlockBone()
	{
		super(Names.Blocks.BONE, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
	}

	@Override
	public ArrayList<ItemStack> getDropsAll()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneS"),
				MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsSand()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "mysteryBone")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsNether()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "unknownSkull")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsCold()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "boneHusk")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsRock()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, "monsterBoneM")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsOther()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.MISC, "dung")
		);
	}
}
