package com.lzimul.LawAssistAdventure;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ItemGroup {
    private static final DeferredRegister<CreativeModeTab> Creative_Mode_Tab = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);
    DeferredHolder<CreativeModeTab, CreativeModeTab> blocks = Creative_Mode_Tab.register("item_group.lzimul.law_assist_adventure.blocks", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(BlockRegister.CraftingTable.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.blocks"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.CraftingTable.get());
                output.accept(ItemRegister.Washer.get());
                output.accept(ItemRegister.ThermalGenerators.get());
                output.accept(ItemRegister.PowerStorageBox1.get());
                output.accept(ItemRegister.PowerStorageBox2.get());
                output.accept(ItemRegister.PowerStorageBox3.get());
                output.accept(ItemRegister.PowerStorageBox4.get());
                output.accept(ItemRegister.PowerStorageBox5.get());
                output.accept(ItemRegister.SolarPanelGenerator.get());
                output.accept(ItemRegister.FluidFuelGenerators.get());
                output.accept(ItemRegister.PowerWire.get());
                output.accept(ItemRegister.WindTunnelChicken.get());
                output.accept(ItemRegister.IndustrialSmeltingFurnaces.get());
                output.accept(ItemRegister.Oven.get());
                output.accept(ItemRegister.Saucepan.get());
                output.accept(ItemRegister.RubberWood.get());
                output.accept(ItemRegister.RubberLeaves.get());
                output.accept(ItemRegister.Cask.get());
                output.accept(ItemRegister.WoodenFaucet.get());
                output.accept(ItemRegister.CopperOre.get());
                output.accept(ItemRegister.TinOre.get());
            }).build());
    DeferredHolder<CreativeModeTab, CreativeModeTab> items = Creative_Mode_Tab.register("item_group.lzimul.law_assist_adventure.items", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.CopperIngot.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.items"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.CopperIngot.get());
                output.accept(ItemRegister.Ingot.get());
                output.accept(ItemRegister.TinIngot.get());
                output.accept(ItemRegister.CopperWire.get());
                output.accept(ItemRegister.GoldWire.get());
                output.accept(ItemRegister.TinWire.get());
                output.accept(ItemRegister.Teleporter.get());
            }).withTabsBefore(blocks.getId()).build());;
    DeferredHolder<CreativeModeTab, CreativeModeTab> armors = Creative_Mode_Tab.register("item_group.lzimul.law_assist_adventure.armors", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ItemRegister.ExtremeDangerExplorerHelm.get()))
            .title(Component.translatable("itemGroup.lzimul.law_assist_adventure.armors"))
            .displayItems((input, output) -> {
                output.accept(ItemRegister.ExtremeDangerExplorerHelm.get());
                output.accept(ItemRegister.ExtremeDangerExplorerBreastplate.get());
                output.accept(ItemRegister.ExtremeDangerExplorerPants.get());
                output.accept(ItemRegister.ExtremeDangerExplorerShoes.get());
                output.accept(ItemRegister.Glock19.get());
                output.accept(ItemRegister.Parachute.get());
            }).withTabsBefore(items.getId()).build());;
    public static void register(IEventBus modEventBus) {
        Creative_Mode_Tab.register(modEventBus);
    }
}
