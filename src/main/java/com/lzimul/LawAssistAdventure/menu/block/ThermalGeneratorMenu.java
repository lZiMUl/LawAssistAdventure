package com.lzimul.LawAssistAdventure.menu.block;

import com.lzimul.LawAssistAdventure.register.MenuRegister;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ThermalGeneratorMenu extends AbstractContainerMenu {
    public ThermalGeneratorMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        super(MenuRegister.ThermalGeneratorMenu.get(), id);
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
