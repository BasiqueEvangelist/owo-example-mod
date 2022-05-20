package net.fabricmc.example.datagen;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.Consumer;

public class ExampleRecipesProvider extends FabricRecipeProvider {
    public ExampleRecipesProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(Items.STONE)
            .pattern(" a ")
            .pattern("ama")
            .pattern(" a ")
            .input('a', Items.ANDESITE)
            .input('m', Items.MAGMA_BLOCK)
            .criterion(hasItem(Items.ANDESITE), conditionsFromItem(Items.ANDESITE))
            .offerTo(exporter, craftingRecipe(Items.STONE));
    }

    private static Identifier craftingRecipe(ItemConvertible item) {
        final var itemId = Registry.ITEM.getId(item.asItem());
        return ExampleMod.id("crafting/" + itemId.getPath());
    }
}
