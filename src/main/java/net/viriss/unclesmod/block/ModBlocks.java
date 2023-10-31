package net.viriss.unclesmod.block;

import net.minecraft.util.valueproviders.UniformInt;
import com.simibubi.create.content.kinetics.base.DirectionalKineticBlock;
import com.simibubi.create.content.kinetics.base.IRotate;
import com.simibubi.create.foundation.block.IBE;
import com.simibubi.create.foundation.utility.VoxelShaper;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.block.custom.*;
import net.viriss.unclesmod.enums.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.enums.StainedStoneBlockGenEnum;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

import static com.simibubi.create.Create.REGISTRATE;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UnclesMod.MOD_ID);

    public static final RegistryObject<Block> SMOKY_CALCITE = registerBlock("smoky_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));

    public static final RegistryObject<Block> BLUE_GLAZED_TERRACOTTA_DIAMOND_TILE = registerBlock("blue_glazed_terracotta_diamond_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA)));
    public static final RegistryObject<Block> BLUE_GLAZED_TERRACOTTA_CHEVRON_TILE = registerBlock("blue_glazed_terracotta_chevron_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA)));
    public static final RegistryObject<Block> BLACK_GLAZED_TERRACOTTA_DIAMOND_TILE = registerBlock("black_glazed_terracotta_diamond_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA)));
    public static final RegistryObject<Block> BLACK_GLAZED_TERRACOTTA_CHEVRON_TILE = registerBlock("black_glazed_terracotta_chevron_tile",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BLUE_GLAZED_TERRACOTTA)));


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

    public static final RegistryObject<Block> RAIN_FLOWER = registerBlock("rain_flower",
            () -> new RainFlowerBlock(() -> MobEffects.LUCK, 0, BlockBehaviour.Properties.copy(Blocks.BLUE_ORCHID)
                    .noCollission()
                    .noCollission()));

    public static final RegistryObject<DropExperienceBlock> SLATE_ORE = registerBlock( "slate_ore",
            () -> new DropExperienceBlock(
                    BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK),
                    UniformInt.of(4,7)
            ));

    public static final RegistryObject<Block> LANTERN_FLOWER = registerBlock("lantern_flower",
            () -> new FlowerBlock(MobEffects.LUCK, 0, BlockBehaviour.Properties.copy(Blocks.RED_TULIP)
                    .lightLevel((state) -> 15)
                    .noCollission()
                    .noCollission()));
    public static final RegistryObject<Block> POTTED_LANTERN_FLOWER = BLOCKS.register("potted_lantern_flower",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.LANTERN_FLOWER,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_RED_TULIP)
                            .lightLevel((state) -> 15)
                            .noOcclusion()));
    public static final RegistryObject<CropBlock> LANTERN_FLOWER_CROP = registerBlock("lantern_flower_crop",
            () -> new LanternFlowerCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)
                    .lightLevel(state -> LanternLightLevel(state.getValue(LanternFlowerCropBlock.AGE)))
                    .noCollission()
                    .noCollission()));
    /*
        public static final RegistryObject<ShaftBlock> SHAFT = REGISTRATE.block("shaft", ShaftBlock::new)
                .initialProperties(SharedProperties::stone)
                //.properties(p -> p.color(MaterialColor.METAL))
                .transform(BlockStressDefaults.setNoImpact())
                .transform(pickaxeOnly())
                .blockstate(BlockStateGen.axisBlockProvider(false))
                .onRegister(CreateRegistrate.blockModel(() -> BracketedKineticBlockModel::new))
                .simpleItem()
                .register();
    */
    public static final RegistryObject<KeneticLampBlock> CREATE_LAMP = registerBlock("create_lamp",
            () -> new KeneticLampBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT))
    );


    public static Integer LanternLightLevel(Integer age) {
        if (age < 4) {
            return 0;
        }
        return (int) ((Math.floor(age - 4) * 5) + 1);
    }

    private static void AddStainedStoneBlocks() {
        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            String name = b.toString();
            AddStainedSet(name, b);
        }
    }

    private static void AddStainedSet(String name, StainedStoneBlockGenEnum b) {
        String blockTypes = b.BlockTypes;
        registerBlock(name, () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));

        if (b.isChiseled()) {
            registerBlock("chiseled_" + name, () -> new GildedEdgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f)));
        }

        if (b.isGildedEdge()) {
            registerBlock(name.replace("gilded_", "gilded_edge_"), () -> new GildedEdgeBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(4f)));
        }

        if (blockTypes.contains("stairs")) {
            registerBlock(name + "_stairs",
                    () -> new StairBlock(() -> Blocks.STONE_STAIRS.defaultBlockState(),
                            BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
        }
        if (blockTypes.contains("slab")) {
            registerBlock(name + "_slab",
                    () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
        }
        if (blockTypes.contains("wall")) {
            registerBlock(name + "_wall",
                    () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
        }
        if (blockTypes.contains("fence")) {
            registerBlock(name + "_fence",
                    () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)));
        }
        if (blockTypes.contains("gate")) {
            registerBlock(name + "_fence_gate",
                    () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE),
                            WoodType.BIRCH.fenceGateOpen(), WoodType.BIRCH.fenceGateClose()));

        }
    }

    public static Block getBlockByName(String name) {
        for (RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()) {
            if (rb.getId().getPath().equals(name.toLowerCase())) {
                return rb.get();
            }
        }
        return null;
    }


    private static void AddExtendedVanillaBlocks() {
        for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            String name = b.toString();
            if (b.isStairs()) {
                registerBlock(name + "_stairs",
                        () -> new StairBlock(() -> b.BaseBlock.defaultBlockState(),
                                BlockBehaviour.Properties.copy(b.BaseBlock)
                        ));
            }
            if (b.isSlab()) {
                registerBlock(name + "_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(b.BaseBlock)));
            }
            if (b.isWall()) {
                registerBlock(name + "_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(b.BaseBlock)));
            }
            if (b.isFence()) {
                registerBlock(name + "_fence", () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE)));
            }
            if (b.isGate()) {
                registerBlock(name + "_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_FENCE_GATE),
                        WoodType.BIRCH.fenceGateOpen(), WoodType.BIRCH.fenceGateClose()));
            }
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

    public static void register(IEventBus eventBus) {
        AddExtendedVanillaBlocks();
        AddStainedStoneBlocks();

        BLOCKS.register(eventBus);
    }


}
