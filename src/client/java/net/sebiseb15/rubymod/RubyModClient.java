package net.sebiseb15.rubymod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.sebiseb15.rubymod.block.ModedBlocks;

public class RubyModClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModedBlocks.Ruby_Crystal, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModedBlocks.Ruby_Crystal, BlockRenderLayer.TRANSLUCENT);
	}
}