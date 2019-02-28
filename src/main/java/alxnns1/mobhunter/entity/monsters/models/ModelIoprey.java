package alxnns1.mobhunter.entity.monsters.models;

import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Alex on 10/06/2016.
 */
@SideOnly(Side.CLIENT)
public class ModelIoprey extends ModelPreyBase
{

	ModelRenderer crest1;
	ModelRenderer crest2;
	ModelRenderer crest3;

	public ModelIoprey()
	{
		this.crest1 = new ModelRenderer(this, 0, 0);
		this.head.addChild(crest1);
		this.crest1.addBox(-1.0f, -1.0f, -2.0f, 2, 2, 5);
		this.crest1.setRotationPoint(4.0f, -5.0f, 2.0f);
		this.crest1.rotateAngleX = (float) Math.PI / 4;
		this.crest1.rotateAngleZ = (float) Math.PI / 6;

		this.crest2 = new ModelRenderer(this, 0, 0);
		this.head.addChild(crest2);
		this.crest2.addBox(-1.0f, -1.0f, -2.0f, 2, 2, 5);
		this.crest2.setRotationPoint(-4.0f, -5.0f, 2.0f);
		this.crest2.rotateAngleX = (float) Math.PI / 4;
		this.crest2.rotateAngleZ = -(float) Math.PI / 6;

		this.crest3 = new ModelRenderer(this, 38, 74);
		this.snout.addChild(crest3);
		this.crest3.addBox(-3.5f, -1.0f, -12.0f, 7, 1, 12);
		this.crest3.setRotationPoint(0.0f, -7.0f, 0.0f);
	}
}
