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
                        pOutput.accept(new ItemStack(ModBlocks.STRIPPED_QUINCE_LOG.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_WOOD.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.STRIPPED_QUINCE_WOOD.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_PLANKS.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_STAIRS.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_SLAB.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_DOOR.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_TRAPDOOR.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_FENCE.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_FENCE_GATE.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_CABINET.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_BUTTON.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_PRESSURE_PLATE.get().asItem()));

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
                        pOutput.accept(new ItemStack(ModBlocks.WILD_SLOE_BERRIES.get().asItem()));

                        pOutput.accept(new ItemStack(ModBlocks.STARFRUIT_CRATE.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.QUINCE_CRATE.get().asItem()));
                        pOutput.accept(new ItemStack(ModBlocks.SLOE_BERRIES_CRATE.get().asItem()));

                        pOutput.accept(ModItems.STARFRUIT_JUICE.get());
                        pOutput.accept(ModItems.SLOE_BERRY_JUICE.get());

                        pOutput.accept(ModItems.STARFRUIT_JAM.get());
                        pOutput.accept(ModItems.QUINCE_JELLY.get());
                        pOutput.accept(ModItems.SLOE_BERRY_JELLY.get());

                        pOutput.accept(ModItems.STARFRUIT_POPSICLE.get());

                        pOutput.accept(ModItems.QUINCE_CANDY.get());

                        pOutput.accept(ModItems.STARFRUIT_MUFFIN.get());

                        pOutput.accept(ModItems.QUINCE_COOKIE.get());

                        pOutput.accept(ModItems.STARFRUIT_SLICE.get());

                        pOutput.accept(ModItems.BOILED_QUINCE.get());
                        pOutput.accept(ModItems.BOILED_QUINCE_PEEL.get());
                        pOutput.accept(ModItems.BOILED_QUINCE_PULP.get());
                        pOutput.accept(ModItems.BOILED_QUINCE_SEEDS.get());

                        pOutput.accept(new ItemStack(ModBlocks.STARFRUIT_CHEESECAKE.get().asItem()));
                        pOutput.accept(ModItems.STARFRUIT_CHEESECAKE_SLICE.get());
                        pOutput.accept(new ItemStack(ModBlocks.SWEET_QUINCE_TART.get().asItem()));
                        pOutput.accept(ModItems.SWEET_QUINCE_TART_SLICE.get());
                        pOutput.accept(new ItemStack(ModBlocks.SLOE_TREACLE_TART.get().asItem()));
                        pOutput.accept(ModItems.SLOE_TREACLE_TART_SLICE.get());

                        pOutput.accept(ModItems.STARFRUIT_SALAD.get());
                        pOutput.accept(ModItems.STARFRUIT_SALMON.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
