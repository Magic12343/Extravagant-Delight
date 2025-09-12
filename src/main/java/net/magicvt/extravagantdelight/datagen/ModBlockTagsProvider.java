package net.magicvt.extravagantdelight.datagen;

import net.magicvt.extravagantdelight.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(PackOutput output,
                                CompletableFuture<HolderLookup.Provider> lookupProvider,
                                ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, "extravagantdelight", existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.STRIPPED_QUINCE_WOOD.get())
                .add(ModBlocks.QUINCE_LOG.get())
                .add(ModBlocks.QUINCE_WOOD.get())
                .add(ModBlocks.STRIPPED_QUINCE_LOG.get())
                .add(ModBlocks.QUINCE_PLANKS.get())
                .add(ModBlocks.QUINCE_STAIRS.get())
                .add(ModBlocks.QUINCE_SLAB.get())
                .add(ModBlocks.QUINCE_DOOR.get())
                .add(ModBlocks.QUINCE_TRAPDOOR.get())
                .add(ModBlocks.QUINCE_FENCE.get())
                .add(ModBlocks.QUINCE_FENCE_GATE.get())
                .add(ModBlocks.QUINCE_CABINET.get())
                .add(ModBlocks.QUINCE_BUTTON.get())
                .add(ModBlocks.STARFRUIT_CRATE.get())
                .add(ModBlocks.QUINCE_CRATE.get())
                .add(ModBlocks.SLOE_BERRIES_CRATE.get())
                .add(ModBlocks.QUINCE_PRESSURE_PLATE.get());
    }
}
