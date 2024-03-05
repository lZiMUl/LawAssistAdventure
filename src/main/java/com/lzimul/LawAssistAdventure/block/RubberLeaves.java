package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RubberLeaves extends Block {
    public RubberLeaves() {
        super(BlockBehaviour.Properties.of().noOcclusion()
                .strength(1.0f)
        );
    }
    @Override
    public @NotNull SoundType getSoundType(@NotNull BlockState blockState) {
        return SoundType.AZALEA_LEAVES;
    }
}
