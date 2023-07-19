package net.viriss.unclesmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, UnclesMod.MOD_ID);

    public static final RegistryObject<Block> SMOKY_CALCITE = registerBlock("smoky_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CALCITE)));

    /*
    public static final RegistryObject<Block> League_Stone_Key = registerBlock("league_stone_key",
            () -> new LeagueStoneKeyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f)), CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Block> League_Stone_Frame = registerBlock("league_stone_frame",
            () -> new LeagueStoneFrameBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f)), CreativeModeTabs.BUILDING_BLOCKS);
    public static final RegistryObject<Block> Red_Carpet_Stairs = registerBlock("red_wool_stairs",
            () -> new StairBlock(() -> Blocks.RED_WOOL.defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.WOOL)
                            .sound(SoundType.WOOL)
            ),
            CreativeModeTabs.COLORED_BLOCKS);
*/
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
