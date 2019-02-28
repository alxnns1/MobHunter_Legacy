package alxnns1.mobhunter.block;

import net.minecraft.util.IStringSerializable;

/**
 * Created by Mark on 05/04/2017.
 */
public enum EnumBarrel implements IStringSerializable
{
	SMALL,
	LARGE,
	BOUNCING;

	@Override
	public String getName()
	{
		return toString().toLowerCase();
	}

	public static String getName(int metadata)
	{
		return metadata < 0 || metadata >= values().length ? "invalid" : values()[metadata].getName();
	}
}
