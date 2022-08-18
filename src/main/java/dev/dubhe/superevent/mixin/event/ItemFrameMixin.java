package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Hanging.HangingEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.ItemFrame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemFrame.class)
public class ItemFrameMixin {

    @Inject(method = "dropItem(Lnet/minecraft/world/entity/Entity;Z)V", at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/decoration/ItemFrame;getItem()Lnet/minecraft/world/item/ItemStack;"))
    private void drop(Entity brokenEntity, boolean dropSelf, CallbackInfo ci) {
        ItemFrame self = (ItemFrame) (Object) this;
        if (null != brokenEntity) {
            // 当一个悬挂实体被一个实体移除时调用本事件
            HangingEvent.HANGING_BREAK_BY_ENTITY_EVENT.invoker().inter(brokenEntity, self);
        } else {
            // 当一个悬挂实体被移除时调用
            HangingEvent.HANGING_BREAK_EVENT.invoker().inter(self);
        }
    }
}
