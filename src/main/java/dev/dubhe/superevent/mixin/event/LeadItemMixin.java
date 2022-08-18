package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Hanging.HangingEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.LeashFenceKnotEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.LeadItem;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(LeadItem.class)
public class LeadItemMixin {

    @Inject(method = "bindPlayerMobs", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/decoration/LeashFenceKnotEntity;playPlacementSound()V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void bind(Player player, Level level, BlockPos pos, CallbackInfoReturnable<InteractionResult> cir,
            LeashFenceKnotEntity leashFenceKnotEntity) {
        // 当一个悬挂实体被放置时触发本事件
        HangingEvent.HANGING_PLACE_EVENT.invoker().inter(player, leashFenceKnotEntity, pos);
    }
}
