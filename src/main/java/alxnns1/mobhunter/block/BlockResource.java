package alxnns1.mobhunter.block;

import alxnns1.mobhunter.MobHunter;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

/**
 * Created by Mark on 14/05/2016.
 */
public class BlockResource extends Block
{
	public BlockResource(String blockName)
	{
		this(blockName, 1);
	}

	public BlockResource(String blockName, int harvestLevel)
	{
		super(Material.ROCK);
		setUnlocalizedName(blockName);
		setCreativeTab(MobHunter.MHBLOCK_TAB);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", harvestLevel);
		setSoundType(SoundType.STONE);
		setRegistryName(blockName);
	}
}
