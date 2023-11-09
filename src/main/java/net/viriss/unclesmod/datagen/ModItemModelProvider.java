package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.enums.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.enums.StainedStoneBlockGenEnum;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;
import net.viriss.unclesmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UnclesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.SAPPHIRE);
        simpleItem(ModItems.LANTERN_FLOWER_SEED);
        simpleItemFromBlock(ModBlocks.LANTERN_FLOWER);

        simpleItemFromBlock(ModBlocks.RAIN_FLOWER);

        evenSimplerBlockItem(ModBlocks.ARROWSLIT);
        //arrowslitItem(ModBlocks.ARROWSLIT);

        evenSimplerBlockItem(ModBlocks.LEAGUE_STONE_KEY);
        evenSimplerDropExpBlockItem(ModBlocks.SLATE_ORE);
        evenSimplerBlockItem(ModBlocks.SLATE_SLAB);
        evenSimplerBlockItem(ModBlocks.SLATE_STAIRS);
        wallItem(ModBlocks.SLATE_WALL, ModBlocks.SLATE);
        evenSimplerBlockItem(ModBlocks.SLATE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.SLATE_BRICK_STAIRS);
        wallItem(ModBlocks.SLATE_BRICK_WALL, ModBlocks.SLATE_BRICK);

        withExistingParent(ModItems.GATHERER_GOLEM_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));

        AddExtendedVanillaBlockItems();
        AddStainedStoneBlockItems();
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UnclesMod.MOD_ID,"item/" +item.getId().getPath()));
    }
    private ItemModelBuilder simpleItemFromBlock(RegistryObject<Block> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UnclesMod.MOD_ID,"item/" +item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(UnclesMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void evenSimplerDropExpBlockItem(RegistryObject<DropExperienceBlock> block) {
        this.withExistingParent(UnclesMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(UnclesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath().replace("_fence", "")));
    }
    public void arrowslitItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/arrowslit"))
                .texture("texture", new ResourceLocation(UnclesMod.MOD_ID, "block/"+block.getId().getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, Block baseBlock) {
        String name = baseBlock.getDescriptionId();
        name = name.substring(name.lastIndexOf(".") + 1).trim();
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", "minecraft:block/" + name);

    }
    public void fenceGateItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(UnclesMod.MOD_ID, "block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(UnclesMod.MOD_ID, "block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(UnclesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void wallItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(UnclesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath().replace("_wall", "")));
    }
    public void wallItem(RegistryObject<Block> block, Block baseBlock) {
        String name = baseBlock.getDescriptionId();
        name = name.substring(name.lastIndexOf(".") + 1).trim();
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", "minecraft:block/" + name);

    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UnclesMod.MOD_ID, "item/"+item.getId().getPath()));
    }

    private void AddExtendedVanillaBlockItems() {
        for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                if(rb.getId().getPath().equals(b.toString() + "_stairs")){
                    evenSimplerBlockItem(rb);
                }
                if(rb.getId().getPath().equals(b.toString() + "_slab")){
                    evenSimplerBlockItem(rb);
                }
                if(rb.getId().getPath().equals(b.toString() + "_wall")){
                    wallItem(rb, b.BaseBlock);
                }
                if(rb.getId().getPath().equals(b.toString() + "_fence")){
                    fenceItem(rb, b.BaseBlock);
                }
                if(rb.getId().getPath().equals(b.toString() + "_fence_gate")){
                    //fenceGateItem(rb, rb);
                    evenSimplerBlockItem(rb);
                }
            }

        }
    }
    private void AddStainedStoneBlockItems() {
        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                AddStainedSet(b.toString(), b, rb);
                //AddStainedSet(b + "_brick", b, rb);
                //AddStainedSet("gilded_" + b, b, rb);
            }
        }
    }
    private void AddStainedSet(String name, StainedStoneBlockGenEnum b, RegistryObject<Block> rb) {
        if(rb.getId().getPath().equals(name)){
            evenSimplerBlockItem(rb);
        }

        if(b.BlockTypes.contains("chiseled") && rb.getId().getPath().equals("chiseled_" + name)){
            evenSimplerBlockItem(rb);
        }

        if(b.isGildedEdge() && rb.getId().getPath().equals(b.toString().replace("gilded_", "gilded_edge_"))){
            evenSimplerBlockItem(rb);
        }

        if(b.BlockTypes.contains("stairs") && rb.getId().getPath().equals(name + "_stairs")){
            evenSimplerBlockItem(rb);
        }
        if(b.BlockTypes.contains("slab") && rb.getId().getPath().equals(name + "_slab")){
            evenSimplerBlockItem(rb);
        }
        if(b.BlockTypes.contains("wall") && rb.getId().getPath().equals(name + "_wall")){
            wallItem(rb);
        }
        if(b.BlockTypes.contains("fence") && rb.getId().getPath().equals(name + "_fence")){
            fenceItem(rb, rb);
        }
        if(b.BlockTypes.contains("gate") && rb.getId().getPath().equals(name + "_fence_gate")){
            evenSimplerBlockItem(rb);
        }
    }
}
