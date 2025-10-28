package net.sebiseb15.rubymod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.sebiseb15.rubymod.item.ModedItems;
import net.sebiseb15.rubymod.util.ModedTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {


        valueLookupBuilder(ModedTags.Items.RUBY_REPAIR)
                .add(ModedItems.Ruby);

        valueLookupBuilder(ItemTags.SWORDS)
                .add(ModedItems.Ruby_Sword);
        valueLookupBuilder(ItemTags.PICKAXES)
                .add(ModedItems.Ruby_Pickaxe);
        valueLookupBuilder(ItemTags.SHOVELS)
                .add(ModedItems.Ruby_Shovel);
        valueLookupBuilder(ItemTags.AXES)
                .add(ModedItems.Ruby_Axe);
        valueLookupBuilder(ItemTags.HOES)
                .add(ModedItems.Ruby_Hoe);

        //valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
          //      .add(ModItems.PINK_GARNET_HELMET)

        valueLookupBuilder(ItemTags.TRIM_MATERIALS)
            .add(ModedItems.Ruby);

    }
}
