package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.Blocks.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockRegister {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> CraftingTable = BLOCKS.register("crafting_table", CraftingTable::new);
    public static final DeferredBlock<Block> Washer = BLOCKS.register("washer", Washer::new);
    public static final DeferredBlock<Block> ThermalGenerators = BLOCKS.register("thermal_generators", ThermalGenerators::new);
    public static final DeferredBlock<Block> PowerStorageBox1 = BLOCKS.register("power_storage_box1", PowerStorageBox1::new);
    public static final DeferredBlock<Block> PowerStorageBox2 = BLOCKS.register("power_storage_box2", PowerStorageBox2::new);
    public static final DeferredBlock<Block> PowerStorageBox3 = BLOCKS.register("power_storage_box3", PowerStorageBox3::new);
    public static final DeferredBlock<Block> PowerStorageBox4 = BLOCKS.register("power_storage_box4", PowerStorageBox4::new);
    public static final DeferredBlock<Block> PowerStorageBox5 = BLOCKS.register("power_storage_box5", PowerStorageBox5::new);
    public static final DeferredBlock<Block> SolarPanelGenerator = BLOCKS.register("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredBlock<Block> FluidFuelGenerators = BLOCKS.register("fluid_fuel_generators", FluidFuelGenerators::new);
    public static final DeferredBlock<Block> PowerWire = BLOCKS.register("power_wire", PowerWire::new);
    public static final DeferredBlock<Block> CopperOre = BLOCKS.register("copper_ore", CopperOre::new);
    public static final DeferredBlock<Block> TinOre = BLOCKS.register("tin_ore", TinOre::new);
    public static final DeferredBlock<Block> WindTunnelChicken = BLOCKS.register("wind_tunnel_chicken", WindTunnelChicken::new);
    public static final DeferredBlock<Block> IndustrialSmeltingFurnaces = BLOCKS.register("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredBlock<Block> Oven = BLOCKS.register("oven", Oven::new);
    public static final DeferredBlock<Block> Saucepan = BLOCKS.register("saucepan", Saucepan::new);
    public static final DeferredBlock<Block> RubberWood = BLOCKS.register("rubber_wood", RubberWood::new);
    public static final DeferredBlock<Block> RubberLeaves = BLOCKS.register("rubber_leaves", RubberLeaves::new);
    public static final DeferredBlock<Block> Cask = BLOCKS.register("cask", Cask::new);
    public static final DeferredBlock<Block> WoodenFaucet = BLOCKS.register("wooden_faucet", WoodenFaucet::new);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
