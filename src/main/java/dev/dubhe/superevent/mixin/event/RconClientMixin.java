package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Server.ServerEvent;
import net.minecraft.server.rcon.thread.RconClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.io.BufferedInputStream;

@Mixin(RconClient.class)
public class RconClientMixin {

    @Inject(method = "run",at = @At(value = "INVOKE",target = "Lnet/minecraft/server/ServerInterface;runCommand(Ljava/lang/String;)Ljava/lang/String;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void runCommand(CallbackInfo ci, BufferedInputStream bufferedInputStream, int i, int j, int k, int l, int m,
            String string, String string2){
        // 当服务器RCON收到指令时触发。
        ServerEvent.REMOTE_SERVER_COMMAND_EVENT.invoker().inter(string2);
    }
}
