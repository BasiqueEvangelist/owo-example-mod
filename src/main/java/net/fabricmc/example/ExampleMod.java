package net.fabricmc.example;

import io.wispforest.owo.registration.reflect.FieldRegistrationHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.example.object.ExampleItems;
import net.minecraft.util.Identifier;

public class ExampleMod implements ModInitializer {
	public static String MOD_ID = "modid";

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		FieldRegistrationHandler.register(ExampleItems.class, MOD_ID, false);

		ExampleItems.ITEM_GROUP.initialize();
	}
}
