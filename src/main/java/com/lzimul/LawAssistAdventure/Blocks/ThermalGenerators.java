package com.lzimul.LawAssistAdventure.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ThermalGenerators extends Block {
    public ThermalGenerators() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
