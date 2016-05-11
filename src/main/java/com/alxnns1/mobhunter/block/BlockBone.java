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
 * Created by Alex on 11/05/2016.
 */
public class BlockBone extends BlockBush {
    public BlockBone(){
        super(Material.vine);
        setUnlocalizedName(Names.Blocks.BONE);
        this.setBlockBounds(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f);
        this.setCreativeTab(MobHunter.MH_TAB);
    }

    public boolean isReplaceable(World worldIn, BlockPos pos)
    {
        return false;
    }

    @Override
    public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) {
        Block blockUnderneath = world.getBlockState(pos.down()).getBlock();
        ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
        for(int n=0;n<RANDOM.nextInt(2)+1+fortune;n++){
            double i = RANDOM.nextDouble();
            if(blockUnderneath.getMaterial()==Material.sand) {
                //On top of sand and gravel
                if (i<0.14303959131545338441890166028097) {
                    drops.add(new ItemStack(MHItems.itemMonsterBoneS));
                } else if (i<0.42528735632183908045977011494252) {
                    drops.add(new ItemStack(MHItems.itemMysteryBone));
                } else {
                    drops.add(new ItemStack(MHItems.itemUnknownSkull));
                }
            }else if(blockUnderneath== Blocks.netherrack || blockUnderneath==Blocks.nether_brick || blockUnderneath==Blocks.soul_sand) {
                //On top of nether blocks
                if (i<0.16666666666666666666666666666667) {
                    drops.add(new ItemStack(MHItems.itemMonsterBoneS));
                } else if (i<0.5) {
                    drops.add(new ItemStack(MHItems.itemMysteryBone));
                } else {
                    drops.add(new ItemStack(MHItems.itemUnknownSkull));
                }
            }else if(blockUnderneath.getMaterial()==Material.snow || blockUnderneath.getMaterial()==Material.craftedSnow || blockUnderneath.getMaterial()==Material.ice || blockUnderneath.getMaterial()==Material.packedIce){
                //On top of snow and ice
                if (i<0.20652173913043478260869565217392) {
                    drops.add(new ItemStack(MHItems.itemMonsterBoneS));
                } else if (i<0.51086956521739130434782608695652) {
                    drops.add(new ItemStack(MHItems.itemMysteryBone));
                } else {
                    drops.add(new ItemStack(MHItems.itemUnknownSkull));
                }
            }else if(blockUnderneath.getMaterial()==Material.rock) {
                //On top of stone and rock material outliers
                if (i<0.17319848293299620733249051833123) {
                    drops.add(new ItemStack(MHItems.itemMonsterBoneS));
                } else if (i<0.32490518331226295828065739570165) {
                    drops.add(new ItemStack(MHItems.itemMonsterBoneM));
                } else if (i<0.74968394437420986093552465233883) {
                    drops.add(new ItemStack(MHItems.itemMysteryBone));
                } else {
                    drops.add(new ItemStack(MHItems.itemUnknownSkull));
                }
            }else{
                //On top of grass and other outliers
                if (i<0.28305084745762711864406779661017) {
                    drops.add(new ItemStack(MHItems.itemMonsterBoneS));
                } else if (i<0.71525423728813559322033898305083) {
                    drops.add(new ItemStack(MHItems.itemMysteryBone));
                } else {
                    drops.add(new ItemStack(MHItems.itemUnknownSkull));
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
