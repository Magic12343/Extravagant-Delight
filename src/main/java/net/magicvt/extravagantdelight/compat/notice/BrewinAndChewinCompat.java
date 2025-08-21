package net.magicvt.extravagantdelight.compat.notice;

import net.magicvt.extravagantdelight.compat.register.BCCompatBlocks;
import net.minecraftforge.eventbus.api.IEventBus;

public class BrewinAndChewinCompat
{
    public static void init(IEventBus modEventBus) {
        BCCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Brewin And Chewin Compat loaded.");
    }
}
