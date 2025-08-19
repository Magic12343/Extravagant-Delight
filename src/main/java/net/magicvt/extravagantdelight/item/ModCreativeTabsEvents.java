package net.magicvt.extravagantdelight.item;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.compat.HHCompatBlocks;
import net.magicvt.extravagantdelight.compat.NTCompatBlocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ExtravagantDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModCreativeTabsEvents {

    @SubscribeEvent
    public static void buildCreativeTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModTabs.EXTRAVAGANTDELIGHT_TAB.get()) {

            if (ModList.get().isLoaded("neapolitan")) {
                if (NTCompatBlocks.STARFRUIT_ICE_CREAM.isPresent()) {
                    event.accept(NTCompatBlocks.STARFRUIT_ICE_CREAM.get());
                }
                if (NTCompatBlocks.QUINCE_ICE_CREAM.isPresent()) {
                    event.accept(NTCompatBlocks.QUINCE_ICE_CREAM.get());
                }
                if (NTCompatBlocks.SLOE_BERRY_ICE_CREAM.isPresent()) {
                    event.accept(NTCompatBlocks.SLOE_BERRY_ICE_CREAM.get());
                }

                if (NTCompatBlocks.STARFRUIT_MILKSHAKE.isPresent()) {
                    event.accept(NTCompatBlocks.STARFRUIT_MILKSHAKE.get());
                }
                if (NTCompatBlocks.QUINCE_MILKSHAKE.isPresent()) {
                    event.accept(NTCompatBlocks.QUINCE_MILKSHAKE.get());
                }
                if (NTCompatBlocks.SLOE_BERRY_MILKSHAKE.isPresent()) {
                    event.accept(NTCompatBlocks.SLOE_BERRY_MILKSHAKE.get());
                }

                if (NTCompatBlocks.STARFRUIT_ICE_CREAM_BLOCK_ITEM.isPresent()) {
                    event.accept(NTCompatBlocks.STARFRUIT_ICE_CREAM_BLOCK_ITEM.get());
                }
                if (NTCompatBlocks.QUINCE_ICE_CREAM_BLOCK_ITEM.isPresent()) {
                    event.accept(NTCompatBlocks.QUINCE_ICE_CREAM_BLOCK_ITEM.get());
                }
                if (NTCompatBlocks.SLOE_BERRY_ICE_CREAM_BLOCK_ITEM.isPresent()) {
                    event.accept(NTCompatBlocks.SLOE_BERRY_ICE_CREAM_BLOCK_ITEM.get());
                }
            }

            if (ModList.get().isLoaded("hearthandharvest")) {
                if (HHCompatBlocks.QUINCE_HALF_CABINET_ITEM.isPresent()) {
                    event.accept(HHCompatBlocks.QUINCE_HALF_CABINET_ITEM.get());
                }

                if (HHCompatBlocks.STARFRUIT_WINE.isPresent()) {
                    event.accept(HHCompatBlocks.STARFRUIT_WINE.get());
                }
                if (HHCompatBlocks.QUINCE_WINE.isPresent()) {
                    event.accept(HHCompatBlocks.QUINCE_WINE.get());
                }
                if (HHCompatBlocks.SLOE_BERRY_WINE.isPresent()) {
                    event.accept(HHCompatBlocks.SLOE_BERRY_WINE.get());
                }

                if (HHCompatBlocks.STARFRUIT_WINE_CRATE_ITEM.isPresent()) {
                    event.accept(HHCompatBlocks.STARFRUIT_WINE_CRATE_ITEM.get());
                }
                if (HHCompatBlocks.QUINCE_WINE_CRATE_ITEM.isPresent()) {
                    event.accept(HHCompatBlocks.QUINCE_WINE_CRATE_ITEM.get());
                }
                if (HHCompatBlocks.SLOE_BERRY_WINE_CRATE_ITEM.isPresent()) {
                    event.accept(HHCompatBlocks.SLOE_BERRY_WINE_CRATE_ITEM.get());
                }

            }


        }


        }
    }


