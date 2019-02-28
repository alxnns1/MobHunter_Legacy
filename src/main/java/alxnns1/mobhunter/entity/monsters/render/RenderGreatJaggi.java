package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityGreatJaggi;
import alxnns1.mobhunter.entity.monsters.models.ModelGreatJaggi;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 01/06/2016.
 */
public class RenderGreatJaggi extends RenderLiving<EntityGreatJaggi> {
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation greatJaggiTextures = new ResourceLocation("mobhunter:textures/entities/great_jaggi.png");

	public RenderGreatJaggi(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelGreatJaggi(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGreatJaggi entity) {
		return greatJaggiTextures;
	}

	public static class Factory implements IRenderFactory<EntityGreatJaggi> {
		@Override
		public Render<? super EntityGreatJaggi> createRenderFor(RenderManager manager) {
			return new RenderGreatJaggi(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityGreatJaggi entity, float f) {
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
