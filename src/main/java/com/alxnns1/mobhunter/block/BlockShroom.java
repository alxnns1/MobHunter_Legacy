package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
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
 * Created by Alex on 04/05/2016.
 */
public class BlockShroom extends BlockBush {
    public BlockShroom(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.SHROOM);
        this.setBlockBounds(0.2f, 0.0f, 0.2f, 0.8f, 0.7f, 0.8f);
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
                if (i<0.23469387755102040816326530612244) {
                    drops.add(new ItemStack(MHItems.itemBlueMushroom));
                } else if (i<0.60969387755102040816326530612245) {
                    drops.add(new ItemStack(MHItems.itemExciteshroom));
                } else {
                    //drops.add(new ItemStack(MHItems.itemMopeshroom));
                }
            }else if(blockUnderneath== Blocks.netherrack || blockUnderneath==Blocks.nether_brick || blockUnderneath==Blocks.soul_sand) {
                //On top of nether blocks
                if (i<0.51228978007761966364812419146184) {
                    drops.add(new ItemStack(MHItems.itemBlueMushroom));
                } else if (i<0.70177708177299652754136311023354) {
                    drops.add(new ItemStack(MHItems.itemNitroshroom));
                } else if (i<0.88765574998297814393681487029346) {
                    drops.add(new ItemStack(MHItems.itemParashroom));
                } else {
                    drops.add(new ItemStack(MHItems.itemExciteshroom));
                }
            }else if(blockUnderneath.getMaterial()==Material.rock) {
                //On top of stone and rock material outliers
                if (i<0.27414600312120686665510664123462) {
                    drops.add(new ItemStack(MHItems.itemBlueMushroom));
                } else if (i<0.43367435408357898387376452228196) {
                    drops.add(new ItemStack(MHItems.itemNitroshroom));
                } else if (i<0.5932027050459511010924224033293) {
                    drops.add(new ItemStack(MHItems.itemParashroom));
                } else if (i<0.65215883474943644876018727241201) {
                    drops.add(new ItemStack(MHItems.itemExciteshroom));
                } else if (i<0.95283509623721172186578810473385) {
                    //drops.add(new ItemStack(MHItems.itemMopeshroom));
                } else {
                    drops.add(new ItemStack(MHItems.itemDragonToadstool));
                }
            }else {
                //On top of grass and other outliers
                if (i<0.14694647912640992225767312272503) {
                    drops.add(new ItemStack(MHItems.itemBlueMushroom));
                } else if (i<0.3015323776569451309935739001483) {
                    drops.add(new ItemStack(MHItems.itemParashroom));
                } else if (i<0.71675729115175481957488877904105) {
                    drops.add(new ItemStack(MHItems.itemToadstool));
                } else if (i<0.79764526131308138228553453466951) {
                    drops.add(new ItemStack(MHItems.itemExciteshroom));
                } else {
                    //drops.add(new ItemStack(MHItems.itemMopeshroom));
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
