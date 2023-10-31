package net.viriss.unclesmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.enums.ExtendedVanillaBlockGenEnum;
import net.viriss.unclesmod.enums.StainedStoneBlockGenEnum;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, UnclesMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.LEAGUE_STONE_KEY.get(),
                     ModBlocks.LEAGUE_STONE_FRAME.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.LEAGUE_STONE_FRAME.get(),
                     ModBlocks.LEAGUE_STONE_KEY.get(),
                     ModBlocks.SLATE_ORE.get());

        for (ExtendedVanillaBlockGenEnum b : ExtendedVanillaBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                if(rb.getId().getPath().equals(b.toString() + "_wall")){
                    this.tag(BlockTags.WALLS)
                            .add(rb.get());
                }
                if(rb.getId().getPath().equals(b.toString() + "_fence")){
                    this.tag(BlockTags.FENCES)
                            .add(rb.get());
                    this.tag(BlockTags.WOODEN_FENCES)
                            .add(rb.get());
                }
                if(rb.getId().getPath().equals(b.toString() + "_fence_gate")){
                    this.tag(BlockTags.FENCE_GATES)
                            .add(rb.get());
                }
            }
        }
        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){
                AddStainedSet(b.toString(), rb);
            }
        }
    }


        //fence
        //fence gate
    private void AddStainedSet(String name, RegistryObject<Block> rb){
        if(rb.getId().getPath().equals(name + "_fence")){
            this.tag(BlockTags.FENCES)
                    .add(rb.get());
            this.tag(BlockTags.WOODEN_FENCES)
                    .add(rb.get());
        }
        if(rb.getId().getPath().equals(name + "_wall")){
            this.tag(BlockTags.WALLS)
                    .add(rb.get());
        }
        if(rb.getId().getPath().equals(name + "_fence_gate")){
            this.tag(BlockTags.FENCE_GATES)
                    .add(rb.get());
        }
    }

}
