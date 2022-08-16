package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class Block {

    /**
     * 与方块被改变或与世界进行交互等情况相关的事件。
     */
    public static final class BlockEvent {

        /**
         * 当一个方块被玩家破坏的时候，调用本事件。
         */
//TODO        public static final Event<> BLOCK_BREAK_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块被火烧掉的时候触发此事件。
         */
//TODO        public static final Event<> BLOCK_BURN_EVENT = EventFactory.createArrayBacked();

        /**
         * 当我们尝试建造一个方块的时候，可以检测我们是否可以在此建造它。
         */
//TODO        public static final Event<> BLOCK_CAN_BUILD_EVENT = EventFactory.createArrayBacked();

        /**
         * 当物品堆在方块内成功烹饪时触发本事件 (原版中这个方块一般是营火)。
         */
//TODO        public static final Event<> BLOCK_COOK_EVENT = EventFactory.createArrayBacked();

        /**
         * 方块被玩家损坏的事件。
         */
//TODO        public static final Event<> BLOCK_DAMAGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个可装备物品从某个方块发射出来并装备到附近的实体上时触发本事件。
         */
//TODO        public static final Event<> BLOCK_DISPENSE_ARMOR_EVENT = EventFactory.createArrayBacked();

        /**
         * 物品被方块(比如发射器,投掷器等)射出的事件。
         */
//TODO        public static final Event<> BLOCK_DISPENSE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块被玩家破坏且掉落物品时触发本事件。
         */
//TODO        public static final Event<> BLOCK_DROP_ITEM_EVENT = EventFactory.createArrayBacked();

        /**
         * 方块产生经验的时候(比如煤矿被被打破会掉落经验)时触发。
         */
//TODO        public static final Event<> BLOCK_EXP_EVENT = EventFactory.createArrayBacked();

        /**
         * 方块爆炸事件。
         */
//TODO        public static final Event<> BLOCK_EXPLODE_EVENT = EventFactory.createArrayBacked();

        /**
         * 方块因为自然条件消退，融化，消失的事件。
         */
//TODO        public static final Event<> BLOCK_FADE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家使用骨粉向某方块施肥后导致方块发生变化时触发本事件。
         */
//TODO        public static final Event<> BLOCK_FERTILIZE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块因为自然变化被放置、更改或者蔓延时(比如下雪),触发此事件。
         */
//TODO        public static final Event<> BLOCK_FORM_EVENT = EventFactory.createArrayBacked();

        /**
         * 液体流动/龙蛋自己传送的事件(源方块到目标方块)。
         */
//TODO        public static final Event<> BLOCK_FROM_TO_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块在世界中自然生长的时触发此事件(如小麦生长)。
         */
//TODO        public static final Event<> BLOCK_GROW_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块被点燃时触发。
         */
//TODO        public static final Event<> BLOCK_IGNITE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当玩家放一个方块, 而连锁放置了第二个方块时(例如玩家放置一个床)触发本事件。
         */
//TODO        public static final Event<> BLOCK_MULTI_PLACE_EVENT = EventFactory.createArrayBacked();

        /**
         * 方块物理事件(例如是沙子掉落、流水)。
         */
//TODO        public static final Event<> BLOCK_PHYSICS_EVENT = EventFactory.createArrayBacked();

        /**
         * 活塞相关事件
         */
//TODO        public static final Event<> BLOCK_PISTON_EVENT = EventFactory.createArrayBacked();

        /**
         * 活塞臂推出事件。
         */
//TODO        public static final Event<> BLOCK_PISTON_EXTEND_EVENT = EventFactory.createArrayBacked();

        /**
         * 活塞臂缩回事件
         */
//TODO        public static final Event<> BLOCK_PISTON_RETRACT_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块被玩家放置的时候触发此事件。
         */
//TODO        public static final Event<> BLOCK_PLACE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当Sculk Sensor接收到游戏事件并因此可能激活时调用。
         */
//TODO        public static final Event<> BLOCK_RECEIVE_GAME_EVENT = EventFactory.createArrayBacked();

        /**
         * 当方块接受到的红石信号变化时触发此事件
         */
//TODO        public static final Event<> BLOCK_REDSTONE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当发射器剪掉附近的羊的羊毛时触发本事件 (发射器内含剪刀时有机会触发本事件)。
         */
//TODO        public static final Event<> BLOCK_SHEAR_ENTITY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当一个方块基于自然法则地蔓延时触发此事件(比如菌丝的蔓延)。
         */
//TODO        public static final Event<> BLOCK_SPREAD_EVENT = EventFactory.createArrayBacked();

        /**
         * 炼药锅水位发生变化时触发本事件。
         */
//TODO        public static final Event<> CAULDRON_LEVEL_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 实体形成方块时触发此事件
         */
//TODO        public static final Event<> ENTITY_BLOCK_FORM_EVENT = EventFactory.createArrayBacked();

        /**
         * 当液体方块的液面高度因相邻方块而发生变化时触发本事件。
         */
//TODO        public static final Event<> FLUID_LEVEL_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当树叶消失时触发此事件。
         */
//TODO        public static final Event<> LEAVES_DECAY_EVENT = EventFactory.createArrayBacked();

        /**
         * 当耕地的湿润等级发生变化时触发本事件。
         */
//TODO        public static final Event<> MOISTURE_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 音符盒播放音符的事件[玩家点击/红石触发]
         */
//TODO        public static final Event<> NOTE_PLAY_EVENT = EventFactory.createArrayBacked();

        /**
         * 在玩家设置牌子上的内容子时触发。
         */
//TODO        public static final Event<> SIGN_CHANGE_EVENT = EventFactory.createArrayBacked();

        /**
         * 当海绵吸水时触发本事件。
         */
//TODO        public static final Event<> SPONGE_ABSORB_EVENT = EventFactory.createArrayBacked();
    }
}
