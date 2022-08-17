package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;

public class Weather {

    /**
     * 与天气状态变化相关的事件。
     */
    public static final class WeatherEvent {

        /**
         * 天气改变事件。
         */
        public static final Event<ServerLevelAndIntAndWeatherTypeInterface> WEATHER_CHANGE_EVENT = EventFactory.createArrayBacked(
                ServerLevelAndIntAndWeatherTypeInterface.class,
                callbacks -> ((level, num, type) -> {
                    for (ServerLevelAndIntAndWeatherTypeInterface callback : callbacks) {
                        callback.inter(level, num, type);
                    }
                })
        );

        /**
         * 雷暴天气切换事件。
         */
        public static final Event<ServerLevelAndBooleanInterface> THUNDER_CHANGE_EVENT = EventFactory.createArrayBacked(
                ServerLevelAndBooleanInterface.class,
                callbacks -> ((level, num) -> {
                    for (ServerLevelAndBooleanInterface callback : callbacks) {
                        callback.inter(level, num);
                    }
                })
        );

        /**
         * 雷击事件。
         */
        public static final Event<ServerLevelAndVec3iInterface> LIGHTING_STRIKE_EVENT = EventFactory.createArrayBacked(
                ServerLevelAndVec3iInterface.class,
                callbacks -> ((level, pos) -> {
                    for (ServerLevelAndVec3iInterface callback : callbacks) {
                        callback.inter(level, pos);
                    }
                })
        );
    }

    @FunctionalInterface
    public interface ServerLevelAndIntAndWeatherTypeInterface {

        void inter(ServerLevel level, int num, WeatherType type);
    }

    @FunctionalInterface
    public interface ServerLevelAndBooleanInterface {

        void inter(ServerLevel level, boolean num);
    }

    @FunctionalInterface
    public interface ServerLevelAndVec3iInterface {

        void inter(ServerLevel level, Vec3i pos);
    }

    public enum WeatherType{
        RAIN,
        CLEAR
    }
}
