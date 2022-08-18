package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;

public class Entity {

    /**
     * 与实体相关的事件，不包括 一些直接引用的更具体的实体类型。
     */
    public static final class EntityEvent {

        /**
         * 当滞留药水应用它的效果时触发本事件，期间每5 tick发生一次。
         */
// TODO        public static final Event<> AREA_EFFECT_CLOUD_APPLY_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当扎在实体上的箭数量变化时触发。
         */
// TODO        public static final Event<> ARROW_BODY_COUNT_CHANGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当蝙蝠试图入睡或从睡梦中醒来时触发。
         */
// TODO        public static final Event<> BAT_TOGGLE_SLEEP_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个生物体在世界中出生时触发该事件。
         */
// TODO        public static final Event<> CREATURE_SPAWN_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当爬行者被闪电击中时触发该事件。
         */
// TODO        public static final Event<> CREEPER_POWER_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当末影龙切换阶段时触发。
         */
// TODO        public static final Event<> ENDER_DRAGON_CHANGE_PHASE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体的氧气值发生变化时触发本事件。
         */
// TODO        public static final Event<> ENTITY_AIR_CHANGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体破坏门时触发本事件。
         */
// TODO        public static final Event<> ENTITY_BREAK_DOOR_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体与另一个实体繁殖时触发。
         */
// TODO        public static final Event<> ENTITY_BREED_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当任何实体更改方块且更特定的事件不可用时触发。
         */
// TODO        public static final Event<> ENTITY_CHANGE_BLOCK_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当方块造成实体燃烧时触发该事件。
         */
// TODO        public static final Event<> ENTITY_COMBUST_BY_BLOCK_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体造成另外一个实体燃烧时触发该事件。
         */
// TODO        public static final Event<> ENTITY_COMBUST_BY_ENTITY_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体燃烧时触发该事件。
         */
// TODO        public static final Event<> ENTITY_COMBUST_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体受到来自方块的伤害时触发该事件。
         */
// TODO        public static final Event<> ENTITY_DAMAGE_BY_BLOCK_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体受到另外一个实体伤害时触发该事件。
         */
// TODO        public static final Event<> ENTITY_DAMAGE_BY_ENTITY_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当任何一个实体死亡时触发本事件。
         */
// TODO        public static final Event<> ENTITY_DEATH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体丢出物品时触发。
         */
// TODO        public static final Event<> ENTITY_DROP_ITEM_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体进入方块, 保存到那个方块时触发本事件。
         */
// TODO        public static final Event<> ENTITY_ENTER_BLOCK_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体进入求爱模式时触发本事件。
         */
// TODO        public static final Event<> ENTITY_ENTER_LOVE_MODE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当人类实体消耗经验时触发。
         */
// TODO        public static final Event<> ENTITY_EXHAUSTION_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体爆炸的时候触发本事件。
         */
// TODO        public static final Event<> ENTITY_EXPLODE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体与其他物体互交时触发本事件。
         */
// TODO        public static final Event<> ENTITY_INTERACT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体捡起地面上的掉落物时触发本事件。
         */
// TODO        public static final Event<> ENTITY_PICKUP_ITEM_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体因玩家在一个方块上"放置"一物品而创建时触发本事件。
         */
// TODO        public static final Event<> ENTITY_PLACE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个实体与传送门接触时触发本事件。
         */
// TODO        public static final Event<> ENTITY_PORTAL_ENTER_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个非玩家的实体被传送门传送时触发本事件。
         */
// TODO        public static final Event<> ENTITY_PORTAL_EVENT  = EventFactory.createArrayBacked();

        /**
         * 在实体从末地传送门离开时调用。
         */
// TODO        public static final Event<> ENTITY_PORTAL_EXIT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体改变它的姿态时触发本事件。
         */
// TODO        public static final Event<> ENTITY_POSE_CHANGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体上的药水效果发生改变时触发本事件。
         */
// TODO        public static final Event<> ENTITY_POTION_EFFECT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体恢复生命值时触发本事件。
         */
// TODO        public static final Event<> ENTITY_REGAIN_HEALTH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体死亡并可能有机会复活时触发。
         */
// TODO        public static final Event<> ENTITY_RESURRECT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个生物用弓射出一支箭时触发。
         */
// TODO        public static final Event<> ENTITY_SHOOT_BOW_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体生成于世界内时触发本事件。
         */
// TODO        public static final Event<> ENTITY_SPAWN_EVENT  = EventFactory.createArrayBacked();

