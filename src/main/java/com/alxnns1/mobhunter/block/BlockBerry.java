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
 * Created by Alex on 10/05/2016.
 */
public class BlockBerry extends BlockBush {
    public BlockBerry(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.BERRY);
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
                if (i<0.13657056145675265553869499241275) {
                    drops.add(new ItemStack(MHItems.itemHuskberry));
                } else if (i<0.22761760242792109256449165402125) {
                    drops.add(new ItemStack(MHItems.itemPaintberry));
                } else if (i<0.37936267071320182094081942336874) {
                    drops.add(new ItemStack(MHItems.itemMightSeed));
                } else if (i<0.66767830045523520485584218512898) {
                    drops.add(new ItemStack(MHItems.itemNulberry));
                } else if (i<0.7814871016691957511380880121396) {
                    drops.add(new ItemStack(MHItems.itemNeedleberry));
                } else {
                    drops.add(new ItemStack(MHItems.itemBomberry));
                }
            }else if(blockUnderneath== Blocks.netherrack || blockUnderneath==Blocks.nether_brick || blockUnderneath==Blocks.soul_sand) {
                //On top of nether blocks
                if (i<0.069615663524292965917331399564906) {
                    drops.add(new ItemStack(MHItems.itemMightSeed));
                } else if (i<0.31109499637418419144307469180568) {
                    drops.add(new ItemStack(MHItems.itemAdamantSeed));
                } else if (i<0.46337926033357505438723712835391) {
                    drops.add(new ItemStack(MHItems.itemNulberry));
                } else if (i<0.66932559825960841189267585206675) {
                    drops.add(new ItemStack(MHItems.itemDragonfellBerry));
                } else if (i<0.79985496736765772298767222625095) {
                    drops.add(new ItemStack(MHItems.itemScatternut));
                } else {
                    drops.add(new ItemStack(MHItems.itemLatchberry));
                }
            }else if(blockUnderneath.getMaterial()==Material.snow || blockUnderneath.getMaterial()==Material.craftedSnow || blockUnderneath.getMaterial()==Material.ice || blockUnderneath.getMaterial()==Material.packedIce){
                //On top of snow and ice
                if (i<0.1465230476793917313480120386504) {
                    drops.add(new ItemStack(MHItems.itemHuskberry));
                } else if (i<0.31126247425946459686361476318707) {
                    drops.add(new ItemStack(MHItems.itemPaintberry));
                } else if (i<0.47726912719784571519087597022018) {
                    drops.add(new ItemStack(MHItems.itemMightSeed));
                } else if (i<0.68002534452716616505623316964993) {
                    drops.add(new ItemStack(MHItems.itemNulberry));
                } else if (i<0.83209250752415650245525106922224) {
                    drops.add(new ItemStack(MHItems.itemNeedleberry));
                } else {
                    drops.add(new ItemStack(MHItems.itemBomberry));
                }
            }else if(blockUnderneath.getMaterial()==Material.rock) {
                //On top of stone and rock material outliers
                if (i<0.092390183542998556403382140647556) {
                    drops.add(new ItemStack(MHItems.itemHuskberry));
                } else if (i<0.20622808826562177768612084965973) {
                    drops.add(new ItemStack(MHItems.itemPaintberry));
                } else if (i<0.33986388946174468962672716023923) {
                    drops.add(new ItemStack(MHItems.itemMightSeed));
                } else if (i<0.4229738090327902660342338626521) {
                    drops.add(new ItemStack(MHItems.itemAdamantSeed));
                } else if (i<0.61146628170756857083934831924109) {
                    drops.add(new ItemStack(MHItems.itemNulberry));
                } else if (i<0.69808207877912971746751907609818) {
                    drops.add(new ItemStack(MHItems.itemNeedleberry));
                } else if (i<0.85151577644875232006599298824502) {
                    drops.add(new ItemStack(MHItems.itemLatchberry));
                } else {
                    drops.add(new ItemStack(MHItems.itemBomberry));
                }
            }else{
                //On top of grass and other outliers
                if (i<0.11499459873854409868627382653239) {
                    drops.add(new ItemStack(MHItems.itemHuskberry));
                } else if (i<0.20232080008363243544621388995365) {
                    drops.add(new ItemStack(MHItems.itemPaintberry));
                } else if (i<0.35564693173502456702791232533017) {
                    drops.add(new ItemStack(MHItems.itemMightSeed));
                } else if (i<0.49985015855315886678049970380179) {
                    drops.add(new ItemStack(MHItems.itemNulberry));
                } else if (i<0.58302958497403909816357110499355) {
                    drops.add(new ItemStack(MHItems.itemScatternut));
                } else if (i<0.66881555563299299578353137958671) {
                    drops.add(new ItemStack(MHItems.itemNeedleberry));
                } else if (i<0.82980799386695473394431473673206) {
                    drops.add(new ItemStack(MHItems.itemLatchberry));
                } else {
                    drops.add(new ItemStack(MHItems.itemBomberry));
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
