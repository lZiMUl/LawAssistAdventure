package com.lzimul.LawAssistAdventure.block.entity;

import com.lzimul.LawAssistAdventure.client.menu.block.FluidFuelGeneratorMenu;
import com.lzimul.LawAssistAdventure.client.menu.block.WasherMenu;
import com.lzimul.LawAssistAdventure.register.BlockEntityRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class WasherEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData containerData;
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private int progress = 0;
    private int progressMax = 100;
    private String descriptionId;

    public WasherEntity(BlockPos blockPos, BlockState blockState, String descriptionId) {
        this(blockPos, blockState);
        this.descriptionId = descriptionId;
    }

    public WasherEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegister.Washer.get(), blockPos, blockState);
        this.containerData = new ContainerData() {

            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> progress;
                    case 1 -> progressMax;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> progress = value;
                    case 1 -> progressMax = value;
                }
            }

            @Override
            public int getCount() {
                return 1;
            }
        };
    }

    public ItemStackHandler getItemHandler() {
        return this.itemStackHandler;
    }

    @Override
    public @NotNull Component getDisplayName() {
        return Component.translatable(this.descriptionId);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new WasherMenu(id, inventory, this, this.containerData);
    }
}
