package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WoodenFaucetBlock extends Block {
    public WoodenFaucetBlock() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }
}
