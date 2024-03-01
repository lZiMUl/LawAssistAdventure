package com.lzimul.LawAssistAdventure;

import com.lzimul.LawAssistAdventure.block.entity.CraftingTable;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.LawAssistAdventure.Config.MODID;

public class BlockEntityRegister {
    private static final DeferredRegister<BlockEntityType<?>> BlockEntity = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, MODID);

    public static void register(IEventBus modEventBus) {
        BlockEntity.register(modEventBus);
    };
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CraftingTable>> CraftingTable = BlockEntity.register("crafting_table_entity", () -> BlockEntityType.Builder.of(
            CraftingTable::new,
            BlockRegister.CraftingTable.get()
    ).build(null));


}