        /**
         * 在唤魔者施法时触发。
         */
// TODO        public static final Event<> ENTITY_SPELL_CAST_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当生物实体被驯服时触发本事件。
         */
// TODO        public static final Event<> ENTITY_TAME_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当生物瞄准或取消瞄准另一个实体时触发。
         */
// TODO        public static final Event<> ENTITY_TARGET_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体以生物为目标并且只能以生物为目标时触发。
         */
// TODO        public static final Event<> ENTITY_TARGET_LIVING_ENTITY_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当非玩家实体从一个位置传送到另一个位置时触发。
         */
// TODO        public static final Event<> ENTITY_TELEPORT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体的移动状态被切换为鞘翅时触发。
         */
// TODO        public static final Event<> ENTITY_TOGGLE_GLIDE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体游泳状态改变时触发本事件。
         */
// TODO        public static final Event<> ENTITY_TOGGLE_SWIM_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体将转化/蜕变为其它实体时触发本事件。
         */
// TODO        public static final Event<> ENTITY_TRANSFORM_EVENT  = EventFactory.createArrayBacked();

        /**
         * 在实体被栓绳释放时触发。
         */
// TODO        public static final Event<> ENTITY_UNLEASH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当附魔之瓶释放经验时触发。
         */
// TODO        public static final Event<> EXP_BOTTLE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当实体爆炸时触发。
         */
// TODO        public static final Event<> EXPLOSION_PRIME_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当烟花爆炸时触发本事件。
         */
// TODO        public static final Event<> FIREWORK_EXPLODE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个人类实体的饥饿值发生变化时触发本事件。
         */
// TODO        public static final Event<> FOOD_LEVEL_CHANGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当马跳起时调用此事件。
         */
// TODO        public static final Event<> HORSE_JUMP_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当掉落物存在时间超过5分钟后被移除时触发本事件 (注:掉落物存在时间因服务器配置和安装的插件而异)。
         */
// TODO        public static final Event<> ITEM_DESPAWN_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当物品实体合并时触发本事件。
         */
// TODO        public static final Event<> ITEM_MERGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当掉落物生成于某个世界时触发本事件。
         */
// TODO        public static final Event<> ITEM_SPAWN_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当滞留药水击中某个区域时触发。
         */
// TODO        public static final Event<> LINGERING_POTION_SPLASH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 与猪灵交易时触发。
         */
// TODO        public static final Event<> PIGLIN_BARTER_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当僵尸猪灵被另一个实体激怒时触发。
         */
// TODO        public static final Event<> PIG_ZOMBIE_ANGER_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个玩家死亡时触发本事件。
         */
// TODO        public static final Event<> PLAYER_DEATH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 在一个生物被玩家拴住时触发。
         */
// TODO        public static final Event<> PLAYER_LEASH_ENTITY_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当飞溅药水击中某个区域时触发。
         */
// TODO        public static final Event<> POTION_SPLASH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当射弹击中物体时触发。
         */
// TODO        public static final Event<> PROJECTILE_HIT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当一个抛射物被发射时触发本事件。
         */
// TODO        public static final Event<> PROJECTILE_LAUNCH_EVENT  = EventFactory.createArrayBacked();

        /**
         * 羊染色时触发。
         */
// TODO        public static final Event<> SHEEP_DYE_WOOL_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当羊身上的羊毛重新长出时触发本事件。
         */
// TODO        public static final Event<> SHEEP_REGROW_WOOL_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当史莱姆死亡后分裂成小史莱姆时触发本事件。
         */
// TODO        public static final Event<> SLIME_SPLIT_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当刷怪笼刷出实体时触发本事件。
         */
// TODO        public static final Event<> SPAWNER_SPAWN_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当炽足兽的体温发生变化时触发。
         */
// TODO        public static final Event<> STRIDER_TEMPERATURE_CHANGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当村民获得新的交易时触发。
         */
// TODO        public static final Event<> VILLAGER_ACQUIRE_TRADE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当村民职业发生变化时触发本事件。
         */
// TODO        public static final Event<> VILLAGER_CAREER_CHANGE_EVENT  = EventFactory.createArrayBacked();

        /**
         * 当村民交易的最大使用量由于玩家的交易增加时触发。
         */
// TODO        public static final Event<> VILLAGER_REPLENISH_TRADE_EVENT  = EventFactory.createArrayBacked();

    }
}
