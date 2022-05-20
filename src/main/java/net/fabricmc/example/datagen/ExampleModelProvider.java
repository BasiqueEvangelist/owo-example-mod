package net.fabricmc.example.datagen;

import net.fabricmc.example.object.ExampleItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.item.Item;

public class ExampleModelProvider extends FabricModelProvider {
    public ExampleModelProvider(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        simpleStateWithGeneratedItem(generator);

        simpleStateWithParentedItem(generator);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {
        generated(generator, ExampleItems.EXAMPLE_ITEM);

        handheld(generator);
    }

    private void generated(ItemModelGenerator generator, Item... items) {
        for (Item item : items) {
            generator.register(item, Models.GENERATED);
        }
    }

    private void handheld(ItemModelGenerator generator, Item... items) {
        for (Item item : items) {
            generator.register(item, Models.HANDHELD);
        }
    }

    private void simpleStateWithGeneratedItem(BlockStateModelGenerator generator, Block... blocks) {
        for (var block : blocks) {
            generator.registerSimpleState(block);
            generator.registerItemModel(block.asItem());
        }
    }

    private void simpleStateWithParentedItem(BlockStateModelGenerator generator, Block... blocks) {
        for (var block : blocks) {
            generator.registerSimpleState(block);
            var blockModelId = ModelIds.getBlockModelId(block);
            generator.registerParentedItemModel(block.asItem(), blockModelId);
        }
    }
}
