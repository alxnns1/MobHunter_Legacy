package alxnns1.mobhunter.block;

import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 03/05/2016.
 */
public class BlockHerb extends BlockNatural
{
	public BlockHerb()
	{
		super(Names.Blocks.HERB, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
	}

	@Override
	public ArrayList<ItemStack> getDropsAll()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "herb"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sapPlant"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "antidoteHerb"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "felvine")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsSand()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "fireHerb"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sleepHerb"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "ivy")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsNether()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "fireHerb"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "hotPepper")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsCold()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sleepHerb"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "gloamgrassRoot")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsRock()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "ivy"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "gloamgrassRoot")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsOther()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "ivy"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "felvine")
		);
	}
}
