package net.sebiseb15.rubymod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.sebiseb15.rubymod.block.ModedBlocks;
import net.sebiseb15.rubymod.block.custom.RubyLamp;
import net.sebiseb15.rubymod.item.ModedItems;
import net.sebiseb15.rubymod.item.custom.ModedArmorMaterial;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModedBlocks.Ruby_Block);
        blockStateModelGenerator.registerSimpleCubeAll(ModedBlocks.Ruby_Ore);
        blockStateModelGenerator.registerSimpleCubeAll(ModedBlocks.Deepslate_Ruby_Ore);

        Identifier lampOffIdentifier = TexturedModel.CUBE_ALL.upload(ModedBlocks.Ruby_Lamp, blockStateModelGenerator.modelCollector);
        Identifier lampOnIdentifier = blockStateModelGenerator.createSubModel(ModedBlocks.Ruby_Lamp, "_on", Models.CUBE_ALL, TextureMap::all);

        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(ModedBlocks.Ruby_Lamp)
                .with(BlockStateModelGenerator.createBooleanModelMap(RubyLamp.LIT,
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOnIdentifier)).build()),
                        new WeightedVariant(Pool.<ModelVariant>builder().add(new ModelVariant(lampOffIdentifier)).build()))));

        blockStateModelGenerator.registerSingleton(ModedBlocks.Ruby_Crystal, TexturedModel.END_FOR_TOP_CUBE_COLUMN);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModedItems.Ruby, Models.GENERATED);

        itemModelGenerator.register(ModedItems.Ruby_Sword, Models.HANDHELD);
        itemModelGenerator.register(ModedItems.Ruby_Pickaxe, Models.HANDHELD);
        itemModelGenerator.register(ModedItems.Ruby_Shovel, Models.HANDHELD);
        itemModelGenerator.register(ModedItems.Ruby_Axe, Models.HANDHELD);
        itemModelGenerator.register(ModedItems.Ruby_Hoe, Models.HANDHELD);

        itemModelGenerator.registerArmor(ModedItems.Ruby_Helmet, ModedArmorMaterial.RUBY_KEY, ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModedItems.Ruby_Chestplate, ModedArmorMaterial.RUBY_KEY, ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModedItems.Ruby_Leggings, ModedArmorMaterial.RUBY_KEY, ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
        itemModelGenerator.registerArmor(ModedItems.Ruby_Boots, ModedArmorMaterial.RUBY_KEY, ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);

    }
}
