package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.Items.*;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ItemRegister {
    private static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> CraftingTable = ITEMS.register("crafting_table", CraftingTable::new);
    public static final DeferredItem<BlockItem> Washer = ITEMS.register("washer", Washer::new);
    public static final DeferredItem<BlockItem> ThermalGenerators = ITEMS.register("thermal_generators", ThermalGenerators::new);
    public static final DeferredItem<BlockItem> PowerStorageBox1 = ITEMS.register("power_storage_box_1", PowerStorageBox1::new);
    public static final DeferredItem<BlockItem> PowerStorageBox2 = ITEMS.register("power_storage_box_2", PowerStorageBox2::new);
    public static final DeferredItem<BlockItem> PowerStorageBox3 = ITEMS.register("power_storage_box_3", PowerStorageBox3::new);
    public static final DeferredItem<BlockItem> PowerStorageBox4 = ITEMS.register("power_storage_box_4", PowerStorageBox4::new);
    public static final DeferredItem<BlockItem> PowerStorageBox5 = ITEMS.register("power_storage_box_5", PowerStorageBox5::new);
    public static final DeferredItem<BlockItem> SolarPanelGenerator = ITEMS.register("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredItem<BlockItem> FluidFuelGenerators = ITEMS.register("fluid_fuel_generators", FluidFuelGenerators::new);
    public static final DeferredItem<BlockItem> PowerWire = ITEMS.register("power_wire", PowerWire::new);
    public static final DeferredItem<BlockItem> WindTunnelChicken = ITEMS.register("wind_tunnel_chicken", WindTunnelChicken::new);
    public static final DeferredItem<BlockItem> IndustrialSmeltingFurnaces = ITEMS.register("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredItem<BlockItem> Oven = ITEMS.register("oven", Oven::new);
    public static final DeferredItem<BlockItem> Saucepan = ITEMS.register("saucepan", Saucepan::new);
    public static final DeferredItem<BlockItem> RubberWood = ITEMS.register("rubber_wood", RubberWood::new);
    public static final DeferredItem<BlockItem> RubberLeaves = ITEMS.register("rubber_leaves", RubberLeaves::new);
    public static final DeferredItem<BlockItem> Cask = ITEMS.register("cask", Cask::new);
    public static final DeferredItem<BlockItem> WoodenFaucet = ITEMS.register("wooden_faucet", WoodenFaucet::new);
    public static final DeferredItem<BlockItem> CopperOre = ITEMS.register("copper_ore", CopperOre::new);
    public static final DeferredItem<BlockItem> TinOre = ITEMS.register("tin_ore", TinOre::new);
    public static final DeferredItem<Item> CopperIngot = ITEMS.register("copper_ingot", CopperIngot::new);
    public static final DeferredItem<Item> Ingot = ITEMS.register("ingot", Ingot::new);
    public static final DeferredItem<Item> TinIngot = ITEMS.register("tin_ingot", TinIngot::new);
    public static final DeferredItem<Item> CopperWire = ITEMS.register("copper_wire", CopperWire::new);
    public static final DeferredItem<Item> GoldWire = ITEMS.register("gold_wire", GoldWire::new);
    public static final DeferredItem<Item> TinWire = ITEMS.register("tin_wire", TinWire::new);
    public static final DeferredItem<Item> Teleporter = ITEMS.register("teleporter", Teleporter::new);

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
