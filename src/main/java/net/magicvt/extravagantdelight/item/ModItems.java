package net.magicvt.extravagantdelight.item;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.block.ModBlocks;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.PopsicleItem;

import java.util.function.Supplier;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);

    //helper
    public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        return block;
    }

    public static RegistryObject<Item> registerWithBlockTab(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        return block;
    }

    public static Item.Properties basicItem() {
        return new Item.Properties();
    }

    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties drinkItem() {
        return new Item.Properties().craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }
    //CROPS

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

    //FOOD

    public static final RegistryObject<Item> STARFRUIT_SALAD = registerWithTab("starfruit_salad",
            () -> new ConsumableItem(bowlFoodItem(EDFoodValues.STARFRUIT_SALAD), true));
    public static final RegistryObject<Item> STARFRUIT_SALMON = registerWithTab("starfruit_salmon",
            () -> new ConsumableItem(bowlFoodItem(EDFoodValues.STARFRUIT_SALMON), true));
    public static final RegistryObject<Item> STARFRUIT_POPSICLE = registerWithTab("starfruit_popsicle",
            () -> new PopsicleItem(bowlFoodItem(EDFoodValues.STARFRUIT_POPSICLE)));
    public static final RegistryObject<Item> STARFRUIT_JAM = registerWithTab("starfruit_jam",
            () -> new DrinkableItem(drinkItem().food(EDFoodValues.STARFRUIT_JAM), true, false));
    public static final RegistryObject<Item> STARFRUIT_MUFFIN = registerWithTab("starfruit_muffin",
            () -> new ConsumableItem(bowlFoodItem(EDFoodValues.STARFRUIT_MUFFIN), true));
    public static final RegistryObject<Item> STARFRUIT_JUICE = registerWithTab("starfruit_juice",
            () -> new DrinkableItem(drinkItem().food(EDFoodValues.STARFRUIT_JUICE), true, false));
    public static final RegistryObject<Item> STARFRUIT_CHEESECAKE_SLICE = registerWithTab("starfruit_cheesecake_slice",
            () -> new Item(foodItem(EDFoodValues.STARFRUIT_CHEESECAKE_SLICE)));





    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
