package dev.abraahamlol6.stackeableitems.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.PotionItem;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.item.LingeringPotionItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public abstract class ItemMixin {
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void stackableItems$modifyMaxCount(CallbackInfoReturnable<Integer> cir) {
        if ((Object)this instanceof PotionItem || (Object)this instanceof SplashPotionItem || (Object)this instanceof LingeringPotionItem) {
            cir.setReturnValue(64);
        }
    }
}
