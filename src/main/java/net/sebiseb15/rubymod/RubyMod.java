package net.sebiseb15.rubymod;

import net.fabricmc.api.ModInitializer;

import net.sebiseb15.rubymod.block.ModedBlocks;
import net.sebiseb15.rubymod.item.ModedItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubyMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
        ModedItems.registerModItems();
        ModedBlocks.registerModBlocks();
	}
}