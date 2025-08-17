package net.magicvt.extravagantdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class FruitQuinceLeavesBlock extends Block {

    public FruitQuinceLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide) {
            ItemStack fruit = new ItemStack(net.magicvt.extravagantdelight.item.ModItems.QUINCE.get(), 1);
            popResource(world, pos, fruit);
            world.setBlock(pos, ModBlocks.FLOURISHING_QUINCE_LEAVES.get().defaultBlockState(), 3);
            world.playSound(null, pos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 1.0F);
        }
        return InteractionResult.SUCCESS;
    }


    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!hasQuinceLogNearby(world, pos, 6)) {
            world.removeBlock(pos, false);
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
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }


    public boolean isSuffocating(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }


    public boolean isViewBlocking(BlockState state, BlockGetter world, BlockPos pos) {
        return false;
    }

    @Override
    public SoundType getSoundType(BlockState state) {
        return SoundType.GRASS;
    }
}
