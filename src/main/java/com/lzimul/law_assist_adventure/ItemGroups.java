package com.lzimul.law_assist_adventure;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.law_assist_adventure.Config.MODID;

public class ItemGroups {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public ItemGroups() {
        CREATIVE_MODE_TAB.register("item_group.lzimul.items", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(Blocks.Crafting_Table.get()))
                .title(Component.translatable("item_group.lzimul.item_tabs"))
                .displayItems((input, output) -> {
                    output.accept(Items.Copper_Ingot.get());
                    output.accept(Items.Ingot.get());
                    output.accept(Items.Tin_Ingot.get());
                    output.accept(Items.Copper_Wire.get());
                    output.accept(Items.Gold_Wire.get());
                    output.accept(Items.Tin_Wire.get());
                }).build());
        CREATIVE_MODE_TAB.register("item_group.lzimul.blocks", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(Blocks.Crafting_Table.get()))
                .title(Component.translatable("item_group.lzimul.item_tabs"))
                .displayItems((input, output) -> {
                    output.accept(Items.Crafting_Table.get());
                    output.accept(Items.Washer.get());
                    output.accept(Items.Thermal_Generators.get());
                    output.accept(Items.Power_Storage_Box_1.get());
                    output.accept(Items.Power_Storage_Box_2.get());
                    output.accept(Items.Power_Storage_Box_3.get());
                    output.accept(Items.Power_Storage_Box_4.get());
                    output.accept(Items.Power_Storage_Box_5.get());
                    output.accept(Items.Solar_Panel_Generator.get());
                    output.accept(Items.Fluid_Fuel_Generators.get());
                    output.accept(Items.Power_Wire.get());
                    output.accept(Items.Wind_Tunnel_Chicken.get());
                    output.accept(Items.Industrial_Smelting_Furnaces.get());
                    output.accept(Items.Oven.get());
                    output.accept(Items.Saucepan.get());
                    output.accept(Items.Rubber_Wood.get());
                    output.accept(Items.Rubber_Leaves.get());
                    output.accept(Items.Cask.get());
                    output.accept(Items.Wooden_Faucet.get());
                    output.accept(Items.Copper_Ore.get());
                    output.accept(Items.Tin_Ore.get());
                }).build());
    }

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TAB.register(modEventBus);
    }
}
