package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 01/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelJaggi extends ModelBase {

    ModelRenderer neck1;
    ModelRenderer neck2;
    ModelRenderer head;
    ModelRenderer snout;
    ModelRenderer jaw;
    ModelRenderer frill1;
    ModelRenderer frill2;
    ModelRenderer arm1;
    ModelRenderer arm2;
    ModelRenderer arm3;
    ModelRenderer arm4;
    ModelRenderer hand1;
    ModelRenderer hand2;
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer foot1;
    ModelRenderer foot2;
    ModelRenderer tail1;
    ModelRenderer tail2;
    ModelRenderer tail3;

    public ModelJaggi() {
        this.textureHeight = 64;
        this.textureWidth = 64;

        this.body = new ModelRenderer(this,0,0);
        this.body.addBox(-4.0f,-4.0f,-6.5f,8,7,10);
        this.body.setRotationPoint(0.0f,12.0f,0.0f);

        this.leg1 = new ModelRenderer(this,36,0);
        this.body.addChild(leg1);
        this.leg1.mirror = true;
        this.leg1.addBox(0.0f,-2.0f,-2.5f,3,6,5);
        this.leg1.setRotationPoint(4.0f,0.0f,0.0f);

        this.leg2 = new ModelRenderer(this,36,0);
        this.body.addChild(leg2);
        this.leg2.addBox(-3.0f,-2.0f,-2.5f,3,6,5);
        this.leg2.setRotationPoint(-4.0f,0.0f,0.0f);

        this.leg3 = new ModelRenderer(this,52,0);
        this.leg1.addChild(leg3);
        this.leg3.mirror = true;
        this.leg3.addBox(-1.0f,-2.0f,-1.0f,2,10,2);
        this.leg3.setRotationPoint(1.5f,4.0f,1.5f);
        this.leg3.rotateAngleX = (float) -Math.PI/12;

        this.leg4 = new ModelRenderer(this,52,0);
        this.leg2.addChild(leg4);
        this.leg4.addBox(-1.0f,-2.0f,-1.0f,2,10,2);
        this.leg4.setRotationPoint(-1.5f,4.0f,1.5f);
        this.leg4.rotateAngleX = (float) -Math.PI/12;

        this.foot1 = new ModelRenderer(this,20,17);
        this.leg3.addChild(foot1);
        this.foot1.mirror = true;
        this.foot1.addBox(-1.5f,0.0f,0.0f,3,2,4);
        this.foot1.setRotationPoint(0.0f,7.0f,-4.0f);
        this.foot1.rotateAngleX = (float) Math.PI/12;

        this.foot2 = new ModelRenderer(this,20,17);
        this.leg4.addChild(foot2);
        this.foot2.addBox(-1.5f,0.0f,0.0f,3,2,4);
        this.foot2.setRotationPoint(0.0f,7.0f,-4.0f);
        this.foot2.rotateAngleX = (float) Math.PI/12;

        this.tail1 = new ModelRenderer(this,0,17);
        this.body.addChild(tail1);
        this.tail1.addBox(-3.0f,-2.5f,-1.0f,6,5,8);
        this.tail1.setRotationPoint(0.0f,-1.5f,3.5f);
        this.tail1.rotateAngleX = (float) -Math.PI/18;

        this.tail2 = new ModelRenderer(this,0,30);
        this.tail1.addChild(tail2);
        this.tail2.addBox(-2.0f,-2.0f,-1.0f,4,4,8);
        this.tail2.setRotationPoint(0.0f,0.0f,8.0f);
        this.tail2.rotateAngleX = (float) Math.PI/36;

        this.tail3 = new ModelRenderer(this,0,42);
        this.tail2.addChild(tail3);
        this.tail3.addBox(-1.0f,-1.0f,-1.0f,2,2,8);
        this.tail3.setRotationPoint(0.0f,0.0f,8.0f);
        this.tail3.rotateAngleX = (float) Math.PI/36;

        this.neck1 = new ModelRenderer(this,34,12);
        this.body.addChild(neck1);
        this.neck1.addBox(-3.0f,-3.0f,-7.0f,6,6,8);
        this.neck1.setRotationPoint(0.0f,-1.0f,-6.5f);
        this.neck1.rotateAngleX = (float) -Math.PI/6;

        this.neck2 = new ModelRenderer(this,43,26);
        this.neck1.addChild(neck2);
        this.neck2.addBox(-2.0f,-6.0f,-2.0f,4,7,4);
        this.neck2.setRotationPoint(0.0f,0.0f,-7.0f);
        this.neck2.rotateAngleX = (float) Math.PI/3;

        this.head = new ModelRenderer(this,17,37);
        this.neck2.addChild(head);
        this.head.addBox(-3.0f,-1.0f,-2.0f,6,6,7);
        this.head.setRotationPoint(0.0f,-7.0f,0.0f);
        this.head.rotateAngleX = (float) -Math.PI/6;

        this.snout = new ModelRenderer(this,21,26);
        this.head.addChild(snout);
        this.snout.addBox(-2.0f,-1.0f,-9.0f,4,4,7);
        this.snout.setRotationPoint(0.0f,0.0f,0.0f);

        this.jaw = new ModelRenderer(this,0,52);
        this.head.addChild(jaw);
        this.jaw.addBox(-1.5f,-2.0f,0.0f,3,2,7);
        this.jaw.setRotationPoint(0.0f,5.0f,-8.5f);

        this.frill1 = new ModelRenderer(this,43,30);
        this.head.addChild(frill1);
        this.frill1.mirror = true;
        this.frill1.addBox(0.0f,0.0f,0.0f,0,11,7);
        this.frill1.setRotationPoint(-3.0f,-3.5f,-2.0f);
        this.frill1.rotateAngleY = (float) -Math.PI/12;

        this.frill2 = new ModelRenderer(this,43,30);
        this.head.addChild(frill2);
        this.frill2.addBox(0.0f,0.0f,0.0f,0,11,7);
        this.frill2.setRotationPoint(3.0f,-3.5f,-2.0f);
        this.frill2.rotateAngleY = (float) Math.PI/12;

        this.arm1 = new ModelRenderer(this,0,0);
        this.neck1.addChild(arm1);
        this.arm1.addBox(-2.0f,-1.0f,-1.5f,2,5,3);
        this.arm1.setRotationPoint(-3.0f,2.0f,-2.0f);

        this.arm2 = new ModelRenderer(this,0,0);
        this.neck1.addChild(arm2);
        this.arm2.mirror = true;
        this.arm2.addBox(0.0f,-1.0f,-1.5f,2,5,3);
        this.arm2.setRotationPoint(3.0f,2.0f,-2.0f);

        this.arm3 = new ModelRenderer(this,26,0);
        this.arm1.addChild(arm3);
        this.arm3.addBox(-1.0f,0.0f,-1.0f,2,5,2);
        this.arm3.setRotationPoint(-1.0f,3.0f,0.0f);
        this.arm3.rotateAngleX = (float) -Math.PI/6;

        this.arm4 = new ModelRenderer(this,26,0);
        this.arm2.addChild(arm4);
        this.arm4.mirror = true;
        this.arm4.addBox(-1.0f,0.0f,-1.0f,2,5,2);
        this.arm4.setRotationPoint(1.0f,3.0f,0.0f);
        this.arm4.rotateAngleX = (float) -Math.PI/6;

        this.hand1 = new ModelRenderer(this,34,0);
        this.arm3.addChild(hand1);
        this.hand1.mirror = true;
        this.hand1.addBox(-1.0f,0.0f,0.0f,2,2,1);
        this.hand1.setRotationPoint(0.0f,5.0f,-1.0f);
        this.hand1.rotateAngleX = (float) Math.PI/6;

        this.hand2 = new ModelRenderer(this,34,0);
        this.arm4.addChild(hand2);
        this.hand2.addBox(-1.0f,0.0f,0.0f,2,2,1);
        this.hand2.setRotationPoint(0.0f,5.0f,-1.0f);
        this.hand2.rotateAngleX = (float) Math.PI/6;
    }

    public void render(Entity entityIn, float p_78088_2_, float p_78088_3_, float p_78088_4_, float p_78088_5_, float p_78088_6_, float scale) {

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
        this.leg1.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_;
        this.leg2.rotateAngleX = MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_;
        this.tail1.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F) * 1.4F * p_78087_2_)/3;
        this.tail2.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
        this.tail3.rotateAngleY = (MathHelper.cos(p_78087_1_ * 0.6662F + (float)Math.PI) * 1.4F * p_78087_2_)/6;
    }
}
