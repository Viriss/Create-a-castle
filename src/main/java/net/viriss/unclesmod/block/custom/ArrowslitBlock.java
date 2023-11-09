package net.viriss.unclesmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.viriss.unclesmod.block.ModBlocks;

import java.util.Optional;

public class ArrowslitBlock extends HorizontalDirectionalBlock {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public DirectionProperty getFacingProperty()
    {
        return FACING;
    }

    public static final VoxelShape SHAPE_NORTH_LEFT = Block.box(0, 0, 14, 6, 16, 16);
    public static final VoxelShape SHAPE_NORTH_RIGHT = Block.box(10, 0, 14, 16, 16, 16);
    public static final VoxelShape SHAPE_EAST_LEFT = Block.box(0, 0, 0, 6, 16, 2);
    public static final VoxelShape SHAPE_EAST_RIGHT = Block.box(10, 0, 0, 16, 16, 2);
    public static final VoxelShape SHAPE_SOUTH_LEFT = Block.box(0, 0, 0, 6, 16, 2);
    public static final VoxelShape SHAPE_SOUTH_RIGHT = Block.box(10, 0, 0, 16, 16, 2);
    public static final VoxelShape SHAPE_WEST_LEFT = Block.box(0, 0, 0, 6, 16, 2);
    public static final VoxelShape SHAPE_WEST_RIGHT = Block.box(10, 0, 0, 16, 16, 2);

    public ArrowslitBlock(Properties p_54120_) {
        super(p_54120_);
    }

    public BlockState getStateForFacing(Direction pDirection) {
        return this.defaultBlockState();
    }

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        VoxelShape shape = Shapes.or(SHAPE_NORTH_LEFT, SHAPE_NORTH_RIGHT);
        if (pState.getValue(FACING).equals(Direction.SOUTH)){
            shape = Shapes.or(SHAPE_SOUTH_LEFT, SHAPE_SOUTH_RIGHT);
        }

        return shape;
    }


    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelReader levelreader = pContext.getLevel();
        BlockState bs = this.defaultBlockState();
        bs = bs.setValue(FACING, pContext.getHorizontalDirection().getOpposite());

        //BlockPos neighbourPos = pContext.getClickedPos().offset(0,1,0); // Offset the block's position by 1 block in the current direction
        //IBlockState neighbourState = world.getBlockState(neighbourPos); // Get the IBlockState at the neighboring position
        Block neighbourBlock = levelreader.getBlockState(pContext.getClickedPos().above()).getBlock(); // neighbourState.getBlock(); // Get the IBlockState's Block
        bs = bs.setValue(UP, (neighbourBlock != ModBlocks.ARROWSLIT.get()));

        neighbourBlock = levelreader.getBlockState(pContext.getClickedPos().below()).getBlock(); // neighbourState.getBlock(); // Get the IBlockState's Block
        bs = bs.setValue(DOWN, (neighbourBlock != ModBlocks.ARROWSLIT.get()));


        return bs;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        //System.out.println(pDirection);
        if (pDirection.equals(Direction.DOWN)) {
            return pState.setValue(DOWN, !pLevel.getBlockState(pNeighborPos).is(ModBlocks.ARROWSLIT.get()));
        }
        if (pDirection.equals(Direction.UP)) {
            return pState.setValue(UP, !pLevel.getBlockState(pNeighborPos).is(ModBlocks.ARROWSLIT.get()));
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
    }

    private void checkBlockInDirection(LevelAccessor pLevel, BlockPos neighbor, Direction dir) {
        System.out.println("check block " + dir);
        if (pLevel.getBlockState(neighbor).is(ModBlocks.ARROWSLIT.get())) {
            if (dir == Direction.UP) {
                //if (pLevel.getBlockState(neighbor).getValue(DOWN)) {
                    System.out.println("found arrowslit");
                    pLevel.setBlock(neighbor, pLevel.getBlockState(neighbor).setValue(DOWN, false), 3);
                //}
            }
            if (dir == Direction.DOWN) {
                //if (pLevel.getBlockState(neighbor).getValue(UP)) {
                    pLevel.setBlock(neighbor, pLevel.getBlockState(neighbor).setValue(UP, false), 3);
                //}
            }
        }
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRot) {
        return pState.setValue(FACING, pRot.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING);
        pBuilder.add(UP);
        pBuilder.add(DOWN);
    }
}
