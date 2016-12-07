package com.alxnns1.mobhunter.entity.monsters.models;

import com.alxnns1.mobhunter.entity.monsters.EntityAltaroth;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 18/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelAltaroth extends ModelBase {

    ModelRenderer thorax;
    ModelRenderer thigh1;
    ModelRenderer leg1;
    ModelRenderer thigh2;
    ModelRenderer leg2;
    ModelRenderer thigh3;
    ModelRenderer leg3;
    ModelRenderer thigh4;
    ModelRenderer leg4;
    ModelRenderer thigh5;
    ModelRenderer leg5;
    ModelRenderer thigh6;
    ModelRenderer leg6;
    ModelRenderer abdomen;
    ModelRenderer juice;
    ModelRenderer stinger;
    ModelRenderer head;
    ModelRenderer crest;
    ModelRenderer mandible1;
    ModelRenderer mandible2;

    public ModelAltaroth(){
        this.textureHeight = 32;
        this.textureWidth = 32;

        this.thorax = new ModelRenderer(this,0,11);
        this.thorax.addBox(-1.0f,-1.0f,-1.0f,2,2,6);
        this.thorax.setRotationPoint(0.0f,22.0f,0.0f);
        this.thorax.rotateAngleX = (float)Math.PI/12;

        this.head = new ModelRenderer(this,16,11);
        this.thorax.addChild(head);
        this.head.addBox(-2.0f,-3.0f,-4.0f,4,3,4);
        this.head.setRotationPoint(0.0f,1.0f,0.0f);
        this.head.rotateAngleX = -(float)Math.PI/12;

        this.crest = new ModelRenderer(this,14,0);
        this.head.addChild(crest);
        this.crest.addBox(-2.0f,-3.0f,-1.0f,4,3,1);
        this.crest.setRotationPoint(0.0f,-3.0f,0.0f);
        this.crest.rotateAngleX = (float)Math.PI/6;

        this.mandible1 = new ModelRenderer(this,14,4);
        this.head.addChild(mandible1);
        this.mandible1.addBox(-2.0f,-0.5f,-3.0f,2,1,3);
        this.mandible1.setRotationPoint(0.0f,-0.5f,-4.0f);

        this.mandible2 = new ModelRenderer(this,14,4);
        this.head.addChild(mandible2);
        this.mandible2.mirror = true;
        this.mandible2.addBox(0.0f,-0.5f,-3.0f,2,1,3);
        this.mandible2.setRotationPoint(0.0f,-0.5f,-4.0f);

        this.thigh1 = new ModelRenderer(this,0,2);
        this.thorax.addChild(thigh1);
        this.thigh1.addBox(-1.0f,-4.0f,-0.5f,1,4,1);
        this.thigh1.setRotationPoint(-1.0f,0.0f,0.0f);
        this.thigh1.rotateAngleX = (float)Math.PI/12;
        this.thigh1.rotateAngleY = -(float)Math.PI/6;
        this.thigh1.rotateAngleZ = -(float)Math.PI/6;

        this.leg1 = new ModelRenderer(this,28,8);
        this.thigh1.addChild(leg1);
        this.leg1.addBox(-0.5f,-6.0f,-0.5f,1,6,1);
        this.leg1.setRotationPoint(-0.5f,-4.0f,0.0f);
        this.leg1.rotateAngleZ = -(float)(11*Math.PI)/18;

        this.thigh2 = new ModelRenderer(this,0,11);
        this.thorax.addChild(thigh2);
        this.thigh2.addBox(-1.0f,-5.0f,-0.5f,1,5,1);
        this.thigh2.setRotationPoint(-1.0f,0.5f,1.5f);
        this.thigh2.rotateAngleX = -(float)Math.PI/12;
        this.thigh2.rotateAngleZ = -(float)Math.PI/6;

        this.leg2 = new ModelRenderer(this,28,0);
        this.thigh2.addChild(leg2);
        this.leg2.addBox(-0.5f,-7.0f,-0.5f,1,7,1);
        this.leg2.setRotationPoint(-0.5f,-5.0f,0.0f);
        this.leg2.rotateAngleZ = -(float)(2*Math.PI)/3;

        this.thigh3 = new ModelRenderer(this,4,0);
        this.thorax.addChild(thigh3);
        this.thigh3.addBox(-1.0f,-6.0f,-0.5f,1,6,1);
        this.thigh3.setRotationPoint(-1.0f,1.0f,3.0f);
        this.thigh3.rotateAngleX = -(float)Math.PI/6;
        this.thigh3.rotateAngleY = (float)Math.PI/6;
        this.thigh3.rotateAngleZ = -(float)Math.PI/6;

        this.leg3 = new ModelRenderer(this,24,0);
        this.thigh3.addChild(leg3);
        this.leg3.addBox(-0.5f,-8.0f,-0.5f,1,8,1);
        this.leg3.setRotationPoint(-0.5f,-6.0f,0.0f);
        this.leg3.rotateAngleZ = -(float)(13*Math.PI)/18;

        this.thigh4 = new ModelRenderer(this,0,2);
        this.thorax.addChild(thigh4);
        this.thigh4.addBox(0.0f,-4.0f,-0.5f,1,4,1);
        this.thigh4.setRotationPoint(1.0f,0.0f,0.0f);
        this.thigh4.rotateAngleX = (float)Math.PI/12;
        this.thigh4.rotateAngleY = (float)Math.PI/6;
        this.thigh4.rotateAngleZ = (float)Math.PI/6;

        this.leg4 = new ModelRenderer(this, 28, 8);
        this.thigh4.addChild(leg4);
        this.leg4.addBox(-0.5f, -6.0f, -0.5f, 1, 6, 1);
        this.leg4.setRotationPoint(0.5f, -4.0f, 0.0f);
        this.leg4.rotateAngleZ = (float) (11 * Math.PI) / 18;

        this.thigh5 = new ModelRenderer(this,0,11);
        this.thorax.addChild(thigh5);
        this.thigh5.addBox(0.0f,-5.0f,-0.5f,1,5,1);
        this.thigh5.setRotationPoint(1.0f,0.5f,1.5f);
        this.thigh5.rotateAngleX = -(float)Math.PI/12;
        this.thigh5.rotateAngleZ = (float)Math.PI/6;

        this.leg5 = new ModelRenderer(this,28,0);
        this.thigh5.addChild(leg5);
        this.leg5.addBox(-0.5f,-7.0f,-0.5f,1,7,1);
        this.leg5.setRotationPoint(0.5f,-5.0f,0.0f);
        this.leg5.rotateAngleZ = (float)(2*Math.PI)/3;

        this.thigh6 = new ModelRenderer(this,4,0);
        this.thorax.addChild(thigh6);
        this.thigh6.addBox(0.0f,-6.0f,-0.5f,1,6,1);
        this.thigh6.setRotationPoint(1.0f,1.0f,3.0f);
        this.thigh6.rotateAngleX = -(float)Math.PI/6;
        this.thigh6.rotateAngleY = -(float)Math.PI/6;
        this.thigh6.rotateAngleZ = (float)Math.PI/6;

        this.leg6 = new ModelRenderer(this,24,0);
        this.thigh6.addChild(leg6);
        this.leg6.addBox(-0.5f,-8.0f,-0.5f,1,8,1);
        this.leg6.setRotationPoint(0.5f,-6.0f,0.0f);
        this.leg6.rotateAngleZ = (float)(13*Math.PI)/18;

        this.abdomen = new ModelRenderer(this,0,0);
        this.thorax.addChild(abdomen);
        this.abdomen.addBox(-1.5f,-1.5f,0.0f,3,3,8);
        this.abdomen.setRotationPoint(0.0f,0.0f,4.0f);
        this.abdomen.rotateAngleX = (float)Math.PI/12;

        this.juice = new ModelRenderer(this,6,19);
        this.abdomen.addChild(juice);
        this.juice.addBox(-2.5f,-2.5f,0.0f,5,5,8);
        this.juice.setRotationPoint(0.0f,0.0f,0.0f);

        this.stinger = new ModelRenderer(this,0,0);
        this.abdomen.addChild(stinger);
        this.stinger.addBox(-0.5f,-0.5f,0.0f,1,1,1);
        this.stinger.setRotationPoint(0.0f,0.0f,8.0f);
    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {

        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn);

        //Only renders the 'juice' model if the entity is "full"
        if(entityIn instanceof EntityAltaroth)
            this.juice.isHidden = !((EntityAltaroth) entityIn).isFull();

        this.thorax.render(scale);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);

        this.head.rotateAngleX = (p_78087_5_ / (180F / (float)Math.PI)) - (float)Math.PI/12;
        this.head.rotateAngleY = p_78087_4_ / (180F / (float)Math.PI);
        this.thigh1.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_) - (float)Math.PI/6;
        this.thigh2.rotateAngleY = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.thigh3.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_) + (float)Math.PI/6;
        this.thigh4.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_) + (float)Math.PI/6;
        this.thigh5.rotateAngleY = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.thigh6.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_) - (float)Math.PI/6;
        this.abdomen.rotateAngleX = Math.abs(MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/2;
    }
}
