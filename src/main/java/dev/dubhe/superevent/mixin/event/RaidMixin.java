package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Raid.RaidEvent;
import net.minecraft.world.entity.raid.Raid;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Raid.class)
public class RaidMixin {

    private final Raid self = (Raid) (Object) this;

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/raid/Raid;isVictory()Z"))
    private void finish(CallbackInfo ci) {
        // 当袭击以胜利或失败时触发本事件
        RaidEvent.RAID_FINISH_EVENT.invoker().inter(this.self, this.self.isVictory());
    }

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void stop(CallbackInfo ci) {
        if (self.isStopped()) {
            // 当袭击中断时触发本事件
            RaidEvent.RAID_STOP_EVENT.invoker().inter(this.self);
        }
    }

    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/level/ServerBossEvent;setName(Lnet/minecraft/network/chat/Component;)V", ordinal = 0))
    private void wave(CallbackInfo ci) {
        // 当新一波袭击开始时触发本事件
        RaidEvent.RAID_SPAWN_WAVE_EVENT.invoker().inter(this.self);
    }
}
