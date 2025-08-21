package net.magicvt.extravagantdelight.compat.notice;

import net.magicvt.extravagantdelight.compat.register.ATCompatBlocks;
import net.minecraftforge.eventbus.api.IEventBus;

public class AtmosphericCompat
{
    public static void init(IEventBus modEventBus) {
        ATCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Atmospheric Compat loaded.");
    }
}
