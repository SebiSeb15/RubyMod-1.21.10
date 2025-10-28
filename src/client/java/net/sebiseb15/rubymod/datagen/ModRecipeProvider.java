package net.sebiseb15.rubymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.sebiseb15.rubymod.RubyMod;
import net.sebiseb15.rubymod.block.ModedBlocks;
import net.sebiseb15.rubymod.item.ModedItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> PINK_GARNET_SMELTABLES = List.of(ModedBlocks.Ruby_Ore,
                        ModedBlocks.Deepslate_Ruby_Ore);

                offerSmelting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModedItems.Ruby, 0.25f, 200, "ruby");
                offerBlasting(PINK_GARNET_SMELTABLES, RecipeCategory.MISC, ModedItems.Ruby, 0.25f, 100, "ruby");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModedItems.Ruby, RecipeCategory.DECORATIONS, ModedBlocks.Ruby_Block);

                createShapeless(RecipeCategory.MISC, ModedItems.Ruby, 16)
                        .input(ModedBlocks.Ruby_Crystal)
                        .criterion(hasItem(ModedBlocks.Ruby_Crystal), conditionsFromItem(ModedBlocks.Ruby_Crystal))
                        .offerTo(exporter, RegistryKey.of(RegistryKeys.RECIPE, Identifier.of(RubyMod.MOD_ID, "ruby_from_ruby_crystal")));

            }
        };
    }

    @Override
    public String getName() {
        return "RubyMod Recipes";
    }
}
