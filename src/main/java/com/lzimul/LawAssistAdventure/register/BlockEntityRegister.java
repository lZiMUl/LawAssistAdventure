package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.block.entity.*;
import com.mojang.datafixers.types.Type;
import com.mojang.datafixers.types.templates.TypeTemplate;
import com.mojang.serialization.Codec;
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

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CraftingTableEntity>> CraftingTable = BlockEntity.register("crafting_table", () -> BlockEntityType.Builder.of(
            CraftingTableEntity::new,
            BlockRegister.CraftingTable.get()
    ).build(new Type<CraftingTableEntity>() {
        @Override
        public TypeTemplate buildTemplate() {
            return null;
        }

        @Override
        protected Codec<CraftingTableEntity> buildCodec() {
            return null;
        }

        @Override
        public boolean equals(Object o, boolean b, boolean b1) {
            return true;
        }
    }));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FluidFuelGeneratorEntity>> FluidFuelGenerator = BlockEntity.register("fluid_fuel_generator", () -> BlockEntityType.Builder.of(
            FluidFuelGeneratorEntity::new,
            BlockRegister.FluidFuelGenerator.get()
    ).build(new Type<FluidFuelGeneratorEntity>() {
        @Override
        public TypeTemplate buildTemplate() {
            return null;
        }

        @Override
        protected Codec<FluidFuelGeneratorEntity> buildCodec() {
            return null;
        }

        @Override
        public boolean equals(Object o, boolean b, boolean b1) {
            return true;
        }
    }));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SolarPanelGeneratorEntity>> SolarPanelGenerator = BlockEntity.register("solar_panel_generator", () -> BlockEntityType.Builder.of(
            SolarPanelGeneratorEntity::new,
            BlockRegister.SolarPanelGenerator.get()
    ).build(new Type<SolarPanelGeneratorEntity>() {
        @Override
        public TypeTemplate buildTemplate() {
            return null;
        }

        @Override
        protected Codec<SolarPanelGeneratorEntity> buildCodec() {
            return null;
        }

        @Override
        public boolean equals(Object o, boolean b, boolean b1) {
            return true;
        }
    }));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ThermalGeneratorEntity>> ThermalGenerator = BlockEntity.register("thermal_generator", () -> BlockEntityType.Builder.of(
            ThermalGeneratorEntity::new,
            BlockRegister.ThermalGenerator.get()
    ).build(new Type<ThermalGeneratorEntity>() {
        @Override
        public TypeTemplate buildTemplate() {
            return null;
        }

        @Override
        protected Codec<ThermalGeneratorEntity> buildCodec() {
            return null;
        }

        @Override
        public boolean equals(Object o, boolean b, boolean b1) {
            return true;
        }
    }));
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<WasherEntity>> Washer = BlockEntity.register("washer", () -> BlockEntityType.Builder.of(
            WasherEntity::new,
            BlockRegister.Washer.get()
    ).build(new Type<WasherEntity>() {
        @Override
        public TypeTemplate buildTemplate() {
            return null;
        }

        @Override
        protected Codec<WasherEntity> buildCodec() {
            return null;
        }

        @Override
        public boolean equals(Object o, boolean b, boolean b1) {
            return true;
        }
    }));
}
