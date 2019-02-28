package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityJaggi;
import alxnns1.mobhunter.entity.monsters.models.ModelJaggi;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 27/04/2016.
 */
public class RenderJaggi extends RenderLiving<EntityJaggi> {
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation jaggiTextures = new ResourceLocation("mobhunter:textures/entities/jaggi.png");

	public RenderJaggi(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelJaggi(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityJaggi entity) {
		return jaggiTextures;
	}

	public static class Factory implements IRenderFactory<EntityJaggi> {
		@Override
		public Render<? super EntityJaggi> createRenderFor(RenderManager manager) {
			return new RenderJaggi(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityJaggi entity, float f) {
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
