package net.viriss.unclesmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.viriss.unclesmod.item.ModItems;

import java.util.function.ToIntFunction;

public class LanternFlowerCropBlock extends CropBlock {
    public final static int MAX_AGE = 7;
    public final static IntegerProperty AGE = BlockStateProperties.AGE_7;
    public final static BooleanProperty IS_LIT = BlockStateProperties.LIT;

    public LanternFlowerCropBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ModItems.LANTERN_FLOWER_SEED.get();
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    public BooleanProperty getLitProperty() {
        return IS_LIT;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }
    public BlockState getStateForLit(boolean bLit) {
        return this.defaultBlockState().setValue(this.getLitProperty(), Boolean.valueOf(bLit));
    }
    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (!pLevel.isAreaLoaded(pPos, 1)) return;
        if (pLevel.getRawBrightness(pPos, 0) >= 9) {
            int currentAge = this.getAge(pState);

            if (currentAge < this.getMaxAge()) {
                float growthSpeed = getGrowthSpeed(this, pLevel, pPos);

                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(pLevel, pPos, pState, pRandom.nextInt((int)(25.0F / growthSpeed) + 1) == 0)) {
                    if(currentAge == MAX_AGE) {
                        pLevel.setBlock(pPos, this.getStateForLit(true), 2);
                        if (!pState.getValue(this.getLitProperty())) {
                            //if(pLevel.getBlockState(pPos.above(1)).is(Blocks.AIR)) {
                            //    pLevel.setBlock(pPos.above(1), this.getStateForAge(currentAge + 1), 2);
                            //}
                            pLevel.setBlock(pPos, this.getStateForLit(true), 2);
                            //pLevel.setBlock(pPos, this.getLightEmission(pState.getLightEmission(pLevel, pPos),pLevel, pPos), 1);
                            //pLevel.setBlock(pPos, this.getLightEmission(pState, pLevel, pPos));

                            //pState = pState.setValue(AbstractFurnaceBlock.LIT, pState.getValue(this.getLitProperty()));
                            //pLevel.setBlock(pPos, pState, 3);
                        }
                    } else {
                        pLevel.setBlock(pPos, this.getStateForAge(currentAge + 1), 2);
                    }

                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(pLevel, pPos, pState);
                }


            }
        }
    }

//    public static ToIntFunction<BlockState> litBlockEmission(int i) {
//        return (blockState) -> this.getLitProperty() ? i : 0;
//    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(AGE);
        pBuilder.add(IS_LIT);
    }
}
