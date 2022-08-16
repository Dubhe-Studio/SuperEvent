package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class Player {

    /**
     * 与玩家相关的事件。
     */
    public static final class PlayerEvent {

        /**
         * 当玩家聊天时触发这个事件。
         */
        public static final Event<ServerPlayerAndMessageInterface> PLAYER_CHAT_EVENT = EventFactory.createArrayBacked(
                ServerPlayerAndMessageInterface.class,
                callbacks -> ((player, message) -> {
                    for (ServerPlayerAndMessageInterface callback : callbacks) {
                        callback.inter(player, message);
                    }
                })
        );

        /**
         * 当玩家完成一个进度中所有的标准时触发此事件。
         */
//TODO        public static final Event<> PLAYER_ADVANCEMENT_DONE_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家动作事件。
         */
//TODO        public static final Event<> PLAYER_ANIMATION_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家动作的不同种类
         */
//TODO        public static final Event<> PLAYER_ANIMATIO_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家与装甲架交互并且进行交换, 取回或放置物品时触发本事件。
         */
//TODO        public static final Event<> PLAYER_ARMOR_STAND_MANIPULATE_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家准备躺到床上时触发此事件。
         */
        public static final Event<ServerPlayerAndBlockPosInterface> PLAYER_BED_ENTER_EVENT = EventFactory.createArrayBacked(
                ServerPlayerAndBlockPosInterface.class,
                callbacks -> ((player, pos) -> {
                    for (ServerPlayerAndBlockPosInterface callback : callbacks) {
                        callback.inter(player, pos);
                    }
                })
        );

        /**
         * 玩家离开床时触发此事件。
         */
        public static final Event<ServerPlayerAndBlockPosInterface> PLAYER_BED_LEAVE_EVENT= EventFactory.createArrayBacked(
                ServerPlayerAndBlockPosInterface.class,
                callbacks -> ((player, pos) -> {
                    for (ServerPlayerAndBlockPosInterface callback : callbacks) {
                        callback.inter(player, pos);
                    }
                })
        );

        /**
         * 玩家用完一只桶后触发此事件。
         */
//TODO        public static final Event<> PLAYER_BUCKET_EMPTY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家用桶捕捉实体时会触发此事件。
         */
//TODO        public static final Event<> PLAYER_BUCKET_ENTITY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家使用桶时触发本事件。
         */
//TODO        public static final Event<> PLAYER_BUCKET_EVENT = EventFactory.createArrayBacked();

        /**
         * 水桶装满水事件。
         */
//TODO        public static final Event<> PLAYER_BUCKET_FILL_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家在客户端设置改变主手时触发本事件。
         */
//TODO        public static final Event<> PLAYER_CHANGED_MAIN_HAND_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家切换到另一个世界时触发此事件。
         */
//TODO        public static final Event<> PLAYER_CHANGED_WORLD_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家注册/注销一个新的插件通道时触发本事件
         */
//TODO        public static final Event<> PLAYER_CHANNEL_EVENT = EventFactory.createArrayBacked();

        /**
         * 这个事件是,当一个玩家执行一个命令的时候将会被触发(也就是在聊天框里面输入信息以/开头的时候，算作命令，就会触发此事件)。
         */
//TODO        public static final Event<> PLAYER_COMMAND_PREPROCESS_EVENT = EventFactory.createArrayBacked();

        /**
         * 当服务器可用命令列表发送给玩家时触发本事件。
         */
//TODO        public static final Event<> PLAYER_COMMAND_SEND_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家丢出物品事件。
         */
//TODO        public static final Event<> PLAYER_DROP_ITEM_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家编辑或签名书与笔时触发。
         */
//TODO        public static final Event<> PLAYER_EDIT_BOOK_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家抛出鸡蛋时触发本事件，鸡蛋可能孵化。
         */
//TODO        public static final Event<> PLAYER_EGG_THROW_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家经验值发生变化时调用此事件。
         */
//TODO        public static final Event<> PLAYER_EXP_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家钓鱼时触发本事件。
         */
//TODO        public static final Event<> PLAYER_FISH_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家游戏模式发生变化时调用此事件。
         */
//TODO        public static final Event<> PLAYER_GAME_MODE_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家收获一个方块时调用此事件。
         */
//TODO        public static final Event<> PLAYER_HARVEST_BLOCK_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家在实体上点击某实体上的某位置时触发此事件。
         */
//TODO        public static final Event<> PLAYER_INTERACT_AT_ENTITY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家点击一个实体时调用此事件。
         */
//TODO        public static final Event<> PLAYER_INTERACT_ENTITY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家对一个对象或空气进行交互时触发本事件。
         */
//TODO        public static final Event<> PLAYER_INTERACT_EVENT = EventFactory.createArrayBacked();

        /**
         * 某玩家工具耐久消耗完毕时触发(比如铲子，打火石，铁制工具)。
         */
//TODO        public static final Event<> PLAYER_ITEM_BREAK_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家消耗完物品时, 此事件将触发 例如:(食物, 药水, 牛奶桶)。
         */
//TODO        public static final Event<> PLAYER_ITEM_CONSUME_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家使用的物品因使用而减少耐久时调用。
         */
//TODO        public static final Event<> PLAYER_ITEM_DAMAGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家手持某物品事件。
         */
//TODO        public static final Event<> PLAYER_ITEM_HELD_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家通过装备上的经验修补附魔修复装备耐久时触发该事件。
         */
//TODO        public static final Event<> PLAYER_ITEM_MEND_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家进入服务器事件。
         */
        public static final Event<ServerPlayerAndMessageInterface> PLAYER_JOIN_EVENT = EventFactory.createArrayBacked(
                ServerPlayerAndMessageInterface.class,
                callbacks -> ((player, message) -> {
                    for (ServerPlayerAndMessageInterface callback : callbacks) {
                        callback.inter(player, message);
                    }
                })
        );

        /**
         * 玩家被服务器踢出事件。
         */
//TODO        public static final Event<> PLAYER_KICK_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家等级改变事件。
         */
//TODO        public static final Event<> PLAYER_LEVEL_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家改变他们的语言设置时触发本事件。
         */
//TODO        public static final Event<> PLAYER_LOCALE_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家尝试登录的事件。
         */
//TODO        public static final Event<> PLAYER_LOGIN_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家移动事件。
         */
//TODO        public static final Event<> PLAYER_MOVE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家从地上捡起箭时触发本事件。
         */
//TODO        public static final Event<> PLAYER_PICKUP_ARROW_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家将要被传送门传送的事件, 传送过程中会生成一个退出传送门。
         */
//TODO        public static final Event<> PLAYER_PORTAL_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家离开服务器事件。
         */
        public static final Event<ServerPlayerAndMessageInterface> PLAYER_QUIT_EVENT = EventFactory.createArrayBacked(
                ServerPlayerAndMessageInterface.class,
                callbacks -> ((player, message) -> {
                    for (ServerPlayerAndMessageInterface callback : callbacks) {
                        callback.inter(player, message);
                    }
                })
        );

        /**
         * 当玩家在配方书中解锁新配方(合成公式)时触发本事件。
         */
//TODO        public static final Event<> PLAYER_RECIPE_DISCOVER_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家注册通信通道之后立即触发此事件。
         */
//TODO        public static final Event<> PLAYER_REGISTER_CHANNEL_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家对通过 Player.setResourcePack(java.lang.String) 发起的资源包请求采取动作时触发本事件。
         */
//TODO        public static final Event<> PLAYER_RESOURCE_PACK_STATUS_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家重生事件。
         */
//TODO        public static final Event<> PLAYER_RESPAWN_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家在使用三叉戟上的激流附魔推动它们在空中飞行(需要在雨天才能在空中飞行)时触发本事件
         */
//TODO        public static final Event<> PLAYER_RIPTIDE_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家对某实体使用剪刀采集物品时调用此事件。
         */
//TODO        public static final Event<> PLAYER_SHEAR_ENTITY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家统计信息增长时触发本事件。
         */
//TODO        public static final Event<> PLAYER_STATISTIC_INCREMENT_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家用快捷键互换主手和副手的物品时触发本事件。
         */
//TODO        public static final Event<> PLAYER_SWAP_HAND_ITEMS_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家拿讲台上的书时调用此事件。
         */
//TODO        public static final Event<> PLAYER_TAKE_LECTERN_BOOK_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家传送事件。
         */
//TODO        public static final Event<> PLAYER_TELEPORT_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家切换飞行状态则调用此事件。
         */
//TODO        public static final Event<> PLAYER_TOGGLE_FLIGHT_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家切换潜行状态则调用此事件。
         */
//TODO        public static final Event<> PLAYER_TOGGLE_SNEAK_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家切换疾跑状态时调用此事件
         */
//TODO        public static final Event<> PLAYER_TOGGLE_SPRINT_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个实体被玩家解开拴绳时调用。
         */
//TODO        public static final Event<> PLAYER_UNLEASH_ENTITY_EVENT = EventFactory.createArrayBacked();

        /**
         * 玩家移动速度变化事件。
         */
//TODO        public static final Event<> PLAYER_VELOCITY_EVENT = EventFactory.createArrayBacked();
    }

    @FunctionalInterface
    public interface ServerPlayerAndMessageInterface {

        void inter(ServerPlayer player, Component message);
    }

    @FunctionalInterface
    public interface ServerPlayerAndBlockPosInterface {

        void inter(ServerPlayer player, BlockPos pos);
    }
}
