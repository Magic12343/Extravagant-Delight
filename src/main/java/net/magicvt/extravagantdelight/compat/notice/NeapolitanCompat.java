package net.magicvt.extravagantdelight.compat.notice;

import net.magicvt.extravagantdelight.compat.register.NTCompatBlocks;
import net.minecraftforge.eventbus.api.IEventBus;

public class NeapolitanCompat
{
    public static void init(IEventBus modEventBus) {
        NTCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Neapolitan Compat loaded.");
    }
}
