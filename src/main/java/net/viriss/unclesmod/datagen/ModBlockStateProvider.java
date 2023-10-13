package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.StainedStoneBlockGenEnum;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;
import net.viriss.unclesmod.block.custom.LanternFlowerCropBlock;

import java.util.function.Function;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UnclesMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.SMOKY_CALCITE);
        blockWithItem(ModBlocks.GILDED_PINKSTONE);
        blockWithItem(ModBlocks.GILDED_EDGE_PINKSTONE);
        blockWithItem(ModBlocks.GILDED_PURESTONE);
        blockWithItem(ModBlocks.GILDED_EDGE_PURESTONE);
        blockWithItem(ModBlocks.LEAGUE_STONE_FRAME);
        horizontalBlock(ModBlocks.LEAGUE_STONE_KEY.get(),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_side"),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_bottom"),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_top")
                );
        blockWithItem(ModBlocks.SLATE);
        wallBlock((WallBlock) ModBlocks.SLATE_WALL.get(), blockTexture(ModBlocks.SLATE.get()));
        slabBlock((SlabBlock) ModBlocks.SLATE_SLAB.get(), blockTexture(ModBlocks.SLATE.get()), blockTexture(ModBlocks.SLATE.get()));
        stairsBlock((StairBlock) ModBlocks.SLATE_STAIRS.get(), blockTexture(ModBlocks.SLATE.get()));

        wallBlock((WallBlock) ModBlocks.SLATE_BRICK_WALL.get(), blockTexture(ModBlocks.SLATE_BRICK.get()));
        slabBlock((SlabBlock) ModBlocks.SLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.SLATE_BRICK.get()), blockTexture(ModBlocks.SLATE_BRICK.get()));
        stairsBlock((StairBlock) ModBlocks.SLATE_BRICK_STAIRS.get(), blockTexture(ModBlocks.SLATE_BRICK.get()));


        for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                if(rb.getId().getPath().equals(b.toString() + "_stairs")){
                    stairsBlock((StairBlock) rb.get(), blockTexture(b.BaseBlock));
                }
                if(rb.getId().getPath().equals(b.toString() + "_slab")){
                    slabBlock((SlabBlock) rb.get(), blockTexture(b.BaseBlock), blockTexture(b.BaseBlock));
                }
                if(rb.getId().getPath().equals(b.toString() + "_wall")){
                    wallBlock((WallBlock) rb.get(), blockTexture(b.BaseBlock));
                }
            }
        }

        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                ResourceLocation rl = new ResourceLocation(UnclesMod.MOD_ID, "block/" + b.toString());
                if(rb.getId().getPath().equals(b.toString())){
                    blockWithItem(rb);
                }
                if(rb.getId().getPath().equals(b.toString() + "_stairs")){
                    stairsBlock((StairBlock) rb.get(), rl);
                }
                if(rb.getId().getPath().equals(b.toString() + "_slab")){
                    slabBlock((SlabBlock) rb.get(), rl, rl);
                }
                if(rb.getId().getPath().equals(b.toString() + "_wall")){
                    wallBlock((WallBlock) rb.get(), rl);
                }
            }
        }

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

        makeLanternFlowerCrop((CropBlock) ModBlocks.LANTERN_FLOWER_CROP.get(), "lantern_flower_stage", "lantern_flower_stage");
    }

    public void makeLanternFlowerCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lanternFlowerStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lanternFlowerStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        //models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()),
        //        new ResourceLocation(UnclesMod.MOD_ID, "block/" + textureName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()))).renderType("cutout"));
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + textureName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
