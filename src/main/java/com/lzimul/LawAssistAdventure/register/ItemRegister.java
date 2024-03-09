package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.item.*;
import com.lzimul.LawAssistAdventure.item.block.*;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class ItemRegister {
    private static final DeferredRegister.Items Item = DeferredRegister.createItems(MODID);
    public static final DeferredItem<BlockItem> CraftingTable = Item.register("crafting_table", CraftingTable::new);
    public static final DeferredItem<BlockItem> ThermalGenerator = Item.register("thermal_generator", ThermalGenerator::new);
    public static final DeferredItem<BlockItem> SolarPanelGenerator = Item.register("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredItem<BlockItem> FluidFuelGenerator = Item.register("fluid_fuel_generator", FluidFuelGenerator::new);
    public static final DeferredItem<BlockItem> PowerStorageBox1 = Item.register("power_storage_box_1", PowerStorageBox1::new);
    public static final DeferredItem<BlockItem> PowerStorageBox2 = Item.register("power_storage_box_2", PowerStorageBox2::new);
    public static final DeferredItem<BlockItem> PowerStorageBox3 = Item.register("power_storage_box_3", PowerStorageBox3::new);
    public static final DeferredItem<BlockItem> PowerStorageBox4 = Item.register("power_storage_box_4", PowerStorageBox4::new);
    public static final DeferredItem<BlockItem> PowerStorageBox5 = Item.register("power_storage_box_5", PowerStorageBox5::new);
    public static final DeferredItem<BlockItem> IndustrialSmeltingFurnaces = Item.register("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredItem<BlockItem> Washer = Item.register("washer", Washer::new);
    public static final DeferredItem<BlockItem> Mill = Item.register("mill", Mill::new);
    public static final DeferredItem<BlockItem> Rollers = Item.register("rollers", Rollers::new);
    public static final DeferredItem<BlockItem> Knife = Item.register("knife", Knife::new);
    public static final DeferredItem<BlockItem> PowerWire = Item.register("power_wire", PowerWire::new);
    public static final DeferredItem<BlockItem> Oven = Item.register("oven", Oven::new);
    public static final DeferredItem<BlockItem> Saucepan = Item.register("saucepan", Saucepan::new);
    public static final DeferredItem<BlockItem> RubberLog = Item.register("rubber_log", RubberLog::new);
    public static final DeferredItem<BlockItem> RubberPlanks = Item.register("rubber_planks", RubberPlanks::new);
    public static final DeferredItem<BlockItem> RubberLeaves = Item.register("rubber_leaves", RubberLeaves::new);
    public static final DeferredItem<BlockItem> Cask = Item.register("cask", Cask::new);
    public static final DeferredItem<BlockItem> WoodenFaucet = Item.register("wooden_faucet", WoodenFaucet::new);
    public static final DeferredItem<BlockItem> CopperOre = Item.register("copper_ore", CopperOre::new);
    public static final DeferredItem<BlockItem> TinOre = Item.register("tin_ore", TinOre::new);

    public static final DeferredItem<Item> CopperIngot = Item.register("copper_ingot", CopperIngot::new);
    public static final DeferredItem<Item> SteelIngot = Item.register("steel_ingot", SteelIngot::new);
    public static final DeferredItem<Item> TinIngot = Item.register("tin_ingot", TinIngot::new);
    public static final DeferredItem<Item> GoldWire = Item.register("gold_wire", GoldWire::new);
    public static final DeferredItem<Item> CopperWire = Item.register("copper_wire", CopperWire::new);
    public static final DeferredItem<Item> TinWire = Item.register("tin_wire", TinWire::new);
    public static final DeferredItem<Item> IronPlates = Item.register("iron_plates", IronPlates::new);
    public static final DeferredItem<Item> GoldPlates = Item.register("gold_plates", GoldPlates::new);
    public static final DeferredItem<Item> CopperPlates = Item.register("copper_plates", CopperPlates::new);
    public static final DeferredItem<Item> SteelPlates = Item.register("steel_plates", SteelPlates::new);
    public static final DeferredItem<Item> TinPlates = Item.register("tin_plates", TinPlates::new);
    public static final DeferredItem<Item> CircuitBoards1 = Item.register("circuit_boards_1", CircuitBoards1::new);
    public static final DeferredItem<Item> CircuitBoards2 = Item.register("circuit_boards_2", CircuitBoards2::new);
    public static final DeferredItem<Item> CircuitBoards3 = Item.register("circuit_boards_3", CircuitBoards3::new);
    public static final DeferredItem<Item> CircuitBoardsBase = Item.register("circuit_boards_base", CircuitBoardsBase::new);
    public static final DeferredItem<Item> Teleporter = Item.register("teleporter", Teleporter::new);

    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerHelm = Item.register("extreme_danger_explorer_helm", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerHelm, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerBreastplate = Item.register("extreme_danger_explorer_breastplate", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerBreastplate, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerPants = Item.register("extreme_danger_explorer_pants", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerPants, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerShoes = Item.register("extreme_danger_explorer_shoes", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerShoes, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> DefendTheBall = Item.register("defend_the_ball", () -> new ArmorItem(ArmorRegister.DefendTheBall, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> Parachute = Item.register("parachute",() -> new ArmorItem(ArmorRegister.Parachute, ArmorItem.Type.CHESTPLATE, new Item.Properties()));

    public static final DeferredItem<Item> Hatchet = Item.register("hatchet", Hatchet::new);
    public static final DeferredItem<Item> Glock19 = Item.register("glock19", Glock19::new);
    public static final DeferredItem<Item> Bullet = Item.register("bullet", Bullet::new);
    public static final DeferredItem<Item> BulletBox = Item.register("bullet_box", BulletBox::new);

    public static final DeferredItem<Item> NoOccupation = Item.register("no_occupation", NoOccupation::new);
    public static final DeferredItem<Item> Dust = Item.register("dust", Dust::new);
    public static final DeferredItem<Item> FallIntoTheVoid = Item.register("fall_into_the_void", FallIntoTheVoid::new);
    public static final DeferredItem<Item> FinalWing = Item.register("final_wing", FinalWing::new);
    public static final DeferredItem<Item> RemnantDawn = Item.register("remnant_dawn", RemnantDawn::new);
    public static final DeferredItem<Item> Staring = Item.register("staring", Staring::new);

    public static final DeferredItem<Item> ResearcherHandbook = Item.register("researcher_handbook", ResearcherHandbook::new);
    public static final DeferredItem<Item> ResearcherNote = Item.register("researcher_note", ResearcherNote::new);
    public static final DeferredItem<Item> ResearcherNoteTampered = Item.register("researcher_note_tampered", ResearcherNoteTampered::new);
    public static final DeferredItem<Item> ResearcherNoteCorrupted = Item.register("researcher_note_corrupted", ResearcherNoteCorrupted::new);

    public static void register(IEventBus modEventBus) {
        Item.register(modEventBus);
    }
}