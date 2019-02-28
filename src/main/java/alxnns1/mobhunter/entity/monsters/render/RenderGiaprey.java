package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityGiaprey;
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
public class RenderGiaprey extends RenderLiving<EntityGiaprey>
{
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation giapreyTextures = new ResourceLocation("mobhunter:textures/entities/giaprey.png");

	public RenderGiaprey(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelVelociprey(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGiaprey entity)
	{
		return giapreyTextures;
	}

	public static class Factory implements IRenderFactory<EntityGiaprey>
	{
		@Override
		public Render<? super EntityGiaprey> createRenderFor(RenderManager manager)
		{
			return new RenderGiaprey(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityGiaprey entity, float f)
	{
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
