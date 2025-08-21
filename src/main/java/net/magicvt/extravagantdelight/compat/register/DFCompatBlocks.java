package net.magicvt.extravagantdelight.compat.register;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.item.EDFoodValues;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import java.util.function.Supplier;

import static net.magicvt.extravagantdelight.item.ModItems.drinkItem;

public class DFCompatBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtravagantDelight.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);



    //Blocks


    //Items
    public static final RegistryObject<Item> SALMONBERRY_YOGURT = ITEMS.register("salmonberry_yogurt",
            () -> new DrinkableItem(drinkItem().food(EDFoodValues.SALMONBERRY_YOGURT), true, false));


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
