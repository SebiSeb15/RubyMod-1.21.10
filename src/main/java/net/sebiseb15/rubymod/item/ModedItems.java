package net.sebiseb15.rubymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.RubyMod;

public class ModedItems {

    public static final Item Ruby = registerItem("ruby");

    private static Item registerItem(String name) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RubyMod.MOD_ID, name));
        return Registry.register(Registries.ITEM, key , new Item(new Item.Settings().registryKey(key)));
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registering Moded Items for "+ RubyMod.MOD_ID);
    }
}
