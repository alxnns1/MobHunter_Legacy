package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityGenprey;
import alxnns1.mobhunter.entity.monsters.models.ModelGenprey;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 10/06/2016.
 */
public class RenderGenprey extends RenderLiving<EntityGenprey>
{
    public static final Factory FACTORY = new Factory();
    private static final ResourceLocation genpreyTextures = new ResourceLocation("mobhunter:textures/entities/genprey.png");

    public RenderGenprey(RenderManager renderManagerIn)
    {
        super(renderManagerIn, new ModelGenprey(), 0.7f);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityGenprey entity)
    {
        return genpreyTextures;
    }

    public static class Factory implements IRenderFactory<EntityGenprey>
    {
        @Override
        public Render<? super EntityGenprey> createRenderFor(RenderManager manager)
        {
            return new RenderGenprey(manager);
        }
    }

    @Override
    protected void preRenderCallback(EntityGenprey entity, float f)
    {
        float tSizeMult = entity.getScale();
        GL11.glScalef(tSizeMult,tSizeMult,tSizeMult);
    }
}
