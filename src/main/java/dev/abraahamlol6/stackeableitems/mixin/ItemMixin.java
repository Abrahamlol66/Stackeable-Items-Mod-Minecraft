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
    @Inject(method = "getMaxCount()I", at = @At("HEAD"), cancellable = true)
    private void onGetMaxCount(CallbackInfoReturnable<Integer> cir) {
        Object self = this;
        if (self instanceof PotionItem || self instanceof SplashPotionItem || self instanceof LingeringPotionItem) {
            cir.setReturnValue(64);
        }
    }
}
