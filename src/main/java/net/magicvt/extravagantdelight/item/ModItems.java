package net.magicvt.extravagantdelight.item;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.block.ModBlocks;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);

    public static final RegistryObject<Item> STARFRUIT = ITEMS.register("starfruit",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).build())));

    public static final RegistryObject<Item> STARFRUIT_SEEDS = ITEMS.register("starfruit_seeds",
            () -> new net.minecraft.world.item.ItemNameBlockItem(ModBlocks.STARFRUIT_CROP.get(), new Item.Properties()));

    public static final RegistryObject<Item> QUINCE = ITEMS.register("quince",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder()
                    .nutrition(1)
                    .saturationMod(0.3f)
                    .effect(() -> new net.minecraft.world.effect.MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1.0f)
                    .build())));

    public static final RegistryObject<Item> SLOE_BERRIES = ITEMS.register("sloe_berries", () ->
            new SloeBerriesItem(new Item.Properties())
    );

    public static final RegistryObject<BlockItem> SLOE_BERRY_PIPS = ITEMS.register("sloe_berry_pips",
            () -> new BlockItem(ModBlocks.SLOE_BERRIES.get(), new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
