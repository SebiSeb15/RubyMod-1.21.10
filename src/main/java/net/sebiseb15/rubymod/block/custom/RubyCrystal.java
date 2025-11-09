package net.sebiseb15.rubymod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.sebiseb15.rubymod.block.ModedBlocks;

public class RubyCrystal extends Block {
    public RubyCrystal(Settings settings) {
        super(settings.nonOpaque()
                .allowsSpawning((state, world, pos, type) -> false)
                .solidBlock((state, world, pos) -> false)
                .suffocates((state, world, pos) -> false)
                .blockVision((state, world, pos) -> false));
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
        // Si le bloc adjacent est du même type, la face n'est pas rendue
        if (stateFrom.isOf(this)) {
            return true;
        }
        return super.isSideInvisible(state, stateFrom, direction);
    }



    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        float pitch = 0.5f ;
        BlockPos post =  pos;
        while (world.getBlockState(post.up()).getBlock().equals(ModedBlocks.Ruby_Crystal) && pos.getY()+ 10 >= post.getY()) {
            pitch += 0.1f;
            post = post.up(1);
        }

        world.playSound(player, pos, SoundEvents.BLOCK_AMETHYST_BLOCK_HIT, SoundCategory.BLOCKS, 15.0F, pitch);
        return ActionResult.SUCCESS;
    }
}
