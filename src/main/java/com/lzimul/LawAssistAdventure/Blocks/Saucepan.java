package com.lzimul.LawAssistAdventure.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class Saucepan extends Block {
    public Saucepan() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }
}
