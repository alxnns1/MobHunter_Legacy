package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 10/05/2016.
 */
public class BlockBug extends BlockNatural
{
    public BlockBug() { super(Names.Blocks.BUG, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f)); }

    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        if (chance<0.023140495867768595041322314049587)     drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "insectHusk"));
        else if (chance<0.082644628099173553719008264462811)drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "stinkHopper"));
        else if (chance<0.12198347107438016528925619834711) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "snakebeeLarva"));
        else if (chance<0.16198347107438016528925619834711) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "honey"));
        else if (chance<0.25619834710743801652892561983471) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "godbug"));
        else if (chance<0.38512396694214876033057851239669) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug"));
        else if (chance<0.46446280991735537190082644628099) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "flashbug"));
        else if (chance<0.55702479338842975206611570247934) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "thunderbug"));
        else if (chance<0.67603305785123966942148760330579) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"));
        else if (chance<0.75404958677685950413223140495868) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "killerBeetle"));
        else if (chance<0.8928925619834710743801652892562)  drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "hercudrome"));
        else                                                drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "rareScarab"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        if (chance<0.062980831920719780936236797496413)     drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "insectHusk"));
        else if (chance<0.19441908984222193245533967922806) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "godbug"));
        else if (chance<0.30577650280349458860346850958404) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug"));
        else if (chance<0.51440865823445038466553657582474) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "flashbug"));
        else if (chance<0.71521710783674533837527708958142) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "thunderbug"));
        else                                                drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsCold(ArrayList<ItemStack> drops, double chance)
    {
        if (chance<0.041787790697674418604651162790699)     drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "insectHusk"));
        else if (chance<0.17623546511627906976744186046512) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "stinkHopper"));
        else if (chance<0.20074127906976744186046511627907) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "snakebeeLarva"));
        else if (chance<0.23074127906976744186046511627907) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "honey"));
        else if (chance<0.29069767441860465116279069767442) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "godbug"));
        else if (chance<0.44331395348837209302325581395349) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug"));
        else if (chance<0.58393895348837209302325581395349) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "flashbug"));
        else if (chance<0.76380813953488372093023255813954) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "thunderbug"));
        else if (chance<0.87281976744186046511627906976745) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"));
        else                                                drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "killerBeetle"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        if (chance<0.042395129659592417479334420387939)     drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "insectHusk"));
        else if (chance<0.14816260490181882283318328622064) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "stinkHopper"));
        else if (chance<0.19982775011174837413985230327564) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "snakebeeLarva"));
        else if (chance<0.23982775011174837413985230327564) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "honey"));
        else if (chance<0.3403068515918634592260087258167)  drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "godbug"));
        else if (chance<0.46392258828121557048331958775867) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug"));
        else if (chance<0.60755859706998910846832327073325) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "flashbug"));
        else if (chance<0.73646270752145253999332657596685) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "thunderbug"));
        else if (chance<0.91009764604410755544922846404219) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"));
        else                                                drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "killerBeetle"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        if (chance<0.043741908727645670924100362601089)     drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "insectHusk"));
        else if (chance<0.16849461702711942297669153127505) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "stinkHopper"));
        else if (chance<0.20193394719586623550576406830576) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "snakebeeLarva"));
        else if (chance<0.24193394719586623550576406830576) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "honey"));
        else if (chance<0.38154937707711017580828658375974) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "godbug"));
        else if (chance<0.46447125811929407676831079452793) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "bitterbug"));
        else if (chance<0.591577791103663559991705570158)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "flashbug"));
        else if (chance<0.69090919280626341539961778370594) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "thunderbug"));
        else if (chance<0.82084031541250777602797688768335) drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "glueglopper"));
        else                                                drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, "killerBeetle"));
        return drops;
    }
}
