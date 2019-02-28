package alxnns1.mobhunter;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * Created by bright_spark on 19/05/2018.
 */
public class MHTab extends CreativeTabs
{
	private final ItemStack stack;

	public MHTab(String label, ItemStack stack)
	{
		super(MobHunter.MOD_ID + "_" + label);
		this.stack = stack;
	}

	@Override
	public ItemStack getTabIconItem()
	{
		return stack;
	}
}
