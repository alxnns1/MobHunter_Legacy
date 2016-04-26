package com.alxnns1.mobhunter.entity.render;

import com.alxnns1.mobhunter.entity.EntityPopo;
import com.alxnns1.mobhunter.entity.models.ModelPopo;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mark on 22/04/2016.
 */
public class RenderPopo extends RenderCow {
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation popoTextures = new ResourceLocation("mobhunter:textures/entities/Popo.png");

    public RenderPopo(RenderManager renderManagerIn) {
        super(renderManagerIn, new ModelPopo(), 0.7f);
    }

    public static class Factory implements IRenderFactory<EntityPopo> {
        @Override
        public Render<? super EntityPopo> createRenderFor(RenderManager manager) {
            return new RenderPopo(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityCow entity, float f) {
        preRenderCallbackPopo((EntityPopo) entity, f);
    }

    protected void preRenderCallbackPopo(EntityPopo entity, float f) {
        float tSizeMult = entity.getPopoScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }

    protected ResourceLocation getEntityTexture(EntityCow entity) {
        return popoTextures;
    }
}
