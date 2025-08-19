package net.magicvt.extravagantdelight.compat;

import alabaster.hearthandharvest.common.block.HalfCabinetBlock;
import alabaster.hearthandharvest.common.item.WineBottleItem;
import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.item.EDFoodValues;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class HHCompatBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtravagantDelight.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);



    //Blocks
    public static final RegistryObject<Block> QUINCE_HALF_CABINET = BLOCKS.register("quince_half_cabinet",
            () -> new HalfCabinetBlock(Block.Properties.copy(Blocks.BARREL)));
    public static final RegistryObject<Block> STARFRUIT_WINE_CRATE = BLOCKS.register("starfruit_wine_crate",
            () -> new SlabBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> QUINCE_WINE_CRATE = BLOCKS.register("quince_wine_crate",
            () -> new SlabBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SLOE_BERRY_WINE_CRATE = BLOCKS.register("sloe_berry_wine_crate",
            () -> new SlabBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    //Items
    public static final RegistryObject<Item> STARFRUIT_WINE = ITEMS.register("starfruit_wine",
            () -> new WineBottleItem(() -> HHCompatFluids.STARFRUIT_WINE.get(),
                    new Item.Properties().food(EDFoodValues.STARFRUIT_WINE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE),
                    true, false));
    public static final RegistryObject<Item> QUINCE_WINE = ITEMS.register("quince_wine",
            () -> new WineBottleItem(() -> HHCompatFluids.QUINCE_WINE.get(),
                    new Item.Properties().food(EDFoodValues.QUINCE_WINE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE),
                    true, false));
    public static final RegistryObject<Item> SLOE_BERRY_WINE = ITEMS.register("sloe_berry_wine",
            () -> new WineBottleItem(() -> HHCompatFluids.SLOE_BERRY_WINE.get(),
                    new Item.Properties().food(EDFoodValues.SLOE_BERRY_WINE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE),
                    true, false));

    //BlockItems
    public static final RegistryObject<Item> QUINCE_HALF_CABINET_ITEM = ITEMS.register("quince_half_cabinet",
            () -> new BlockItem(HHCompatBlocks.QUINCE_HALF_CABINET.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> STARFRUIT_WINE_CRATE_ITEM = ITEMS.register("starfruit_wine_crate",
            () -> new BlockItem(HHCompatBlocks.STARFRUIT_WINE_CRATE.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> QUINCE_WINE_CRATE_ITEM = ITEMS.register("quince_wine_crate",
            () -> new BlockItem(HHCompatBlocks.QUINCE_WINE_CRATE.get(), new Item.Properties())
    );
    public static final RegistryObject<Item> SLOE_BERRY_WINE_CRATE_ITEM = ITEMS.register("sloe_berry_wine_crate",
            () -> new BlockItem(HHCompatBlocks.SLOE_BERRY_WINE_CRATE.get(), new Item.Properties())
    );




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

    public static FoodProperties.Builder createMilkshake(Supplier<MobEffectInstance> effect) {
        return createFood(2, 1.5F).alwaysEat().effect(effect, 1.0F);
    }
}
