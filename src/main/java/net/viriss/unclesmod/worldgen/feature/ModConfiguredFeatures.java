//package net.viriss.unclesmod.worldgen.feature;
//
//import net.minecraft.core.registries.Registries;
//import net.minecraft.data.worldgen.BootstapContext;
//import net.minecraft.resources.ResourceKey;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.tags.BlockTags;
//import net.minecraft.util.valueproviders.ConstantInt;
//import net.minecraft.world.level.block.Blocks;
//import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
//import net.minecraft.world.level.levelgen.feature.Feature;
//import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
//import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
//import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
//import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
//import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
//import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
//import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
//import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
//import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
//import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
//import net.viriss.unclesmod.UnclesMod;
//import net.viriss.unclesmod.block.ModBlocks;
//
//import java.util.List;
//
//public class ModConfiguredFeatures {
//
//    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SLATE_KEY = registerKey("slate");
//
//    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
//        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
//        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
//        //RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
//        //RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);
//
//        List<OreConfiguration.TargetBlockState> overworldSlate = List.of(OreConfiguration.target(stoneReplaceables,
//                        ModBlocks.SLATE.get().defaultBlockState()),
//                OreConfiguration.target(deepslateReplaceables, ModBlocks.SLATE.get().defaultBlockState())
//                );
//
//        register(context, OVERWORLD_SLATE_KEY, Feature.ORE, new OreConfiguration(overworldSlate, 9));
//        /*
//        register(context, END_BLACK_OPAL_ORE_KEY, Feature.ORE, new OreConfiguration(endstoneReplaceables,
//                ModBlocks.ENDSTONE_BLACK_OPAL_ORE.get().defaultBlockState(), 9));
//        register(context, NETHER_BLACK_OPEL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
//                ModBlocks.NETHERRACK_BLACK_OPAL_ORE.get().defaultBlockState(), 9));
//
//         */
//    }
//
//
//    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
//        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UnclesMod.MOD_ID, name));
//    }
//
//    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
//                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
//        context.register(key, new ConfiguredFeature<>(feature, configuration));
//    }
//}