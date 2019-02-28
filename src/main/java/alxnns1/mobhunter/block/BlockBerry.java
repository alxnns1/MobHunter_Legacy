package alxnns1.mobhunter.block;

import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 10/05/2016.
 */
public class BlockBerry extends BlockNatural
{
	public BlockBerry()
	{
		super(Names.Blocks.BERRY, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
	}

	@Override
	public ArrayList<ItemStack> getDropsAll()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "huskberry"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "paintberry"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "nullberry")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsSand()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "bomberry"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "scatternut")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsNether()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "adamantSeed"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "dragonfellBerry"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "bomberry"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "mightSeed")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsCold()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "latchberry")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsRock()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "adamantSeed"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "needleberry")
		);
	}

	@Override
	public ArrayList<ItemStack> getDropsOther()
	{
		return createList(
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "scatternut"),
				MetaRef.getStack(MetaRef.EnumItemType.BERRY, "mightSeed")
		);
	}
}
