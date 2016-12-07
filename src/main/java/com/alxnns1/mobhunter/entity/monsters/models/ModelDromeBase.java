package com.alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 01/06/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelDromeBase extends ModelBase
{
    ModelRenderer body;
    ModelRenderer thigh1;
    ModelRenderer thigh2;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer neck1;
    ModelRenderer neck2;
    ModelRenderer head;
    ModelRenderer snout;
    ModelRenderer jaw;
    ModelRenderer shoulder1;
    ModelRenderer shoulder2;
    ModelRenderer arm1;
    ModelRenderer arm2;
    ModelRenderer hand1;
    ModelRenderer hand2;
    ModelRenderer talon1;
    ModelRenderer talon2;

    public ModelDromeBase()
    {
        this.textureHeight = 256;
        this.textureWidth = 256;

        this.body = new ModelRenderer(this,0,0);
        this.body.addBox(-13.0f,-16.0f,-20.0f,26,24,34);
        this.body.setRotationPoint(0.0f,-13.0f,0.0f);

        this.thigh1 = new ModelRenderer(this,92,58);
        this.body.addChild(thigh1);
        this.thigh1.addBox(-10.0f,-8.0f,-8.0f,10,20,16);
        this.thigh1.setRotationPoint(-13.0f,0.0f,0.0f);

        this.thigh2 = new ModelRenderer(this,92,58);
        this.body.addChild(thigh2);
        this.thigh2.mirror = true;
        this.thigh2.addBox(0.0f,-8.0f,-8.0f,10,20,16);
        this.thigh2.setRotationPoint(13.0f,0.0f,0.0f);

        this.leg1 = new ModelRenderer(this,144,42);
        this.thigh1.addChild(leg1);
        this.leg1.addBox(-3.0f,-4.0f,-3.0f,6,34,6);
        this.leg1.setRotationPoint(-5.0f,8.0f,5.0f);
        this.leg1.rotateAngleX = -(float)Math.PI/12;

        this.leg2 = new ModelRenderer(this,144,42);
        this.thigh2.addChild(leg2);
        this.leg2.mirror = true;
        this.leg2.addBox(-3.0f,-4.0f,-3.0f,6,34,6);
        this.leg2.setRotationPoint(5.0f,8.0f,5.0f);
        this.leg2.rotateAngleX = -(float)Math.PI/12;

        this.foot1 = new ModelRenderer(this,86,0);
        this.leg1.addChild(foot1);
        this.foot1.addBox(-5.0f,-2.0f,-14.0f,10,6,14);
        this.foot1.setRotationPoint(0.0f,26.0f,0.0f);
        this.foot1.rotateAngleX = (float)Math.PI/12;

        this.foot2 = new ModelRenderer(this,86,0);
        this.leg2.addChild(foot2);
        this.foot2.mirror = true;
        this.foot2.addBox(-5.0f,-2.0f,-14.0f,10,6,14);
        this.foot2.setRotationPoint(0.0f,26.0f,0.0f);
        this.foot2.rotateAngleX = (float)Math.PI/12;

        this.tail1 = new ModelRenderer(this,120,0);
        this.body.addChild(tail1);
        this.tail1.addBox(-10.0f,-8.0f,-4.0f,20,16,26);
        this.tail1.setRotationPoint(0.0f,-7.0f,12.0f);
        this.tail1.rotateAngleX = -(float)Math.PI/18;

        this.tail2 = new ModelRenderer(this,168,42);
        this.tail1.addChild(tail2);
        this.tail2.addBox(-6.0f,-7.0f,-4.0f,12,14,26);
        this.tail2.setRotationPoint(0.0f,0.0f,22.0f);
        this.tail2.rotateAngleX = (float)Math.PI/36;

        this.tail3 = new ModelRenderer(this,118,82);
        this.tail2.addChild(tail3);
        this.tail3.addBox(-3.0f,-4.0f,-4.0f,6,8,26);
        this.tail3.setRotationPoint(0.0f,0.0f,22.0f);
        this.tail3.rotateAngleX = (float)Math.PI/36;

        this.neck1 = new ModelRenderer(this,0,58);
        this.body.addChild(neck1);
        this.neck1.addBox(-10.0f,-10.0f,-18.0f,20,20,26);
        this.neck1.setRotationPoint(0.0f,-10.0f,-22.0f);
        this.neck1.rotateAngleX = -(float)Math.PI/6;

        this.neck2 = new ModelRenderer(this,182,82);
        this.neck1.addChild(neck2);
        this.neck2.addBox(-7.0f,-20.0f,-7.0f,14,24,14);
        this.neck2.setRotationPoint(0.0f,-2.0f,-18.0f);
        this.neck2.rotateAngleX = (float)Math.PI/3;

        this.head = new ModelRenderer(this,0,104);
        this.neck2.addChild(head);
        this.head.addBox(-10.0f,-10.0f,-12.0f,20,20,24);
        this.head.setRotationPoint(0.0f,-20.0f,0.0f);
        this.head.rotateAngleX = -(float)Math.PI/6;

        this.snout = new ModelRenderer(this,0,148);
        this.head.addChild(snout);
        this.snout.addBox(-7.0f,-14.0f,-24.0f,14,14,24);
        this.snout.setRotationPoint(0.0f,4.0f,-12.0f);

        this.jaw = new ModelRenderer(this,0,186);
        this.head.addChild(jaw);
        this.jaw.addBox(-5.0f,0.0f,-24.0f,10,6,24);
        this.jaw.setRotationPoint(0.0f,4.0f,-12.0f);

        this.shoulder1 = new ModelRenderer(this,186,0);
        this.neck1.addChild(shoulder1);
        this.shoulder1.addBox(-6.0f,-6.0f,-5.0f,6,16,10);
        this.shoulder1.setRotationPoint(-10.0f,6.0f,-6.0f);

        this.shoulder2 = new ModelRenderer(this,186,0);
        this.neck1.addChild(shoulder2);
        this.shoulder2.mirror = true;
        this.shoulder2.addBox(0.0f,-6.0f,-5.0f,6,16,10);
        this.shoulder2.setRotationPoint(10.0f,6.0f,-6.0f);

        this.arm1 = new ModelRenderer(this,218,0);
        this.shoulder1.addChild(arm1);
        this.arm1.addBox(-3.0f,-4.0f,-3.0f,6,16,6);
        this.arm1.setRotationPoint(-3.0f,10.0f,0.0f);
        this.arm1.rotateAngleX = -(float)Math.PI/6;

        this.arm2 = new ModelRenderer(this,218,0);
        this.shoulder2.addChild(arm2);
        this.arm2.mirror = true;
        this.arm2.addBox(-3.0f,-4.0f,-3.0f,6,16,6);
        this.arm2.setRotationPoint(3.0f,10.0f,0.0f);
        this.arm2.rotateAngleX = -(float)Math.PI/6;

        this.hand1 = new ModelRenderer(this,214,22);
        this.arm1.addChild(hand1);
        this.hand1.addBox(-3.0f,0.0f,0.0f,6,6,4);
        this.hand1.setRotationPoint(0.0f,12.0f,-3.0f);
        this.hand1.rotateAngleX = (float)Math.PI/6;

        this.hand2 = new ModelRenderer(this,214,22);
        this.arm2.addChild(hand2);
        this.hand2.mirror = true;
        this.hand2.addBox(-3.0f,0.0f,0.0f,6,6,4);
        this.hand2.setRotationPoint(0.0f,12.0f,-3.0f);
        this.hand2.rotateAngleX = (float)Math.PI/6;

        this.talon1 = new ModelRenderer(this,0,0);
        this.hand1.addChild(talon1);
        this.talon1.addBox(0.0f,0.0f,0.0f,2,6,2);
        this.talon1.setRotationPoint(-1.0f,6.0f,0.0f);
        this.talon1.rotateAngleX = (float)Math.PI/6;

        this.talon2 = new ModelRenderer(this,0,0);
        this.hand2.addChild(talon2);
        this.talon2.addBox(0.0f,0.0f,0.0f,2,6,2);
        this.talon2.setRotationPoint(-1.0f,6.0f,0.0f);
        this.talon2.rotateAngleX = (float)Math.PI/6;
    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale)
    {
        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn);
        this.body.render(scale);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);
        this.head.rotateAngleX = (p_78087_5_ / (180F / (float)Math.PI)) - (float)Math.PI/6;
        this.head.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/3;
        this.neck1.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/3;
        this.neck2.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/3;
        this.thigh1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.thigh2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.tail1.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/3;
        this.tail2.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
        this.tail3.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
    }
}
