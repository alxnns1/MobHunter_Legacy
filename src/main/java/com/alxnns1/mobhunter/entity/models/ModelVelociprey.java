package com.alxnns1.mobhunter.entity.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 30/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelVelociprey extends ModelPreyBase {

    ModelRenderer crest;

    public ModelVelociprey() {
        this.crest = new ModelRenderer(this,44,58);
        this.head.addChild(crest);
        this.crest.addBox(0.0f,-4.0f,-7.0f,0,7,18);
        this.crest.setRotationPoint(0.0f,-5.0f,0.0f);
    }
}
