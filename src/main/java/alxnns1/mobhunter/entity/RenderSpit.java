package alxnns1.mobhunter.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by Mark on 07/12/2016.
 */
public class RenderSpit extends RenderSnowball<EntitySpit>
{
	public static final RenderSpit.Factory FACTORY = new RenderSpit.Factory();

	public RenderSpit(RenderManager renderManager, RenderItem itemRenderer)
	{
		super(renderManager, null, itemRenderer);
	}

	@Override
	public ItemStack getStackToRender(EntitySpit entityIn)
	{
		return entityIn.getItemToRender();
	}

	public static class Factory implements IRenderFactory<EntitySpit>
	{
		@Override
		public Render<? super EntitySpit> createRenderFor(RenderManager manager)
		{
			return new RenderSpit(manager, Minecraft.getMinecraft().getRenderItem());
		}
	}
}
