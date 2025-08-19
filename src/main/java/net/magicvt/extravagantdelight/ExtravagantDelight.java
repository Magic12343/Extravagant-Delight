package net.magicvt.extravagantdelight;

import com.mojang.logging.LogUtils;
import net.magicvt.extravagantdelight.block.ModBlocks;
import net.magicvt.extravagantdelight.compat.BCCompatFluids;
import net.magicvt.extravagantdelight.compat.CompatHandler;
import net.magicvt.extravagantdelight.compat.HHCompatFluids;
import net.magicvt.extravagantdelight.item.ModCreativeModTabs;
import net.magicvt.extravagantdelight.item.ModItems;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ExtravagantDelight.MOD_ID)
public class ExtravagantDelight {
    public static final String MOD_ID = "extravagantdelight";
    public static final Logger LOGGER = LogUtils.getLogger();


    public ExtravagantDelight() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        ModCreativeModTabs.register(modEventBus);
        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        HHCompatFluids.FLUID_TYPES.register(modEventBus);
        HHCompatFluids.FLUIDS.register(modEventBus);
        HHCompatFluids.registerCompat();
        BCCompatFluids.FLUID_TYPES.register(modEventBus);
        BCCompatFluids.FLUIDS.register(modEventBus);
        BCCompatFluids.registerCompat();

        CompatHandler.init(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModBlocks.STARFRUIT_CROP.get(), RenderType.cutout());
        }
    }
}
