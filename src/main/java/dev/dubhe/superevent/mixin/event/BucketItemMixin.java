package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Player.PlayerEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BucketItem.class)
public class BucketItemMixin {

    @Inject(method = "use", at = @At("HEAD"))
    private void use(Level level, Player player, InteractionHand interactionHand,
            CallbackInfoReturnable<InteractionResultHolder<ItemStack>> cir) {
        PlayerEvent.PLAYER_BUCKET_EVENT.invoker().inter((ServerPlayer) player, interactionHand);
    }

    @Inject(method = "emptyContents", at = @At("RETURN"))
    private void empty(Player player, Level level, BlockPos blockPos, BlockHitResult blockHitResult,
            CallbackInfoReturnable<Boolean> cir) {
        if (cir.getReturnValue()) {
            PlayerEvent.PLAYER_BUCKET_EMPTY_EVENT.invoker().inter((ServerPlayer) player, blockPos);
        }
    }
}
