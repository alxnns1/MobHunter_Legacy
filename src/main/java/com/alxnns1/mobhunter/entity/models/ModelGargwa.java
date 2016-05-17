package com.alxnns1.mobhunter.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 17/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelGargwa extends ModelBase {

    ModelRenderer body;
    ModelRenderer hip1;
    ModelRenderer leg1;
    ModelRenderer foot1;
    ModelRenderer hip2;
    ModelRenderer leg2;
    ModelRenderer foot2;
    ModelRenderer tail;
    ModelRenderer neck1;
    ModelRenderer wing1;
    ModelRenderer wing2;
    ModelRenderer neck2;
    ModelRenderer head;
    ModelRenderer crest;
    ModelRenderer bill;
    ModelRenderer mouth;

    public ModelGargwa() {
        this.textureHeight = 64;
        this.textureWidth = 64;

        this.body = new ModelRenderer(this,0,1);
        this.body.addBox(-4.0f,-7.5f,-6.5f,8,10,12);
        this.body.setRotationPoint(0.0f,12.0f,0.0f);

        this.hip1 = new ModelRenderer(this,29,0);
        this.body.addChild(hip1);
        this.hip1.mirror = true;
        this.hip1.addBox(-3.0f,-2.5f,-2.5f,3,6,5);
        this.hip1.setRotationPoint(-4.0f,0.0f,0.0f);

        this.leg1 = new ModelRenderer(this,0,0);
        this.hip1.addChild(leg1);
        this.leg1.mirror = true;
        this.leg1.addBox(-1.0f,-1.0f,-1.0f,2,10,2);
        this.leg1.setRotationPoint(-1.5f,2.5f,1.5f);
        this.leg1.rotateAngleX = (float) -Math.PI/12;

        this.foot1 = new ModelRenderer(this,46,0);
        this.leg1.addChild(foot1);
        this.foot1.mirror = true;
        this.foot1.addBox(-1.5f,-1.0f,-3.0f,3,2,4);
        this.foot1.setRotationPoint(0.0f,9.0f,0.0f);
        this.foot1.rotateAngleX = (float) Math.PI/12;

        this.hip2 = new ModelRenderer(this,29,0);
        this.body.addChild(hip2);
        this.hip2.addBox(0.0f,-2.5f,-2.5f,3,6,5);
        this.hip2.setRotationPoint(4.0f,0.0f,0.0f);

        this.leg2 = new ModelRenderer(this,0,0);
        this.hip2.addChild(leg2);
        this.leg2.addBox(-1.0f,-1.0f,-1.0f,2,10,2);
        this.leg2.setRotationPoint(1.5f,2.5f,1.5f);
        this.leg2.rotateAngleX = (float) -Math.PI/12;

        this.foot2 = new ModelRenderer(this,46,0);
        this.leg2.addChild(foot2);
        this.foot2.addBox(-1.5f,-1.0f,-3.0f,3,2,4);
        this.foot2.setRotationPoint(0.0f,9.0f,0.0f);
        this.foot2.rotateAngleX = (float) Math.PI/12;

        this.tail = new ModelRenderer(this,0,24);
        this.body.addChild(tail);
        this.tail.addBox(-3.0f,-4.0f,-2.0f,6,8,5);
        this.tail.setRotationPoint(0.0f,-2.5f,4.5f);
        this.tail.rotateAngleX = (float) Math.PI/6;

        this.neck1 = new ModelRenderer(this,33,17);
        this.body.addChild(neck1);
        this.neck1.addBox(-3.0f,-4.0f,-5.0f,6,8,8);
        this.neck1.setRotationPoint(0.0f,-2.5f,-6.5f);
        this.neck1.rotateAngleX = (float) -Math.PI/6;

        this.wing1 = new ModelRenderer(this,46,7);
        this.neck1.addChild(wing1);
        this.wing1.mirror = true;
        this.wing1.addBox(0.0f,-1.5f,0.0f,0,3,6);
        this.wing1.setRotationPoint(-3.0f,-1.0f,-4.0f);
        this.wing1.rotateAngleX = (float) Math.PI/6;
        this.wing1.rotateAngleY = (float) -Math.PI/6;

        this.wing2 = new ModelRenderer(this,46,7);
        this.neck1.addChild(wing2);
        this.wing2.addBox(0.0f,-1.5f,0.0f,0,3,6);
        this.wing2.setRotationPoint(3.0f,-1.0f,-4.0f);
        this.wing2.rotateAngleX = (float) Math.PI/6;
        this.wing2.rotateAngleY = (float) Math.PI/6;

        this.neck2 = new ModelRenderer(this,0,38);
        this.neck1.addChild(neck2);
        this.neck2.addBox(-2.0f,-7.0f,-2.0f,4,10,4);
        this.neck2.setRotationPoint(0.0f,0.0f,-5.0f);
        this.neck2.rotateAngleX = (float) Math.PI/6;

        this.head = new ModelRenderer(this,23,34);
        this.neck2.addChild(head);
        this.head.addBox(-2.0f,-2.0f,-3.0f,4,4,5);
        this.head.setRotationPoint(0.0f,-7.0f,0.0f);

        this.crest = new ModelRenderer(this,42,34);
        this.head.addChild(crest);
        this.crest.addBox(-1.5f,-2.0f,-1.0f,3,2,6);
        this.crest.setRotationPoint(0.0f,-2.0f,0.0f);
        this.crest.rotateAngleX = (float) Math.PI/6;

        this.bill = new ModelRenderer(this,17,44);
        this.head.addChild(bill);
        this.bill.addBox(-1.5f,-1.0f,-5.0f,3,1,5);
        this.bill.setRotationPoint(0.0f,0.0f,-3.0f);

        this.mouth = new ModelRenderer(this,37,43);
        this.bill.addChild(mouth);
        this.mouth.addBox(-1.0f,0.0f,-5.0f,2,1,5);
        this.mouth.setRotationPoint(0.0f,0.0f,0.0f);

    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {

        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn);

        if (this.isChild) {
            this.body.render(scale);
        }
        else {
            this.body.render(scale);
        }
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);

        this.head.rotateAngleX = p_78087_5_ / (180F / (float)Math.PI);
        this.head.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/3;
        this.neck1.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/3;
        this.neck2.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/3;
        this.hip1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.hip2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.tail.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/3;
        this.wing1.rotateAngleY = -Math.abs((MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/2) - (float)Math.PI/6;
        this.wing2.rotateAngleY = Math.abs((MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/2) + (float)Math.PI/6;

    }
}
