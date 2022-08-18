package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;

public class Hanging {

    /**
     * 与悬挂实体相关的事件。
     */
    public static final class HangingEvent {

        /**
         * 当一个悬挂实体被一个实体移除时调用本事件。
         */
        public static final Event<EntityAndHangingEntityInterface> HANGING_BREAK_BY_ENTITY_EVENT = EventFactory.createArrayBacked(
                EntityAndHangingEntityInterface.class,
                callbacks -> ((entity, hangingEntity) -> {
                    for (EntityAndHangingEntityInterface callback : callbacks) {
                        callback.inter(entity, hangingEntity);
                    }
                })
        );

        /**
         * 当一个悬挂实体被移除时调用。
         */
        public static final Event<HangingEntityInterface> HANGING_BREAK_EVENT = EventFactory.createArrayBacked(
                HangingEntityInterface.class,
                callbacks -> ((hangingEntity) -> {
                    for (HangingEntityInterface callback : callbacks) {
                        callback.inter(hangingEntity);
                    }
                })
        );

        /**
         * 当一个悬挂实体被放置时触发本事件。
         */
        public static final Event<PlayerAndHangingEntityAndBlockPosInterface> HANGING_PLACE_EVENT = EventFactory.createArrayBacked(
                PlayerAndHangingEntityAndBlockPosInterface.class,
                callbacks -> ((player, hangingEntity, blockPos) -> {
                    for (PlayerAndHangingEntityAndBlockPosInterface callback : callbacks) {
                        callback.inter(player, hangingEntity, blockPos);
                    }
                })
        );
    }

    @FunctionalInterface
    public interface EntityAndHangingEntityInterface {

        void inter(Entity entity, HangingEntity hangingEntity);
    }

    @FunctionalInterface
    public interface HangingEntityInterface {

        void inter(HangingEntity hangingEntity);
    }

    @FunctionalInterface
    public interface PlayerAndHangingEntityAndBlockPosInterface {

        void inter(Player player, HangingEntity hangingEntity, BlockPos blockPos);
    }
}
