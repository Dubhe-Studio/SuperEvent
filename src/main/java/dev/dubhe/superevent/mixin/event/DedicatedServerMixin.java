package dev.dubhe.superevent.mixin.event;

import dev.dubhe.superevent.event.Server.ServerEvent;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.dedicated.DedicatedServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Environment(EnvType.SERVER)
@Mixin(DedicatedServer.class)
public class DedicatedServerMixin {
    MinecraftServer self = (DedicatedServer) (Object) this;

    @Redirect(method = "handleConsoleInputs", at = @At(value = "INVOKE", target = "Lnet/minecraft/commands/Commands;performCommand(Lnet/minecraft/commands/CommandSourceStack;Ljava/lang/String;)I"))
    private int runCommand(Commands instance, CommandSourceStack source, String command) {
        ServerEvent.SERVER_COMMAND_EVENT.invoker().inter(self, source, command);
        return self.getCommands().performCommand(source, command);
    }
}
