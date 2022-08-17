package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Weather.WeatherEvent;
import dev.dubhe.superevent.event.Weather.WeatherType;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.storage.ServerLevelData;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(ServerLevel.class)
public class ServerLevelMixin {

    @Shadow
    @Final
    private ServerLevelData serverLevelData;
    private final ServerLevel serverLevel = (ServerLevel) (Object) this;

    @ModifyArg(method = "resetWeatherCycle", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;setRaining(Z)V"))
    public boolean resetRaining(boolean bl) {
        // 天气改变事件
        WeatherType type;
        if (bl) {
            type = WeatherType.RAIN;
        } else {
            type = WeatherType.CLEAR;
        }
        WeatherEvent.WEATHER_CHANGE_EVENT.invoker().inter(serverLevel, serverLevelData.getRainTime(), type);
        bl = type == WeatherType.RAIN;
        return bl;
    }

    @ModifyArg(method = "resetWeatherCycle", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;setThundering(Z)V"))
    public boolean resetThundering(boolean bl) {
        // 雷暴天气切换事件
        WeatherEvent.THUNDER_CHANGE_EVENT.invoker().inter(serverLevel, bl);
        return bl;
    }

    @ModifyArg(method = "advanceWeatherCycle", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;setRaining(Z)V"))
    public boolean setRaining(boolean bl) {
        // 天气改变事件
        WeatherType type;
        if (bl) {
            type = WeatherType.RAIN;
        } else {
            type = WeatherType.CLEAR;
        }
        WeatherEvent.WEATHER_CHANGE_EVENT.invoker().inter(serverLevel, serverLevelData.getRainTime(), type);
        bl = type == WeatherType.RAIN;
        return bl;
    }

    @ModifyArg(method = "advanceWeatherCycle", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/storage/ServerLevelData;setThundering(Z)V"))
    public boolean setThundering(boolean bl) {
        // 雷暴天气切换事件
        WeatherEvent.THUNDER_CHANGE_EVENT.invoker().inter(serverLevel, bl);
        return bl;
    }

    @ModifyArg(method = "tickChunk", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;atBottomCenterOf(Lnet/minecraft/core/Vec3i;)Lnet/minecraft/world/phys/Vec3;"))
    public Vec3i lighting(Vec3i pos) {
        // 雷击事件
        WeatherEvent.LIGHTING_STRIKE_EVENT.invoker().inter(serverLevel, pos);
        return pos;
    }
}
