package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityPopo;
import alxnns1.mobhunter.entity.monsters.models.ModelPopo;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Mark on 22/04/2016.
 */
public class RenderPopo extends RenderLiving<EntityPopo> {
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation popoTextures = new ResourceLocation("mobhunter:textures/entities/popo.png");

	public RenderPopo(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelPopo(), 0.7f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPopo entity) {
		return popoTextures;
	}

	public static class Factory implements IRenderFactory<EntityPopo> {
		@Override
		public Render<? super EntityPopo> createRenderFor(RenderManager manager) {
			return new RenderPopo(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityPopo entity, float f) {
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
