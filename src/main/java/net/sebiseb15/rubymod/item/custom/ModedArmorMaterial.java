package net.sebiseb15.rubymod.item.custom;

import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.sebiseb15.rubymod.RubyMod;
import net.sebiseb15.rubymod.util.ModedTags;

import java.util.EnumMap;

public class ModedArmorMaterial {
    static RegistryKey<? extends Registry<EquipmentAsset>> REGISTRY_KEY = RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset"));
    public static final RegistryKey<EquipmentAsset> RUBY_KEY = RegistryKey.of(REGISTRY_KEY, Identifier.of(RubyMod.MOD_ID, "ruby"));

    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new ArmorMaterial(
            30,
            Util.make(new EnumMap<>(EquipmentType.class), map -> {
                map.put(EquipmentType.BOOTS, 2);
                map.put(EquipmentType.LEGGINGS, 4);
                map.put(EquipmentType.CHESTPLATE, 6);
                map.put(EquipmentType.HELMET, 2);
                map.put(EquipmentType.BODY, 4);
            }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,0,0, ModedTags.Items.RUBY_REPAIR, RUBY_KEY
    );

}
