package net.viriss.unclesmod.worldgen.tree.custom;

import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.Immutable;
import com.mojang.datafixers.FunctionType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.viriss.unclesmod.worldgen.tree.ModTrunkPlacerTypes;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class PoplarTrunkPlacer extends TrunkPlacer {
    public static final Codec<PoplarTrunkPlacer> CODEC = RecordCodecBuilder.create(poplarTrunkPlacerInstance ->
            trunkPlacerParts(poplarTrunkPlacerInstance).apply(poplarTrunkPlacerInstance, PoplarTrunkPlacer::new));

    public PoplarTrunkPlacer(int pBaseHeight, int pHeightRandA, int pHeightRandB) {
        super(pBaseHeight, pHeightRandA, pHeightRandB);
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return ModTrunkPlacerTypes.POPLAR_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader pLevel, BiConsumer<BlockPos, BlockState> pBlockSetter,
                                                            RandomSource pRandom, int pFreeTreeHeight, BlockPos pPos, TreeConfiguration pConfig) {
        setDirtAt(pLevel, pBlockSetter, pRandom, pPos.below(), pConfig);

        int height = this.getTreeHeight(pRandom);

        for(int i = 0; i < height; i++) {
            placeLog(pLevel, pBlockSetter, pRandom, pPos.above(i), pConfig);

            /*
            if (i % 2 == 0 && pRandom.nextBoolean()) {
                if (pRandom.nextFloat() > 0.25f) {
                    for (int x = 0; x < 4; x++ ){
                        pBlockSetter.accept(pPos.above(i).relative(Direction.NORTH, x + 1),
                                ((BlockState) Function.identity().apply(pConfig.trunkProvider.getState(pRandom, pPos).setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z))));
                    }
                }
            }
             */

        }

        return ImmutableList.of(new FoliagePlacer.FoliageAttachment(pPos.above(height), 0, false));
    }
}
