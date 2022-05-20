package net.fabricmc.example.item;

import io.wispforest.owo.itemgroup.Icon;
import io.wispforest.owo.itemgroup.OwoItemGroup;
import io.wispforest.owo.itemgroup.gui.ItemGroupButton;
import net.fabricmc.example.object.ExampleItems;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ExampleItemGroup extends OwoItemGroup {
    public static final int MAIN = 0;

    public ExampleItemGroup(Identifier id) {
        super(id);
    }

    @Override
    protected void setup() {
        this.addTab(Icon.of(ExampleItems.EXAMPLE_ITEM), "main", null);

        this.addButton(ItemGroupButton.github("https://github.com/wisp-forest/owo-example-mod"));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ExampleItems.EXAMPLE_ITEM);
    }
}
