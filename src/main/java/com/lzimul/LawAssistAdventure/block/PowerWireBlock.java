package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class PowerWireBlock extends Block {
    public PowerWireBlock() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }
}
