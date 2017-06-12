package alxnns1.mobhunter.item;

import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.reference.MetaRef;
import alxnns1.mobhunter.reference.Names;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * Created by Alex on 30/11/2016.
 */
public class ItemMHGlutton extends ItemMHConsumable {
    private static ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

    static {
        drops.add(new ItemStack(Items.ARROW));
        drops.add(new ItemStack(Items.BLAZE_POWDER));
        drops.add(new ItemStack(Items.BLAZE_ROD));
        drops.add(new ItemStack(Items.BONE));
        drops.add(new ItemStack(Items.BOOK));
        drops.add(new ItemStack(Items.BOW));
        drops.add(new ItemStack(Items.BOWL));
        drops.add(new ItemStack(Items.BRICK));
        drops.add(new ItemStack(Items.BUCKET));
        drops.add(new ItemStack(Items.CLAY_BALL));
        drops.add(new ItemStack(Items.CLOCK));
        drops.add(new ItemStack(Items.COAL));
        drops.add(new ItemStack(Items.COMPASS));
        drops.add(new ItemStack(Items.DIAMOND));
        for(int i=0;i<16;i++)
            drops.add(new ItemStack(Items.DYE, 1, i));
        drops.add(new ItemStack(Items.EMERALD));
        drops.add(new ItemStack(Items.ENDER_EYE));
        drops.add(new ItemStack(Items.ENDER_PEARL));
        drops.add(new ItemStack(Items.EXPERIENCE_BOTTLE));
        drops.add(new ItemStack(Items.FEATHER));
        drops.add(new ItemStack(Items.FIRE_CHARGE));
        drops.add(new ItemStack(Items.FIREWORK_CHARGE));
        drops.add(new ItemStack(Items.FLINT));
        drops.add(new ItemStack(Items.FLINT_AND_STEEL));
        drops.add(new ItemStack(Items.GHAST_TEAR));
        drops.add(new ItemStack(Items.GLASS_BOTTLE));
        drops.add(new ItemStack(Items.GLOWSTONE_DUST));
        drops.add(new ItemStack(Items.GOLD_INGOT));
        drops.add(new ItemStack(Items.GOLD_NUGGET));
        drops.add(new ItemStack(Items.GUNPOWDER));
        drops.add(new ItemStack(Items.IRON_INGOT));
        drops.add(new ItemStack(Items.LEAD));
        drops.add(new ItemStack(Items.LEATHER));
        drops.add(new ItemStack(Items.MAGMA_CREAM));
        drops.add(new ItemStack(Items.NAME_TAG));
        drops.add(new ItemStack(Items.NETHERBRICK));
        drops.add(new ItemStack(Items.PAPER));
        drops.add(new ItemStack(Items.PRISMARINE_CRYSTALS));
        drops.add(new ItemStack(Items.PRISMARINE_SHARD));
        drops.add(new ItemStack(Items.QUARTZ));
        drops.add(new ItemStack(Items.RABBIT_HIDE));
        drops.add(new ItemStack(Items.REDSTONE));
        drops.add(new ItemStack(Items.SADDLE));
        drops.add(new ItemStack(Items.SHEARS));
        drops.add(new ItemStack(Items.SLIME_BALL));
        drops.add(new ItemStack(Items.SPECTRAL_ARROW));
        drops.add(new ItemStack(Items.STICK));
        drops.add(new ItemStack(Items.STRING));
        drops.add(new ItemStack(Items.WRITABLE_BOOK));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.BERRY, Names.Items.HUSKBERRY));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.BUG, Names.Items.INSECT_HUSK));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.CATALYST));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.WHETSTONE));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC, Names.Items.MINI_WHETSTONE));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_S));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_M));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_L));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MONSTER_BONE_PLUS));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.MYSTERY_BONE));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.UNKNOWN_SKULL));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.BRUTE_BONE));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.JUMBO_BONE));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.BEAST_DROP, Names.Items.SHARP_FANG));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.MISC_DROP, Names.Items.BONE_HUSK));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.EARTH_CRYSTAL));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.MACHALITE_INGOT));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.DRAGONITE_INGOT));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.GOSSAMITE_INGOT));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.LIGHT_CRYSTAL));
        drops.add(MetaRef.getStack(MetaRef.EnumItemType.ORE, Names.Items.ICE_CRYSTAL));
    }

    public ItemMHGlutton(int amount, float saturation, boolean isWolfFood, String itemName, String... subNames) {
        super(amount, saturation, isWolfFood, itemName, subNames);
    }

    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if(worldIn.isRemote) return;

        if(stack.getItem() == MHItems.itemGluttonTuna) {
            ItemStack drop = drops.get(worldIn.rand.nextInt(drops.size()));
            if(!player.inventory.addItemStackToInventory(drop))
                player.entityDropItem(drop, 0f);
        }else if(stack.getItem() == MHItems.itemGastronomeTuna) {
            for(int i=0;i<2;i++) {
                ItemStack drop = drops.get(worldIn.rand.nextInt(drops.size()));
                if(!player.inventory.addItemStackToInventory(drop))
                    player.entityDropItem(drop, 0f);
            }
        }
    }
}
