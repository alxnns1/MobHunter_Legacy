package alxnns1.mobhunter.capability.monsters;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.INBTSerializable;

/**
 * Created by Mark on 10/04/2017.
 */
public class MonsterSize implements INBTSerializable<NBTTagCompound>
{
    public String entityID;
    public float smallest, largest;

    public MonsterSize(String entityID, float size)
    {
        this(entityID, size, size);
    }

    public MonsterSize(String entityID, float smallest, float largest)
    {
        this.entityID = entityID;
        this.smallest = smallest;
        this.largest = largest;
    }

    public MonsterSize(NBTTagCompound nbt)
    {
        deserializeNBT(nbt);
    }

    public String getEntityUnlocName()
    {
        return "entity." + entityID + ".name";
    }

    public boolean isSameEntityName(String name)
    {
        if(entityID.equalsIgnoreCase(name))
            return true;
        String[] namesSplit = entityID.split("\\.");
        String nameID = namesSplit.length == 1 ? namesSplit[0] : namesSplit[namesSplit.length-1];
        if(nameID.equalsIgnoreCase(name))
            return true;
        return false;
    }

    public void updateSizes(float size)
    {
        if(size < smallest) smallest = size;
        if(size > largest) largest = size;
    }

    public EnumSizeResult checkSize(float size)
    {
        if(size < smallest)
            return EnumSizeResult.SMALLEST;
        if(size > largest)
            return EnumSizeResult.LARGEST;
        return EnumSizeResult.NONE;
    }

    @Override
    public NBTTagCompound serializeNBT()
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("name", entityID);
        tag.setFloat("small", smallest);
        tag.setFloat("large", largest);
        return tag;
    }

    @Override
    public void deserializeNBT(NBTTagCompound nbt)
    {
        entityID = nbt.getString("name");
        smallest = nbt.getFloat("small");
        largest = nbt.getFloat("large");
    }
}
