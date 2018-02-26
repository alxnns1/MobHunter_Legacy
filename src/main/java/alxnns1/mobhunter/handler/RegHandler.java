package alxnns1.mobhunter.handler;

import alxnns1.mobhunter.MobHunter;
import alxnns1.mobhunter.init.MHItems;
import alxnns1.mobhunter.item.ISubTypes;
import alxnns1.mobhunter.util.ClientUtil;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
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
        MHItems.getItems().forEach(registry::register);
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

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void regModels(ModelRegistryEvent event)
    {
        MHItems.getItems().forEach(item ->
        {
            if(item instanceof ISubTypes && item.getHasSubtypes())
                for(int meta = 0; meta < ((ISubTypes) item).getSubNames().length; meta++)
                    ClientUtil.regModel(item, meta);
            else
                ClientUtil.regModel(item);
        });
    }
}
