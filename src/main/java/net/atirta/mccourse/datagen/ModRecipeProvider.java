package net.atirta.mccourse.datagen;

import net.atirta.mccourse.block.ModBlocks;
import net.atirta.mccourse.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.CookingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        return new RecipeProvider(registries, output) {
            @Override
            public void buildRecipes() {
                List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH, ModBlocks.BISMUTH_ORE,
                        ModBlocks.BISMUTH_DEEPSLATE_ORE, ModBlocks.BISMUTH_NETHER_ORE, ModBlocks.BISMUTH_END_ORE);

                oreSmelting(BISMUTH_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.BISMUTH,
                        0.25f, 200, "bismuth");

                oreBlasting(BISMUTH_SMELTABLES, RecipeCategory.MISC, CookingBookCategory.BLOCKS, ModItems.BISMUTH,
                        0.25f, 100, "bismuth");


                // 1. Standard Furnace (200 ticks)
                SimpleCookingRecipeBuilder.smelting(
                                Ingredient.of(ModItems.CHEVON), // Your raw food item
                                RecipeCategory.FOOD,              // Recipe Category
                                CookingBookCategory.FOOD,
                                ModItems.COOKED_CHEVON,             // Resulting cooked item
                                0.35f,                            // Experience (0.35f is vanilla standard for meat)
                                200                               // Cooking time in ticks
                        )
                        .unlockedBy(getHasName(ModItems.CHEVON), has(ModItems.CHEVON))
                        .save(output);

                // 2. Smoker (100 ticks - twice as fast)
                SimpleCookingRecipeBuilder.smoking(
                                Ingredient.of(ModItems.CHEVON),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_CHEVON,
                                0.35f,
                                100
                        )
                        .unlockedBy(getHasName(ModItems.CHEVON), has(ModItems.CHEVON))
                        // CRITICAL: You must provide a custom resource location/name for the second recipe.
                        // Otherwise, it will try to save as "cooked_beef" and overwrite the smelting recipe.
                        .save(output, "cooked_chevon_from_smoking");

                // 3. Campfire (600 ticks - takes longer but costs no fuel)
                SimpleCookingRecipeBuilder.campfireCooking(
                                Ingredient.of(ModItems.CHEVON),
                                RecipeCategory.FOOD,
                                ModItems.COOKED_CHEVON,
                                0.35f,
                                600
                        )
                        .unlockedBy(getHasName(ModItems.CHEVON), has(ModItems.CHEVON))
                        .save(output, "cooked_chevon_from_campfire");













                nineBlockStorageRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.BISMUTH,
                        RecipeCategory.DECORATIONS, ModBlocks.BISMUTH_BLOCK);

                shaped(RecipeCategory.MISC, ModBlocks.RAW_BISMUTH_BLOCK, 1)
                        .pattern("RRR")
                        .pattern("RRR")
                        .pattern("RRR")
                        .define('R', ModItems.RAW_BISMUTH)
                        .unlockedBy(getHasName(ModItems.RAW_BISMUTH), has(ModItems.RAW_BISMUTH))
                        .save(output);

                shapeless(RecipeCategory.MISC, ModItems.RAW_BISMUTH, 9)
                        .requires(ModBlocks.RAW_BISMUTH_BLOCK)
                        .unlockedBy(getHasName(ModBlocks.RAW_BISMUTH_BLOCK), has(ModBlocks.RAW_BISMUTH_BLOCK))
                        .save(output);
            }
        };
    }

    @Override
    public String getName() {
        return "MCCourse Recipes";
    }
}
