package dev.abraahamlol6.stackeableitems.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PotionItem.class)
public class PotionItemMixin {
    @Inject(method = "finishUsing", at = @At("RETURN"), cancellable = true)
    private void onFinishUsing(ItemStack stack, World world, LivingEntity user, CallbackInfoReturnable<ItemStack> cir) {
        if (user instanceof PlayerEntity player && !player.getAbilities().creativeMode) {
            ItemStack result = cir.getReturnValue();
            // Si el resultado es una botella vacía y el stack original todavía tiene items,
            // significa que necesitamos devolver el stack original y poner la botella en el inventario.
            if (result.getItem() == Items.GLASS_BOTTLE && !stack.isEmpty()) {
                if (!player.getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE))) {
                    player.dropItem(new ItemStack(Items.GLASS_BOTTLE), false);
                }
                cir.setReturnValue(stack);
            }
        }
    }
}
