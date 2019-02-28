package alxnns1.mobhunter.block;

import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.tileentity.TileGourmetBBQ;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created by Mark on 20/12/2016.
 */
public class BlockBbqGourmet extends BlockBbq
{
	public BlockBbqGourmet()
	{
		super(Names.Blocks.BBQ_GOURMET);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileGourmetBBQ();
	}
}
