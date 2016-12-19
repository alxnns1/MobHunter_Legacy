package com.alxnns1.mobhunter.entity.spits;

import com.alxnns1.mobhunter.util.LogHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.registry.IRenderFactory;

/**
 * Created by Mark on 07/12/2016.
 */
public class RenderSpit extends RenderSnowball<EntitySpit>
{
    public static final Factory FACTORY_POISON = new Factory(new ItemStack(Items.CHORUS_FRUIT_POPPED));
    public static final Factory FACTORY_ICE = new Factory(new ItemStack(Items.SNOWBALL));

    private ItemStack itemToRender;

    public RenderSpit(RenderManager renderManager, ItemStack item, RenderItem itemRenderer)
    {
        super(renderManager, item.getItem(), itemRenderer);
        itemToRender = item;
    }

    @Override
    public ItemStack getStackToRender(EntitySpit entityIn)
    {
        LogHelper.info("Getting item to render: " + (itemToRender == null ? "NULL" : itemToRender.toString()));
        return itemToRender;
    }

    public static class Factory implements IRenderFactory<EntitySpit>
    {
        private final ItemStack item;

        public Factory()
        {
            item = new ItemStack(Items.SNOWBALL);
        }

        public Factory(ItemStack item)
        {
            this.item = item;
        }

        @Override
        public Render<? super EntitySpit> createRenderFor(RenderManager manager)
        {
            return new RenderSpit(manager, item, Minecraft.getMinecraft().getRenderItem());
        }
    }
}
