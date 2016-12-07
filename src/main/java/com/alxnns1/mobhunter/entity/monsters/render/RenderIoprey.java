package com.alxnns1.mobhunter.entity.monsters.render;

import com.alxnns1.mobhunter.entity.monsters.EntityIoprey;
import com.alxnns1.mobhunter.entity.monsters.models.ModelIoprey;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 10/06/2016.
 */
public class RenderIoprey extends RenderLiving<EntityIoprey>
{
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation iopreyTextures = new ResourceLocation("mobhunter:textures/entities/ioprey.png");

    public RenderIoprey(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelIoprey(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityIoprey entity)
    {
        return iopreyTextures;
    }

    public static class Factory implements IRenderFactory<EntityIoprey>
    {
        @Override
        public Render<? super EntityIoprey> createRenderFor(RenderManager manager)
        {
            return new RenderIoprey(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityIoprey entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
