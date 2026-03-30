package dev.abraahamlol6.stackeableitems.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Potion.class)
public class PotionDurationMixin {

    @Inject(method = "<init>(Ljava/lang/String;[Lnet/minecraft/entity/effect/StatusEffectInstance;)V", at = @At("HEAD"))
    private static void onInit(String baseName, StatusEffectInstance[] effects, CallbackInfo ci) {
        for (int i = 0; i < effects.length; i++) {
            StatusEffectInstance effect = effects[i];
            int duration = effect.getDuration();
            
            // Si es una poción instantánea, no se suma tiempo.
            if (duration <= 1) continue;

            // Si es Nivel 2 (Amplificador 1), sumar 30 segundos (600 ticks) para que dure 2:00
            if (effect.getAmplifier() == 1) {
                effects[i] = new StatusEffectInstance(effect.getEffectType(), duration + 600, effect.getAmplifier(), effect.isAmbient(), effect.shouldShowParticles(), effect.shouldShowIcon());
            }
        }
    }
}
