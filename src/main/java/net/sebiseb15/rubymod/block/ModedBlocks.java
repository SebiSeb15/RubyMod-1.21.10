package net.sebiseb15.rubymod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.sebiseb15.rubymod.RubyMod;

import java.util.function.Function;

public class ModedBlocks {

    public static final Block Ruby_Block = registerBlock("ruby_block",
            Block::new,
            AbstractBlock.Settings.create().strength(5f, 6.0F).requiresTool().sounds(BlockSoundGroup.METAL),
            true
    );

    public static final Block Ruby_Ore = registerBlock("ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3,7), settings),
            Block.Settings.create().strength(3f, 3f).requiresTool().sounds(BlockSoundGroup.STONE),
            true);

    public static final Block Deepslate_Ruby_Ore = registerBlock("deepslate_ruby_ore",
            settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3,7), settings),
            Block.Settings.create().strength(4.5f, 3f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE),
            true);


    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {

        RegistryKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(RubyMod.MOD_ID, name));
    }
    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(RubyMod.MOD_ID, name));
    }


    public static void registerModBlocks(){
        RubyMod.LOGGER.info("Registering Moded Blocks for "+ RubyMod.MOD_ID);
    }
}
