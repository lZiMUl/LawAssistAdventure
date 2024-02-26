package com.lzimul.law_assist_adventure;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.law_assist_adventure.Config.MODID;

public class ItemTabs {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public ItemTabs() {
        CREATIVE_MODE_TAB.register("item_group.lzimul", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(Blocks.DEMO.get()))
                .title(Component.translatable("item_group.lzimul.item_tabs"))
                .displayItems((input, output) -> {
                    output.accept(Items.DEMO.get());
                    output.accept(Items.TEST.get());
                    output.accept(Items.ZY.get());

                    output.accept(Blocks.DEMO.get());
                    output.accept(Blocks.TEST.get());
                }).build());
    }

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TAB.register(modEventBus);
    }
}
