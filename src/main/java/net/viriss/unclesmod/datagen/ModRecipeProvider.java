package net.viriss.unclesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.*;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;
import net.viriss.unclesmod.enums.StainedStoneBlockGenEnum;
import net.viriss.unclesmod.UnclesMod;
import net.viriss.unclesmod.block.ModBlocks;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.LEAGUE_STONE_FRAME.get(), 8)
                .pattern("ccc")
                .pattern("cgc")
                .pattern("ccc")
                .define('c', Blocks.CALCITE)
                .define('g', Items.GOLD_INGOT)
                .unlockedBy(getHasName(Blocks.CALCITE), has(Blocks.CALCITE))
                .save(pWriter);

        for (StainedStoneBlockGenEnum b : StainedStoneBlockGenEnum.values()) {
            for(RegistryObject<Block> rb : ModBlocks.BLOCKS.getEntries()){

                if(rb.getId().getPath().equals(b.toString())){
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rb.get(), 8)
                            .pattern("sss")
                            .pattern("sds")
                            .pattern("sss")
                            .define('s', Blocks.STONE)
                            .define('d', b.Dye)
                            .unlockedBy(getHasName(b.Dye), has(b.Dye))
                            .save(pWriter);
                }
                if(rb.getId().getPath().equals(b.toString() + "_stairs")){
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rb.get(), 4)
                            .pattern("s  ")
                            .pattern("ss ")
                            .pattern("sss")
                            .define('s', rb.get())
                            .unlockedBy(getHasName(rb.get()), has(rb.get()))
                            .save(pWriter);
                }
                if(rb.getId().getPath().equals(b.toString() + "_slab")){
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rb.get(), 6)
                            .pattern("sss")
                            .define('s', rb.get())
                            .unlockedBy(getHasName(rb.get()), has(rb.get()))
                            .save(pWriter);
                }
                if(rb.getId().getPath().equals(b.toString() + "_wall")){
                    ShapedRecipeBuilder.shaped(RecipeCategory.MISC, rb.get(), 6)
                            .pattern("sss")
                            .pattern("sss")
                            .define('s', rb.get())
                            .unlockedBy(getHasName(rb.get()), has(rb.get()))
                            .save(pWriter);
                }
            }
        }


        //SingleItemRecipeBuilder sc = stonecutting(ModBlocks.SLATE.get().defaultBlockState(), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SLATE_BRICK.get());

//        SingleItemRecipeBuilder builder = SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.SLATE.get()), RecipeCategory.MISC, ModBlocks.SLATE_BRICK.get())
  //              .unlockedBy("criteria",) // How the recipe is unlocked
    //            .save(pWriter); // Add data to builder

//        Ingredient ingredient = Ingredient.of(ModBlocks.SLATE.get());
  //      SingleItemRecipeBuilder.stonecutting(ingredient, RecipeCategory.MISC, ModBlocks.SLATE_BRICK.get(), 1)
   //             .unlockedBy("has_item", has(ModBlocks.SLATE.get()))
    //            .save(pWriter); //, wrap(item, folder, "_slab_stonecutter"));

        addStonecuttingRecipe(ModBlocks.SLATE.get(), ModBlocks.SLATE_BRICK.get(), 1, pWriter);
        addStonecuttingRecipe(ModBlocks.SLATE.get(), ModBlocks.SLATE_WALL.get(), 1, pWriter);
        addStonecuttingRecipe(ModBlocks.SLATE.get(), ModBlocks.SLATE_SLAB.get(), 2, pWriter);
        addStonecuttingRecipe(ModBlocks.SLATE.get(), ModBlocks.SLATE_STAIRS.get(), 1, pWriter);

        addStonecuttingRecipe(ModBlocks.SLATE_BRICK.get(), ModBlocks.SLATE_BRICK_WALL.get(), 1, pWriter);
        addStonecuttingRecipe(ModBlocks.SLATE_BRICK.get(), ModBlocks.SLATE_BRICK_SLAB.get(), 2, pWriter);
        addStonecuttingRecipe(ModBlocks.SLATE_BRICK.get(), ModBlocks.SLATE_BRICK_STAIRS.get(), 1, pWriter);
    }

    private void addStonecuttingRecipe(ItemLike input, ItemLike output, int amount, Consumer<FinishedRecipe> pWriter)
    {
        Ingredient ingredient = Ingredient.of(input);
        SingleItemRecipeBuilder.stonecutting(ingredient, RecipeCategory.BUILDING_BLOCKS, output, amount)
                .unlockedBy("has_item", has(input))
                .save(pWriter); //, wrap(item, folder, "_slab_stonecutter"));

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, UnclesMod.MOD_ID +":"+ getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }


}
