package alxnns1.mobhunter.tileentity;

import alxnns1.mobhunter.init.MHItems;
import net.minecraft.item.ItemStack;

/**
 * Created by bright_spark on 22/05/2018.
 */
public class TileGourmetBBQ extends TileBbq
{
    public TileGourmetBBQ()
    {
        super();
    }

    @Override
    protected ItemStack getCookedMeat()
    {
        return new ItemStack(MHItems.itemGourmetSteak);
    }
}
