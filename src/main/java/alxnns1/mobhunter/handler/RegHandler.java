package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.block.render.RenderBbq;
import alxnns1.mobhunter.capability.quest.MHQuest;
import alxnns1.mobhunter.crafting.ArmourCraftingManager;
import alxnns1.mobhunter.crafting.ArmourCraftingRecipe;
import alxnns1.mobhunter.crafting.WeaponCraftingManager;
import alxnns1.mobhunter.crafting.WeaponCraftingRecipe;
import alxnns1.mobhunter.init.*;
import alxnns1.mobhunter.tileentity.TileBbq;
import alxnns1.mobhunter.tileentity.TileGourmetBBQ;
import alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

@Mod.EventBusSubscriber(modid = MobHunter.MOD_ID)
public class RegHandler
{
    private static <T extends IForgeRegistryEntry<T>> IForgeRegistry<T> addRegistry(String registryName, Class<T> type)
    {
        return new RegistryBuilder<T>()
                .setName(new ResourceLocation(MobHunter.MOD_ID, registryName))
                .setType(type)
                .disableSaving()
                .allowModification()
                .create();
    }

    @SubscribeEvent
    public static void regRegistry(RegistryEvent.NewRegistry event)
    {
        WeaponCraftingManager.REGISTRY = addRegistry("weapon_recipes", WeaponCraftingRecipe.class);
        ArmourCraftingManager.REGISTRY = addRegistry("armour_recipes", ArmourCraftingRecipe.class);
        MHQuests.REGISTRY = addRegistry("quests", MHQuest.class);
    }

    @SubscribeEvent
    public static void regItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        MHItems.getItems().forEach(registry::register);
        MHBlocks.getItemBlocks().forEach(registry::register);
    }

    @SubscribeEvent
    public static void regBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();
        MHBlocks.getBlocks().forEach(registry::register);
    }

    @SubscribeEvent
    public static void regEntities(RegistryEvent.Register<EntityEntry> event)
    {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();
        MHEntities.getEntities().forEach(registry::register);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void regModels(ModelRegistryEvent event)
    {
        MHItems.getItems().forEach(ClientUtil::regModel);
        MHBlocks.getBlocks().forEach(ClientUtil::regModel);
        ClientRegistry.bindTileEntitySpecialRenderer(TileBbq.class, new RenderBbq());
        ClientRegistry.bindTileEntitySpecialRenderer(TileGourmetBBQ.class, new RenderBbq());
        MHEntities.regRenders();
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void regItemColours(ColorHandlerEvent.Item event)
    {
        event.getItemColors().registerItemColorHandler(
                (stack, tintIndex) -> ColorizerGrass.getGrassColor(0.5D, 1.0D),
                MHBlocks.blockHerb, MHBlocks.blockBerry, MHBlocks.blockBug, MHBlocks.blockShroom);
    }

    @SubscribeEvent
    public static void regBlockColours(ColorHandlerEvent.Block event)
    {
        event.getBlockColors().registerBlockColorHandler(
                (state, worldIn, pos, tintIndex) -> worldIn != null && pos != null ? BiomeColorHelper.getGrassColorAtPos(worldIn, pos) : ColorizerGrass.getGrassColor(0.5D, 1.0D),
                MHBlocks.blockHerb, MHBlocks.blockBerry, MHBlocks.blockBug, MHBlocks.blockShroom);
    }

    @SubscribeEvent
    public static void regWeaponRecipes(RegistryEvent.Register<WeaponCraftingRecipe> event)
    {
        MHRecipes.regWeaponRecipes(event.getRegistry());
    }

    @SubscribeEvent
    public static void regArmourRecipes(RegistryEvent.Register<ArmourCraftingRecipe> event)
    {
        MHRecipes.regArmourRecipes(event.getRegistry());
    }

    @SubscribeEvent
    public static void regQuests(RegistryEvent.Register<MHQuest> event)
    {
        MHQuests.regQuests(event.getRegistry());
    }
}
