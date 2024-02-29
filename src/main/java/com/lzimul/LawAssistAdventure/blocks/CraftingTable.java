package com.lzimul.LawAssistAdventure.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class CraftingTable extends Block implements MenuProvider {
    private static final ItemStackHandler itemStackHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {

        }
    };
    public CraftingTable() {
        super(BlockBehaviour.Properties.of().noOcclusion());
    }
    @Override
    public @NotNull InteractionResult use(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Player player, @NotNull InteractionHand interactionHand, @NotNull BlockHitResult blockHitResult) {
        // TODO 待开发点击工作台显示界面
        player.openMenu(this);
        return super.use(blockState, level, blockPos, player, interactionHand, blockHitResult);
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable("block.law_assist_adventure.crafting_table");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
        return new AbstractContainerMenu(MenuType.CRAFTER_3x3, i) {
            @Override
            public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
                try {
                    return new ItemStack(CraftingTable.class.newInstance(), 1);
                } catch (IllegalAccessException | InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override
            public boolean stillValid(@NotNull Player p_38874_) {
                return true;
            }
        };
    }
}
