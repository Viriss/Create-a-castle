package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.item.ModItems;
import org.apache.commons.lang3.text.WordUtils;

public class ModLangProvider extends LanguageProvider {

    public ModLangProvider(PackOutput output, String locale) {
        super(output, UnclesMod.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {
        this.add("creativetab.unclesmod_tab", "Uncles Mod Tab");

        for(RegistryObject<Item> ri : ModItems.ITEMS.getEntries()){
            this.addItem(ri, WordUtils.capitalize(ri.getId().getPath().replace('_', ' ')));
        }
/*
        for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
            String name = rb.getKey().toString().substring(rb.getKey().toString().lastIndexOf('.') + 1).trim();
            //if(rb.getId().getPath().contains(name + "_stairs") || rb.getId().getPath().contains(name + "_slab")){
                this.addBlock(rb, rb.getId().getPath());
            //}
        }
*/
    }

}
