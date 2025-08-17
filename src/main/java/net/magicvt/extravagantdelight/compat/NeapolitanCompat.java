package net.magicvt.extravagantdelight.compat;

import net.minecraftforge.eventbus.api.IEventBus;

public class NeapolitanCompat
{
    public static void init(IEventBus modEventBus) {
        NTCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Neapolitan Compat loaded.");
    }
}
