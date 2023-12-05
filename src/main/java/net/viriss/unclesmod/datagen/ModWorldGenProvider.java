package net.viriss.unclesmod.datagen;


import net.minecraftforge.registries.ForgeRegistries;
import net.viriss.unclesmod.UnclesMod;
//import net.viriss.unclesmod.worldgen.feature.ModConfiguredFeatures;
//import net.viriss.unclesmod.worldgen.feature.ModPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.viriss.unclesmod.worldgen.ModBiomeModifiers;
import net.viriss.unclesmod.worldgen.ModConfiguredFeatures;
import net.viriss.unclesmod.worldgen.ModPlacedFeatures;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(UnclesMod.MOD_ID));
    }
}