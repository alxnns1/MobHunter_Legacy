package alxnns1.mobhunter.block;

import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 10/05/2016.
 */
public class BlockBug extends BlockNatural
{
	public BlockBug(){ super(Names.Blocks.BUG, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f)); }

	@Override
	public ArrayList<ItemStack> getDropsAll()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "insectHusk"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "stinkhopper"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "snakebeeLarva"),
				MetaRef.getStack(MetaRef.EnumItemType.PLANT, "honey")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsSand()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "flashbug"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "thunderbug"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "rareScarab")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsNether()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "godbug"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "killerBeetle")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsCold()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "killerBeetle"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsRock()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "hercudrome"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "rareScarab")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsOther()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"),
				MetaRef.getStack(MetaRef.EnumItemType.BUG, "rareScarab")
		);
	}
}
