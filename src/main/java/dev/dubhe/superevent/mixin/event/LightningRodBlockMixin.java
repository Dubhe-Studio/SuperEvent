package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Weather.WeatherEvent;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LightningRodBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LightningRodBlock.class)
public class LightningRodBlockMixin {
    private ServerLevel serverLevel;

    @Inject(method = "onProjectileHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;atBottomCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;"))
    private void onProjectileHit(Level level, BlockState blockState, BlockHitResult blockHitResult,
            Projectile projectile, CallbackInfo ci) {
        this.serverLevel = (ServerLevel) level;
    }

    @ModifyArg(method = "onProjectileHit", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;atBottomCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;"))
    private Vec3i onProjectileHit(Vec3i pos) {
        // 雷击事件
        WeatherEvent.LIGHTING_STRIKE_EVENT.invoker().inter(this.serverLevel, pos);
        return pos;
    }
}
