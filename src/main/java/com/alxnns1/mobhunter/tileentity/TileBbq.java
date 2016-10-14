package com.alxnns1.mobhunter.tileentity;

import com.alxnns1.mobhunter.init.MHItems;
import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.EnumSkyBlock;

/**
 * Created by Mark on 26/04/2016.
 */
public class TileBbq extends TileEntity implements ITickable
{
    private int cookTime = 0;
    private int rotationAngles = 64;
    private int RARE_TIME = 120; //6 secs
    private int DONE_TIME = 180; //9 secs
    private int BURN_TIME = 200; //10 secs
    private boolean isCooking = false;

    //These are just used as keys for the NBT saving/reading
    private String KEY_TIME = "cookTime";
    private String KEY_COOKING = "cooking";

    public TileBbq() {}

    public boolean isCooking()
    {
        return isCooking;
    }

    /**
     * If not already cooking, will start the cooking of a piece of raw meat.
     * @return If a new cooking process has started.
     */
    public boolean putRawMeat()
    {
        if(!isCooking)
        {
            isCooking = true;
            return true;
        }
        else
            return false;
    }

    /**
     * Gets the meat at the current cooking time.
     * This is ONLY used to see the item. Use retrieveItem() to take the item out.
     * @return
     */
    public Item getMeat()
    {
        //If not cooking, then return null
        if(!isCooking)
            return null;
        //If cooking, then return relevant item
        if(cookTime < RARE_TIME)
            return MHItems.itemRawMeat;
        else if(cookTime < DONE_TIME)
            return MHItems.itemRareSteak;
        else if(cookTime < BURN_TIME)
            return MHItems.itemDoneSteak;
        else
            return MHItems.itemBurntMeat;
    }

    /**
     * Gets an integer referring to the stage of cooking. Used for the renderer.
     * @return Cooking stage
     */
    public int getCookingStage()
    {
        Item item = getMeat();
        if(item == null || item.equals(MHItems.itemRawMeat))
            return 0;
        else if(item.equals(MHItems.itemRareSteak))
            return 1;
        else if(item.equals(MHItems.itemDoneSteak))
            return 2;
        else if(item.equals(MHItems.itemBurntMeat))
            return 3;
        else
            return 0;
    }

    /**
     * Gets the rotation for the meat render in radians.
     * @return Angle in radians
     */
    public float getMeatRotation()
    {
        return (((float)cookTime % (float)rotationAngles) / (float)rotationAngles) * 360f;
    }

    /**
     * Gets the meat from the bbq at whatever stage of cooking it's at.
     * @return
     */
    public Item retrieveItem()
    {
        Item product = getMeat();
        isCooking = false;
        cookTime = 0;
        return product;
    }

    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        isCooking = tag.getBoolean(KEY_COOKING);
        cookTime = tag.getInteger(KEY_TIME);
    }

    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setBoolean(KEY_COOKING, isCooking);
        tag.setInteger(KEY_TIME, cookTime);
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
        if(isCooking)
            //Increase time meat has been cooking for
            cookTime++;
    }
}
