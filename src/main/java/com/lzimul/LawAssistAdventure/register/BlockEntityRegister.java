package com.lzimul.LawAssistAdventure.register;

import com.lzimul.LawAssistAdventure.block.entity.CraftingTableEntity;
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
    };
    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CraftingTableEntity>> CraftingTableEntity = BlockEntity.register("crafting_table_entity", () -> BlockEntityType.Builder.of(
            CraftingTableEntity::new,
            BlockRegister.CraftingTable.get()
    ).build(null));


}
