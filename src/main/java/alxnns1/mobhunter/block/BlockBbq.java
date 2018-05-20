package alxnns1.mobhunter.block;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.Names;
import alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

/**
 * Created by Mark on 26/04/2016.
 */
public class BlockBbq extends BlockContainer
{
    public BlockBbq(String name)
    {
        super(Material.ROCK);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(MobHunter.MHBLOCK_TAB);
        setHardness(2f);
        setResistance(10f);
        //setLightOpacity(0);
    }

    public BlockBbq()
    {
        this(Names.Blocks.BBQ);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileBbq(
                new ItemStack[] {
                        new ItemStack(MHItems.itemRawMeat),
                        new ItemStack(MHItems.itemRareSteak),
                        new ItemStack(MHItems.itemDoneSteak),
                        new ItemStack(MHItems.itemBurntMeat)},
                new int[] {120, 180, 200}); //6, 9, 10 secs
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity te = world.getTileEntity(pos);
        return te == null || !(te instanceof TileBbq) || !((TileBbq)te).isCooking() ? 0 : 14;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        TileBbq te = (TileBbq) world.getTileEntity(pos);
        if(te == null) return false;

        ItemStack heldItem = player.getHeldItem(hand);

        if(te.isValidInput(heldItem) && te.putInputItem())
        {
            //Start cooking held item
            heldItem.shrink(1);
            return true;
        }
        else if(te.isCooking())
        {
            //Try to get the item from the bbq spit
            ItemStack product = te.retrieveResult();
            if(product != null && !world.isRemote)
            {
                //Trigger crafting event
                net.minecraftforge.fml.common.FMLCommonHandler.instance().firePlayerCraftingEvent(player, product, null);
                //Drop item on the ground
                BlockPos pPos = player.getPosition();
                EntityItem itemDrop = new EntityItem(world, pPos.getX() + 0.5d, pPos.getY() + 0.5d, pPos.getZ() + 0.5d, product);
                itemDrop.setNoPickupDelay();
                world.spawnEntity(itemDrop);
                return true;
            }
        }
        return false;
    }

    private void spawnParticle(World world, BlockPos pos, Random rand, boolean isFire)
    {
        double x = pos.getX() + 0.375d + (rand.nextDouble() * 0.25d);
        double y = pos.getY() + 0.25d + (rand.nextDouble() * 0.125d);
        double z = pos.getZ() + 0.375d + (rand.nextDouble() * 0.25d);
        EnumParticleTypes type;
        if(isFire)
            type = EnumParticleTypes.FLAME;
        else
            type = EnumParticleTypes.SMOKE_NORMAL;
        world.spawnParticle(type, x, y, z, 0, 0, 0);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void randomDisplayTick(IBlockState state, World worldIn, BlockPos pos, Random rand)
    {
        worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
        worldIn.checkLightFor(EnumSkyBlock.BLOCK, pos);
        //This is where the particles are spawned when cooking
        TileEntity te = worldIn.getTileEntity(pos);
        if(te == null) return;
        boolean cooking = ((TileBbq) te).isCooking();
        if(cooking)
        {
            //Spawns between 2 and 5 fire particles
            for(int i = 0; i < rand.nextInt(3) + 1; i++)
                spawnParticle(worldIn, pos, rand, true);
            //Spawns between 0 and 3 smoke particles
            for(int i = 1; i < rand.nextInt(4); i++)
                spawnParticle(worldIn, pos, rand, false);
        }
    }
}
