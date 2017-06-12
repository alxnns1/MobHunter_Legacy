package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 26/05/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelApceros extends ModelBase {

    ModelRenderer body;
    ModelRenderer plater1;
    ModelRenderer plater2;
    ModelRenderer plater3;
    ModelRenderer plater4;
    ModelRenderer plater5;
    ModelRenderer platel1;
    ModelRenderer platel2;
    ModelRenderer platel3;
    ModelRenderer platel4;
    ModelRenderer platel5;

    ModelRenderer thighr1;
    ModelRenderer thighr2;
    ModelRenderer thighl1;
    ModelRenderer thighl2;
    ModelRenderer legr1;
    ModelRenderer legr2;
    ModelRenderer legl1;
    ModelRenderer legl2;
    ModelRenderer footr1;
    ModelRenderer footr2;
    ModelRenderer footl1;
    ModelRenderer footl2;

    ModelRenderer neck1;
    ModelRenderer neckridge;
    ModelRenderer neck2;
    ModelRenderer neck3;
    ModelRenderer head;
    ModelRenderer hspiker;
    ModelRenderer hspikel;
    ModelRenderer snout;
    ModelRenderer mouth;

    ModelRenderer tail1;
    ModelRenderer tailridge;
    ModelRenderer tail2;
    ModelRenderer tail3;
    ModelRenderer club1;
    ModelRenderer club2;
    ModelRenderer tspike1;
    ModelRenderer tspiker1;
    ModelRenderer tspiker2;
    ModelRenderer tspiker3;
    ModelRenderer tspiker4;
    ModelRenderer tspikel1;
    ModelRenderer tspikel2;
    ModelRenderer tspikel3;
    ModelRenderer tspikel4;

    public ModelApceros() {
        this.textureHeight = 128;
        this.textureWidth = 256;

        //body
        this.body = new ModelRenderer(this,0,0);
        this.body.addBox(-12.0f,-6.0f,-16.0f,24,12,32);
        this.body.setRotationPoint(0.0f,6.0f,0.0f);

        this.plater1 = new ModelRenderer(this, 190, 20);
        this.plater1.mirror = true;
        this.body.addChild(plater1);
        this.plater1.addBox(-8.0f,-2.0f,-24.0f,9,4,24);
        this.plater1.setRotationPoint(0.0f,-14.0f,0.0f);
        this.plater1.rotateAngleX = (float)(Math.PI/180)*15;
        this.plater1.rotateAngleY = (float)(Math.PI/180)*3;
        this.plater1.rotateAngleZ = (float)(Math.PI/180)*-15;

        this.plater2 = new ModelRenderer(this, 188, 48);
        this.plater2.mirror = true;
        this.plater1.addChild(plater2);
        this.plater2.addBox(-8.0f,-2.0f,0.0f,9,4,25);
        this.plater2.setRotationPoint(0.0f,0.0f,-1.0f);
        this.plater2.rotateAngleX = (float)(Math.PI/180)*-23;
        this.plater2.rotateAngleY = (float)(Math.PI/180)*-6;

        this.plater3 = new ModelRenderer(this, 190, 77);
        this.plater3.mirror = true;
        this.plater1.addChild(plater3);
        this.plater3.addBox(-9.0f,-2.0f,-24.0f,9,4,24);
        this.plater3.setRotationPoint(-7.0f,0.0f,0.0f);
        this.plater3.rotateAngleZ = (float)(Math.PI/180)*-30;

        this.plater4 = new ModelRenderer(this, 147, 28);
        this.plater4.mirror = true;
        this.plater1.addChild(plater4);
        this.plater4.addBox(-9.0f,-2.0f,0.0f,9,4,24);
        this.plater4.setRotationPoint(-7.0f,0.0f,-1.0f);
        this.plater4.rotateAngleX = (float)(Math.PI/180)*-18;
        this.plater4.rotateAngleY = (float)(Math.PI/180)*-15;
        this.plater4.rotateAngleZ = (float)(Math.PI/180)*-26;

        this.plater5 = new ModelRenderer(this, 189, 56);
        this.plater4.addChild(plater5);
        this.plater5.addBox(-3.0f,-2.0f,-3.0f,6,4,6);
        this.plater5.setRotationPoint(-4.5f,0.0f,24.0f);
        this.plater5.rotateAngleY = (float)(Math.PI/180)*45;

        this.platel1 = new ModelRenderer(this, 190, 20);
        this.body.addChild(platel1);
        this.platel1.addBox(-1.0f,-2.0f,-24.0f,9,4,24);
        this.platel1.setRotationPoint(0.0f,-14.0f,0.0f);
        this.platel1.rotateAngleX = (float)(Math.PI/180)*15;
        this.platel1.rotateAngleY = (float)(Math.PI/180)*-3;
        this.platel1.rotateAngleZ = (float)(Math.PI/180)*15;

        this.platel2 = new ModelRenderer(this, 188, 48);
        this.platel1.addChild(platel2);
        this.platel2.addBox(-1.0f,-2.0f,0.0f,9,4,25);
        this.platel2.setRotationPoint(0.0f,0.0f,-1.0f);
        this.platel2.rotateAngleX = (float)(Math.PI/180)*-23;
        this.platel2.rotateAngleY = (float)(Math.PI/180)*6;

        this.platel3 = new ModelRenderer(this, 190, 77);
        this.platel1.addChild(platel3);
        this.platel3.addBox(0.0f,-2.0f,-24.0f,9,4,24);
        this.platel3.setRotationPoint(7.0f,0.0f,0.0f);
        this.platel3.rotateAngleZ = (float)(Math.PI/180)*30;

        this.platel4 = new ModelRenderer(this, 147, 28);
        this.platel1.addChild(platel4);
        this.platel4.addBox(0.0f,-2.0f,0.0f,9,4,24);
        this.platel4.setRotationPoint(7.0f,0.0f,-1.0f);
        this.platel4.rotateAngleX = (float)(Math.PI/180)*-18;
        this.platel4.rotateAngleY = (float)(Math.PI/180)*15;
        this.platel4.rotateAngleZ = (float)(Math.PI/180)*26;

        this.platel5 = new ModelRenderer(this, 189, 56);
        this.platel5.mirror = true;
        this.platel4.addChild(platel5);
        this.platel5.addBox(-3.0f,-2.0f,-3.0f,6,4,6);
        this.platel5.setRotationPoint(4.5f,0.0f,24.0f);
        this.platel5.rotateAngleY = (float)(Math.PI/180)*45;

        //legs
        this.thighr1 = new ModelRenderer(this, 0, 4);
        this.body.addChild(thighr1);
        this.thighr1.addBox(-6.0f,-5.5f,-3.5f,6,10,7);
        this.thighr1.setRotationPoint(-9,5,-10);
        this.thighr1.rotateAngleX = (float)(Math.PI/180)*30;

        this.legr1 = new ModelRenderer(this, 0, 44);
        this.thighr1.addChild(legr1);
        this.legr1.addBox(-2.0f,0.0f,-2.5f,4,8,5);
        this.legr1.setRotationPoint(-3,3,0);
        this.legr1.rotateAngleX = (float)(Math.PI/180)*-45;

        this.footr1 = new ModelRenderer(this, 0, 21);
        this.legr1.addChild(footr1);
        this.footr1.addBox(-2.0f,0.0f,-3.0f,4,4,6);
        this.footr1.setRotationPoint(0,6,0);
        this.footr1.rotateAngleX = (float)(Math.PI/180)*15;

        this.thighr2 = new ModelRenderer(this, 0, 4);
        this.body.addChild(thighr2);
        this.thighr2.addBox(-6.0f,-5.5f,-3.5f,6,10,7);
        this.thighr2.setRotationPoint(-9,5,10);
        this.thighr2.rotateAngleX = (float)(Math.PI/180)*-30;

        this.legr2 = new ModelRenderer(this, 0, 44);
        this.thighr2.addChild(legr2);
        this.legr2.addBox(-2.0f,0.0f,-2.5f,4,8,5);
        this.legr2.setRotationPoint(-3,3,0);
        this.legr2.rotateAngleX = (float)(Math.PI/180)*45;

        this.footr2 = new ModelRenderer(this, 0, 21);
        this.legr2.addChild(footr2);
        this.footr2.addBox(-2.0f,0.0f,-3.0f,4,4,6);
        this.footr2.setRotationPoint(0,6,0);
        this.footr2.rotateAngleX = (float)(Math.PI/180)*-15;

        this.thighl1 = new ModelRenderer(this, 0, 4);
        this.body.addChild(thighl1);
        this.thighl1.addBox(0.0f,-5.5f,-3.5f,6,10,7);
        this.thighl1.setRotationPoint(9,5,-10);
        this.thighl1.rotateAngleX = (float)(Math.PI/180)*30;

        this.legl1 = new ModelRenderer(this, 0, 44);
        this.thighl1.addChild(legl1);
        this.legl1.addBox(-2.0f,0.0f,-2.5f,4,8,5);
        this.legl1.setRotationPoint(3,3,0);
        this.legl1.rotateAngleX = (float)(Math.PI/180)*-45;

        this.footl1 = new ModelRenderer(this, 0, 21);
        this.legl1.addChild(footl1);
        this.footl1.addBox(-2.0f,0.0f,-3.0f,4,4,6);
        this.footl1.setRotationPoint(0,6,0);
        this.footl1.rotateAngleX = (float)(Math.PI/180)*15;

        this.thighl2 = new ModelRenderer(this, 0, 4);
        this.body.addChild(thighl2);
        this.thighl2.addBox(0.0f,-5.5f,-3.5f,6,10,7);
        this.thighl2.setRotationPoint(9,5,10);
        this.thighl2.rotateAngleX = (float)(Math.PI/180)*-30;

        this.legl2 = new ModelRenderer(this, 0, 44);
        this.thighl2.addChild(legl2);
        this.legl2.addBox(-2.0f,0.0f,-2.5f,4,8,5);
        this.legl2.setRotationPoint(3,3,0);
        this.legl2.rotateAngleX = (float)(Math.PI/180)*45;

        this.footl2 = new ModelRenderer(this, 0, 21);
        this.legl2.addChild(footl2);
        this.footl2.addBox(-2.0f,0.0f,-3.0f,4,4,6);
        this.footl2.setRotationPoint(0,6,0);
        this.footl2.rotateAngleX = (float)(Math.PI/180)*-15;

        //head
        this.neck1 = new ModelRenderer(this,80,0);
        this.body.addChild(neck1);
        this.neck1.addBox(-8.0f,-5.0f,-8.0f,16,10,8);
        this.neck1.setRotationPoint(0.0f,0.0f,-12.0f);
        this.neck1.rotateAngleX = (float)(Math.PI/180)*20;

        this.neckridge = new ModelRenderer(this,212,0);
        this.neck1.addChild(neckridge);
        this.neckridge.addBox(-3.0f,-8.0f,-6.0f,9,8,12);
        this.neckridge.setRotationPoint(-2.0f,0.0f,0.0f);
        this.neckridge.rotateAngleY = (float)(Math.PI/180)*90;
        this.neckridge.rotateAngleZ = (float)(Math.PI/180)*25;

        this.neck2 = new ModelRenderer(this,128,0);
        this.neck1.addChild(neck2);
        this.neck2.addBox(-6.0f,-4.0f,-10.0f,12,8,10);
        this.neck2.setRotationPoint(0.0f,0.0f,-4.0f);
        this.neck2.rotateAngleX = (float)(Math.PI/180)*-10;

        this.neck3 = new ModelRenderer(this,172,0);
        this.neck2.addChild(neck3);
        this.neck3.addBox(-4.0f,-3.0f,-12.0f,8,6,12);
        this.neck3.setRotationPoint(0.0f,0.0f,-5.0f);
        this.neck3.rotateAngleX = (float)(Math.PI/180)*-10;

        this.head = new ModelRenderer(this,112,18);
        this.neck3.addChild(head);
        this.head.addBox(-5.0f,-6.0f,-8.0f,10,8,8);
        this.head.setRotationPoint(0.0f,0.0f,-8.0f);
        this.head.rotateAngleX = (float)(Math.PI/180)*-15;

        this.snout = new ModelRenderer(this,148,18);
        this.head.addChild(snout);
        this.snout.addBox(-4.0f,-2.0f,-6.0f,8,4,6);
        this.snout.setRotationPoint(0.0f,-4.0f,-7.0f);
        this.snout.rotateAngleX = (float)(Math.PI/180)*15;

        this.mouth = new ModelRenderer(this,176,18);
        this.head.addChild(mouth);
        this.mouth.addBox(-3.0f,-2.0f,-5.0f,6,4,5);
        this.mouth.setRotationPoint(0.0f,0.0f,-7.0f);

        this.hspiker = new ModelRenderer(this,0,0);
        this.head.addChild(hspiker);
        this.hspiker.addBox(-4.0f,-1.0f,-1.0f,6,2,2);
        this.hspiker.setRotationPoint(-5.0f,1.0f,-1.0f);
        this.hspiker.rotateAngleY = (float)(Math.PI/180)*45;
        this.hspiker.rotateAngleZ = (float)(Math.PI/180)*-30;

        this.hspikel = new ModelRenderer(this,0,0);
        this.hspikel.mirror = true;
        this.head.addChild(hspikel);
        this.hspikel.addBox(-2.0f,-1.0f,-1.0f,6,2,2);
        this.hspikel.setRotationPoint(5.0f,1.0f,-1.0f);
        this.hspikel.rotateAngleY = (float)(Math.PI/180)*-45;
        this.hspikel.rotateAngleZ = (float)(Math.PI/180)*30;

        //tail
        this.tail1 = new ModelRenderer(this,18,44);
        this.body.addChild(tail1);
        this.tail1.addBox(-8.0f,-5.0f,0.0f,16,10,8);
        this.tail1.setRotationPoint(0.0f,0.0f,12.0f);

        this.tailridge = new ModelRenderer(this,115,44);
        this.tail1.addChild(tailridge);
        this.tailridge.addBox(-10.0f,-8.0f,-6.0f,10,8,12);
        this.tailridge.setRotationPoint(0.0f,-2.0f,-5.0f);
        this.tailridge.rotateAngleY = (float)(Math.PI/180)*90;
        this.tailridge.rotateAngleZ = (float)(Math.PI/180)*-25;

        this.tail2 = new ModelRenderer(this,66,44);
        this.tail1.addChild(tail2);
        this.tail2.addBox(-6.0f,-4.0f,0.0f,12,8,12);
        this.tail2.setRotationPoint(0.0f,0.0f,4.0f);
        this.tail2.rotateAngleX = (float)(Math.PI/180)*-5;

        this.tail3 = new ModelRenderer(this,0,62);
        this.tail2.addChild(tail3);
        this.tail3.addBox(-4.0f,-3.0f,0.0f,8,6,20);
        this.tail3.setRotationPoint(0.0f,0.0f,8.0f);
        this.tail3.rotateAngleX = (float)(Math.PI/180)*-5;

        this.club1 = new ModelRenderer(this,56,64);
        this.tail3.addChild(club1);
        this.club1.addBox(-5.0f,-4.0f,0.0f,10,8,18);
        this.club1.setRotationPoint(0.0f,0.0f,18.0f);
        this.club1.rotateAngleX = (float)(Math.PI/180)*-5;

        this.club2 = new ModelRenderer(this,112,64);
        this.club1.addChild(club2);
        this.club2.addBox(-6.0f,-5.0f,0.0f,12,10,12);
        this.club2.setRotationPoint(0.0f,0.0f,3.0f);

        this.tspike1 = new ModelRenderer(this,0,88);
        this.club1.addChild(tspike1);
        this.tspike1.addBox(-16.0f,-1.0f,-1.0f,20,2,2);
        this.tspike1.setRotationPoint(6.0f,0.0f,9.0f);

        this.tspiker1 = new ModelRenderer(this,0,0);
        this.club1.addChild(tspiker1);
        this.tspiker1.addBox(-5.0f,-1.0f,-1.0f,6,2,2);
        this.tspiker1.setRotationPoint(-5.0f,-4.0f,3.0f);
        this.tspiker1.rotateAngleY = (float)(Math.PI/180)*-45;
        this.tspiker1.rotateAngleZ = (float)(Math.PI/180)*45;

        this.tspiker2 = new ModelRenderer(this,0,0);
        this.club1.addChild(tspiker2);
        this.tspiker2.addBox(-5.0f,-1.0f,-1.0f,6,2,2);
        this.tspiker2.setRotationPoint(-5.0f,4.0f,3.0f);
        this.tspiker2.rotateAngleY = (float)(Math.PI/180)*-45;
        this.tspiker2.rotateAngleZ = (float)(Math.PI/180)*-45;

        this.tspiker3 = new ModelRenderer(this,0,0);
        this.club1.addChild(tspiker3);
        this.tspiker3.addBox(-5.0f,-1.0f,-1.0f,6,2,2);
        this.tspiker3.setRotationPoint(-5.0f,-4.0f,15.0f);
        this.tspiker3.rotateAngleY = (float)(Math.PI/180)*45;
        this.tspiker3.rotateAngleZ = (float)(Math.PI/180)*45;

        this.tspiker4 = new ModelRenderer(this,0,0);
        this.club1.addChild(tspiker4);
        this.tspiker4.addBox(-5.0f,-1.0f,-1.0f,6,2,2);
        this.tspiker4.setRotationPoint(-5.0f,4.0f,15.0f);
        this.tspiker4.rotateAngleY = (float)(Math.PI/180)*45;
        this.tspiker4.rotateAngleZ = (float)(Math.PI/180)*-45;

        this.tspikel1 = new ModelRenderer(this,0,0);
        this.tspikel1.mirror = true;
        this.club1.addChild(tspikel1);
        this.tspikel1.addBox(-1.0f,-1.0f,-1.0f,6,2,2);
        this.tspikel1.setRotationPoint(5.0f,-4.0f,3.0f);
        this.tspikel1.rotateAngleY = (float)(Math.PI/180)*45;
        this.tspikel1.rotateAngleZ = (float)(Math.PI/180)*-45;

        this.tspikel2 = new ModelRenderer(this,0,0);
        this.tspikel2.mirror = true;
        this.club1.addChild(tspikel2);
        this.tspikel2.addBox(-1.0f,-1.0f,-1.0f,6,2,2);
        this.tspikel2.setRotationPoint(5.0f,4.0f,3.0f);
        this.tspikel2.rotateAngleY = (float)(Math.PI/180)*45;
        this.tspikel2.rotateAngleZ = (float)(Math.PI/180)*45;

        this.tspikel3 = new ModelRenderer(this,0,0);
        this.tspikel3.mirror = true;
        this.club1.addChild(tspikel3);
        this.tspikel3.addBox(-1.0f,-1.0f,-1.0f,6,2,2);
        this.tspikel3.setRotationPoint(5.0f,-4.0f,15.0f);
        this.tspikel3.rotateAngleY = (float)(Math.PI/180)*-45;
        this.tspikel3.rotateAngleZ = (float)(Math.PI/180)*-45;

        this.tspikel4 = new ModelRenderer(this,0,0);
        this.tspikel4.mirror = true;
        this.club1.addChild(tspikel4);
        this.tspikel4.addBox(-1.0f,-1.0f,-1.0f,6,2,2);
        this.tspikel4.setRotationPoint(5.0f,4.0f,15.0f);
        this.tspikel4.rotateAngleY = (float)(Math.PI/180)*-45;
        this.tspikel4.rotateAngleZ = (float)(Math.PI/180)*45;
    }

    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

        this.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
        this.body.render(scale);
    }

    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale, Entity entityIn)
    {
        float f = (180F / (float)Math.PI);

        this.head.rotateAngleX = ((headPitch / (180F / (float)Math.PI)) + (float)Math.PI/4) + (float)(Math.PI/180)*-15;
        this.head.rotateAngleY = (netHeadYaw / (180F / (float)Math.PI))/4;
        this.neck1.rotateAngleY = (netHeadYaw / (180F / (float)Math.PI))/4;
        this.neck2.rotateAngleY = (netHeadYaw / (180F / (float)Math.PI))/4;
        this.neck3.rotateAngleY = (netHeadYaw / (180F / (float)Math.PI))/4;
        this.thighr1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*30;
        this.thighr2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float)Math.PI) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*-30;
        this.thighl1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float)Math.PI) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*30;
        this.thighl2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*-30;
        this.legr1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float)Math.PI) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*-45;
        this.legr2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*45;
        this.legl1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*-45;
        this.legl2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float)Math.PI) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*45;
        this.footr1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*15;
        this.footr2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float)Math.PI) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*-15;
        this.footl1.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F + (float)Math.PI) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*15;
        this.footl2.rotateAngleX = (MathHelper.cos(limbSwing * 0.25F) * 1.4F * limbSwingAmount) + (float)(Math.PI/180)*-15;
        this.tail1.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount)/3;
        this.tail2.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount)/6;
        this.tail3.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount)/6;
        this.club1.rotateAngleY = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount)/6;
    }
}
