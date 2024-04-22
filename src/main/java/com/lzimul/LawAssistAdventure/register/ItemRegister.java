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
    public static final DeferredItem<BlockItem> CraftingTable = Item.register("crafting_table", CraftingTableItem::new);
    public static final DeferredItem<BlockItem> ThermalGenerator = Item.register("thermal_generator", ThermalGeneratorItem::new);
    public static final DeferredItem<BlockItem> SolarPanelGenerator = Item.register("solar_panel_generator", SolarPanelGeneratorItem::new);
    public static final DeferredItem<BlockItem> FluidFuelGenerator = Item.register("fluid_fuel_generator", FluidFuelGeneratorItem::new);
    public static final DeferredItem<BlockItem> PowerStorageBox1 = Item.register("power_storage_box_1", PowerStorageBox1Item::new);
    public static final DeferredItem<BlockItem> PowerStorageBox2 = Item.register("power_storage_box_2", PowerStorageBox2Item::new);
    public static final DeferredItem<BlockItem> PowerStorageBox3 = Item.register("power_storage_box_3", PowerStorageBox3Item::new);
    public static final DeferredItem<BlockItem> PowerStorageBox4 = Item.register("power_storage_box_4", PowerStorageBox4Item::new);
    public static final DeferredItem<BlockItem> PowerStorageBox5 = Item.register("power_storage_box_5", PowerStorageBox5Item::new);
    public static final DeferredItem<BlockItem> IndustrialSmeltingFurnaces = Item.register("industrial_smelting_furnaces", IndustrialSmeltingFurnacesItem::new);
    public static final DeferredItem<BlockItem> Washer = Item.register("washer", WasherItem::new);
    public static final DeferredItem<BlockItem> Mill = Item.register("mill", MillItem::new);
    public static final DeferredItem<BlockItem> Rollers = Item.register("rollers", RollersItem::new);
    public static final DeferredItem<BlockItem> Knife = Item.register("knife", KnifeItem::new);
    public static final DeferredItem<BlockItem> PowerWire = Item.register("power_wire", PowerWireItem::new);
    public static final DeferredItem<BlockItem> Oven = Item.register("oven", OvenItem::new);
    public static final DeferredItem<BlockItem> Saucepan = Item.register("saucepan", SaucepanItem::new);
    public static final DeferredItem<BlockItem> RubberLog = Item.register("rubber_log", RubberLogItem::new);
    public static final DeferredItem<BlockItem> RubberPlanks = Item.register("rubber_planks", RubberPlanksItem::new);
    public static final DeferredItem<BlockItem> RubberLeaves = Item.register("rubber_leaves", RubberLeavesItem::new);
    public static final DeferredItem<BlockItem> Cask = Item.register("cask", CaskItem::new);
    public static final DeferredItem<BlockItem> WoodenFaucet = Item.register("wooden_faucet", WoodenFaucetItem::new);
    public static final DeferredItem<BlockItem> CopperOre = Item.register("copper_ore", CopperOreItem::new);
    public static final DeferredItem<BlockItem> TinOre = Item.register("tin_ore", TinOreItem::new);

    public static final DeferredItem<Item> CopperIngot = Item.register("copper_ingot", CopperIngotItem::new);
    public static final DeferredItem<Item> SteelIngot = Item.register("steel_ingot", SteelIngotItem::new);
    public static final DeferredItem<Item> TinIngot = Item.register("tin_ingot", TinIngotItem::new);
    public static final DeferredItem<Item> GoldWire = Item.register("gold_wire", GoldWireItem::new);
    public static final DeferredItem<Item> CopperWire = Item.register("copper_wire", CopperWireItem::new);
    public static final DeferredItem<Item> TinWire = Item.register("tin_wire", TinWireItem::new);
    public static final DeferredItem<Item> IronPlates = Item.register("iron_plates", IronPlatesItem::new);
    public static final DeferredItem<Item> GoldPlates = Item.register("gold_plates", GoldPlatesItem::new);
    public static final DeferredItem<Item> CopperPlates = Item.register("copper_plates", CopperPlatesItem::new);
    public static final DeferredItem<Item> SteelPlates = Item.register("steel_plates", SteelPlatesItem::new);
    public static final DeferredItem<Item> TinPlates = Item.register("tin_plates", TinPlatesItem::new);
    public static final DeferredItem<Item> CircuitBoards1 = Item.register("circuit_boards_1", CircuitBoards1Item::new);
    public static final DeferredItem<Item> CircuitBoards2 = Item.register("circuit_boards_2", CircuitBoards2Item::new);
    public static final DeferredItem<Item> CircuitBoards3 = Item.register("circuit_boards_3", CircuitBoards3Item::new);
    public static final DeferredItem<Item> CircuitBoardsBase = Item.register("circuit_boards_base", CircuitBoardsBaseItem::new);
    public static final DeferredItem<Item> Teleporter = Item.register("teleporter", TeleporterItem::new);

    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerHelm = Item.register("extreme_danger_explorer_helm", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerHelm, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerBreastplate = Item.register("extreme_danger_explorer_breastplate", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerBreastplate, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerPants = Item.register("extreme_danger_explorer_pants", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerPants, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> ExtremeDangerExplorerShoes = Item.register("extreme_danger_explorer_shoes", () -> new ArmorItem(ArmorRegister.ExtremeDangerExplorerShoes, ArmorItem.Type.BOOTS, new Item.Properties()));
    public static final DeferredItem<ArmorItem> DefendTheBall = Item.register("defend_the_ball", () -> new ArmorItem(ArmorRegister.DefendTheBall, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final DeferredItem<ArmorItem> Parachute = Item.register("parachute", () -> new ArmorItem(ArmorRegister.Parachute, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final DeferredItem<Item> Harquebus = Item.register("harquebus", HarquebusItem::new);
    public static final DeferredItem<Item> Hatchet = Item.register("hatchet", HatchetItem::new);
    public static final DeferredItem<Item> Ak47 = Item.register("ak47", Ak47Item::new);
    public static final DeferredItem<Item> PearFlowerGun = Item.register("pear_flower_gun", PearFlowerGunItem::new);
    public static final DeferredItem<Item> Glock19 = Item.register("glock19", Glock19Item::new);
    public static final DeferredItem<Item> Bullet = Item.register("bullet", BulletItem::new);
    public static final DeferredItem<Item> BulletBox = Item.register("bullet_box", BulletBoxItem::new);
    public static final DeferredItem<Item> EmptyBulletBox = Item.register("empty_bullet_box", EmptyBulletBoxItem::new);
    public static final DeferredItem<Item> NoOccupation = Item.register("no_occupation", NoOccupationsItem::new);
    public static final DeferredItem<Item> Dust = Item.register("dust", DustOccupationItem::new);
    public static final DeferredItem<Item> FallIntoTheVoid = Item.register("fall_into_the_void", FallIntoTheVoidOccupationItem::new);
    public static final DeferredItem<Item> FinalWing = Item.register("final_wing", FinalWingOccupationItem::new);
    public static final DeferredItem<Item> RemnantDawn = Item.register("remnant_dawn", RemnantDawnOccupationItem::new);
    public static final DeferredItem<Item> Staring = Item.register("staring", StaringOccupationItem::new);
    public static final DeferredItem<Item> ResearcherHandbook = Item.register("researcher_handbook", ResearcherHandbookItem::new);
    public static final DeferredItem<Item> ResearcherNote = Item.register("researcher_note", ResearcherNoteItem::new);
    public static final DeferredItem<Item> ResearcherNoteTampered = Item.register("researcher_note_tampered", ResearcherNoteTamperedItem::new);
    public static final DeferredItem<Item> ResearcherNoteCorrupted = Item.register("researcher_note_corrupted", ResearcherNoteCorruptedItem::new);

    public static void register(IEventBus modEventBus) {
        Item.register(modEventBus);
    }


}