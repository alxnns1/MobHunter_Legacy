package alxnns1.mobhunter.entity.monsters.render;

import alxnns1.mobhunter.entity.monsters.EntityApceros;
import alxnns1.mobhunter.entity.monsters.models.ModelApceros;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import org.lwjgl.opengl.GL11;

/**
 * Created by Alex on 26/05/2016.
 */
public class RenderApceros extends RenderLiving<EntityApceros> {
	public static final Factory FACTORY = new Factory();
	private static final ResourceLocation apcerosTextures = new ResourceLocation("mobhunter:textures/entities/apceros.png");

	public RenderApceros(RenderManager renderManagerIn) {
		super(renderManagerIn, new ModelApceros(), 1.4f);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityApceros entity) {
		return apcerosTextures;
	}

	public static class Factory implements IRenderFactory<EntityApceros> {
		@Override
		public Render<? super EntityApceros> createRenderFor(RenderManager manager) {
			return new RenderApceros(manager);
		}
	}

	@Override
	protected void preRenderCallback(EntityApceros entity, float f) {
		float tSizeMult = entity.getScale();
		GL11.glScalef(tSizeMult, tSizeMult, tSizeMult);
	}
}
