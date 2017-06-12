package alxnns1.mobhunter.block;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * Created by Mark on 10/05/2016.
 */
public class BlockCraft extends Block
{
    public BlockCraft(String name)
    {
        super(Material.ROCK);
        setCreativeTab(MobHunter.MHBLOCK_TAB);
        setHardness(2f);
        setResistance(10f);
        setUnlocalizedName(name);
        setRegistryName(name);
    }

    //Used to open the block's GUI
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        //Open crafting gui
        if(!world.isRemote && !player.isSneaking())
            CommonUtil.openGui(player, world, pos);
            //player.openGui(MobHunter.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }
}
