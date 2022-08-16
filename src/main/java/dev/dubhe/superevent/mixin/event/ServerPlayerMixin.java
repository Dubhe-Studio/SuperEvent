package dev.dubhe.superevent.mixin.event;

import com.mojang.datafixers.util.Either;
import dev.dubhe.superevent.event.Player.PlayerEvent;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Unit;
import net.minecraft.world.entity.player.Player.BedSleepingProblem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {

    @Inject(method = "startSleepInBed", at = @At("HEAD"))
    private void startSleepInBed(BlockPos blockPos, CallbackInfoReturnable<Either<BedSleepingProblem, Unit>> cir) {
        // 玩家准备躺到床上时触发此事件。
        PlayerEvent.PLAYER_BED_ENTER_EVENT.invoker().inter((ServerPlayer) (Object) this, blockPos);
    }

    @Inject(method = "stopSleepInBed", at = @At("HEAD"))
    private void stopSleepInBed(boolean bl, boolean bl2, CallbackInfo ci) {
        ServerPlayer serverPlayer = (ServerPlayer) (Object) this;
        Optional<BlockPos> pos = serverPlayer.getSleepingPos();
        // 玩家离开床时触发此事件。
        pos.ifPresent(blockPos -> PlayerEvent.PLAYER_BED_LEAVE_EVENT.invoker().inter(serverPlayer, blockPos));
    }

    @ModifyArg(method = "giveExperienceLevels", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/player/Player;giveExperienceLevels(I)V"))
    private int exp(int num){
        PlayerEvent.PLAYER_LEVEL_CHANGE_EVENT.invoker().inter((ServerPlayer) (Object) this, num);
        return num;
    }
}
