package net.magicvt.extravagantdelight.compat.notice;

import net.magicvt.extravagantdelight.compat.register.DFCompatBlocks;
import net.minecraftforge.eventbus.api.IEventBus;

public class DelightfulCompat
{
    public static void init(IEventBus modEventBus) {
        DFCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Delightful Compat loaded.");
    }
}
