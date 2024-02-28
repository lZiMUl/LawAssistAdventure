package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.Items.Blocks.*;
import com.lzimul.LawAssistAdventure.Items.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ItemRegister {
    private static final DeferredRegister.Items Items = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> CraftingTable = Items.register("crafting_table", CraftingTable::new);
    public static final DeferredItem<BlockItem> Washer = Items.register("washer", Washer::new);
    public static final DeferredItem<BlockItem> ThermalGenerators = Items.register("thermal_generators", ThermalGenerators::new);
    public static final DeferredItem<BlockItem> PowerStorageBox1 = Items.register("power_storage_box_1", PowerStorageBox1::new);
    public static final DeferredItem<BlockItem> PowerStorageBox2 = Items.register("power_storage_box_2", PowerStorageBox2::new);
    public static final DeferredItem<BlockItem> PowerStorageBox3 = Items.register("power_storage_box_3", PowerStorageBox3::new);
    public static final DeferredItem<BlockItem> PowerStorageBox4 = Items.register("power_storage_box_4", PowerStorageBox4::new);
    public static final DeferredItem<BlockItem> PowerStorageBox5 = Items.register("power_storage_box_5", PowerStorageBox5::new);
    public static final DeferredItem<BlockItem> SolarPanelGenerator = Items.register("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredItem<BlockItem> FluidFuelGenerators = Items.register("fluid_fuel_generators", FluidFuelGenerators::new);
    public static final DeferredItem<BlockItem> PowerWire = Items.register("power_wire", PowerWire::new);
    public static final DeferredItem<BlockItem> WindTunnelChicken = Items.register("wind_tunnel_chicken", WindTunnelChicken::new);
    public static final DeferredItem<BlockItem> IndustrialSmeltingFurnaces = Items.register("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredItem<BlockItem> Oven = Items.register("oven", Oven::new);
    public static final DeferredItem<BlockItem> Saucepan = Items.register("saucepan", Saucepan::new);
    public static final DeferredItem<BlockItem> RubberWood = Items.register("rubber_wood", RubberWood::new);
    public static final DeferredItem<BlockItem> RubberLeaves = Items.register("rubber_leaves", RubberLeaves::new);
    public static final DeferredItem<BlockItem> Cask = Items.register("cask", Cask::new);
    public static final DeferredItem<BlockItem> WoodenFaucet = Items.register("wooden_faucet", WoodenFaucet::new);
    public static final DeferredItem<BlockItem> CopperOre = Items.register("copper_ore", CopperOre::new);
    public static final DeferredItem<BlockItem> TinOre = Items.register("tin_ore", TinOre::new);

    public static final DeferredItem<Item> CopperIngot = Items.register("copper_ingot", CopperIngot::new);
    public static final DeferredItem<Item> Ingot = Items.register("ingot", Ingot::new);
    public static final DeferredItem<Item> TinIngot = Items.register("tin_ingot", TinIngot::new);
    public static final DeferredItem<Item> CopperWire = Items.register("copper_wire", CopperWire::new);
    public static final DeferredItem<Item> GoldWire = Items.register("gold_wire", GoldWire::new);
    public static final DeferredItem<Item> TinWire = Items.register("tin_wire", TinWire::new);
    public static final DeferredItem<Item> Teleporter = Items.register("teleporter", Teleporter::new);
    public static final DeferredItem<Item> Glock19 = Items.register("glock19", Glock19::new);

    public static final DeferredItem<ArmorItem> Parachute = Items.register("parachute", () -> ArmorRegister.Parachute);
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerHelm = Items.register("extreme_danger_explorer_helm", () -> ArmorRegister.ExtremeDangerExplorerHelm);
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerBreastplate = Items.register("extreme_danger_explorer_breastplate", () -> ArmorRegister.ExtremeDangerExplorerBreastplate);
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerPants = Items.register("extreme_danger_explorer_pants", () -> ArmorRegister.ExtremeDangerExplorerPants);
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerShoes = Items.register("extreme_danger_explorer_shoes", () -> ArmorRegister.ExtremeDangerExplorerShoes);
    public static void register(IEventBus modEventBus) {
        Items.register(modEventBus);
    }
}