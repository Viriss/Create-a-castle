package net.viriss.unclesmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnclesMod.MOD_ID);

public static final RegistryObject<CreativeModeTab> UNCLESMOD_TAB =
        CREATIVE_MOD_TABS.register("unclesmod_tab",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                        .title(Component.translatable("creativetab.unclesmod_tab"))
                        .displayItems((pParameters, pOutput) -> {
                            pOutput.accept(ModItems.RUBY.get());
                            pOutput.accept(ModItems.SAPPHIRE.get());
                            pOutput.accept(ModItems.LANTERN_FLOWER_SEED.get());

                            pOutput.accept(ModBlocks.SMOKY_CALCITE.get());
                            pOutput.accept(ModBlocks.PINKSTONE.get());
                            pOutput.accept(ModBlocks.GILDED_PINKSTONE.get());
                            pOutput.accept(ModBlocks.GILDED_EDGE_PINKSTONE.get());
                            pOutput.accept(ModBlocks.PURESTONE.get());
                            pOutput.accept(ModBlocks.GILDED_PURESTONE.get());
                            pOutput.accept(ModBlocks.GILDED_EDGE_PURESTONE.get());
                            pOutput.accept(ModBlocks.SLATE.get());
                            pOutput.accept(ModBlocks.SLATE_BRICK.get());
                            pOutput.accept(ModBlocks.SLATE_BRICK_SLAB.get());
                            pOutput.accept(ModBlocks.SLATE_BRICK_STAIRS.get());
                            pOutput.accept(ModBlocks.SLATE_BRICK_WALL.get());
                            pOutput.accept(ModBlocks.SLATE_SLAB.get());
                            pOutput.accept(ModBlocks.SLATE_STAIRS.get());
                            pOutput.accept(ModBlocks.SLATE_WALL.get());

                            pOutput.accept(ModBlocks.LEAGUE_STONE_FRAME.get());
                            pOutput.accept(ModBlocks.LEAGUE_STONE_KEY.get());
                            pOutput.accept(ModBlocks.GOLD_SLAB.get());
                            pOutput.accept(ModBlocks.GOLD_STAIRS.get());

                            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                                pOutput.accept(rb.get());
                            }

                        })
                        .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
