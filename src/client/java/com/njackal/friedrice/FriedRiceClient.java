package com.njackal.friedrice;

import net.fabricmc.api.ClientModInitializer;

public class FriedRiceClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// This entrypoint is suitable for setting up client-specific logic, such as rendering.
		FriedRice.LOGGER.info("FriedRice Client Init");
	}
}