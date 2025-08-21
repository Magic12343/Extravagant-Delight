package net.magicvt.extravagantdelight.compat.notice;

import net.magicvt.extravagantdelight.compat.register.HHCompatBlocks;
import net.minecraftforge.eventbus.api.IEventBus;

public class HearthAndHarvestCompat
{
    public static void init(IEventBus modEventBus) {
        HHCompatBlocks.register(modEventBus);
        System.out.println("[ExtravagantDelight]Hearth and Harvest Compat loaded.");
    }
}
