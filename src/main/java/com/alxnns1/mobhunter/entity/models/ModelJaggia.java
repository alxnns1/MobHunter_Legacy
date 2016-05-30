package com.alxnns1.mobhunter.entity.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 30/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelJaggia extends ModelPreyBase {

    ModelRenderer frill1;
    ModelRenderer frill2;

    public ModelJaggia() {
        this.frill1 = new ModelRenderer(this,44,49);
        this.head.addChild(frill1);
        this.frill1.addBox(0.0f,-4.5f,0.0f,0,15,9);
        this.frill1.setRotationPoint(-5.0f,0.0f,-3.0f);
        this.frill1.rotateAngleY = -(float)Math.PI/12;

        this.frill2 = new ModelRenderer(this,44,49);
        this.head.addChild(frill2);
        this.frill2.mirror = true;
        this.frill2.addBox(0.0f,-4.5f,0.0f,0,15,9);
        this.frill2.setRotationPoint(5.0f,0.0f,-3.0f);
        this.frill2.rotateAngleY = (float)Math.PI/12;
    }
}
