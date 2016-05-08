package com.alxnns1.mobhunter.block.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by Mark on 08/05/2016.
 */
public class ModelBbqMeat extends ModelBase
{
    private ModelRenderer meat;

    public ModelBbqMeat()
    {
        meat = new ModelRenderer(this, "meat");

        setTextureOffset("meat.middle",     0, 0);
        setTextureOffset("meat.boneW",      0, 24);
        setTextureOffset("meat.boneEndW1",  0, 26);
        setTextureOffset("meat.boneEndW2",  0, 26);
        setTextureOffset("meat.boneE",      0, 24);
        setTextureOffset("meat.boneEndE1",  0, 26);
        setTextureOffset("meat.boneEndE2",  0, 26);

        meat.addBox("middle",       5 , 6, 6, 6, 3, 3);
        meat.addBox("boneW",        2 , 7, 7, 3, 1, 1);
        meat.addBox("boneEndW1",    1 , 7, 6, 1, 1, 1);
        meat.addBox("boneEndW2",    1 , 7, 8, 1, 1, 1);
        meat.addBox("boneE",        11, 7, 7, 3, 1, 1);
        meat.addBox("boneEndE1",    14, 7, 6, 1, 1, 1);
        meat.addBox("boneEndE2",    14, 7, 8, 1, 1, 1);
    }

    public void render()
    {
        render(0);
    }

    public void render(int cookState)
    {
        //Change texture of meat corresponding to the meat's cooking state.
        if(getTextureOffset("meat.middle").textureOffsetY != cookState * 6)
            setTextureOffset("meat.middle", 0, cookState * 6);
        meat.render(1f / 16f);
    }
}
