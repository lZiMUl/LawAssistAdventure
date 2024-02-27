package com.lzimul.LawAssistAdventure.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Oven extends Block {
    public Oven() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
