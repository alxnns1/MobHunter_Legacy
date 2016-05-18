package com.alxnns1.mobhunter.entity.render;

import com.alxnns1.mobhunter.entity.EntityAltaroth;
import com.alxnns1.mobhunter.entity.models.ModelAltaroth;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 17/05/2016.
 */
public class RenderAltaroth extends RenderLiving<EntityAltaroth> {
    public static final RenderAltaroth.Factory FACTORY = new RenderAltaroth.Factory();
    private static final ResourceLocation altarothTextures = new ResourceLocation("mobhunter:textures/entities/altaroth.png");

    public RenderAltaroth(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelAltaroth(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAltaroth entity)
    {
        return altarothTextures;
    }

    public static class Factory implements IRenderFactory<EntityAltaroth>
    {
        @Override
        public Render<? super EntityAltaroth> createRenderFor(RenderManager manager)
        {
            return new RenderAltaroth(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityAltaroth entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
