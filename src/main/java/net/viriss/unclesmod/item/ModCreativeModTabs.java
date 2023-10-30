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
import net.viriss.unclesmod.enums.LangGenEnum;
import org.apache.commons.codec.language.bm.Lang;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UnclesMod.MOD_ID);

public static final RegistryObject<CreativeModeTab> UNCLESMOD_TAB =
        CREATIVE_MOD_TABS.register(LangGenEnum.unclesmod_tab.toString(),
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE.get()))
                        .title(Component.translatable(LangGenEnum.unclesmod_tab.en_us))
                        .displayItems((pParameters, pOutput) -> {

                            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                                if (!rb.getKey().toString().contains("potted")) {
                                    pOutput.accept(rb.get());
                                }
                            }

                        })
                        .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MOD_TABS.register(eventBus);
    }
}
