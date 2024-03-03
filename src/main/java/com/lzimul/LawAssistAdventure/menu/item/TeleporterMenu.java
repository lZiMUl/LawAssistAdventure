package com.lzimul.LawAssistAdventure.menu.item;

import com.lzimul.LawAssistAdventure.register.ItemRegister;
import com.lzimul.LawAssistAdventure.register.MenuRegister;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TeleporterMenu extends AbstractContainerMenu {

    public TeleporterMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        this(id);
    }

    public TeleporterMenu(int id) {
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
