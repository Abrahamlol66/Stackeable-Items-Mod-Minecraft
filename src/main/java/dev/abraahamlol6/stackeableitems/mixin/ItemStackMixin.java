package dev.abraahamlol6.stackeableitems.mixin;

import dev.abraahamlol6.stackeableitems.PotionMergingLogic;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PotionItem;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.PotionUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(method = "getName", at = @At("RETURN"), cancellable = true)
    private void onGetName(CallbackInfoReturnable<Text> cir) {
        ItemStack self = (ItemStack) (Object) this;
        if (!(self.getItem() instanceof PotionItem)) return;

        NbtCompound nbt = self.getNbt();
        if (nbt == null || !nbt.contains(PotionMergingLogic.CROSSED_TYPE_KEY)) return;

        String type = nbt.getString(PotionMergingLogic.CROSSED_TYPE_KEY);
        String effectName = PotionUtil.getPotionEffects(self).get(0).getEffectType().getName().getString();
        
        MutableText customName;
        if (PotionMergingLogic.MIXING.equals(type)) {
            customName = Text.literal("Mixing Potion of Arcane Chaos").formatted(Formatting.DARK_PURPLE);
        } else if (PotionMergingLogic.HERO.equals(type)) {
            customName = Text.literal("Hero Potion of Eternal Valor").formatted(Formatting.BLUE);
        } else if (PotionMergingLogic.LEGENDARY.equals(type)) {
            String fullText = "Legendary Potion of " + effectName;
            customName = createRainbowText(fullText);
        } else {
            return;
        }

        cir.setReturnValue(customName);
    }

    private MutableText createRainbowText(String text) {
        MutableText result = Text.empty();
        int[] colors = {
            0xFF0000, // Rojo
            0xFF7F00, // Naranja
            0xFFFF00, // Amarillo
            0x00FF00, // Verde
            0x0000FF, // Azul
            0x4B0082, // Indigo
            0x9400D3  // Violeta
        };

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            int color = colors[i % colors.length];
            result.append(Text.literal(String.valueOf(c)).setStyle(Style.EMPTY.withColor(color)));
        }
        return result;
    }
}
