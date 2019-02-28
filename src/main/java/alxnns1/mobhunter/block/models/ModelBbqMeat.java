package alxnns1.mobhunter.block.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

/**
 * Created by Mark on 08/05/2016.
 */
public class ModelBbqMeat extends ModelBase
{
	private ModelRenderer meat;

	public ModelBbqMeat()
	{
		textureWidth = 32;
		textureHeight = 32;

		meat = new ModelRenderer(this, "meat");

		setTextureOffset("meat.middle", 0, 0);
		setTextureOffset("meat.boneW", 0, 6);
		setTextureOffset("meat.boneEndW1", 0, 8);
		setTextureOffset("meat.boneEndW2", 0, 8);
		setTextureOffset("meat.boneE", 0, 6);
		setTextureOffset("meat.boneEndE1", 0, 8);
		setTextureOffset("meat.boneEndE2", 0, 8);

		meat.addBox("middle", 5, -1.5f, -1.5f, 6, 3, 3);
		meat.addBox("boneW", 2, -0.5f, -0.5f, 3, 1, 1);
		meat.addBox("boneEndW1", 1, -0.5f, -1.5f, 1, 1, 1);
		meat.addBox("boneEndW2", 1, -0.5f, 0.5f, 1, 1, 1);
		meat.addBox("boneE", 11, -0.5f, -0.5f, 3, 1, 1);
		meat.addBox("boneEndE1", 14, -0.5f, -1.5f, 1, 1, 1);
		meat.addBox("boneEndE2", 14, -0.5f, 0.5f, 1, 1, 1);
	}

	public void render()
	{
		meat.render(1f / 16f);
	}

	public void rotateX(float radians)
	{
		meat.rotateAngleX = radians;
	}
}
