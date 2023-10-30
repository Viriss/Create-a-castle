package net.viriss.unclesmod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.enums.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.enums.StainedStoneBlockGenEnum;
import net.viriss.unclesmod.block.ModBlocks;
import net.viriss.unclesmod.block.custom.LanternFlowerCropBlock;
import net.viriss.unclesmod.item.ModItems;

import java.util.*;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.SMOKY_CALCITE.get());
        this.dropSelf(ModBlocks.BLUE_GLAZED_TERRACOTTA_DIAMOND_TILE.get());
        this.dropSelf(ModBlocks.BLUE_GLAZED_TERRACOTTA_CHEVRON_TILE.get());
        this.dropSelf(ModBlocks.BLACK_GLAZED_TERRACOTTA_DIAMOND_TILE.get());
        this.dropSelf(ModBlocks.BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE.get());
        this.dropSelf(ModBlocks.SLATE.get());
        this.dropSelf(ModBlocks.SLATE_STAIRS.get());
        this.add(ModBlocks.SLATE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SLATE_SLAB.get()));
        this.dropSelf(ModBlocks.SLATE_WALL.get());
        this.dropSelf(ModBlocks.SLATE_BRICK.get());
        this.dropSelf(ModBlocks.SLATE_BRICK_STAIRS.get());
        this.add(ModBlocks.SLATE_BRICK_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.SLATE_BRICK_SLAB.get()));
        this.dropSelf(ModBlocks.SLATE_BRICK_WALL.get());
        this.dropSelf(ModBlocks.LEAGUE_STONE_FRAME.get());
        this.dropSelf(ModBlocks.LEAGUE_STONE_KEY.get());

        this.dropSelf(ModBlocks.RAIN_FLOWER.get());
        this.dropSelf(ModBlocks.LANTERN_FLOWER.get());
        this.add(ModBlocks.POTTED_LANTERN_FLOWER.get(), createPotFlowerItemTable(ModBlocks.LANTERN_FLOWER.get()));
        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.LANTERN_FLOWER_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(LanternFlowerCropBlock.AGE, LanternFlowerCropBlock.MAX_AGE));
        this.add(ModBlocks.LANTERN_FLOWER_CROP.get(), createCropDrops(ModBlocks.LANTERN_FLOWER_CROP.get(), ModItems.LANTERN_FLOWER_SEED.get(),
                ModItems.LANTERN_FLOWER_SEED.get(), lootitemcondition$builder));

        this.dropSelf(ModBlocks.CREATE_LAMP.get());

        AddExtendedVanillaBlocks();
        AddStainedStoneBlocks();
    }

    private void AddExtendedVanillaBlocks() {
        for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                if(rb.getId().getPath().startsWith(b.toString())){
                    this.dropSelf(rb.get());
                }
            }
        }

    }

    private void AddStainedStoneBlocks() {
        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                String name = b.toString();
                if(rb.getId().getPath().startsWith(name)){
                    this.dropSelf(rb.get());
                }
                if(rb.getId().getPath().startsWith("chiseled_" + name)){
                    this.dropSelf(rb.get());
                }

                if(rb.getId().getPath().startsWith(name + "_brick")){
                    this.dropSelf(rb.get());
                }
                if(rb.getId().getPath().startsWith("gilded_" + name)){
                    this.dropSelf(rb.get());
                }

                if(rb.getId().getPath().startsWith("gilded_edge_" + name)){
                    this.dropSelf(rb.get());
                }
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
