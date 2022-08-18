package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Hanging.HangingEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(HangingEntityItem.class)
public class HangingEntityItemMixin {

    @Inject(method = "useOn", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/decoration/HangingEntity;playPlacementSound()V"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void mayPlace(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir, BlockPos blockPos,
            Direction direction, BlockPos blockPos2, Player player, ItemStack itemStack, Level level,
            HangingEntity hangingEntity) {
        // 当一个悬挂实体被放置时触发本事件
        HangingEvent.HANGING_PLACE_EVENT.invoker().inter(player, hangingEntity, blockPos2);
    }
}
