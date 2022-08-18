package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.network.chat.Component;

public class Server {

    /**
     * 与服务器程序状态变化有关的事件。
     */
    public static final class ServerEvent{

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
// TODO        public static final Event<> MAP_INITIALIZE_EVENT = EventFactory.createArrayBacked();

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
// TODO        public static final Event<> SERVER_COMMAND_EVENT = EventFactory.createArrayBacked();

        /**
         * 当收到MOTD请求时被触发。
         */
// TODO        public static final Event<> SERVER_LIST_PING_EVENT = EventFactory.createArrayBacked();

        /**
         * 当服务器启动/重载完成时触发。
         */
// TODO        public static final Event<> SERVER_LOAD_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个 CommandSender 尝试补全命令时触发。
         */
// TODO        public static final Event<> TAB_COMPLETE_EVEN = EventFactory.createArrayBacked();
    }

    @FunctionalInterface
    public interface ComponentInterface {

        void inter(Component component);
    }

    @FunctionalInterface
    public interface StringInterface {

        void inter(String str);
    }
}
