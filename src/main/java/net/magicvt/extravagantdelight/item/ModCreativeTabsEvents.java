package net.magicvt.extravagantdelight.item;

import net.magicvt.extravagantdelight.ExtravagantDelight;
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
                if (NTCompatBlocks.STRAWBERRY_PIPS_BAG.isPresent()) {
                    event.accept(NTCompatBlocks.STRAWBERRY_PIPS_BAG_ITEM.get());
                }
                if (NTCompatBlocks.MINT_SPROUTS_BAG.isPresent()) {
                    event.accept(NTCompatBlocks.MINT_SPROUTS_BAG_ITEM.get());
                }

            }


        }
    }
}

