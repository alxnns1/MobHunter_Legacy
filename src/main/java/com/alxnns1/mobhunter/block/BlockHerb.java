package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockNetherrack;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

/**
 * Created by Alex on 03/05/2016.
 */
public class BlockHerb extends BlockBush {
    public BlockHerb(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.HERB);
        this.setBlockBounds(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f);
        this.setCreativeTab(MobHunter.MH_TAB);
    }

    public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockColor() {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @SideOnly(Side.CLIENT)
    public int getRenderColor(IBlockState state) {
        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
    }

    @SideOnly(Side.CLIENT)
    public int colorMultiplier(IBlockAccess worldIn, BlockPos pos, int renderPass)
    {
        return worldIn.getBiomeGenForCoords(pos).getGrassColorAtPos(pos);
    }

    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        Block blockUnderneath = world.getBlockState(pos.down()).getBlock();
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        for(int n=0;n<RANDOM.nextInt(2)+1+fortune;n++){
            double i = RANDOM.nextDouble();
            if(blockUnderneath.getMaterial()==Material.sand) {
                //On top of sand and gravel
                if (i<0.24044694515556929348449815838642) {
                    drops.add(new ItemStack(MHItems.itemHerb));
                } else if (i<0.39824025291391164233370007482751) {
                    drops.add(new ItemStack(MHItems.itemFireHerb));
                } else if (i<0.49731329976041936048240533453302) {
                    drops.add(new ItemStack(MHItems.itemSleepHerb));
                } else if (i<0.63162546053091314551476172769419) {
                    drops.add(new ItemStack(MHItems.itemSapPlant));
                } else if (i<0.75964119522022087121252695090918) {
                    drops.add(new ItemStack(MHItems.itemFelvine));
                } else if (i<0.8934382856696908812966428616242) {
                    drops.add(new ItemStack(MHItems.itemGloamgrassRoot));
                } else {
                    drops.add(new ItemStack(MHItems.itemHotPepper));
                }
            }else if(blockUnderneath==Blocks.netherrack || blockUnderneath==Blocks.nether_brick || blockUnderneath==Blocks.soul_sand) {
                //On top of nether blocks
                if (i<0.15722379603399433427762039660058) {
                    drops.add(new ItemStack(MHItems.itemHerb));
                } else if (i<0.41643059490084985835694050991504) {
                    drops.add(new ItemStack(MHItems.itemAntidoteHerb));
                } else if (i<0.58640226628895184135977337110485) {
                    drops.add(new ItemStack(MHItems.itemFireHerb));
                } else if (i<0.75637393767705382436260623229466) {
                    drops.add(new ItemStack(MHItems.itemIvy));
                } else if (i<0.84135977337110481586402266288957) {
                    drops.add(new ItemStack(MHItems.itemSapPlant));
                } else {
                    drops.add(new ItemStack(MHItems.itemGloamgrassRoot));
                }
            }else if(blockUnderneath.getMaterial()==Material.snow || blockUnderneath.getMaterial()==Material.craftedSnow || blockUnderneath.getMaterial()==Material.ice || blockUnderneath.getMaterial()==Material.packedIce){
                //On top of snow and ice
                if (i<0.23785803237858032378580323785803) {
                    drops.add(new ItemStack(MHItems.itemHerb));
                } else if (i<0.46699875466998754669987546699875) {
                    drops.add(new ItemStack(MHItems.itemSleepHerb));
                } else if (i<0.65130759651307596513075965130759) {
                    drops.add(new ItemStack(MHItems.itemSapPlant));
                } else {
                    drops.add(new ItemStack(MHItems.itemFelvine));
                }
            }else if(blockUnderneath.getMaterial()==Material.rock) {
                //On top of stone and rock material outliers
                if (i<0.13405341021372206656650559683816) {
                    drops.add(new ItemStack(MHItems.itemHerb));
                } else if (i<0.31612999282630175552577794020114) {
                    drops.add(new ItemStack(MHItems.itemAntidoteHerb));
                } else if (i<0.50129261921197601548435998429908) {
                    drops.add(new ItemStack(MHItems.itemFireHerb));
                } else if (i<0.63837793207996643250632774326282) {
                    drops.add(new ItemStack(MHItems.itemIvy));
                } else if (i<0.75954575601304800963711915106726) {
                    drops.add(new ItemStack(MHItems.itemSapPlant));
                } else if (i<0.84400590138195205803927938170843) {
                    drops.add(new ItemStack(MHItems.itemFelvine));
                } else {
                    drops.add(new ItemStack(MHItems.itemGloamgrassRoot));
                }
            }else{
                //On top of grass and other outliers
                if (i<0.15908241598812579991386447291226) {
                    drops.add(new ItemStack(MHItems.itemHerb));
                } else if (i<0.35843886134033408081858071111877) {
                    drops.add(new ItemStack(MHItems.itemAntidoteHerb));
                } else if (i<0.48309057811764829542106967932635) {
                    drops.add(new ItemStack(MHItems.itemIvy));
                } else if (i<0.59136575706185465777724422736793) {
                    drops.add(new ItemStack(MHItems.itemSleepHerb));
                } else if (i<0.77048450265861149198405745351408) {
                    drops.add(new ItemStack(MHItems.itemSapPlant));
                } else if (i<0.8508311912399560415608067252761) {
                    drops.add(new ItemStack(MHItems.itemFelvine));
                } else {
                    drops.add(new ItemStack(MHItems.itemHotPepper));
                }
            }
        }
        return drops;
    }

    @Override
    public EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return EnumPlantType.Cave;
    }
}
