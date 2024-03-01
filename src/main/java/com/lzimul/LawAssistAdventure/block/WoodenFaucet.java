package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class WoodenFaucet extends Block {
    public WoodenFaucet() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }
}
