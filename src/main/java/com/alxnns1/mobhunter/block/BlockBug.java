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
public class BlockBug extends BlockBush {
    public BlockBug(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.BUG);
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
                if (i<0.023140495867768595041322314049587) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<0.082644628099173553719008264462811) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<0.12198347107438016528925619834711) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<0.16198347107438016528925619834711) {
                    drops.add(new ItemStack(MHItems.itemHoney));
                } else if (i<0.25619834710743801652892561983471) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<0.38512396694214876033057851239669) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<0.46446280991735537190082644628099) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<0.55702479338842975206611570247934) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<0.67603305785123966942148760330579) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else if (i<0.75404958677685950413223140495868) {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                } else if (i<0.8928925619834710743801652892562) {
                    drops.add(new ItemStack(MHItems.itemHercudrome));
                } else {
                    drops.add(new ItemStack(MHItems.itemRareScarab));
                }
            }else if(blockUnderneath== Blocks.netherrack || blockUnderneath==Blocks.nether_brick || blockUnderneath==Blocks.soul_sand) {
                //On top of nether blocks
                if (i<0.062980831920719780936236797496413) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<0.19441908984222193245533967922806) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<0.30577650280349458860346850958404) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<0.51440865823445038466553657582474) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<0.71521710783674533837527708958142) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                }
            }else if(blockUnderneath.getMaterial()==Material.snow || blockUnderneath.getMaterial()==Material.craftedSnow || blockUnderneath.getMaterial()==Material.ice || blockUnderneath.getMaterial()==Material.packedIce){
                //On top of snow and ice
                if (i<0.041787790697674418604651162790699) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<0.17623546511627906976744186046512) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<0.20074127906976744186046511627907) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<0.23074127906976744186046511627907) {
                    drops.add(new ItemStack(MHItems.itemHoney));
                } else if (i<0.29069767441860465116279069767442) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<0.44331395348837209302325581395349) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<0.58393895348837209302325581395349) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<0.76380813953488372093023255813954) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<0.87281976744186046511627906976745) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                }
            }else if(blockUnderneath.getMaterial()==Material.rock) {
                //On top of stone and rock material outliers
                if (i<0.042395129659592417479334420387939) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<0.14816260490181882283318328622064) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<0.19982775011174837413985230327564) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<0.23982775011174837413985230327564) {
                    drops.add(new ItemStack(MHItems.itemHoney));
                } else if (i<0.3403068515918634592260087258167) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<0.46392258828121557048331958775867) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<0.60755859706998910846832327073325) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<0.73646270752145253999332657596685) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<0.91009764604410755544922846404219) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
                }
            }else{
                //On top of grass and other outliers
                if (i<0.043741908727645670924100362601089) {
                    drops.add(new ItemStack(MHItems.itemInsectHusk));
                } else if (i<0.16849461702711942297669153127505) {
                    drops.add(new ItemStack(MHItems.itemStinkhopper));
                } else if (i<0.20193394719586623550576406830576) {
                    drops.add(new ItemStack(MHItems.itemSnakebeeLarva));
                } else if (i<0.24193394719586623550576406830576) {
                    drops.add(new ItemStack(MHItems.itemHoney));
                } else if (i<0.38154937707711017580828658375974) {
                    drops.add(new ItemStack(MHItems.itemGodbug));
                } else if (i<0.46447125811929407676831079452793) {
                    drops.add(new ItemStack(MHItems.itemBitterbug));
                } else if (i<0.591577791103663559991705570158) {
                    drops.add(new ItemStack(MHItems.itemFlashbug));
                } else if (i<0.69090919280626341539961778370594) {
                    drops.add(new ItemStack(MHItems.itemThunderbug));
                } else if (i<0.82084031541250777602797688768335) {
                    drops.add(new ItemStack(MHItems.itemGlueglopper));
                } else {
                    drops.add(new ItemStack(MHItems.itemKillerBeetle));
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
