package alxnns1.mobhunter.item;

import alxnns1.mobhunter.block.EnumBarrel;
import alxnns1.mobhunter.entity.EntityBarrelBomb;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

/**
 * Created by Mark on 07/04/2017.
 */
//TODO: This needs to be a metadata item
public class ItemBlockBarrelBomb extends ItemBlock
{
    public ItemBlockBarrelBomb(Block block)
    {
        super(block);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return super.getUnlocalizedName() + "." + EnumBarrel.getName(stack.getMetadata());
    }

    @Override
    public int getMetadata(int metadata)
    {
        return metadata;
    }

    /**
     * Returns the action that specifies what animation to play when the items is being used
     */
    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }

    /**
     * How long it takes to use or consume an item
     */
    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    /**
     * Called when the player stops using an Item (stops holding the right mouse button).
     */
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if(!(entityLiving instanceof EntityPlayer) || worldIn.isRemote) return;
        EntityPlayer player = (EntityPlayer) entityLiving;

        int timeHeld = getMaxItemUseDuration(stack) - timeLeft;
        if(timeHeld < 5) return;
        float bombVel = Math.min((float) timeHeld / 20f, 1f);

        EntityBarrelBomb bomb = new EntityBarrelBomb(worldIn, player, bombVel);
        worldIn.spawnEntity(bomb);
        worldIn.playSound(null, bomb.posX, bomb.posY, bomb.posZ, SoundEvents.ENTITY_TNT_PRIMED, SoundCategory.BLOCKS, 1.0F, 1.0F);
        if(!player.capabilities.isCreativeMode)
        {
            player.getCooldownTracker().setCooldown(this, 40);
            stack.shrink(1);
        }
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        //If small barrel bomb
        if(playerIn.getHeldItem(hand).getMetadata() == 0)
        {
            playerIn.setActiveHand(hand);
            return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
        }
        return super.onItemRightClick(worldIn, playerIn, hand);
    }
}
