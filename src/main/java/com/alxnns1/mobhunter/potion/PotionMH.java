package com.alxnns1.mobhunter.potion;

import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 01/06/2016.
 */
public class PotionMH extends Potion
{
    public PotionMH(String name, boolean badEffect, int potionColor)
    {
        super(new ResourceLocation(Reference.MOD_ID, name), badEffect, potionColor);
    }

    @Override
    public Potion setIconIndex(int x, int y)
    {
        return super.setIconIndex(x, y);
    }
}
