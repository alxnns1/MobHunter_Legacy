package alxnns1.mobhunter.item;

import alxnns1.mobhunter.entity.EntitySpit;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

/**
 * Created by Mark on 07/12/2016.
 */
public class ItemMHDebug extends ItemMHBasic
{
    public ItemMHDebug()
    {
        super(Names.Items.DEBUG);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(!worldIn.isRemote)
        {
            EntitySpit entity = new EntitySpit(worldIn, playerIn, "debugSpit", 2f, 1f, new PotionEffect(MobEffects.GLOWING, 40));
            entity.setPosition(playerIn.posX, playerIn.posY + 1.5d, playerIn.posZ);
            entity.setItemToRender(new ItemStack(Items.ENDER_EYE));
            worldIn.spawnEntity(entity);
        }
        return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
    }
}
