package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Raid.RaidEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.raid.Raid;
import net.minecraft.world.entity.raid.Raids;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Raids.class)
public abstract class RaidsMixin {

    @Shadow
    protected abstract int getUniqueId();

    @Redirect(method = "getOrCreateRaid", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/raid/Raid;<init>(ILnet/minecraft/server/level/ServerLevel;Lnet/minecraft/core/BlockPos;)V"))
    private void createRaid(Raid instance, int i, ServerLevel serverLevel, BlockPos blockPos) {
        Raid raid = new Raid(this.getUniqueId(), serverLevel, blockPos);
        // 当袭击被触发时触发本事件
        RaidEvent.RAID_TRIGGER_EVENT.invoker().inter(raid);
    }
}
