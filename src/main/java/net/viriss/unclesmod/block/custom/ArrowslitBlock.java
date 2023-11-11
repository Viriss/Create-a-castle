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

    public static final VoxelShape SHAPE_NORTH_LEFT = Block.box(0, 0, 15, 5, 16, 16);
    public static final VoxelShape SHAPE_NORTH_RIGHT = Block.box(11, 0, 15, 16, 16, 16);
    public static final VoxelShape SHAPE_WEST_LEFT = Block.box(15, 0, 0, 16, 16, 5);
    public static final VoxelShape SHAPE_WEST_RIGHT = Block.box(15, 0, 11, 16, 16, 16);
    public static final VoxelShape SHAPE_SOUTH_LEFT = Block.box(0, 0, 0, 5, 16, 1);
    public static final VoxelShape SHAPE_SOUTH_RIGHT = Block.box(11, 0, 0, 16, 16, 1);
    public static final VoxelShape SHAPE_EAST_LEFT = Block.box(0, 0, 11, 1, 16, 16);
    public static final VoxelShape SHAPE_EAST_RIGHT = Block.box(0, 0, 0, 1, 16, 5);

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
        if (pState.getValue(FACING).equals(Direction.EAST)){
            shape = Shapes.or(SHAPE_EAST_LEFT, SHAPE_EAST_RIGHT);
        }
        if (pState.getValue(FACING).equals(Direction.WEST)){
            shape = Shapes.or(SHAPE_WEST_LEFT, SHAPE_WEST_RIGHT);
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
        BlockState nBS = levelreader.getBlockState(pContext.getClickedPos().above());
        boolean showLedge = true;
        if (nBS.getBlock() == ModBlocks.ARROWSLIT.get()) {
            if (nBS.getValue(FACING).equals(pContext.getHorizontalDirection().getOpposite())) {
                showLedge = false;
            }
        }
        bs = bs.setValue(UP, showLedge);

        nBS = levelreader.getBlockState(pContext.getClickedPos().below());
        showLedge = true;
        if (nBS.getBlock() == ModBlocks.ARROWSLIT.get()) {
            if (nBS.getValue(FACING).equals(pContext.getHorizontalDirection().getOpposite())) {
                showLedge = false;
            }
        }
        bs = bs.setValue(DOWN, showLedge);

        return bs;
    }

    @Override
    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        //System.out.println(pDirection);
        if (pDirection.equals(Direction.DOWN)) {
            if (pLevel.getBlockState(pNeighborPos).is(ModBlocks.ARROWSLIT.get())) {
                if (pNeighborState.getValue(FACING).equals(pState.getValue(FACING))) {
                    return pState.setValue(DOWN, !pLevel.getBlockState(pNeighborPos).is(ModBlocks.ARROWSLIT.get()));
                }
                else {
                    return pState.setValue(DOWN, true);
                }
            }
            else {
                return pState.setValue(DOWN, true);
            }
        }
        if (pDirection.equals(Direction.UP)) {
            if (pLevel.getBlockState(pNeighborPos).is(ModBlocks.ARROWSLIT.get())) {
                if (pNeighborState.getValue(FACING).equals(pState.getValue(FACING))) {
                    return pState.setValue(UP, !pLevel.getBlockState(pNeighborPos).is(ModBlocks.ARROWSLIT.get()));
                }
                else {
                    return pState.setValue(UP, true);
                }
            }
            else {
                return pState.setValue(UP, true);
            }
        }

        return super.updateShape(pState, pDirection, pNeighborState, pLevel, pCurrentPos, pNeighborPos);
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
