package net.viriss.unclesmod.datagen;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.block.ModBlocks;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SMOKY_CALCITE.get());
        this.dropSelf(ModBlocks.PINKSTONE.get());
        this.dropSelf(ModBlocks.GILDED_PINKSTONE.get());
        this.dropSelf(ModBlocks.GILDED_EDGE_PINKSTONE.get());
        this.dropSelf(ModBlocks.PURESTONE.get());
        this.dropSelf(ModBlocks.GILDED_PURESTONE.get());
        this.dropSelf(ModBlocks.GILDED_EDGE_PURESTONE.get());
        this.dropSelf(ModBlocks.SLATE.get());
        this.dropSelf(ModBlocks.SLATE_BRICK.get());
        this.dropSelf(ModBlocks.SLATE_BRICK_STAIRS.get());
        this.add(ModBlocks.SLATE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SLATE_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.SLATE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.LEAGUE_STONE_FRAME.get());
        this.dropSelf(ModBlocks.LEAGUE_STONE_KEY.get());
        this.dropSelf(ModBlocks.RED_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.BLUE_WOOL_STAIRS.get());
        this.dropSelf(ModBlocks.GOLD_STAIRS.get());
        this.dropOther(ModBlocks.SLATE_ORE.get(), ModBlocks.SLATE.get());


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
