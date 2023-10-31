package net.viriss.unclesmod.datagen;

import com.simibubi.create.content.materials.ExperienceBlock;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.predicate.BlockStatePredicate;
import net.minecraft.world.level.storage.loot.predicates.TimeCheck;
import net.minecraft.world.level.storage.loot.predicates.WeatherCheck;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.block.custom.KeneticLampBlock;
import net.viriss.unclesmod.enums.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.enums.StainedStoneBlockGenEnum;
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
        blockWithItemKenetic(ModBlocks.CREATE_LAMP);

        blockWithItem(ModBlocks.SMOKY_CALCITE);
        blockWithItem(ModBlocks.BLUE_GLAZED_TERRACOTTA_DIAMOND_TILE);
        blockWithItem(ModBlocks.BLUE_GLAZED_TERRACOTTA_CHEVRON_TILE);
        blockWithItem(ModBlocks.BLACK_GLAZED_TERRACOTTA_DIAMOND_TILE);
        blockWithItem(ModBlocks.BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE);
        blockWithItem(ModBlocks.LEAGUE_STONE_FRAME);
        horizontalBlock(ModBlocks.LEAGUE_STONE_KEY.get(),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_side"),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_bottom"),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + ModBlocks.LEAGUE_STONE_KEY.getId().getPath() + "_top")
                );
        blockWithItem(ModBlocks.SLATE);
        expBlockWithItem(ModBlocks.SLATE_ORE);
        wallBlock((WallBlock) ModBlocks.SLATE_WALL.get(), blockTexture(ModBlocks.SLATE.get()));
        slabBlock((SlabBlock) ModBlocks.SLATE_SLAB.get(), blockTexture(ModBlocks.SLATE.get()), blockTexture(ModBlocks.SLATE.get()));
        stairsBlock((StairBlock) ModBlocks.SLATE_STAIRS.get(), blockTexture(ModBlocks.SLATE.get()));

        wallBlock((WallBlock) ModBlocks.SLATE_BRICK_WALL.get(), blockTexture(ModBlocks.SLATE_BRICK.get()));
        slabBlock((SlabBlock) ModBlocks.SLATE_BRICK_SLAB.get(), blockTexture(ModBlocks.SLATE_BRICK.get()), blockTexture(ModBlocks.SLATE_BRICK.get()));
        stairsBlock((StairBlock) ModBlocks.SLATE_BRICK_STAIRS.get(), blockTexture(ModBlocks.SLATE_BRICK.get()));

        simpleBlockWithItem(ModBlocks.RAIN_FLOWER.get(), models().cross(blockTexture(ModBlocks.RAIN_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.RAIN_FLOWER.get())).renderType("cutout"));

        simpleBlockWithItem(ModBlocks.LANTERN_FLOWER.get(), models().cross(blockTexture(ModBlocks.LANTERN_FLOWER.get()).getPath(),
                blockTexture(ModBlocks.LANTERN_FLOWER.get())).renderType("cutout"));
        simpleBlockWithItem(ModBlocks.POTTED_LANTERN_FLOWER.get(), models().singleTexture("potted_lantern_flower",
                new ResourceLocation("flower_pot_cross"), "plant",
                blockTexture(ModBlocks.LANTERN_FLOWER.get())).renderType("cutout"));

        makeLanternFlowerCrop((CropBlock) ModBlocks.LANTERN_FLOWER_CROP.get(), "lantern_flower_stage", "lantern_flower_stage");

        AddExtendedVanillaBlockStates();
        AddStainedStoneBlockStates();

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

    public void makeLanternFlowerCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> lanternFlowerStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] lanternFlowerStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()),
                new ResourceLocation(UnclesMod.MOD_ID, "block/" + textureName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()))).renderType("cutout"));
        //models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()),
        //        new ResourceLocation(UnclesMod.MOD_ID, "block/" + textureName + state.getValue(((LanternFlowerCropBlock) block).getAgeProperty()))).renderType("cutout"));
        return models;
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
    private void expBlockWithItem(RegistryObject<DropExperienceBlock> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }
    private void blockWithItemKenetic(RegistryObject<KeneticLampBlock> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));

    }

    private void AddExtendedVanillaBlockStates() {
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
                if(rb.getId().getPath().equals(b.toString() + "_fence")){
                    fenceBlock((FenceBlock) rb.get(), blockTexture(b.BaseBlock));
                }
                if(rb.getId().getPath().equals(b.toString() + "_fence_gate")){
                    fenceGateBlock((FenceGateBlock) rb.get(), blockTexture(b.BaseBlock));
                }
            }
        }
    }
    private void AddStainedStoneBlockStates() {
        String name;
        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                name = b.toString();
                AddStainedSet(name, b, rb);
                //AddStainedSet(name + "_brick", b, rb);
                //AddStainedSet("gilded_" + name, b, rb);


            }
        }
    }
    private void AddStainedSet(String name, StainedStoneBlockGenEnum sb, RegistryObject<Block> rb) {
        ResourceLocation rl = new ResourceLocation(UnclesMod.MOD_ID, "block/" + name);
        String gl_name = name.replace("gilded_", "gilded_edge_");

        if(rb.getId().getPath().equals(name)){
            blockWithItem(rb);
        }

        if(sb.BlockTypes.contains("chiseled") && rb.getId().getPath().equals("chiseled_" + name)){
            blockWithItem(rb);
        }

        if(sb.isGildedEdge() && rb.getId().getPath().equals(gl_name)){
            ModelFile mf = models().cubeAll("block/" + gl_name,
                            new ResourceLocation(UnclesMod.MOD_ID, "block/" + gl_name))
                    .texture("particle", "block/" + gl_name)
                    .texture("up", "block/" + gl_name)
                    .texture("down", "block/" + gl_name)
                    .texture("north", "block/" + gl_name + "_right")
                    .texture("south", "block/" + gl_name + "_right")
                    .texture("east", "block/" + gl_name + "_left")
                    .texture("west", "block/" + gl_name + "_left");
            this.getVariantBuilder(rb.get())
                    .partialState().with(HorizontalDirectionalBlock.FACING, Direction.NORTH)
                    .modelForState().modelFile(mf).addModel();
            this.getVariantBuilder(rb.get())
                    .partialState().with(HorizontalDirectionalBlock.FACING, Direction.EAST)
                    .modelForState().modelFile(mf).rotationY(90).addModel();
            this.getVariantBuilder(rb.get())
                    .partialState().with(HorizontalDirectionalBlock.FACING, Direction.SOUTH)
                    .modelForState().modelFile(mf).rotationY(180).addModel();
            this.getVariantBuilder(rb.get())
                    .partialState().with(HorizontalDirectionalBlock.FACING, Direction.WEST)
                    .modelForState().modelFile(mf).rotationY(270).addModel();
        }

        if(sb.BlockTypes.contains("stairs") && rb.getId().getPath().equals(name + "_stairs")){
            stairsBlock((StairBlock) rb.get(), rl);
        }
        if(sb.BlockTypes.contains("slab") && rb.getId().getPath().equals(name + "_slab")){
            slabBlock((SlabBlock) rb.get(), rl, rl);
        }
        if(sb.BlockTypes.contains("wall") && rb.getId().getPath().equals(name + "_wall")){
            wallBlock((WallBlock) rb.get(), rl);
        }
        if(sb.BlockTypes.contains("fence") && rb.getId().getPath().equals(name + "_fence")){
            fenceBlock((FenceBlock) rb.get(), rl);
        }
        if(sb.BlockTypes.contains("gate") && rb.getId().getPath().equals(name + "_fence_gate")){
            fenceGateBlock((FenceGateBlock) rb.get(), rl);
        }

    }
}
