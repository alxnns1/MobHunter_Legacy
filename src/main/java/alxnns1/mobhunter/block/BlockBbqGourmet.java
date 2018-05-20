package alxnns1.mobhunter.block;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.item.ItemStack;
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
        return new TileBbq(
                new ItemStack[] {
                        new ItemStack(MHItems.itemRawMeat),
                        new ItemStack(MHItems.itemRareSteak),
                        new ItemStack(MHItems.itemGourmetSteak),
                        new ItemStack(MHItems.itemBurntMeat)},
                new int[] {120, 180, 200}); //6, 9, 10 secs
    }
}
