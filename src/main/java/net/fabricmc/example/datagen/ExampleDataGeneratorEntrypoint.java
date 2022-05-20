package net.fabricmc.example.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class ExampleDataGeneratorEntrypoint implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        fabricDataGenerator.addProvider(ExampleModelProvider::new);
        fabricDataGenerator.addProvider(ExampleBlockTagProvider::new);
        fabricDataGenerator.addProvider(ExampleRecipesProvider::new);
    }
}
