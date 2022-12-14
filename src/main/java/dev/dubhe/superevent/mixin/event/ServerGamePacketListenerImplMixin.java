package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Player.PlayerEvent;
import net.minecraft.network.chat.ChatType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.UUID;
import java.util.function.Function;

@Mixin(ServerGamePacketListenerImpl.class)
public class ServerGamePacketListenerImplMixin {

    @Shadow
    public ServerPlayer player;

    @ModifyArg(method = "onDisconnect", index = 0, at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;broadcastMessage(Lnet/minecraft/network/chat/Component;Lnet/minecraft/network/chat/ChatType;Ljava/util/UUID;)V"))
    private Component exit(Component component){
        // 玩家离开服务器事件。
        PlayerEvent.PLAYER_QUIT_EVENT.invoker().inter(player, component);
        return component;
    }

    @ModifyArgs(method = "handleChat(Lnet/minecraft/server/network/TextFilter$FilteredText;)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/players/PlayerList;broadcastMessage(Lnet/minecraft/network/chat/Component;Ljava/util/function/Function;Lnet/minecraft/network/chat/ChatType;Ljava/util/UUID;)V"))
    private void chat(Args args){
        Component component = args.get(0);
        // 当玩家聊天时触发这个事件。
        PlayerEvent.PLAYER_CHAT_EVENT.invoker().inter(player, component);
        args.set(0, component);
    }
}
