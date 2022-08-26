package fr.sivarth.sbm.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class RoundWindowBlock extends HorizontalBlock {

    private static final VoxelShape SHAPE_N = Stream.of(
        Block.box(0, 0, 6, 16, 1, 11),
        Block.box(0, 16, 6, 16, 17, 11),
        Block.box(0, 1, 6, 1, 16, 11),
        Block.box(15, 1, 6, 16, 16, 11),
        Block.box(1, 11, 6, 2, 16, 11),
        Block.box(14, 1, 6, 15, 6, 11),
        Block.box(1, 1, 6, 2, 6, 11),
        Block.box(14, 11, 6, 15, 16, 11),
        Block.box(13, 1, 6, 14, 5, 11),
        Block.box(2, 1, 6, 3, 5, 11),
        Block.box(13, 12, 6, 14, 16, 11),
        Block.box(2, 12, 6, 3, 16, 11),
        Block.box(12, 13, 6, 13, 16, 11),
        Block.box(3, 1, 6, 4, 4, 11),
        Block.box(12, 1, 6, 13, 4, 11),
        Block.box(3, 13, 6, 4, 16, 11),
        Block.box(11, 1, 6, 12, 3, 11),
        Block.box(11, 14, 6, 12, 16, 11),
        Block.box(4, 14, 6, 5, 16, 11),
        Block.box(4, 1, 6, 5, 3, 11),
        Block.box(5, 15, 6, 6, 16, 11),
        Block.box(10, 1, 6, 11, 2, 11),
        Block.box(5, 1, 6, 6, 2, 11),
        Block.box(10, 15, 6, 11, 16, 11),
        Block.box(1, 1, 8, 15, 16, 9)
    ).reduce((v1, v2) ->  VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_E = Stream.of(
        Block.box(6, 0, 0, 11, 1, 16),
        Block.box(6, 16, 0, 11, 17, 16),
        Block.box(6, 1, 0, 11, 16, 1),
        Block.box(6, 1, 15, 11, 16, 16),
        Block.box(6, 11, 1, 11, 16, 2),
        Block.box(6, 1, 14, 11, 6, 15),
        Block.box(6, 1, 1, 11, 6, 2),
        Block.box(6, 11, 14, 11, 16, 15),
        Block.box(6, 1, 13, 11, 5, 14),
        Block.box(6, 1, 2, 11, 5, 3),
        Block.box(6, 12, 13, 11, 16, 14),
        Block.box(6, 12, 2, 11, 16, 3),
        Block.box(6, 13, 12, 11, 16, 13),
        Block.box(6, 1, 3, 11, 4, 4),
        Block.box(6, 1, 12, 11, 4, 13),
        Block.box(6, 13, 3, 11, 16, 4),
        Block.box(6, 1, 11, 11, 3, 12),
        Block.box(6, 14, 11, 11, 16, 12),
        Block.box(6, 14, 4, 11, 16, 5),
        Block.box(6, 1, 4, 11, 3, 5),
        Block.box(6, 15, 5, 11, 16, 6),
        Block.box(6, 1, 10, 11, 2, 11),
        Block.box(6, 1, 5, 11, 2, 6),
        Block.box(6, 15, 10, 11, 16, 11),
        Block.box(8, 1, 1, 9, 16, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_S = Stream.of(
        Block.box(0, 0, 6, 16, 1, 11),
        Block.box(0, 16, 6, 16, 17, 11),
        Block.box(15, 1, 6, 16, 16, 11),
        Block.box(0, 1, 6, 1, 16, 11),
        Block.box(14, 11, 6, 15, 16, 11),
        Block.box(1, 1, 6, 2, 6, 11),
        Block.box(14, 1, 6, 15, 6, 11),
        Block.box(1, 11, 6, 2, 16, 11),
        Block.box(2, 1, 6, 3, 5, 11),
        Block.box(13, 1, 6, 14, 5, 11),
        Block.box(2, 12, 6, 3, 16, 11),
        Block.box(13, 12, 6, 14, 16, 11),
        Block.box(3, 13, 6, 4, 16, 11),
        Block.box(12, 1, 6, 13, 4, 11),
        Block.box(3, 1, 6, 4, 4, 11),
        Block.box(12, 13, 6, 13, 16, 11),
        Block.box(4, 1, 6, 5, 3, 11),
        Block.box(4, 14, 6, 5, 16, 11),
        Block.box(11, 14, 6, 12, 16, 11),
        Block.box(11, 1, 6, 12, 3, 11),
        Block.box(10, 15, 6, 11, 16, 11),
        Block.box(5, 1, 6, 6, 2, 11),
        Block.box(10, 1, 6, 11, 2, 11),
        Block.box(5, 15, 6, 6, 16, 11),
        Block.box(1, 1, 8, 15, 16, 9)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public static final VoxelShape SHAPE_W = Stream.of(
        Block.box(5, 0, 0, 10, 1, 16),
        Block.box(5, 16, 0, 10, 17, 16),
        Block.box(5, 1, 15, 10, 16, 16),
        Block.box(5, 1, 0, 10, 16, 1),
        Block.box(5, 11, 14, 10, 16, 15),
        Block.box(5, 1, 1, 10, 6, 2),
        Block.box(5, 1, 14, 10, 6, 15),
        Block.box(5, 11, 1, 10, 16, 2),
        Block.box(5, 1, 2, 10, 5, 3),
        Block.box(5, 1, 13, 10, 5, 14),
        Block.box(5, 12, 2, 10, 16, 3),
        Block.box(5, 12, 13, 10, 16, 14),
        Block.box(5, 13, 3, 10, 16, 4),
        Block.box(5, 1, 12, 10, 4, 13),
        Block.box(5, 1, 3, 10, 4, 4),
        Block.box(5, 13, 12, 10, 16, 13),
        Block.box(5, 1, 4, 10, 3, 5),
        Block.box(5, 14, 4, 10, 16, 5),
        Block.box(5, 14, 11, 10, 16, 12),
        Block.box(5, 1, 11, 10, 3, 12),
        Block.box(5, 15, 10, 10, 16, 11),
        Block.box(5, 1, 5, 10, 2, 6),
        Block.box(5, 1, 10, 10, 2, 11),
        Block.box(5, 15, 5, 10, 16, 6),
        Block.box(7, 1, 1, 8, 16, 15)
    ).reduce((v1, v2) -> VoxelShapes.join(v1, v2, IBooleanFunction.OR)).get();

    public RoundWindowBlock(Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        switch (state.getValue(FACING)) {
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return state.setValue(FACING, rotation.rotate(state.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState p_220071_1_, IBlockReader p_220071_2_, BlockPos p_220071_3_, ISelectionContext p_220071_4_) {
        return super.getCollisionShape(p_220071_1_, p_220071_2_, p_220071_3_, p_220071_4_);
    }
}
