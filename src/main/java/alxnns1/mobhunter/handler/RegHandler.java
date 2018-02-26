package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.MobHunter;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.IForgeRegistryEntry;
import net.minecraftforge.registries.RegistryBuilder;

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

    }

    @SubscribeEvent
    public static void regItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();

    }

    @SubscribeEvent
    public static void regBlocks(RegistryEvent.Register<Block> event)
    {
        IForgeRegistry<Block> registry = event.getRegistry();

    }

    @SubscribeEvent
    public static void regEntities(RegistryEvent.Register<EntityEntry> event)
    {
        IForgeRegistry<EntityEntry> registry = event.getRegistry();

    }

    @SubscribeEvent
    public static void regVanillaRecipes(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistry<IRecipe> registry = event.getRegistry();

    }
}
