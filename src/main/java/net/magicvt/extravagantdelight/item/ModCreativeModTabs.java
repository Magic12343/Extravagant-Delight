package net.magicvt.extravagantdelight.item;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ExtravagantDelight.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EXTRAVAGANTDELIGHT_TAB = CREATIVE_MODE_TABS.register("extravagantdelight_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.STARFRUIT.get()))
                    .title(Component.translatable("creativetab.extravagantdelight_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_LOG.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_LEAVES.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.FLOURISHING_QUINCE_LEAVES.get().asItem()));

                        pOutput.accept(ModItems.STARFRUIT.get());
                        pOutput.accept(ModItems.QUINCE.get());
                        pOutput.accept(ModItems.SLOE_BERRIES.get());

                        pOutput.accept(ModItems.STARFRUIT_SEEDS.get());
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_SEEDLING.get().asItem()));
                        pOutput.accept(ModItems.SLOE_BERRY_PIPS.get());

                        pOutput.accept(new ItemStack(ModBlocks.WILD_STARFRUIT.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.WILD_QUINCE.get().asItem()));

                        pOutput.accept(new ItemStack(ModBlocks.STARFRUIT_CRATE.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_CRATE.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.SLOE_BERRIES_CRATE.get().asItem()));

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
