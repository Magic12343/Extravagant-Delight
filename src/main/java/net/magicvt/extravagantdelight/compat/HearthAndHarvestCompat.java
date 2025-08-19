package net.magicvt.extravagantdelight.compat;

import net.minecraftforge.eventbus.api.IEventBus;

public class HearthAndHarvestCompat
{
    public static void init(IEventBus modEventBus) {
        HHCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Hearth and Harvest Compat loaded.");
    }
}
