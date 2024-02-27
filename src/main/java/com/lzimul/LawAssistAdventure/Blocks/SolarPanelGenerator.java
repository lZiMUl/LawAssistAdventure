package com.lzimul.LawAssistAdventure.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class SolarPanelGenerator extends Block {
    public SolarPanelGenerator() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
