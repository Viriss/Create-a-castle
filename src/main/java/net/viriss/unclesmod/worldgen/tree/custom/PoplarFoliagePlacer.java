package net.viriss.unclesmod.worldgen.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.viriss.unclesmod.worldgen.tree.ModFoliagePlacers;

public class PoplarFoliagePlacer extends FoliagePlacer {
public static final Codec<PoplarFoliagePlacer>  CODEC = RecordCodecBuilder.create(poplarFolagePlacerInstance ->
        foliagePlacerParts(poplarFolagePlacerInstance).and(Codec.intRange(0,16).fieldOf("height")
                .forGetter(fp -> fp.height)).apply(poplarFolagePlacerInstance, PoplarFoliagePlacer::new));
    private final int height;


    public PoplarFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacers.POPLAR_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter pBlockSetter, RandomSource pRandom, TreeConfiguration pConfig, int pMaxFreeTreeHeight, FoliageAttachment pAttachment, int pFoliageHeight, int pFoliageRadius, int pOffset) {
        //tryPlaceLeaf(pLevel, p );
        this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().above(0), 0, 0, pAttachment.doubleTrunk());
        for (int i = 1; i < this.height - 2; i++) {
            this.placeLeavesRow(pLevel, pBlockSetter, pRandom, pConfig, pAttachment.pos().below(i), 1, 0, pAttachment.doubleTrunk());
        }
    }

    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
