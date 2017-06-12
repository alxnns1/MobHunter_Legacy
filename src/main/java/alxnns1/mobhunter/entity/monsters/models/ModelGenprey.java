package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 10/06/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelGenprey extends ModelPreyBase {

    ModelRenderer crest1;
    ModelRenderer crest2;
    ModelRenderer fang1;
    ModelRenderer fang2;

    public ModelGenprey() {
        this.crest1 = new ModelRenderer(this,44,58);
        this.head.addChild(crest1);
        this.crest1.addBox(0.0f,-2.0f,-6.0f,0,5,15);
        this.crest1.setRotationPoint(-5.0f,-5.0f,0.0f);
        this.crest1.rotateAngleZ = -(float)Math.PI/6;

        this.crest2 = new ModelRenderer(this,44,58);
        this.head.addChild(crest2);
        this.crest2.addBox(0.0f,-2.0f,-6.0f,0,5,15);
        this.crest2.setRotationPoint(5.0f,-5.0f,0.0f);
        this.crest2.rotateAngleZ = (float)Math.PI/6;

        this.fang1 = new ModelRenderer(this,0,0);
        this.head.addChild(fang1);
        this.fang1.addBox(0.0f,0.0f,0.0f,1,5,1);
        this.fang1.setRotationPoint(-3.5f,2.0f,-18.0f);

        this.fang2 = new ModelRenderer(this,0,0);
        this.head.addChild(fang2);
        this.fang2.addBox(0.0f,0.0f,0.0f,1,5,1);
        this.fang2.setRotationPoint(2.5f,2.0f,-18.0f);
    }
}
