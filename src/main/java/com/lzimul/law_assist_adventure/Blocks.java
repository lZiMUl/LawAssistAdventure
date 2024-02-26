package com.lzimul.law_assist_adventure;

import com.lzimul.lzimul.blocks.Demo;
import com.lzimul.lzimul.blocks.Test;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import static com.lzimul.lzimul.Config.MODID;

public class Blocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MODID);
    public static final DeferredBlock<Block> DEMO = BLOCKS.register("demo", Demo::new);
    public static final DeferredBlock<Block> TEST = BLOCKS.register("test", Test::new);

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
