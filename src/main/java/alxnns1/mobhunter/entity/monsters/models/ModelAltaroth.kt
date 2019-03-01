package alxnns1.mobhunter.entity.monsters.models

import alxnns1.mobhunter.entity.monsters.EntityAltaroth
import net.minecraft.client.model.ModelBase
import net.minecraft.client.model.ModelRenderer
import net.minecraft.entity.Entity
import net.minecraft.util.math.MathHelper
import net.minecraftforge.fml.relauncher.Side
import net.minecraftforge.fml.relauncher.SideOnly

@SideOnly(Side.CLIENT)
class ModelAltaroth : ModelBase() {
    private var thorax: ModelRenderer
    private var thigh1: ModelRenderer
    private var leg1: ModelRenderer
    private var thigh2: ModelRenderer
    private var leg2: ModelRenderer
    private var thigh3: ModelRenderer
    private var leg3: ModelRenderer
    private var thigh4: ModelRenderer
    private var leg4: ModelRenderer
    private var thigh5: ModelRenderer
    private var leg5: ModelRenderer
    private var thigh6: ModelRenderer
    private var leg6: ModelRenderer
    private var abdomen: ModelRenderer
    private var juice: ModelRenderer
    private var stinger: ModelRenderer
    private var head: ModelRenderer
    private var crest: ModelRenderer
    private var mandible1: ModelRenderer
    private var mandible2: ModelRenderer

