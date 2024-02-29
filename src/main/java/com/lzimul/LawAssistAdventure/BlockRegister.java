package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.blocks.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockRegister {
    private static final DeferredRegister.Blocks Blocks = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> CraftingTable = Blocks.register("crafting_table", CraftingTable::new);
    public static final DeferredBlock<Block> ThermalGenerators = Blocks.register("thermal_generators", ThermalGenerators::new);
    public static final DeferredBlock<Block> SolarPanelGenerator = Blocks.register("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredBlock<Block> FluidFuelGenerators = Blocks.register("fluid_fuel_generators", FluidFuelGenerators::new);
    public static final DeferredBlock<Block> PowerStorageBox1 = Blocks.register("power_storage_box_1", PowerStorageBox1::new);
    public static final DeferredBlock<Block> PowerStorageBox2 = Blocks.register("power_storage_box_2", PowerStorageBox2::new);
    public static final DeferredBlock<Block> PowerStorageBox3 = Blocks.register("power_storage_box_3", PowerStorageBox3::new);
    public static final DeferredBlock<Block> PowerStorageBox4 = Blocks.register("power_storage_box_4", PowerStorageBox4::new);
    public static final DeferredBlock<Block> PowerStorageBox5 = Blocks.register("power_storage_box_5", PowerStorageBox5::new);
    public static final DeferredBlock<Block> IndustrialSmeltingFurnaces = Blocks.register("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredBlock<Block> Washer = Blocks.register("washer", Washer::new);
    public static final DeferredBlock<Block> WindTunnelChicken = Blocks.register("wind_tunnel_chicken", WindTunnelChicken::new);
    public static final DeferredBlock<Block> Rollers = Blocks.register("rollers", Rollers::new);
    public static final DeferredBlock<Block> Knife = Blocks.register("knife", Knife::new);
    public static final DeferredBlock<Block> PowerWire = Blocks.register("power_wire", PowerWire::new);
    public static final DeferredBlock<Block> Oven = Blocks.register("oven", Oven::new);
    public static final DeferredBlock<Block> Saucepan = Blocks.register("saucepan", Saucepan::new);
    public static final DeferredBlock<Block> RubberWood = Blocks.register("rubber_wood", RubberWood::new);
    public static final DeferredBlock<Block> RubberLeaves = Blocks.register("rubber_leaves", RubberLeaves::new);
    public static final DeferredBlock<Block> Cask = Blocks.register("cask", Cask::new);
    public static final DeferredBlock<Block> WoodenFaucet = Blocks.register("wooden_faucet", WoodenFaucet::new);
    public static final DeferredBlock<Block> CopperOre = Blocks.register("copper_ore", CopperOre::new);
    public static final DeferredBlock<Block> TinOre = Blocks.register("tin_ore", TinOre::new);
    public static void register(IEventBus modEventBus) {
        Blocks.register(modEventBus);
    }
}
