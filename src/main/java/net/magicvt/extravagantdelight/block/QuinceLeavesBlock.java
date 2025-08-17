package net.magicvt.extravagantdelight.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class QuinceLeavesBlock extends Block {

    public QuinceLeavesBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        int radius = 6;
        boolean hasLogNearby = false;

        search:
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    if (world.getBlockState(checkPos).is(net.magicvt.extravagantdelight.block.ModBlocks.QUINCE_LOG.get())) {
                        hasLogNearby = true;
                        break search;
                    }
                }
            }
        }

        if (!hasLogNearby) {
            world.removeBlock(pos, false);
        }
    }


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
