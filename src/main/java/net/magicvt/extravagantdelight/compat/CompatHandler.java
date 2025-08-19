package net.magicvt.extravagantdelight.compat;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.eventbus.api.IEventBus;

public class CompatHandler {
    public static void init(IEventBus modEventBus) {

        if (ModList.get().isLoaded("neapolitan")) {
            NeapolitanCompat.init(modEventBus);
        }
        if (ModList.get().isLoaded("hearthandharvest")) {
            HearthAndHarvestCompat.init(modEventBus);
        }
        if (ModList.get().isLoaded("brewinandchewin")) {
            BrewinAndChewinCompat.init(modEventBus);
        }
    }
}
