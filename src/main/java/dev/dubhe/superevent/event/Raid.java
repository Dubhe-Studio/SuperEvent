package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class Raid {

    /**
     * 与袭击有关的事件。
     */
    public static final class RaidEvent {

        /**
         * 当袭击以胜利或失败时触发本事件。
         */
        public static final Event<RaidAndBooleanInterface> RAID_FINISH_EVENT = EventFactory.createArrayBacked(
                RaidAndBooleanInterface.class,
                callbacks -> ((raid, bl) -> {
                    for (RaidAndBooleanInterface callback : callbacks) {
                        callback.inter(raid, bl);
                    }
                })
        );

        /**
         * 当新一波袭击开始时触发本事件。
         */
        public static final Event<RaidInterface> RAID_SPAWN_WAVE_EVENT = EventFactory.createArrayBacked(
                RaidInterface.class,
                callbacks -> ((raid) -> {
                    for (RaidInterface callback : callbacks) {
                        callback.inter(raid);
                    }
                })
        );

        /**
         * 当袭击中断时触发本事件。
         */
        public static final Event<RaidInterface> RAID_STOP_EVENT = EventFactory.createArrayBacked(
                RaidInterface.class,
                callbacks -> ((raid) -> {
                    for (RaidInterface callback : callbacks) {
                        callback.inter(raid);
                    }
                })
        );

        /**
         * 当袭击被触发时触发本事件。
         */
        public static final Event<RaidInterface> RAID_TRIGGER_EVENT = EventFactory.createArrayBacked(
                RaidInterface.class,
                callbacks -> ((raid) -> {
                    for (RaidInterface callback : callbacks) {
                        callback.inter(raid);
                    }
                })
        );
    }

    @FunctionalInterface
    public interface RaidAndBooleanInterface {

        void inter(net.minecraft.world.entity.raid.Raid raid,boolean bl);
    }

    @FunctionalInterface
    public interface RaidInterface {

        void inter(net.minecraft.world.entity.raid.Raid raid);
    }
}
