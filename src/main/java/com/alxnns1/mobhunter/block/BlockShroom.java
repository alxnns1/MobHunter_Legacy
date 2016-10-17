package com.alxnns1.mobhunter.block;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.reference.Names;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.ArrayList;

/**
 * Created by Alex on 04/05/2016.
 */
public class BlockShroom extends BlockNatural
{
    public BlockShroom(){
        super(Names.Blocks.SHROOM, new AxisAlignedBB(0.2f, 0.0f, 0.2f, 0.8f, 0.7f, 0.8f));
    }

    /*
    public ArrayList<ItemStack> getDropsSand(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.23469387755102040816326530612244)        drops.add(new ItemStack(MHItems.itemBlueMushroom));
        else if (chance < 0.60969387755102040816326530612245)   drops.add(new ItemStack(MHItems.itemExciteshroom));
        else                                                    drops.add(new ItemStack(MHItems.itemMopeshroom));
        return drops;
    }

    public ArrayList<ItemStack> getDropsNether(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.51228978007761966364812419146184)        drops.add(new ItemStack(MHItems.itemBlueMushroom));
        else if (chance < 0.70177708177299652754136311023354)   drops.add(new ItemStack(MHItems.itemNitroshroom));
        else if (chance < 0.88765574998297814393681487029346)   drops.add(new ItemStack(MHItems.itemParashroom));
        else                                                    drops.add(new ItemStack(MHItems.itemExciteshroom));
        return drops;
    }

    public ArrayList<ItemStack> getDropsRock(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.27414600312120686665510664123462)        drops.add(new ItemStack(MHItems.itemBlueMushroom));
        else if (chance < 0.43367435408357898387376452228196)   drops.add(new ItemStack(MHItems.itemNitroshroom));
        else if (chance < 0.5932027050459511010924224033293)    drops.add(new ItemStack(MHItems.itemParashroom));
        else if (chance < 0.65215883474943644876018727241201)   drops.add(new ItemStack(MHItems.itemExciteshroom));
        else if (chance < 0.95283509623721172186578810473385)   drops.add(new ItemStack(MHItems.itemMopeshroom));
        else                                                    drops.add(new ItemStack(MHItems.itemDragonToadstool));
        return drops;
    }

    public ArrayList<ItemStack> getDropsOther(ArrayList<ItemStack> drops, double chance)
    {
        if (chance < 0.14694647912640992225767312272503)        drops.add(new ItemStack(MHItems.itemBlueMushroom));
        else if (chance < 0.3015323776569451309935739001483)    drops.add(new ItemStack(MHItems.itemParashroom));
        else if (chance < 0.71675729115175481957488877904105)   drops.add(new ItemStack(MHItems.itemToadstool));
        else if (chance < 0.79764526131308138228553453466951)   drops.add(new ItemStack(MHItems.itemExciteshroom));
        else                                                    drops.add(new ItemStack(MHItems.itemMopeshroom));
        return drops;
    }
    */
}
