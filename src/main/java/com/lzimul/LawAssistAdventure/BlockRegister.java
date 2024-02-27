package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.Blocks.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockRegister {
    private static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> Crafting_Table = BLOCKS.register("crafting_table", Crafting_Table::new);
    public static final DeferredBlock<Block> Washer = BLOCKS.register("washer", Washer::new);
    public static final DeferredBlock<Block> Thermal_Generators = BLOCKS.register("thermal_generators", Thermal_Generators::new);
    public static final DeferredBlock<Block> Power_Storage_Box_1 = BLOCKS.register("power_storage_box_1", Power_Storage_Box_1::new);
    public static final DeferredBlock<Block> Power_Storage_Box_2 = BLOCKS.register("power_storage_box_2", Power_Storage_Box_2::new);
    public static final DeferredBlock<Block> Power_Storage_Box_3 = BLOCKS.register("power_storage_box_3", Power_Storage_Box_3::new);
    public static final DeferredBlock<Block> Power_Storage_Box_4 = BLOCKS.register("power_storage_box_4", Power_Storage_Box_4::new);
    public static final DeferredBlock<Block> Power_Storage_Box_5 = BLOCKS.register("power_storage_box_5", Power_Storage_Box_5::new);
    public static final DeferredBlock<Block> Solar_Panel_Generator = BLOCKS.register("solar_panel_generator", Solar_Panel_Generator::new);
    public static final DeferredBlock<Block> Fluid_Fuel_Generators = BLOCKS.register("fluid_fuel_generators", Fluid_Fuel_Generators::new);
    public static final DeferredBlock<Block> Power_Wire = BLOCKS.register("power_wire", Power_Wire::new);
    public static final DeferredBlock<Block> Copper_Ore = BLOCKS.register("copper_ore", Copper_Ore::new);
    public static final DeferredBlock<Block> Tin_Ore = BLOCKS.register("tin_ore", Tin_Ore::new);
    public static final DeferredBlock<Block> Wind_Tunnel_Chicken = BLOCKS.register("wind_tunnel_chicken", Wind_Tunnel_Chicken::new);
    public static final DeferredBlock<Block> Industrial_Smelting_Furnaces = BLOCKS.register("industrial_smelting_furnaces", Industrial_Smelting_Furnaces::new);
    public static final DeferredBlock<Block> Oven = BLOCKS.register("oven", Oven::new);
    public static final DeferredBlock<Block> Saucepan = BLOCKS.register("saucepan", Saucepan::new);
    public static final DeferredBlock<Block> Rubber_Wood = BLOCKS.register("rubber_wood", Rubber_Wood::new);
    public static final DeferredBlock<Block> Rubber_Leaves = BLOCKS.register("rubber_leaves", Rubber_Leaves::new);
    public static final DeferredBlock<Block> Cask = BLOCKS.register("cask", Cask::new);
    public static final DeferredBlock<Block> Wooden_Faucet = BLOCKS.register("wooden_faucet", Wooden_Faucet::new);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
