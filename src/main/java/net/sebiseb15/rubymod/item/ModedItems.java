package net.sebiseb15.rubymod.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.RubyMod;
import net.sebiseb15.rubymod.item.custom.ModedArmorMaterial;
import net.sebiseb15.rubymod.item.custom.ModedToolMaterials;

import java.util.function.Function;

import static net.minecraft.item.Items.register;

public class ModedItems {

    public static final Item Ruby = registerItem("ruby", Item::new);

    public static final Item Ruby_Sword = registerItem("ruby_sword",
            setting -> new Item(setting.sword(ModedToolMaterials.RUBY, 3, -2.4f)));
    public static final Item Ruby_Pickaxe = registerItem("ruby_pickaxe",
            setting -> new Item(setting.pickaxe(ModedToolMaterials.RUBY, 1, -2.8f)));
    public static final Item Ruby_Shovel = registerItem("ruby_shovel",
            setting -> new ShovelItem(ModedToolMaterials.RUBY, 1.5f, -3.0f, setting));
    public static final Item Ruby_Axe = registerItem("ruby_axe",
            setting -> new AxeItem(ModedToolMaterials.RUBY, 6, -3.2f, setting));
    public static final Item Ruby_Hoe = registerItem("ruby_hoe",
            setting -> new HoeItem(ModedToolMaterials.RUBY, 0, -3f, setting));

    public static final Item Ruby_Helmet = registerItem("ruby_helmet",
            settings -> new Item(settings.armor(ModedArmorMaterial.RUBY_ARMOR_MATERIAL, EquipmentType.HELMET)
                    .maxDamage(EquipmentType.HELMET.getMaxDamage(ModedArmorMaterial.RUBY_ARMOR_MATERIAL.durability()))));
    public static final Item Ruby_Chestplate = registerItem("ruby_chestplate",
            settings -> new Item(settings.armor(ModedArmorMaterial.RUBY_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
                    .maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(ModedArmorMaterial.RUBY_ARMOR_MATERIAL.durability()))));
    public static final Item Ruby_Leggings = registerItem("ruby_leggings",
            settings -> new Item(settings.armor(ModedArmorMaterial.RUBY_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
                    .maxDamage(EquipmentType.LEGGINGS.getMaxDamage(ModedArmorMaterial.RUBY_ARMOR_MATERIAL.durability()))));
    public static final Item Ruby_Boots = registerItem("ruby_boots",
            settings -> new Item(settings.armor(ModedArmorMaterial.RUBY_ARMOR_MATERIAL, EquipmentType.BOOTS)
                    .maxDamage(EquipmentType.BOOTS.getMaxDamage(ModedArmorMaterial.RUBY_ARMOR_MATERIAL.durability()))));


    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(RubyMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RubyMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        RubyMod.LOGGER.info("Registering Moded Items for "+ RubyMod.MOD_ID);
    }
}
