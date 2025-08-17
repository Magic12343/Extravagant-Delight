package net.magicvt.extravagantdelight;

import net.magicvt.extravagantdelight.block.ModBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@EventBusSubscriber(modid = "extravagantdelight", bus = Bus.MOD, value = Dist.CLIENT)
public class ClientSetup {
    public static void onClientSetup(final FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.STARFRUIT_CROP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FLOURISHING_QUINCE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FRUIT_QUINCE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.QUINCE_LEAVES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.QUINCE_SEEDLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.QUINCE_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SLOE_BERRIES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_STARFRUIT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_QUINCE.get(), RenderType.cutout());
    }
}
