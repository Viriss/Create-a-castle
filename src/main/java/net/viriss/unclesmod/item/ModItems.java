package net.viriss.unclesmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;

import java.awt.event.InputEvent;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, UnclesMod.MOD_ID);

    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
        () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> LANTERN_FLOWER_SEED = ITEMS.register("lantern_flower_seed",
            () -> new ItemNameBlockItem(ModBlocks.LANTERN_FLOWER_CROP.get(), new Item.Properties()));


    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
