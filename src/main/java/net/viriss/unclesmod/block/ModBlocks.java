package net.viriss.unclesmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.custom.LanternFlowerCropBlock;
import net.viriss.unclesmod.block.custom.LeagueStoneFrameBlock;
import net.viriss.unclesmod.block.custom.LeagueStoneKeyBlock;
import net.viriss.unclesmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UnclesMod.MOD_ID);



    public static final RegistryObject<Block> SMOKY_CALCITE = registerBlock("smoky_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> PINKSTONE = registerBlock("pinkstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> GILDED_PINKSTONE = registerBlock("gilded_pinkstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> GILDED_EDGE_PINKSTONE = registerBlock("gilded_edge_pinkstone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> PURESTONE = registerBlock("purestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> GILDED_PURESTONE = registerBlock("gilded_purestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> GILDED_EDGE_PURESTONE = registerBlock("gilded_edge_purestone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIORITE)));
    public static final RegistryObject<Block> SLATE = registerBlock("slate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SLATE_STAIRS = registerBlock("slate_stairs",
            () -> new StairBlock(() -> ModBlocks.SLATE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SLATE_SLAB = registerBlock("slate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SLATE_WALL = registerBlock("slate_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> SLATE_BRICK = registerBlock("slate_brick",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SLATE_BRICK_STAIRS = registerBlock("slate_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SLATE_BRICK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SLATE_BRICK_SLAB = registerBlock("slate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    public static final RegistryObject<Block> SLATE_BRICK_WALL = registerBlock("slate_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));

    public static final RegistryObject<Block> LEAGUE_STONE_KEY = registerBlock("league_stone_key",
            () -> new LeagueStoneKeyBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f)));
    public static final RegistryObject<Block> LEAGUE_STONE_FRAME = registerBlock("league_stone_frame",
            () -> new LeagueStoneFrameBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4f)

            ));
/*
    public static final RegistryObject<Block> RED_WOOL_STAIRS = registerBlock("red_wool_stairs",
            () -> new StairBlock(() -> Blocks.RED_WOOL.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.RED_WOOL)
            ));
    public static final RegistryObject<Block> RED_WOOL_SLAB = registerBlock("red_wool_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));

    public static final RegistryObject<Block> BLUE_WOOL_STAIRS = registerBlock("blue_wool_stairs",
            () -> new StairBlock(() -> Blocks.BLUE_WOOL.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)
            ));
    public static final RegistryObject<Block> BLUE_WOOL_SLAB = registerBlock("blue_wool_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BLUE_WOOL)));
*/

    public static final RegistryObject<Block> GOLD_STAIRS = registerBlock("gold_stairs",
            () -> new StairBlock(() -> Blocks.GOLD_BLOCK.defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)
            ));
    public static final RegistryObject<Block> GOLD_SLAB = registerBlock("gold_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK)));


    public static final RegistryObject<CropBlock> LANTERN_FLOWER_CROP = registerBlock("lantern_flower_crop",
                () -> new LanternFlowerCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                        .lightLevel((p_50886_) -> { return 9;})
                        //.lightLevel(litBlockEmission(13))
                        .noCollission()
                        .noCollission()));


    public static void AddWoolStairsAndSlabs(){
         for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            String name = b.toString();

            //String name = b.getDescriptionId() + "as+df";
            registerBlock( name + "_stairs",
                    () -> new StairBlock(() -> b.BaseBlock.defaultBlockState(),
                            BlockBehaviour.Properties.copy(b.BaseBlock)
                    ));
            registerBlock(name + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(b.BaseBlock)));
            registerBlock(name + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(b.BaseBlock)));
        }


    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        AddWoolStairsAndSlabs();
        BLOCKS.register(eventBus);
    }
}
