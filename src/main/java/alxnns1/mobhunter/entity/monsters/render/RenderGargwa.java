package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityGargwa;
import alxnns1.mobhunter.entity.monsters.models.ModelGargwa;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 17/05/2016.
 */
public class RenderGargwa extends RenderLiving<EntityGargwa>
{
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation gargwaTextures = new ResourceLocation("mobhunter:textures/entities/gargwa.png");

    public RenderGargwa(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelGargwa(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGargwa entity)
    {
        return gargwaTextures;
    }

    public static class Factory implements IRenderFactory<EntityGargwa>
    {
        @Override
        public Render<? super EntityGargwa> createRenderFor(RenderManager manager)
        {
            return new RenderGargwa(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityGargwa entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
