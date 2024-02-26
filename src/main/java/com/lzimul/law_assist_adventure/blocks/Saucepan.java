package com.lzimul.law_assist_adventure.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Saucepan extends Block {
    public Saucepan() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }
}
