package com.alxnns1.mobhunter.entity.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 26/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelAptonoth extends ModelBase {

    ModelRenderer body;
    ModelRenderer ridge4;
    ModelRenderer tail1;
    ModelRenderer ridge5;
    ModelRenderer tail2;
    ModelRenderer ridge6;
    ModelRenderer tail3;
    ModelRenderer ridge7;
    ModelRenderer tail4;
    ModelRenderer ridge8;
    ModelRenderer tail5;
    ModelRenderer tspiker1;
    ModelRenderer tspiker2;
    ModelRenderer tspiker3;
    ModelRenderer tspikel1;
    ModelRenderer tspikel2;
    ModelRenderer tspikel3;
    ModelRenderer neck1;
    ModelRenderer ridge3;
    ModelRenderer neck2;
    ModelRenderer ridge2;
    ModelRenderer neck3;
    ModelRenderer ridge1;
    ModelRenderer head1;
    ModelRenderer hspiker1;
    ModelRenderer hspiker2;
    ModelRenderer hspikel1;
    ModelRenderer hspikel2;
    ModelRenderer crest;
    ModelRenderer crestr;
    ModelRenderer cspiker1;
    ModelRenderer cspiker2;
    ModelRenderer crestl;
    ModelRenderer cspikel1;
    ModelRenderer cspikel2;
    ModelRenderer head2;
    ModelRenderer snout;
    ModelRenderer mouth;
    ModelRenderer thighr1;
    ModelRenderer thighr2;
    ModelRenderer thighl1;
    ModelRenderer thighl2;
    ModelRenderer legr1;
    ModelRenderer legr2;
    ModelRenderer legl1;
    ModelRenderer legl2;

    public ModelAptonoth() {
        this.textureHeight = 256;
        this.textureWidth = 256;

        this.body = new ModelRenderer(this,0,0);
        this.body.addBox(-12.0f,-28.0f,-39.0f,24,28,48);
        this.body.setRotationPoint(0.0f,4.0f,15.0f);

        this.ridge4 = new ModelRenderer(this,0,76);
        this.body.addChild(ridge4);
        this.ridge4.addBox(-2.0f,-8.0f,-48.0f,4,8,48);
        this.ridge4.setRotationPoint(0.0f,-28.0f,9.0f);

        this.tail1 = new ModelRenderer(this,96,0);
        this.body.addChild(tail1);
        this.tail1.addBox(-10.0f,0.0f,0.0f,20,24,16);
        this.tail1.setRotationPoint(0.0f,-28.0f,9.0f);
        this.tail1.rotateAngleX = -(float)Math.PI/12;

        this.ridge5 = new ModelRenderer(this,0,76);
        this.tail1.addChild(ridge5);
        this.ridge5.addBox(-2.0f,-8.0f,-16.0f,4,8,16);
        this.ridge5.setRotationPoint(0.0f,0.0f,16.0f);

        this.tail2 = new ModelRenderer(this,168,0);
        this.tail1.addChild(tail2);
        this.tail2.addBox(-8.0f,-9.0f,0.0f,16,18,16);
        this.tail2.setRotationPoint(0.0f,11.0f,14.0f);

        this.ridge6 = new ModelRenderer(this,128,68);
        this.tail2.addChild(ridge6);
        this.ridge6.addBox(-2.0f,-6.0f,-16.0f,4,6,16);
        this.ridge6.setRotationPoint(0.0f,-9.0f,16.0f);

        this.tail3 = new ModelRenderer(this,168,68);
        this.tail2.addChild(tail3);
        this.tail3.addBox(-6.0f,-6.0f,-2.0f,12,12,16);
        this.tail3.setRotationPoint(0.0f,-1.0f,16.0f);

        this.ridge7 = new ModelRenderer(this,0,100);
        this.tail3.addChild(ridge7);
        this.ridge7.addBox(-2.0f,-4.0f,-16.0f,4,4,16);
        this.ridge7.setRotationPoint(0.0f,-6.0f,14.0f);

        this.tail4 = new ModelRenderer(this,128,90);
        this.tail3.addChild(tail4);
        this.tail4.addBox(-4.0f,-3.0f,0.0f,8,6,8);
        this.tail4.setRotationPoint(0.0f,-1.0f,12.0f);

        this.ridge8 = new ModelRenderer(this,24,28);
        this.tail4.addChild(ridge8);
        this.ridge8.addBox(-2.0f,-2.0f,-8.0f,4,2,8);
        this.ridge8.setRotationPoint(0.0f,-3.0f,8.0f);

        this.tail5 = new ModelRenderer(this,148,96);
        this.tail4.addChild(tail5);
        this.tail5.addBox(-6.0f,-2.0f,0.0f,12,4,12);
        this.tail5.setRotationPoint(0.0f,0.0f,6.0f);
        this.tail5.rotateAngleX = (float)Math.PI/12;

        this.tspiker1 = new ModelRenderer(this,152,0);
        this.tail5.addChild(tspiker1);
        this.tspiker1.addBox(-2.0f,0.0f,0.0f,4,4,8);
        this.tspiker1.setRotationPoint(-6.0f,-2.0f,2.0f);
        this.tspiker1.rotateAngleX = -(float)Math.PI/6;
        this.tspiker1.rotateAngleY = -(float)Math.PI/2;

        this.tspiker2 = new ModelRenderer(this,152,0);
        this.tail5.addChild(tspiker2);
        this.tspiker2.addBox(-2.0f,-4.0f,0.0f,4,4,8);
        this.tspiker2.setRotationPoint(-6.0f,2.0f,7.0f);
        this.tspiker2.rotateAngleX = (float)Math.PI/6;
        this.tspiker2.rotateAngleY = -(float)Math.PI/2;

        this.tspiker3 = new ModelRenderer(this,152,0);
        this.tail5.addChild(tspiker3);
        this.tspiker3.addBox(-2.0f,-4.0f,0.0f,4,4,8);
        this.tspiker3.setRotationPoint(-4.0f,2.0f,12.0f);
        this.tspiker3.rotateAngleX = (float)Math.PI/12;

        this.tspikel1 = new ModelRenderer(this,152,0);
        this.tail5.addChild(tspikel1);
        this.tspikel1.addBox(-2.0f,0.0f,0.0f,4,4,8);
        this.tspikel1.setRotationPoint(6.0f,-2.0f,2.0f);
        this.tspikel1.rotateAngleX = -(float)Math.PI/6;
        this.tspikel1.rotateAngleY = (float)Math.PI/2;

        this.tspikel2 = new ModelRenderer(this,152,0);
        this.tail5.addChild(tspikel2);
        this.tspikel2.addBox(-2.0f,-4.0f,0.0f,4,4,8);
        this.tspikel2.setRotationPoint(6.0f,2.0f,7.0f);
        this.tspikel2.rotateAngleX = (float)Math.PI/6;
        this.tspikel2.rotateAngleY = (float)Math.PI/2;

        this.tspikel3 = new ModelRenderer(this,152,0);
        this.tail5.addChild(tspikel3);
        this.tspikel3.addBox(-2.0f,-4.0f,0.0f,4,4,8);
        this.tspikel3.setRotationPoint(4.0f,2.0f,12.0f);
        this.tspikel3.rotateAngleX = (float)Math.PI/12;

        this.neck1 = new ModelRenderer(this,56,76);
        this.body.addChild(neck1);
        this.neck1.addBox(-10.0f,-12.0f,-12.0f,20,24,16);
        this.neck1.setRotationPoint(0.0f,-16.0f,-39.0f);
        this.neck1.rotateAngleX = -(float)Math.PI/12;

        this.ridge3 = new ModelRenderer(this,0,28);
        this.neck1.addChild(ridge3);
        this.ridge3.addBox(-2.0f,-6.0f,-12.0f,4,6,12);
        this.ridge3.setRotationPoint(0.0f,-12.0f,0.0f);

        this.neck2 = new ModelRenderer(this,176,34);
        this.neck1.addChild(neck2);
        this.neck2.addBox(-8.0f,-9.0f,-16.0f,16,18,16);
        this.neck2.setRotationPoint(0.0f,0.0f,-8.0f);
        this.neck2.rotateAngleX = -(float)Math.PI/12;

        this.ridge2 = new ModelRenderer(this,180,96);
        this.neck2.addChild(ridge2);
        this.ridge2.addBox(-2.0f,-4.0f,-16.0f,4,4,16);
        this.ridge2.setRotationPoint(0.0f,-9.0f,0.0f);

        this.neck3 = new ModelRenderer(this,112,112);
        this.neck2.addChild(neck3);
        this.neck3.addBox(-6.0f,-6.0f,-16.0f,12,12,16);
        this.neck3.setRotationPoint(0.0f,0.0f,-12.0f);
        this.neck3.rotateAngleX = -(float)Math.PI/12;

        this.ridge1 = new ModelRenderer(this,208,80);
        this.neck3.addChild(ridge1);
        this.ridge1.addBox(-2.0f,-2.0f,-16.0f,4,2,16);
        this.ridge1.setRotationPoint(0.0f,-6.0f,0.0f);

        this.head1 = new ModelRenderer(this,0,132);
        this.neck3.addChild(head1);
        this.head1.addBox(-7.0f,-8.0f,-8.0f,14,16,16);
        this.head1.setRotationPoint(0.0f,0.0f,-16.0f);
        this.head1.rotateAngleX = (float)Math.PI/4;

        this.hspiker1 = new ModelRenderer(this,216,0);
        this.head1.addChild(hspiker1);
        this.hspiker1.mirror = true;
        this.hspiker1.addBox(-4.0f,-2.0f,-2.0f,4,4,4);
        this.hspiker1.setRotationPoint(-7.0f,-5.0f,-1.0f);

        this.hspiker2 = new ModelRenderer(this,216,0);
        this.head1.addChild(hspiker2);
        this.hspiker2.mirror = true;
        this.hspiker2.addBox(-4.0f,-2.0f,-2.0f,4,4,4);
        this.hspiker2.setRotationPoint(-7.0f,0.0f,-5.0f);

        this.hspikel1 = new ModelRenderer(this,216,0);
        this.head1.addChild(hspikel1);
        this.hspikel1.addBox(0.0f,-2.0f,-2.0f,4,4,4);
        this.hspikel1.setRotationPoint(7.0f,-5.0f,-1.0f);

        this.hspikel2 = new ModelRenderer(this,216,0);
        this.head1.addChild(hspikel2);
        this.hspikel2.addBox(0.0f,-2.0f,-2.0f,4,4,4);
        this.hspikel2.setRotationPoint(7.0f,0.0f,-5.0f);

        this.crest = new ModelRenderer(this,60,132);
        this.head1.addChild(crest);
        this.crest.addBox(-4.0f,-2.0f,0.0f,8,4,16);
        this.crest.setRotationPoint(0.0f,-6.0f,8.0f);

        this.crestr = new ModelRenderer(this,0,186);
        this.crest.addChild(crestr);
        this.crestr.mirror = true;
        this.crestr.addBox(-8.0f,-2.0f,0.0f,8,4,12);
        this.crestr.setRotationPoint(-1.0f,0.0f,12.0f);

        this.cspiker1 = new ModelRenderer(this,216,0);
        this.crestr.addChild(cspiker1);
        this.cspiker1.mirror = true;
        this.cspiker1.addBox(-4.0f,-2.0f,-2.0f,4,4,4);
        this.cspiker1.setRotationPoint(-8.0f,0.0f,2.0f);

        this.cspiker2 = new ModelRenderer(this,216,0);
        this.crestr.addChild(cspiker2);
        this.cspiker2.mirror = true;
        this.cspiker2.addBox(-4.0f,-2.0f,-2.0f,4,4,4);
        this.cspiker2.setRotationPoint(-4.0f,0.0f,12.0f);
        this.cspiker2.rotateAngleY = (float)Math.PI/2;

        this.crestl = new ModelRenderer(this,0,186);
        this.crest.addChild(crestl);
        this.crestl.addBox(0.0f,-2.0f,0.0f,8,4,12);
        this.crestl.setRotationPoint(1.0f,0.0f,12.0f);

        this.cspikel1 = new ModelRenderer(this,216,0);
        this.crestl.addChild(cspikel1);
        this.cspikel1.addBox(0.0f,-2.0f,-2.0f,4,4,4);
        this.cspikel1.setRotationPoint(8.0f,0.0f,2.0f);

        this.cspikel2 = new ModelRenderer(this,216,0);
        this.crestr.addChild(cspikel2);
        this.cspikel2.addBox(0.0f,-2.0f,-2.0f,4,4,4);
        this.cspikel2.setRotationPoint(6.0f,0.0f,12.0f);
        this.cspikel2.rotateAngleY = -(float)Math.PI/2;

        this.head2 = new ModelRenderer(this,0,164);
        this.head1.addChild(head2);
        this.head2.addBox(-5.0f,-7.0f,-8.0f,10,14,8);
        this.head2.setRotationPoint(0.0f,0.0f,-8.f);

        this.snout = new ModelRenderer(this,36,164);
        this.head2.addChild(snout);
        this.snout.addBox(-5.0f,-8.0f,-8.0f,10,8,8);
        this.snout.setRotationPoint(0.0f,3.0f,-8.f);

        this.mouth = new ModelRenderer(this,60,152);
        this.head2.addChild(mouth);
        this.mouth.addBox(-5.0f,0.0f,-8.0f,10,4,8);
        this.mouth.setRotationPoint(0.0f,3.0f,-8.f);

        this.thighr1 = new ModelRenderer(this,0,0);
        this.body.addChild(thighr1);
        this.thighr1.addBox(-4.0f,-6.0f,-5.0f,12,18,10);
        this.thighr1.setRotationPoint(-12.0f,-10.0f,-30.0f);

        this.legr1 = new ModelRenderer(this,144,40);
        this.thighr1.addChild(legr1);
        this.legr1.addBox(-4.0f,-2.0f,-4.0f,8,20,8);
        this.legr1.setRotationPoint(2.0f,12.0f,0.0f);

        this.thighr2 = new ModelRenderer(this,0,0);
        this.body.addChild(thighr2);
        this.thighr2.addBox(-4.0f,-6.0f,-5.0f,12,18,10);
        this.thighr2.setRotationPoint(-12.0f,-10.0f,0.0f);

        this.legr2 = new ModelRenderer(this,144,40);
        this.thighr2.addChild(legr2);
        this.legr2.addBox(-4.0f,-2.0f,-4.0f,8,20,8);
        this.legr2.setRotationPoint(2.0f,12.0f,0.0f);

        this.thighl1 = new ModelRenderer(this,0,0);
        this.body.addChild(thighl1);
        this.thighl1.addBox(-8.0f,-6.0f,-5.0f,12,18,10);
        this.thighl1.setRotationPoint(12.0f,-10.0f,-30.0f);

        this.legl1 = new ModelRenderer(this,144,40);
        this.thighl1.addChild(legl1);
        this.legl1.addBox(-4.0f,-2.0f,-4.0f,8,20,8);
        this.legl1.setRotationPoint(-2.0f,12.0f,0.0f);

        this.thighl2 = new ModelRenderer(this,0,0);
        this.body.addChild(thighl2);
        this.thighl2.addBox(-8.0f,-6.0f,-5.0f,12,18,10);
        this.thighl2.setRotationPoint(12.0f,-10.0f,0.0f);

        this.legl2 = new ModelRenderer(this,144,40);
        this.thighl2.addChild(legl2);
        this.legl2.addBox(-4.0f,-2.0f,-4.0f,8,20,8);
        this.legl2.setRotationPoint(-2.0f,12.0f,0.0f);

    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {

        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn);
        this.body.render(scale);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);

        this.head1.rotateAngleX = (p_78087_5_ / (180F / (float)Math.PI)) + (float)Math.PI/4;
        this.head1.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/4;
        this.neck1.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/4;
        this.neck2.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/4;
        this.neck3.rotateAngleY = (p_78087_4_ / (180F / (float)Math.PI))/4;
        this.thighr1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.thighl1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.thighr2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.thighl2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.tail1.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/3;
        this.tail2.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
        this.tail3.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
        this.tail4.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
        this.tail5.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;

    }
}
