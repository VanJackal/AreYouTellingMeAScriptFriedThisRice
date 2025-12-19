package com.njackal.friedrice;

import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import org.lwjgl.glfw.GLFW;

public class FriedRiceClient implements ClientModInitializer {
	private static KeyMapping keyMapping;
	private static final KeyMapping.Category CATEGORY = KeyMapping.Category.register(ResourceLocation.fromNamespaceAndPath("friedrice", "runscript"));
	
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		FriedRice.LOGGER.info("FriedRice Client Init");
		
		initKeybinds();
	}
	
	private void initKeybinds(){
		keyMapping = KeyBindingHelper.registerKeyBinding(new KeyMapping(
				"key.friedrice.run",
				InputConstants.Type.KEYSYM,
				GLFW.GLFW_KEY_I,
				CATEGORY
		));

		ClientTickEvents.END_CLIENT_TICK.register( client -> {
			while (keyMapping.consumeClick()) {
				assert client.player != null;
                client.player.displayClientMessage(Component.literal("Run key was pressed"), false);
			}
		});
	}
}