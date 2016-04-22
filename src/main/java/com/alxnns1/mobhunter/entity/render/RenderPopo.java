package com.alxnns1.mobhunter.entity.render;

import com.alxnns1.mobhunter.entity.EntityPopo;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.client.model.ModelCow;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderCow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityCow;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

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

    @Override
    protected void preRenderCallback(EntityCow entity, float f)
    {
        preRenderCallbackPopo((EntityPopo) entity, f);
    }

    protected void preRenderCallbackPopo(EntityPopo entity, float f)
    {
        float tSizeMult = entity.getSizeMult();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
        LogHelper.info("Popo size scaled by " + tSizeMult);
    }
}
