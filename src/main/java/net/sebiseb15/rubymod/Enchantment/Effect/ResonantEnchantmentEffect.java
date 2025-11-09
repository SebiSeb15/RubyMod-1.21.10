package net.sebiseb15.rubymod.Enchantment.Effect;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.EnchantmentLevelBasedValue;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;

public record ResonantEnchantmentEffect(EnchantmentLevelBasedValue amount) implements EnchantmentEntityEffect {
    public static final MapCodec<ResonantEnchantmentEffect> CODEC = RecordCodecBuilder.mapCodec(instance ->
        instance.group(
            EnchantmentLevelBasedValue.CODEC.fieldOf("amount").forGetter(ResonantEnchantmentEffect::amount)
        ).apply(instance, ResonantEnchantmentEffect::new)
    );

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity target, Vec3d pos) {
        if (!(target instanceof LivingEntity attacker)) return;
        // context.owner() is the entity wearing the enchanted armor (the victim of the hit)
        if (context.owner() instanceof LivingEntity wearer && !world.isClient()) {
            // Compute duration from the configured level-based value (ticks)
            int duration = (int) this.amount.getValue(level)*20;
            int amplifier = 0;
            attacker.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, duration, amplifier));
        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
