package com.alxnns1.mobhunter.item;

import com.alxnns1.mobhunter.MobHunter;
import com.alxnns1.mobhunter.block.BlockCrop;
import com.alxnns1.mobhunter.init.MHBlocks;
import com.alxnns1.mobhunter.potion.PotionEffectParalyse;
import com.alxnns1.mobhunter.reference.MetaRef;
import com.alxnns1.mobhunter.reference.Names;
import com.alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.List;

/**
 * Created by Alex on 26/04/2016.
 */
public class ItemMHConsumable extends ItemFood implements ISubTypes<ItemMHConsumable>, net.minecraftforge.common.IPlantable
{
    protected final int effectDuration = 200;
    private int eatDuration = this.itemUseDuration;
    public static int EAT_DURATION_SHORT = 8;
    protected String[] subNames;
    public String type;

    public ItemMHConsumable(String itemName, String... subNames)
    {
        this(true, EAT_DURATION_SHORT, itemName, subNames);
    }

    public ItemMHConsumable(boolean alwaysEdible, int eatingDuration, String itemName, String... subNames)
    {
        this(0, 0, false, itemName, subNames);
        if(alwaysEdible) setAlwaysEdible();
        eatDuration = eatingDuration;
    }

    public ItemMHConsumable(int amount, float saturation, boolean isWolfFood, String itemName, String... subNames)
    {
        super(amount, saturation, isWolfFood);
        setCreativeTab(MobHunter.MH_TAB);
        this.type = itemName;
        setUnlocalizedName(itemName);
        setRegistryName(itemName);
        setHasSubtypes(subNames != null && subNames.length > 0);
        this.subNames = hasSubtypes ? subNames : null;
    }

