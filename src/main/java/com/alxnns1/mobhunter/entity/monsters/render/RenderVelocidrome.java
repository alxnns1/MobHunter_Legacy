package com.alxnns1.mobhunter.entity.monsters.render;

import com.alxnns1.mobhunter.entity.monsters.EntityVelocidrome;
import com.alxnns1.mobhunter.entity.monsters.models.ModelVelocidrome;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 01/06/2016.
 */
public class RenderVelocidrome extends RenderLiving<EntityVelocidrome>
{
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation velocidromeTextures = new ResourceLocation("mobhunter:textures/entities/velocidrome.png");

    public RenderVelocidrome(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelVelocidrome(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityVelocidrome entity)
    {
        return velocidromeTextures;
    }

    public static class Factory implements IRenderFactory<EntityVelocidrome>
    {
        @Override
        public Render<? super EntityVelocidrome> createRenderFor(RenderManager manager)
        {
            return new RenderVelocidrome(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityVelocidrome entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
