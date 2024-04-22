package com.lzimul.LawAssistAdventure.client.menu.block;

import com.lzimul.LawAssistAdventure.block.entity.CraftingTableEntity;
import com.lzimul.LawAssistAdventure.register.MenuRegister;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.apache.commons.lang3.function.TriConsumer;
import org.jetbrains.annotations.NotNull;

public class CraftingTableMenu extends AbstractContainerMenu {

    public CraftingTableMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory, inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()), new SimpleContainerData(1));
    }

    public CraftingTableMenu(int id, Inventory inventory, BlockEntity blockEntity, ContainerData containerData) {
        super(MenuRegister.CraftingTableMenu.get(), id);
        checkContainerSize(inventory, 13);
        CraftingTableEntity craftingTableBlockEntity = (CraftingTableEntity) blockEntity;

        addDataSlots(containerData);
        layoutPlayerInventorySlots(inventory);

        ItemStackHandler handler = craftingTableBlockEntity.getItemHandler();
        int[][] positions = {
                {11, 19},
                {29, 19},
                {47, 19},
                {11, 37},
                {29, 37},
                {47, 37},
                {11, 55},
                {29, 55},
                {47, 55},
                {82, 58},
                {103, 58},
                {124, 58},
                {125, 20}
        };
        forEachWithIndex(positions, (data, index, source) -> this.addSlot(new SlotItemHandler(handler, index, data[0], data[1])));
    }

    public static <T> void forEachWithIndex(T[] array, TriConsumer<T, Integer, T[]> consumer) {
        for (int i = 0; i < array.length; i++) {
            consumer.accept(array[i], i, array);
        }
    }

    private void layoutPlayerInventorySlots(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(@NotNull Player p_38874_) {
        return true;
    }
}
