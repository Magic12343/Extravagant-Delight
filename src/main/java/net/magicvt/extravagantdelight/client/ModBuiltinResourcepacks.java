package net.magicvt.extravagantdelight.client;

import com.mojang.logging.LogUtils;
import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forgespi.locating.IModFile;
import org.slf4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;

@Mod.EventBusSubscriber(modid = ExtravagantDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ModBuiltinResourcepacks {
    private static final Logger LOGGER = LogUtils.getLogger();

    @SubscribeEvent
    public static void onAddPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() != PackType.CLIENT_RESOURCES) return;

        ModList.get().getModContainerById(ExtravagantDelight.MOD_ID).ifPresent(container -> {
            IModFile modFile = container.getModInfo().getOwningFile().getFile();

            Path packRoot = modFile.findResource("resourcepacks/extravagant_coasters");
            if (!Files.exists(packRoot)) {
                LOGGER.warn("Resource pack not found in {}", packRoot);
                return;
            }

            event.addRepositorySource(consumer -> {
                Pack pack = Pack.readMetaAndCreate(
                        "extravagant_coasters",                        
                        Component.literal("Extravagant Coasters"),    
                        false,                                          
                        id -> new PathPackResources(id, packRoot, false),
                        event.getPackType(),
                        Pack.Position.TOP,
                        PackSource.BUILT_IN
                );
                if (pack != null) {
                    consumer.accept(pack);
                    LOGGER.info("'extravagant_coasters' registered.");
                } else {
                    LOGGER.error("Error in Pack.mcmeta.");
                }
            });
        });
    }
}
