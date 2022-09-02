package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;

public class Server {

    /**
     * 与服务器程序状态变化有关的事件。
     */
    public static final class ServerEvent {

        /**
         * 当服务器发送广播消息时触发。
         */
        public static final Event<ComponentInterface> BROADCAST_MESSAGE_EVENT = EventFactory.createArrayBacked(
                ComponentInterface.class,
                callbacks -> ((component) -> {
                    for (ComponentInterface callback : callbacks) {
                        callback.inter(component);
                    }
                })
        );

        /**
         * 地图初始化时触发。
         */
        public static final Event<MinecraftServerAndServerLevelInterface> MAP_INITIALIZE_EVENT = EventFactory.createArrayBacked(
                MinecraftServerAndServerLevelInterface.class,
                callbacks -> ((server, level) -> {
                    for (MinecraftServerAndServerLevelInterface callback : callbacks) {
                        callback.inter(server, level);
                    }
                })
        );

        /**
         * 当服务器RCON收到指令时触发。
         */
        public static final Event<StringInterface> REMOTE_SERVER_COMMAND_EVENT = EventFactory.createArrayBacked(
                StringInterface.class,
                callbacks -> ((str) -> {
                    for (StringInterface callback : callbacks) {
                        callback.inter(str);
                    }
                })
        );

        /**
         * 当服务器后台发送指令时触发。
         */
        public static final Event<MinecraftServerAndCommandSourceStackAndStringInterface> SERVER_COMMAND_EVENT = EventFactory.createArrayBacked(
                MinecraftServerAndCommandSourceStackAndStringInterface.class,
                callbacks -> ((server, stack, str) -> {
                    for (MinecraftServerAndCommandSourceStackAndStringInterface callback : callbacks) {
                        callback.inter(server, stack, str);
                    }
                })
        );

        /**
         * 当收到MOTD请求时被触发。
         */
        public static final Event<MinecraftServerInterface> SERVER_LIST_PING_EVENT = EventFactory.createArrayBacked(
                MinecraftServerInterface.class,
                callbacks -> ((server) -> {
                    for (MinecraftServerInterface callback : callbacks) {
                        callback.inter(server);
                    }
                })
        );

        /**
         * 当服务器启动/重载完成时触发。
         */
        public static final Event<MinecraftServerInterface> SERVER_LOAD_EVENT = EventFactory.createArrayBacked(
                MinecraftServerInterface.class,
                callbacks -> ((server) -> {
                    for (MinecraftServerInterface callback : callbacks) {
                        callback.inter(server);
                    }
                })
        );
    }

    @FunctionalInterface
    public interface ComponentInterface {

        void inter(Component component);
    }

    @FunctionalInterface
    public interface StringInterface {

        void inter(String str);
    }

    @FunctionalInterface
    public interface MinecraftServerInterface {

        void inter(MinecraftServer server);
    }

    @FunctionalInterface
    public interface MinecraftServerAndServerLevelInterface {

        void inter(MinecraftServer server, ServerLevel level);
    }

    @FunctionalInterface
    public interface MinecraftServerAndCommandSourceStackAndStringInterface {

        void inter(MinecraftServer server, CommandSourceStack stack, String str);
    }
}
