package com.lzimul.law_assist_adventure;

import com.lzimul.law_assist_adventure.items.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.law_assist_adventure.Config.MODID;

public class Items {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> Crafting_Table = ITEMS.register("crafting_table", Crafting_Table::new);
    public static final DeferredItem<BlockItem> Washer = ITEMS.register("washer", Washer::new);
    public static final DeferredItem<BlockItem> Thermal_Generators = ITEMS.register("thermal_generators", Thermal_Generators::new);
    public static final DeferredItem<BlockItem> Power_Storage_Box_1 = ITEMS.register("power_storage_box_1", Power_Storage_Box_1::new);
    public static final DeferredItem<BlockItem> Power_Storage_Box_2 = ITEMS.register("power_storage_box_2", Power_Storage_Box_2::new);
    public static final DeferredItem<BlockItem> Power_Storage_Box_3 = ITEMS.register("power_storage_box_3", Power_Storage_Box_3::new);
    public static final DeferredItem<BlockItem> Power_Storage_Box_4 = ITEMS.register("power_storage_box_4", Power_Storage_Box_4::new);
    public static final DeferredItem<BlockItem> Power_Storage_Box_5 = ITEMS.register("power_storage_box_5", Power_Storage_Box_5::new);
    public static final DeferredItem<BlockItem> Solar_Panel_Generator = ITEMS.register("solar_panel_generator", Solar_Panel_Generator::new);
    public static final DeferredItem<BlockItem> Fluid_Fuel_Generators = ITEMS.register("fluid_fuel_generators", Fluid_Fuel_Generators::new);
    public static final DeferredItem<BlockItem> Power_Wire = ITEMS.register("power_wire", Power_Wire::new);
    public static final DeferredItem<BlockItem> Wind_Tunnel_Chicken = ITEMS.register("wind_tunnel_chicken", Wind_Tunnel_Chicken::new);
    public static final DeferredItem<BlockItem> Industrial_Smelting_Furnaces = ITEMS.register("industrial_smelting_furnaces", Industrial_Smelting_Furnaces::new);
    public static final DeferredItem<BlockItem> Oven = ITEMS.register("oven", Oven::new);
    public static final DeferredItem<BlockItem> Saucepan = ITEMS.register("saucepan", Saucepan::new);
    public static final DeferredItem<BlockItem> Rubber_Wood = ITEMS.register("rubber_wood", Rubber_Wood::new);
    public static final DeferredItem<BlockItem> Rubber_Leaves = ITEMS.register("rubber_leaves", Rubber_Leaves::new);
    public static final DeferredItem<BlockItem> Cask = ITEMS.register("cask", Cask::new);
    public static final DeferredItem<BlockItem> Wooden_Faucet = ITEMS.register("wooden_faucet", Wooden_Faucet::new);
    public static final DeferredItem<BlockItem> Copper_Ore = ITEMS.register("copper_ore", Copper_Ore::new);
    public static final DeferredItem<BlockItem> Tin_Ore = ITEMS.register("tin_ore", Tin_Ore::new);
    public static final DeferredItem<Item> Copper_Ingot = ITEMS.register("copper_ingot", Copper_Ingot::new);
    public static final DeferredItem<Item> Ingot = ITEMS.register("ingot", Ingot::new);
    public static final DeferredItem<Item> Tin_Ingot = ITEMS.register("tin_ingot", Tin_Ingot::new);
    public static final DeferredItem<Item> Copper_Wire = ITEMS.register("copper_wire", Copper_Wire::new);
    public static final DeferredItem<Item> Gold_Wire = ITEMS.register("gold_wire", Gold_Wire::new);
    public static final DeferredItem<Item> Tin_Wire = ITEMS.register("tin_wire", Tin_Wire::new);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
