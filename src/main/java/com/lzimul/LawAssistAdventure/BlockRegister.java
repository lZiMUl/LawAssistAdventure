package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.block.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockRegister {
    private static final DeferredRegister.Blocks Block = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> CraftingTable = Block.register("crafting_table", CraftingTable::new);
    public static final DeferredBlock<Block> ThermalGenerators = Block.register("thermal_generators", ThermalGenerators::new);
    public static final DeferredBlock<Block> SolarPanelGenerator = Block.register("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredBlock<Block> FluidFuelGenerators = Block.register("fluid_fuel_generators", FluidFuelGenerators::new);
    public static final DeferredBlock<Block> PowerStorageBox1 = Block.register("power_storage_box_1", PowerStorageBox1::new);
    public static final DeferredBlock<Block> PowerStorageBox2 = Block.register("power_storage_box_2", PowerStorageBox2::new);
    public static final DeferredBlock<Block> PowerStorageBox3 = Block.register("power_storage_box_3", PowerStorageBox3::new);
    public static final DeferredBlock<Block> PowerStorageBox4 = Block.register("power_storage_box_4", PowerStorageBox4::new);
    public static final DeferredBlock<Block> PowerStorageBox5 = Block.register("power_storage_box_5", PowerStorageBox5::new);
    public static final DeferredBlock<Block> IndustrialSmeltingFurnaces = Block.register("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredBlock<Block> Washer = Block.register("washer", Washer::new);
    public static final DeferredBlock<Block> Mill = Block.register("mill", Mill::new);
    public static final DeferredBlock<Block> Rollers = Block.register("rollers", Rollers::new);
    public static final DeferredBlock<Block> Knife = Block.register("knife", Knife::new);
    public static final DeferredBlock<Block> PowerWire = Block.register("power_wire", PowerWire::new);
    public static final DeferredBlock<Block> Oven = Block.register("oven", Oven::new);
    public static final DeferredBlock<Block> Saucepan = Block.register("saucepan", Saucepan::new);
    public static final DeferredBlock<Block> RubberWood = Block.register("rubber_wood", RubberWood::new);
    public static final DeferredBlock<Block> RubberLeaves = Block.register("rubber_leaves", RubberLeaves::new);
    public static final DeferredBlock<Block> Cask = Block.register("cask", Cask::new);
    public static final DeferredBlock<Block> WoodenFaucet = Block.register("wooden_faucet", WoodenFaucet::new);
    public static final DeferredBlock<Block> CopperOre = Block.register("copper_ore", CopperOre::new);
    public static final DeferredBlock<Block> TinOre = Block.register("tin_ore", TinOre::new);
    public static void register(IEventBus modEventBus) {
        Block.register(modEventBus);
    }
}
