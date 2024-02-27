package com.lzimul.LawAssistAdventure.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RubberLeaves extends Block {
    public RubberLeaves() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
