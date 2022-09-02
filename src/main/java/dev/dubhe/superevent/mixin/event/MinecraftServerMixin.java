package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Server.ServerEvent;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.progress.ChunkProgressListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {

    @Inject(method = "runServer", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;updateStatusIcon(Lnet/minecraft/network/protocol/status/ServerStatus;)V"))
    private void loadServer(CallbackInfo info) {
        ServerEvent.SERVER_LOAD_EVENT.invoker().inter((MinecraftServer) (Object) this);
    }

    @Inject(method = "reloadResources", at=@At("TAIL"))
    private void reloadServer(Collection<String> selectedIds, CallbackInfoReturnable<CompletableFuture<Void>> cir){
        ServerEvent.SERVER_LOAD_EVENT.invoker().inter((MinecraftServer) (Object) this);
    }

    @Redirect(method = "createLevels", at = @At(value = "INVOKE",target = "Ljava/util/Map;put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"))
    private <K, V> V createWorlds(Map<K, V> levels, K registryKey, V serverLevel){
        final V result = levels.put(registryKey, serverLevel);
        ServerEvent.MAP_INITIALIZE_EVENT.invoker().inter((MinecraftServer) (Object) this,(ServerLevel) serverLevel);
        return result;
    }
}
