package net.zndrmn.furnitured.properties.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.stream.Stream;

import static net.minecraft.block.HorizontalFacingBlock.FACING;

public class InnerRightKitchenCounterBlock extends Block {

    private static final VoxelShape SHAPE_NORTH = Stream.of(
            Block.createCuboidShape(1, 0, 1, 16, 12, 16),
            Block.createCuboidShape(1, 0, 0, 16, 12, 1),
            Block.createCuboidShape(0, 0, 1, 1, 12, 16),
            Block.createCuboidShape(0, 12, 0, 16, 16, 16))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_EAST  = Stream.of(
            Block.createCuboidShape(0, 12, 0, 16, 16, 16),
            Block.createCuboidShape(0, 0, 1, 15, 12, 16),
            Block.createCuboidShape(15, 0, 1, 16, 12, 16),
            Block.createCuboidShape(0, 0, 0, 15, 12, 1))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_SOUTH = Stream.of(
            Block.createCuboidShape(0, 0, 0, 15, 12, 15),
            Block.createCuboidShape(0, 0, 15, 15, 12, 16),
            Block.createCuboidShape(15, 0, 0, 16, 12, 15),
            Block.createCuboidShape(0, 12, 0, 16, 16, 16))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private static final VoxelShape SHAPE_WEST  = Stream.of(
            Block.createCuboidShape(1, 0, 0, 16, 12, 15),
            Block.createCuboidShape(0, 0, 0, 1, 12, 15),
            Block.createCuboidShape(1, 0, 15, 16, 12, 16),
            Block.createCuboidShape(0, 12, 0, 16, 16, 16))
            .reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    public InnerRightKitchenCounterBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH :
                return SHAPE_NORTH;
            case EAST  :
                return SHAPE_EAST;
            case SOUTH :
                return SHAPE_SOUTH;
            case WEST  :
                return SHAPE_WEST;
            default :
                return SHAPE_NORTH;
        }
    }

    //@Override
    //public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    //    switch ((Direction) state.get(FACING)) {
    //        case UP :
    //        case DOWN :
    //        case SOUTH :
    //        default :
    //            return SHAPE_SOUTH;
    //        case NORTH :
    //            return SHAPE_NORTH;
    //        case WEST :
    //            return SHAPE_WEST;
    //        case EAST :
    //            return SHAPE_EAST;
    //    }
    //}

    //public InnerRightKitchenCounterBlock(Settings settings) {
    //    super(settings);
    //    setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    //}

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(FACING, context.getPlayerFacing().getOpposite());
    }


    //@Override
    //public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    //    switch (state.get(FACING)) {
    //        case NORTH :
    //            return SHAPE_NORTH;
    //        case EAST  :
    //            return SHAPE_EAST;
    //        case SOUTH :
    //            return SHAPE_SOUTH;
    //        case WEST  :
    //            return SHAPE_WEST;
    //        default :
    //            return SHAPE_NORTH;
    //    }
    //}

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(FACING, rotation.rotate((Direction)state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction)state.get(FACING)));
    }



    //@Override
    //public BlockState getRotation(BlockState state, getRotation rotate) {
    //    return state.with(FACING, rotate.getRotation(state.get(FACING)))
    //}

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    //@Override
    //public BlockState getPlacementState(ItemPlacementContext ctx) {
    //    return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    //}

}
