package com.lzimul.LawAssistAdventure.Blocks;

import com.lzimul.LawAssistAdventure.Dimensions.Dust;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static com.lzimul.LawAssistAdventure.Dimension.DUST;
import static com.lzimul.LawAssistAdventure.Dimension.MAIN_WORLD_DIMENSION;

public class Saucepan extends Block {
    public Saucepan() {
        super(BlockBehaviour.Properties.of().noOcclusion().noCollission());
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        if (!level.isClientSide) {
            if (player.level().dimension() == MAIN_WORLD_DIMENSION) {
                teleportToWorld((ServerPlayer) player, DUST, player.getOnPos());
            } else {
                teleportToWorld((ServerPlayer) player, MAIN_WORLD_DIMENSION, player.getOnPos());
            }
            player.getCooldowns().addCooldown(Item.byBlock(this), 20);
        }
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }
    private void teleportToWorld(ServerPlayer player, ResourceKey<Level> dimension, BlockPos pos) {
        ServerLevel world = Objects.requireNonNull(player.getServer()).getLevel(dimension);
        if (world != null) {
            player.changeDimension(world, new Dust(pos));
        } else {
            player.displayClientMessage(Component.literal("the world not found."), true);
        }
    }
}
