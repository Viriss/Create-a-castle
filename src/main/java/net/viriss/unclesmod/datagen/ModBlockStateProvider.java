package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.*;
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
        blockWithItem(ModBlocks.GILDED_PINKSTONE);
        blockWithItem(ModBlocks.GILDED_EDGE_PINKSTONE);
        blockWithItem(ModBlocks.PURESTONE);
        blockWithItem(ModBlocks.GILDED_PURESTONE);
        blockWithItem(ModBlocks.GILDED_EDGE_PURESTONE);
        blockWithItem(ModBlocks.LEAGUE_STONE_FRAME);
        horizontalBlock(ModBlocks.LEAGUE_STONE_KEY.get(),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_side"),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_bottom"),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_top")
                );
        blockWithItem(ModBlocks.SLATE);
        wallBlock((WallBlock) ModBlocks.SLATE_BRICK_WALL.get(), blockTexture(ModBlocks.SLATE_BRICK.get()));
        slabBlock((SlabBlock) ModBlocks.SLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.SLATE_BRICK.get()), blockTexture(ModBlocks.SLATE_BRICK.get()));
        stairsBlock((StairBlock) ModBlocks.RED_WOOL_STAIRS.get(), blockTexture(Blocks.RED_WOOL));
        stairsBlock((StairBlock) ModBlocks.BLUE_WOOL_STAIRS.get(), blockTexture(Blocks.BLUE_WOOL));
        stairsBlock((StairBlock) ModBlocks.GOLD_STAIRS.get(), blockTexture(Blocks.GOLD_BLOCK));

        //horizontalBlock();

        //VariantBlockStateBuilder builder = getVariantBuilder(ModBlocks.SLATE_BRICK.get());
        //ConfiguredModel[] models = new ConfiguredModel[4];
        //models[0] = new ConfiguredModel();
        //builder.setModels(models)

        /*
        VariantBlockStateBuilder builder = getVariantBuilder(ModBlocks.SLATE_BRICK.get());
        for (int i = 0; i <= 4; i++) {
            //ResourceLocation txt = new ResourceLocation(UnclesMod.MOD_ID, "block/"+ModBlocks.SLATE_BRICK.getId().getPath() + "_" +(i+1));
            //BlockModelBuilder model = p.models().cubeAll(ForgeRegistries.BLOCKS.getKey(block).getPath() + (idx == 0 ? "" : idx), txt);

            ModelFile _file = models().cross(ModBlocks.SLATE_BRICK.getId().getPath() + "_" + (i + 1),
                    new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.SLATE_BRICK.getId().getPath() + "_" + (i+1)));
            builder.partialState().modelForState().modelFile(_file).addModel(
                builder.addModels(
                    new ConfiguredModel(simpleBlockWithItem(ModBlocks.SLATE_BRICK.get()
                    //,new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.SLATE_BRICK.getId().getPath() + "_" + (i+1))))
                    //, new ConfiguredModel(_file,0,0,false, 100)
                            ,ConfiguredModel.builder().addModel()
                            //models().cross(ModBlocks.SLATE_BRICK.getId().getPath() + "_" + (i + 1),
//                                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.SLATE_BRICK.getId().getPath() + "_" + (i+1)))

            );


            // this withExistingParent(UnclesMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
            //                            modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath())))

        }
 */




    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
