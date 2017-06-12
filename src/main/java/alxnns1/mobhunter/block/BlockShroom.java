package alxnns1.mobhunter.block;

import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 04/05/2016.
 */
public class BlockShroom extends BlockNatural
{
    public BlockShroom(){
        super(Names.Blocks.SHROOM, new AxisAlignedBB(0.2f, 0.0f, 0.2f, 0.8f, 0.7f, 0.8f));
    }

    @Override
    public ArrayList<ItemStack> getDropsAll()
    {
        return createList(
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "blueMushroom"),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "toadstool")
        );
    }

    @Override
    public ArrayList<ItemStack> getDropsSand()
    {
        return createList(
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "parashroom"),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "mopeshroom")
        );
    }

    @Override
    public ArrayList<ItemStack> getDropsNether()
    {
        return createList(
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "nitroshroom"),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "dragonToadstool")
        );
    }

    @Override
    public ArrayList<ItemStack> getDropsCold()
    {
        return createList(
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "mopeshroom"),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "exciteshroom")
        );
    }

    @Override
    public ArrayList<ItemStack> getDropsRock()
    {
        return createList(
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "exciteshroom"),
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "dragonToadstool")
        );
    }

    @Override
    public ArrayList<ItemStack> getDropsOther()
    {
        return createList(
                MetaRef.getStack(MetaRef.EnumItemType.MUSHROOM, "dragonToadstool")
        );
    }
}
