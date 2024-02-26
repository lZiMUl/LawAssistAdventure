package com.lzimul.law_assist_adventure;

import com.lzimul.lzimul.items.Demo;
import com.lzimul.lzimul.items.Test;
import com.lzimul.lzimul.items.Zy;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.lzimul.Config.MODID;

public class Items {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<Item> ZY = ITEMS.register("zy", Zy::new);
    public static final DeferredItem<BlockItem> DEMO = ITEMS.register("demo", Demo::new);
    public static final DeferredItem<BlockItem> TEST = ITEMS.register("test", Test::new);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
