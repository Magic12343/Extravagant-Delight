package net.magicvt.extravagantdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.phys.BlockHitResult;

public class FlourishingQuinceLeavesBlock extends Block implements BonemealableBlock {

    public FlourishingQuinceLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(BlockStateProperties.WATERLOGGED, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(BlockStateProperties.WATERLOGGED);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!hasQuinceLogNearby(world, pos, 6)) {
            world.removeBlock(pos, false);
            return;
        }
        if (random.nextInt(10) == 0) {
            world.setBlock(pos, ModBlocks.FRUIT_QUINCE_LEAVES.get().defaultBlockState(), 3);
        }
    }

    private boolean hasQuinceLogNearby(ServerLevel world, BlockPos pos, int radius) {
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    if (world.getBlockState(checkPos).is(ModBlocks.QUINCE_LOG.get())) {
                        return true;
                    }
                }
            }
        }
        return false;
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
        world.setBlock(pos, ModBlocks.FRUIT_QUINCE_LEAVES.get().defaultBlockState(), 3);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        return InteractionResult.PASS;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

    public boolean isSuffocating(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }


    public boolean isViewBlocking(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }
}
