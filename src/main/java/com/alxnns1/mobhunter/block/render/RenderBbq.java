package com.alxnns1.mobhunter.block.render;

import com.alxnns1.mobhunter.block.models.ModelBbqMeat;
import com.alxnns1.mobhunter.reference.Reference;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;

/**
 * Created by Mark on 06/05/2016.
 */
public class RenderBbq extends TileEntitySpecialRenderer<TileBbq>
{
    private static final ModelBbqMeat model = new ModelBbqMeat();
    private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + "textures/models/blocks/meat.png");

    @Override
    public void renderTileEntityAt(TileBbq te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        //Render meat only if cooking
        if(te.isCooking())
        {
            GlStateManager.pushMatrix();
            GlStateManager.translate(x, y, z);

            //Set the model position and rotation
            double rotation = te.getMeatRotation();

            //Set the texture to use for the meat model
            bindTexture(texture);

            //Render model
            model.render(te.getCookingStage());

            GlStateManager.popMatrix();
        }
    }
}
