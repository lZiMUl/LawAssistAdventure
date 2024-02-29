package com.lzimul.LawAssistAdventure.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

public class IndustrialSmeltingFurnaces extends Block {
    public IndustrialSmeltingFurnaces() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        // TODO 待开发点击工业冶炼炉显示界面
        player.sendSystemMessage(Component.literal(IndustrialSmeltingFurnaces.class.getName()));
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
}