    init {
        textureHeight = 32
        textureWidth = 32

        crest = ModelRenderer(this, 14, 0).apply {
            addBox(-2.0f, -3.0f, -1.0f, 4, 3, 1)
            setRotationPoint(0.0f, -3.0f, 0.0f)
            rotateAngleX = Math.PI.toFloat() / 6
        }

        mandible1 = ModelRenderer(this, 14, 4).apply {
            addBox(-2.0f, -0.5f, -3.0f, 2, 1, 3)
            setRotationPoint(0.0f, -0.5f, -4.0f)
        }

        mandible2 = ModelRenderer(this, 14, 4).apply {
            mirror = true
            addBox(0.0f, -0.5f, -3.0f, 2, 1, 3)
            setRotationPoint(0.0f, -0.5f, -4.0f)
        }

        leg1 = ModelRenderer(this, 28, 8).apply {
            addBox(-0.5f, -6.0f, -0.5f, 1, 6, 1)
            setRotationPoint(-0.5f, -4.0f, 0.0f)
            rotateAngleZ = -Math.PI.toFloat() * 11 / 18
        }

        thigh1 = ModelRenderer(this, 0, 2).apply {
            addBox(-1.0f, -4.0f, -0.5f, 1, 4, 1)
            setRotationPoint(-1.0f, 0.0f, 0.0f)
            rotateAngleX = Math.PI.toFloat() / 12
            rotateAngleY = -Math.PI.toFloat() / 6
            rotateAngleZ = -Math.PI.toFloat() / 6
            addChild(leg1)
        }

        leg2 = ModelRenderer(this, 28, 0).apply {
            addBox(-0.5f, -7.0f, -0.5f, 1, 7, 1)
            setRotationPoint(-0.5f, -5.0f, 0.0f)
            rotateAngleZ = -Math.PI.toFloat() * 2 / 3
        }

        thigh2 = ModelRenderer(this, 0, 11).apply {
            addBox(-1.0f, -5.0f, -0.5f, 1, 5, 1)
            setRotationPoint(-1.0f, 0.5f, 1.5f)
            rotateAngleX = -Math.PI.toFloat() / 12
            rotateAngleZ = -Math.PI.toFloat() / 6
            addChild(leg2)
        }

        leg3 = ModelRenderer(this, 24, 0).apply {
            addBox(-0.5f, -8.0f, -0.5f, 1, 8, 1)
            setRotationPoint(-0.5f, -6.0f, 0.0f)
            rotateAngleZ = -Math.PI.toFloat() * 13 / 18
        }

        thigh3 = ModelRenderer(this, 4, 0).apply {
            addBox(-1.0f, -6.0f, -0.5f, 1, 6, 1)
            setRotationPoint(-1.0f, 1.0f, 3.0f)
            rotateAngleX = -Math.PI.toFloat() / 6
            rotateAngleY = Math.PI.toFloat() / 6
            rotateAngleZ = -Math.PI.toFloat() / 6
            addChild(leg3)
        }

        leg4 = ModelRenderer(this, 28, 8).apply {
            addBox(-0.5f, -6.0f, -0.5f, 1, 6, 1)
            setRotationPoint(0.5f, -4.0f, 0.0f)
            rotateAngleZ = (11 * Math.PI).toFloat() / 18
        }

        thigh4 = ModelRenderer(this, 0, 2).apply {
            addBox(0.0f, -4.0f, -0.5f, 1, 4, 1)
            setRotationPoint(1.0f, 0.0f, 0.0f)
            rotateAngleX = Math.PI.toFloat() / 12
            rotateAngleY = Math.PI.toFloat() / 6
            rotateAngleZ = Math.PI.toFloat() / 6
            addChild(leg4)
        }

        leg5 = ModelRenderer(this, 28, 0).apply {
            addBox(-0.5f, -7.0f, -0.5f, 1, 7, 1)
            setRotationPoint(0.5f, -5.0f, 0.0f)
            rotateAngleZ = (2 * Math.PI).toFloat() / 3
        }

        thigh5 = ModelRenderer(this, 0, 11).apply {
            addBox(0.0f, -5.0f, -0.5f, 1, 5, 1)
            setRotationPoint(1.0f, 0.5f, 1.5f)
            rotateAngleX = -Math.PI.toFloat() / 12
            rotateAngleZ = Math.PI.toFloat() / 6
            addChild(leg5)
        }

        leg6 = ModelRenderer(this, 24, 0).apply {
            addBox(-0.5f, -8.0f, -0.5f, 1, 8, 1)
            setRotationPoint(0.5f, -6.0f, 0.0f)
            rotateAngleZ = (13 * Math.PI).toFloat() / 18
        }

        thigh6 = ModelRenderer(this, 4, 0).apply {
            addBox(0.0f, -6.0f, -0.5f, 1, 6, 1)
            setRotationPoint(1.0f, 1.0f, 3.0f)
            rotateAngleX = -Math.PI.toFloat() / 6
            rotateAngleY = -Math.PI.toFloat() / 6
            rotateAngleZ = Math.PI.toFloat() / 6
            addChild(leg6)
        }

        juice = ModelRenderer(this, 6, 19).apply {
            addBox(-2.5f, -2.5f, 0.0f, 5, 5, 8)
            setRotationPoint(0.0f, 0.0f, 0.0f)
        }

        stinger = ModelRenderer(this, 0, 0).apply {
            addBox(-0.5f, -0.5f, 0.0f, 1, 1, 1)
            setRotationPoint(0.0f, 0.0f, 8.0f)
        }

        abdomen = ModelRenderer(this, 0, 0).apply {
            addBox(-1.5f, -1.5f, 0.0f, 3, 3, 8)
            setRotationPoint(0.0f, 0.0f, 4.0f)
            rotateAngleX = Math.PI.toFloat() / 12
            addChild(stinger)
            addChild(juice)
        }

        head = ModelRenderer(this, 16, 11).apply {
            addBox(-2.0f, -3.0f, -4.0f, 4, 3, 4)
            setRotationPoint(0.0f, 1.0f, 0.0f)
            rotateAngleX = -Math.PI.toFloat() / 12
            addChild(crest)
            addChild(mandible1)
            addChild(mandible2)
        }

        thorax = ModelRenderer(this, 0, 11).apply {
            addBox(-1.0f, -1.0f, -1.0f, 2, 2, 6)
            setRotationPoint(0.0f, 22.0f, 0.0f)
            rotateAngleX = Math.PI.toFloat() / 12
            addChild(head)
            addChild(abdomen)
            addChild(thigh1)
            addChild(thigh2)
            addChild(thigh3)
            addChild(thigh4)
            addChild(thigh5)
            addChild(thigh6)
        }
    }

    override fun render(entityIn: Entity, limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float, scale: Float) {
        setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn)

        if (entityIn is EntityAltaroth) {
            juice.isHidden = !entityIn.isFull
        }

        thorax.render(scale)
    }

    override fun setRotationAngles(limbSwing: Float, limbSwingAmount: Float, ageInTicks: Float, netHeadYaw: Float, headPitch: Float, scaleFactor: Float, entityIn: Entity) {
        head.rotateAngleX = headPitch / (180f / Math.PI.toFloat()) - Math.PI.toFloat() / 12
        head.rotateAngleY = netHeadYaw / (180f / Math.PI.toFloat())
        thigh1.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount - Math.PI.toFloat() / 6
        thigh2.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount
        thigh3.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount + Math.PI.toFloat() / 6
        thigh4.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount + Math.PI.toFloat() / 6
        thigh5.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount
        thigh6.rotateAngleY = MathHelper.cos(limbSwing * 0.6662f + Math.PI.toFloat()) * 1.4f * limbSwingAmount - Math.PI.toFloat() / 6
        abdomen.rotateAngleX = Math.abs(MathHelper.cos(limbSwing * 0.6662f) * 1.4f * limbSwingAmount) / 2
    }
}
