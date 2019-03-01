package alxnns1.mobhunter.potion;

import alxnns1.mobhunter.MobHunter;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Created by Mark on 01/06/2016.
 */
public class PotionMH extends Potion {
	public static ResourceLocation textures = new ResourceLocation(MobHunter.MOD_ID, MobHunter.GUI_TEXTURE_DIR + "effects.png");

	public PotionMH(String name, boolean badEffect, int potionColor, int iconIndexX, int iconIndexY) {
		super(badEffect, potionColor);
		setPotionName("effect." + name + ".name");
		setIconIndex(iconIndexX, iconIndexY);
		setRegistryName(name);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex() {
		//Sets the texture sheet to our effects sheet
		Minecraft.getMinecraft().renderEngine.bindTexture(textures);
		return super.getStatusIconIndex();
	}
}
