package com.alxnns1.mobhunter.block.render;

import com.alxnns1.mobhunter.block.models.ModelBbqMeat;
import com.alxnns1.mobhunter.tileentity.TileBbq;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.item.Item;

/**
 * Created by Mark on 06/05/2016.
 */
public class RenderBbq extends TileEntitySpecialRenderer<TileBbq>
{
    private static final ModelBbqMeat model = new ModelBbqMeat();

    @Override
    public void renderTileEntityAt(TileBbq te, double x, double y, double z, float partialTicks, int destroyStage)
    {
        if(te.isCooking())
        {
            //Render meat
            GlStateManager.pushMatrix();
            GlStateManager.translate(x, y, z);

            Item meatItem = te.getMeat();


            GlStateManager.popMatrix();
        }
    }
}
