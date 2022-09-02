package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Server;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.LegacyQueryHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.net.InetSocketAddress;

@Mixin(LegacyQueryHandler.class)
public class LegacyQueryHandlerMixin {

    @Inject(method = "channelRead", at = @At(value = "INVOKE", target = "Lio/netty/buffer/ByteBuf;readableBytes()I", ordinal = 0), locals = LocalCapture.CAPTURE_FAILHARD)
    private void ping(ChannelHandlerContext context, Object object, CallbackInfo ci, ByteBuf byteBuf, boolean bl, InetSocketAddress addr, MinecraftServer server) {
        Server.ServerEvent.SERVER_LIST_PING_EVENT.invoker().inter(server);
    }
}
