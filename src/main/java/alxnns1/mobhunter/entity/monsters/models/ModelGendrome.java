package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 01/06/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelGendrome extends ModelDromeBase {
    ModelRenderer crest1;
    ModelRenderer crest2;
    ModelRenderer fang1;
    ModelRenderer fang2;

    public ModelGendrome() {
        this.crest1 = new ModelRenderer(this,88,116);
        this.head.addChild(crest1);
        this.crest1.addBox(0.0f,-20.0f,-12.0f,0,24,32);
        this.crest1.setRotationPoint(-10.0f,-10.0f,0.0f);
        this.crest1.rotateAngleZ = -(float)Math.PI/6;

        this.crest2 = new ModelRenderer(this,88,116);
        this.crest2.mirror = true;
        this.head.addChild(crest2);
        this.crest2.addBox(0.0f,-20.0f,-12.0f,0,24,32);
        this.crest2.setRotationPoint(10.0f,-10.0f,0.0f);
        this.crest2.rotateAngleZ = (float)Math.PI/6;

        this.fang1 = new ModelRenderer(this,8,0);
        this.snout.addChild(fang1);
        this.fang1.addBox(0.0f,0.0f,0.0f,2,10,2);
        this.fang1.setRotationPoint(-7f,0.0f,-24.0f);

        this.fang2 = new ModelRenderer(this,8,0);
        this.fang2.mirror = true;
        this.snout.addChild(fang2);
        this.fang2.addBox(0.0f,0.0f,0.0f,2,10,2);
        this.fang2.setRotationPoint(5f,0.0f,-24.0f);
    }
}
