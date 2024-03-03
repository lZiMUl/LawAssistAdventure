package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.block.entity.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockEntityRegister {
    private static final DeferredRegister<BlockEntityType<?>> BlockEntity = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);
    public static void register(IEventBus eventBus) {
        BlockEntity.register(eventBus);
    }

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CraftingTableEntity>> CraftingTable = BlockEntity.register("crafting_table_entity", () -> BlockEntityType.Builder.of(
            CraftingTableEntity::new,
            BlockRegister.CraftingTable.get()
    ).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidFuelGeneratorEntity>> FluidFuelGenerator = BlockEntity.register("fluid_fuel_generator_entity", () -> BlockEntityType.Builder.of(
            FluidFuelGeneratorEntity::new,
            BlockRegister.FluidFuelGenerator.get()
    ).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WasherEntity>> Washer = BlockEntity.register("washer_entity", () -> BlockEntityType.Builder.of(
            WasherEntity::new,
            BlockRegister.Washer.get()
    ).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarPanelGeneratorEntity>> SolarPanelGenerator = BlockEntity.register("solar_panel_generator_entity", () -> BlockEntityType.Builder.of(
            SolarPanelGeneratorEntity::new,
            BlockRegister.SolarPanelGenerator.get()
    ).build(null));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermalGeneratorEntity>> ThermalGenerator = BlockEntity.register("thermal_generator_entity", () -> BlockEntityType.Builder.of(
            ThermalGeneratorEntity::new,
            BlockRegister.ThermalGenerator.get()
    ).build(null));


    ;
}
