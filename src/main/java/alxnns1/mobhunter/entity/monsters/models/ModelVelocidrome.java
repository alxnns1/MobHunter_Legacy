package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 01/06/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelVelocidrome extends ModelDromeBase
{
    ModelRenderer crest;

    public ModelVelocidrome()
    {
        this.crest = new ModelRenderer(this,88,116);
        this.head.addChild(crest);
        this.crest.addBox(0.0f,-12.0f,-24.0f,0,24,36 );
        this.crest.setRotationPoint(0.0f,-10.0f,12.0f);
    }
}
