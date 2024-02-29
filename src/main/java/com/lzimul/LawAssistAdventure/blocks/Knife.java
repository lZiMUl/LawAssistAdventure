package com.lzimul.LawAssistAdventure.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Knife extends Block {
    public Knife() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
