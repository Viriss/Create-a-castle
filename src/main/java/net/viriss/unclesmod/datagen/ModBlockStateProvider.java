package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UnclesMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SMOKY_CALCITE);
        blockWithItem(ModBlocks.PINKSTONE);
//        getVariantBuilder(ModBlocks.SLATE_BRICK.get()).addModels(
//                VariantBlockStateBuilder.PartialBlockstate(new BlockStateProvider(output, )),
//                , ModBlocks.SLATE_BRICK.get()
//        );

        wallBlock((WallBlock) ModBlocks.SLATE_BRICK_WALL.get(), blockTexture(ModBlocks.SLATE_BRICK.get()));
        slabBlock((SlabBlock) ModBlocks.SLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.SLATE_BRICK.get()), blockTexture(ModBlocks.SLATE_BRICK.get()));
        stairsBlock((StairBlock) ModBlocks.RED_WOOL_STAIRS.get(), blockTexture(Blocks.RED_WOOL));
        stairsBlock((StairBlock) ModBlocks.BLUE_WOOL_STAIRS.get(), blockTexture(Blocks.BLUE_WOOL));
        stairsBlock((StairBlock) ModBlocks.GOLD_STAIRS.get(), blockTexture(Blocks.GOLD_BLOCK));

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
