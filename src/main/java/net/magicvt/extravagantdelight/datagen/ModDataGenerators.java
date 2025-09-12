package net.magicvt.extravagantdelight.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.core.HolderLookup;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = "extravagantdelight", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModDataGenerators {

    @Mod.EventBusSubscriber(modid = "extravagantdelight", bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Events {
        public static void gatherData(GatherDataEvent event) {
            DataGenerator generator = event.getGenerator();
            PackOutput output = generator.getPackOutput();
            ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
            CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

            generator.addProvider(
                    event.includeServer(),
                    new ModBlockTagsProvider(output, lookupProvider, existingFileHelper)
            );
        }
    }
}
