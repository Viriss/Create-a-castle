package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
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

        //evenSimplerBlockItem(ModBlocks.PINKSTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_PINKSTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_EDGE_PINKSTONE);
        //evenSimplerBlockItem(ModBlocks.PURESTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_PURESTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_EDGE_PURESTONE);
        //evenSimplerBlockItem(ModBlocks.LEAGUE_STONE_FRAME);
        evenSimplerBlockItem(ModBlocks.LEAGUE_STONE_KEY);

        evenSimplerBlockItem(ModBlocks.RED_WOOL_STAIRS);
        evenSimplerBlockItem(ModBlocks.BLUE_WOOL_STAIRS);
        evenSimplerBlockItem(ModBlocks.GOLD_STAIRS);

        evenSimplerBlockItem(ModBlocks.SLATE_BRICK_SLAB);
        wallItem(ModBlocks.SLATE_BRICK_WALL, ModBlocks.SLATE_BRICK);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UnclesMod.MOD_ID,"item/" +item.getId().getPath()));
    }
    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(UnclesMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(UnclesMod.MOD_ID, "block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(UnclesMod.MOD_ID, "block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
/*
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), modLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(UnclesMod.MOD_ID, "block/"+ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
 */
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(UnclesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(UnclesMod.MOD_ID, "item/"+item.getId().getPath()));
    }
}
