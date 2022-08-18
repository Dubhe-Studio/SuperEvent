package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Enchantment.EnchantmentEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.List;

@Mixin(EnchantmentMenu.class)
public class EnchantmentMenuMixin {

    @Inject(method = "method_17411", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/inventory/EnchantmentMenu;broadcastChanges()V"))
    private void slotsChanged(ItemStack itemStack, Level level, BlockPos blockPos, CallbackInfo ci) {
        if (itemStack.isEmpty() || !itemStack.isEnchantable()) {
            EnchantmentEvent.PREPARE_ITEM_EVENT.invoker().inter(itemStack);
        }
    }

    @Inject(method = "method_17410", at = @At(value = "INVOKE", target = "Ljava/util/List;isEmpty()Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void clickMenuButton(ItemStack itemStack, int i, Player player, int j, ItemStack itemStack2, Level level,
            BlockPos blockPos, CallbackInfo ci, ItemStack itemStack3, List<EnchantmentInstance> list) {
        EnchantmentEvent.ENCHANT_ITEM_EVENT.invoker().inter(list, itemStack3);
    }
}
