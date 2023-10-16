package net.viriss.unclesmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

import java.util.function.Supplier;

public class RainFlowerBlock extends FlowerBlock {

    public final static IntegerProperty RAIN_LEVEL = IntegerProperty.create("raining", 0, 15);
    public final static BooleanProperty IS_THUNDERING = BooleanProperty.create("thundering");

    public RainFlowerBlock(Supplier<MobEffect> effectSupplier, int pEffectDuration, Properties pProperties) {
        super(effectSupplier, pEffectDuration, pProperties);
    }

    @Override
    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        //Float rain_level = pLevel.rainLevel;
        //Float thunder_level = pLevel.thunderLevel;
        //System.out.println("rain level: " + rain_level + ", thunder: " + thunder_level);

        int moon = pLevel.dimensionType().moonPhase(pLevel.getDayTime());
        System.out.println("moon: " + moon);
    }

    @Override
    public boolean isRandomlyTicking(BlockState pState) {
        return true;
        //return super.isRandomlyTicking(pState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(RAIN_LEVEL);
        pBuilder.add(IS_THUNDERING);
    }
}
