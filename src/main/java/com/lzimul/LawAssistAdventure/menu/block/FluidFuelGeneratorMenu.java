package com.lzimul.LawAssistAdventure.menu.block;

import com.lzimul.LawAssistAdventure.register.MenuRegister;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class FluidFuelGeneratorMenu extends AbstractContainerMenu {
    public FluidFuelGeneratorMenu(int id, Inventory inventory, FriendlyByteBuf friendlyByteBuf) {
        super(MenuRegister.FluidFuelGeneratorMenu.get(), id);
    }

    public FluidFuelGeneratorMenu(int id, Inventory inventory, Player player) {
        super(MenuRegister.FluidFuelGeneratorMenu.get(), id);
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
