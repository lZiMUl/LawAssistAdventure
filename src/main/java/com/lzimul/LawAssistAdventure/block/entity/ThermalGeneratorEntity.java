package com.lzimul.LawAssistAdventure.block.entity;

import com.lzimul.LawAssistAdventure.client.menu.block.ThermalGeneratorMenu;
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

import static com.lzimul.LawAssistAdventure.Config.getDescriptionId;

public class ThermalGeneratorEntity extends BlockEntity implements MenuProvider {
    protected final ContainerData containerData;
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(1) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };
    private int progress = 0;
    private int progressMax = 100;

    public ThermalGeneratorEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegister.ThermalGenerator.get(), blockPos, blockState);
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
        return Component.translatable(getDescriptionId(super.level, getBlockPos()));
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, @NotNull Inventory inventory, @NotNull Player player) {
        return new ThermalGeneratorMenu(id, inventory, this, this.containerData);
    }
}
