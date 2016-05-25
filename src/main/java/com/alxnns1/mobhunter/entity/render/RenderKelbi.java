package com.alxnns1.mobhunter.entity.render;

import com.alxnns1.mobhunter.entity.EntityKelbi;
import com.alxnns1.mobhunter.entity.models.ModelKelbi;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 27/04/2016.
 */
public class RenderKelbi extends RenderLiving<EntityKelbi>
{
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation kelbiTextures = new ResourceLocation("mobhunter:textures/entities/kelbi.png");

    public RenderKelbi(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelKelbi(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKelbi entity)
    {
        return kelbiTextures;
    }

    public static class Factory implements IRenderFactory<EntityKelbi>
    {
        @Override
        public Render<? super EntityKelbi> createRenderFor(RenderManager manager)
        {
            return new RenderKelbi(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityKelbi entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
