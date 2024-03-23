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
    public static final DeferredBlock<Block> CraftingTable = registerBlock("crafting_table", CraftingTableBlock::new);//为什么两类名一样的？
    public static final DeferredBlock<Block> ThermalGenerator = registerBlock("thermal_generator", ThermalGeneratorBlock::new);
    public static final DeferredBlock<Block> SolarPanelGenerator = registerBlock("solar_panel_generator", SolarPanelGeneratorBlock::new);
    public static final DeferredBlock<Block> FluidFuelGenerator = registerBlock("fluid_fuel_generator", FluidFuelGeneratorBlock::new);
    public static final DeferredBlock<Block> PowerStorageBox1 = registerBlock("power_storage_box_1", PowerStorageBox1Block::new);
    public static final DeferredBlock<Block> PowerStorageBox2 = registerBlock("power_storage_box_2", PowerStorageBox2Block::new);
    public static final DeferredBlock<Block> PowerStorageBox3 = registerBlock("power_storage_box_3", PowerStorageBox3Block::new);
    public static final DeferredBlock<Block> PowerStorageBox4 = registerBlock("power_storage_box_4", PowerStorageBox4Block::new);
    public static final DeferredBlock<Block> PowerStorageBox5 = registerBlock("power_storage_box_5", PowerStorageBox5Block::new);
    public static final DeferredBlock<Block> IndustrialSmeltingFurnaces = registerBlock("industrial_smelting_furnaces", IndustrialSmeltingFurnacesBlock::new);
    public static final DeferredBlock<Block> Washer = registerBlock("washer", WasherBlock::new);
    public static final DeferredBlock<Block> Mill = registerBlock("mill", MillBlock::new);
    public static final DeferredBlock<Block> Rollers = registerBlock("rollers", RollersBlock::new);
    public static final DeferredBlock<Block> Knife = registerBlock("knife", KnifeBlock::new);
    public static final DeferredBlock<Block> PowerWire = registerBlock("power_wire", PowerWireBlock::new);
    public static final DeferredBlock<Block> Oven = registerBlock("oven", OvenBlock::new);
    public static final DeferredBlock<Block> Saucepan = registerBlock("saucepan", SaucepanBlock::new);
    public static final DeferredBlock<Block> RubberLog = registerBlock("rubber_log", RubberLogBlock::new);
    public static final DeferredBlock<Block> RubberPlanks = registerBlock("rubber_planks", RubberPlanksBlock::new);
    public static final DeferredBlock<Block> RubberLeaves = registerBlock("rubber_leaves", RubberLeavesBlock::new);
    public static final DeferredBlock<Block> Cask = registerBlock("cask", CaskBlock::new);
    public static final DeferredBlock<Block> WoodenFaucet = registerBlock("wooden_faucet", WoodenFaucetBlock::new);
    public static final DeferredBlock<Block> CopperOre = registerBlock("copper_ore", CopperOreBlock::new);
    public static final DeferredBlock<Block> TinOre = registerBlock("tin_ore", TinOreBlock::new);

    private static <T extends Block> DeferredBlock<Block> registerBlock(String name, Supplier<T> block) {
        return Block.register(name, block);
    }

    public static void register(IEventBus modEventBus) {
        Block.register(modEventBus);
    }
}
