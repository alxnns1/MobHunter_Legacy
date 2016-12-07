package com.alxnns1.mobhunter.entity.monsters.render;

import com.alxnns1.mobhunter.entity.monsters.EntityJaggia;
import com.alxnns1.mobhunter.entity.monsters.models.ModelJaggia;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 27/04/2016.
 */
public class RenderJaggia extends RenderLiving<EntityJaggia>
{
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation jaggiaTextures = new ResourceLocation("mobhunter:textures/entities/jaggia.png");

    public RenderJaggia(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelJaggia(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityJaggia entity)
    {
        return jaggiaTextures;
    }

    public static class Factory implements IRenderFactory<EntityJaggia>
    {
        @Override
        public Render<? super EntityJaggia> createRenderFor(RenderManager manager)
        {
            return new RenderJaggia(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityJaggia entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
