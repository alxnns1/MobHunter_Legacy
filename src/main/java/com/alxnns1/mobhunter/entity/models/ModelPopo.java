package com.alxnns1.mobhunter.entity.models;

import com.alxnns1.mobhunter.entity.EntityPopo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Matrix4f;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.util.vector.Quaternion;

/**
 * Created by Alex on 24/04/2016.
 */

@SideOnly(Side.CLIENT)
public class ModelPopo extends ModelBase {

    ModelRenderer head;
    ModelRenderer t1;
    ModelRenderer t2;
    ModelRenderer t3;
    ModelRenderer t4;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;

    public ModelPopo(){
        this.textureHeight = 64;
        this.textureWidth = 64;

        this.body = new ModelRenderer(this,0,16);
        this.body.addBox(-6.0f,-8.0f,-16.0f,12,12,16);
        this.body.setRotationPoint(0.0f,11.0f,8.0f);

        this.head = new ModelRenderer(this,0,0);
        this.body.addChild(head);
        this.head.addBox(-4.0f,-4.0f,-8.0f,8,8,8);
        this.head.setRotationPoint(0.0f,-2.0f,-16.0f);

        this.t1 = new ModelRenderer(this,24,0);
        this.head.addChild(t1);
        this.t1.addBox(-1.0f,2.0f,-5.0f,2,2,6);
        this.t1.setRotationPoint(-4.0f,0.0f,-8.0f);
        this.t1.rotateAngleY = 0.5f;

        this.t2 = new ModelRenderer(this,24,0);
        this.head.addChild(t2);
        this.t2.mirror = true;
        this.t2.addBox(-1.0f,2.0f,-5.0f,2,2,6);
        this.t2.setRotationPoint(4.0f,0.0f,-8.0f);
        this.t2.rotateAngleY = -0.5f;

        this.t3 = new ModelRenderer(this,0,0);
        this.t1.addChild(t3);
        this.t3.addBox(-1.0f,-1.0f,-5.0f,2,4,2);

        this.t4 = new ModelRenderer(this,0,0);
        this.t2.addChild(t4);
        this.t4.mirror = true;
        this.t4.addBox(-1.0f,-1.0f,-5.0f,2,4,2);

        this.leg1 = new ModelRenderer(this,0,16);
        this.body.addChild(leg1);
        this.leg1.addBox(-2.0f,0.0f,-2.0f,4,12,4);
        this.leg1.setRotationPoint(-4.0f,1.0f,-14.0f);

        this.leg2 = new ModelRenderer(this,0,16);
        this.leg2.mirror = true;
        this.body.addChild(leg2);
        this.leg2.addBox(-2.0f,0.0f,-2.0f,4,12,4);
        this.leg2.setRotationPoint(4.0f,1.0f,-14.0f);

        this.leg3 = new ModelRenderer(this,0,16);
        this.body.addChild(leg3);
        this.leg3.addBox(-2.0f,0.0f,-2.0f,4,12,4);
        this.leg3.setRotationPoint(-4.0f,1.0f,-2.0f);

        this.leg4 = new ModelRenderer(this,0,16);
        this.leg4.mirror = true;
        this.body.addChild(leg4);
        this.leg4.addBox(-2.0f,0.0f,-2.0f,4,12,4);
        this.leg4.setRotationPoint(4.0f,1.0f,-2.0f);
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
        this.head.rotateAngleX = p_78087_5_ / f;
        this.head.rotateAngleY = p_78087_4_ / f;
        this.leg1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.leg2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.leg3.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.leg4.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
    }
}
