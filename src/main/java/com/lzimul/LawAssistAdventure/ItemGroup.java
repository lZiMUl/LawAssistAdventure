package com.lzimul.LawAssistAdventure;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ItemGroup {
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    public ItemGroup() {
        CREATIVE_MODE_TAB.register("item_group.lzimul.law_assist_adventure.items", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(BlockRegister.Crafting_Table.get()))
                .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.items"))
                .displayItems((input, output) -> {
                    output.accept(ItemRegister.Copper_Ingot.get());
                    output.accept(ItemRegister.Ingot.get());
                    output.accept(ItemRegister.Tin_Ingot.get());
                    output.accept(ItemRegister.Copper_Wire.get());
                    output.accept(ItemRegister.Gold_Wire.get());
                    output.accept(ItemRegister.Tin_Wire.get());
                }).build());

        CREATIVE_MODE_TAB.register("item_group.lzimul.law_assist_adventure.blocks", () -> CreativeModeTab.builder()
                .icon(() -> new ItemStack(BlockRegister.Crafting_Table.get()))
                .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.blocks"))
                .displayItems((input, output) -> {
                    output.accept(ItemRegister.Crafting_Table.get());
                    output.accept(ItemRegister.Washer.get());
                    output.accept(ItemRegister.Thermal_Generators.get());
                    output.accept(ItemRegister.Power_Storage_Box_1.get());
                    output.accept(ItemRegister.Power_Storage_Box_2.get());
                    output.accept(ItemRegister.Power_Storage_Box_3.get());
                    output.accept(ItemRegister.Power_Storage_Box_4.get());
                    output.accept(ItemRegister.Power_Storage_Box_5.get());
                    output.accept(ItemRegister.Solar_Panel_Generator.get());
                    output.accept(ItemRegister.Fluid_Fuel_Generators.get());
                    output.accept(ItemRegister.Power_Wire.get());
                    output.accept(ItemRegister.Wind_Tunnel_Chicken.get());
                    output.accept(ItemRegister.Industrial_Smelting_Furnaces.get());
                    output.accept(ItemRegister.Oven.get());
                    output.accept(ItemRegister.Saucepan.get());
                    output.accept(ItemRegister.Rubber_Wood.get());
                    output.accept(ItemRegister.Rubber_Leaves.get());
                    output.accept(ItemRegister.Cask.get());
                    output.accept(ItemRegister.Wooden_Faucet.get());
                    output.accept(ItemRegister.Copper_Ore.get());
                    output.accept(ItemRegister.Tin_Ore.get());
                }).build());
    }

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TAB.register(modEventBus);
    }
}
