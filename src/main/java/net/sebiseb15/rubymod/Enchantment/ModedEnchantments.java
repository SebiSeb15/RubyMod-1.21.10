package net.sebiseb15.rubymod.Enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.Enchantment.Effect.ResonantEnchantmentEffect;
import net.sebiseb15.rubymod.RubyMod;

public class ModedEnchantments {
    public static final RegistryKey<Enchantment> RESONANT = of("resonant");

    private static RegistryKey<Enchantment> of(String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(RubyMod.MOD_ID, name));
    }

    public static void initialize() {
        // Register the custom EnchantmentEntityEffect codec so JSON can reference it via "rubymod:resonant"
        Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
                Identifier.of(RubyMod.MOD_ID, "resonant"),
                ResonantEnchantmentEffect.CODEC);
    }
}
