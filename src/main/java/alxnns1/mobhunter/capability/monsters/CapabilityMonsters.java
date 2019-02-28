package alxnns1.mobhunter.capability.monsters;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.message.MessageCapability;
import alxnns1.mobhunter.util.CommonUtil;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 10/04/2017.
 */
public class CapabilityMonsters implements IMonsters
{
	private static final ResourceLocation monstersRL = new ResourceLocation(MobHunter.MOD_ID, "_Monsters");
	private List<MonsterSize> monsterSizes = new ArrayList<>();

	public CapabilityMonsters(){}

	@Override
	public List<MonsterSize> getAllMonsterSizes()
	{
		//Sort the list before getting it
		monsterSizes.sort((o1, o2) -> o1.entityID.compareToIgnoreCase(o2.entityID));
		return monsterSizes;
	}

	@Override
	public MonsterSize getMonsterSizes(String monsterID)
	{
		for(MonsterSize ms : monsterSizes)
			if(ms.isSameEntityName(monsterID))
				return ms;
		return null;
	}

	@Override
	public EnumSizeResult checkMonsterSize(String monsterID, float size)
	{
		MonsterSize ms = getMonsterSizes(monsterID);
		if(ms == null) return EnumSizeResult.NEW;
		return ms.checkSize(size);
	}

	@Override
	public void updateMonsterSize(String monsterID, float size)
	{
		MonsterSize ms = getMonsterSizes(monsterID);
		if(ms != null)
			ms.updateSizes(size);
		else
			monsterSizes.add(new MonsterSize(monsterID, size));
	}

	@Override
	public void dataChanged(EntityPlayerMP player)
	{
		dataChanged(player, null);
	}

	@Override
	public void dataChanged(EntityPlayerMP player, String monsterID)
	{
		NBTTagCompound tag = monsterID == null ? serializeNBT() : new NBTTagCompound();
		if(monsterID != null)
		{
			NBTTagList tagList = new NBTTagList();
			MonsterSize ms = getMonsterSizes(monsterID);
			if(ms != null) tagList.appendTag(ms.serializeNBT());
			tag.setTag("list", tagList);
		}
		CommonUtil.NETWORK.sendTo(new MessageCapability(MessageCapability.EnumCapability.MONSTERS, tag), player);
	}

	@Override
	public ResourceLocation getKey()
	{
		return monstersRL;
	}

	@Override
	public ICapabilityProvider getProvider()
	{
		return new CapabilityMonstersProvider();
	}

	@Override
	public NBTTagCompound serializeNBT()
	{
		NBTTagCompound tag = new NBTTagCompound();
		NBTTagList tagList = new NBTTagList();
		for(MonsterSize ms : monsterSizes)
			tagList.appendTag(ms.serializeNBT());
		tag.setTag("list", tagList);
		return tag;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt)
	{
		if(!nbt.hasKey("list")) return;
		NBTTagList tagList = nbt.getTagList("list", Constants.NBT.TAG_COMPOUND);
		monsterSizes.clear();
		for(int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = tagList.getCompoundTagAt(i);
			MonsterSize ms = new MonsterSize(tag);
			monsterSizes.add(ms);
		}
	}
}
