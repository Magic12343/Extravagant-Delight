package net.magicvt.extravagantdelight.compat.register;

import com.teamabnormals.neapolitan.common.item.IceCreamItem;
import com.teamabnormals.neapolitan.core.registry.NeapolitanBlocks;
import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.compat.item.ShakeItem;
import net.magicvt.extravagantdelight.item.EDFoodValues;
import net.magicvt.extravagantdelight.item.LollipopItem;
import net.magicvt.extravagantdelight.compat.food.NTCombatFoodValues;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.registry.ModEffects;

import java.util.function.Supplier;

import static net.magicvt.extravagantdelight.item.ModItems.drinkItem;
import static net.magicvt.extravagantdelight.item.ModItems.registerWithTab;

public class NTCompatBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtravagantDelight.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);



    //Blocks
    public static final RegistryObject<Block> STARFRUIT_ICE_CREAM_BLOCK =
            BLOCKS.register("starfruit_ice_cream_block", () ->
                    new Block(NeapolitanBlocks.NeapolitanBlockProperties.VANILLA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> QUINCE_ICE_CREAM_BLOCK =
            BLOCKS.register("quince_ice_cream_block", () ->
                    new Block(NeapolitanBlocks.NeapolitanBlockProperties.VANILLA_ICE_CREAM_BLOCK));
    public static final RegistryObject<Block> SLOE_BERRY_ICE_CREAM_BLOCK =
            BLOCKS.register("sloe_berry_ice_cream_block", () ->
                    new Block(NeapolitanBlocks.NeapolitanBlockProperties.VANILLA_ICE_CREAM_BLOCK));

    //Items
    public static final RegistryObject<Item> STARFRUIT_ICE_CREAM = registerItem("starfruit_ice_cream",
            () -> new IceCreamItem((new Item.Properties()).food(EDFoodValues.STARFRUIT_ICE_CREAM)));
    public static final RegistryObject<Item> QUINCE_ICE_CREAM = registerItem("quince_ice_cream",
            () -> new IceCreamItem((new Item.Properties()).food(EDFoodValues.QUINCE_ICE_CREAM)));
    public static final RegistryObject<Item> SLOE_BERRY_ICE_CREAM = registerItem("sloe_berry_ice_cream",
            () -> new IceCreamItem((new Item.Properties()).food(EDFoodValues.SLOE_BERRY_ICE_CREAM)));

    public static final RegistryObject<Item> STARFRUIT_MILKSHAKE = registerItem("starfruit_milkshake",
            () -> new ShakeItem(new Item.Properties().food(EDFoodValues.STARFRUIT_MILKSHAKE)));
    public static final RegistryObject<Item> QUINCE_MILKSHAKE = registerItem("quince_milkshake",
            () -> new ShakeItem(new Item.Properties().food(EDFoodValues.QUINCE_MILKSHAKE)));
    public static final RegistryObject<Item> SLOE_BERRY_MILKSHAKE = registerItem("sloe_berry_milkshake",
            () -> new ShakeItem(new Item.Properties().food(EDFoodValues.SLOE_BERRY_MILKSHAKE)));

    public static final RegistryObject<Item> STRAWBERRY_YOGURT = ITEMS.register("strawberry_yogurt",
            () -> new DrinkableItem(drinkItem().food(NTCombatFoodValues.STRAWBERRY_YOGURT), true, false));

    public static final RegistryObject<Item> STRAWBERRY_LOLLIPOP =
            registerWithTab("strawberry_lollipop",
                    () -> new LollipopItem(
                            new Item.Properties().stacksTo(1),
                            NTCombatFoodValues.STRAWBERRY_LOLLIPOP,
                            10
                    )
            );
    public static final RegistryObject<Item> MINT_LOLLIPOP =
            registerWithTab("mint_lollipop",
                    () -> new LollipopItem(
                            new Item.Properties().stacksTo(1),
                            NTCombatFoodValues.MINT_LOLLIPOP,
                            10
                    )
            );

    public static final RegistryObject<Item> STRAWBERRY_JAM = registerWithTab("strawberry_jam",
            () -> new DrinkableItem(drinkItem().food(EDFoodValues.STARFRUIT_JAM), true, false));

    //BlockItems
    public static final RegistryObject<Item> STARFRUIT_ICE_CREAM_BLOCK_ITEM = ITEMS.register("starfruit_ice_cream_block",
            () -> new BlockItem(NTCompatBlocks.STARFRUIT_ICE_CREAM_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> QUINCE_ICE_CREAM_BLOCK_ITEM = ITEMS.register("quince_ice_cream_block",
            () -> new BlockItem(NTCompatBlocks.QUINCE_ICE_CREAM_BLOCK.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> SLOE_BERRY_ICE_CREAM_BLOCK_ITEM = ITEMS.register("sloe_berry_ice_cream_block",
            () -> new BlockItem(NTCompatBlocks.SLOE_BERRY_ICE_CREAM_BLOCK.get(), new Item.Properties())
    );



    public static RegistryObject<Item> registerItem(String name, Supplier<Item> item) {
        return ITEMS.register(name, item);
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }


public static final class NeapolitanFoods {
    public static final FoodProperties STARFRUIT_MILKSHAKE = createMilkshake(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false)).build();
    public static final FoodProperties QUINCE_MILKSHAKE = createMilkshake(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0)).build();
    public static final FoodProperties SLOE_BERRY_MILKSHAKE = createMilkshake(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false)).build();

    public static final FoodProperties STARFRUIT_ICE_CREAM = createFood(6, 0.3F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0, false, false), 1.0F).build();
    public static final FoodProperties QUINCE_ICE_CREAM = createFood(6, 0.3F).effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 200, 0), 1.0F).build();
    public static final FoodProperties SLOE_BERRY_ICE_CREAM = createFood(6, 0.3F).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 400, 0, false, false), 1.0F).build();

    public static FoodProperties.Builder createFood(int nutrition, float saturation) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturation);
    }

    public static FoodProperties.Builder createMilkshake(Supplier<MobEffectInstance> effect) {
        return createFood(2, 1.5F).alwaysEat().effect(effect, 1.0F);
    }
}
}