    public BlockCrop getBlockCrop(ItemStack stack){

        String[] itemNameSplit = stack.getUnlocalizedName().split("\\W");
        String itemName = itemNameSplit[itemNameSplit.length-1];

        if(itemName.equals(Names.Items.HERB)){
            return MHBlocks.blockCropHerb;
        }else if(itemName.equals(Names.Items.ANTIDOTE_HERB)){
            return MHBlocks.blockCropAntidoteHerb;
        }else if(itemName.equals(Names.Items.FIRE_HERB)){
            return MHBlocks.blockCropFireHerb;
        }else if(itemName.equals(Names.Items.IVY)){
            return MHBlocks.blockCropIvy;
        }else if(itemName.equals(Names.Items.SLEEP_HERB)){
            return MHBlocks.blockCropSleepHerb;
        }else if(itemName.equals(Names.Items.SAP_PLANT)){
            return MHBlocks.blockCropSapPlant;
        }else if(itemName.equals(Names.Items.FELVINE)){
            return MHBlocks.blockCropFelvine;
        }else if(itemName.equals(Names.Items.GLOAMGRASS_BUD) || itemName.equals(Names.Items.GLOAMGRASS_ROOT)){
            return MHBlocks.blockCropGloamgrass;
        }else if(itemName.equals(Names.Items.HOT_PEPPER)){
            return MHBlocks.blockCropHotPepper;
        }else if(itemName.equals(Names.Items.BLUE_MUSHROOM)){
            return MHBlocks.blockCropBlueMushroom;
        }else if(itemName.equals(Names.Items.NITROSHROOM)){
            return MHBlocks.blockCropNitroshroom;
        }else if(itemName.equals(Names.Items.PARASHROOM)){
            return MHBlocks.blockCropParashroom;
        }else if(itemName.equals(Names.Items.TOADSTOOL)){
            return MHBlocks.blockCropToadstool;
        }else if(itemName.equals(Names.Items.EXCITESHROOM)){
            return MHBlocks.blockCropExciteshroom;
        }else if(itemName.equals(Names.Items.MOPESHROOM)){
            return MHBlocks.blockCropMopeshroom;
        }else if(itemName.equals(Names.Items.DRAGON_TOADSTOOL)){
            return MHBlocks.blockCropDragonToadstool;
        }else if(itemName.equals(Names.Items.PAINTBERRY)){
            return MHBlocks.blockCropPaintberry;
        }else if(itemName.equals(Names.Items.MIGHT_SEED)){
            return MHBlocks.blockCropMightSeed;
        }else if(itemName.equals(Names.Items.ADAMANT_SEED)){
            return MHBlocks.blockCropAdamantSeed;
        }else if(itemName.equals(Names.Items.NULBERRY)){
            return MHBlocks.blockCropNulberry;
        }else if(itemName.equals(Names.Items.DRAGONFELL_BERRY)){
            return MHBlocks.blockCropDragonfellBerry;
        }else if(itemName.equals(Names.Items.SCATTERNUT)){
            return MHBlocks.blockCropScatternut;
        }else if(itemName.equals(Names.Items.NEEDLEBERRY)){
            return MHBlocks.blockCropNeedleberry;
        }else if(itemName.equals(Names.Items.LATCHBERRY)){
            return MHBlocks.blockCropLatchberry;
        }else if(itemName.equals(Names.Items.BOMBERRY)){
            return MHBlocks.blockCropBomberry;
        }else {
            return null;
        }
    }

    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return eatDuration;
    }

    public void setMaxItemUseDuration(int duration)
    {
        eatDuration = duration;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if(itemStackIn.isItemEqual(MetaRef.getStack(MetaRef.EnumItemType.PLANT, Names.Items.HERB)))
        {
            if(playerIn.shouldHeal())
                super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);
        }
        else
            super.onItemRightClick(itemStackIn, worldIn, playerIn, hand);

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemStackIn);
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        //Only want to run on the server
        if(worldIn.isRemote) return;

        //All consumables heal 1 hunger
        player.getFoodStats().addStats(1,0);

        String[] itemNameSplit = stack.getUnlocalizedName().split("\\W");
        String itemName = itemNameSplit[itemNameSplit.length-1];

        if(itemName.equals(Names.Items.HERB))
            player.heal(2f);
        else if(itemName.equals(Names.Items.NULBERRY) && player.getActivePotionEffects().size() > 0)
        {
            Collection<PotionEffect> effects = player.getActivePotionEffects();
            int rand = itemRand.nextInt(effects.size());
            int i = 0;
            for(PotionEffect effect : effects)
            {
                if(i == rand)
                {
                    player.removePotionEffect(effect.getPotion());
                    break;
                }
                i++;
            }
        }
        else if(itemRand.nextFloat() < 0.5f)
        {
            //HERBS
            if(itemName.equals(Names.Items.ANTIDOTE_HERB)) {
                if(player.isPotionActive(MobEffects.POISON))
                    player.removePotionEffect(MobEffects.POISON);
            }
            else if(itemName.equals(Names.Items.FIRE_HERB))
                player.setFire(effectDuration / 20);
            else if(itemName.equals(Names.Items.SLEEP_HERB))
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, effectDuration));
            else if(itemName.equals(Names.Items.SAP_PLANT)){
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, effectDuration/2));
                player.addPotionEffect(new PotionEffect(MobEffects.SLOWNESS, effectDuration/2));
            }
            else if(itemName.equals(Names.Items.GLOAMGRASS_BUD))
                player.heal(1f);
            else if(itemName.equals(Names.Items.HOT_PEPPER)) {
                player.setFire(effectDuration / 20);
            }//SHROOMS
            else if(itemName.equals(Names.Items.NITROSHROOM))
                player.addPotionEffect(new PotionEffect(MobEffects.SPEED, effectDuration));
            else if(itemName.equals(Names.Items.PARASHROOM))
                player.addPotionEffect(new PotionEffectParalyse(effectDuration));
            else if(itemName.equals(Names.Items.TOADSTOOL))
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, effectDuration));
            else if(itemName.equals(Names.Items.EXCITESHROOM))
                player.getFoodStats().addStats(1,0);
            else if(itemName.equals(Names.Items.MOPESHROOM))
                player.getFoodStats().addStats(-3,0);
            else if(itemName.equals(Names.Items.DRAGON_TOADSTOOL)) {
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, effectDuration));
            }//BERRIES
            else if(itemName.equals(Names.Items.HUSKBERRY))
                player.getFoodStats().addStats(-1,0);
            else if(itemName.equals(Names.Items.PAINTBERRY))
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, effectDuration));
            else if(itemName.equals(Names.Items.MIGHT_SEED))
                player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, effectDuration));
            else if(itemName.equals(Names.Items.ADAMANT_SEED))
                player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, effectDuration));
            else if(itemName.equals(Names.Items.DRAGONFELL_BERRY))
                player.addPotionEffect(new PotionEffect(MobEffects.WEAKNESS, effectDuration));
            else if(itemName.equals(Names.Items.SCATTERNUT))
                player.attackEntityFrom(DamageSource.generic, 1);
            else if(itemName.equals(Names.Items.NEEDLEBERRY))
                player.attackEntityFrom(DamageSource.generic, 2);
            else if(itemName.equals(Names.Items.BOMBERRY)) {
                double rotation = Math.toRadians(player.getRotationYawHead());
                double xLook = -Math.sin(rotation);
                double zLook = Math.cos(rotation);
                worldIn.createExplosion(null, player.posX + xLook, player.posY, player.posZ + zLook, 0.5f, true);
            }//BUGS
            else if(itemName.equals(Names.Items.INSECT_HUSK))
                player.getFoodStats().addStats(-1,0);
            else if(itemName.equals(Names.Items.STINKHOPPER))
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, effectDuration));
            else if(itemName.equals(Names.Items.BITTERBUG)) {
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, effectDuration));
                if(player.isPotionActive(MobEffects.POISON))
                    player.removePotionEffect(MobEffects.POISON);
            }
            else if(itemName.equals(Names.Items.FLASHBUG))
                player.addPotionEffect(new PotionEffect(MobEffects.BLINDNESS, effectDuration));
            else if(itemName.equals(Names.Items.THUNDERBUG))
                player.addPotionEffect(new PotionEffectParalyse(effectDuration));
            else if(itemName.equals(Names.Items.GLUEGLOPPER))
                player.addPotionEffect(new PotionEffect(MobEffects.NAUSEA, effectDuration));
            else if(itemName.equals(Names.Items.FULGURBUG))
                player.addPotionEffect(new PotionEffectParalyse(effectDuration));
        }
    }

    @Override
    public String[] getSubNames()
    {
        return subNames;
    }

    @Override
    public ItemMHConsumable addToMetaRef(MetaRef.EnumItemType itemType)
    {
        MetaRef.addMetaTo(itemType, subNames);
        return this;
    }

    /**
     * Returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
        if(hasSubtypes)
            for(int i = 0; i < getSubNames().length; i++)
                subItems.add(new ItemStack(itemIn, 1, i));
        else
            subItems.add(new ItemStack(itemIn));
    }

    /**
     * Called when a Block is right-clicked with this Item
     */
    public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        net.minecraft.block.state.IBlockState state = worldIn.getBlockState(pos);
        if (facing == EnumFacing.UP && playerIn.canPlayerEdit(pos.offset(facing), facing, stack) && worldIn.isAirBlock(pos.up())) {
            if (state.getBlock()==Blocks.FARMLAND && (((ItemMHConsumable) stack.getItem()).type=="plant" || ((ItemMHConsumable) stack.getItem()).type=="berry")) {
                worldIn.setBlockState(pos.up(), this.getBlockCrop(stack).getDefaultState());
                --stack.stackSize;
                return EnumActionResult.SUCCESS;
            }else if ((state.getBlock()==Blocks.MYCELIUM || state.getBlock()==Blocks.LOG || state.getBlock()==Blocks.LOG2) && ((ItemMHConsumable) stack.getItem()).type=="mushroom") {
                worldIn.setBlockState(pos.up(), this.getBlockCrop(stack).getDefaultState());
                --stack.stackSize;
                return EnumActionResult.SUCCESS;
            } else {
                return EnumActionResult.FAIL;
            }
        } else {
            return EnumActionResult.FAIL;
        }
    }

    @Override
    public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
        return null;
    }

    @Override
    public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
        return null;
    }

    /**
     * Returns the unlocalized name of this item. This version accepts an ItemStack so different stacks can have
     * different names based on their damage or NBT.
     */
    public String getUnlocalizedName(ItemStack stack)
    {
        if(hasSubtypes)
            return super.getUnlocalizedName(stack) + "." + getSubNames()[stack.getMetadata()];
        return super.getUnlocalizedName(stack);
    }

    /**
     * Allows items to add custom lines of information to the mouseover description
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
        ClientUtil.addTooltip(stack, tooltip);
    }
}
