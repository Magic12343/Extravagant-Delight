package net.magicvt.extravagantdelight.compat.register;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.compat.fluid.BCCompatFluids;
import net.magicvt.extravagantdelight.compat.food.BCCombatFoodValues;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import umpaz.brewinandchewin.common.item.BoozeItem;

import java.util.function.Supplier;

public class BCCompatBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtravagantDelight.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);



    //Blocks


    //Items
    public static final RegistryObject<Item> STARFRUIT_PALOMA = ITEMS.register("starfruit_paloma",
            () -> new BoozeItem(
                    BCCompatFluids.STARFRUIT_PALOMA.get(),
                    new Item.Properties()
                            .stacksTo(16)
                            .food(BCCombatFoodValues.STARFRUIT_PALOMA)
            )
    );
    public static final RegistryObject<Item> PINK_GIN = ITEMS.register("pink_gin",
            () -> new BoozeItem(
                    BCCompatFluids.PINK_GIN.get(),
                    new Item.Properties()
                            .stacksTo(16)
                            .food(BCCombatFoodValues.PINK_GIN)
            )
    );
    public static final RegistryObject<Item> SLOE_GIN = ITEMS.register("sloe_gin",
            () -> new BoozeItem(
                    BCCompatFluids.SLOE_GIN.get(),
                    new Item.Properties()
                            .stacksTo(16)
                            .food(BCCombatFoodValues.SLOE_GIN)
            )
    );
    public static final RegistryObject<Item> SLOE_VODKA = ITEMS.register("sloe_vodka",
            () -> new BoozeItem(
                    BCCompatFluids.SLOE_VODKA.get(),
                    new Item.Properties()
                            .stacksTo(16)
                            .food(BCCombatFoodValues.SLOE_VODKA)
            )
    );


    //BlockItems




    public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }



    public static FoodProperties.Builder createFood(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation);
    }


}
