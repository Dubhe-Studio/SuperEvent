package dev.dubhe.superevent.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentInstance;

import java.util.List;

public class Enchantment {

    /**
     * 与附魔台操作相关的事件。
     */
    public static final class EnchantmentEvent{

        /**
         * 成功附魔物品的事件 (在附魔台里面附魔的)
         */
        public static final Event<EnchantmentInstanceListAndItemStackInterface> ENCHANT_ITEM_EVENT = EventFactory.createArrayBacked(
                EnchantmentInstanceListAndItemStackInterface.class,
                callbacks -> ((enchantmentInstanceList, itemStack) -> {
                    for (EnchantmentInstanceListAndItemStackInterface callback : callbacks) {
                        callback.inter(enchantmentInstanceList, itemStack);
                    }
                })
        );

        /**
         * 物品塞入附魔台的事件。
         */
        public static final Event<ItemStackInterface> PREPARE_ITEM_EVENT = EventFactory.createArrayBacked(
                ItemStackInterface.class,
                callbacks -> ((itemStack) -> {
                    for (ItemStackInterface callback : callbacks) {
                        callback.inter(itemStack);
                    }
                })
        );
    }


    @FunctionalInterface
    public interface EnchantmentInstanceListAndItemStackInterface {
        void inter(List<EnchantmentInstance> enchantmentInstanceList, ItemStack itemStack);
    }

    @FunctionalInterface
    public interface ItemStackInterface {

        void inter(ItemStack itemStack);
    }
}
