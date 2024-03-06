package com.lzimul.LawAssistAdventure.block;

import com.lzimul.LawAssistAdventure.block.entity.ThermalGeneratorEntity;
import com.lzimul.LawAssistAdventure.menu.block.ThermalGeneratorMenu;
import com.lzimul.LawAssistAdventure.register.MenuRegister;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;

public class ThermalGenerator extends BaseEntityBlock implements EntityBlock, MenuProvider {
    public ThermalGenerator() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }

    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        // TODO 待开发点击火力发电机显示界面
        if (!level.isClientSide && player.isAlive()) {
            BlockEntity entity = level.getBlockEntity(blockPos);
            if (entity instanceof ThermalGeneratorEntity) {
                player.openMenu(this);
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable(this.getDescriptionId());
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new ThermalGeneratorMenu(id, inventory, player);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos blockPos, @NotNull BlockState blockState) {
        return new ThermalGeneratorEntity(blockPos, blockState);
    }

    @Nonnull
    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return RenderShape.MODEL;
    }
}
