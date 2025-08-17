package net.magicvt.extravagantdelight.block;

import net.magicvt.extravagantdelight.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StarfruitCropBlock extends Block implements BonemealableBlock {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = IntegerProperty.create("age", 0, MAX_AGE);
    public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);

    public StarfruitCropBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AGE, 0)
                .setValue(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, HALF);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            return Blocks.OAK_FENCE.getShape(Blocks.OAK_FENCE.defaultBlockState(), world, pos, context);
        } else {
            return Blocks.OAK_SLAB.getShape(Blocks.OAK_SLAB.defaultBlockState(), world, pos, context);
        }
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState below = level.getBlockState(pos.below());
            return below.is(this) && below.getValue(HALF) == DoubleBlockHalf.LOWER;
        } else {
            BlockState soil = level.getBlockState(pos.below());
            return soil.is(BlockTags.SAND) || soil.is(Blocks.CLAY);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.isAreaLoaded(pos, 1)) return;
        if (state.getValue(HALF) != DoubleBlockHalf.LOWER) return;

        int age = state.getValue(AGE);
        if (age >= 4) return;

        if (level.getRawBrightness(pos, 0) >= 9 && random.nextInt(5) == 0) {
            int newAge = age + 1;
            level.setBlock(pos, state.setValue(AGE, newAge), 2);

            BlockPos abovePos = pos.above();
            BlockState aboveState = level.getBlockState(abovePos);

            if (!aboveState.is(this)) {
                level.setBlock(abovePos, this.defaultBlockState()
                        .setValue(AGE, newAge)
                        .setValue(HALF, DoubleBlockHalf.UPPER), 2);
            } else {
                level.setBlock(abovePos, aboveState.setValue(AGE, newAge), 2);
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, BlockState state, boolean isClient) {
        if (state.getValue(AGE) >= 4) return false;
        if (state.getValue(HALF) == DoubleBlockHalf.UPPER) {
            BlockState belowState = world.getBlockState(pos.below());
            return belowState.is(this) && belowState.getValue(AGE) < 4;
        }
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level world, RandomSource random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource random, BlockPos pos, BlockState state) {
        BlockPos lowerPos = state.getValue(HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos;
        BlockState lowerState = world.getBlockState(lowerPos);
        int age = lowerState.getValue(AGE);
        if (age < 4) {
            int newAge = age + 1;
            world.setBlock(lowerPos, lowerState.setValue(AGE, newAge), 2);

            BlockPos abovePos = lowerPos.above();
            BlockState aboveState = world.getBlockState(abovePos);
            if (!aboveState.is(this)) {
                world.setBlock(abovePos, this.defaultBlockState().setValue(AGE, newAge).setValue(HALF, DoubleBlockHalf.UPPER), 2);
            } else {
                world.setBlock(abovePos, aboveState.setValue(AGE, newAge), 2);
            }
        }
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (level.isClientSide) return InteractionResult.SUCCESS;

        if (state.getValue(AGE) == 4) {
            BlockPos lowerPos = state.getValue(HALF) == DoubleBlockHalf.UPPER ? pos.below() : pos;
            BlockState lowerState = level.getBlockState(lowerPos);
            BlockState upperState = level.getBlockState(lowerPos.above());

            if (!lowerState.is(this) || lowerState.getValue(AGE) != 4)
                return super.use(state, level, pos, player, hand, hit);

            int amount = 2 + level.random.nextInt(4);
            ItemStack fruit = new ItemStack(ModItems.STARFRUIT.get(), amount);
            popResource(level, lowerPos, fruit);

            level.playSound(null, lowerPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);

            level.setBlock(lowerPos, lowerState.setValue(AGE, 3), 3);
            if (upperState.is(this)) {
                level.setBlock(lowerPos.above(), upperState.setValue(AGE, 3), 3);
            }

            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, hit);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockPos abovePos = pos.above();
                BlockState aboveState = level.getBlockState(abovePos);
                if (aboveState.is(this) && aboveState.getValue(HALF) == DoubleBlockHalf.UPPER) {
                    level.destroyBlock(abovePos, false);
                }
            } else {
                BlockPos belowPos = pos.below();
                BlockState belowState = level.getBlockState(belowPos);
                if (belowState.is(this) && belowState.getValue(HALF) == DoubleBlockHalf.LOWER) {
                    level.destroyBlock(belowPos, false);
                }
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            if (!state.canSurvive(level, pos)) {
                level.destroyBlock(pos, true);
                BlockPos abovePos = pos.above();
                BlockState aboveState = level.getBlockState(abovePos);
                if (aboveState.is(this) && aboveState.getValue(HALF) == DoubleBlockHalf.UPPER) {
                    level.destroyBlock(abovePos, false);
                }
            }
        } else {
            BlockPos belowPos = pos.below();
            BlockState belowState = level.getBlockState(belowPos);
            if (!belowState.is(this)) {
                level.destroyBlock(pos, true);
            }
        }
        super.neighborChanged(state, level, pos, block, fromPos, isMoving);
    }
}
