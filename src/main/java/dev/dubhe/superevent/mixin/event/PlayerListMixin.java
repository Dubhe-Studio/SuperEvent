package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Player.PlayerEvent;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerList.class)
public class PlayerListMixin {

    private ServerPlayer serverPlayer;

    @Inject(method = "placeNewPlayer", at = @At(value = "HEAD"))
    private void join(Connection connection, ServerPlayer serverPlayer, CallbackInfo ci) {
        this.serverPlayer = serverPlayer;
    }

    @ModifyArg(method = "placeNewPlayer", index = 0, at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;broadcastMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/ChatType;Ljava/util/UUID;)V"))
    private Component join(Component component) {
        // 玩家进入服务器事件。
        PlayerEvent.PLAYER_JOIN_EVENT.invoker().inter(serverPlayer, component);
        return component;
    }
}
