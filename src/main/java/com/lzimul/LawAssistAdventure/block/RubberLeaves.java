package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class RubberLeaves extends Block {
    public RubberLeaves() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
