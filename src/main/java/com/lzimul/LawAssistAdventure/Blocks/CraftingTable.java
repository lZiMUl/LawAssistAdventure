package com.lzimul.LawAssistAdventure.Blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CraftingTable extends Block {
    public CraftingTable() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
}
