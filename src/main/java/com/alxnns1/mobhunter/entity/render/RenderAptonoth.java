package com.alxnns1.mobhunter.entity.render;

import com.alxnns1.mobhunter.entity.EntityAptonoth;
import com.alxnns1.mobhunter.entity.models.ModelAptonoth;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 26/05/2016.
 */
public class RenderAptonoth extends RenderLiving<EntityAptonoth> {
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation popoTextures = new ResourceLocation("mobhunter:textures/entities/aptonoth.png");

    public RenderAptonoth(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelAptonoth(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityAptonoth entity)
    {
        return popoTextures;
    }

    public static class Factory implements IRenderFactory<EntityAptonoth>
    {
        @Override
        public Render<? super EntityAptonoth> createRenderFor(RenderManager manager)
        {
            return new RenderAptonoth(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityAptonoth entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
