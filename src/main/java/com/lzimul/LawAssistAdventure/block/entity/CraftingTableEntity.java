package com.lzimul.LawAssistAdventure.block.entity;

import com.lzimul.LawAssistAdventure.client.menu.block.CraftingTableMenu;
import com.lzimul.LawAssistAdventure.register.BlockEntityRegister;
import com.lzimul.LawAssistAdventure.register.ItemRegister;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.lzimul.LawAssistAdventure.Config.getDescriptionId;

public class CraftingTableEntity extends BlockEntity implements MenuProvider {
    private final ContainerData containerData;
    private int progress = 0;
    private int progressMax = 100;
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(13) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (slot == 4 && itemStackHandler.getStackInSlot(4).getItem() == ItemRegister.Glock19.get().asItem()) {
                itemStackHandler.setStackInSlot(12, ItemRegister.Ak47.toStack());
            }
            if (slot == 12 && itemStackHandler.getStackInSlot(12).getItem() == ItemStack.EMPTY.getItem()) {
                itemStackHandler.setStackInSlot(4, ItemStack.EMPTY);
            }
        }
    };
    public CraftingTableEntity(BlockPos blockPos, BlockState blockState) {
        super(BlockEntityRegister.CraftingTable.get(), blockPos, blockState);
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
        return new CraftingTableMenu(id, inventory, this, this.containerData);
    }

    @Override
    public void load(@NotNull CompoundTag compoundTag) {
        super.load(compoundTag);
        this.itemStackHandler.deserializeNBT(compoundTag.getCompound("Inventory"));
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.put("Inventory", this.itemStackHandler.serializeNBT());
    }


}
