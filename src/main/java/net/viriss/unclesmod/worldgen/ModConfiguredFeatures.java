package net.viriss.unclesmod.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.common.Tags;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TEST_ORE_KEY = registerKey("test_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_TEST_ORE_KEY = registerKey("nether_test_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_TEST_ORE_KEY = registerKey("end_test_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POPLAR_KEY = registerKey("poplar");


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new TagMatchTest(Tags.Blocks.NETHERRACK);
        RuleTest endReplaceables = new TagMatchTest(Tags.Blocks.END_STONES);

        List<OreConfiguration.TargetBlockState> overworldTestOres = List.of(
                OreConfiguration.target(stoneReplaceable, ModBlocks.BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE.get().defaultBlockState())
        );

        register(context, OVERWORLD_TEST_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTestOres, 9));
        register(context, NETHER_TEST_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE.get().defaultBlockState(), 9));
        register(context, END_TEST_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE.get().defaultBlockState(), 9));

        register(context, POPLAR_KEY, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.POPLAR_LOG.get()),
                //new StraightTrunkPlacer(7,1,1),
                new StraightTrunkPlacer(5,4,3),

                BlockStateProvider.simple(ModBlocks.POPLAR_LEAVES.get()),
                //new BlobFoliagePlacer(ConstantInt.of(1), ConstantInt.of(1), 8),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(2), 7),

                //new TwoLayersFeatureSize(0,0,1)).build()
                new TwoLayersFeatureSize(1,0,2)).build()
        );
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UnclesMod.MOD_ID, name));
    }

    public static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                         ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
