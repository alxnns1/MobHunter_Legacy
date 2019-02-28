package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityGendrome;
import alxnns1.mobhunter.entity.monsters.models.ModelGendrome;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 11/12/2016.
 */
public class RenderGendrome extends RenderLiving<EntityGendrome>
{
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation gendromeTextures = new ResourceLocation("mobhunter:textures/entities/gendrome.png");

	public RenderGendrome(RenderManager renderManagerIn)
	{
		super(renderManagerIn, new ModelGendrome(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGendrome entity)
	{
		return gendromeTextures;
	}

	public static class Factory implements IRenderFactory<EntityGendrome>
	{
		@Override
		public Render<? super EntityGendrome> createRenderFor(RenderManager manager)
		{
			return new RenderGendrome(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityGendrome entity, float f)
	{
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
