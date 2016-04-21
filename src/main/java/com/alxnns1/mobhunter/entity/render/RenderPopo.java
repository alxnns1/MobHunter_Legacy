package com.alxnns1.mobhunter.entity.render;

import com.alxnns1.mobhunter.entity.EntityPopo;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by Mark on 22/04/2016.
 */
public class RenderPopo extends RenderCow
{
    public static final Factory FACTORY = new Factory();

    public RenderPopo(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelCow(), 0.7f);
    }

    public static class Factory implements IRenderFactory<EntityPopo>
    {
        @Override
        public Render<? super EntityPopo> createRenderFor(RenderManager manager)
        {
            return new RenderPopo(manager);
        }
    }
}
