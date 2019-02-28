package alxnns1.mobhunter.potion;

import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * Created by Mark on 01/06/2016.
 */

/**
 * This class is used to
 */
public class PotionNoRender extends Potion
{
	public PotionNoRender(boolean badEffect, int potionColor)
	{
		super(badEffect, potionColor);
	}

	/**
	 * If the Potion effect should be displayed in the players inventory
	 *
	 * @param effect the active PotionEffect
	 * @return true to display it (default), false to hide it.
	 */
	public boolean shouldRender(PotionEffect effect){ return false; }
}
