package net.fabricmc.example.object;

import io.wispforest.owo.itemgroup.OwoItemSettings;
import io.wispforest.owo.registration.reflect.ItemRegistryContainer;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.item.ExampleItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ExampleItems implements ItemRegistryContainer {
    public static final ExampleItemGroup ITEM_GROUP = new ExampleItemGroup(ExampleMod.id("modid"));

    public static final Item EXAMPLE_ITEM = new Item(new OwoItemSettings().group(ITEM_GROUP).tab(ExampleItemGroup.MAIN));
}
