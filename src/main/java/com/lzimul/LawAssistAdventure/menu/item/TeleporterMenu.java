package com.lzimul.LawAssistAdventure.menu.item;

import com.lzimul.LawAssistAdventure.ItemRegister;
import com.lzimul.LawAssistAdventure.MenuRegister;
import com.lzimul.LawAssistAdventure.screen.item.TeleporterScreen;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;

public class TeleporterMenu extends AbstractContainerMenu {

    public TeleporterMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id, inventory, inventory.player.level().getBlockEntity(friendlyByteBuf.readBlockPos()), new SimpleContainerData(2));
    }

    public TeleporterMenu(int id, Inventory inventory, BlockEntity blockEntity, ContainerData containerData) {
        super(MenuRegister.TeleporterMenu.get(), id);
    }

    @Override
    public @NotNull ItemStack quickMoveStack(@NotNull Player p_38941_, int p_38942_) {
        return new ItemStack(ItemRegister.Teleporter.get());
    }

    @Override
    public boolean stillValid(@NotNull Player p_38874_) {
        return true;
    }
}
