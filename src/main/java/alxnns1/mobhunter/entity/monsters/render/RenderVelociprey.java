package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityVelociprey;
import alxnns1.mobhunter.entity.monsters.models.ModelVelociprey;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 27/04/2016.
 */
public class RenderVelociprey extends RenderLiving<EntityVelociprey>
{
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation velocipreyTextures = new ResourceLocation("mobhunter:textures/entities/velociprey.png");

	public RenderVelociprey(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelVelociprey(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityVelociprey entity)
	{
		return velocipreyTextures;
	}

	public static class Factory implements IRenderFactory<EntityVelociprey>
	{
		@Override
		public Render<? super EntityVelociprey> createRenderFor(RenderManager manager)
		{
			return new RenderVelociprey(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityVelociprey entity, float f)
	{
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
