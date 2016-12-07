package com.alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 01/06/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelGreatJaggi extends ModelDromeBase
{
    ModelRenderer spike1;
    ModelRenderer spike2;
    ModelRenderer spike3;
    ModelRenderer spike4;
    ModelRenderer spike5;
    ModelRenderer spike6;
    ModelRenderer ridge1;
    ModelRenderer ridge2;
    ModelRenderer ridge3;
    ModelRenderer ridge4;
    ModelRenderer frill1;
    ModelRenderer frill2;

    public ModelGreatJaggi()
    {
        this.spike1 = new ModelRenderer(this,0,216);
        this.tail3.addChild(spike1);
        this.spike1.addBox(-5.0f,-1.0f,-1.0f,10,2,2);
        this.spike1.setRotationPoint(0.0f,0.0f,18.0f);

        this.spike2 = new ModelRenderer(this,0,216);
        this.tail3.addChild(spike2);
        this.spike2.addBox(-5.0f,-1.0f,-1.0f,10,2,2);
        this.spike2.setRotationPoint(0.0f,0.0f,10.0f);

        this.spike3 = new ModelRenderer(this,0,216);
        this.tail3.addChild(spike3);
        this.spike3.addBox(-5.0f,-1.0f,-1.0f,10,2,2);
        this.spike3.setRotationPoint(0.0f,0.0f,2.0f);

        this.spike4 = new ModelRenderer(this,0,220);
        this.tail2.addChild(spike4);
        this.spike4.addBox(-8.0f,-1.0f,-1.0f,16,2,2);
        this.spike4.setRotationPoint(0.0f,0.0f,18.0f);

        this.spike5 = new ModelRenderer(this,0,220);
        this.tail2.addChild(spike5);
        this.spike5.addBox(-8.0f,-1.0f,-1.0f,16,2,2);
        this.spike5.setRotationPoint(0.0f,0.0f,10.0f);

        this.spike6 = new ModelRenderer(this,0,220);
        this.tail2.addChild(spike6);
        this.spike6.addBox(-8.0f,-1.0f,-1.0f,16,2,2);
        this.spike6.setRotationPoint(0.0f,0.0f,2.0f);

        this.ridge1 = new ModelRenderer(this,196,108);
        this.head.addChild(ridge1);
        this.ridge1.addBox(0.0f,-23.0f,-8.0f,0,23,23);
        this.ridge1.setRotationPoint(0.0f,10.0f,0.0f);

        this.ridge2 = new ModelRenderer(this,128,114);
        this.body.addChild(ridge2);
        this.ridge2.addBox(0.0f,-6.0f,-34.0f,0,6,34);
        this.ridge2.setRotationPoint(0.0f,-16.0f,12.0f);

        this.ridge3 = new ModelRenderer(this,128,114);
        this.tail1.addChild(ridge3);
        this.ridge3.addBox(0.0f,-6.0f,-26.0f,0,6,26);
        this.ridge3.setRotationPoint(0.0f,-8.0f,22.0f);

        this.ridge4 = new ModelRenderer(this,128,107);
        this.tail2.addChild(ridge4);
        this.ridge4.addBox(0.0f,-5.0f,-26.0f,0,5,26);
        this.ridge4.setRotationPoint(0.0f,-7.0f,22.0f);

        this.frill1 = new ModelRenderer(this,88,98);
        this.head.addChild(frill1);
        this.frill1.addBox(0.0f,-15.0f,0.0f,0,36,20);
        this.frill1.setRotationPoint(-10.0f,0.0f,-6.0f);
        this.frill1.rotateAngleY = -(float)Math.PI/12;

        this.frill2 = new ModelRenderer(this,88,98);
        this.head.addChild(frill2);
        this.frill2.addBox(0.0f,-15.0f,0.0f,0,36,20);
        this.frill2.setRotationPoint(10.0f,0.0f,-6.0f);
        this.frill2.rotateAngleY = (float)Math.PI/12;
    }
}
