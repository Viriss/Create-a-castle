package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.ExtendedVanillaBlockGenEnum;
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

        //evenSimplerBlockItem(ModBlocks.PINKSTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_PINKSTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_EDGE_PINKSTONE);
        //evenSimplerBlockItem(ModBlocks.PURESTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_PURESTONE);
        //evenSimplerBlockItem(ModBlocks.GILDED_EDGE_PURESTONE);
        //evenSimplerBlockItem(ModBlocks.LEAGUE_STONE_FRAME);
        evenSimplerBlockItem(ModBlocks.LEAGUE_STONE_KEY);

        //evenSimplerBlockItem(ModBlocks.RED_WOOL_SLAB);
        //evenSimplerBlockItem(ModBlocks.RED_WOOL_STAIRS);
        //evenSimplerBlockItem(ModBlocks.BLUE_WOOL_SLAB);
        //evenSimplerBlockItem(ModBlocks.BLUE_WOOL_STAIRS);
        evenSimplerBlockItem(ModBlocks.GOLD_SLAB);
        evenSimplerBlockItem(ModBlocks.GOLD_STAIRS);

        evenSimplerBlockItem(ModBlocks.SLATE_SLAB);
        evenSimplerBlockItem(ModBlocks.SLATE_STAIRS);
        wallItem(ModBlocks.SLATE_WALL, ModBlocks.SLATE);
        evenSimplerBlockItem(ModBlocks.SLATE_BRICK_SLAB);
        evenSimplerBlockItem(ModBlocks.SLATE_BRICK_STAIRS);
        wallItem(ModBlocks.SLATE_BRICK_WALL, ModBlocks.SLATE_BRICK);

        for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                if(rb.getId().getPath().equals(b.toString() + "_stairs")){
                    evenSimplerBlockItem(rb);
                }
                if(rb.getId().getPath().equals(b.toString() + "_slab")){
                    evenSimplerBlockItem(rb);
                }
                if(rb.getId().getPath().equals(b.toString() + "_wall")){
                    //evenSimplerBlockItem(rb);
                    wallItem(rb, b.BaseBlock);
                }
            }

        }
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
    public void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  new ResourceLocation(UnclesMod.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
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
}
