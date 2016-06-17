package com.alxnns1.mobhunter.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 27/04/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelKelbi extends ModelBase {

    ModelRenderer neck;
    ModelRenderer head;
    ModelRenderer ear1;
    ModelRenderer ear2;
    ModelRenderer h1;
    ModelRenderer h2;
    ModelRenderer h3;
    ModelRenderer h4;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer tail;

    public ModelKelbi() {
        this.textureHeight = 64;
        this.textureWidth = 64;

        this.body = new ModelRenderer(this,0,0);
        this.body.addBox(-4.0f,-8.0f,-15.0f,8,8,15);
        this.body.setRotationPoint(0.0f,14.0f,7.5f);

        this.leg1 = new ModelRenderer(this,0,0);
        this.body.addChild(leg1);
        this.leg1.addBox(-1.5f,0.0f,-1.5f,3,10,3);
        this.leg1.setRotationPoint(-2.5f,0.0f,-13.5f);

        this.leg2 = new ModelRenderer(this,0,0);
        this.body.addChild(leg2);
        this.leg2.mirror = true;
        this.leg2.addBox(-1.5f,0.0f,-1.5f,3,10,3);
        this.leg2.setRotationPoint(2.5f,0.0f,-13.5f);

        this.leg3 = new ModelRenderer(this,0,0);
        this.body.addChild(leg3);
        this.leg3.addBox(-1.5f,0.0f,-1.5f,3,10,3);
        this.leg3.setRotationPoint(-2.5f,0.0f,-1.5f);

        this.leg4 = new ModelRenderer(this,0,0);
        this.body.addChild(leg4);
        this.leg4.mirror = true;
        this.leg4.addBox(-1.5f,0.0f,-1.5f,3,10,3);
        this.leg4.setRotationPoint(2.5f,0.0f,-1.5f);

        this.neck = new ModelRenderer(this,0,23);
        this.body.addChild(neck);
        this.neck.addBox(-2.0f,-2.0f,-4.0f,4,4,6);
        this.neck.setRotationPoint(0.0f,-8.0f,-15.0f);
        this.neck.rotateAngleX = (float) -Math.PI/4;

        this.head = new ModelRenderer(this,31,0);
        this.neck.addChild(head);
        this.head.addBox(-2.0f,-2.0f,-4.0f,4,8,4);
        this.head.setRotationPoint(0.0f,0.0f,-4.0f);

        this.ear1 = new ModelRenderer(this,31,12);
        this.head.addChild(ear1);
        this.ear1.addBox(-3.0f,0.0f,-1.0f,3,1,2);
        this.ear1.setRotationPoint(-2.0f,-1.0f,-3.0f);
        this.ear1.rotateAngleX = (float) Math.PI/4;

        this.ear2 = new ModelRenderer(this,31,12);
        this.head.addChild(ear2);
        this.ear2.mirror = true;
        this.ear2.addBox(0.0f,0.0f,-1.0f,3,1,2);
        this.ear2.setRotationPoint(2.0f,-1.0f,-3.0f);
        this.ear2.rotateAngleX = (float) Math.PI/4;

        this.h1 = new ModelRenderer(this,0,23);
        this.head.addChild(h1);
        this.h1.addBox(0.0f,0.0f,0.0f,1,2,2);
        this.h1.setRotationPoint(-2.0f,0.0f,-6.0f);

        this.h2 = new ModelRenderer(this,0,23);
        this.head.addChild(h2);
        this.h2.mirror = true;
        this.h2.addBox(0.0f,0.0f,0.0f,1,2,2);
        this.h2.setRotationPoint(1.0f,0.0f,-6.0f);

        this.h3 = new ModelRenderer(this,9,0);
        this.h1.addChild(h3);
        this.h3.addBox(0.0f,0.0f,0.0f,1,1,2);
        this.h3.setRotationPoint(0.0f,0.0f,-2.0f);

        this.h4 = new ModelRenderer(this,9,0);
        this.h2.addChild(h4);
        this.h4.addBox(0.0f,0.0f,0.0f,1,1,2);
        this.h4.setRotationPoint(0.0f,0.0f,-2.0f);

        this.tail = new ModelRenderer(this,20,23);
        this.body.addChild(tail);
        this.tail.addBox(-1.5f,0.0f,-1.0f,3,7,1);
        this.tail.setRotationPoint(0.0f,-8.0f,0.0f);
        this.tail.rotateAngleX = (float)Math.PI/6;
    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {

        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn);

        this.body.render(scale);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);
        this.head.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.neck.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
        this.leg1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.leg2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.leg3.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.leg4.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.tail.rotateAngleX = (Math.abs(MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/2) + (float)Math.PI/6;
    }
}
