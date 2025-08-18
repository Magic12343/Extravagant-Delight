package net.magicvt.extravagantdelight.block;

import net.magicvt.extravagantdelight.ExtravagantDelight;
import net.magicvt.extravagantdelight.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
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

    public static final RegistryObject<Block> QUINCE_CRATE = registerBlock("quince_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));


    public static final RegistryObject<Block> SLOE_BERRIES = BLOCKS.register("sloe_berries",
            () -> new SloeBerriesBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion()));

    public static final RegistryObject<Block> SLOE_BERRIES_CRATE = registerBlock("sloe_berries_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    public static final RegistryObject<Block> STARFRUIT_CHEESECAKE = BLOCKS.register("starfruit_cheesecake",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.STARFRUIT_CHEESECAKE_SLICE));

    //BlockItems
    public static final RegistryObject<Item> STARFRUIT_CHEESECAKE_ITEM = ITEMS.register("starfruit_cheesecake",
            () -> new BlockItem(ModBlocks.STARFRUIT_CHEESECAKE.get(), new Item.Properties()));



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
