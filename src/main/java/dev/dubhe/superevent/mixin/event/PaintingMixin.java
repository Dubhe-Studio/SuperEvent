package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Hanging.HangingEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.Painting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Painting.class)
public class PaintingMixin {

    @Inject(method = "dropItem", at = @At("HEAD"))
    private void drop(Entity brokenEntity, CallbackInfo ci) {
        Painting self = (Painting) (Object) this;
        if (null != brokenEntity) {
            // 当一个悬挂实体被一个实体移除时调用本事件
            HangingEvent.HANGING_BREAK_BY_ENTITY_EVENT.invoker().inter(brokenEntity, self);
        } else {
            // 当一个悬挂实体被移除时调用
            HangingEvent.HANGING_BREAK_EVENT.invoker().inter(self);
        }
    }
}
