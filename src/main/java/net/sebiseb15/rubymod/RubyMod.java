package net.sebiseb15.rubymod;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.block.ModedBlocks;
import net.sebiseb15.rubymod.item.ModItemsGroups;
import net.sebiseb15.rubymod.item.ModedItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RubyMod implements ModInitializer {
	public static final String MOD_ID = "rubymod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello Fabric world!");
        ModedItems.registerModItems();
        ModedBlocks.registerModBlocks();
        ModItemsGroups.registerItemGroups();
        Registry.register(Registries.SOUND_EVENT, Identifier.of(MOD_ID, "xylophone_a"),
                SoundEvent.of(Identifier.of(MOD_ID, "xylophone_a")));
	}
}