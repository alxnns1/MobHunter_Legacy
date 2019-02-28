package alxnns1.mobhunter.capability;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * Created by Mark on 10/04/2017.
 */
public interface ICapability extends INBTSerializable<NBTTagCompound>
{
	/**
	 * Gets the Capability key used when adding the capability to entities
	 */
	ResourceLocation getKey();

	/**
	 * Gets the a new capability provider for this capability
	 */
	ICapabilityProvider getProvider();

	/**
	 * Will send updates for all data in this capability
	 */
	void dataChanged(EntityPlayerMP player);
}
