package alxnns1.mobhunter.init;

import alxnns1.mobhunter.potion.PotionMH;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.potion.Potion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mark on 01/06/2016.
 */
public class MHPotions
{
	private static Set<Potion> POTIONS = new HashSet<>();

	public static PotionMH potionParalyse;

	private static void reg(Potion potion)
	{
		POTIONS.add(potion);
	}

	private static void init()
	{
		reg(potionParalyse = new PotionMH(Names.Potions.PARALYSE, true, 0x000000, 0, 0));
	}

	public static Set<Potion> getPotions()
	{
		if(POTIONS.isEmpty()) init();
		return POTIONS;
	}
}
