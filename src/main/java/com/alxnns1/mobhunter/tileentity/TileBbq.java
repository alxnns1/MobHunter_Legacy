package com.alxnns1.mobhunter.tileentity;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by Mark on 26/04/2016.
 */
public class TileBbq extends TileEntity implements ITickable
{
    private int cookTime = 0;
    private int rotationAngles = 64;
    private final ItemStack[] cookResults;
    private final int[] cookTimes;

    //These are just used as keys for the NBT saving/reading
    private String KEY_TIME = "cookTime";

    public TileBbq(ItemStack[] cookResults, int[] cookTimes)
    {
        if(cookResults == null || cookResults.length <= 0 || cookTimes == null || cookTimes.length <= 0 || cookResults.length - 1 != cookTimes.length)
            throw new IllegalArgumentException("Input arrays must not be empty and cookResults' length should be 1 greater than the cookTimes' length.");
        this.cookResults = cookResults;
        this.cookTimes = cookTimes;
    }

    public boolean isValidInput(ItemStack input)
    {
        return input.isItemEqual(cookResults[0]);
    }

    public boolean isCooking()
    {
        return cookTime > 0;
    }

    /**
     * If not already cooking, will start the cooking of the input item.
     * @return If a new cooking process has started.
     */
    public boolean putInputItem()
    {
        if(!isCooking())
        {
            cookTime++;
            return true;
        }
        else
            return false;
    }

    /**
     * Gets the meat at the current cooking time.
     * This is ONLY used to see the item. Use retrieveResult() to take the item out.
     * @return
     */
    public ItemStack getResult()
    {
        //If not cooking, then return null
        return isCooking() ? cookResults[getCookingStage()].copy() : null;
    }

    /**
     * Gets an integer referring to the stage of cooking. Used for the renderer.
     * @return Cooking stage
     */
    public int getCookingStage()
    {
        for(int i = 0; i < cookTimes.length; i++)
            if(cookTime < cookTimes[i])
                return i;
        return cookTimes.length;
    }

    /**
     * Gets the rotation for the meat render in radians.
     * @return Angle in radians
     */
    public float getCookRotation()
    {
        return (((float)cookTime % (float)rotationAngles) / (float)rotationAngles) * 360f;
    }

    /**
     * Gets the meat from the bbq at whatever stage of cooking it's at.
     * @return
     */
    public ItemStack retrieveResult()
    {
        ItemStack product = getResult();
        cookTime = 0;
        return product;
    }

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        cookTime = tag.getInteger(KEY_TIME);
        //TODO: Read cook times and results
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger(KEY_TIME, cookTime);
        //TODO: Save cook times and results
        return tag;
    }

    /**
     * Use this to send data about the block. In this case, the NBTTagCompound.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new SPacketUpdateTileEntity(pos, 0, nbt);
    }

    /**
     * Use this to update the block when a packet is received.
     */
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.SPacketUpdateTileEntity pkt)
    {
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void update()
    {
        if(isCooking())
            //Increase time item has been cooking for
            cookTime++;
    }
}
