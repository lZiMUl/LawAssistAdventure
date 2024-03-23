package com.lzimul.LawAssistAdventure.client.menu.block;

import com.lzimul.LawAssistAdventure.block.entity.SolarPanelGeneratorEntity;
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
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.NotNull;

public class SolarPanelGeneratorMenu extends AbstractContainerMenu {
    private final ContainerData containerData;

    public SolarPanelGeneratorMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory, inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()), new SimpleContainerData(1));
    }

    public SolarPanelGeneratorMenu(int id, Inventory inventory, BlockEntity blockEntity, ContainerData containerData) {
        super(MenuRegister.SolarPanelGeneratorMenu.get(), id);
        checkContainerSize(inventory, 1);
        this.containerData = containerData;
        SolarPanelGeneratorEntity solarPanelGeneratorEntity = (SolarPanelGeneratorEntity) blockEntity;
        this.addSlot(new SlotItemHandler(solarPanelGeneratorEntity.getItemHandler(), 0, 80, 32));
        addDataSlots(containerData);
        layoutPlayerInventorySlots(inventory);
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
    public @NotNull ItemStack quickMoveStack(@NotNull Player player, int p_38942_) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(@NotNull Player player) {
        return true;
    }
}
