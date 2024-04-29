package com.lzimul.LawAssistAdventure.block;

import com.lzimul.LawAssistAdventure.block.entity.CraftingTableEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;


public class CraftingTableBlock extends BaseEntityBlock {

    public CraftingTableBlock() {
        super(BlockBehaviour.Properties.of());
    }

//    @Override
//    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
//        if (!level.isClientSide && player.isAlive()) {
//            BlockEntity entity = level.getBlockEntity(blockPos);
//            if (entity instanceof CraftingTableEntity) {
//                if (OccupationHelper.isOccupation("final_wing")) {
//                    player.openMenu(Objects.requireNonNull(this.getMenuProvider(blockState, level, blockPos)), blockPos);
//                } else {
//                    player.sendSystemMessage(Component.literal("当前职业无法使用！"));
//                }
//            }
//        }
//        return InteractionResult.SUCCESS;
//    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(@NotNull BlockPos pos, @NotNull BlockState state) {
        return new CraftingTableEntity(pos, state);
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos, @NotNull CollisionContext collisionContext) {
        return box(0, 0, 0, 16, 16, 16);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return null;
    }

    @Nonnull
    @Override
    public RenderShape getRenderShape(@Nonnull BlockState state) {
        return RenderShape.MODEL;
    }
}
