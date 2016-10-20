package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 11/05/2016.
 */
public class BlockBone extends BlockNatural
{
    public BlockBone(){
        super(Names.Blocks.BONE, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
    }

    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.11303959131545338441890166028097)        drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 0)); //Monster Bone S
        else if (chance < 0.36528735632183908045977011494252)   drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 2)); //Mystery Bone
        else if (chance < 0.91)                                 drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 3)); //UnknownSkull
        else                                                    drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 6)); //Dung
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.13666666666666666666666666666667)        drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 0)); //Monster Bone S
        else if (chance < 0.44)                                 drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 2)); //Mystery Bone
        else if (chance < 0.91)                                 drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 3)); //UnknownSkull
        else                                                    drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 6)); //Dung
        return drops;
    }

    public ArrayList<ItemStack> getDropsCold(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.17652173913043478260869565217392)        drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 0)); //Monster Bone S
        else if (chance < 0.45086956521739130434782608695652)   drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 2)); //Mystery Bone
        else if (chance < 0.91)                                 drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 3)); //UnknownSkull
        else                                                    drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 6)); //Dung
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.14319848293299620733249051833123)            drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 0)); //Monster Bone S
        else if (chance < 0.26490518331226295828065739570165)       drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 1)); //Monster Bone M
        else if (chance < 0.65968394437420986093552465233883)       drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 2)); //Mystery Bone
        else if (chance < 0.88)                                     drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 3)); //UnknownSkull
        else                                                        drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 6)); //Dung
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.25305084745762711864406779661017)            drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 0)); //Monster Bone S
        else if (chance < 0.65525423728813559322033898305083)       drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 2)); //Mystery Bone
        else if (chance < 0.91)                                     drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 3)); //UnknownSkull
        else                                                        drops.add(new ItemStack(MHItems.itemMonsterDrop, 1, 6)); //Dung
        return drops;
    }
}
