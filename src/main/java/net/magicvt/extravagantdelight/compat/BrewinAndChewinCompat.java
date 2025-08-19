package net.magicvt.extravagantdelight.compat;

import net.minecraftforge.eventbus.api.IEventBus;

public class BrewinAndChewinCompat
{
    public static void init(IEventBus modEventBus) {
        BCCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Brewin And Chewin Compat loaded.");
    }
}
