package dev.abraahamlol6.stackeableitems.mixin;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.PotionUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "getName", at = @At("RETURN"), cancellable = true)
    private void stackableItems$addLevelToName(CallbackInfoReturnable<Text> cir) {
        ItemStack self = (ItemStack) (Object) this;
        
        // Solo aplicar a pociones
        if (!(self.getItem() instanceof PotionItem)) return;

        List<StatusEffectInstance> effects = PotionUtil.getPotionEffects(self);
        if (effects.isEmpty()) return;

        // Obtener el amplificador del primer efecto
        int amplifier = effects.get(0).getAmplifier();
        
        // Si el nivel es 2 (amplificador 1) o nivel 3 (amplificador 2)
        if (amplifier >= 1) {
            String suffix = "";
            if (amplifier == 1) suffix = " II";
            else if (amplifier == 2) suffix = " III";
            else suffix = " " + (amplifier + 1); // Por si acaso hay niveles superiores

            Text originalName = cir.getReturnValue();
            if (originalName instanceof MutableText mutable) {
                cir.setReturnValue(mutable.append(suffix));
            } else {
                cir.setReturnValue(Text.literal(originalName.getString() + suffix));
            }
        }
    }
}
