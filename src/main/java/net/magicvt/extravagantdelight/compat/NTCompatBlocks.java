package net.magicvt.extravagantdelight.compat;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class NTCompatBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExtravagantDelight.MOD_ID);

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ExtravagantDelight.MOD_ID);

    //Blocks
    public static final RegistryObject<Block> STRAWBERRY_PIPS_BAG =
            BLOCKS.register("strawberry_pips_bag", () ->
                    new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(1.0f)));
    public static final RegistryObject<Block> MINT_SPROUTS_BAG =
            BLOCKS.register("mint_sprouts_bag", () ->
                    new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL).strength(1.0f)));

    //Items
    public static final RegistryObject<Item> STRAWBERRY_PIPS_BAG_ITEM =
            ITEMS.register("strawberry_pips_bag", () ->
                    new BlockItem(STRAWBERRY_PIPS_BAG.get(), new Item.Properties()));
    public static final RegistryObject<Item> MINT_SPROUTS_BAG_ITEM =
            ITEMS.register("mint_sprouts_bag", () ->
                    new BlockItem(MINT_SPROUTS_BAG.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
        ITEMS.register(eventBus);
    }
}