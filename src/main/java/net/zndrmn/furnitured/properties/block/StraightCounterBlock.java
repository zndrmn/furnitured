package net.zndrmn.furnitured.properties.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import static net.minecraft.block.HorizontalFacingBlock.FACING;

public class StraightCounterBlock extends Block {

    private static final VoxelShape SHAPE_NORTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 12, 0, 16, 16, 16), Block.createCuboidShape(0, 0, 1, 16, 12, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_EAST  = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 12, 0, 16, 16, 16), Block.createCuboidShape(0, 0, 0, 15, 12, 16), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_SOUTH = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 12, 0, 16, 16, 16), Block.createCuboidShape(0, 0, 0, 16, 12, 15), BooleanBiFunction.OR);
    private static final VoxelShape SHAPE_WEST  = VoxelShapes.combineAndSimplify(Block.createCuboidShape(0, 12, 0, 16, 16, 16), Block.createCuboidShape(1, 0, 0, 16, 12, 16), BooleanBiFunction.OR);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        switch ((Direction) state.get(FACING)) {
            case UP :
            case DOWN :
            case SOUTH :
            default :
                return SHAPE_SOUTH;
            case NORTH :
                return SHAPE_NORTH;
            case WEST :
                return SHAPE_WEST;
            case EAST :
                return SHAPE_EAST;
        }
    }

    public StraightCounterBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(Properties.HORIZONTAL_FACING, ctx.getPlayerFacing().getOpposite());
    }

}
