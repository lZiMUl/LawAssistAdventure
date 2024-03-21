package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.block.*;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

import static com.lzimul.LawAssistAdventure.client.util.ConfigUtil.MODID;

public class BlockRegister {
    private static final DeferredRegister.Blocks Block = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> CraftingTable = registerBlock("crafting_table", CraftingTable::new);//为什么两类名一样的？
    public static final DeferredBlock<Block> ThermalGenerator = registerBlock("thermal_generator", ThermalGenerator::new);
    public static final DeferredBlock<Block> SolarPanelGenerator = registerBlock("solar_panel_generator", SolarPanelGenerator::new);
    public static final DeferredBlock<Block> FluidFuelGenerator = registerBlock("fluid_fuel_generator", FluidFuelGenerator::new);
    public static final DeferredBlock<Block> PowerStorageBox1 = registerBlock("power_storage_box_1", PowerStorageBox1::new);
    public static final DeferredBlock<Block> PowerStorageBox2 = registerBlock("power_storage_box_2", PowerStorageBox2::new);
    public static final DeferredBlock<Block> PowerStorageBox3 = registerBlock("power_storage_box_3", PowerStorageBox3::new);
    public static final DeferredBlock<Block> PowerStorageBox4 = registerBlock("power_storage_box_4", PowerStorageBox4::new);
    public static final DeferredBlock<Block> PowerStorageBox5 = registerBlock("power_storage_box_5", PowerStorageBox5::new);
    public static final DeferredBlock<Block> IndustrialSmeltingFurnaces = registerBlock("industrial_smelting_furnaces", IndustrialSmeltingFurnaces::new);
    public static final DeferredBlock<Block> Washer = registerBlock("washer", Washer::new);
    public static final DeferredBlock<Block> Mill = registerBlock("mill", Mill::new);
    public static final DeferredBlock<Block> Rollers = registerBlock("rollers", Rollers::new);
    public static final DeferredBlock<Block> Knife = registerBlock("knife", Knife::new);
    public static final DeferredBlock<Block> PowerWire = registerBlock("power_wire", PowerWire::new);
    public static final DeferredBlock<Block> Oven = registerBlock("oven", Oven::new);
    public static final DeferredBlock<Block> Saucepan = registerBlock("saucepan", Saucepan::new);
    public static final DeferredBlock<Block> RubberLog = registerBlock("rubber_log", RubberLog::new);
    public static final DeferredBlock<Block> RubberPlanks = registerBlock("rubber_planks", RubberPlanks::new);
    public static final DeferredBlock<Block> RubberLeaves = registerBlock("rubber_leaves", RubberLeaves::new);
    public static final DeferredBlock<Block> Cask = registerBlock("cask", Cask::new);
    public static final DeferredBlock<Block> WoodenFaucet = registerBlock("wooden_faucet", WoodenFaucet::new);
    public static final DeferredBlock<Block> CopperOre = registerBlock("copper_ore", CopperOre::new);
    public static final DeferredBlock<Block> TinOre = registerBlock("tin_ore", TinOre::new);

    private static <T extends Block> DeferredBlock<Block> registerBlock(String name, Supplier<T> block) {
        return Block.register(name, block);
    }

    public static void register(IEventBus modEventBus) {
        Block.register(modEventBus);
    }
}
