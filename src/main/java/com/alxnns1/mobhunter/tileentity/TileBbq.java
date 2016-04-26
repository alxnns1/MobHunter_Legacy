package com.alxnns1.mobhunter.tileentity;

import com.alxnns1.mobhunter.init.MHItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by Mark on 26/04/2016.
 */
public class TileBbq extends TileEntity implements ITickable
{
    private int cookTime = 0;
    private int DONE_TIME = 100; //5 secs
    private int BURN_TIME = DONE_TIME + 20; //1 sec after done time
    private Item cookItem = null;


    public TileBbq() {}

    public void putRawMeat()
    {
        cookItem = MHItems.itemRawMeat;
        cookTime = 0;
    }

    public ItemStack getRawMeat()
    {
        if(cookTime < DONE_TIME)
            return new ItemStack(MHItems.itemRareSteak);
        else if(cookTime < BURN_TIME)
            return new ItemStack(MHItems.itemDoneSteak);
        else
            return new ItemStack(Items.coal, 1, 1);
    }

    public void readFromNBT(NBTTagCompound tag)
    {

    }

    public void writeToNBT(NBTTagCompound tag)
    {

    }

    /**
     * Use this to send data about the block. In this case, the NBTTagCompound.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new S35PacketUpdateTileEntity(pos, 0, nbt);
    }

    /**
     * Use this to update the block when a packet is received.
     */
    public void onDataPacket(net.minecraft.network.NetworkManager net, net.minecraft.network.play.server.S35PacketUpdateTileEntity pkt)
    {
        readFromNBT(pkt.getNbtCompound());
    }

    @Override
    public void update()
    {

    }
}
