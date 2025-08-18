package net.magicvt.extravagantdelight.block;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.item.ModItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.CabinetBlock;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

import static net.magicvt.extravagantdelight.item.ModItems.ITEMS;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(net.minecraft.core.registries.Registries.BLOCK, ExtravagantDelight.MOD_ID);

    public static final RegistryObject<Block> WILD_STARFRUIT = registerBlock("wild_starfruit",
            () -> new WildCropBlock(MobEffects.MOVEMENT_SPEED, 10, Block.Properties.copy(Blocks.TALL_GRASS)));

    public static final RegistryObject<Block> STARFRUIT_CROP = registerBlock("starfruit_crop",
            () -> new StarfruitCropBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.CROP))
    );

    public static final RegistryObject<Block> STARFRUIT_CRATE = registerBlock("starfruit_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILD_QUINCE = registerBlock("wild_quince",
            () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));

    public static final RegistryObject<Block> QUINCE_SEEDLING = registerBlock("quince_seedling",
            () -> new QuinceSeedlingBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
            ));

    public static final RegistryObject<Block> QUINCE_SAPLING = registerBlock("quince_sapling",
            () -> new QuinceSaplingBlock(BlockBehaviour.Properties.of()
                    .noCollission()
                    .randomTicks()
                    .instabreak()
                    .sound(SoundType.GRASS)
            ));

    public static final RegistryObject<Block> FLOURISHING_QUINCE_LEAVES = registerBlock("flourishing_quince_leaves",
            () -> new FlourishingQuinceLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .noOcclusion()
                    .randomTicks()
                    .strength(0.2f)
                    .sound(Blocks.OAK_LEAVES.defaultBlockState().getSoundType())));

    public static final RegistryObject<Block> FRUIT_QUINCE_LEAVES = registerBlock("fruit_quince_leaves",
            () -> new FruitQuinceLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .noOcclusion()
                    .randomTicks()
                    .strength(0.2f)
                    .sound(Blocks.OAK_LEAVES.defaultBlockState().getSoundType())));

    public static final RegistryObject<Block> QUINCE_LEAVES = registerBlock("quince_leaves",
            () -> new QuinceLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .noOcclusion()
                    .randomTicks()
                    .strength(0.2f)
                    .sound(Blocks.OAK_LEAVES.defaultBlockState().getSoundType())));

    public static final RegistryObject<Block> QUINCE_LOG = registerBlock("quince_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_QUINCE_LOG = registerBlock("stripped_quince_log",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> QUINCE_WOOD = registerBlock("quince_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_QUINCE_WOOD = registerBlock("stripped_quince_wood",
            () -> new RotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)));
    public static final RegistryObject<Block> QUINCE_PLANKS = registerBlock("quince_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {});
    public static final RegistryObject<Block> QUINCE_STAIRS = registerBlock("quince_stairs",
            () -> new StairBlock(() -> ModBlocks.QUINCE_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.0f, 3.0f)
                            .sound(SoundType.WOOD)));
    public static final RegistryObject<Block> QUINCE_SLAB = registerBlock("quince_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.0f, 3.0f)
                    .sound(SoundType.WOOD)));
    public static final RegistryObject<DoorBlock> QUINCE_DOOR = registerBlock("quince_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR)
                    .strength(1.0f, 3.0f)
                    .noOcclusion()
                    .sound(SoundType.WOOD),
                    BlockSetType.ACACIA));
    public static final RegistryObject<Block> QUINCE_TRAPDOOR = BLOCKS.register("quince_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.WOOD)
                    .strength(3.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion(), BlockSetType.OAK));
    public static final RegistryObject<Block> QUINCE_FENCE = registerBlock("quince_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {});
    public static final RegistryObject<Block> QUINCE_FENCE_GATE = registerBlock("quince_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE).sound(SoundType.WOOD), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> QUINCE_CABINET = registerBlock("quince_cabinet",
            () -> new CabinetBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)) {});
    public static final RegistryObject<Block> QUINCE_BUTTON = registerBlock("quince_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.WOOD),
                    BlockSetType.ACACIA, 10, true));
    public static final RegistryObject<Block> QUINCE_PRESSURE_PLATE = registerBlock("quince_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD),
                    BlockSetType.ACACIA));


    public static final RegistryObject<Block> QUINCE_CRATE = registerBlock("quince_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> WILD_SLOE_BERRIES = registerBlock("wild_sloe_berries",
            () -> new WildCropBlock(MobEffects.WEAKNESS, 10, Block.Properties.copy(Blocks.TALL_GRASS)));

    public static final RegistryObject<Block> SLOE_BERRIES = BLOCKS.register("sloe_berries",
            () -> new SloeBerriesBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion()));

    public static final RegistryObject<Block> SLOE_BERRIES_CRATE = registerBlock("sloe_berries_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STARFRUIT_CHEESECAKE = BLOCKS.register("starfruit_cheesecake",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.STARFRUIT_CHEESECAKE_SLICE));
    public static final RegistryObject<Block> SWEET_QUINCE_TART = BLOCKS.register("sweet_quince_tart",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.SWEET_QUINCE_TART_SLICE));
    public static final RegistryObject<Block> SLOE_TREACLE_TART = BLOCKS.register("sloe_treacle_tart",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.SLOE_TREACLE_TART_SLICE));

    //BlockItems
    public static final RegistryObject<Item> STARFRUIT_CHEESECAKE_ITEM = ITEMS.register("starfruit_cheesecake",
            () -> new BlockItem(ModBlocks.STARFRUIT_CHEESECAKE.get(), new Item.Properties()));
    public static final RegistryObject<Item> SWEET_QUINCE_TART_ITEM = ITEMS.register("sweet_quince_tart",
            () -> new BlockItem(ModBlocks.SWEET_QUINCE_TART.get(), new Item.Properties()));
    public static final RegistryObject<Item> SLOE_TREACLE_TART_ITEM = ITEMS.register("sloe_treacle_tart",
            () -> new BlockItem(ModBlocks.SLOE_TREACLE_TART.get(), new Item.Properties()));
    public static final RegistryObject<Item> QUINCE_TRAPDOOR_ITEM = ITEMS.register("quince_trapdoor",
            () -> new BlockItem(ModBlocks.QUINCE_TRAPDOOR.get(), new Item.Properties()));




    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static RegistryObject<Item> registerBlockItem(String name, RegistryObject<? extends Block> block) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
