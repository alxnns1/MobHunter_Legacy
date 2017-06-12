package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 24/04/2016.
 */

@SideOnly(Side.CLIENT)
public class ModelPopo extends ModelBase {

    ModelRenderer head;
    ModelRenderer tr1;
    ModelRenderer tr2;
    ModelRenderer tr3;
    ModelRenderer tl1;
    ModelRenderer tl2;
    ModelRenderer tl3;
    ModelRenderer body;
    ModelRenderer hind1;
    ModelRenderer hind2;
    ModelRenderer legr1;
    ModelRenderer legr2;
    ModelRenderer legl1;
    ModelRenderer legl2;
    ModelRenderer footr1;
    ModelRenderer footr2;
    ModelRenderer footl1;
    ModelRenderer footl2;
    ModelRenderer hump;
    ModelRenderer tail;

    public ModelPopo(){
        this.textureHeight = 256;
        this.textureWidth = 128;

        this.body = new ModelRenderer(this,0,0);
        this.body.addBox(-16.0f,-28.0f,-34.0f,32,28,24);
        this.body.setRotationPoint(0.0f,8.0f,14.0f);

        this.hump = new ModelRenderer(this,0,80);
        this.body.addChild(hump);
        this.hump.addBox(-12.0f,-4.0f,-8.0f,24,4,16);
        this.hump.setRotationPoint(0.0f,-28.0f,-22.0f);

        this.hind1 = new ModelRenderer(this,0,100);
        this.body.addChild(hind1);
        this.hind1.addBox(-14.0f,-12.0f,0.0f,28,24,8);
        this.hind1.setRotationPoint(0.0f,-12.0f,-10.0f);

        this.hind2 = new ModelRenderer(this,56,52);
        this.hind1.addChild(hind2);
        this.hind2.addBox(-12.0f,-10.0f,0.0f,24,20,8);
        this.hind2.setRotationPoint(0.0f,2.0f,8.0f);

        this.tail = new ModelRenderer(this,64,80);
        this.hind2.addChild(tail);
        this.tail.addBox(-4.0f,0.0f,0.0f,8,2,8);
        this.tail.setRotationPoint(0.0f,-10.0f,8.0f);
        this.tail.rotateAngleX = -(float)Math.PI/3;

        this.head = new ModelRenderer(this,0,52);
        this.body.addChild(head);
        this.head.addBox(-8.0f,-8.0f,-12.0f,16,16,12);
        this.head.setRotationPoint(0.0f,-8.0f,-34.0f);

        this.tr1 = new ModelRenderer(this,72,108);
        this.head.addChild(tr1);
        this.tr1.addBox(-2.0f,-1.0f,-10.0f,4,2,12);
        this.tr1.setRotationPoint(-8.0f,7.0f,-10.0f);
        this.tr1.rotateAngleY = (float)Math.PI/12;

        this.tr2 = new ModelRenderer(this,96,80);
        this.tr1.addChild(tr2);
        this.tr2.addBox(-3.0f,-2.0f,-8.0f,6,2,8);
        this.tr2.setRotationPoint(0.0f,1.0f,-10.0f);
        this.tr2.rotateAngleX = -(float)Math.PI/4;

        this.tr3 = new ModelRenderer(this,92,108);
        this.tr2.addChild(tr3);
        this.tr3.addBox(-4.0f,-2.0f,-8.0f,8,2,8);
        this.tr3.setRotationPoint(0.0f,0.0f,-8.0f);
        this.tr3.rotateAngleX = -(float)Math.PI/4;

        this.tl1 = new ModelRenderer(this,72,108);
        this.head.addChild(tl1);
        this.tl1.addBox(-2.0f,-1.0f,-10.0f,4,2,12);
        this.tl1.setRotationPoint(8.0f,7.0f,-10.0f);
        this.tl1.rotateAngleY = -(float)Math.PI/12;

        this.tl2 = new ModelRenderer(this,96,80);
        this.tl1.addChild(tl2);
        this.tl2.addBox(-3.0f,-2.0f,-8.0f,6,2,8);
        this.tl2.setRotationPoint(0.0f,1.0f,-10.0f);
        this.tl2.rotateAngleX = -(float)Math.PI/4;

        this.tl3 = new ModelRenderer(this,92,108);
        this.tl2.addChild(tl3);
        this.tl3.addBox(-4.0f,-2.0f,-8.0f,8,2,8);
        this.tl3.setRotationPoint(0.0f,0.0f,-8.0f);
        this.tl3.rotateAngleX = -(float)Math.PI/4;

        this.legr1 = new ModelRenderer(this,88,0);
        this.body.addChild(legr1);
        this.legr1.addBox(-4.0f,0.0f,-4.0f,8,10,8);
        this.legr1.setRotationPoint(10.0f,0.0f,-28.0f);

        this.legl1 = new ModelRenderer(this,88,0);
        this.body.addChild(legl1);
        this.legl1.addBox(-4.0f,0.0f,-4.0f,8,10,8);
        this.legl1.setRotationPoint(-10.0f,0.0f,-28.0f);

        this.legr2 = new ModelRenderer(this,88,0);
        this.body.addChild(legr2);
        this.legr2.addBox(-4.0f,0.0f,-4.0f,8,10,8);
        this.legr2.setRotationPoint(8.0f,0.0f,0.0f);

        this.legl2 = new ModelRenderer(this,88,0);
        this.body.addChild(legl2);
        this.legl2.addBox(-4.0f,0.0f,-4.0f,8,10,8);
        this.legl2.setRotationPoint(-8.0f,0.0f,0.0f);

        this.footr1 = new ModelRenderer(this,68,90);
        this.legr1.addChild(footr1);
        this.footr1.addBox(-6.0f,0.0f,-6.0f,12,6,12);
        this.footr1.setRotationPoint(0.0f,10.0f,0.0f);

        this.footr2 = new ModelRenderer(this,68,90);
        this.legr2.addChild(footr2);
        this.footr2.addBox(-6.0f,0.0f,-6.0f,12,6,12);
        this.footr2.setRotationPoint(0.0f,10.0f,0.0f);

        this.footl1 = new ModelRenderer(this,68,90);
        this.legl1.addChild(footl1);
        this.footl1.addBox(-6.0f,0.0f,-6.0f,12,6,12);
        this.footl1.setRotationPoint(0.0f,10.0f,0.0f);

        this.footl2 = new ModelRenderer(this,68,90);
        this.legl2.addChild(footl2);
        this.footl2.addBox(-6.0f,0.0f,-6.0f,12,6,12);
        this.footl2.setRotationPoint(0.0f,10.0f,0.0f);

    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {

        this.setRotationAngles(p_78088_2_, p_78088_3_, p_78088_4_, p_78088_5_, p_78088_6_, scale, entityIn);
        this.body.render(scale);
    }

    public void setRotationAngles(float p_78087_1_, float p_78087_2_, float p_78087_3_, float p_78087_4_, float p_78087_5_, float p_78087_6_, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);

        this.head.rotateAngleX = p_78087_5_ / f;
        this.head.rotateAngleY = p_78087_4_ / f;
        this.legr1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.legl1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.legr2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.legl2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.tail.rotateAngleX = (Math.abs(MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/2) - (float)Math.PI/3;

    }
}
