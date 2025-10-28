package net.sebiseb15.rubymod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.RubyMod;

public class ModedTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_RUBY_TOOL =  TagKey.of(Registries.BLOCK.getKey(), Identifier.of( "needs_ruby_tool"));
        public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL =  TagKey.of(Registries.BLOCK.getKey(), Identifier.of(RubyMod.MOD_ID, "incorrect_for_ruby_tool"));
    }

    public static class Items {
        public static final TagKey<Item> RUBY_TOOL_MATERIAL =  TagKey.of(Registries.ITEM.getKey(), Identifier.of(RubyMod.MOD_ID, "ruby_tool_material"));
        public static final TagKey<Item> RUBY_REPAIR =  TagKey.of(Registries.ITEM.getKey(), Identifier.of(RubyMod.MOD_ID, "ruby_repair"));
    }
}
