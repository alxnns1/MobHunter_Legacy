package alxnns1.mobhunter.block.render;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.block.models.ModelBbqMeat;
import alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mark on 06/05/2016.
 */
@SideOnly(Side.CLIENT)
public class RenderBbq extends TileEntitySpecialRenderer<TileBbq>
{
	private static final ModelBbqMeat model = new ModelBbqMeat();
	private static final ResourceLocation tRaw = new ResourceLocation(MobHunter.MOD_ID + ":textures/models/blocks/meatRaw.png");
	private static final ResourceLocation tRare = new ResourceLocation(MobHunter.MOD_ID + ":textures/models/blocks/meatRare.png");
	private static final ResourceLocation tDone = new ResourceLocation(MobHunter.MOD_ID + ":textures/models/blocks/meatDone.png");
	private static final ResourceLocation tBurnt = new ResourceLocation(MobHunter.MOD_ID + ":textures/models/blocks/meatBurnt.png");

	@Override
	public void render(TileBbq te, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
	{
		//Render meat only if cooking
		if(te.isCooking())
		{
			GlStateManager.pushMatrix();

			//Set the model position and rotation
			GlStateManager.translate(x, y + 0.84375f, z + 0.5f);
			model.rotateX((float) Math.toRadians(te.getCookRotation()));

			//Set the texture to use for the meat model
			ResourceLocation texture;
			switch(te.getCookingStage())
			{
				case 1:
					texture = tRare;
					break;
				case 2:
					texture = tDone;
					break;
				case 3:
					texture = tBurnt;
					break;
				case 0:
				default:
					texture = tRaw;
			}
			bindTexture(texture);

			//Render model
			model.render();

			GlStateManager.popMatrix();
		}
	}
}
