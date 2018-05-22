package alxnns1.mobhunter.tileentity;

import alxnns1.mobhunter.init.MHItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

/**
 * Created by Mark on 26/04/2016.
 */
public class TileBbq extends TileEntity implements ITickable
{
    private static final int[] COOK_TIMES = new int[] {120, 180, 200}; //6, 9, 10 secs;
    private static final String KEY_TIME = "cookTime";
    private int cookTime = 0;
    private int rotationAngles = 64;

    public TileBbq() {}

    public boolean isValidInput(ItemStack input)
    {
        return input.getItem().equals(MHItems.itemRawMeat);
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
     */
    public ItemStack getResult()
    {
        //If not cooking, then return null
        if(isCooking())
        {
            switch(getCookingStage())
            {
                case 0: return new ItemStack(MHItems.itemRawMeat);
                case 1: return new ItemStack(MHItems.itemRareSteak);
                case 2: return getCookedMeat();
                case 3: return new ItemStack(MHItems.itemBurntMeat);
            }
        }
        return null;
    }

    /**
     * Returns the perfectly cooked meat ItemStack
     */
    protected ItemStack getCookedMeat()
    {
        return new ItemStack(MHItems.itemDoneSteak);
    }

    /**
     * Gets an integer referring to the stage of cooking. Used for the renderer.
     * @return Cooking stage
     */
    public int getCookingStage()
    {
        for(int i = 0; i < COOK_TIMES.length; i++)
            if(cookTime < COOK_TIMES[i])
                return i;
        return COOK_TIMES.length;
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

    @Override
    public void readFromNBT(NBTTagCompound tag)
    {
        super.readFromNBT(tag);
        cookTime = tag.getInteger(KEY_TIME);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag)
    {
        super.writeToNBT(tag);
        tag.setInteger(KEY_TIME, cookTime);
        return tag;
    }

    /**
     * Use this to send data about the block. In this case, the NBTTagCompound.
     */
    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        NBTTagCompound nbt = new NBTTagCompound();
        writeToNBT(nbt);
        return new SPacketUpdateTileEntity(pos, 0, nbt);
    }

    /**
     * Use this to update the block when a packet is received.
     */
    @Override
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
