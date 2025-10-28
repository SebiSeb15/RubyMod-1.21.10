package net.sebiseb15.rubymod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.RubyMod;
import net.minecraft.registry.Registry;
import net.sebiseb15.rubymod.block.ModedBlocks;

public class ModItemsGroups {

    public static final ItemGroup Ruby_Items_Group = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(RubyMod.MOD_ID, "ruby_items"),
            FabricItemGroup.builder().icon(()-> new ItemStack(ModedItems.Ruby))
                    .displayName(Text.translatable("itemgroup.rubymod.ruby_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(new ItemStack(ModedItems.Ruby));
                        entries.add(new ItemStack(ModedBlocks.Ruby_Block));
                        entries.add(new ItemStack(ModedBlocks.Ruby_Ore));
                        entries.add(new ItemStack(ModedBlocks.Deepslate_Ruby_Ore));
                        entries.add(new ItemStack(ModedBlocks.Ruby_Crystal));
                        entries.add(new ItemStack(ModedBlocks.Ruby_Lamp));
                        entries.add(new ItemStack(ModedItems.Ruby_Sword));
                        entries.add(new ItemStack(ModedItems.Ruby_Axe));
                        entries.add(new ItemStack(ModedItems.Ruby_Pickaxe));
                        entries.add(new ItemStack(ModedItems.Ruby_Shovel));
                        entries.add(new ItemStack(ModedItems.Ruby_Hoe));

                    }
            ).build()
    );

    public static void registerItemGroups() {
        RubyMod.LOGGER.info("Registering Item Groups for "+ RubyMod.MOD_ID);
    }
}
