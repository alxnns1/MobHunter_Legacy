package com.alxnns1.mobhunter.util;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.handler.EnumGuiID;
import com.alxnns1.mobhunter.message.MessageGuiQuest;
import com.alxnns1.mobhunter.message.MessageCapability;
import com.alxnns1.mobhunter.message.MessageSetQuest;
import com.alxnns1.mobhunter.reference.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import java.util.regex.Matcher;

/**
 * This class will contain methods which will get used in multiple places
 * Created by Mark on 21/04/2016.
 */
public class CommonUtil
{
    public static SimpleNetworkWrapper NETWORK;
    private static int messageID = 1;

    public static void initNetwork()
    {
        NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
        NETWORK.registerMessage(MessageCapability.Handler.class, MessageCapability.class, messageID++, Side.CLIENT);
        NETWORK.registerMessage(MessageGuiQuest.Handler.class, MessageGuiQuest.class, messageID++, Side.SERVER);
        NETWORK.registerMessage(MessageSetQuest.Handler.class, MessageSetQuest.class, messageID++, Side.SERVER);
    }

    /**
     * Copied from EntityLivingBase due to it being private.
     * Determines whether the entity can block the damage source based on the damage source's location, whether the
     * damage source is blockable, and whether the entity is blocking.
     */
    public static boolean canBlockDamageSource(EntityLivingBase entity, DamageSource damageSourceIn)
    {
        if (!damageSourceIn.isUnblockable() && entity.isActiveItemStackBlocking())
        {
            Vec3d vec3d = damageSourceIn.getDamageLocation();

            if (vec3d != null)
            {
                Vec3d vec3d1 = entity.getLook(1.0F);
                Vec3d vec3d2 = vec3d.subtractReverse(new Vec3d(entity.posX, entity.posY, entity.posZ)).normalize();
                vec3d2 = new Vec3d(vec3d2.xCoord, 0.0D, vec3d2.zCoord);

                if (vec3d2.dotProduct(vec3d1) < 0.0D)
                {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Open a GUI for a block (Uses a guiID of -1).
     */
    public static void openGui(EntityPlayer player, World world, BlockPos pos)
    {
        player.openGui(MobHunter.instance, -1, world, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * Open a GUI for an item (Uses the position of the player).
     */
    public static void openGui(EntityPlayer player, World world, EnumGuiID guiID)
    {
        openGui(player, world, guiID.ordinal());
    }

    /**
     * Open a GUI for an item (Uses the position of the player).
     */
    public static void openGui(EntityPlayer player, World world, int guiID)
    {
        BlockPos pos = player.getPosition();
        player.openGui(MobHunter.instance, guiID, world, pos.getX(), pos.getY(), pos.getZ());
    }

    /**
     * This method will replace all commas (',') with new line markers ('\n').
     * Mainly for converting a text comma separated list to a vertical list where each value is on it's own line.
     */
    public static String replaceCommasWithNewlines(String text, boolean addSpaceAroundNewlines)
    {
        return text.replaceAll(", ", addSpaceAroundNewlines ? " \n " : "\n");
    }

    /**
     * Gets the velocity of the given Entity.
     */
    public static double getEntityVelocity(Entity entity)
    {
        return Math.sqrt(Math.pow(entity.motionX, 2) + Math.pow(entity.motionY, 2) + Math.pow(entity.motionZ, 2));
    }
}
