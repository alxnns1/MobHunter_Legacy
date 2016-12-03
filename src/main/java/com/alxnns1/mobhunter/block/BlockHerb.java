package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 03/05/2016.
 */
public class BlockHerb extends BlockNatural
{
    public BlockHerb(){
        super(Names.Blocks.HERB, new AxisAlignedBB(0.1f, 0.0f, 0.1f, 0.9f, 0.75f, 0.9f));
    }

    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.24044694515556929348449815838642)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "herb"));
        else if (chance < 0.39824025291391164233370007482751)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "fireHerb"));
        else if (chance < 0.49731329976041936048240533453302)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sleepHerb"));
        else if (chance < 0.63162546053091314551476172769419)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sapPlant"));
        else if (chance < 0.75964119522022087121252695090918)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "felvine"));
        else if (chance < 0.8934382856696908812966428616242)    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "gloamgrassRoot"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "hotPepper"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.15722379603399433427762039660058)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "herb"));
        else if (chance < 0.41643059490084985835694050991504)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "antidoteHerb"));
        else if (chance < 0.58640226628895184135977337110485)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "fireHerb"));
        else if (chance < 0.75637393767705382436260623229466)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "ivy"));
        else if (chance < 0.84135977337110481586402266288957)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sapPlant"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "gloamgrassRoot"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsCold(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.23785803237858032378580323785803)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "herb"));
        else if (chance < 0.46699875466998754669987546699875)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sleepHerb"));
        else if (chance < 0.65130759651307596513075965130759)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sapPlant"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "felvine"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.13405341021372206656650559683816)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "herb"));
        else if (chance < 0.31612999282630175552577794020114)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "antidoteHerb"));
        else if (chance < 0.50129261921197601548435998429908)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "fireHerb"));
        else if (chance < 0.63837793207996643250632774326282)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "ivy"));
        else if (chance < 0.75954575601304800963711915106726)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sapPlant"));
        else if (chance < 0.84400590138195205803927938170843)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "felvine"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "gloamgrassRoot"));
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.15908241598812579991386447291226)        drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "herb"));
        else if (chance < 0.35843886134033408081858071111877)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.CONSUMABLE, "antidoteHerb"));
        else if (chance < 0.48309057811764829542106967932635)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "ivy"));
        else if (chance < 0.59136575706185465777724422736793)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sleepHerb"));
        else if (chance < 0.77048450265861149198405745351408)   drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "sapPlant"));
        else if (chance < 0.8508311912399560415608067252761)    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "felvine"));
        else                                                    drops.add(MetaRef.getStack(MetaRef.EnumItemType.PLANT, "hotPepper"));
        return drops;
    }
}
