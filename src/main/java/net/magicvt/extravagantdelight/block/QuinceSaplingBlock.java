package net.magicvt.extravagantdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;

public class QuinceSaplingBlock extends Block implements BonemealableBlock {

    private static final VoxelShape SAPLING_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);

    public QuinceSaplingBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.PERSISTENT, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.PERSISTENT);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        BlockState blockBelow = world.getBlockState(pos.below());
        return blockBelow.is(BlockTags.DIRT);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        if (direction == Direction.DOWN && !state.canSurvive(world, pos)) {
            return Blocks.AIR.defaultBlockState();
        }
        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!world.isClientSide()) {
            if (random.nextInt(8) == 0) {
                growTree(world, pos, random);
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        growTree(world, pos, random);
    }

    public boolean growTree(ServerLevel world, BlockPos pos, RandomSource random) {
        world.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);

        int height = 2 + random.nextInt(3);

        for (int y = 0; y < height; y++) {
            BlockPos logPos = pos.above(y);
            world.setBlock(logPos, ModBlocks.QUINCE_LOG.get().defaultBlockState(), 3);
        }

        Direction branchDir = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        BlockPos branchStart = pos.above(height - 1);
        int branchLength = 1 + random.nextInt(2);
        BlockPos branchPos = branchStart;

        for (int i = 0; i < branchLength; i++) {
            branchPos = branchPos.relative(branchDir, 1);
            world.setBlock(branchPos, ModBlocks.QUINCE_LOG.get().defaultBlockState(), 3);
        }

        placeLeavesCluster(world, pos.above(height - 1), random);
        placeLeavesCluster(world, branchPos, random);

        return true;
    }

    private void placeLeavesCluster(ServerLevel world, BlockPos center, RandomSource random) {
        for (BlockPos leafPos : BlockPos.betweenClosed(center.offset(-1, -1, -1), center.offset(1, 1, 1))) {
            if (world.getBlockState(leafPos).getBlock() == ModBlocks.QUINCE_LOG.get()) continue;

            float chance = 0.7f;
            if (Math.abs(leafPos.getX() - center.getX()) == 1 && Math.abs(leafPos.getZ() - center.getZ()) == 1) {
                chance = 0.3f;
            }

            if (random.nextFloat() < chance) {
                BlockState blockToPlace;
                if (random.nextFloat() < 0.15f) {
                    blockToPlace = ModBlocks.FLOURISHING_QUINCE_LEAVES.get().defaultBlockState();
                    if (blockToPlace.hasProperty(BlockStateProperties.WATERLOGGED)) {
                        blockToPlace = blockToPlace.setValue(BlockStateProperties.WATERLOGGED, false);
                    }
                } else {
                    blockToPlace = ModBlocks.QUINCE_LEAVES.get().defaultBlockState();
                    if (blockToPlace.hasProperty(BlockStateProperties.WATERLOGGED)) {
                        blockToPlace = blockToPlace.setValue(BlockStateProperties.WATERLOGGED, false);
                    }
                }
                world.setBlock(leafPos, blockToPlace, 3);
            }
        }

        for (Direction dir : Direction.Plane.HORIZONTAL) {
            BlockPos sideLeafPos = center.relative(dir);
            if (world.isEmptyBlock(sideLeafPos) && random.nextFloat() < 0.5f) {
                BlockState blockToPlace = ModBlocks.QUINCE_LEAVES.get().defaultBlockState();
                if (blockToPlace.hasProperty(BlockStateProperties.WATERLOGGED)) {
                    blockToPlace = blockToPlace.setValue(BlockStateProperties.WATERLOGGED, false);
                }
                world.setBlock(sideLeafPos, blockToPlace, 3);
            }
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return SAPLING_SHAPE;
    }
}
