package com.lzimul.LawAssistAdventure.menus.items;

import com.lzimul.LawAssistAdventure.ItemRegister;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class TeleporterMenu extends AbstractContainerMenu {
    public TeleporterMenu(int p_38852_) {
//        super(ScreenRegister.Teleporter.get(), p_38852_);
        super(MenuType.CRAFTING, p_38852_);
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
