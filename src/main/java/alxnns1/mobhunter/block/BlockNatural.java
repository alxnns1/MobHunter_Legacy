package alxnns1.mobhunter.block;

import alxnns1.mobhunter.MobHunter;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldServer;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeHell;
import net.minecraftforge.common.EnumPlantType;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Mark on 17/06/2016.
 */
public class BlockNatural extends BlockBush
{
	private AxisAlignedBB BLOCK_BOUNDS;

	public BlockNatural(String name, AxisAlignedBB blockBounds)
	{
		super(Material.VINE);
		setCreativeTab(MobHunter.MHBLOCK_TAB);
		setUnlocalizedName(name);
		setRegistryName(name);
		BLOCK_BOUNDS = blockBounds;
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return BLOCK_BOUNDS;
	}

	@Override
	public boolean isReplaceable(IBlockAccess world, BlockPos pos)
	{
		return false;
	}

	@Override
	public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
	{
		return EnumPlantType.Cave;
	}

	/**
	 * Returns a new, empty ArrayList for ItemStacks.
	 */
	protected ArrayList<ItemStack> createEmptyList()
	{
		return new ArrayList<>();
	}

	/**
	 * Returns an ArrayList of the given ItemStacks.
	 */
	protected ArrayList<ItemStack> createList(ItemStack... stacks)
	{
		return Lists.newArrayList(stacks);
	}

	/**
	 * One of the drops from this list is always chosen with equal chance.
	 */
	public ArrayList<ItemStack> getDropsAll()
	{
		return createEmptyList();
	}

	public ArrayList<ItemStack> getDropsSand()
	{
		return createEmptyList();
	}

	public ArrayList<ItemStack> getDropsNether()
	{
		return createEmptyList();
	}

	public ArrayList<ItemStack> getDropsCold()
	{
		return createEmptyList();
	}

	public ArrayList<ItemStack> getDropsRock()
	{
		return createEmptyList();
	}

	public ArrayList<ItemStack> getDropsOther()
	{
		return createEmptyList();
	}

	private ItemStack getRandStack(Random rand, ArrayList<ItemStack> list)
	{
		return list.get(rand.nextInt(list.size()));
	}

	/**
	 * This returns a complete list of items dropped from this block.
	 */
	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune)
	{
		if(!(world instanceof WorldServer))
			return;
		WorldServer server = (WorldServer) world;
		Biome biome = server.getBiomeForCoordsBody(pos);
		IBlockState stateBelow = server.getBlockState(pos.down());
		Random rand = server.rand;

		//Get normal drops (1-2 + fortune level)
		ArrayList<ItemStack> dropsList = getDropsAll();
		for(int i = 0; i < rand.nextInt(2) + 1 + fortune; i++)
			drops.add(getRandStack(rand, dropsList));

		//Get special drops (0-1 + fortune level)
		if(stateBelow.getMaterial() == Material.SAND) dropsList = getDropsSand();
		else if(biome instanceof BiomeHell) dropsList = getDropsNether();
		else if(biome.getTemperature(pos) < 0.2f) dropsList = getDropsCold();
		else if(stateBelow.getMaterial() == Material.ROCK) dropsList = getDropsRock();
		else dropsList = getDropsOther();
		if(!dropsList.isEmpty())
			for(int i = 0; i < rand.nextInt(2) + fortune; i++)
				drops.add(getRandStack(rand, dropsList));
	}
}
