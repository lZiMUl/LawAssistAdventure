package com.lzimul.LawAssistAdventure.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RubberPlanksBlock extends Block {
    public RubberPlanksBlock() {
        super(BlockBehaviour.Properties.of()
                .strength(3.0f)
        );
    }

    @Override
    public @NotNull SoundType getSoundType(@NotNull BlockState blockState) {
        return SoundType.WOOD;
    }
}
